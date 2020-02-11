package com.fuyd.other;

/**
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 16
 * 输出: true
 * 示例 2:
 *
 * 输入: 5
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuyongde
 * @date 2020/2/11 19:40
 */
public class Solution342 {

    /**
     * 和判断一个数是否为3的幂方法一样
     * @see Solution326
     */
    public boolean isPowerOfFour(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 1;
    }

    /**
     * 位运算
     * 4的幂一定是2的。
     * 4的幂和2的幂一样，只会出现一位1。但是，4的1总是出现在奇数位。
     * 0xa = 0101b可以用来校验奇数位上的1。
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */
    public boolean isPowerOfFour2(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }
}
