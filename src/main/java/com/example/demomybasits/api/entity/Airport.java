package com.example.demomybasits.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-02-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Airport implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ICAO")
    private String icao;

    @TableField("Place")
    private String Place;

}
