package com.xwy.one.bean;

public class Man {
    private Godness godNess;

    public Man(Godness godNess) {
        this.godNess = godNess;
    }

    public Godness getGodNess() {
        return godNess;
    }

    public void setGodNess(Godness godNess) {
        this.godNess = godNess;
    }

    public Man() {
    }

    @Override
    public String toString() {
        return "Man{" +
                "godNess=" + godNess +
                '}';
    }
}