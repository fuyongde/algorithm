package com.fuyd.linkednode;

/**
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
            size ++;
            node = node.next;
        }
        int m = size - n;
        node = sentinel;
        while (m > 0) {
            m --;
            node = node.next;
        }
        node.next = node.next.next;
        return sentinel.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
