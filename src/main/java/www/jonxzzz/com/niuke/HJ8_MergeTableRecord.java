package www.jonxzzz.com.niuke;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述
 * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
 * 提示:
 * 0 <= index <= 11111111
 * 1 <= value <= 100000
 * 输入描述：
 * 先输入键值对的个数n（1 <= n <= 500）
 * 接下来n行每行输入成对的index和value值，以空格隔开
 * 输出描述：
 * 输出合并后的键值对（多行）
 *
 * 示例1
 * 输入：
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 输出：
 * 0 3
 * 1 2
 * 3 4
 *
 * 示例2
 * 输入：
 * 3
 * 0 1
 * 0 2
 * 8 9
 * 输出：
 * 0 3
 * 8 9
 *
 * @Author: xiaoqizong
 * @Date: 2023/10/16 18:40
 */
public class HJ8_MergeTableRecord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[][] records = new int[n][2];
        int i = 0;
        while (in.hasNextLine()) {
            String[] indexAndValue = in.nextLine().split(" ");
            records[i][0] = Integer.parseInt(indexAndValue[0]);
            records[i][1] = Integer.parseInt(indexAndValue[1]);
            i++;
        }

        int[][] result = HJ8_MergeTableRecord.mergeRecord(records);
        for (int[] r: result) {
            System.out.println(r[0] + " " + r[1]);
        }
    }

    public static int[][] mergeRecord(int[][] records) {
        Map<Integer, Integer> index2ValueMap = new HashMap<>();
        for (int[] record: records) {
            if (index2ValueMap.containsKey(record[0])) {
                index2ValueMap.put(record[0], index2ValueMap.get(record[0]) + record[1]);
            } else {
                index2ValueMap.put(record[0], record[1]);
            }
        }

        List<int[]> result = index2ValueMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(e -> new int[]{e.getKey(), e.getValue()})
                .collect(Collectors.toList());

        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
