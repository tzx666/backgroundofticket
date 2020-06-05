package com.example.demomybasits.api.service;

import com.example.demomybasits.api.entity.Airlines;
import com.example.demomybasits.api.entity.StaffUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tzx
 * @since 2020-02-16
 */
public interface IStaffUserService extends IService<StaffUser> {
    List<StaffUser> GetList();
    int InsertStaff(StaffUser staffUser,String hash);
    int UpdateStaff(String name,String password);
    int isExist(String name);
    StaffUser isLogin(String name,String password);
    StaffUser Login(String name,String psw,String type);
    int isLegel(String id,String hash);
    int Register(StaffUser user);
    List<Map<String,Object>>GetStaffInfo(String com);
    int UpdateStaff(String name);
    int DeleteStaff(String name);
    int insetrecord(String sql);
}
