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


    public Planet getPlanet(long planetId){
        Planet planet = planetRepository.getPlanet(planetId);
        return planet;
    }

    public  List getAccByPlanetId(long id){
        List<Accomodation> results = accomodatiponRepository.getAccByPlanetId(id);
        return results;
    }

    public List getAmenitiesByAccomodationId(long id){
        List<AmenityType> getAccomodationById = amenityRepository.getAmenitiesByAccomodationId(id);
        return getAccomodationById;
    }

    public List getPlanetsBySolarSystemId(long id) {
        List<Planet> listOfPlanetsBySolarSystem = planetRepository.getPlanetsBySolarSystemId(id);
        return listOfPlanetsBySolarSystem;
    }

    public  List<Planet> getAllPlanet(){
        List<Planet> listOfAllPlanets = planetRepository.getAllPlanet();
        return listOfAllPlanets;
    }

    public  List<Customer> getAllCustomers() {
        List<Customer> results = customerRepository.getAllCustomers();
        return results;
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
        List<Room> results = roomRepository .getRoomsByAcommodationId(accomodationId);
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
}





/*
// WITH ENTITYMANAGER:
@Transactional
@Repository
public class QueryHandler {

    @PersistenceContext
    EntityManager em;

    public List getPlanetsBySolarSystemId(long id) {

        List<Planet> listOfPlanetsBySolarSystem = em.createNamedQuery("Planet.getPlanetsBySolarSystemId", Planet.class)
                .setParameter("solarSystemId", id).getResultList();

        return listOfPlanetsBySolarSystem;
    }

    public  List getAccByPlanetId(long id){

        List<Accomodation> results = em.createNamedQuery("getAccByPlanetId", Accomodation.class)
                .setParameter("planetId", id).getResultList();

        return results;
    }

    public  List<Planet> getAllPlanet(){

        List<Planet> listOfAllPlanets = em.createNamedQuery("Planet.getAllPlanet", Planet.class)
                .getResultList();

        return listOfAllPlanets;

    }

    public Planet getPlanet(long planetId){

        Planet planet = em.createNamedQuery("getPlanet", Planet.class)
                .setParameter("planetId", planetId).getSingleResult();

        return planet;
    }


    public  List<Customer> getAllCustomers() {
        List<Customer> results = em.createNamedQuery("Customer.getAllCustomers", Customer.class)
                .getResultList();
        return results;
    }

    public  List getAllSolarSystem() {
        List<SolarSystem> results =  em.createNamedQuery("SolarSystem.getAllSolarSystem", SolarSystem.class).getResultList();
        return results;
    }

    public Customer getCustomerByEmail(String email) {
        Customer customer = null;
        try{
            customer = em.createNamedQuery("Customer.getCustomerByEmail", Customer.class)
                    .setParameter("email", email).getSingleResult();
        } catch (Exception e){
            System.out.println("No record found: " + e.getMessage());
        }
        return customer;
    }

    public List<Room> getRoomsByAcommodationId(long acommodationId) {
        List<Room> results = em.createNamedQuery("Room.getRoomsByAcommodationId", Room.class)
                .setParameter("acommodationId", acommodationId).getResultList();
        return results;
    }

    public Accomodation getAccomodationById(long acommodationId) {
        Accomodation accomodation = null;
        try {
            accomodation = em.createNamedQuery("Accomodation.getAccomodationById", Accomodation.class)
                    .setParameter("accomodationId", acommodationId).getSingleResult();

        } catch (Exception e){
            System.out.println("No accomodation.");
        }
        return accomodation;
    }

    public Room getRoomById(long roomId) {
        Room room = null;
        try {
            room = em.createNamedQuery("Room.getRoomById", Room.class)
                    .setParameter("roomId", roomId).getSingleResult();
        } catch (Exception e){
            System.out.println("No room.");
        }
        return room;
    }

    public Customer getCustomerById(Long customerId) {
        Customer customer = null;
        try{
            customer = em.createNamedQuery("Customer.getCustomerById", Customer.class)
                    .setParameter("id", customerId).getSingleResult();
        } catch (Exception e){
            System.out.println("No record found: " + e.getMessage());
        }
        return customer;
    }


    public void persistData(Object object) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(object);
        transaction.commit();
    }
}

*/
