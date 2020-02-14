package com.fuyd.linkednode;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuyongde
 * @date 2020/2/14 22:20
 */
public class Solution1456 {

    /**
     * 先反转链表，再遍历链表构建数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] reversePrint(ListNode head) {
        // 先反转链表
        ListNode current = head, newHead = null;
        int length = 0;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = newHead;
            newHead = current;
            current = tmp;
            length++;
        }
        // 然后遍历链表构建数组
        int[] array = new int[length];
        current = newHead;
        for (int i = 0; i < length; i++) {
            array[i] = current.val;
            current = current.next;
        }
        return array;
    }

}
