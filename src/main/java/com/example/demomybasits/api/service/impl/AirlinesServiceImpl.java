package com.example.demomybasits.api.service.impl;

import com.example.demomybasits.api.entity.Airlines;
import com.example.demomybasits.api.mapper.AirlinesMapper;
import com.example.demomybasits.api.service.IAirlinesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tzx
 * @since 2020-02-15
 */
@Service
public class AirlinesServiceImpl extends ServiceImpl<AirlinesMapper, Airlines> implements IAirlinesService {
    @Autowired
    private com.example.demomybasits.api.mapper.AirlinesMapper airlinesMapper;
    @Override
    public List<Airlines> GetAll() {
        return airlinesMapper.GetAll();
    }

    @Override
    public Airlines isPermission(String fullname) {
        return airlinesMapper.isPermission(fullname);
    }

    @Override
    public List<Airlines> getAllAirlines() {
        return airlinesMapper.getAllAirlines();
    }

}
