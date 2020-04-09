//根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。 
//
// 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dea
//d）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律： 
//
// 
// 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
//// 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
//// 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
//// 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
////
//
// 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生
//和死亡是同时发生的。 
//
// 
//
// 示例： 
//
// 输入： 
//[
//  [0,1,0],
//  [0,0,1],
//  [1,1,1],
//  [0,0,0]
//]
//输出：
//[
//  [0,0,0],
//  [1,0,1],
//  [0,1,1],
//  [0,1,0]
//] 
//
// 
//
// 进阶： 
//
// 
// 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。 
// 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？ 
// 
// Related Topics 数组


package leetcode.editor.cn;

//java:生命游戏
public class P289GameOfLife {
    public static void main(String[] args) {
        Solution solution = new P289GameOfLife().new Solution();
        //TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public void gameOfLife(int[][] board) {

            int rows = board.length;
            int cols = board[0].length;

            int[] neighbour = {0, 1, -1};


            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {

                    int count = 0;

                    for (int m = 0; m < 3; m++) {
                        for (int n = 0; n < 3; n++) {
                            if (!(neighbour[m] == 0 && neighbour[n] == 0)) {
                                int r = row + neighbour[m];
                                int c = col + neighbour[n];
                                if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                    count += 1;
                                }
                            }
                        }
                    }

                    // 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                    //// 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；


                    if ((board[row][col] == 1) && (count < 2 || count > 3)) {
                        board[row][col] = -1;
                    }
                    //// 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                    if (board[row][col] == 0 && count == 3) {
                        board[row][col] = 2;
                    }
                    //// 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
                }
            }

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (board[row][col] > 0) {
                        board[row][col] = 1;
                    } else {
                        board[row][col] = 0;
                    }
                }
            }
        }


        public void gameOfLifeWithExtraSpace(int[][] board) {

            int rows = board.length;
            int cols = board[0].length;

            int[] neighbour = {0, 1, -1};


            int[][] copy = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                System.arraycopy(board[i], 0, copy[i], 0, cols);
            }


            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {

                    int count = 0;

                    for (int m = 0; m < 3; m++) {
                        for (int n = 0; n < 3; n++) {
                            if (!(neighbour[m] == 0 && neighbour[n] == 0)) {
                                int r = row + neighbour[m];
                                int c = col + neighbour[n];
                                if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copy[r][c] == 1)) {
                                    count += 1;
                                }
                            }
                        }
                    }

                    // 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                    //// 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；


                    if ((copy[row][col] == 1) && (count < 2 || count > 3)) {
                        board[row][col] = 0;
                    }
                    //// 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                    if (copy[row][col] == 0 && count == 3) {
                        board[row][col] = 1;
                    }
                    //// 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；


                }
            }


        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}