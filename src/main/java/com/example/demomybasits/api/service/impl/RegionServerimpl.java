package com.example.demomybasits.api.service.impl;

import com.example.demomybasits.api.entity.Region;
import com.example.demomybasits.api.service.RegionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionServerimpl implements RegionServer {
    @Autowired
    private com.example.demomybasits.api.mapper.regionMapper regionMapper;
    @Override
    public List<Region> GetRegionList(){
        try{
            List<Region>regions=regionMapper.GetRegionList();
            return  regions;
        }catch (Exception e){
            throw e;
        }
    }
    @Override
    public List<Region>GetCityList(String pinyin){
        try{
            List<Region>regions=regionMapper.GetCityList(pinyin);
            return  regions;
        }catch (Exception e){
            throw e;
        }
    }
}
