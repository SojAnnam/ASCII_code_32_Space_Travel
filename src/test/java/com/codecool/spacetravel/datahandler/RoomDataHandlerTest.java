package com.codecool.spacetravel.datahandler;

import com.codecool.spacetravel.model.Customer;
import com.codecool.spacetravel.model.Room;
import com.codecool.spacetravel.validator.RoomReservationDataValidator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoomDataHandlerTest {
    @Test
    void filterReservedRooms() {
    }

    @Test
    void saveRoomReservation() {
        Map<String, String> roomReservationDatas = new HashMap<>();
        roomReservationDatas.put("customerId", "1");
        roomReservationDatas.put("roomId", "2");
        roomReservationDatas.put("startDateStringFromUser", "2018/01/02");
        roomReservationDatas.put("endDateStringFromUser", "2019/01/02");
        List<String> exampleList = new ArrayList<>();
        Customer costumer = new Customer();
        

        QueryHandler QueryHandlerMock = Mockito.mock(QueryHandler.class);
        RoomReservationDataValidator roomReservationMock = Mockito.mock(RoomReservationDataValidator.class);
        RoomDataHandler roomDataHandler = new RoomDataHandler(QueryHandlerMock,roomReservationMock);
        RoomDataHandler roomDataHandler1 = Mockito.mock(RoomDataHandler.class);
        QueryHandler spy = Mockito.spy(QueryHandlerMock);


        when(QueryHandlerMock.getCustomerById(1L)).thenReturn(costumer);
        when(roomDataHandler1.roomIsFree(new Room(),new Date(2018,01,02),new Date(2019,01,02))).thenReturn(true);
        doNothing().when(QueryHandlerMock).persistData();
        boolean actual = roomDataHandler.saveRoomReservation(roomReservationDatas,exampleList);
        assertTrue(actual);
    }

    @Test
    void renderRoomsHandler() {
    }

    @Test
    void renderRoomReservationSavingHandler() {
    }

}