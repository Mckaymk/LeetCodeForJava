package designPatterns.bridge;

/**
 * @author Mckay
 * @create 2020-10-06
 * @description
 **/
public class Vivo implements Brand{
    @Override
    public void call() {
        System.out.println("Vivo手机能打电话");
    }

    @Override
    public void open() {
        System.out.println("Vivo手机能开机");
    }

    @Override
    public void close() {
        System.out.println("Vivo手机能关机");

    }
}
