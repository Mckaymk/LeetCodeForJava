package com.mk.demo.base.tree;

import javax.sound.midi.SoundbankResource;

/**
 * @author MengKai
 * @create 2020-07-19
 */
public class TreeTest {
    public static void main(String[] args) {
        RedBlackTree<String, String> redBlackTree = new RedBlackTree<>();
        redBlackTree.put("A","小明");
        redBlackTree.put("B","小红");
        redBlackTree.put("C","小红");
        redBlackTree.put("D","小红");
        redBlackTree.put("E","小红");
        redBlackTree.put("F","小红");

        System.out.println(redBlackTree.isRed("A"));
        System.out.println(redBlackTree.isRed("B"));
        System.out.println(redBlackTree.isRed("C"));
        System.out.println(redBlackTree.isRed("D"));
        System.out.println(redBlackTree.isRed("E"));
        System.out.println(redBlackTree.isRed("F"));
        System.out.println(redBlackTree.getRoot());

//        redBlackTree.put("3","小花");
//        redBlackTree.put("4","小黑");
        System.out.println(redBlackTree.get("1"));
        System.out.println(redBlackTree.get("2"));

    }
}
