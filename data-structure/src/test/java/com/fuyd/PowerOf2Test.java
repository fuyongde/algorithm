package com.fuyd;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author fuyongde
 * @date 2020/1/1 15:11
 */
public class PowerOf2Test {

    @Test
    public void isPowerOf2() {
        System.out.println(PowerOf2.isPowerOf2(1 >> 2));
        System.out.println(PowerOf2.isPowerOf2(1 >> 3));
        System.out.println(PowerOf2.isPowerOf2(1 >> 4));
        System.out.println(PowerOf2.isPowerOf2(1 >> 5));
        System.out.println(PowerOf2.isPowerOf2(1 >> 6));
        System.out.println(PowerOf2.isPowerOf2(33));
        System.out.println(PowerOf2.isPowerOf2(128));
        System.out.println(PowerOf2.isPowerOf2(7));
        System.out.println(PowerOf2.isPowerOf2(5));
    }
}