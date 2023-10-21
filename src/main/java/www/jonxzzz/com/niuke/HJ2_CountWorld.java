package www.jonxzzz.com.niuke;

import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 * 数据范围：
 * 1 ≤ n ≤ 1000
 * 输入描述：
 * 第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 *
 * 示例1
 * 输入：
 * ABCabc
 * A
 * 输出：
 * 2
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/16 10:33
 */
public class HJ2_CountWorld {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String s = in.nextLine();
            // 为了对比时忽略大小写，处理为全小写
            String target = in.nextLine().toLowerCase();
            System.out.println(HJ2_CountWorld.countWorld(s, target.charAt(0)));
        }
    }

    public static int countWorld(String s, char target) {
        char[] chars = s.toLowerCase().toCharArray();

        int count = 0;
        for (char c: chars) {
            if (c == target) {
                count++;
            }
        }

        return count;
    }
}
