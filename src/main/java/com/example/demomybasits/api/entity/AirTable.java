package com.example.demomybasits.api.entity;

import lombok.Data;

@Data
public class AirTable {
    private  int ID;
    private  String Pid;
    private  String ComID;
    private  String pre_takeoff;
    private  String pre_landing;
    private  String takeoff_place;
    private  String landing_place;
    private  String takeoff_pinyin;
    private  String landing_pinyin;
    private String FullName;
    private String type;
}//必须手动注解result否则无法正常析出原文
