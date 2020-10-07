package designPatterns.bridge;

/**
 * @author Mckay
 * @create 2020-10-06
 * @description
 **/
public class Test {
    public static void main(String[] args) {
        Phone phone = new FolderPhone(new Xiaomi());
        phone.open();
        phone.call();
        phone.close();


        Phone phone1 = new UprightPhone(new Xiaomi());
        phone1.open();
        phone1.call();
        phone1.close();
    }
}
