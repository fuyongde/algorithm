package com.fuyd.other;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuyongde
 * @date 2020/2/17
 */
public class Solution67 {

    /**
     * 逐位计算
     * 时间复杂度：O(max(n, m))，其中 n、m 为字符串 a、b 的长度
     * 空间复杂度：O(max(n, m))
     */
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        if (n < m) {
            return addBinary(b, a);
        }
        int l = Math.max(m, n);
        StringBuilder sb = new StringBuilder();
        int carry = 0, j = m - 1;
        for (int i = l - 1; i >= 0; i--) {
            if (a.charAt(i) == '1') {
                ++carry;
            }
            if (j > -1 && b.charAt(j--) == '1') {
                ++carry;
            }
            if (carry % 2 == 1) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            carry /= 2;
        }
        if (carry == 1) {
            sb.append('1');
        }
        // 将字符串倒转
        sb.reverse();
        return sb.toString();
    }
}
