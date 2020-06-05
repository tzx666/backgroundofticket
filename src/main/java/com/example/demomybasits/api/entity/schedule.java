package com.example.demomybasits.api.entity;

public class schedule {
    private  int ID;
    private  String Pid;
    private  String ComID;
    private  String pre_takeoff;
    private  String pre_landing;
    private  String takeoff_place;
    private  String landing_place;
    private Integer isdelay;
    private Integer delaycode;


    public void setPid(String pid) {
        Pid = pid;
    }

    public int getID() {
        return ID;
    }

    public String getComID() {
        return ComID;
    }

    public String getLanding_place() {
        return landing_place;
    }

    public String getPid() {
        return Pid;
    }

    public String getPre_landing() {
        return pre_landing;
    }

    public String getPre_takeoff() {
        return pre_takeoff;
    }


    public String getTakeoff_place() {
        return takeoff_place;
    }

    public void setComID(String comID) {
        ComID = comID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLanding_place(String landing_place) {
        this.landing_place = landing_place;
    }

    public void setPre_landing(String pre_landing) {
        this.pre_landing = pre_landing;
    }

    public void setPre_takeoff(String pre_takeoff) {
        this.pre_takeoff = pre_takeoff;
    }

    public void setTakeoff_place(String takeoff_place) {
        this.takeoff_place = takeoff_place;
    }

    public Integer getDelaycode() {
        return delaycode;
    }

    public Integer getIsdelay() {
        return isdelay;
    }

    public void setDelaycode(Integer delaycode) {
        this.delaycode = delaycode;
    }

    public void setIsdelay(Integer isdelay) {
        this.isdelay = isdelay;
    }
}
