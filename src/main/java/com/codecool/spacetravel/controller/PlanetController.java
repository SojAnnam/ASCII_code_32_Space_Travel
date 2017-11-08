package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.Model.Planet;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanetController {

    public static ModelAndView renderPlanets(Request req, Response res, EntityManager em) {


//
//        ProductDao productDataStore = ProductDaoJdbc.getInstance();
//        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoJdbc.getInstance();
//        SupplierDao supplierDataStore = SupplierDaoJdbc.getInstance();

        List<Planet> planetList = QueryController.getPlanetsBySolarSystemId(1, em);
        //System.out.println("getPlanetsBySolarSystemId - controller");


        Map params = new HashMap<>();
        params.put("planets", planetList);
//        params.put("category", productCategoryDataStore.getAll());
//        params.put("products", productDataStore.getAll());
//        params.put("suppliers", supplierDataStore.getAll());
//        params.put("numberOfOrderedItems", order.getNumberOfItems());
        return new ModelAndView(params, "index");
    }
}
