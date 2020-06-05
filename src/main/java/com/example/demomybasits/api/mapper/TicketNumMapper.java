package com.example.demomybasits.api.mapper;

import com.example.demomybasits.api.entity.TicketNum;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tzx
 * @since 2020-05-24
 */
@Component
public interface TicketNumMapper extends BaseMapper<TicketNum> {
@Select("SELECT count(*) from `schedule` WHERE `schedule`.isdelay=0")
    int count();
@Select("SELECT sum(tickets.cost) FROM tickets")
    Double money();
@Update("UPDATE ticket_num set ticket_num.tickctA_rest=ticket_num.tickctA_rest-1 WHERE ticket_num.ticket_id=#{id};")
    int UpdateTicketASUB(String id);
    @Update("UPDATE ticket_num set ticket_num.tickctB_rest=ticket_num.tickctB_rest-1 WHERE ticket_num.ticket_id=#{id};")
    int UpdateTicketBSUB(String id);
    @Update("UPDATE ticket_num set ticket_num.tickctC_rest=ticket_num.tickctC_rest-1 WHERE ticket_num.ticket_id=#{id};")
    int UpdateTicketCSUB(String id);
    @Update("UPDATE ticket_num set ticket_num.tickctA_rest=ticket_num.tickctA_rest+1 WHERE ticket_num.ticket_id=#{id};")
    int UpdateTicketAADD(String id);
    @Update("UPDATE ticket_num set ticket_num.tickctB_rest=ticket_num.tickctB_rest+1 WHERE ticket_num.ticket_id=#{id};")
    int UpdateTicketBADD(String id);
    @Update("UPDATE ticket_num set ticket_num.tickctC_rest=ticket_num.tickctC_rest+1 WHERE ticket_num.ticket_id=#{id};")
    int UpdateTicketCADD(String id);
}
