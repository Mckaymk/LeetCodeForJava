package com.mk.demo.boxes;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author MengKai
 * @create 2020-08-11
 * 1、请写一个字符串协议解析的实现，如 a=b&c=d& -> map[a]=b, map[c]=d. 要求尽量保持对异常的兼容如 &&&===&a=b&
 * 2、请写一个在字符串中寻找子串第一个位置的实现，并给出相应复杂度
 * 3、请实现一个高效的单向链表逆序输出（即1->2->3转变为3->2->1）
 */

public class Demo {
    public static void main(String[] args) {

        //test1
        Map<String, String> stringStringMap = parseStr("a=b&c=d&");
        if (stringStringMap.containsKey("a")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        //test2
        int index = findSubStr("aaabcc", "abc");
        if (index == -1) {
            System.out.println("未找到");
        } else {
            System.out.println("已找到，开始索引为" + index);
        }

        //test3
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        reverseList(node);
    }


    public static Map<String, String> parseStr(String str) {
        Map<String, String> map = new HashMap<>();
        String[] tmpStr = str.split("&");
        for (String s : tmpStr) {
            if (s.contains("=")) {
                String[] split = s.split("=");
                if (split.length == 2) {
                    map.put(split[0], split[1]);
                }
            }
        }
        return map;
    }

    public static int findSubStr(String target, String sub) {

        //BF -1表示没找到 时间复杂度为len(target)*len(sub)
        for (int i = 0; i < target.length() - sub.length() + 1; i++) {
            boolean flag = true;
            for (int j = 0, k = i; j < sub.length(); j++, k++) {
                if (target.charAt(k) != sub.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
        //kmp
    }

    public static void reverseList(Node root) {
        Stack<Node> stack = new Stack();
        Node p = root;
        while (p != null) {
            stack.push(p);
            p = p.next;

        }
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            stringBuilder.append(stack.pop().value);
            if (!stack.isEmpty()) {
                stringBuilder.append("->");
            } else {
                break;
            }
        }
        System.out.println(stringBuilder.toString());
    }

}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
