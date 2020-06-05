package com.example.demomybasits.api.service;

import com.example.demomybasits.api.entity.DelayTip;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tzx
 * @since 2020-02-23
 */
public interface IDelayTipService extends IService<DelayTip> {
    List<DelayTip> DelayTips();
}
