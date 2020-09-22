/**
 * @author Mckay
 * @create 2020-09-13
 * @description
 **/

import java.util.*;
public class Main {
    public static void main(String[] args) {
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