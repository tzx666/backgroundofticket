package com.example.demomybasits.api.controller;


import com.example.demomybasits.api.entity.Planetype;
import com.example.demomybasits.api.service.impl.PlanetypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tzx
 * @since 2020-05-24
 */
@RestController

public class PlanetypeController {
    @Autowired
    private PlanetypeServiceImpl service;
    @RequestMapping("/api/planetype")
    public Map<String, Object> GetType(String id){
        return service.GetSeats(id);
    }
}
