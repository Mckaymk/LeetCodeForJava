package designPatterns.bridge;

/**
 * @author Mckay
 * @create 2020-10-06
 * @description
 **/
public abstract class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }


    protected void call() {
        this.brand.call();
    }


    protected void open() {
        this.brand.open();

    }

    protected void close() {
        this.brand.close();

    }
}
