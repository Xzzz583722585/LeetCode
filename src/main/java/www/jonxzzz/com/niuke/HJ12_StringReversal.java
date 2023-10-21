package www.jonxzzz.com.niuke;

import java.util.Scanner;

/**
 * 描述
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * 输入描述：
 * 输入一行，为一个只包含小写字母的字符串。
 * 输出描述：
 * 输出该字符串反转后的字符串。
 *
 * 示例1
 * 输入：
 * abcd
 * 输出：
 * dcba
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/16 21:03
 */
public class HJ12_StringReversal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(HJ12_StringReversal.stringReversal(in.nextLine()));
    }

    public static String stringReversal(String origin) {
        if (origin == null || origin.isEmpty()) {
            return "";
        }

        StringBuilder reversal = new StringBuilder();
        for (char c: origin.toCharArray()) {
            reversal.insert(0, c);
        }
        return reversal.toString();
    }
}
