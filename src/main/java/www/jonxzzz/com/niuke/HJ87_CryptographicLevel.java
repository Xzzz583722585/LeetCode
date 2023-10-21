package www.jonxzzz.com.niuke;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** todo
 * 描述
 * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 * 一、密码长度:
 * 5 分: 小于等于4 个字符
 * 10 分: 5 到7 字符
 * 25 分: 大于等于8 个字符
 * 二、字母:
 * 0 分: 没有字母
 * 10 分: 密码里的字母全都是小（大）写字母
 * 20 分: 密码里的字母符合”大小写混合“
 * 三、数字:
 * 0 分: 没有数字
 * 10 分: 1 个数字
 * 20 分: 大于1 个数字
 * 四、符号:
 * 0 分: 没有符号
 * 10 分: 1 个符号
 * 25 分: 大于1 个符号
 * 五、奖励（只能选符合最多的那一种奖励）:
 * 2 分: 字母和数字
 * 3 分: 字母、数字和符号
 * 5 分: 大小写字母、数字和符号
 * 最后的评分标准:
 * >= 90: 非常安全
 * >= 80: 安全（Secure）
 * >= 70: 非常强
 * >= 60: 强（Strong）
 * >= 50: 一般（Average）
 * >= 25: 弱（Weak）
 * >= 0:  非常弱（Very_Weak）
 * 对应输出为：
 * VERY_SECURE
 * SECURE
 * VERY_STRONG
 * STRONG
 * AVERAGE
 * WEAK
 * VERY_WEAK
 * 请根据输入的密码字符串，进行安全评定。
 *
 * 注：
 * 字母：a-z, A-Z
 * 数字：0-9
 * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
 * !"#$%&'()*+,-./     (ASCII码：0x21~0x2F)
 * :;<=>?@             (ASCII码：0x3A~0x40)
 * [\]^_`              (ASCII码：0x5B~0x60)
 * {|}~                (ASCII码：0x7B~0x7E)
 *
 * 提示:
 * 1 <= 字符串的长度<= 300
 * 输入描述：
 * 输入一个string的密码
 * 输出描述：
 * 输出密码等级
 *
 * 示例1
 * 输入：
 * 38$@NoNoN
 * 输出：
 * VERY_SECURE
 * 说明：
 * 样例的密码长度大于等于8个字符，得25分；大小写字母都有所以得20分；有两个数字，所以得20分；包含大于1符号，所以得25分；由于该密码包含大小写字母、数字和符号，所以奖励部分得5分，经统计得该密码的密码强度为25+20+20+25+5=95分。
 *
 * 示例2
 * 输入：
 * Jl)M:+
 * 输出：
 * AVERAGE
 * 说明：
 * 示例2的密码强度为10+20+0+25+0=55分。
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/17 09:57
 */
public class HJ87_CryptographicLevel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(HJ87_CryptographicLevel.cryptographicLevel(in.nextLine()));
    }

    public static String cryptographicLevel(String cipher) {
        if (cipher == null || cipher.length() == 0) {
            return "VERY_WEAK";
        }
        int score = 0;

        // 1.密码长度
        if (cipher.length() < 4) {
            score += 5;
        } else if (cipher.length() > 7) {
            score += 25;
        } else {
            // 5-7
            score += 10;
        }

        // 2.字母
        boolean noLetter = Pattern.matches("[^a-zA-Z]+", cipher);
        boolean allLetter1 = Pattern.matches("^([^A-Z]*[a-z]+[^A-Z]*)+$", cipher);
        boolean allLetter2 = Pattern.matches("^([^a-z]*[A-Z]+[^a-z]*)+$", cipher);
        if (!noLetter) {
            if (allLetter1 || allLetter2) {
                score += 10;
            } else {
                score += 20;
            }
        }

        // 3.数字
        boolean noDigit = Pattern.matches("[^0-9]+", cipher);
        if (!noDigit) {
            Matcher notOnlyOneDigit = Pattern.compile("(\\d).*(\\d)").matcher(cipher);
            if (notOnlyOneDigit.find()) {
                score += 20;
            } else {
                score += 10;
            }
        }

        // 4.符号
        boolean noSymbol = Pattern.matches("[0-9a-zA-Z]+", cipher);
        if (!noSymbol) {
            Matcher notOnlyOneSymbol = Pattern.compile("([^0-9a-zA-Z]).*([^0-9a-zA-Z])").matcher(cipher);
            if (notOnlyOneSymbol.find()) {
                score += 25;
            } else {
                score += 10;
            }
        }

        // 5.奖励
        if (!noLetter && !allLetter1 && !allLetter2 && !noDigit && !noSymbol) {
            score += 5;
        } else if (!noLetter && !noDigit && !noSymbol) {
            score += 3;
        } else if (!noLetter && !noDigit) {
            score += 2;
        }

        // 6.最终结果
        if (score >= 90) {
            return "VERY_SECURE";
        } else if (score >= 80) {
            return "SECURE";
        } else if (score >= 70) {
            return "VERY_STRONG";
        } else if (score >= 60) {
            return "STRONG";
        } else if (score >= 50) {
            return "AVERAGE";
        } else if (score >= 25) {
            return "WEAK";
        } else {
            return "VERY_WEAK";
        }
    }
}
