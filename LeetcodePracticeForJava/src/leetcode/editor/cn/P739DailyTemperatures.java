//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表


package leetcode.editor.cn;

import java.util.*;

//java:每日温度
public class P739DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new P739DailyTemperatures().new Solution();
        //TO TEST
        int[] number = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = solution.dailyTemperatures(number);
        System.out.println(Arrays.toString(ints));

    }


    //leetcode submit region begin(Prohibit modification and deletion)

    public class keyValue {
        private int key;
        private int value;

        public keyValue(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "keyValue{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


    class Solution {
        public int[] dailyTemperatures(int[] T) {
            int[] target = new int[T.length];
            Stack<keyValue> stack = new Stack();
            for (int i = 0; i < T.length; i++) {
                // {73, 74, 75, 71, 69, 72, 76, 73}
                if (stack.isEmpty()) {
                    stack.push(new keyValue(i, T[i]));
                } else {
//[1, 1, 4, 2, 1, 1, 0, 0]。239
                    keyValue peek = stack.peek();    
                    while (T[i] > peek.getValue()) {
                        target[peek.getKey()] = i - peek.getKey();
                        stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        }
                        peek = stack.peek();
                    }
                    stack.push(new keyValue(i, T[i]));
                }
            }

            return target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}