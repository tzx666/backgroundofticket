package com.example.demomybasits.api.controller;


import com.example.demomybasits.api.service.impl.StaffUserServiceImpl;
import com.example.demomybasits.api.service.impl.TicketNumServiceImpl;
import com.example.demomybasits.api.service.impl.TicketsServiceImpl;
import com.example.demomybasits.api.service.impl.UsersServiceImpl;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Cipher;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tzx
 * @since 2020-05-24
 */
@RestController

public class TicketsController {
    @Autowired
    private TicketsServiceImpl service;
    @Autowired
    private TicketNumServiceImpl service1;
    @Autowired
    private UsersServiceImpl service2;
    @Autowired
    private StaffUserServiceImpl service3;
    @RequestMapping("/servier/confirmenough")
    public int confirmenough(String id,int type){
        Map<String,Object>map=service.isticketenough(id);
        if(map==null)return 0;
        System.out.print(map.toString());
        if(type==1){
           return (Integer) map.get("tickctA_rest")>0?1:0;
        }else if(type==2){
            return (Integer) map.get("tickctB_rest")>0?1:0;
        }else{
            return (Integer) map.get("tickctC_rest")>0?1:0;
        }
    }
    @RequestMapping("/servier/confirmticket")
    @Transactional
    public String confirmticket(@RequestBody Map<String, String> map) throws JSONException {
        String type=map.get("type");
        String id=map.get("id");
        String price=map.get("price");
        String user=map.get("user");
        String transation=id+type;
        System.out.println(transation);
         RestTemplate restTemplate = new RestTemplate();
        String url="http://49.233.81.150:8082/encode?id="+transation;
        ResponseEntity<String>res=restTemplate.getForEntity(url,String.class);
        String body=res.getBody();
        JSONObject object = new JSONObject(body);
        Boolean issuccess= (Boolean) object.get("status");
        System.out.print(object.get("res").toString());
        service3.insetrecord("/servier/confirmticket"+type+id+price+user+transation);
        if(issuccess){
            String hash=object.get("res").toString();
            int result=service.insert(user,price,hash,id);
            if(result==1){
                int result1=service2.updateBalance2(Double.valueOf(price),user);
                if(result1==1){
                    int result2=service1.UpdateTicketSUB(id,Integer.valueOf(type));
                    if(result2==1)
                        return hash;
                }else{
                    return "0";
                }
            }
            return "0";
        }else{
            return "0";
        }
    }
    @RequestMapping("/servier/GetUserTran")
    public List<Map<String,Object>> GetUserTran(String name){
        return service.GetUserTran(name);
    }
    @RequestMapping("/servier/GetUserTicket")
    public List<Map<String,Object>>GetUserTicket(String name){
        return service.getuserticket(name);
    }
}
