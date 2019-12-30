package com.fuyd;

/**
 * @author fuyongde
 * @date 2019/12/28 23:10
 */
public class Sortor {

    public static int[] maopao(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    public static int[] maopao2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    // 因为有元素交换，所以不是有序的
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        return array;
    }

    public static int[] maopao3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
        return array;
    }

    public static int[] xuanze(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }
        return array;
    }

    public static int[] charu(int[] array) {
        int j, tmp;
        for (int i = 0; i < array.length - 1; i++) {
            j = i;
            tmp = array[i + 1];
            while (j > -1 && tmp <= array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
        return array;
    }

    public static int[] quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            // left >= right 说明数组只有一个元素，不需要排序
            return array;
        }
        int key = array[startIndex];
        int i = startIndex;
        int j = endIndex;
        while (i < j) {
            while (array[j] >= key && i < j) {
                j--;
            }
            while (array[i] <= key && i < j) {
                i++;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        array[startIndex] = array[i];
        array[i] = key;
        quickSort(array, startIndex, i - 1);
        quickSort(array, i + 1, endIndex);
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
