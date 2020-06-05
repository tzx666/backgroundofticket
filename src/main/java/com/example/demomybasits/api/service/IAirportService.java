package com.example.demomybasits.api.service;

import com.example.demomybasits.api.entity.Airport;
import com.baomidou.mybatisplus.extension.service.IService;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tzx
 * @since 2020-02-18
 */
public interface IAirportService extends IService<Airport> {
    List<Map<String,Object>> Get0(String city);
    JSONObject getMainInfo(String com) throws JSONException;
    List<Map<String,Object>> GetPlaneByCompany(String com);
    String GetCode(String name);
}
