package com.fuyd.linkednode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * @author fuyongde
 * @date 2020/1/14 16:56
 */
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA;
        while (tmpA != null) {
            ListNode tmpB = headB;
            while (tmpB != null) {
                if (tmpA.equals(tmpB)) {
                    return tmpA;
                }
                tmpB = tmpB.next;
            }
            tmpA = tmpA.next;
        }
        return null;
    }
}
