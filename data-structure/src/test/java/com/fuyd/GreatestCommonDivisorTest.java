package com.fuyd;

import org.junit.Test;

/**
 * @author fuyongde
 * @date 2020/1/1 15:05
 */
public class GreatestCommonDivisorTest {

    @Test
    public void getGreatestCommonDivisor() {
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisor(25, 5));
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisor(100, 80));
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisor(27, 14));
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisor(10000, 10001));
    }

    @Test
    public void getGreatestCommonDivisorByEuclidean() {
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisorByEuclidean(25, 5));
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisorByEuclidean(100, 80));
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisorByEuclidean(27, 14));
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisorByEuclidean(10000, 10001));
    }

    @Test
    public void getGreatestCommonDivisorByChina() {
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisorByChina(25, 5));
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisorByChina(100, 80));
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisorByChina(27, 14));
        System.out.println(GreatestCommonDivisor.getGreatestCommonDivisorByChina(10000, 10001));
    }

}