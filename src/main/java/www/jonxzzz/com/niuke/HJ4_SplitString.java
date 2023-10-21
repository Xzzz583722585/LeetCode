package www.jonxzzz.com.niuke;

import java.util.Scanner;

/**
 * 描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 *
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 *
 * 示例1
 * 输入：
 * abc
 * 输出：
 * abc00000
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/16 10:54
 */
public class HJ4_SplitString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String[] result = HJ4_SplitString.split(in.nextLine(), 8);
            for (String r: result) {
                System.out.println(r);
            }
        }
    }

    public static String[] split(String s, int length) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }

        String[] result = new String[s.length() / length + (s.length() % length == 0 ? 0 : 1)];
        for (int i = 0; i < s.length(); i += length) {
            result[i / length] = s.substring(i, Math.min(i + length, s.length()));
        }

        StringBuilder lastWorld = new StringBuilder(result[result.length - 1]);
        int lwl = lastWorld.length();
        if (lwl < length) {
            for (int i = 0; i < length - lwl; i++) {
                lastWorld.append("0");
            }
        }
        result[result.length - 1] = lastWorld.toString();

        return result;
    }
}
