package com.example.demomybasits.api.controller;


import com.example.demomybasits.api.service.impl.AirportServiceImpl;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tzx
 * @since 2020-02-18
 */
@RestController

public class AirportController {
    @Autowired
    private AirportServiceImpl airportService;
    @RequestMapping("/airport")
    public List<Map<String,Object>> Get0(String city){
        System.out.println(city);
        return airportService.Get0(city);
    }
    @RequestMapping("/api/maininfo")
    public String GetMainInfo(String com) throws JSONException {
        return airportService.getMainInfo(com).toString();
    }
    @RequestMapping("/api/GetCompanyPlane")
    public List<Map<String, Object>>GetPlaneByCompany(String com){
        return airportService.GetPlaneByCompany(com);
    }
    @RequestMapping("/api/GetAirportCode")
    public String GetAirportCode(String name){
        return airportService.GetCode(name);
    }
}
