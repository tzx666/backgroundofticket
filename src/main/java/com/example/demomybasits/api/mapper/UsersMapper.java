package com.example.demomybasits.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demomybasits.api.entity.users;
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
 * @since 2020-05-24
 */
@Component
public interface UsersMapper extends BaseMapper<users> {
    @Select("select * from users")
    List<users> getuserlist();
    @Update("UPDATE `users` SET `psw`=#{paw} WHERE users.name=#{name}")
    int update(String name,String paw);
    @Select("Select name,account_balance,level,points from users where name=#{name} limit 1")
    users isExist(String name);
    @Select("Select * from users where name=#{name} and psw=#{psw} limit 1")
    users Login(String name,String psw);
    @Insert("insert into users(`name`, `psw`, `account_balance`, `level`, `points`) values(#{name},#{psw},0,1,0)")
    int Register(String name,String psw);
    @Select("SELECT account_balance,`level`,points from users WHERE users.`name`=#{name} limit 1")
    Map<String,Object> getuserinfo(String name);
    @Update("UPDATE users set users.account_balance=users.account_balance+500 where users.name=#{name}")
    int updateBalance1(String name);
    @Update("UPDATE weblearn.users set weblearn.users.account_balance=weblearn.users.account_balance-500 WHERE weblearn.users.name='god';")
    int updateBalance();
    @Update("UPDATE users set users.account_balance=users.account_balance-#{price} WHERE (users.account_balance-#{price})>0 and users.`name`=#{user}")
    int updateBalance2(Double price,String user);
    @Update("UPDATE users set users.points=(SELECT  sum(tickets.cost)from tickets WHERE tickets.`User`=#{user}) where users.`name`=#{user}")
    int updatepoint(String user);
    @Update("update users set users.points=users.points-#{point} WHERE users.`name`=#{user};")
    int updatepoint1(String user,int point);
}
