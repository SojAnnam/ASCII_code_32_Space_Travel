package com.codecool.spacetravel.datahandler;


import com.codecool.spacetravel.model.Planet;
import com.codecool.spacetravel.model.SolarSystem;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import  org.mockito.ArgumentMatchers;



import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class PlanetDataHandlerTest {

    @Test
    void getPlanetsBySolarSystemId() throws NoSuchFieldException {
        List<Planet> planetList= new ArrayList<>();
        planetList.add(new Planet());
        EntityManager entityManagerMock = Mockito.mock(EntityManager.class);

        TypedQuery<Planet> mockedQuery2 = Mockito.mock(TypedQuery.class);
        when(entityManagerMock.createNamedQuery("Planet.getPlanetsBySolarSystemId", Planet.class)).thenReturn(mockedQuery2);
        when(mockedQuery2.setParameter("solarSystemId",1L)).thenReturn(mockedQuery2);
        when(mockedQuery2.getResultList()).thenReturn(planetList);

        PlanetDataHandler planetDataHandler = new PlanetDataHandler(entityManagerMock);
        List<Planet> actualList = planetDataHandler.getPlanetsBySolarSystemId(1);
        assertEquals(planetList,actualList);
    }

    
    @Test
    void getAllPlanet() {
    }

    @Test
    void getPlanet() {
    }

    @Test
    void persistData() {
    }

}