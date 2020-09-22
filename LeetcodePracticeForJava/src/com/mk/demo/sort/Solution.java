package com.mk.demo.sort;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author MengKai
 * @create 2020-08-13
 */
public class Solution {
    public boolean IsValidExp(String s) {
        // write code here
        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        set.add('[');
        set.add('(');
        set.add('{');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)){
                stack.push(c);
            }
            
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
