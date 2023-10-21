package www.jonxzzz.com.niuke;

import java.util.Scanner;

/** todo
 * 描述
 * 给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
 * 所谓回文串，指左右对称的字符串。
 * 所谓子串，指一个字符串删掉其部分前缀和后缀（也可以不删）的字符串
 * 数据范围：字符串长度 1≤s≤350
 * 进阶：时间复杂度：O(n) ，空间复杂度：O(n)
 *
 * 输入描述：
 * 输入一个仅包含小写字母的字符串
 * 输出描述：
 * 返回最长回文子串的长度
 *
 * 示例1
 * 输入：
 * cdabbacc
 * 输出：
 * 4
 * 说明：
 * abba为最长的回文子串
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/18 07:50
 */
public class HJ85_LongestReturnSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(HJ85_LongestReturnSubstring.longestReturnSubstring(in.nextLine()));
    }

    public static int longestReturnSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        // abc -> #a#b#c#
        char[] chars = prepare(str).toCharArray();
        // 最右回文子串中心点
        int point = 1;
        // 最右回文子串右边界
        int right = 2;
        // 以该点字符为中心的回文子串半径
        int[] returnStrRadius = new int[chars.length];
        returnStrRadius[0] = 1;
        returnStrRadius[1] = 2;
        // 最长回文子串长度（过滤掉添加字符#后的结果）
        int result = -1;
        for (int i = 2; i < chars.length; i++) {
            // 以point为中心，当前坐标i在point左边的对称下标
            int j = 2 * point - i;
            // 暴力搜索开始的半径长度
            int startRadius = i > right ? 1 : Math.min(returnStrRadius[j], right - i + 1);
            // 暴力搜以当前点为中心的最长回文子串半径
            int radius = search(chars, i, startRadius);

            if (i + radius - 1 > right) {
                right = i + radius - 1;
                point = i;
            }
            returnStrRadius[i] = radius;
            result = Math.max(result, returnStrRadius[i] - 1);
        }

        return result;
    }

    private static String prepare(String str) {
        return "#" + String.join("#", str.split("")) + "#";
    }

    private static int search(char[] chars, int point, int r) {
        while (point - r >= 0
                && point + r < chars.length
                && chars[point - r] == chars[point + r]) {
            r++;
        }
        return r;
    }
}
