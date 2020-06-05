package com.example.demomybasits.api.service.impl;

import com.example.demomybasits.api.entity.TicketNum;
import com.example.demomybasits.api.mapper.TicketNumMapper;
import com.example.demomybasits.api.service.ITicketNumService;
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
public class TicketNumServiceImpl extends ServiceImpl<TicketNumMapper, TicketNum> implements ITicketNumService {
@Autowired
private TicketNumMapper mapper;
    @Override
    public Double res() {
        Double a=mapper.money()==null?0:mapper.money();
        Double b=Double.valueOf(mapper.count()*100000);
        System.out.print(a+" "+b);
        return a-b;
    }

    @Override
    public int UpdateTicketADD(String id, int type) {
        if(type==1){
            return    mapper.UpdateTicketAADD(id);
        }else if(type==2){
            return   mapper.UpdateTicketBADD(id);
        }else{
            return  mapper.UpdateTicketCADD(id);
        }
    }

    @Override
    public int UpdateTicketSUB(String id, int type) {
        if(type==1){
            return    mapper.UpdateTicketASUB(id);
        }else if(type==2){
            return   mapper.UpdateTicketBSUB(id);
        }else{
            return  mapper.UpdateTicketCSUB(id);
        }
    }
}
