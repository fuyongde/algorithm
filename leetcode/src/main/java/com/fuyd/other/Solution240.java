package com.fuyd.other;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuyongde
 * @date 2020/2/12 20:32
 */
public class Solution240 {

    /**
     * 暴力迭代
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int i : ints) {
                if (i == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 减而治之
     * 时间复杂度：O(n+m)。时间复杂度分析的关键是注意到在每次迭代（我们不返回 true）时，行或列都会精确地递减/递增一次。
     * 由于行只能减少 m 次，而列只能增加 n 次，因此在导致 while 循环终止之前，循环不能运行超过 n+m 次。
     * 因为所有其他的工作都是常数，所以总的时间复杂度在矩阵维数之和中是线性的。
     * 空间复杂度：O(1)。因为这种方法只处理几个指针，所以它的内存占用是恒定的。
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        // 最大行数
        int rows = matrix.length;
        if (rows == 0) {
            // 此时说明矩阵中没有元素
            return false;
        }
        // 最大列数
        int columns = matrix[0].length;
        if (columns == 0) {
            // 此时说明矩阵中没有元素
            return false;
        }
        int x = rows - 1;
        int y = 0;
        while (x >= 0) {
            while (y < columns && matrix[x][y] < target) {
                y++;
            }
            if (y < columns && matrix[x][y] == target) {
                return true;
            }
            x--;
        }
        return false;
    }

}
