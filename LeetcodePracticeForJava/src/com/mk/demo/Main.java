package com.mk.demo;


import java.util.*;

public class Main {
    static class Node {
        int num;
        Node next;

        public Node(int value) {
            this.num = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node root = new Node(-1);
        Node p = root;
        for (int i = 0; i < n; i++) {
            p.next = new Node(in.nextInt());
            p = p.next;
        }
        boolean flag = true;
        int min_value = -1;
        Node pre = null;
        while (flag) {
            flag = false;
            p = root.next;
            pre = null;
            while (p.next != null) {
                if (p.num == p.next.num) {
                    if (pre == null) {
                        pre = p;
                        min_value = p.num;
                    } else if (p.num < min_value) {
                        min_value = p.num;
                        pre = p;
                    }
                    flag = true;
                }

                p = p.next;
            }
            if (pre != null) {
                pre.next = pre.next.next;
                pre.num *= 2;
            }

        }
        while (root.next != null) {
            System.out.print(root.next.num);
            if (root.next != null) {
                System.out.print(" ");
            }
            root = root.next;
        }
    }
}
