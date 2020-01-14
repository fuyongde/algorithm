package com.fuyd;

/**
 * @author fuyongde
 * @date 2020/1/1 15:10
 */
public class PowerOf2 {

    /**
     * 思路
     * 如果一个数是2的n次方，则改数用2进制表示一定是 10000（若干个0），减一则为11111（若干个1），两个数做与运算，一定等于0
     */
    public static boolean isPowerOf2(int num) {
        return num > 0 && (num & num - 1) == 0;
    }
}
