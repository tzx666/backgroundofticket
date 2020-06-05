package com.example.demomybasits.api.service.impl;

import com.example.demomybasits.api.entity.Station;
import com.example.demomybasits.api.mapper.StationMapper;
import com.example.demomybasits.api.service.IStationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tzx
 * @since 2020-02-23
 */
@Service
public class StationServiceImpl extends ServiceImpl<StationMapper, Station> implements IStationService {
@Autowired
private StationMapper stationMapper;
    @Override
    public List<Map<String, Object>> Get0(String com) {
        return stationMapper.Get0(com);
    }

    @Override
    public List<Station> isExsit(String code, String com) {
        return stationMapper.isExsit(code, com);
    }

    @Override
    public int Insert(String city, String code, String com) {
        return stationMapper.Insert(city, code, com);
    }

    @Override
    public List<Map<String, Object>> Get1(String com, String city) {
        return stationMapper.Get1(com, city);
    }

    @Override
    public int Delete(String com, String name) {
        String id=stationMapper.GetICAO(name);
        System.out.println(id);
        return stationMapper.Delete(com,id);
    }
}
