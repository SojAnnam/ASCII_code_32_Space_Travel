package com.codecool.spacetravel.repository;

import com.codecool.spacetravel.model.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomReservationRepository extends JpaRepository<RoomReservation, Long> {

    List<RoomReservation> getRoomReservationsByCustomerId(@Param("customerId") Long customerId);

}
