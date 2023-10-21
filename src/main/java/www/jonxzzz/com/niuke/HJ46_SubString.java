package www.jonxzzz.com.niuke;

import java.util.Scanner;

/**
 * 描述
 * 输入一个字符串和一个整数 k ，截取字符串的前k个字符并输出
 * 数据范围：字符串长度满足 1≤n≤1000，1≤k≤n
 *
 * 输入描述：
 * 1.输入待截取的字符串
 * 2.输入一个正整数k，代表截取的长度
 * 输出描述：
 * 截取后的字符串
 *
 * 示例1
 * 输入：
 * abABCcDEF
 * 6
 * 输出：
 * abABCc
 *
 * 示例2
 * 输入：
 * bdxPKBhih
 * 6
 * 输出：
 * bdxPKB
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/17 11:00
 */
public class HJ46_SubString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int length = Integer.parseInt(in.nextLine());
        System.out.println(HJ46_SubString.subString("12345", 4));
    }

    public static String subString(String s, int length) {
        return s.substring(0, length);
    }
}
