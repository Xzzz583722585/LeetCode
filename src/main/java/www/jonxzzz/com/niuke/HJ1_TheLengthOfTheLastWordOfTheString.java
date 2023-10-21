package www.jonxzzz.com.niuke;

import sun.applet.Main;

import java.util.Scanner;

/**
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 *
 * 示例1
 * 输入：
 * hello nowcoder
 * 输出：
 * 8
 * 说明：
 * 最后一个单词为nowcoder，长度为8
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/16 10:12
 */
public class HJ1_TheLengthOfTheLastWordOfTheString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            System.out.println(HJ1_TheLengthOfTheLastWordOfTheString.lengthOfLastWorld(in.nextLine()));
        }
    }

    public static int lengthOfLastWorld(String s) {
        // 1.从最后一个单词开始往前遍历
        // 2.计算单词长度
        int lastWorldLength = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                return lastWorldLength;
            }

            lastWorldLength++;
        }

        return lastWorldLength;
    }

}
