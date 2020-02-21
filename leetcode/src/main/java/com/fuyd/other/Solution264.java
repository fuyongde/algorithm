package com.fuyd.other;

/**
 * 264. 丑数 II
 * 编写一个程序，找出第 n 个丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 *
 * @author fuyongde
 * @date 2020/2/21
 */
public class Solution264 {

    /**
     * 暴力法
     * 该方法在 leetcode 中会超时。
     */
    public int nthUglyNumber(int n) {
        int index = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (isUgly(i)) {
                index++;
                if (index == n) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 三指针法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int nthUglyNumber2(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            if (min == dp[i2] * 2) {
                i2++;
            }
            if (min == dp[i3] * 3) {
                i3++;
            }
            if (min == dp[i5] * 5) {
                i5++;
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }

    public static boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 2 == 0) {
            num >>= 1;
        }
        return num == 1;
    }
}
