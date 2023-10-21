package www.jonxzzz.com.niuke;

import java.util.Scanner;

/**
 * 描述
 * 将一个字符串str的内容颠倒过来，并输出。
 * 数据范围：1≤len(str)≤10000
 *
 * 输入描述：
 * 输入一个字符串，可以有空格
 * 输出描述：
 * 输出逆序的字符串
 *
 * 示例1
 * 输入：
 * I am a student
 * 输出：
 * tneduts a ma I
 *
 * 示例2
 * 输入：
 * nowcoder
 * 输出：
 * redocwon
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/16 22:48
 */
public class HJ106_StringReversal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(HJ106_StringReversal.reverse(in.nextLine()));
    }

    public static String reverse(String origin) {
        StringBuilder reverse = new StringBuilder();
        char[] chars = origin.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            reverse.append(chars[i]);
        }

        return reverse.toString();
    }
}
