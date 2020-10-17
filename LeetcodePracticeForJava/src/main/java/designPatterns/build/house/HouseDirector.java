package designPatterns.build.house;

/**
 * @author Mckay
 * @create 2020-10-11
 * @description
 **/
public class HouseDirector {
    AbstractHouseBuilder houseBuilder = null;


    public HouseDirector(AbstractHouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }


    public void setHouseBuilder(AbstractHouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}
