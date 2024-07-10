package com.tech_challenge_4.logistics_application.controller;

import com.tech_challenge_4.logistics_application.entity.Truck;
import com.tech_challenge_4.logistics_application.service.TruckService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/truck")
public class TruckController {

    private final TruckService truckService;

    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @PostMapping
    public ResponseEntity<Truck> create(@RequestBody Truck truck) {
        Truck createdTruck = truckService.create(truck);
        return ResponseEntity.ok(createdTruck);
    }

    @GetMapping
    public ResponseEntity<List<Truck>> readAll() {
        List<Truck> trucks = truckService.readAll();
        return ResponseEntity.ok(trucks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Truck> readById(@PathVariable UUID id) {
        Truck truck = truckService.readById(id);
        return ResponseEntity.ok(truck);
    }

    @PutMapping
    public ResponseEntity<Truck> update(@RequestBody Truck truck) {
        Truck updatedTruck = truckService.update(truck);
        return ResponseEntity.ok(updatedTruck);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        truckService.deleteById(id);
        return ResponseEntity.ok("Deleted truck with id " + id);
    }
}
