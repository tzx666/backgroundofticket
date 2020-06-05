package com.example.demomybasits.api.service.impl;

import com.example.demomybasits.api.entity.AirTable;
import com.example.demomybasits.api.mapper.ScheduleMapper;
import com.example.demomybasits.api.entity.schedule;
import com.example.demomybasits.api.service.ScheduleServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public class ScheduleServerimpl implements ScheduleServer {
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private StaffUserServiceImpl staffUserService;
    @Override
    public List<schedule> GetList() {
        try{
            List<schedule>schedule=scheduleMapper.GetList();
            return  schedule;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<schedule> GetList1(String Date, String p1, String p2) {
        try{
            List<schedule>schedule=scheduleMapper.GetList1(Date, p1, p2);
            return  schedule;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public  List<AirTable>GetAll(){
        try{
            return   scheduleMapper.GetAll();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<AirTable> GetSchedule(String Date, String p1, String p2) {
        try{
            return   scheduleMapper.GetSchedule( Date, p1, p2);
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public List<Map<String,Object>> GetByQP(String id) {
        try{
            return   scheduleMapper.GetByQP(id);
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public int insert(String a,String b,String c,String d,String e,String f) {
        return scheduleMapper.insert(a, b, c, d, e, f);
    }
/*
* 根据航司返回所有查询信息
* */
    @Override
    public List<Map<String, Object>> GetInfoByCompany(String com) {
        return scheduleMapper.GetInfoByCompany(com);
    }

    @Override
    @Transactional
    public int InsertAllScheduleInfo(String a, String b, String c, String d, String e,
                                     String f, String g, String h, String i) {
        int insertSecheul=scheduleMapper.insert(a,b,c,d,e,f);
        if(insertSecheul==1){
            String id=String.valueOf(scheduleMapper.GetLatestId());
            Map<String,Object>pinfo=scheduleMapper.GetPlaneSeats(a);
            return scheduleMapper.InsetExtraInfo(id,pinfo.get("seat1").toString(),
                    pinfo.get("total").toString(),pinfo.get("seat2").toString(),
                    pinfo.get("seat3").toString(),g,h,i);
        }else{
            return 0;
        }
    }

    @Override
    @Transactional
    public int DeleteScheduleInfo(String pid, String pretakeoff, String preland, String takeoff_place, String landing_place) {
        String id=scheduleMapper.GetSelectedId(pid, pretakeoff, preland, takeoff_place, landing_place);
        int res=scheduleMapper.DeleteTickInfo(id);
        if(res==1){
            return scheduleMapper.Deleteschedule(pid, pretakeoff, preland, takeoff_place, landing_place);
        }else{
            return 0;
        }
    }

    @Override
    @Transactional
    public int UpdateScheduleInfo(String pid, String pretakeoff, String preland, String willtake, String willland, String p1, String p2, String p3) {
        System.out.print(pid+" "+pretakeoff+" "+preland);
        String id=scheduleMapper.GetUpdateID(pid, pretakeoff, preland);
        System.out.print(id);
        int res=scheduleMapper.Updateschedule(willtake,willland,id);
        System.out.print(res);
        if(res==1){
            return scheduleMapper.Updateticket(p1,p2,p3,id);
        }else{
            return 0;
        }

    }

    @Override
    public List<Map<String, Object>> GetChoosedSchedule(String d1, String d2, String c1, String c2) {
        return scheduleMapper.GetChoosedSchedule(d1, d2, c1, c2);
    }

    @Override
    public List<Map<String, Object>> GetUndoSchedule() {
        return scheduleMapper.GetUndoSchedule();
    }

    @Override
    public int updateScheduleState(String id, String code) {
        String sql="UPDATE `schedule` SET `schedule`.isdelay=1, `schedule`.delaycode="+code+" WHERE `schedule`.ID="+id;
        staffUserService.insetrecord(sql);
        return scheduleMapper.updateScheduleState(id,code);
    }
}
