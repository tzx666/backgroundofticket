package com.example.demomybasits.api.mapper;

import com.example.demomybasits.api.entity.Region;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface regionMapper {
    @Select("SELECT * FROM region WHERE pid='100000'")
    List<Region> GetRegionList();
    @Select("SELECT * FROM region WHERE pid in( SELECT id FROM region WHERE pinyin = #{pinyin})")
    List<Region>GetCityList(String pinyin);
}
