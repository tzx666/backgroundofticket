package com.example.demomybasits.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomybasits.api.entity.users;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tzx
 * @since 2020-05-24
 */
public interface IUsersService extends IService<users> {
    List<users> getuserlist();
    int update(String name,String paw);
    int isExist(String name);
    int Login(String name,String psw);
    int Register(String name,String psw);
     users GetUserInfo(String name);
    Map<String,Object> getuserinfo(String name);
    @Transactional
    int updateBalance(String name);
    int updateBalance2(Double price,String user);
    int updatepoint(String name);
    int updatepoint1(String name,int point);
}
