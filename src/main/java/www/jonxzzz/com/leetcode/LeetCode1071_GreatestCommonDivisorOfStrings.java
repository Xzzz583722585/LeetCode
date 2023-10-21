package www.jonxzzz.com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 *
 * 示例 1：
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 *
 * 示例 2：
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 *
 * 示例 3：
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *
 * 提示：
 * 1 <= str1.length, str2.length <= 1000
 * str1 和 str2 由大写英文字母组成
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/18 15:17
 */
public class LeetCode1071_GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        System.out.println(new LeetCode1071_GreatestCommonDivisorOfStrings().gcdOfStrings(
                "ABABAB",
                "ABAB"
        ));
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str1.length() == 0
                || str2 == null || str2.length() == 0) {
            return "";
        }

//        PrefixTree prefixTree = new PrefixTree();
//        prefixTree.add(str1);
//        prefixTree.add(str2);
//        String prefix = prefixTree.getLongestPrefix();
//        if ((prefix.length() & 1) == 1) {
//            return "";
//        }

        String shortStr = str1.length() <= str2.length() ? str1 : str2;
        for (int l = shortStr.length(); l >= 1; l -= 1) {
            String tmp = shortStr.substring(0, l);
            if (check(tmp, str1) && check(tmp, str2)) {
                return tmp;
            }
        }
        return "";
    }

    private boolean check(String factor, String target) {
        if (target.length() % factor.length() != 0) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length() / factor.length(); i++) {
            sb.append(factor);
        }
        return target.equals(sb.toString());
    }

    private static class PrefixTree {
        TreeNode head = new TreeNode(null);
        int wordCount = 0;

        public void add(String word) {
            wordCount++;
            if (word == null || word.length() == 0) {
                return;
            }

            TreeNode now = this.head;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!now.next.containsKey(c)) {
                    now.next.put(c, new TreeNode(c));
                }

                now = now.next.get(c);
                now.visited++;
            }
        }

        public String getLongestPrefix() {
            return search(this.head);
        }

        private String search(TreeNode now) {
            if (now == null) {
                return "";
            }

            for (TreeNode next: now.next.values()) {
                if (next.visited == this.wordCount) {
                    return now.getC() + search(next);
                }
            }
            return now.getC();
        }
    }

    private static class TreeNode {
        Character c;
        Map<Character, TreeNode> next = new HashMap<>();
        int visited = 0;

        public TreeNode(Character c) {
            this.c = c;
        }

        public String getC() {
            return this.c == null ? "" : this.c + "";
        }
    }
}
