package com.example.demomybasits.api.service;

import com.example.demomybasits.api.entity.Region;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegionServer {
    List<Region> GetRegionList();
    List<Region>GetCityList(String pinyin);
}
