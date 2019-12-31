package com.fuyd.linkednode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author fuyongde
 * @date 2019/12/30
 */
public class Problems19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 哨兵
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        int m = size - n;
        node = sentinel;
        while (m > 0) {
            m--;
            node = node.next;
        }
        node.next = node.next.next;
        return sentinel.next;
    }

}
