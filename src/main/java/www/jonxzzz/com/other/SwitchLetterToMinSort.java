package www.jonxzzz.com.other;

/**
 * 给定一个字符串s，最多只能进行一次变换，返回变换后能得到的最小字符串（按照字典序进行比较）
 * 变换规则：交换字符串中任意两个不同位置的字符
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/20 20:27
 */
public class SwitchLetterToMinSort {

    public static void main(String[] args) {
        System.out.println(SwitchLetterToMinSort.change("adfegbc"));
    }

    public static String change(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] > chars[j]) {
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                    return String.valueOf(chars);
                }
            }
        }

        return s;
    }
}
