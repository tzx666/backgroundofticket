package com.example.demomybasits.api.mapper;

import com.example.demomybasits.api.entity.Airport;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tzx
 * @since 2020-02-18
 */
@Component
public interface AirportMapper extends BaseMapper<Airport> {
@Select("SELECT * FROM `airport` WHERE city=#{city}")
List<Map<String,Object>> Get0(String city);
@Select("select count(*) from planes where Company=#{com}")
    int PlaneNum(String com);
    @Select("select count(*) from `station` where company=#{com} ")
    int GetStation(String com);
    @Select("select count(*) from `schedule` where ComID=#{com}")
    int GetSchedule(String com);
    @Select("select count(*) from `schedule` where ComID=#{com} and isdelay=1")
    int GetDelay(String com);
    @Select("SELECT PlaneId,planes.type,seat1,seat2,seat3,total,FullName,state from planes,planetype,airlines WHERE planes.type=planetype.Type and planes.Company=#{com} AND planes.Company=airlines.RegID")
    List<Map<String,Object>> GetPlaneByCompany(String com);
    @Select("select ICAO from airport where name=#{name}")
    String GetCode(String name);
}

