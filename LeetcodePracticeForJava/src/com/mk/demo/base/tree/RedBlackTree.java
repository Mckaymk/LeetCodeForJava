package com.mk.demo.base.tree;

import java.lang.ref.ReferenceQueue;

/**
 * @author MengKai
 * @create 2020-07-14
 */
public class RedBlackTree<Key extends Comparable, Value> {

    private Node root;
    private int N;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private class Node {
        public Key key;
        public Value value;
        public Node left;
        public Node right;
        public boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", color=" + color +
                    '}';
        }
    }

    private boolean isRed(Node x) {
        //判断节点是否为红色
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    public boolean isRed(Key key) {
        return isRed(get(root, key));
    }

    private Node rotateLeft(Node h) {
        //左旋
        //获取h的左子节点，表示为x
        Node x = h.right;
        //让x节点的左子节点标记为h节点的右子节点
        h.right = x.left;
        //让h成为x节点的左子节点
        x.left = h;
        //让x的节点color的属性等于h节点的color属性
        x.color = h.color;
        //让h节点的color属性变为红色
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        //右旋
        //获取h的左子节点
        Node x = h.left;
        //让x节点的右子节点，成为h节点的左子节点
        h.left = x.right;
        //让h节点成为x的右子节点
        x.right = h;
        //让x节点的color的属性等于h节点的color属性
        x.color = h.color;
        //让h节点的color属性变为红色
        h.color = RED;

        return x;
    }

    private void flipColors(Node h) {
        //颜色反转
        //当前节点变成红色
        h.color = RED;
        //左子节点和右子节点变成黑色
        h.left.color = BLACK;
        h.right.color = BLACK;

    }

    public void put(Key key, Value value) {
        //插入操作
        root = put(root, key, value);
        //根节点的颜色总为黑色
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        //在指定树中，完成操作
        if (h == null) {
            N++;
            return new Node(key, value, null, null, RED);
        }
        //比较值得大小
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }
        //左旋
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        //右旋
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }

        //变色
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        return h;
    }

    public Value get(Key key) {
        //获取key对应的值
        Node x = get(root, key);
        if (x == null) {
            return null;
        } else {
            return x.value;
        }
    }

    private Node get(Node x, Key key) {
        //从指定树中，获取key的值
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x;
        }
    }

    public int size() {
        //获取树的大小
        return N;
    }

}
