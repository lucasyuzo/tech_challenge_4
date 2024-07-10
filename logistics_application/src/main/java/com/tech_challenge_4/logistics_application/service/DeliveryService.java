package com.tech_challenge_4.logistics_application.service;

import com.tech_challenge_4.logistics_application.entity.dto.*;
import com.tech_challenge_4.logistics_application.entity.*;
import com.tech_challenge_4.logistics_application.gateway.OrderFeignClientGateway;
import com.tech_challenge_4.logistics_application.gateway.ProductFeignClientGateway;
import com.tech_challenge_4.logistics_application.gateway.UserFeignClientGateway;
import com.tech_challenge_4.logistics_application.repository.DeliveryPersonRepository;
import com.tech_challenge_4.logistics_application.repository.DeliveryRepository;
import com.tech_challenge_4.logistics_application.repository.TruckRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryPersonRepository deliveryPersonRepository;
    private final TruckRepository truckRepository;
    private final OrderFeignClientGateway orderFeignClientGateway;
    private final UserFeignClientGateway userFeignClientGateway;
    private final ProductFeignClientGateway productFeignClientGateway;

    public DeliveryService(
            DeliveryRepository deliveryRepository,
            DeliveryPersonRepository deliveryPersonRepository,
            TruckRepository truckRepository,
            OrderFeignClientGateway orderFeignClientGateway,
            UserFeignClientGateway userFeignClientGateway,
            ProductFeignClientGateway productFeignClientGateway
    ) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryPersonRepository = deliveryPersonRepository;
        this.truckRepository = truckRepository;
        this.orderFeignClientGateway = orderFeignClientGateway;
        this.userFeignClientGateway = userFeignClientGateway;
        this.productFeignClientGateway = productFeignClientGateway;
    }

    public DeliveryReportDTO createBySubSector(char subSector) throws Exception {
        // requisita ordens em preparação
        List<OrderDTO> ordersDTO = this.orderFeignClientGateway.readOrdersInPreparation();

        // requisite usuários das ordens
        List<UserDTO> usersDTO = this.userFeignClientGateway.readUsersByIdList(ordersDTO.stream().map(OrderDTO::userId).toList());

        // filtra usuários pelo sub-setor
        final List<UserDTO> filteredUsersDTO = usersDTO.stream().filter(userDTO -> subSector == userDTO.address().cep().charAt(3)).toList();

        // filtra ordens com os usuários filtrados
        final List<OrderDTO> filteredOrdersDTO = ordersDTO.stream().filter(orderDTO -> filteredUsersDTO.stream().anyMatch(userDTO -> userDTO.id().equals(orderDTO.userId()))).toList();

        // cria lista com os ids dos produtos
        List<UUID> productsId = new ArrayList<>();
        filteredOrdersDTO.forEach(orderDTO -> {
            orderDTO.items().forEach(item -> productsId.add(item.productId()));
        });

        // requisita produtos
        List<ProductDTO> productsDTO = this.productFeignClientGateway.readProductsByIdList(productsId);

        // cria lista com entregadores disponíveis
        List<DeliveryPerson> availableDeliveryPersons = this.deliveryPersonRepository.findAllByStatus(DeliveryPersonStatus.AVAILABLE);

        // pega o primeiro que vier como entregador
        DeliveryPerson deliveryPerson = availableDeliveryPersons.getFirst();

        // cria lista com caminhões disponíveis
        List<Truck> availableTrucks = this.truckRepository.findAllByStatus(TruckStatus.AVAILABLE);

        // seleciona caminhão
        Truck truck = availableTrucks.getFirst();

        // cria entrega
        Delivery delivery = new Delivery(
                UUID.randomUUID(),
                deliveryPerson.getId(),
                truck.getId(),
                ordersDTO.stream().map((OrderDTO::id)).toList(),
                DeliveryStatus.IN_DELIVERY
        );

        // salva entrega
        Delivery savedDelivery = this.deliveryRepository.save(delivery);

        // atualiza status do entregador
        deliveryPerson.setStatus(DeliveryPersonStatus.IN_DELIVERY);
        this.deliveryPersonRepository.save(deliveryPerson);

        // atualiza status do caminhão
        truck.setStatus(TruckStatus.IN_DELIVERY);
        this.truckRepository.save(truck);

        // atualiza status das ordens
        filteredOrdersDTO.forEach(orderDTO -> {
            this.orderFeignClientGateway.updateOrderStatusToDelivered(orderDTO.id());
        });

        // cria ordens para o relatório
        List<OrderReportDTO> orders = this.buildOrdersReportDTO(filteredOrdersDTO, filteredUsersDTO, productsDTO);

        // retorna relatório da entrega
        return new DeliveryReportDTO(
                savedDelivery.getId(),
                deliveryPerson,
                truck,
                orders
        );
    }

    public List<Delivery> readAll() {
        return this.deliveryRepository.findAll();
    }

    public DeliveryReportDTO readById(UUID deliveryId) {

        Delivery delivery = deliveryRepository.findById(deliveryId).orElse(null);

        if (delivery == null) {
            throw new EntityNotFoundException("Delivery with id " + deliveryId + " not found");
        }

        DeliveryPerson deliveryPerson = deliveryPersonRepository.findById(delivery.getDeliveryPersonId()).orElse(null);

        if (deliveryPerson == null) {
            throw new EntityNotFoundException("Delivery Person with id " + delivery.getDeliveryPersonId() + " not found");
        }

        Truck truck = truckRepository.findById(delivery.getTruckId()).orElse(null);

        if (truck == null) {
            throw new EntityNotFoundException("Truck with id " + delivery.getTruckId() + " not found");
        }

        List<OrderDTO> ordersDTO = delivery.getOrdersId().stream().map(this.orderFeignClientGateway::readOrderById).toList();
        List<UserDTO> usersDTO = ordersDTO.stream().map(orderDTO -> this.userFeignClientGateway.readUserById(orderDTO.userId())).toList();

        List<UUID> productsId = new ArrayList<>();
        ordersDTO.forEach(orderDTO -> {
            orderDTO.items().forEach(item -> productsId.add(item.productId()));
        });
        List<ProductDTO> productsDTO = this.productFeignClientGateway.readProductsByIdList(productsId);

        List<OrderReportDTO> ordersReport = this.buildOrdersReportDTO(ordersDTO, usersDTO, productsDTO);

        return new DeliveryReportDTO(
                delivery.getId(),
                deliveryPerson,
                truck,
                ordersReport
        );
    }

    public void updateToDelivered(UUID deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId).orElse(null);
        if (delivery == null) {
            throw new EntityNotFoundException("Delivery with id " + deliveryId + " not found");
        }
        delivery.setStatus(DeliveryStatus.DELIVERED);
        this.deliveryRepository.save(delivery);
    }

    public void updateToReturned(UUID deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId).orElse(null);
        if (delivery == null) {
            throw new EntityNotFoundException("Delivery with id " + deliveryId + " not found");
        }
        delivery.setStatus(DeliveryStatus.RETURNED);
        this.deliveryRepository.save(delivery);
    }

    public void updateToCanceled(UUID deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId).orElse(null);
        if (delivery == null) {
            throw new EntityNotFoundException("Delivery with id " + deliveryId + " not found");
        }
        delivery.setStatus(DeliveryStatus.CANCELED);
        this.deliveryRepository.save(delivery);
    }

    public void deleteById(UUID deliveryId) {
        Delivery delivery = deliveryRepository.findById(deliveryId).orElse(null);
        if (delivery == null) {
            throw new EntityNotFoundException("Delivery with id " + deliveryId + " not found");
        }
        deliveryRepository.deleteById(deliveryId);
    }

    private List<OrderReportDTO> buildOrdersReportDTO(
            List<OrderDTO> ordersDTO,
            List<UserDTO> usersDTO,
            List<ProductDTO> productsDTO
    ) {
        return ordersDTO.stream().map(orderDTO -> {
            UserDTO user = usersDTO.stream().filter(userDTO -> userDTO.id().equals(orderDTO.userId())).findFirst().get();
            List<ItemReportDTO> items =  orderDTO.items().stream().map(itemDTO -> {
                ProductDTO product = productsDTO.stream().filter(productDTO -> productDTO.id().equals(itemDTO.productId())).findFirst().get();
                return new ItemReportDTO(
                        itemDTO.id(),
                        product,
                        itemDTO.quantity()
                );
            }).toList();
            return new OrderReportDTO(
                    orderDTO.id(),
                    user,
                    items
            );
        }).toList();
    }

}
