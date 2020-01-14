package com.fuyd;

/**
 * @author fuyongde
 * @date 2019/12/28 23:10
 */
public class Sortor {

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSort2(int[] array) {
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
    }

    public static void bubbleSort3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
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
    }

    public static void insertionSort(int[] array) {
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
    }

    public static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            // left >= right 说明数组只有一个元素，不需要排序
            return;
        }
        // 这里基础元素可以在数组里随机选，这里我们直接以 startIndex 作为基准元素
        int pivot = array[startIndex];
        int i = startIndex;
        int j = endIndex;
        while (i < j) {
            while (array[j] >= pivot && i < j) {
                j--;
            }
            while (array[i] <= pivot && i < j) {
                i++;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        array[startIndex] = array[i];
        array[i] = pivot;
        quickSort(array, startIndex, i - 1);
        quickSort(array, i + 1, endIndex);
    }

    public static void quickSort2(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        // 这里基础元素可以在数组里随机选，这里我们直接以 startIndex 作为基准元素
        int pivot = array[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (array[i] < pivot) {
                mark++;
                swap(array, i, mark);
            }
        }
        array[startIndex] = array[mark];
        array[mark] = pivot;
        quickSort2(array, startIndex, mark - 1);
        quickSort2(array, mark + 1, endIndex);
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
