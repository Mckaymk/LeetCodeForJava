package com.mk.demo.base.tree;


import java.util.ArrayList;
import java.util.Stack;

/**
 * @author MengKai
 * @create 2020-06-30
 */
public class TravelBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        boolean isFirst;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void preOrder(TreeNode node, ArrayList<Integer> arr) {
        if (node == null) {
            return;
        }
        arr.add(node.val);
        preOrder(node.left, arr);
        preOrder(node.right, arr);
    }

    public void inOrder(TreeNode node, ArrayList<Integer> arr) {
        if (node == null) {
            return;
        }
        inOrder(node.left, arr);
        arr.add(node.val);
        inOrder(node.right, arr);
    }

    public void postOrder(TreeNode node, ArrayList<Integer> arr) {
        if (node == null) {
            return;
        }
        postOrder(node.left, arr);
        postOrder(node.right, arr);
        arr.add(node.val);
    }

    public ArrayList<Integer> nonRecursivePreOrder(TreeNode node) {
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                arr.add(current.val);
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                current = current.right;
            }
        }
        return arr;
    }


    public ArrayList<Integer> nonRecursiveInOrder(TreeNode node) {
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                arr.add(current.val);
                current = current.right;
            }
        }
        return arr;
    }


    public ArrayList<Integer> nonRecursivePostOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                current.isFirst = true;
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                if (current.isFirst) {
                    current.isFirst = false;
                    stack.push(current);
                    current = current.right;
                } else {
                    arr.add(current.val);
                    current = null;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

//        testRecursivePostOrder(root);
//        testPreOrder(root);
//        testInOrder(root);
        testPostOrder(root);

    }

    private static void testPreOrder(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        TravelBinaryTree travel = new TravelBinaryTree();
        arr = travel.nonRecursivePreOrder(root);
        System.out.println("nonRecursivePreOrder = " + arr.toString());
        arr.clear();
        travel.preOrder(root, arr);
        System.out.println("preOrder = " + arr.toString());
    }

    private static void testInOrder(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        TravelBinaryTree travel = new TravelBinaryTree();
        arr = travel.nonRecursiveInOrder(root);
        System.out.println("nonRecursiveInOrder = " + arr.toString());
        arr.clear();
        travel.inOrder(root, arr);
        System.out.println("inOrder = " + arr.toString());
    }

    private static void testPostOrder(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        TravelBinaryTree travel = new TravelBinaryTree();
        arr = travel.nonRecursivePostOrder(root);
        System.out.println("nonRecursivePostOrder = " + arr.toString());
        arr.clear();
        travel.postOrder(root, arr);
        System.out.println("postOrder = " + arr.toString());
    }

}
