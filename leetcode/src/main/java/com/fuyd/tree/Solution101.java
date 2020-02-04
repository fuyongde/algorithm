package com.fuyd.tree;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuyongde
 * @date 2020/2/4 15:33
 */
public class Solution101 {

    /**
     * 递归的方式
     * 时间复杂度：O(n)，因为需要遍历整个树，其中n时书中结点的总数
     * 空间复杂度：O(n)，递归调用次数受树的高度的限制，最糟糕情况下，树时线性的，其高度为O(n)，因此糟糕情况下，由栈上的递归调用造成的空间复杂度为O(n)
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }
}
