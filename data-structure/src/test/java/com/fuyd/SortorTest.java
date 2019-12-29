package com.fuyd;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author fuyongde
 * @date 2019/12/29 10:39
 */
public class SortorTest {

    private int[] items = {9, 4, 8, 7, 3, 1, 0, 2, 5, 6};

    @Before
    public void setUp() throws Exception {
        System.out.println(String.format("--- before : %s", Arrays.toString(items)));
    }

    @Test
    public void maopao() {
        int[] array = Sortor.maopao(items);
        System.out.println(String.format("--- after  : %s", Arrays.toString(array)));
    }

    @Test
    public void maopao2() {
        int[] array = Sortor.maopao2(items);
        System.out.println(String.format("--- after  : %s", Arrays.toString(array)));
    }

    @Test
    public void maopao3() {
        int[] array = Sortor.maopao3(items);
        System.out.println(String.format("--- after  : %s", Arrays.toString(array)));
    }

    @Test
    public void xuanze() {
        int[] array = Sortor.xuanze(items);
        System.out.println(String.format("--- after  : %s", Arrays.toString(array)));
    }

    @Test
    public void charu() {
        int[] array = Sortor.charu(items);
        System.out.println(String.format("--- after  : %s", Arrays.toString(array)));
    }
}