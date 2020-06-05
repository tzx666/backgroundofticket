package com.example.demomybasits.api.service.impl;

import com.example.demomybasits.api.entity.DelayTip;
import com.example.demomybasits.api.mapper.DelayTipMapper;
import com.example.demomybasits.api.service.IDelayTipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tzx
 * @since 2020-02-23
 */
@Service
public class DelayTipServiceImpl extends ServiceImpl<DelayTipMapper, DelayTip> implements IDelayTipService {
@Autowired
private DelayTipMapper mapper;
    @Override
    public List<DelayTip> DelayTips() {
        return mapper.DelayTips();
    }
}
