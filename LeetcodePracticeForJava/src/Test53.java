import java.util.Scanner;

/**
 * @author Mckay
 * @create 2020-09-27
 * @description
 **/

public class Test53 {

    /**
     * by qr jobdu 1008 2014-8-7(8) graph:shortest path
     */
    static int mind = Integer.MAX_VALUE;
    static int minp = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, m;
        n = scan.nextInt(); // number of node
        m = scan.nextInt(); // number of edge

        while (!(n == 0 && m == 0)) {
            int edgeD[][] = new int[n + 1][n + 1]; // node number is 1-->n
            int edgeP[][] = new int[n + 1][n + 1];

            boolean flag[] = new boolean[n + 1]; // flag node pass situation(不要忘记加一个标记数组记录节点是否被访问过，迷宫也一样)

            for (int i = 1; i < n + 1; i++) {
                flag[i] = false;
                for (int j = 1; j < n + 1; j++) {
                    edgeD[i][j] = 0; // 0 represent no edge
                }
            }

            for (int i = 0; i < m; i++) {
                int a = scan.nextInt();
                int b = scan.nextInt();

                edgeD[a][b] = scan.nextInt();
                edgeD[b][a] = edgeD[a][b];

                edgeP[a][b] = scan.nextInt();
                edgeP[b][a] = edgeP[a][b];
            }

            int s = scan.nextInt();
            int t = scan.nextInt();

            // dfs get the shortest path
            flag[s] = true;
            DFS(s, t, edgeD, edgeP, n, 0, 0, flag);

            //output result
            System.out.println(mind + " " + minp);

            mind = Integer.MAX_VALUE;  //!important
            minp = Integer.MAX_VALUE;

            n = scan.nextInt();
            m = scan.nextInt();


        }
    }

    private static void DFS(int a, int b, int[][] edgeD, int[][] edgeP, int n,
                            int d, int p, boolean flag[]) {
        if (a == b) {
            //在过程中就可以判断出来最小的，而无需返回再判断
            if (mind > d || (mind == d && minp > p)) {
                mind = d;
                minp = p;
            }
        } else {
            for (int i = 1; i < n + 1; i++) {
                if (edgeD[a][i] != 0 && !flag[i]) {  //flag[i]=false
                    flag[i] = true;
                    DFS(i, b, edgeD, edgeP, n, d + edgeD[a][i],
                            p + edgeP[a][i], flag);
                    flag[i] = false; //访问之后记得将状态变回来，无需创建一个一样大小的数组
                }
            }
        }
    }

}
