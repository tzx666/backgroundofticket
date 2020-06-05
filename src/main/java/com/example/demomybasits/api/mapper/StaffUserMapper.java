package com.example.demomybasits.api.mapper;

import com.example.demomybasits.api.entity.Airlines;
import com.example.demomybasits.api.entity.StaffUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tzx
 * @since 2020-02-16
 */
@Component
public interface StaffUserMapper extends BaseMapper<StaffUser> {
    @Update("UPDATE `staff_user` SET `password`=#{paw} WHERE staff_user.name=#{name}")
    int update(String name,String paw);
    @Select("Select * from staff_user where name=#{name} limit 1")
    StaffUser isExist(String name);
    @Select("Select Staff,Company from staff_user where name=#{name} and password=#{psw} limit 1")
    StaffUser Login(String name,String psw);
@Select("select * from staff_user where name=#{name} and password=#{psw} and type=#{type}")
StaffUser Login(String name,String psw,String type);
@Select("select * from airlines where RegID=#{id} and hash=#{hash}")
    Airlines isLegel(String id,String hash);
@Select("SELECT staff_user.`name`,Staff,airlines.FullName,staff_user.type FROM staff_user,airlines WHERE staff_user.Company=airlines.RegID and staff_user.Company=#{com}")
    List<Map<String,Object>>GetStaffInfo(String com);
@Update("UPDATE staff_user set type=type*-1 where name=#{name}")
    int UpdateStaff(String name);
@Delete("DELETE FROM `staff_user` WHERE name=#{name}")
    int DeleteStaff(String name);
@Select("select permission from staff_user WHERE staff_user.`name`=#{name}")
    int getpermission(String name);
@Insert("INSERT into sqlrecord(sqlrecord.`sql`,sqlrecord.time)VALUES(#{sql},CURRENT_TIMESTAMP())")
    int insetrecord(String sql);
}
