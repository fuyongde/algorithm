package com.fuyd.tree;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuyongde
 * @date 2020/2/4 14:19
 */
public class Solution100 {

    /**
     * 采用递归的方式
     * 时间复杂度：O(n)，其中n是树的结点数，因为每个结点都旭要访问一次
     * 空间复杂度：最优情况（完全平衡二叉树）时为 O(log(n))，最坏情况（完全不平衡二叉树）时为 O(n)，用于维护递归栈
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            // 如果两者都为空，则说明相等
            return true;
        }
        if (p == null || q == null) {
            // 任意一个为空，则不相等
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
