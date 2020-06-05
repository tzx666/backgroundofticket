package com.example.demomybasits.api.service;

import com.example.demomybasits.api.entity.AirTable;
import com.example.demomybasits.api.entity.schedule;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public interface ScheduleServer {
    List<schedule> GetList();
    List<schedule>GetList1(String Date,String p1,String p2);
    List<AirTable>GetAll();
    List<AirTable>GetSchedule(String Date,String p1,String p2);
    List<Map<String,Object>>GetByQP(String id);
    int insert(String a,String b,String c,String d,String e,String f);
    List<Map<String,Object>>GetInfoByCompany(String com);
    @Transactional
    int InsertAllScheduleInfo(String a,String b,String c,String d,String e,String f
            ,String g,String h,String i);
    @Transactional
    int DeleteScheduleInfo(String pid,String pretakeoff,String preland,String takeoff_place,String landing_place);
    @Transactional
    int UpdateScheduleInfo(String pid,String pretakeoff,String preland,String willtake,String willland,String p1,String p2,String p3);
    List<Map<String,Object>>GetChoosedSchedule(String d1,String d2,String c1,String c2);
    List<Map<String,Object>>GetUndoSchedule();
    int updateScheduleState(String id,String code);
}
