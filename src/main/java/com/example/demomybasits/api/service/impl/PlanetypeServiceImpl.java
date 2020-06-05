package com.example.demomybasits.api.service.impl;

import com.example.demomybasits.api.entity.Planetype;
import com.example.demomybasits.api.mapper.PlanetypeMapper;
import com.example.demomybasits.api.service.IPlanetypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class PlanetypeServiceImpl extends ServiceImpl<PlanetypeMapper, Planetype> implements IPlanetypeService {
@Autowired
private PlanetypeMapper mapper;
    @Override
    public Map<String, Object> GetSeats(String id) {
        return mapper.GetSeats(id);
    }
}
