package www.jonxzzz.com.leetcode;

import java.util.Stack;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/18 14:44
 */
public class LeetCode581_ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
//        System.out.println(new LeetCode581_ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{
//                1,3,2,2,2,3,4
//        }));
    }

//    public int findUnsortedSubarray(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int left = -1;
//        int right = -1;
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    if (left == -1) {
//                        left = i;
//                    }
//                    right = Math.max(right, j);
//                }
//            }
//        }
//
//        return right == -1 ? 0 : right - left + 1;
//    }

    // todo 重复元素问题 1,3,2,2,2
//    public int findUnsortedSubarray(int[] nums) {
//    }

}
