/**
 * @author Mckay
 * @create 2020-09-13
 * @description
 **/

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        testScanner();
//        candy();
//        testSheep();
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < n; j++) {
            int x = 0;
            int y = j;
            while (x >= 0 && x < m && y >= 0 && y < n) {
                stringBuilder.append(arr[x][y]);
                stringBuilder.append(',');
                x++;
                y--;
            }
        }
        for (int i = 1; i < m; i++) {
            int x = i;
            int y = n - 1;
            while (x >= 0 && x < m && y >= 0 && y < n) {
                stringBuilder.append(arr[x][y]);
                stringBuilder.append(',');
                x++;
                y--;
            }
        }
        System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
    }

    private static void testSheep() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int s = in.nextInt();
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        while (n > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int tmp = list.get(i);
                if (tmp == -1) {
                    continue;

                }
                tmp++;
                if (tmp == s) {
                    list.set(i, -1);
                } else if (tmp == a || tmp == b) {
                    list.add(0);
                    list.set(i, tmp);
                } else {
                    list.set(i, tmp);
                }
            }
            n--;
        }
        int count = 0;
        System.out.println(list.size());
        for (int k : list) {
            if (k != -1) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void candy() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 1;
        int total = 0;
        while (total <= n) {
            total += count++;
        }
        if (total == n) {
            System.out.println(count - 1);
        } else {
            System.out.println(count - 2);
        }
    }

    private static void testScanner() {
        Scanner in = new Scanner(System.in);
        String[] splits = in.nextLine().split(" ");
        int[] nums = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            nums[i] = Integer.parseInt(splits[i]);
        }
        Arrays.sort(nums);
        //双指针
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            //两边搜索
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    //小于0则左指针移动
                    while (left < right && nums[left] == nums[++left]) {
                    }
                } else if (sum > 0) {
                    //大于0，则右指针移动
                    while (left < right && nums[right] == nums[--right]) {
                    }
                } else {
                    //相等则输出
                    ans.add(nums[i] + " " + nums[left] + " " + nums[right]);
                    while (left < right && nums[left] == nums[++left]) {
                    }
                    while (left < right && nums[right] == nums[--right]) {
                    }
                }
            }
            for (String an : ans) {
                System.out.println(an);
            }
        }
    }
}