package www.jonxzzz.com.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 * 数据范围：输入的数据满足 4≤n≤1000
 *
 * 输入描述：
 * 输入一个大于2的偶数
 * 输出描述：
 * 从小到大输出两个素数
 *
 * 示例1
 * 输入：
 * 20
 * 输出：
 * 7
 * 13
 *
 * 示例2
 * 输入：
 * 4
 * 输出：
 * 2
 * 2
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/17 11:25
 */
public class HJ60_TwoPrimeNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] result = HJ60_TwoPrimeNumber.twoPrimeNumber(in.nextInt());
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] twoPrimeNumber(int n) {
        List<Integer> allPrimes = allPrimes(n);
        int left = 0;
        int right = allPrimes.size() - 1;
        int[] result = null;
        while (left <= right) {
            if (allPrimes.get(left) + allPrimes.get(right) == n) {
                result = new int[]{allPrimes.get(left), allPrimes.get(right)};
                left++;
            } else if (allPrimes.get(left) + allPrimes.get(right) < n) {
                left++;
            } else if (allPrimes.get(left) + allPrimes.get(right) > n) {
                right--;
            }
        }

        return result;
    }

    private static List<Integer> allPrimes(int n) {
        boolean[] isNotPrimes = new boolean[n + 1];
        List<Integer> allPrimes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!isNotPrimes[i]) {
                allPrimes.add(i);
                for (int j = i * i; j <= n; j += i) {
                    isNotPrimes[j] = true;
                }
            }
        }

        return allPrimes;
    }
}
