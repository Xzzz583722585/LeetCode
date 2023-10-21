package www.jonxzzz.com.niuke;

import java.util.Scanner;

/**
 * 描述
 * 求一个int类型数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 *
 * 数据范围：数据组数：1≤t≤5 ，1≤n≤500000
 * 进阶：时间复杂度：O(logn) ，空间复杂度：O(1)
 *
 * 输入描述：
 * 输入一个int类型数字
 * 输出描述：
 * 输出转成二进制之后连续1的个数
 *
 * 示例1
 * 输入：
 * 200
 * 输出：
 * 2
 * 说明：
 * 200的二进制表示是11001000，最多有2个连续的1。
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/17 00:04
 */
public class HJ86_CountMaxConsecutiveBits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(Integer.toBinaryString(num));
        System.out.println(HJ86_CountMaxConsecutiveBits.countMaxConsecutiveBits(num));
    }

    public static int countMaxConsecutiveBits(int num) {
        int result = 0;
        int nextOne = 0;
        int count = 0;
        while (num != 0) {
            // 拿到最右边的1
            int rightestOne = num & -num;

            if (rightestOne >> 1 == nextOne) {
                // 和上一次出现的1是连续的
                count++;
            } else {
                result = Math.max(result, count);
                count = 1;
            }

            num -= rightestOne;
            nextOne = rightestOne;
        }
        result = Math.max(result, count);

        return result;
    }
}
