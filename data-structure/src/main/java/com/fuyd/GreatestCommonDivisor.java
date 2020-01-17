package com.fuyd;

/**
 * 求两个数的最大公约数
 *
 * @author fuyongde
 * @date 2020/1/1 14:38
 */
public class GreatestCommonDivisor {

    /**
     * 思路：
     * 若两者较大数对较小数求余，若余数为0，则最大公约数为较小的数
     * 若不满足上述条件，则从较小数的一半开始向下寻找，若两个数对i求余，余数均为0，则i为最大公约数
     * 若没找到，则两个数的最大公约数是1
     * <p>
     * 在两个数都比较大时循环次数比较多，比如 a=10000，b=10001
     */
    public static int getGreatestCommonDivisor(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        if (big % small == 0) {
            return small;
        }
        for (int i = small / 2; i > 1; i--) {
            if (small % i == 0 && big % i == 0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * 思路
     * 两个正整数 a、b（a > b），他们的最大公约数等于a除以b的余数c 和 b 之间的最大公约数
     * <p>
     * 取模运算性能较差
     */
    public static int getGreatestCommonDivisorByEuclidean(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        if (big % small == 0) {
            return small;
        }
        return getGreatestCommonDivisorByEuclidean(small, big % small);
    }

    /**
     * 思路
     * 两个正整数a和b（a > b），他们的最大公约数等于（a-b）的差值c和较小数b的最大公约数
     * <p>
     * 运算次数比较多
     */
    public static int getGreatestCommonDivisorByChina(int a, int b) {
        if (a == b) {
            return a;
        }
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        return getGreatestCommonDivisorByChina(small, big - small);
    }
    
}
