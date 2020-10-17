package com.mk.demo.boxes;

import java.util.*;

/**
 * @author MengKai
 * @create 2020-08-12
 */
public class Demo3 {
    public static void main(String[] args) {
//        Set<String> t = new HashSet<String>();
//        Set<String> b = new HashSet<String>();
//        Set<String> w = new HashSet<String>();

        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            list.add(sc.nextLine());

        }
        list.remove(0);
        for (String s : list) {
            System.out.println(s);
        }
        for (String s : list) {
            int t = 0;
            int b = 0;
            int w = 0;
            Set<Character> num = new HashSet<>();
            String[] cards = s.split(" ");
            for (String str : cards) {
                if (str.contains("T")) {
                    t++;
                    num.add(str.charAt(0));
                }
                if (str.contains("B")) {
                    b++;
                    num.add(str.charAt(0));
                }
                if (str.contains("W")) {
                    w++;
                    num.add(str.charAt(0));
                }
            }
            if (num.size() == 7 && t <= 3 && b <= 3 && w <= 3) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
/**
 * 4
 * 1T 4T 7T 2B 5B 8B 9W
 * 1T 2T 3T 4T 5T 6T 7T
 * 1B 2W 3T 4B 5W 6T 8W
 * 2B 8B 5B 2B 6T 7W 4W
 */