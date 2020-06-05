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
 * @since 2020-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StaffUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String password;
    private int permission;
    @TableField("Staff")
    private String Staff;
    private int type;
    @TableField("Company")
    private String Company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return Company;
    }

    public String getPassword() {
        return password;
    }

    public String getStaff() {
        return Staff;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStaff(String staff) {
        Staff = staff;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
