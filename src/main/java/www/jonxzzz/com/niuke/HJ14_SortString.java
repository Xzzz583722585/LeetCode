package www.jonxzzz.com.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述
 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
 * 数据范围：1≤n≤1000  ，字符串长度满足 1≤len≤100
 *
 * 输入描述：
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述：
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 *
 * 示例1
 * 输入：
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 * 输出：
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/17 11:48
 */
public class HJ14_SortString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<String> strList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            strList.add(in.nextLine());
        }
        HJ14_SortString.sort(strList);
        for (int i = 0; i < n; i++) {
            System.out.println(strList.get(i));
        }
    }

    /**
     * 基数排序
     */
    public static void sort(List<String> strList) {
        // 空
        List<String> empty = new ArrayList<>();
        // 大写桶 A-Z
        List<List<String>> upper = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            upper.add(i, new ArrayList<>());
        }
        // 小写桶 a-z
        List<List<String>> lower = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            lower.add(i, new ArrayList<>());
        }

        // 计算最长字符串长度
        int maxLength = 0;
        for (String str: strList) {
            maxLength = Math.max(maxLength, str.length());
        }

        for (int i = maxLength - 1; i >= 0; i--) {
            // 按基数分桶
            for (String str: strList) {
                Character c = i >= str.length() ? null : str.charAt(i);
                if (c == null) {
                    empty.add(str);
                } else if (c < 97) {
                    upper.get(c - 65).add(str);
                } else {
                    lower.get(c - 97).add(str);
                }
            }

            // 收集
            strList.clear();
            strList.addAll(empty);
            empty.clear();
            for (int j = 0; j < 26; j++) {
                strList.addAll(upper.get(j));
                upper.get(j).clear();
            }
            for (int j = 0; j < 26; j++) {
                strList.addAll(lower.get(j));
                lower.get(j).clear();
            }
        }
    }
}
