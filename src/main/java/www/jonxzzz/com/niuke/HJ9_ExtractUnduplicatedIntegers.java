package www.jonxzzz.com.niuke;

import java.util.Scanner;

/**
 * 描述
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 * 数据范围： 1≤n≤10^8
 *
 * 输入描述：
 * 输入一个int型整数
 * 输出描述：
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入：
 * 9876673
 * 输出：
 * 37689
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/16 18:55
 */
public class HJ9_ExtractUnduplicatedIntegers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(HJ9_ExtractUnduplicatedIntegers.extractUnduplicatedIntegers(Integer.parseInt(in.nextLine())));
    }

    public static int extractUnduplicatedIntegers(int origin) {
        // 是否使用过该因子
        boolean[] bases = new boolean[10];
        int result = 0;
        while (origin > 0) {
            int num = origin % 10;
            if (!bases[num]) {
                result = result * 10 + num;
                bases[num] = true;
            }

            origin /= 10;
        }

        return result;
    }
}
