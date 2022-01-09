package designPatterns.bridge;

/**
 * @author Mckay
 * @create 2020-10-06
 * @description
 **/
public class UprightPhone extends Phone {
    public UprightPhone(Brand brand) {
        super(brand);
    }

    @Override
    protected void call() {
        super.call();
        System.out.println("直立手机打电话");
    }

    @Override
    protected void open() {
        super.open();
        System.out.println("直立手机开机");

    }

    @Override
    protected void close() {
        super.close();
        System.out.println("直立手机关机");

    }
}
