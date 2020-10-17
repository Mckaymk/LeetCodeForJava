package com.mk.demo.xiaomi;

import javafx.scene.transform.Scale;

import java.util.*;

/**
 * @author MengKai
 * @create 2020-09-15
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Character> set = new HashSet<>();
        set.add('(');
        set.add('[');
        set.add('{');
        while (in.hasNext()) {
            String str = in.nextLine();
            System.out.println(isValidString(set, str));
        }


    }

    private static boolean isValidString(Set<Character> set, String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (set.contains(c)) {
                stack.push(c);
            } else {
                char pop = stack.pop();
                switch (pop) {
                    case '(':
                        if (c != ')') {
                            return false;
                        }
                        break;
                    case '[':
                        if (c != ']') {
                            return false;
                        }
                        break;
                    case '{':
                        if (c != '}') {
                            return false;
                        }
                        break;
                }

            }
        }
        return stack.isEmpty();
    }
}
