package com.tech_challenge_4.logistics_application.repository;

import com.tech_challenge_4.logistics_application.entity.DeliveryPerson;
import com.tech_challenge_4.logistics_application.entity.DeliveryPersonStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeliveryPersonRepository extends JpaRepository<DeliveryPerson, UUID> {

    List<DeliveryPerson> findAllByStatus(DeliveryPersonStatus deliveryPersonStatus);

}
