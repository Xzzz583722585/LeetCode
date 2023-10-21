package www.jonxzzz.com.leetcode;

import java.util.*;

/**
 * @Author: xiaoqizong
 * @Date: 2023/10/18 16:30
 */
public class LeetCode1111_MaxNestingDepth {
    public static void main(String[] args) {
        int[] r = new LeetCode1111_MaxNestingDepth().maxDepthAfterSplit("((())())()");
        System.out.println();
    }

    public int[] maxDepthAfterSplit(String seq) {
        if (seq ==  null || seq.length() == 0) {
            return new int[]{};
        }

        // 左括号下标
        Stack<Integer> left = new Stack<>();
        Map<Integer, List<Node>> depth2NodeMap = new HashMap<>();
        double maxDepth = 0.0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                left.push(i);
            } else {
                int depth = left.size();
                maxDepth = Math.max(maxDepth, depth);

                Node node = new Node();
                node.left = left.pop();
                node.right = i;

                if (!depth2NodeMap.containsKey(depth)) {
                    depth2NodeMap.put(depth, new ArrayList<>());
                }
                depth2NodeMap.get(depth).add(node);
            }
        }

        int[] result = new int[seq.length()];
        for (Map.Entry<Integer, List<Node>> e: depth2NodeMap.entrySet()) {
            if (e.getKey() > Math.ceil(maxDepth / 2)) {
                for (Node node: e.getValue()) {
                    result[node.left] = 1;
                    result[node.right] = 1;
                }
            }
        }

        return result;
    }

    private static class Node {
        int left;
        int right;
    }
}
