package com.tech_challenge_4.logistics_application.controller;

import com.tech_challenge_4.logistics_application.entity.Delivery;
import com.tech_challenge_4.logistics_application.entity.dto.DeliveryReportDTO;
import com.tech_challenge_4.logistics_application.service.DeliveryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/{subSector}")
    public ResponseEntity<?> createBySubSector(@PathVariable char subSector) {
        try {
            DeliveryReportDTO report = deliveryService.createBySubSector(subSector);
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> readAll() {
        List<Delivery> deliveries = this.deliveryService.readAll();
        return ResponseEntity.ok(deliveries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable UUID id) {
        try {
            DeliveryReportDTO report = this.deliveryService.readById(id);
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/updated-to-delivered/{deliveryId}")
    public ResponseEntity<?> updateToDelivered(@PathVariable UUID deliveryId) {
        try {
            this.deliveryService.updateToDelivered(deliveryId);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/updated-to-returned/{deliveryId}")
    public ResponseEntity<?> updateToReturned(@PathVariable UUID deliveryId) {
        try {
            this.deliveryService.updateToReturned(deliveryId);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/updated-to-canceled/{deliveryId}")
    public ResponseEntity<?> updateToCanceled(@PathVariable UUID deliveryId) {
        try {
            this.deliveryService.updateToCanceled(deliveryId);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{deliveryId}")
    public ResponseEntity<?> deleteById(@PathVariable UUID deliveryId) {
        try {
            this.deliveryService.deleteById(deliveryId);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
