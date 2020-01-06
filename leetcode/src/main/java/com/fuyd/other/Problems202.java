package com.fuyd.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例: 
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuyongde
 * @date 2020/1/6 23:06
 */
public class Problems202 {

    public boolean isHappy(int n) {
        List<Integer> list = split(n);
        Set<Integer> set = new HashSet<>();
        while (!list.isEmpty() && n != 1) {
            int result = 0;
            for (Integer i : list) {
                result += i * i;
            }
            if (set.contains(result)) {
                return false;
            }
            n = result;
            list = split(n);
            set.add(result);
        }
        return true;
    }

    public static List<Integer> split(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            int x = n % 10;
            n = n / 10;
            list.add(x);
        }
        return list;
    }
}
