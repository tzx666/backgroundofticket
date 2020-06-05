package com.example.demomybasits.api.service;

import com.example.demomybasits.api.entity.Planetype;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tzx
 * @since 2020-05-24
 */
public interface IPlanetypeService extends IService<Planetype> {
    Map<String, Object> GetSeats(String type);
}
