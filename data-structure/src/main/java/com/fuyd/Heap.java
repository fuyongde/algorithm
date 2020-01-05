package com.fuyd;

/**
 * 堆虽然是一个完全二叉树，但是它的存储方式并不是链式存储，而是顺序存储。二叉树所有的节点都存储再数组中
 * <p>
 * 假设父节点的下标是parent，则左孩子下标是2*parent + 1，右孩子下标是2*parent + 2
 * <p>
 *        1
 *      /   \
 *     3     2
 *    / \   / \
 *   6  5  7   8
 *  / \
 * 9  10
 * <p>
 * 转换成顺序存储则是：1, 3, 2, 6, 5, 7, 8, 9, 10
 *
 * @author fuyongde
 * @date 2020/1/3
 */
public class Heap {

    /**
     * 构建堆
     *
     * @param array 待调整的堆
     */
    public static void buildHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    /**
     * 上浮调整
     *
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int tmp = array[childIndex];
        while (childIndex > 0 && tmp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = tmp;
    }

    public static void upAdjust2(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int tmp = array[childIndex];
        while (childIndex > 0 && tmp < array[parentIndex]) {
            // 将父子节点进行交换
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = tmp;
    }

    /**
     * 下沉调整
     *
     * @param array       待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length      堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // tmp 保存父节点的值
        int tmp = array[parentIndex];
        // 父节点的左孩子
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            if (tmp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = tmp;
    }

}
