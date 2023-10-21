package www.jonxzzz.com.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述：
 * 给定一组闭区间，其中部分区间存在交集。任意两个给定区间的交集，称为公共区间（如：[1,2],[2,3]的公共区间为[2,2]，[3,5],[3,6]的公共区间为 [3,5]）。公共区间 之间若存在交集，则需要合并（如：[1,3],[3,5]区间存在交集[3,3]，须合并为[1,5])。按升序排列输出合并后的区间列表。
 *
 * 输入描述：
 *
 * 一组区间列表，
 * 区间数为 N： 0 <= N <= 1000；
 * 区间元素为 X： -10000 <= X <= 10000。
 * 输出描述：升序排列的合并后区间列表
 * 备注：
 *
 * 区间元素均为数字，不考虑字母、符号等异常输入。
 *
 * 单个区间认定为无公共区间。
 * 示例 1
 *
 * 输入:
 * 0 3
 * 1 3
 * 3 5
 * 3 6
 * 输出:
 * 1 5
 * 说明
 *
 * [0,3]和[1,3]的公共区间为[1,3]，[0,3]和[3,5]的公共区间为[3,3]，
 * [0,3]和[3,6]的公共区间为[3,3]，[1,3]和[3,5]的公共区间为[3,3]，
 * [1,3]和[3,6]的公共区间为[3,3]，[3,5]和[3,6]的公共区间为[3,5]，
 * 公共区间列表为[[1,3],[3,3],[3,5]]；[1,3],[3,3],[3,5]存在交集，须合并为[1,5]。
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/20 21:11
 */
public class IntervalIntersection {
    public static void main(String[] args) {
        int[][] result1 = IntervalIntersection.intervalIntersection(new int[][]{
                new int[]{0, 3},
                new int[]{1, 3},
                new int[]{3, 5},
                new int[]{3, 6},
        });
        System.out.println();

        int[][] result2 = IntervalIntersection.intervalIntersection(new int[][]{
                new int[]{0, 3},
                new int[]{1, 4},
                new int[]{4, 7},
                new int[]{5, 8},
        });
        System.out.println();
    }

    public static int[][] intervalIntersection(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }

        // 1.排序
        Arrays.sort(intervals, Comparator.<int[], Integer>comparing(t -> t[0]).thenComparing(t -> t[1]));

        // 2.求交集
        List<int[]> intersections = new LinkedList<>();
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                int[] a = intervals[i];
                int[] b = intervals[j];
                if (b[0] <= a[1]) {
                    intersections.add(new int[]{b[0], a[1]});
                }
            }
        }
        if (intersections.size() <= 1) {
            return intersections.toArray(new int[][]{});
        }
        intersections.sort(Comparator.<int[], Integer>comparing(t -> t[0]).thenComparing(t -> t[1]));

        // 3.合并交集
        List<int[]> unions = new LinkedList<>();
        int i = 1;
        int[] pre = intersections.get(0);
        while (i < intersections.size()) {
            int[] now = intersections.get(i++);
            if (now[0] <= pre[1]) {
                pre = new int[]{pre[0], now[1]};
            } else {
                unions.add(pre);
                pre = now;
            }
        }
        unions.add(pre);

        return unions.toArray(new int[][]{});
    }
}
