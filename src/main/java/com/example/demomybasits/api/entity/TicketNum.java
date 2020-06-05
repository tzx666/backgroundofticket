package com.example.demomybasits.api.entity;

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
public class TicketNum implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer ticketId;

    @TableField("tickctA_rest")
    private Integer tickctaRest;

    private Integer total;

    @TableField("tickctB_rest")
    private Integer tickctbRest;

    @TableField("tickctC_rest")
    private Integer tickctcRest;

    @TableField("tickctA_price")
    private Integer tickctaPrice;

    @TableField("tickctB_price")
    private Integer tickctbPrice;

    @TableField("tickctC_price")
    private Integer tickctcPrice;


}
