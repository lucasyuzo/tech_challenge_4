package com.tech_challenge_4.logistics_application.controller;

import com.tech_challenge_4.logistics_application.entity.DeliveryPerson;
import com.tech_challenge_4.logistics_application.service.DeliveryPersonService;
import com.tech_challenge_4.logistics_application.service.TruckService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/delivery-person")
public class DeliveryPersonController {

    private final DeliveryPersonService deliveryPersonService;

    public DeliveryPersonController(DeliveryPersonService deliveryPersonService, TruckService truckService) {
        this.deliveryPersonService = deliveryPersonService;
    }

    @PostMapping
    public ResponseEntity<DeliveryPerson> create(@RequestBody DeliveryPerson deliveryPerson) {
        DeliveryPerson createdDeliveryPerson = deliveryPersonService.create(deliveryPerson);
        return ResponseEntity.ok(createdDeliveryPerson);
    }

    @GetMapping
    public ResponseEntity<List<DeliveryPerson>> readAll() {
        List<DeliveryPerson> deliveryPeople = deliveryPersonService.readAll();
        return ResponseEntity.ok(deliveryPeople);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryPerson> readById(@PathVariable UUID id) {
        DeliveryPerson deliveryPerson = deliveryPersonService.readById(id);
        return ResponseEntity.ok(deliveryPerson);
    }

    @PutMapping
    public ResponseEntity<DeliveryPerson> update(@RequestBody DeliveryPerson deliveryPerson) {
        DeliveryPerson updatedDeliveryPerson = deliveryPersonService.update(deliveryPerson);
        return ResponseEntity.ok(updatedDeliveryPerson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable UUID id) {
        deliveryPersonService.deleteById(id);
        return ResponseEntity.ok("Deleted delivery person with id " + id);
    }
}
