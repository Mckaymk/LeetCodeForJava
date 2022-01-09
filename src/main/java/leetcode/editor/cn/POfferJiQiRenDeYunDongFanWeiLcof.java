//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 164 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//java:机器人的运动范围
public class POfferJiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new POfferJiQiRenDeYunDongFanWeiLcof().new Solution();
        //TO TEST
        System.out.println(solution.sumOfNum(35) + solution.sumOfNum(38));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int ans = 0;
        private int m;
        private int n;
        private int k;
        private boolean[][] visited;


        public int movingCount(int m, int n, int k) {
            this.visited = new boolean[m][n];
            this.m = m;
            this.n = n;
            this.k = k;
            dfs(0, 0);
            return ans;
        }

        private void dfs(int x, int y) {
            if (x < 0 || x >= m || y < 0 || y >= n || this.visited[x][y]) {
                return;
            }
            if (sumOfNum(x) + sumOfNum(y) > this.k) {
                return;
            }
            visited[x][y] = true;
            this.ans++;
            dfs(x + 1, y);
            dfs(x, y + 1);
        }

        private int movingCount01(int m, int n, int k) {
            if (k == 0) {
                return 1;
            }
            Queue<int[]> queue = new LinkedList<>();
            int[] dx = {0, 1};
            int[] dy = {1, 0};
            boolean[][] vis = new boolean[m][n];
            queue.offer(new int[]{0, 0});
            vis[0][0] = true;
            int ans = 1;
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int i = 0; i < 2; i++) {
                    int tx = dx[i] + x;
                    int ty = dy[i] + y;
                    if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || sumOfNum(tx) + sumOfNum(ty) > k) {
                        continue;
                    }
                    queue.offer(new int[]{tx, ty});
                    vis[tx][ty] = true;
                    ans++;
                }
            }
            return ans;
        }

        public int sumOfNum(int x) {
            int total = 0;
            while (x != 0) {
                total += x % 10;
                x /= 10;
            }
            return total;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}