package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.controller.collectdata.AccDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Scope("session")
public class AccController {

    @Autowired
    private AccDataHandler accDataHandler;

    @RequestMapping(value = "/{planetId}/accomodation", method = RequestMethod.GET)
    public String renderAcc(@RequestParam Map<String,String> allRequestParams,
                            Model model,
                            @PathVariable("planetId") long planetId,
                            HttpServletRequest httpServletRequest) {
        model = accDataHandler.collectAccData(allRequestParams, model, planetId, httpServletRequest);
        return "accomodation";
    }

}
