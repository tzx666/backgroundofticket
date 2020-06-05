package com.example.demomybasits.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
public class Planetype implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("Type")
    private String Type;

    private Integer seat1;

    private Integer seat2;

    private Integer seat3;

    private Integer total;


}
