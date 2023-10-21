package www.jonxzzz.com.niuke;

import java.util.Scanner;

/** todo
 * 描述
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 *
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 * 数据范围：字符串长度：
 * 1
 * ≤
 * �
 * ≤
 * 150
 *
 * 1≤s≤150
 * 进阶：时间复杂度：
 * �
 * (
 * �
 * 3
 * )
 *
 * O(n
 * 3
 *  ) ，空间复杂度：
 * �
 * (
 * �
 * )
 *
 * O(n)
 * 输入描述：
 * 输入两个只包含小写字母的字符串
 *
 * 输出描述：
 * 输出一个整数，代表最大公共子串的长度
 *
 * 示例1
 * 输入：
 * asdfas
 * werasdfaswer
 * 输出：
 * 6
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/16 23:48
 */
public class HJ75_LongestSubString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(HJ75_LongestSubString.LSS(s1, s2));
    }

    public static int LSS(String s1, String s2) {
        // todo DP

        int lss = 0;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i1 = 0; i1 < chars1.length; i1++) {
            for (int i2 = 0; i2 < chars2.length; i2++) {
                int index1 = i1;
                int index2 = i2;
                while (index1 < chars1.length && index2 < chars2.length && chars1[index1] == chars2[index2]) {
                    index1++;
                    index2++;
                }
                lss = Math.max(lss, index1 - i1);
            }
        }

        return lss;
    }
}
