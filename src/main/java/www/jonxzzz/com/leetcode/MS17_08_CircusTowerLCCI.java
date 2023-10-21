package www.jonxzzz.com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/** todo
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。
 * 已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 *
 * 示例：
 * 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
 * 输出：6
 * 解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
 *
 * 提示：
 * height.length == weight.length <= 10000
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/18 16:58
 */
public class MS17_08_CircusTowerLCCI {

    public static void main(String[] args) {
        System.out.println(new MS17_08_CircusTowerLCCI().bestSeqAtIndex(
                new int[]{2868,5485,1356,1306,6017,8941,7535,4941,6331,6181},
                new int[]{5042,3995,7985,1651,5991,7036,9391,428,7561,8594}
        ));
    }

    public int bestSeqAtIndex(int[] height, int[] weight) {
        if (height == null || height.length == 0
                || weight == null || weight.length == 0) {
            return 0;
        }

        List<Man> mans = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            mans.add(new Man(height[i], weight[i]));
        }

        List<Man> sortedMans = mans.stream()
                .sorted(Comparator.comparing(Man::getHeight).thenComparing(Man::getWeight))
                .collect(Collectors.toList());

        // -1 - n
        int[] dp = new int[sortedMans.size() + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0;

        for (int pre = dp.length - 1; pre >= 0; pre--) {
            int max = 0;
            for (int now = pre + 1; now < dp.length; now++) {
                if (pre == 0 || (
                        sortedMans.get(pre - 1).height < sortedMans.get(now - 1).height
                     && sortedMans.get(pre - 1).weight < sortedMans.get(now - 1).weight)
                ) {
                    max = Math.max(max, dp[now] + 1);
                }
            }
            dp[pre] = max;
        }
        // search(sortedMans, -1)
        return dp[0];
    }

    private static class Man {
        int height;
        int weight;

        public Man(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWeight() {
            return this.weight;
        }
    }
}
