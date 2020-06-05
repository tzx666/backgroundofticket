package com.example.demomybasits.api.controller;

import com.example.demomybasits.api.entity.AirTable;
import com.example.demomybasits.api.entity.schedule;
import com.example.demomybasits.api.service.impl.ScheduleServerimpl;
import com.example.demomybasits.api.service.impl.StaffUserServiceImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ScheduleControl {
    @Autowired
    private ScheduleServerimpl scheduleServerimpl;
    @Autowired
    private StaffUserServiceImpl service;
    /*@RequestMapping("/sqltest3")
    public List<schedule> GetList(){
        return  scheduleServerimpl.GetList();
    }*/
    @RequestMapping("/sqltest4")
    public List<schedule> GetList1(@RequestBody Map<String, String> map){
        String Date=map.get("Date").toString();
        String p1=map.get("p1").toString();
        String p2=map.get("p2").toString();
        System.out.println(Date);
        System.out.println(p1);
        System.out.println(p2);
        return scheduleServerimpl.GetList1(Date, p1, p2);
    }
    @RequestMapping("/sqltest9")
    public  List<AirTable>GetAll(){
        return scheduleServerimpl.GetAll();
    }
    @RequestMapping("/sqltest10")
    public List<AirTable>GetSchedule(@RequestBody Map<String, String> map){
        String Date=map.get("Date").toString();
        String p1=map.get("p1").toString();
        String p2=map.get("p2").toString();
        System.out.println(Date);
        System.out.println(p1);
        System.out.println(p2);
        return  scheduleServerimpl.GetSchedule(Date,p1,p2);
    }
    @RequestMapping("/api/getbycompany")
    public List<Map<String,Object>> GetByQP(String id){
        return scheduleServerimpl.GetInfoByCompany(id);
    }
    @RequestMapping("qinsert")//航班时刻表插入处理
    public int insert(@RequestBody Map<String, String> map){
       //重写
        String a=map.get("Pid");
        String b=map.get("ComID");
        String c=map.get("pre_takeoff");
        String d=map.get("pre_landing");
        String e=map.get("takeoff_place");
        String f=map.get("landing_place");
        service.insetrecord("qinsert"+a+b+c+d+e+f);
        return scheduleServerimpl.insert(a,b,c,d,e,f);
    }
    @RequestMapping("/api/AddSchedule")
    public String AddSchedule(@RequestBody Map<String, String> map) throws JSONException {
        String pid,comid,pretakeoff,prelanding,takeoffplace,landplace,pricea,priceb,pricec;
        pid=map.get("pid");
        comid=map.get("comid");
        pretakeoff=map.get("pretakeoff");
        prelanding=map.get("prelanding");
        takeoffplace=map.get("takeoffplace");
        landplace=map.get("landplace");
        pricea=map.get("pricea");
        priceb=map.get("priceb");
        pricec=map.get("pricec");
        service.insetrecord("/api/AddSchedule"+pid+comid+pretakeoff+prelanding
                +takeoffplace+landplace+pricea+priceb+pricec);
        int res= scheduleServerimpl.InsertAllScheduleInfo(pid,comid,pretakeoff,prelanding
        ,takeoffplace,landplace,pricea,priceb,pricec);
        JSONObject object=new JSONObject();
        if(res==1){
            object.put("status",1);
            object.put("res","插入成功");
        }else{
            object.put("status",0);
            object.put("res","插入失败");
        }
        return object.toString();
    }
    @RequestMapping("/api/deleteSchedule")
    public String deleteSchedule(@RequestBody Map<String, String> map) throws JSONException {
        String pid,pretakeoff,prelanding,takeoffplace,landplace;
        pid=map.get("pid");
        pretakeoff=map.get("pretakeoff");
        prelanding=map.get("prelanding");
        takeoffplace=map.get("takeoffplace");
        landplace=map.get("landplace");
        int res= scheduleServerimpl.DeleteScheduleInfo(pid,pretakeoff,prelanding
                ,takeoffplace,landplace);
        service.insetrecord("/api/deleteSchedule"+pid+pretakeoff+prelanding
                +takeoffplace+landplace);
        JSONObject object=new JSONObject();
        if(res==1){
            object.put("status",1);
            object.put("res","删除成功");
        }else{
            object.put("status",0);
            object.put("res","删除失败");
        }
        return object.toString();
    }
    @RequestMapping("/api/updateSchedule")
    public String updateSchedule(@RequestBody Map<String, String> map) throws JSONException{
        String pid,pretakeoff,prelanding,time1,time2,priceA,priceB,priceC;
        pid=map.get("pid");
        pretakeoff=map.get("pretakeoff");
        prelanding=map.get("prelanding");
        time1=map.get("time1");
        time2=map.get("time2");
        priceA=map.get("priceA");
        priceB=map.get("priceB");
        priceC=map.get("priceC");
        service.insetrecord("/api/updateSchedule"+pid+pretakeoff+prelanding+time1+time2+priceA+priceB+priceC);
        int res=scheduleServerimpl.UpdateScheduleInfo(pid,pretakeoff,prelanding,time1,time2,priceA,priceB,priceC);
        JSONObject object=new JSONObject();
        if(res==1){
            object.put("status",1);
            object.put("res","修改成功");
        }else{
            object.put("status",0);
            object.put("res","修改失败");
        }
        return object.toString();
    }
    @RequestMapping("/service/GetChoosedSchedule")
    public List<Map<String,Object>>GetChoosedSchedule(@RequestBody Map<String, String> map){
        String day=map.get("date");
        String c1=map.get("takeoff_place");
        String c2=map.get("land_place");
        String d1=day+" 00:00:00";
        String d2=day+" 23:59:59";
        System.out.println(d1+" "+d2);
        return scheduleServerimpl.GetChoosedSchedule(d1,d2,c1,c2);
    }
    @RequestMapping("/service/GetUndoSchedule")
    public List<Map<String,Object>>GetUndoSchedule(){
        return scheduleServerimpl.GetUndoSchedule();
    }
    @RequestMapping("/api/updateScheduleState")
    public int updateScheduleState(@RequestBody Map<String, String> map){
        String id=map.get("id");
        String code=map.get("code");
        service.insetrecord("/api/updateScheduleState"+id+code);
        return scheduleServerimpl.updateScheduleState(id,code);
    }
}
