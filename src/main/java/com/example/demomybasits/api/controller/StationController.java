package com.example.demomybasits.api.controller;


import com.example.demomybasits.api.service.impl.StaffUserServiceImpl;
import com.example.demomybasits.api.service.impl.StationServiceImpl;
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
 * @since 2020-02-23
 */
@RestController

public class StationController {
@Autowired
    private StationServiceImpl stationService;
@Autowired
    private StaffUserServiceImpl service;
    @RequestMapping("/station")
    public List<Map<String,Object>> Get0(String com){
        return stationService.Get0(com);
    }
    @RequestMapping("/station1")
    public int IsExist(String code, String com){
        if(stationService.isExsit(code, com).size()==0){
            return 0;
        }
        else return  1;
    }
    @RequestMapping("/station2")
    public int Insert(String city, String code, String com){
        if(stationService.isExsit(code, com).size()==0)
           {    service.insetrecord("/station2"+city+code+com);
               return  stationService.Insert(city, code, com);
           }
        else return 0;
    }
    @RequestMapping("/station3")
    public List<Map<String,Object>> Get1(String com,String city){
        return stationService.Get1(com, city);
    }
    @RequestMapping("/api/Delstation")
    public int Delstation(String com,String name){
        service.insetrecord("/api/Delstation"+name+com);
        return stationService.Delete(com, name);
    }
}
