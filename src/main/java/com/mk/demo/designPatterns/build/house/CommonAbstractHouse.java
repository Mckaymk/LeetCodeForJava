package com.mk.demo.designPatterns.build.house;

/**
 * @author Mckay
 * @create 2020-10-11
 * @description
 **/
public class CommonAbstractHouse extends AbstractHouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子封顶了");
    }
}
