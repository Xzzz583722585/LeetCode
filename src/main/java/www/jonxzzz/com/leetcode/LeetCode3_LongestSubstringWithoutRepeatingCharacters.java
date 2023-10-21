package www.jonxzzz.com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/17 15:50
 */
public class LeetCode3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(new LeetCode3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("tmmzuxt"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        /*
         * 滑动窗口遍历字符串
         * 利用Map记录之前出现的每个字符及其下标
         * 遍历过程中使用Map查看当前字符有无出现过
         * 若没有，则记录该元素下标，继续移动右指针向后遍历并更新结果
         * 若有，则查看之前出现的下标，将左指针移到他的下一位，即跳过它，然后记录当前出现的下标，然后右指针继续向后遍历
         */
        int left = 0;
        int right = 0;
        int result = 0;
        Map<Character, Integer> letterAndIndex = new HashMap<>();
        char[] chars = s.toCharArray();
        while (right < chars.length) {
            char c = chars[right];

            if (letterAndIndex.containsKey(c) && letterAndIndex.get(c) >= left) {
                left = letterAndIndex.get(c) + 1;
            } else {
                result = Math.max(result, right - left + 1);
            }

            letterAndIndex.put(c, right);
            right++;
        }

        return result;
    }

}
