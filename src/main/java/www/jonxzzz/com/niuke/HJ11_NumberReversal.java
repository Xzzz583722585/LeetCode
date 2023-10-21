package www.jonxzzz.com.niuke;

import java.util.Scanner;

/**
 * 描述
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * 数据范围： 0≤n≤2^30−1
 *
 * 输入描述：
 * 输入一个int整数
 * 输出描述：
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入：
 * 1516000
 * 输出：
 * 0006151
 *
 * 示例2
 * 输入：
 * 0
 * 输出：
 * 0
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/16 20:58
 */
public class HJ11_NumberReversal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(HJ11_NumberReversal.reversalNumber(Integer.parseInt(in.nextLine())));
    }

    public static String reversalNumber(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 10);
            num /= 10;
        }

        return sb.toString();
    }
}
