package com.example.demomybasits.api.service.impl;

import com.example.demomybasits.api.entity.Airlines;
import com.example.demomybasits.api.entity.StaffUser;
import com.example.demomybasits.api.mapper.AirlinesMapper;
import com.example.demomybasits.api.mapper.StaffUserMapper;
import com.example.demomybasits.api.service.IStaffUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tzx
 * @since 2020-02-16
 */
@Repository
public class StaffUserServiceImpl extends ServiceImpl<StaffUserMapper, StaffUser> implements IStaffUserService {
@Autowired
    private StaffUserMapper staffUserMapper;
    @Autowired
    private AirlinesMapper airlinesMapper;
    @Override
    public List<StaffUser> GetList() {
        return staffUserMapper.selectList(null);
    }

    @Override
    public int InsertStaff(StaffUser staffUser,String hash) {
        //如果不存在则插入，否则不插入
        System.out.println(staffUser.getCompany());
        Airlines res=airlinesMapper.isPermission(staffUser.getCompany());
        System.out.println(res.getRegID());
        if(res.getRegID().equals(staffUser.getCompany())){
            if(this.isExist(staffUser.getName())==0)
                return staffUserMapper.insert(staffUser);
            else if(this.isExist(staffUser.getName())==1){
                return -1;
            }else{
                return -2;
            }
        }else{
            return -3;
        }
    }

    @Override
    public int UpdateStaff(String name,String password) {
        //如果存在则修改密码，否则不修改密码
        if(this.isExist(name)==1)
            return staffUserMapper.update(name, password);
        else if(this.isExist(name)==0){
            return -1;
        }else{
            return -2;
        }
    }

    @Override
    public int isExist(String name) {
        if(staffUserMapper.isExist(name)==null)
            return 0;
        return 1;
    }

    @Override
    public StaffUser isLogin(String name, String password) {
        return  staffUserMapper.Login(name,password);
    }

    @Override
    public StaffUser Login(String name, String psw, String type) {
        return staffUserMapper.Login(name, psw, type);
    }

    @Override
    public int isLegel(String id,String hash) {
        return staffUserMapper.isLegel(id,hash)==null?0:1;
    }

    @Override
    public int Register(StaffUser user) {
        return staffUserMapper.insert(user);
    }

    @Override
    public List<Map<String, Object>> GetStaffInfo(String com) {
        return staffUserMapper.GetStaffInfo(com);
    }

    @Override
    public int UpdateStaff(String name) {
        return staffUserMapper.UpdateStaff(name);
    }

    @Override
    public int DeleteStaff(String name) {
        return staffUserMapper.DeleteStaff(name);
    }

    @Override
    public int insetrecord(String sql) {
        return staffUserMapper.insetrecord(sql);
    }
}
