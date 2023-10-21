package www.jonxzzz.com.leetcode;

import java.util.Scanner;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 *
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 * 提示：
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/18 08:46
 */
public class LeetCode28_FindFirstIndexString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String shortStr = in.nextLine();
        String longStr = in.nextLine();
        System.out.println(LeetCode28_FindFirstIndexString.find(longStr, shortStr) != -1);
    }

    /**
     * 搜索str2在str1中首次完整出现的下标
     */
    private static int find(String str1, String str2) {
        if (str1 == null || str1.length() == 0
                || str2 == null || str2.length() == 0) {
            return -1;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        // str2中，该下标之前的子串中，前缀字符串与后缀字符串相同的最长长度
        int[] next = next(chars2);
        int i1 = 0;
        int i2 = 0;
        while (i1 < chars1.length && i2 < chars2.length) {
            if (chars1[i1] == chars2[i2]) {
                i1++;
                i2++;
            } else if (i2 == 0) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }

        return i2 == chars2.length ? i1 - chars2.length : -1;
    }

    private static int[] next(char[] str) {
        if (str.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        if (str.length == 2) {
            return next;
        }

        for (int i = 2; i < str.length; i++) {
            int j = i - 1;
            while (j > 0 && str[i - 1] != str[next[j]]) {
                j = next[j];
            }

            next[i] = j == 0 ? 0 : next[j] + 1;
        }

        return next;
    }
}
