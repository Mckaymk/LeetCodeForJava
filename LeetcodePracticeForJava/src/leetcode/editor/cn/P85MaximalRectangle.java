//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 示例: 
//
// 输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//输出: 6 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 592 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//java:最大矩形
public class P85MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new P85MaximalRectangle().new Solution();
        //TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {

        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0) {
                return 0;
            }
            int m = matrix.length;
            int n = matrix[0].length;

            int[] left = new int[n]; // initialize left as the leftmost boundary possible
            int[] right = new int[n];
            int[] height = new int[n];

            Arrays.fill(right, n); // initialize right as the rightmost boundary possible

            int maxarea = 0;
            for (int i = 0; i < m; i++) {
                int cur_left = 0, cur_right = n;
                // update height
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        height[j]++;
                    } else {
                        height[j] = 0;
                    }
                }
                // update left
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        left[j] = Math.max(left[j], cur_left);
                    } else {
                        left[j] = 0;
                        cur_left = j + 1;
                    }
                }
                // update right
                for (int j = n - 1; j >= 0; j--) {
                    if (matrix[i][j] == '1') {
                        right[j] = Math.min(right[j], cur_right);
                    } else {
                        right[j] = n;
                        cur_right = j;
                    }
                }
                // update area
                for (int j = 0; j < n; j++) {
                    maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
                }

            }
            return maxarea;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}