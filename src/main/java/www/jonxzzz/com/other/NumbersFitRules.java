package www.jonxzzz.com.other;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个正整数数组，检查数组中是否存在满足规则的数字组合。规则： A = B + 2C。存在输入a，b，c，不存在输出0
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/20 20:10
 */
public class NumbersFitRules {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] nums = new int[n];
        String[] numStr = in.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
        }

        int[] result = NumbersFitRules.numberFitRules(nums);
        if (result == null) {
            System.out.println("0");
            return;
        }
        String[] resultStr = new String[3];
        for (int i = 0; i < 3; i++) {
            resultStr[i] = result[i] + "";
        }
        System.out.println(String.join(" ", resultStr));
    }

    public static int[] numberFitRules(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }

        Arrays.sort(nums);
        for (int ia = 2; ia < nums.length; ia++) {
            int ib1 = 0;
            int ic1 = ia - 1;
            while (ib1 < ic1) {
                if (nums[ib1] + 2 * nums[ic1] == nums[ia]) {
                    return new int[]{nums[ia], nums[ib1], nums[ic1]};
                } else if (nums[ib1] + 2 * nums[ic1] < nums[ia]) {
                    ib1++;
                } else {
                    ic1--;
                }
            }

            int ic2 = 0;
            int ib2 = ia - 1;
            while (ic2 < ib2) {
                if (nums[ic2] + 2 * nums[ib2] == nums[ia]) {
                    return new int[]{nums[ia], nums[ic2], nums[ib2]};
                } else if (nums[ib1] + 2 * nums[ic1] < nums[ia]) {
                    ic2++;
                } else {
                    ib2--;
                }
            }
        }

        return null;
    }
}
