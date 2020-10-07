import java.util.Scanner;

/**
 * @author Mckay
 * @create 2020-09-20
 * @description
 **/
public class StaticStuff {

    public static void main(String[] args) {
    }

    private static void test2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int[] dp = new int[s.length()];
        if (s.charAt(0) == 'E') {
            dp[0] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                dp[i] = Math.max(1, dp[i - 1] + 1);
            } else {
                dp[i] = Math.max(-1, dp[i - 1] - 1);
            }
        }
        int maxValue = dp[0];
        for (int i : dp) {
            maxValue = Math.max(maxValue, i);
        }
        System.out.println(maxValue);
    }

    private static void test1() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int xS = in.nextInt();
        int yS = in.nextInt();
        int xT = in.nextInt();
        int yT = in.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = in.nextInt();
            }
        }
    }
}
