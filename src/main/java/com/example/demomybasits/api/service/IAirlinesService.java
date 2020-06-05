package com.example.demomybasits.api.service;

import com.example.demomybasits.api.entity.Airlines;
import com.baomidou.mybatisplus.extension.service.IService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tzx
 * @since 2020-02-15
 */
@Service
public interface IAirlinesService extends IService<Airlines> {
    List<Airlines> GetAll();
    Airlines isPermission(String fullname);
    List<Airlines>getAllAirlines();
}
