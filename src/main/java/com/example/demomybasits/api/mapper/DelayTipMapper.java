package com.example.demomybasits.api.mapper;

import com.example.demomybasits.api.entity.DelayTip;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tzx
 * @since 2020-02-23
 */
@Component
public interface DelayTipMapper extends BaseMapper<DelayTip> {
@Select("SELECT * from delay_tip")
    List<DelayTip>DelayTips();
}
