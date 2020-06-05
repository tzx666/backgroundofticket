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
 * @since 2020-02-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Airlines implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("RegID")
    private String RegID;

    @TableField("FullName")
    private String FullName;
    @TableField("Hash")
    private String hash;

    public String getFullName() {
        return FullName;
    }

    public String getHash() {
        return hash;
    }

    public String getRegID() {
        return RegID;
    }
}
