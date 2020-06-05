package com.example.demomybasits.api.entity;

public class users {
    private int id;
    private String name;
    private String psw;
    private double account_balance;
    private int level;
    private int points;
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPsw() {
        return psw;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public double getAccount_balance() {
        return account_balance;
    }

    public int getPoints() {
        return points;
    }

    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
