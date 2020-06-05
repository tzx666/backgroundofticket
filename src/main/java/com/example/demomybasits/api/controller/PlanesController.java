package com.example.demomybasits.api.controller;


import com.example.demomybasits.api.entity.Planes;
import com.example.demomybasits.api.service.impl.PlanesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
 * @since 2020-05-24
 */
@RestController
public class PlanesController {
    private Integer lastcode;
    @Autowired
    private PlanesServiceImpl planesService;
    @RequestMapping("/api/GetAllPlane")
    public List<Planes>GetAllPlane(){
        return planesService.list();
    }
    @RequestMapping("/api/GetPlaneByCompany")
    public List<Planes>GetPlaneByCompany(String com){
        return planesService.GetPlaneByCompany(com);
    }
    @RequestMapping("/api/GetPlaneByTypeAndCompany")
    public List<Map<String, Object>>GetPlaneByTypeAndCompany(String type,String com){
        return planesService.GetPlaneByTypeAndCompany(type, com);
    }
    @RequestMapping("/api/AddPlanes")
    public int AddPlanes(@RequestBody Map<String, String> map){
        Planes planes=new Planes();
        planes.setCompany(map.get("company"));
        planes.setType(map.get("type"));
        lastcode=Integer.valueOf(planesService.GetLatestCode().substring(1))+1;
        planes.setPlaneId("B"+String.valueOf(lastcode));
        return planesService.addPlane(planes);
    }
    @RequestMapping("/api/DeletePlane")
    public int DeletePlane(@RequestBody Map<String, String> map){
        return planesService.deletePlane(map.get("id"));
    }
    @RequestMapping("/api/UpdatePlaneCompany")
    public int UpdatePlane(@RequestBody Map<String, String> map){
        return planesService.UpdatePlane(map.get("id"),map.get("company"));
    }
    @RequestMapping("/api/GetUsefulPlane")
    public List<Map<String, Object>>GetUsefulPlane(String takeoff,String land,String com){
        System.out.print(takeoff+" "+land);
        return planesService.GetUsefulPlane(takeoff,land,com);
    }
}
