package www.jonxzzz.com.niuke;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/** todo
 * 描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * 数据范围：1≤n≤2×10^9+14
 * 输入描述：
 * 输入一个整数
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
 *
 * 示例1
 * 输入：
 * 180
 * 输出：
 * 2 2 3 3 5
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/16 17:09
 */
public class HJ6_PrimeFactor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] factors = HJ6_PrimeFactor.primeFactor(Integer.parseInt(in.nextLine()));
        String[] result = new String[factors.length];
        for (int i = 0; i < factors.length; i++) {
            result[i] = factors[i] + "";
        }
        System.out.println(String.join(" ", result));
    }

    public static int[] primeFactor(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        if (num == 1) {
            return new int[]{1};
        }

        double doubleNum = num;
        List<Integer> result = new LinkedList();
        int prime = 2;
        while (prime < (Math.sqrt(num) + 1) && doubleNum > 1) {
            if (doubleNum % prime == 0.0) {
                result.add(prime);
                doubleNum /= prime;
            } else {
                prime += 1;
            }
        }
        if (doubleNum > 1) {
            result.add((int) doubleNum);
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

}
