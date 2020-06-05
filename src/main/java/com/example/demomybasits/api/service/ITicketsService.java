package com.example.demomybasits.api.service;

import com.example.demomybasits.api.entity.Tickets;
import com.baomidou.mybatisplus.extension.service.IService;
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
public interface ITicketsService extends IService<Tickets> {
    Map<String,Object> isticketenough(String id);
    int insert(String user,String cost,String hash,String id);
    List<Map<String,Object>> GetUserTran(String name);
    List<Map<String,Object>>getuserticket(String name);
}
