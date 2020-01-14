package com.fuyd;

import org.junit.Before;
import org.junit.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;

/**
 * @author fuyongde
 * @date 2019/12/29 10:39
 */
public class SortorTest {

    private int[] items = {9, 4, 8, 7, 3, 1, 0, 2, 5, 6};

    @Before
    public void setUp() {
        System.out.println(String.format("--- before : %s", Arrays.toString(items)));
    }

    @Test
    public void bubbleSort() throws RunnerException {
        Sortor.bubbleSort(items);
        System.out.println(String.format("--- after  : %s", Arrays.toString(items)));

        Options opt = new OptionsBuilder()
                .include(Sortor.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

    @Test
    public void bubbleSort2() {
        Sortor.bubbleSort2(items);
        System.out.println(String.format("--- after  : %s", Arrays.toString(items)));
    }

    @Test
    public void bubbleSort3() {
        Sortor.bubbleSort3(items);
        System.out.println(String.format("--- after  : %s", Arrays.toString(items)));
    }

    @Test
    public void selectionSort() {
        Sortor.selectionSort(items);
        System.out.println(String.format("--- after  : %s", Arrays.toString(items)));
    }

    @Test
    public void insertionSort() {
        Sortor.insertionSort(items);
        System.out.println(String.format("--- after  : %s", Arrays.toString(items)));
    }

    @Test
    public void quickSort() {
        Sortor.quickSort(items, 0, items.length - 1);
        System.out.println(String.format("--- after  : %s", Arrays.toString(items)));
    }

    @Test
    public void quickSort2() {
        Sortor.quickSort2(items, 0, items.length - 1);
        System.out.println(String.format("--- after  : %s", Arrays.toString(items)));
    }
}