/**
 * @author Mckay
 * @create 2020-09-10
 * @description
 **/

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class Main1 {
    static class Node {
        int remain;
        static int maxValue;
        int cur = 1;

        public Node(int remain) {
            this.remain = remain;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "remain=" + remain +
                    ", maxValue=" + maxValue +
                    ", cur=" + cur +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return remain == node.remain &&
                    cur == node.cur;
        }

        @Override
        public int hashCode() {
            return Objects.hash(remain, cur);
        }
    }

    public static int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int one = 1;
        int two = 2;
        int three = 4;
        int res = 0;
        for (int i = 4; i <= n; i++) {
            res = one + two;
            if (res > 1000000007) {
                res -= 1000000007;
            }
            res += three;
            if (res > 1000000007) {
                res -= 1000000007;
            }
            one = two;
            two = three;
            three = res;
        }
        return res;

    }

    public static int climbStairs(int n) {
        int p = 0;
        int q = 1;
        int tmp = 0;
        for (int i = 0; i <= n; i++) {
            tmp = q;
            q = p + q;
            p = tmp;
        }
        return p;

    }


    public static void main(String[] args) {
        int n = 8;
        System.out.println(nStepClimbStairs(n, 3));
        System.out.println(climbStairs(n));
        System.out.println(waysToStep(n));
    }

    public static int nStepClimbStairs(int n, int step) {
        Map<Node, Integer> map = new HashMap<>(16);
        Node.maxValue = step;
        Node root = new Node(n);
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            Node pop = stack.peek();
            if (pop.remain == 0) {
                count += 1;
                stack.pop();
            } else if (pop.remain > 0) {
                if (pop.cur <= Node.maxValue) {
                    stack.push(new Node(pop.remain - pop.cur));
                    pop.cur++;
                } else {
                    stack.pop();
                }
            } else {
                stack.pop();
            }
        }
        return count;
    }
}
