package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.Model.Planet;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanetController {

    public static ModelAndView renderPlanets(Request req, Response res) {

        System.out.println("ddddd");
//
//        ProductDao productDataStore = ProductDaoJdbc.getInstance();
//        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoJdbc.getInstance();
//        SupplierDao supplierDataStore = SupplierDaoJdbc.getInstance();

        List<Planet> planetList = QueryController.getPlanetsBySolarSystemId(1);
        //System.out.println("getPlanetsBySolarSystemId - controller");

        System.out.println("SIZE OF LIST: " + planetList.size());


        Map params = new HashMap<>();
        params.put("planets", planetList);
//        params.put("category", productCategoryDataStore.getAll());
//        params.put("products", productDataStore.getAll());
//        params.put("suppliers", supplierDataStore.getAll());
//        params.put("numberOfOrderedItems", order.getNumberOfItems());
        return new ModelAndView(params, "index");
    }
}
