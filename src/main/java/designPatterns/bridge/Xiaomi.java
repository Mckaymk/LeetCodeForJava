package designPatterns.bridge;

/**
 * @author Mckay
 * @create 2020-10-06
 * @description
 **/
public class Xiaomi implements Brand{
    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void open() {
        System.out.println("小米手机开机");
    }

    @Override
    public void close() {
        System.out.println("小米手机关机");
    }
}
