package www.jonxzzz.com.niuke;

import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * 数据范围：保证结果在 1≤n≤2^31-1
 * 输入描述：
 * 输入一个十六进制的数值字符串。
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 *
 * 示例1
 * 输入：
 * 0xAA
 * 输出：
 * 170
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/16 11:09
 */
public class HJ5_BasConvert {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNextLine()) {
            System.out.println(HJ5_BasConvert.baseConvert(in.nextLine()));
        }
    }

    public static int baseConvert(String s) {
        int base = 1;
        int result = 0;
        char[] nums = s.toCharArray();
        for (int i = nums.length - 1; i >= 2; i--) {
            result += base * getNum(nums[i]);
            base *= 16;
        }

        return result;
    }

    private static int getNum(char c) {
        if (c >= 48 && c <= 57) {
            return c - 48;
        } else if (c >= 97 && c <= 122) {
            return c - 97 + 10;
        }
        if (c >= 65 && c <= 90) {
            return c - 65 + 10;
        }
        return c;
    }
}
