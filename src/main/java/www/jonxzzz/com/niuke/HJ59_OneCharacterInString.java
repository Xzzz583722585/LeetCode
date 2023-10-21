package www.jonxzzz.com.niuke;

import java.util.*;

/**
 * 描述
 * 找出字符串中第一个只出现一次的字符
 * 数据范围：输入的字符串长度满足 1≤n≤1000
 *
 * 输入描述：
 * 输入一个非空字符串
 * 输出描述：
 * 输出第一个只出现一次的字符，如果不存在输出-1
 *
 * 示例1
 * 输入：
 * asdfasdfo
 * 输出：
 * o
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/17 12:16
 */
public class HJ59_OneCharacterInString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(HJ59_OneCharacterInString.search(in.nextLine()));
    }

    public static String search(String s) {
        if (s == null || s.length() == 0) {
            return "-1";
        }

        // 出现过的字符
        Set<Character> appeared = new HashSet<>();
        // 只出现过一次的字符（按出现顺序排序）
        Set<Character> one = new LinkedHashSet<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (appeared.contains(c)) {
                if (one.contains(c)) {
                    one.remove(c);
                }
            } else {
                appeared.add(c);
                one.add(c);
            }
        }

        if (one.isEmpty()) {
            return "-1";
        } else {
            return one.stream()
                    .findFirst()
                    .map(character -> character + "")
                    .orElse("-1");
        }
    }
}
