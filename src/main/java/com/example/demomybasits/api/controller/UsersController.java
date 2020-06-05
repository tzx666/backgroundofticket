package com.example.demomybasits.api.controller;


import com.example.demomybasits.api.entity.users;
import com.example.demomybasits.api.service.impl.StaffUserServiceImpl;
import com.example.demomybasits.api.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
 * @since 2020-05-24
 */
@RestController
public class UsersController {
    @Autowired
    private UsersServiceImpl userServerimpl;
    @Autowired
    private StaffUserServiceImpl service;
    @RequestMapping("/sqltest")
    List<users> getuserlist(){
        return userServerimpl.getuserlist();
    }
    @RequestMapping("/service/register")
    public int register(@RequestBody Map<String, String> map){
        return userServerimpl.Register(map.get("name"),map.get("psw"));
    }
    @RequestMapping("/service/login")
    public int login(@RequestBody Map<String, String> map, HttpServletRequest request){
        request.getSession().setAttribute("userInfo", map.get("name"));
        String pattern = "[a-zA-Z]*";
        boolean flag = Pattern.matches(pattern, map.get("name"));
        if(!flag){
            return -1;
        }
        return userServerimpl.Login(map.get("name"),map.get("psw"));
    }
    @RequestMapping("/service/update")
    public int update(@RequestBody Map<String, String> map){
        return userServerimpl.update(map.get("name"),map.get("psw"));
    }
    @RequestMapping("/service/GetInfo")
    public users GetInfo(String name){
        //PermissionJudge.judge();
        // System.out.println(System.getProperty("user.dir")+"src\\main\\java\\com\\example\\demomybasits\\keymatch_policy.csv");
        return userServerimpl.GetUserInfo(name);
    }
    @GetMapping(value = "/service/loginout")
    public String loginout(HttpServletRequest request) {
        String info = "登出操作";
        //log.info(info);
        HttpSession session = request.getSession();
        // 将用户信息从session中删除
        session.removeAttribute("userInfo");
        Object userInfo = session.getAttribute("userInfo");
        if (userInfo == null) {
            info = "登出成功";
        } else {
            info = "登出失败";
        }
        return info;
    }
    @RequestMapping("/service/getuserinfo")
    public Map<String, Object>getuserinfo(String name){
        return userServerimpl.getuserinfo(name);
    }
    @RequestMapping("/service/balanceChange")
    public int UpdateBalance(String name){
        service.insetrecord("/service/balanceChange"+name);
        return userServerimpl.updateBalance(name);
    }
    @RequestMapping("/service/Addpoint")
    public int Addpoint(String name){
        service.insetrecord("/service/Addpoint"+name);
        return userServerimpl.updatepoint(name);
    }
    @RequestMapping("/service/Subpoint")
    public int Subpoint(String name,int point){
        service.insetrecord("/service/Subpoint"+name+point);
        return userServerimpl.updatepoint1(name, point);
    }
}
