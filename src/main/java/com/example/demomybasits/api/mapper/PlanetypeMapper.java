package com.example.demomybasits.api.mapper;

import com.example.demomybasits.api.entity.Planetype;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tzx
 * @since 2020-05-24
 */
@Component
public interface PlanetypeMapper extends BaseMapper<Planetype> {
@Select("SELECT seat1,seat2,seat3,total from planes,planetype WHERE PlaneId=#{id} and planes.type=planetype.Type")
Map<String, Object> GetSeats(String id);
}
