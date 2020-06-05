package com.example.demomybasits.api.entity;

public class Region {
    private int id;
    private String name;
    private int pid;
    private String sname;
    private int level;
    private String citycode;
    private String yzcode;
    private String mername;
    private float Lng;
    private float Lat;
    private String pinyin;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public float getLat() {
        return Lat;
    }

    public float getLng() {
        return Lng;
    }

    public int getLevel() {
        return level;
    }

    public int getPid() {
        return pid;
    }

    public String getCitycode() {
        return citycode;
    }

    public String getMername() {
        return mername;
    }

    public String getPinyin() {
        return pinyin;
    }

    public String getSname() {
        return sname;
    }

    public String getYzcode() {
        return yzcode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public void setLat(float lat) {
        Lat = lat;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLng(float lng) {
        Lng = lng;
    }

    public void setMername(String mername) {
        this.mername = mername;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setYzcode(String yzcode) {
        this.yzcode = yzcode;
    }
}
