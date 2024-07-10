package com.tech_challenge_4.logistics_application.service;

import com.tech_challenge_4.logistics_application.entity.Truck;
import com.tech_challenge_4.logistics_application.repository.TruckRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TruckService {

    private final TruckRepository truckRepository;

    public TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

   public Truck create(Truck truck) {
        return truckRepository.save(truck);
   }

   public List<Truck> readAll() {
        return truckRepository.findAll();
   }

   public Truck readById(UUID id) {
        return truckRepository.findById(id).orElseThrow(EntityNotFoundException::new);
   }

   public Truck update(Truck truck) {
        Truck currentTruck = truckRepository.findById(truck.getId()).orElse(null);
        if (currentTruck != null) {
            return truckRepository.save(truck);
        }
        throw new EntityNotFoundException();
   }

   public void deleteById(UUID id) {
       Truck currentTruck = truckRepository.findById(id).orElse(null);
        if (currentTruck != null) {
            truckRepository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException();
   }
}
