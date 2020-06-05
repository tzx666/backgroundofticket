package com.example.demomybasits.api.service.impl;

import com.example.demomybasits.api.entity.Tickets;
import com.example.demomybasits.api.mapper.TicketNumMapper;
import com.example.demomybasits.api.mapper.TicketsMapper;
import com.example.demomybasits.api.service.ITicketsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TicketsServiceImpl extends ServiceImpl<TicketsMapper, Tickets> implements ITicketsService {
@Autowired
    private TicketsMapper mapper;
    @Override
    public Map<String, Object> isticketenough(String id) {
        return mapper.isticketenough(id);
    }

    @Override
    public int insert(String user, String cost, String hash, String id) {
        return mapper.insert(user,cost,hash,id);
    }

    @Override
    public List<Map<String, Object>> GetUserTran(String name) {
        return mapper.GetUserTran(name);
    }

    @Override
    public List<Map<String, Object>> getuserticket(String name) {
        return mapper.getuserticket(name);
    }
}
