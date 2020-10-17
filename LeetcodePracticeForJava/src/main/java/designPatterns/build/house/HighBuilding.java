package designPatterns.build.house;

/**
 * @author Mckay
 * @create 2020-10-11
 * @description
 **/
public class HighBuilding extends AbstractHouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("高楼打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砌墙");

    }

    @Override
    public void roofed() {
        System.out.println("高楼封顶了");
    }
}
