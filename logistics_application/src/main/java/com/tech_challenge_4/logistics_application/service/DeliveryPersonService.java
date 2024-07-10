package com.tech_challenge_4.logistics_application.service;

import com.tech_challenge_4.logistics_application.entity.DeliveryPerson;
import com.tech_challenge_4.logistics_application.repository.DeliveryPersonRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeliveryPersonService {

    private final DeliveryPersonRepository deliveryPersonRepository;

    public DeliveryPersonService(DeliveryPersonRepository deliveryPersonRepository) {
        this.deliveryPersonRepository = deliveryPersonRepository;
    }

    public DeliveryPerson create(DeliveryPerson deliveryPerson) {
        return deliveryPersonRepository.save(deliveryPerson);
    }

    public List<DeliveryPerson> readAll() {
        return deliveryPersonRepository.findAll();
    }

    public DeliveryPerson readById(UUID id) {
        return deliveryPersonRepository.findById(id).orElseThrow(EntityExistsException::new);
    }

    public DeliveryPerson update(DeliveryPerson deliveryPerson) {
        DeliveryPerson currentDeliveryPerson = deliveryPersonRepository.findById(deliveryPerson.getId()).orElse(null);
        if (currentDeliveryPerson != null) {
            return deliveryPersonRepository.save(deliveryPerson);
        }
        throw new EntityNotFoundException();
    }

    public void deleteById(UUID id) {
        DeliveryPerson currentDeliveryPerson = deliveryPersonRepository.findById(id).orElse(null);
        if (currentDeliveryPerson != null) {
            deliveryPersonRepository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException();
    }
}
