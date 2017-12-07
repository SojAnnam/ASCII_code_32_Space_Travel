// INFO ABOUT QUERIES IN SPRING:
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.named-queries

package com.codecool.spacetravel.DAO;

import com.codecool.spacetravel.model.*;
import java.util.List;
import com.codecool.spacetravel.model.Accomodation;
import com.codecool.spacetravel.model.Customer;
import com.codecool.spacetravel.model.Planet;
import com.codecool.spacetravel.model.Room;
import com.codecool.spacetravel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryHandler {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private AccomodatiponRepository accomodatiponRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SolarSystemRepository solarSystemRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PlanetPictureRepository planetPictureRepository;

    @Autowired
    private RoomReservationRepository roomReservationRepository;

    @Autowired
    private AmenityRepository amenityRepository;

    @Autowired
    private AccomodationImageRepository accomodationImageRepository;


    @Autowired
    private RoomTypeRepository roomTypeRepository;


    public Planet getPlanet(long planetId){
        Planet planet = planetRepository.getPlanet(planetId);
        return planet;
    }

    public  List getAccByPlanetId(long id){
        List<Accomodation> results = accomodatiponRepository.getAccByPlanetId(id);
        return results;
    }

//    public List getAmenitiesByAccomodationId(long id){
//        List<AmenityType> getAccomodationById = amenityRepository.getAmenitiesByAccomodationId(id);
//        return getAccomodationById;
//    }

    public List getPlanetsBySolarSystemId(long id) {
        List<Planet> listOfPlanetsBySolarSystem = planetRepository.getPlanetsBySolarSystemId(id);
        return listOfPlanetsBySolarSystem;
    }

    public List<Planet> getAllPlanet(){
        List<Planet> listOfAllPlanets = planetRepository.getAllPlanet();
        return listOfAllPlanets;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> results = customerRepository.getAllCustomers();
        return results;
    }

    public Customer getCostumer(long id){

        Customer customer = customerRepository.findOne(id);

     return customer;
    }

    public  List getAllSolarSystem() {
        List<SolarSystem> results =  solarSystemRepository.getAllSolarSystem();
        return results;
    }

    public Customer getCustomerByEmail(String email) {
        Customer customer = null;
        try{
            customer = customerRepository.getCustomerByEmail(email);
        } catch (Exception e){
            System.out.println("No record found: " + e.getMessage());
        }
        return customer;
    }

    public List<Room> getRoomsByAcommodationId(long accomodationId) {
        List<Room> results = roomRepository.getRoomsByAcommodationId(accomodationId);
        return results;
    }

    public Accomodation getAccomodationById(long accomodationId) {
        Accomodation accomodation = null;
        try {
            accomodation = accomodatiponRepository.getAccomodationById(accomodationId);
        } catch (Exception e){
            System.out.println("No accomodation.");
        }
        return accomodation;
    }

    public Room getRoomById(long roomId) {
        Room room = null;
        try {
            room = roomRepository.getRoomById(roomId);
        } catch (Exception e){
            System.out.println("No room.");
        }
        return room;
    }

    public Customer getCustomerById(Long customerId) {
        Customer customer = null;
        try{
            customer = customerRepository.getCustomerById(customerId);
        } catch (Exception e){
            System.out.println("No record found: " + e.getMessage());
        }
        return customer;
    }

    public List<RoomReservation> getReservationsByCustomerId(Long customerId) {
        List<RoomReservation> results = roomReservationRepository.getRoomReservationsByCustomerId(customerId);
        return results;
    }

    public void saveNewCustomer(Customer customer) {

        customerRepository.save(customer);

    }

    public void savePlanet(Planet newPlanet) {

        planetRepository.save(newPlanet);

    }

    public void savePlanetPicture(PlanetPicture planetPicture) {

        planetPictureRepository.save(planetPicture);

    }

    public void saveRoomReservation(RoomReservation roomReservation) {

        roomReservationRepository.save(roomReservation);

    }
    public List<RoomType> getAllRoomType() {
        List<RoomType> roomTypeList = roomTypeRepository.findAll();
        return roomTypeList;
    }
    public List<AmenityType> getAllAmenity() {
        List<AmenityType> amenityTypes = amenityRepository.findAll();
        return amenityTypes;
    }

    public void saveAccommodation(Accomodation accomodation) {
        accomodatiponRepository.save(accomodation);
    }

    public void saveAccommodationPicture(AccomodationPicture accomodationPicture) {
        accomodationImageRepository.save(accomodationPicture);
    }


    public void saveAmenity(AmenityType amenity) {
        amenityRepository.save(amenity);
    }

    public List<AmenityType> getAmenitisByAccomodationId(long accommodationId) {
        List <AmenityType > amenityList = amenityRepository.getAmenityTypesBy(accommodationId);
       return amenityList;
    }
    public RoomType getRoomTypeById(long id){
        RoomType roomType = roomTypeRepository.findOne(id);

        return roomType;
    }
    public void saveNewRoom(Room room){
        roomRepository.save(room);
    }


}

