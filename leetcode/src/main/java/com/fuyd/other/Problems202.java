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

    /**
     * 除了“快慢指针”思路，本题还可以归为数学规律题
     * <p>
     * 1-9中只有1和7是“快乐数”，其他均不是“快乐数”，
     * 故若当前的n等于1或7，则直接返回true;否则，若n < 10，且不等于1或7，则直接返回false。
     * <p>
     * 若程序仍未结束，则计算其每个位置上的数字的平方和sum，并对其递归执行上述过程。
     * <p>
     * 作者：hegongshan
     * 链接：https://leetcode-cn.com/problems/happy-number/solution/di-gui-by-hegongshan/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean isHappy2(int n) {
        if (n == 1 || n == 7) {
            return true;
        }
        if (n < 10) {
            return false;
        }

        int sum = 0;
        while (n >= 1) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }

        return isHappy(sum);
    }

}
