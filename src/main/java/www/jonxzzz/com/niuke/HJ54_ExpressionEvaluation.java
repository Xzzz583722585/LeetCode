package www.jonxzzz.com.niuke;

import java.util.Scanner;
import java.util.Stack;

/** todo
 * 描述
 * 给定一个字符串描述的算术表达式，计算出结果值。
 * 输入字符串长度不超过 100 ，合法的字符包括 ”+, -, *, /, (, )” ， ”0-9” 。
 * 数据范围：运算过程中和最终结果均满足
 * 1≤∣val∣≤2^31−1  ，即只进行整型运算，确保输入的表达式合法
 *
 * 输入描述：
 * 输入算术表达式
 * 输出描述：
 * 计算出结果值
 *
 * 示例1
 * 输入：
 * 400+5
 * 输出：
 * 405
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/16 21:11
 */
public class HJ54_ExpressionEvaluation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(HJ54_ExpressionEvaluation.eval(in.nextLine()));
    }

    public static int eval(String expression) {
        // 1.求波兰表达式
        // 数字 + 运算符
        Stack<String> numAndSymbols = new Stack<>();
        // 暂存运算符
        Stack<String> tmpSymbols = new Stack<>();

        char[] chars = expression.toCharArray();
        Integer num = null;
        boolean isNegativeNum = false;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (isDigit(c)) {
                if (num == null) {
                    num = c - 48;
                } else {
                    num = num * 10 + (c - 48);
                }
            } else if (c == '-' && (i == 0 || (!isDigit(chars[i - 1]) && ')' != chars[i - 1]))) {
                // 特殊处理下负数
                isNegativeNum = true;
            } else {
                if (num != null) {
                    numAndSymbols.push((num * (isNegativeNum ? -1 : 1)) + "");
                    num = null;
                    isNegativeNum = false;
                }

                if (c == '(') {
                    tmpSymbols.push(c + "");
                } else if (c == ')') {
                    while (!"(".equals(tmpSymbols.peek())) {
                        int num2 = Integer.parseInt(numAndSymbols.pop());
                        int num1 = Integer.parseInt(numAndSymbols.pop());
                        numAndSymbols.push(eval(tmpSymbols.pop(), num1, num2) + "");
                    }
                    tmpSymbols.pop();
                } else {
                    // 运算符
                    while (!highPriority(c + "", tmpSymbols.isEmpty() ? null : tmpSymbols.peek())) {
                        int num2 = Integer.parseInt(numAndSymbols.pop());
                        int num1 = Integer.parseInt(numAndSymbols.pop());
                        numAndSymbols.push(eval(tmpSymbols.pop(), num1, num2) + "");
                    }
                    tmpSymbols.push(c + "");
                }
            }
        }
        if (num != null) {
            numAndSymbols.push((num * (isNegativeNum ? -1 : 1)) + "");
        }
        while (!tmpSymbols.isEmpty()) {
            int num2 = Integer.parseInt(numAndSymbols.pop());
            int num1 = Integer.parseInt(numAndSymbols.pop());
            numAndSymbols.push(eval(tmpSymbols.pop(), num1, num2) + "");
        }

        // 2.逆波兰表达式求最终结果
        return Integer.parseInt(numAndSymbols.pop());
    }

    private static boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }

    private static boolean highPriority(String symbol1, String symbol2) {
        if (symbol2 == null || "(".equals(symbol2)) {
            return true;
        }

        if ("+".equals(symbol1) || "-".equals(symbol1)
                || "*".equals(symbol2) || "/".equals(symbol2) ) {
            return false;
        }
        return true;
    }

    private static int eval(String symbol, int num1, int num2) {
        switch (symbol) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2;
            default: throw new RuntimeException();
        }
    }
}
