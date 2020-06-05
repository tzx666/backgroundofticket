package com.example.demomybasits.api.mapper;

import com.example.demomybasits.api.entity.Tickets;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface TicketsMapper extends BaseMapper<Tickets> {
    @Select("SELECT ticket_num.tickctA_rest,ticket_num.tickctB_rest,ticket_num.tickctC_rest from ticket_num,`schedule` WHERE ticket_num.ticket_id=#{id} and `schedule`.ID=ticket_num.ticket_id and `schedule`.isdelay=-1")
    Map<String,Object> isticketenough(String id);
    @Insert("INSERT into tickets(tickets.`User`,tickets.cost,tickets.tranhash,tickets.scheduleID)VALUES(#{user},#{cost},#{hash},#{id})")
    int insert(String user,String cost,String hash,String id);
    @Select("SELECT tickets.cost,tickets.tranhash,tickets.scheduleID,`schedule`.ComID,`schedule`.pre_takeoff,`schedule`.pre_landing,airport.`name`,a.`name` name1,airlines.FullName from weblearn.tickets,`schedule`,airport,airlines,airport a WHERE tickets.`User`=#{name} and tickets.scheduleID=`schedule`.ID and `schedule`.ComID=airlines.RegID and airport.ICAO=`schedule`.takeoff_place and a.ICAO=`schedule`.landing_place")
    List<Map<String,Object>>GetUserTran(String name);
    @Select("SELECT  cost,tranhash from tickets WHERE tickets.`User`=#{name}")
    List<Map<String,Object>>getuserticket(String name);
}
