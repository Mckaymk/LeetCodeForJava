package designPatterns.bridge;

/**
 * @author Mckay
 * @create 2020-10-06
 * @description
 **/
public class FolderPhone extends Phone {
    public FolderPhone(Brand brand) {
        super(brand);
    }

    @Override
    protected void call() {
        super.call();
        System.out.println("折叠式手机打电话");
    }

    @Override
    protected void open() {
        super.open();
        System.out.println("折叠式手机开机了");

    }

    @Override
    protected void close() {
        super.close();
        System.out.println("折叠式手机关机了");

    }
}
