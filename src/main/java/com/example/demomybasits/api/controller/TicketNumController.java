package com.example.demomybasits.api.controller;


import com.example.demomybasits.api.service.impl.TicketNumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tzx
 * @since 2020-05-24
 */
@RestController

public class TicketNumController {
    @Autowired
    private TicketNumServiceImpl service;
    @RequestMapping("/api/ticketnum")
    public Double res(){
        return service.res();
    }
}
