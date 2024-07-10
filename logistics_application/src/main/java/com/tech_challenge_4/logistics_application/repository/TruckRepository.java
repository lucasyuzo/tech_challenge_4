package com.tech_challenge_4.logistics_application.repository;

import com.tech_challenge_4.logistics_application.entity.Truck;
import com.tech_challenge_4.logistics_application.entity.TruckStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TruckRepository extends JpaRepository<Truck, UUID> {

    List<Truck> findAllByStatus(TruckStatus truckStatus);

}
