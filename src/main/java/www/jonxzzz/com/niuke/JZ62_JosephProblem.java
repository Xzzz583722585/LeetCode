package www.jonxzzz.com.niuke;

import java.util.ArrayList;
import java.util.List;

/** todo
 * 描述:
 * 每年六一儿童节，牛客都会准备一些小礼物和小游戏去看望孤儿院的孩子们。
 * 其中，有个游戏是这样的：首先，让 n 个小朋友们围成一个大圈，小朋友们的编号是0~n-1。
 * 然后，随机指定一个数 m ，让编号为0的小朋友开始报数。
 * 每次喊到 m-1 的那个小朋友要出列唱首歌，然后可以在礼品箱中任意的挑选礼物，并且不再回到圈中，
 * 从他的下一个小朋友开始，继续0... m-1报数....这样下去....
 * 直到剩下最后一个小朋友，可以不用表演，并且拿到牛客礼品，请你试着想下，哪个小朋友会得到这份礼品呢？
 *
 * 数据范围：1≤n≤5000，1≤m≤10000
 * 要求：空间复杂度 O(1)，时间复杂度 O(n)
 *
 * 示例1
 * 输入：
 * 5,3
 * 返回值：
 * 3
 *
 * 示例2
 * 输入：
 * 2,3
 * 返回值：
 * 1
 * 说明：
 * 有2个小朋友编号为0，1，第一次报数报到3的是0号小朋友，0号小朋友出圈，1号小朋友得到礼物
 *
 * 示例3
 * 输入：
 * 10,17
 * 返回值：
 * 2
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/17 15:27
 */
public class JZ62_JosephProblem {
    public static void main(String[] args) {
        System.out.println(new JZ62_JosephProblem().LastRemaining_Solution(10, 17));
    }

    public int LastRemaining_Solution(int n, int m) {
        List<String> nums = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nums.add(i + "");
        }
        return Integer.parseInt(search(nums, 0, m));
    }

    private String search(List<String> nums, int startIndex, int m) {
        if (nums.size() == 1) {
            return nums.get(0);
        }

        int deleteIndex = (startIndex + m - 1) % nums.size();
        nums.remove(deleteIndex);
        return search(nums, deleteIndex, m);
    }
}
