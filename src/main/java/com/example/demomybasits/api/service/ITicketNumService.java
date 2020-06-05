package com.example.demomybasits.api.service;

import com.example.demomybasits.api.entity.TicketNum;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tzx
 * @since 2020-05-24
 */
public interface ITicketNumService extends IService<TicketNum> {
    @Transactional
    Double res();
    int UpdateTicketADD(String id,int type);
    int UpdateTicketSUB(String id,int type);
}
