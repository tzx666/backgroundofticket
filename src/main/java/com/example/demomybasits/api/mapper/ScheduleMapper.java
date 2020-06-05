package com.example.demomybasits.api.mapper;

import com.example.demomybasits.api.entity.AirTable;
import com.example.demomybasits.api.entity.schedule;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface ScheduleMapper {
    @Select("SELECT * FROM `schedule`")
    List<schedule>GetList();
    @Select("SELECT * FROM `schedule` WHERE Convert(schedule.pre_takeoff,Date) = #{Date}  AND takeoff_place=#{p1} AND landing_place=#{p2}")
    List<schedule>GetList1(String Date,String p1,String p2);
    @Select("SELECT * FROM airlines,planes,schedule WHERE airlines.RegID=schedule.ComID AND schedule.Pid=planes.PlaneId")
    @Results({
            @Result(property = "Pid", column = "Pid"),
            @Result(property = "ComID", column = "ComID"),
            @Result(property = "pre_takeoff", column = "pre_takeoff"),
            @Result(property = "pre_landing", column = "pre_landing"),
            @Result(property = "takeoff_place", column = "takeoff_place"),
            @Result(property = "landing_place", column = "landing_place"),
            @Result(property = "FullName", column = "FullName"),
            @Result(property = "type", column = "type")
    })
    List<AirTable>GetAll();
    @Select("SELECT * FROM airlines,planes,schedule WHERE airlines.RegID=schedule.ComID AND schedule.Pid=planes.PlaneId AND Convert(schedule.pre_takeoff,Date) =#{Date}  AND takeoff_place=#{p1} AND landing_place=#{p2}")
    @Results({
            @Result(property = "Pid", column = "Pid"),
            @Result(property = "ComID", column = "ComID"),
            @Result(property = "pre_takeoff", column = "pre_takeoff"),
            @Result(property = "pre_landing", column = "pre_landing"),
            @Result(property = "takeoff_place", column = "takeoff_place"),
            @Result(property = "landing_place", column = "landing_place"),
            @Result(property = "FullName", column = "FullName"),
            @Result(property = "type", column = "type")
    })
    List<AirTable>GetSchedule(String Date,String p1,String p2);
    @Select("SELECT schedule.ID,airlines.RegID,airlines.FullName,planes.PlaneId,planes.type,schedule.pre_takeoff,schedule.pre_landing,A.name name1,B.name name2,schedule.takeoff_place,schedule.landing_place FROM airlines,planes,schedule,airport A,airport B WHERE airlines.RegID=schedule.ComID AND schedule.Pid=planes.PlaneId AND schedule.ComID=#{id} AND  A.ICAO=schedule.takeoff_place AND B.ICAO=schedule.landing_place")
    @Results({
            @Result(property = "ID", column = "ID"),
            @Result(property = "RegID", column = "RegID"),
            @Result(property = "pre_takeoff", column = "pre_takeoff"),
            @Result(property = "pre_landing", column = "pre_landing"),
            @Result(property = "takeoff_place", column = "takeoff_place"),
            @Result(property = "landing_place", column = "landing_place"),
            @Result(property = "FullName", column = "FullName"),
            @Result(property = "type", column = "type"),
            @Result(property = "PlaneId", column = "PlaneId"),
            @Result(property = "name1", column = "name1"),
            @Result(property = "name2", column = "name2")
    })
    List<Map<String,Object>>GetByQP(String id);
    @Insert("INSERT INTO `schedule`(`Pid`, `ComID`, `pre_takeoff`, `pre_landing`, `takeoff_place`, `landing_place`, `isdelay`, `delaycode`) VALUES" +
            " (#{a},#{b},#{c},#{d},#{e},#{f},-1,-1)")
     int insert(String a,String b,String c,String d,String e,String f);
    @Select("SELECT `schedule`.Pid,airlines.FullName,airport.`name` takeoffplace,a.`name` landplace,`schedule`.pre_takeoff,`schedule`.pre_landing,`schedule`.isdelay,`schedule`.delaycode,ticket_num.tickctA_rest,tickctA_price,tickctB_rest,tickctB_price,tickctC_rest,tickctC_price,total,type FROM  ticket_num,`schedule`,airport,airlines,airport a,planes WHERE ticket_id=`schedule`.ID and ComID=#{com} and ComID=airlines.RegID and `schedule`.takeoff_place=airport.ICAO and landing_place=a.ICAO and Pid=PlaneId")
    List<Map<String,Object>>GetInfoByCompany(String com);
    @Select("SELECT ID from `schedule` ORDER BY `schedule`.ID DESC limit 1")
    String GetLatestId();
    @Select("SELECT seat1,seat2,seat3,total FROM planes,planetype WHERE planes.type=planetype.Type and PlaneId=#{pid}")
    Map<String,Object>GetPlaneSeats(String pid);
    @Insert("INSERT INTO `ticket_num`(`ticket_id`, `tickctA_rest`, `total`, `tickctB_rest`, `tickctC_rest`, `tickctA_price`, `tickctB_price`, `tickctC_price`) VALUES (#{a},#{b},#{c},#{d},#{e},#{f},#{g},#{h})")
    int InsetExtraInfo(String a,String b,String c,String d,String e,String f,String g,String h);
    @Select("SELECT `schedule`.ID from `schedule` WHERE `schedule`.Pid=#{pid} and unix_timestamp(`schedule`.pre_takeoff)=unix_timestamp(#{pretakeoff}) and unix_timestamp(`schedule`.pre_landing)=unix_timestamp(#{preland}) and `schedule`.takeoff_place=#{takeoff_place} and `schedule`.landing_place=#{landing_place}")
    String GetSelectedId(String pid,String pretakeoff,String preland,String takeoff_place,String landing_place);
    @Delete("delete from `schedule` WHERE `schedule`.Pid=#{pid} and unix_timestamp(`schedule`.pre_takeoff)=unix_timestamp(#{pretakeoff}) and unix_timestamp(`schedule`.pre_landing)=unix_timestamp(#{preland}) and `schedule`.takeoff_place=#{takeoff_place} and `schedule`.landing_place=#{landing_place}")
    int Deleteschedule(String pid,String pretakeoff,String preland,String takeoff_place,String landing_place);
    @Delete("delete from ticket_num where ticket_id=#{id}")
    int DeleteTickInfo(String id);
    @Select("SELECT ID FROM `schedule` WHERE Pid=#{pid} and `schedule`.pre_takeoff=#{pretakeoff} and `schedule`.pre_landing=#{preland}")
    String GetUpdateID(String pid,String pretakeoff,String preland);
    @Update("UPDATE `schedule` SET `pre_takeoff`=#{willtake},`pre_landing`=#{willland} WHERE ID=#{id}")
    int Updateschedule(String willtake,String willland,String id);
    @Update("UPDATE `ticket_num` SET `tickctA_price`=#{p1},`tickctB_price`=#{p2},`tickctC_price`=#{p3} WHERE `ticket_id`=#{id}")
    int Updateticket(String p1,String p2,String p3,String id);
@Select("SELECT `schedule`.Pid,`schedule`.ID,`schedule`.ComID,`schedule`.pre_takeoff,`schedule`.pre_landing,airport.`name`,a.`name` name1,ticket_num.tickctA_price,ticket_num.tickctB_price,ticket_num.tickctC_price,airlines.FullName " +
        "FROM `schedule`,ticket_num,airport,airlines,airport a " +
        "WHERE" +
        " UNIX_TIMESTAMP(`schedule`.pre_takeoff)>UNIX_TIMESTAMP(#{d1}) and " +
        " UNIX_TIMESTAMP(`schedule`.pre_takeoff)<UNIX_TIMESTAMP(#{d2}) and " +
        "`schedule`.takeoff_place in" +
        " (SELECT airport.ICAO FROM airport WHERE airport.`city`=#{c1}) " +
        "and `schedule`.landing_place in" +
        " (SELECT airport.ICAO FROM airport WHERE airport.`city`=#{c2}) and `schedule`.ID=ticket_id and `schedule`.takeoff_place=airport.ICAO and a.ICAO=`schedule`.landing_place and `schedule`.delaycode=-1 and `schedule`.ComID=airlines.RegID")
    List<Map<String,Object>>GetChoosedSchedule(String d1,String d2,String c1,String c2);
@Select("SELECT `schedule`.ID,`schedule`.Pid,`schedule`.ComID,`schedule`.pre_takeoff,`schedule`.pre_landing,airport.`name`,a.`name` name1,planes.type,\n" +
        "(1-tickctA_rest/seat1) rest1,\n" +
        "(1-tickctB_rest/seat2) rest2,\n" +
        "(1-tickctC_rest/seat3) rest3,\n" +
        "`schedule`.isdelay,\n" +
        "`schedule`.delaycode\n" +
        "FROM \n" +
        "`schedule`,ticket_num,planes,planetype,airport,airport a \n" +
        "WHERE\n" +
        "`schedule`.ID=ticket_num.ticket_id \n" +
        "and\n" +
        "`schedule`.Pid=planes.PlaneId \n" +
        "and \n" +
        "planes.type=planetype.Type \n" +
        "and\n" +
        "airport.ICAO=`schedule`.takeoff_place \n" +
        "and \n" +
        "a.ICAO=`schedule`.landing_place \n" +
        "and \n" +
        "`schedule`.isdelay=-1")
    List<Map<String,Object>>GetUndoSchedule();
@Update("UPDATE `schedule` SET `schedule`.isdelay=1, `schedule`.delaycode=#{code} WHERE `schedule`.ID=#{id}")
    int updateScheduleState(String id,String code);
}
