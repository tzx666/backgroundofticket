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
 * @since 2020-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Planes implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("PlaneId")
    private String PlaneId;

    private String type;
    private  String state;
    @TableField("Company")
    private String Company;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getCompany() {
        return Company;
    }

    public String getPlaneId() {
        return PlaneId;
    }

    public String getType() {
        return type;
    }

    public void setPlaneId(String planeId) {
        PlaneId = planeId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
