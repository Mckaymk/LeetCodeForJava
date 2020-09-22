/**
 * @author Mckay
 * @create 2020-09-20
 * @description
 **/
public class StaticStuff {
    static int x = 10;

    static {
        x += 5;
    }

    public static void main(String[] args) {
        int x = 4;
        System.out.println((x > 4) ? 99.9 : 9);
        System.out.println("value is " + ((x>4)?99.9:9));

    }

    static {
        x /= 3;
    }
}
