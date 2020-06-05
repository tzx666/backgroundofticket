package com.example.demomybasits.api.mapper;

import com.example.demomybasits.api.entity.Planes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
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
public interface PlanesMapper extends BaseMapper<Planes> {
@Select("select * from planes where Company=#{com}")
    List<Planes>GetPlaneByCompany(String com);
@Select("select * from planes,planetype WHERE planes.type=#{type} and planes.type=planetype.Type and Company=#{com}")
    List<Map<String, Object>>GetPlaneByTypeAndCompany(String type, String com);
@Select("select PlaneId from planes order by PlaneId DESC limit 1")
    String GetLatestCode();
@Delete("delete from planes where PlaneId=#{id}")
    int deletePlane(String id);
@Update("UPDATE planes set planes.Company=#{com} WHERE planes.PlaneId=#{id}")
    int UpdatePlane(String id,String com);
@Select("SELECT * FROM planes WHERE planes.Company=#{com} and ( planes.PlaneId not in (SELECT `schedule`.Pid FROM `schedule`) or planes.PlaneId in " +
        "(SELECT `schedule`.Pid FROM `schedule` " +
        "WHERE " +
        " unix_timestamp( date_add(#{land}, interval 2 hour))<unix_timestamp(`schedule`.pre_takeoff)" +
        " or unix_timestamp( date_add(`schedule`.pre_landing, interval 2 hour))<unix_timestamp(#{takeoff})))")
    List<Map<String, Object>>GetUsefulPlane(String takeoff,String land,String com);
}
