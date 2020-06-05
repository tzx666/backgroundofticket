package com.example.demomybasits.api.service.impl;

import com.example.demomybasits.api.entity.Planes;
import com.example.demomybasits.api.mapper.PlanesMapper;
import com.example.demomybasits.api.service.IPlanesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class PlanesServiceImpl extends ServiceImpl<PlanesMapper, Planes> implements IPlanesService {
    @Autowired
    private PlanesMapper mapper;
    @Override
    public List<Planes> GetPlaneByCompany(String com) {
        return mapper.GetPlaneByCompany(com);
    }

    @Override
    public List<Map<String, Object>> GetPlaneByTypeAndCompany(String type, String com) {
        return mapper.GetPlaneByTypeAndCompany(type, com);
    }

    @Override
    public int addPlane(Planes planes) {
        return mapper.insert(planes);
    }

    @Override
    public int deletePlane(String id) {
        return mapper.deletePlane(id);
    }

    @Override
    public int UpdatePlane(String id,String com) {
        return mapper.UpdatePlane( id, com);
    }

    @Override
    public List<Map<String, Object>> GetUsefulPlane(String takeoff, String land,String com) {
        return mapper.GetUsefulPlane(takeoff, land,com);
    }

    public String GetLatestCode(){
        return mapper.GetLatestCode();
    }
}
