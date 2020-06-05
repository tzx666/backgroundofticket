package com.example.demomybasits.api.controller;


import com.example.demomybasits.CookieUtil;
import com.example.demomybasits.PermissionJudge;
import com.example.demomybasits.api.entity.StaffUser;
import com.example.demomybasits.api.service.impl.StaffUserServiceImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tzx
 * @since 2020-02-16
 */
@RestController
public class StaffUserController {
    @Autowired
    private StaffUserServiceImpl staffUserService;
@RequestMapping("/sqltest11")
    public List<StaffUser> GetList(){
    return  staffUserService.GetList();
}
    @RequestMapping("/api/staffregister")
    public int Insert(@RequestBody Map<String, String> map){
    String name, password, Staff, Company,token,type;
    name=map.get("user").toString();
        password=map.get("psw").toString();
        Staff=map.get("name").toString();
        Company=map.get("cmp").toString();
        token=map.get("token").toString();
        type=map.get("type").toString();
        StaffUser staffUser=new StaffUser();
     if(type.equals("签派")){
         staffUser.setPermission(666);
         staffUser.setType(100);
     }else if(type.equals("管制")){
         staffUser.setPermission(555);
         staffUser.setType(101);
     }

    staffUser.setName(name);
    staffUser.setPassword(password);
    staffUser.setStaff(Staff);
    staffUser.setCompany(Company);
    return staffUserService.InsertStaff(staffUser,token);
    }
    @RequestMapping("/sqltest13")
    public int UpdateStaff(String name,String password){
    return staffUserService.UpdateStaff(name, password);
    }
    @RequestMapping("/sqltest/login")
    public StaffUser isLogin(@RequestBody Map<String, String> map){
    String name=map.get("name").toString();
        String password=map.get("password").toString();
    return staffUserService.isLogin(name, password);

    }
    @RequestMapping("/api/Login")
    public String Login(@RequestBody Map<String, String> map, HttpServletRequest request) throws JSONException {
        String name=map.get("name").toString();
        String password=map.get("password").toString();
        String type=map.get("type").toString();
        JSONObject object=new JSONObject();
        String pattern = "[a-zA-Z]*";
        boolean flag = Pattern.matches(pattern, name);
        if(!flag){
            object.put("status",-1);
            object.put("com",null);
            return object.toString();
        }
        if(staffUserService.Login(name, password,type)!=null){
            System.out.println(staffUserService.Login(name, password,type).getType()+" "+staffUserService.Login(name, password,type).getPermission());
            staffUserService.insetrecord("/api/Login"+name);
            System.out.println(staffUserService.Login(name, password,type).getCompany());
            object.put("status",1);
            object.put("com",staffUserService.Login(name, password,type).getCompany());
            request.getSession().setAttribute("userInfo",name);
        }else{
            object.put("status",0);
            object.put("com",null);
        }
        return object.toString();
    }
    @RequestMapping("/isLogin")
    public int isLogin(HttpServletRequest request){
        System.out.println(request.getSession().getAttribute("userInfo"));
        return 1;
    }

    @RequestMapping("/api/permissiontest")
    public String ishave(HttpServletResponse response){
        CookieUtil.set(response,"Cookie","123",true);
        String sub = "666";
        String obj ="/api/permissiontest";
        String act = "(GET)|(POST)";
        return PermissionJudge.judge(sub, obj, act);
    }
    @GetMapping(value = "/api/loginout")
    public String loginout(HttpServletRequest request) {
        String info = "登出操作";
        //log.info(info);
        HttpSession session = request.getSession();
        staffUserService.insetrecord("/api/Login"+session.getAttribute("userInfo"));
        // 将用户信息从session中删除
        session.removeAttribute("userInfo");

        Object userInfo = session.getAttribute("userInfo");
        if (userInfo == null) {
            info = "登出成功";
        } else {
            info = "登出失败";
        }
        //log.info(info);

        return info;

    }
    @RequestMapping("/api/Register")
    public String Register(@RequestBody Map<String, String> map) throws JSONException {
        String name,psw,staff,type,com,hash;
        name=map.get("name");
        psw=map.get("psw");
        staff=map.get("staff");
        type=map.get("type");
        com=map.get("com");
        hash=map.get("hash");
        JSONObject object=new JSONObject();
        if(staffUserService.isExist(name)==1){
            object.put("status",-1);
            object.put("res","已经注册");
            return object.toString();
        }

        if(staffUserService.isLegel(com,hash)==1){
            StaffUser staffUser=new StaffUser();
            staffUser.setName(name);
            staffUser.setPassword(psw);
            staffUser.setStaff(staff);
            staffUser.setCompany(com);
            staffUser.setType(Integer.valueOf(type));
            if(type.equals("999")){
                //管理员
                staffUser.setPermission(777);
            }else if(type.equals("100")){
                //管制
                staffUser.setPermission(666);
            }else if(type.equals("101")){
                //签派
                staffUser.setPermission(666);
            }else{
                object.put("status",-1);
                object.put("res","输入违法");
                return object.toString();
            }
            int status=staffUserService.Register(staffUser);
            if(status==0){
                object.put("status",-1);
                object.put("res","注册失败");
            }else{
                object.put("status",1);
                object.put("res","注册成功");
            }
        }else{
            object.put("status",-1);
            object.put("res","验证失败");
        }
        return object.toString();
    }
    @RequestMapping("/API/GetStaffInfo")
    public List<Map<String,Object>>GetStaffInfo(String com){
    return  staffUserService.GetStaffInfo(com);
    }
    @RequestMapping("/API/UpdateStaffState")
    public String UpdateStaffState(String name) throws JSONException {
        JSONObject object=new JSONObject();
        String sqlcord="UPDATE staff_user set type=type*-1 where name="+name;
        int res=staffUserService.UpdateStaff(name);
        if(res==0){
            object.put("status",0);
            object.put("res","更新失败");
        }else{
            staffUserService.insetrecord(sqlcord);
            object.put("status",1);
            object.put("res","更新成功");
        }
        return object.toString();
    }
    @RequestMapping("/API/DeleteStaffState")
    public String DeleteStaffState(String name) throws JSONException {
        JSONObject object=new JSONObject();
        String sql="DELETE FROM `staff_user` WHERE name="+name;
        int res=staffUserService.DeleteStaff(name);
        if(res==0){
            object.put("status",0);
            object.put("res","删除失败");
        }else{
            staffUserService.insetrecord(sql);
            object.put("status",1);
            object.put("res","删除成功");
        }
        return object.toString();
    }
}
