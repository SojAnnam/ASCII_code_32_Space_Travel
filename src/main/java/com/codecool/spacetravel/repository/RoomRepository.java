package com.codecool.spacetravel.repository;

import com.codecool.spacetravel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    // Named query not works with JOIN:
    // List<Room> getRoomsByAcommodationId(@Param("accomodationId") Long accomodationId);

    @Query(value = "SELECT * FROM Room r " +
            "JOIN RoomType rt ON rt.id = r.room_type_id " +
            "WHERE r.accomodation_id = ?1 " +
            "ORDER BY rt.bednumber ASC , rt.name ASC;",
            nativeQuery = true)
    List<Room> getRoomsByAcommodationId(long accomodationId);

    Room getRoomById(@Param("roomId") Long id);

}
