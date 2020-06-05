package com.example.demomybasits.api.mapper;

import com.example.demomybasits.api.entity.Airlines;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tzx
 * @since 2020-02-15
 */
@Mapper
@Component
public interface AirlinesMapper extends BaseMapper<Airlines> {
    List<Airlines> GetAll();
    @Select("SELECT * FROM `airlines` WHERE RegID = #{id}")
    Airlines find(String id);
    @Select("select * from airlines WHERE RegID=#{fullname}")
    Airlines isPermission(String fullname);
    @Select("select fullName,RegID from airlines")
    List<Airlines>getAllAirlines();
}
