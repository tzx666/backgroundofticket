package com.example.demomybasits.api.mapper;

import com.example.demomybasits.api.entity.Station;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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
 * @since 2020-02-23
 */
@Component
public interface StationMapper extends BaseMapper<Station> {
@Select("select station.city,airport.`name`,airport.engname FROM station, airport WHERE station.city = airport.city AND station.company = #{com} AND station.airport=airport.ICAO")
    List<Map<String,Object>> Get0(String com);
@Select("select  * FROM station, airport WHERE station.city = airport.city AND station.company = #{com} and airport.city=#{city} AND station.airport=airport.ICAO")
    List<Map<String,Object>> Get1(String com,String city);
@Select("SELECT * FROM `station` WHERE airport=#{code} AND company=#{com}")
    List<Station> isExsit(String code,String com);
@Insert("INSERT INTO `station`( `city`, `airport`, `company`) VALUES (#{city},#{code},#{com})")
    int Insert(String city,String code,String com);
@Delete("delete  from station where company=#{com} and airport=#{id}")
    int Delete(String com,String id);
@Select("select ICAO from airport where name=#{name}")
    String GetICAO(String name);
}
