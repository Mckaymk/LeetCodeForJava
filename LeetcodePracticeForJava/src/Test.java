import java.util.*;

/**
 * @author Mckay
 * @create 2020-09-17
 * @description
 **/
class A {
    static {
        System.out.println("a");
    }

    public A() {
        System.out.println("b");
    }
}

class B extends A {
    static {
        System.out.println("c");
    }

    public B() {
        System.out.println("d");
    }
}

public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
    }

    private static void test1() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        Character ch1 = null;
        Character ch2 = null;
        int a = 0, b = 0;
        for (Character ch : map.keySet()) {
            if (map.get(ch) > a) {
                b = a;
                ch2 = ch1;
                a = map.get(ch);
                ch1 = ch;
            } else if (map.get(ch) < a && map.get(ch) > b) {
                b = map.get(ch);
                ch2 = ch;
            }
        }
        System.out.println(ch2);
    }
}
