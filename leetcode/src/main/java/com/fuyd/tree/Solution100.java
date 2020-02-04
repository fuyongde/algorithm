package com.fuyd.tree;

/**
 * @author fuyongde
 * @date 2020/2/4 14:19
 */
public class Solution100 {

    /**
     * 采用递归的方式
     * 时间复杂度：O(n)，其中n是树的结点数，因为每个结点都旭要访问一次
     * 空间复杂度：最优情况（完全平衡二叉树）时为O(log(n))，最坏情况（完全不平衡二叉树）时为O(n)，用于维护递归栈
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
