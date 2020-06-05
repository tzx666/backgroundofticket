package com.example.demomybasits.api.service.impl;

import com.example.demomybasits.api.entity.Airport;
import com.example.demomybasits.api.mapper.AirportMapper;
import com.example.demomybasits.api.service.IAirportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.json.JSONException;
import org.json.JSONObject;
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
 * @since 2020-02-18
 */
@Service
public class AirportServiceImpl extends ServiceImpl<AirportMapper, Airport> implements IAirportService {
@Autowired
private AirportMapper airportMapper;
    @Override
    public List<Map<String, Object>> Get0(String city) {
        return airportMapper.Get0(city);
    }

    @Override
    public JSONObject getMainInfo(String com) throws JSONException {
        int a,b,c,d;
        a=airportMapper.PlaneNum(com);
        b=airportMapper.GetStation(com);
        c=airportMapper.GetSchedule(com);
        d=airportMapper.GetDelay(com);
        JSONObject object=new JSONObject();
        object.put("plane",a);
        object.put("station",b);
        object.put("schedule",c);
        object.put("delay",d);
        return object;
    }

    @Override
    public List<Map<String, Object>> GetPlaneByCompany(String com) {
        return airportMapper.GetPlaneByCompany(com);
    }

    @Override
    public String GetCode(String name) {
        return airportMapper.GetCode(name);
    }
}
