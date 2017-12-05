package com.codecool.spacetravel.repository;

import com.codecool.spacetravel.model.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomReservationRepository extends JpaRepository<RoomReservation, Long> {
}
