package com.fuyd.other;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuyongde
 * @date 2020/1/2 22:38
 */
public class Solution7 {

    public static int reverse(int x) {
        boolean zhengshu = false;
        if (x >= 0) {
            zhengshu = true;
        }
        String s = String.valueOf(x);
        if (zhengshu) {
            s = "+" + s;
        }
        int[] array = new int[s.length() - 1];
        for (int i = 0; i < s.length() - 1; i++) {
            array[i] = Integer.parseInt(String.valueOf(s.charAt(i + 1)));
        }
        int[] tmp = new int[s.length() - 1];
        for (int i = tmp.length - 1; i >= 0; i--) {
            tmp[tmp.length - 1 - i] = array[i];
        }
        String str = "";
        for (int i : tmp) {
            str += i;
        }
        long l = zhengshu ? Long.valueOf(str) : 0 - Long.valueOf(str);
        return (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) ? 0 : (int) l;
    }

    public static int reverse2(int x) {
        boolean zhengshu = false;
        if (x >= 0) {
            zhengshu = true;
        }
        String s = String.valueOf(x);
        if (!zhengshu) {
            s = s.substring(1);
        }
        String v = new StringBuffer(s).reverse().toString();
        long l = zhengshu ? Long.parseLong(v) : -Long.parseLong(v);
        return (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) ? 0 : (int) l;
    }

    public static int reverse3(int x) {
        long rs = 0;
        while (x != 0) {
            rs = rs * 10 + x % 10;
            x /= 10;
        }
        return (rs < Integer.MIN_VALUE || rs > Integer.MAX_VALUE) ? 0 : (int) rs;
    }

}
