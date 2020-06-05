package com.example.demomybasits.api.service;

import com.example.demomybasits.api.entity.Planes;
import com.baomidou.mybatisplus.extension.service.IService;

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
public interface IPlanesService extends IService<Planes> {
    List<Planes> GetPlaneByCompany(String com);
    List<Map<String, Object>>GetPlaneByTypeAndCompany(String type, String com);
    int addPlane(Planes planes);
    int deletePlane(String id);
    int UpdatePlane(String id,String com);
    List<Map<String, Object>>GetUsefulPlane(String takeoff,String land,String com);
}
