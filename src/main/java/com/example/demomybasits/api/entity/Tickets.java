package com.example.demomybasits.api.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author tzx
 * @since 2020-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Tickets implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableField("Userid")
    private Integer Userid;

    private BigDecimal cost;

    private String tranhash;
    private Integer scheduleID;

}
