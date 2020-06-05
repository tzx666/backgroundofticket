package com.example.demomybasits.api.controller;


import com.example.demomybasits.api.entity.Airlines;
import com.example.demomybasits.api.service.impl.AirlinesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tzx
 * @since 2020-02-15
 */
@RestController

public class AirlinesController {
    @Autowired
    private AirlinesServiceImpl airlinesService1;
    @RequestMapping("sqltest7")
    public List<Airlines> GetAll(){
        return  airlinesService1.GetAll();
    }
    @RequestMapping("/api/getAllAirlines")
    public List<Airlines> GetAllAirlines(){
        return  airlinesService1.getAllAirlines();
    }
}
