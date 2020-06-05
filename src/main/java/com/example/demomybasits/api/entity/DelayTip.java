package com.example.demomybasits.api.entity;

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
 * @since 2020-02-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DelayTip implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer errorCode;

    private String errorReason;


}
