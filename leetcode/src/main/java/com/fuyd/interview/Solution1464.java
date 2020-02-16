package com.fuyd.interview;

/**
 * @author fuyongde
 * @date 2020/2/16 20:43
 */
public class Solution1464 {

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int x = 1, y = 1, z = 0;
        for (int i = 2; i <= n; i++) {
            z = (x + y) % 1000000007;
            x = y;
            y = z;
        }
        return z;
    }
}
