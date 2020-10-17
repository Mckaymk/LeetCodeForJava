package designPatterns.build.house;

/**
 * @author Mckay
 * @create 2020-10-11
 * @description
 **/
public class Test {
    public static void main(String[] args) {

//        HouseDirector houseDirector = new HouseDirector(new CommonAbstractHouse());
        HouseDirector houseDirector = new HouseDirector(new HighBuilding());
        houseDirector.constructHouse();


    }
}
