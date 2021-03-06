package com.fuyd.other;

/**
 * 263. 丑数
 * 编写一个程序判断给定的数是否为丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例 1:
 *
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * 示例 2:
 *
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * 示例 3:
 *
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 * 说明：
 *
 * 1 是丑数。
 * 输入不会超过 32 位有符号整数的范围: [−(2的31次方),  2的31次方 − 1]。
 *
 * @author fuyongde
 * @date 2020/2/20
 */
public class Solution263 {

    /**
     * 思路：
     * 此题较为简单，想要判断一个数的因子是否为2、3、5，只需要判断对这个几个数进行取模然后再除以这几个数，直到最后为1即是丑数。
     * 如果对这个几个数取模都不能整除那一定不是丑数，所以使用else if，一直连续判断，如果除以2、3、5，都除不尽那就是丑数
     *
     */
    public boolean isUgly(int num) {
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
