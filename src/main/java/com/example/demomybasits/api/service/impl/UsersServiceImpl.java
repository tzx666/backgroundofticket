package com.example.demomybasits.api.service.impl;

import com.example.demomybasits.api.entity.users;
import com.example.demomybasits.api.mapper.UsersMapper;
import com.example.demomybasits.api.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tzx
 * @since 2020-05-24
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, users> implements IUsersService {
    @Autowired
    private com.example.demomybasits.api.mapper.UsersMapper UserMapper;
    @Override
    public List<users> getuserlist() {
        try {
            List<users> users = UserMapper.getuserlist();

            return  users;
        }
        catch (Exception e)
        {
            throw e;
//            return null;
        }
    }

    @Override
    public int update(String name, String paw) {
        if(isExist(name)==0)return -1;
        return UserMapper.update(name, paw);
    }

    @Override
    public int isExist(String name) {
        return UserMapper.isExist(name)==null?0:1;
    }
    @Override
    public users GetUserInfo(String name){
        return UserMapper.isExist(name);
    }

    @Override
    public Map<String, Object> getuserinfo(String name) {
        return UserMapper.getuserinfo(name);
    }

    @Override
    @Transactional
    public int updateBalance(String name) {
        int res=UserMapper.updateBalance1(name);
        System.out.println(res);
        if(res==1){
            int res1=UserMapper.updateBalance();
            System.out.println(res1);
            return res1;
        }else{
            throw new RuntimeException("updatefile");
        }
    }

    @Override
    public int updateBalance2(Double price, String user) {
        return UserMapper.updateBalance2(price, user);
    }

    @Override
    public int updatepoint(String name) {
        return UserMapper.updatepoint(name);
    }

    @Override
    public int updatepoint1(String name, int point) {
        return UserMapper.updatepoint1(name, point);
    }


    @Override
    public int Login(String name, String psw) {
        if(isExist(name)==0)return -1;
        return UserMapper.Login(name, psw)==null?0:1;
    }

    @Override
    public int Register(String name, String psw) {
        if(isExist(name)==1)return -1;
        return UserMapper.Register(name, psw);
    }
}
