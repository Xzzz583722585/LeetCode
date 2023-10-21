package www.jonxzzz.com.niuke;

import java.util.Scanner;

/**
 * 描述
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 * 数据范围：输入的字符串长度满足 1≤n≤1000
 *
 * 输入描述：
 * 输入一行字符串，可以有空格
 * 输出描述：
 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
 *
 * 示例1
 * 输入：
 * 1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
 * 输出：
 * 26
 * 3
 * 10
 * 12
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/17 11:41
 */
public class HJ40_StatisticCharacter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] result = HJ40_StatisticCharacter.statistic(in.nextLine());
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
    }

    public static int[] statistic(String s) {
        int[] result = new int[4];
        for (char c: s.toCharArray()) {
            if (isLetter(c)) {
                result[0]++;
            } else if (c == ' ') {
                result[1]++;
            } else if (isDigit(c)) {
                result[2]++;
            } else {
                result[3]++;
            }
        }

        return result;
    }

    private static boolean isLetter(char c) {
        return (c >= 97 && c <= 122) || (c >= 65 && c<= 90);
    }

    private static boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }
}
