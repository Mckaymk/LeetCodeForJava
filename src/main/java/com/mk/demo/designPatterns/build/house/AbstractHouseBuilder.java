package com.mk.demo.designPatterns.build.house;

/**
 * @author Mckay
 * @create 2020-10-11
 * @description
 **/
public abstract class AbstractHouseBuilder {
    protected House house = new House();

    public abstract void buildBasic();

    public abstract void buildWalls();

    public abstract void roofed();

    public House buildHouse() {
        return house;
    }
}
