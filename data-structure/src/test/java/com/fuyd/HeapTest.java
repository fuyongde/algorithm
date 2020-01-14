package com.fuyd;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author fuyongde
 * @date 2020/1/3
 */
public class HeapTest {

    @Test
    public void buildHeap() {
        int[] items = {7, 1, 3, 10, 5, 2, 8, 9, 6};
        Heap.buildHeap(items);
        System.out.println(Arrays.toString(items));
    }

    @Test
    public void upAdjust() {
        int[] array = {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        Heap.upAdjust(array);
        // [0, 1, 2, 6, 3, 7, 8, 9, 10, 5]
        System.out.println(Arrays.toString(array));
    }
}