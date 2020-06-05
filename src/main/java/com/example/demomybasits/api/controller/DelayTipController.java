package com.example.demomybasits.api.controller;


import com.example.demomybasits.api.entity.DelayTip;
import com.example.demomybasits.api.service.impl.DelayTipServiceImpl;
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
 * @since 2020-02-23
 */
@RestController

public class DelayTipController {
    @Autowired
    private DelayTipServiceImpl service;
    @RequestMapping("/api/delaytip")
    public List<DelayTip>DelayCode(){
        return service.list();
    }
}
