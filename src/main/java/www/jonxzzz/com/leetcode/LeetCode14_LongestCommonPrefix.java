package www.jonxzzz.com.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/17 16:09
 */
public class LeetCode14_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"b",""};
        System.out.println(new LeetCode14_LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        PrefixTree prefixTree = new PrefixTree();
        for (String str: strs) {
            prefixTree.add(str);
        }
        String r = prefixTree.findLongestPrefix();
        return "".equals(r) ? "" : r.substring(1);
    }

    private static class PrefixTree {
        TreeNode head;
        int wordCount;

        public PrefixTree() {
            this.head = new TreeNode(' ');
            this.wordCount = 0;
        }

        public void add(String word) {
            wordCount++;
            if (word == null || word.length() == 0) {
                return;
            }

            TreeNode now = this.head;
            char[] letters = word.toCharArray();
            for (int i = 0; i <= letters.length; i++) {
                now.visited++;
                if (i == letters.length) {
                    break;
                }

                int c = letters[i] - 97;
                if (now.next[c] == null) {
                    now.next[c] = new TreeNode(letters[i]);
                }

                if (i == letters.length - 1) {
                    now.next[c].end++;
                }
                now = now.next[c];
            }
        }

        public String findLongestPrefix() {
            if (wordCount == 0) {
                return "";
            }

            return search(this.head);
        }

        public String search(TreeNode now) {
            if (now.visited < this.wordCount) {
                return "";
            }

            String result = "";
            for (TreeNode next: now.next) {
                if (next != null) {
                    String r = search(next);
                    if (r.length() > result.length()) {
                        result = r;
                    }
                }
            }
            return now.c + result;
        }
    }

    private static class TreeNode {
        // 本节点代表字符
        char c;
        // 路径字符
        TreeNode[] next = new TreeNode[26];
        // 经过本节点的字符串个数
        int visited = 0;
        // 以本节点结尾的字符串个数
        int end = 0;

        public TreeNode(char c) {
            this.c = c;
        }
    }
}
