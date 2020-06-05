package com.example.demomybasits.api.service;

import com.example.demomybasits.api.entity.Station;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tzx
 * @since 2020-02-23
 */
public interface IStationService extends IService<Station> {
    List<Map<String,Object>> Get0(String com);
    List<Station> isExsit(String code,String com);
    int Insert(String city,String code,String com);
    List<Map<String,Object>> Get1(String com,String city);
    int Delete(String com,String name);
}
