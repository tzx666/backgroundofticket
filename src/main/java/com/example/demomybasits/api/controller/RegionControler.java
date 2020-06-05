package com.example.demomybasits.api.controller;

import com.example.demomybasits.api.entity.Region;
import com.example.demomybasits.api.service.impl.RegionServerimpl;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RegionControler {
    @Autowired
    private RegionServerimpl regionServerimpl;
    @RequestMapping("/sqltest1")
    public List<Region>GetRegionList(){
        return regionServerimpl.GetRegionList();
    }
    @ResponseBody
    @PostMapping("/sqltest2")
    public List<Region>GetCityList(@RequestBody Map<String, String> map) throws JSONException {
        String pinyin=map.get("pinyin").toString();
        return  regionServerimpl.GetCityList(pinyin);
    }
    @RequestMapping("/service/getprovice")
    public List<Region>GetRegionList1(){
        return regionServerimpl.GetRegionList();
    }
    @ResponseBody
    @PostMapping("/service/getcity")
    public List<Region>GetCityList1(@RequestBody Map<String, String> map) throws JSONException {
        String pinyin=map.get("pinyin").toString();
        return  regionServerimpl.GetCityList(pinyin);
    }
}
