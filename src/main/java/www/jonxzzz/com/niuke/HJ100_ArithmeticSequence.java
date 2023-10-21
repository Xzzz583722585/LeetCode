package www.jonxzzz.com.niuke;

import java.util.Scanner;

/**
 * 描述
 * 等差数列 2，5，8，11，14。。。。
 * （从 2 开始的 3 为公差的等差数列）
 * 输出求等差数列前n项和
 * 数据范围： 1≤n≤1000
 *
 * 输入描述：
 * 输入一个正整数n。
 * 输出描述：
 * 输出一个相加后的整数。
 *
 * 示例1
 * 输入：
 * 2
 * 输出：
 * 7
 * 说明：
 * 2+5=7
 *
 * 示例2
 * 输入：
 * 275
 * 输出：
 * 113575
 * 说明：
 * 2+5+...+821+824=113575
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/17 00:17
 */
public class HJ100_ArithmeticSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(HJ100_ArithmeticSequence.sum(in.nextInt()));
    }

    public static int sum(int n) {
        return n * 2 + (n * (n - 1) >> 1) * 3;
    }
}
