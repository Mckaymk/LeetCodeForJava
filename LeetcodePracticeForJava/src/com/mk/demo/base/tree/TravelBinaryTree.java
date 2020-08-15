package com.mk.demo.base.tree;


import javax.sound.midi.SoundbankResource;
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

    public static void preOrder(TreeNode root) {
        //[1, 2, 4, 5, 3, 6, 7]
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                list.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop().right;
        }
        System.out.println(list.toString());
    }

    public static void preOrder1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                list.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop().right;
        }
        System.out.println("preOrder1" + list.toString());
    }

    public static void inOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        System.out.println(list.toString());
//        ArrayList<Integer> list = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode curr = root;
//        while (curr != null || !stack.isEmpty()) {
//            while (curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//            curr = stack.pop();
//            list.add(curr.val);
//            curr = curr.right;
//        }
//        System.out.println(list.toString());
    }

    public static void postOrderWithOnlyStack(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                curr.isFirst = true;
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.isFirst) {
                curr.isFirst = false;
                stack.push(curr);
                curr = curr.right;
            } else {
                list.add(curr.val);
                curr = null;
            }
        }
        System.out.println(list.toString());
    }


    public static void postOrderWithTwoStack(TreeNode root) {
        Stack<TreeNode> operate = new Stack<>();
        Stack<Integer> res = new Stack<>();
        operate.push(root);
        while (!operate.isEmpty()) {
            TreeNode curr = operate.pop();
            res.push(curr.val);
            if (curr.left != null) {
                operate.push(curr.left);
            }
            if (curr.right != null) {
                operate.push(curr.right);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!res.isEmpty()) {
            stringBuilder.append(res.pop());
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder.toString());

//        Stack<TreeNode> operate = new Stack<>();
//        Stack<Integer> res = new Stack<>();
//        operate.push(root);
//        while (!operate.isEmpty()) {
//            TreeNode curr = operate.pop();
//            res.push(curr.val);
//            if (curr.left != null) {
//                operate.push(curr.left);
//            }
//            if (curr.right != null) {
//                operate.push(curr.right);
//            }
//        }
//        while (!res.isEmpty()) {
//            System.out.print(res.pop() + " ");
//        }
//        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root1 = buildTree();
        TreeNode root2 = buildTree();
        //[1, 2, 4, 5, 3, 6, 7]
//        preOrder1(root1);
//        testPreOrder(root2);

//        inOrder(root1);
//        testInOrder(root2);
        postOrderWithTwoStack(root1);
        testPostOrder(root2);


    }

    public static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
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
