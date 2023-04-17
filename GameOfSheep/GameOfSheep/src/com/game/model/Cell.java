package com.game.model;

public class Cell {

    private Integer state = 0;      // 判断是否有牌

    private Brand brand;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
