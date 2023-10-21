package www.jonxzzz.com.niuke;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 描述
 * 输入n个整数，找出其中最小的k个整数并按升序输出
 * 本题有多组输入样例
 * 数据范围：1≤n≤1000  ，输入的整数满足1≤val≤10000
 *
 * 输入描述：
 * 第一行输入两个整数n和k
 * 第二行输入一个整数数组
 * 输出描述：
 * 从小到大输出最小的k个整数，用空格分开。
 *
 * 示例1
 * 输入：
 * 5 2
 * 1 3 5 7 2
 * 输出：
 * 1 2
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/17 12:32
 */
public class HJ58_MinKth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] l1 = in.nextLine().split(" ");
        int n = Integer.parseInt(l1[0]);
        int k = Integer.parseInt(l1[1]);
        String[] l2 = in.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(l2[i]);
        }

        int[] result = HJ58_MinKth.minKth(nums, k);
        String[] resultStr = new String[result.length];
        for (int i = 0; i < result.length; i++) {
            resultStr[i] = result[i] + "";
        }
        System.out.println(String.join(" ", resultStr));
    }

    public static int[] minKth(int[] nums, int k) {
        // 大根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int num: nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else if (num < heap.peek()) {
                heap.poll();
                heap.add(num);
            }
        }

        int[] result = new int[k];
        for (int i = heap.size() - 1; !heap.isEmpty(); i--) {
            result[i] = heap.poll();
        }
        return result;
    }
}
