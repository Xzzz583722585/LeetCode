package www.jonxzzz.com.niuke;

import java.util.Scanner;

/**
 * 描述
 * 判断短字符串S中的所有字符是否在长字符串T中全部出现。
 * 请注意本题有多组样例输入。
 * 数据范围:1≤len(S),len(T)≤200
 * 进阶：时间复杂度：O(n) ，空间复杂度：O(n)
 *
 * 输入描述：
 * 输入两个字符串。第一个为短字符串，第二个为长字符串。两个字符串均由小写字母组成。
 * 输出描述：
 * 如果短字符串的所有字符均在长字符串中出现过，则输出字符串"true"。否则输出字符串"false"。
 *
 * 示例1
 * 输入：
 * bc
 * abc
 * 输出：
 * true
 * 说明：
 * 其中abc含有bc，输出"true"
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/18 09:22
 */
public class HJ81_StringCharacterMatch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String shortStr = in.nextLine();
        String longStr = in.nextLine();
        System.out.println(HJ81_StringCharacterMatch.match(shortStr, longStr));
    }

    private static boolean match(String shortStr, String longStr) {
        char[] shortChars = shortStr.toCharArray();
        int[] shortCharsAppeared = new int[26];
        for (char c: shortChars) {
            shortCharsAppeared[c - 97]++;
        }

        char[] longChars = longStr.toCharArray();
        int[] longCharsAppeared = new int[26];
        for (char c: longChars) {
            longCharsAppeared[c - 97]++;
        }

        for (int i = 0; i < 26; i++) {
            if (shortCharsAppeared[i] > 0 && longCharsAppeared[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
