package com.fuyd.problems200;

/**
 * 反转单链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @author fuyongde
 * @date 2019/12/26 23:17
 */
public class Problems206 {

    public static ListNode reverseList(ListNode head) {
        // 定义一个新的头部
        ListNode newHead = null;
        // 定义一个临时变量，并赋初始值为原链表头
        ListNode tmpNode = head;
        while (tmpNode != null) {
            // 获取临时变量的下一个结点
            ListNode next = tmpNode.next;
            // 将新的头作为临时结点的下一个结点
            tmpNode.next = newHead;
            // 将临时变量赋值给新的链表头
            newHead = tmpNode;
            tmpNode = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode newNode = reverseList(node);
        String s = "";
        ListNode tmp = newNode;
        while (tmp != null) {
            s += tmp.val + " ";
            tmp = tmp.next;
        }
        System.out.println(s);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
