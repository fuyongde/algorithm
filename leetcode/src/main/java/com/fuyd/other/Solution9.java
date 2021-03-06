package com.fuyd.other;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuyongde
 * @date 2020/1/2 23:16
 */
public class Solution9 {

    /**
     * 用到了 leetcode 第7题的思想
     */
    public static boolean isPalindrome(int x) {
        int tmp = x;
        boolean fushu = x < 0;
        if (fushu) {
            return false;
        }
        long rs = 0;
        while (x != 0) {
            rs = rs * 10 + x % 10;
            x /= 10;
        }
        return tmp == (int) rs;
    }

}
