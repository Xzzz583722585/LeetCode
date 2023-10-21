package www.jonxzzz.com.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/** todo
 * 描述
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 * 例如：
 * 1^3=1
 * 2^3=3+5
 * 3^3=7+9+11
 * 4^3=13+15+17+19
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 *
 * 数据范围：1≤m≤100
 * 进阶：时间复杂度：O(m) ，空间复杂度：O(1)
 *
 * 输入描述：
 * 输入一个int整数
 * 输出描述：
 * 输出分解后的string
 *
 * 示例1
 * 输入：
 * 6
 * 输出：
 * 31+33+35+37+39+41
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/16 22:55
 */
public class HJ76_NikosTheorem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> result = HJ76_NikosTheorem.nikos(in.nextInt())
                .stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(String.join("+", result));
    }

    private static List<Integer> nikos(int num) {
        int a1 = num * num - num + 1;
        List<Integer> result = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            result.add(a1);
            a1 += 2;
        }
        return result;
    }
}
