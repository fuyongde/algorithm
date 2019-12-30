package com.fuyd;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * @author fuyongde
 * @date 2019/12/28 16:30
 */
public class BinaryTreeTest {

    BinaryTree<Integer> root = new BinaryTree<>(1);

    @Before
    public void setUp() throws Exception {
        root.setLeft(2);
        root.setRight(3);
        root.left.setLeft(4);
        root.left.setRight(5);
        root.right.setRight(6);
    }

    @Test
    public void qianxu() {
        // 1, 2, 4, 5, 3, 6
        List<Integer> list = new ArrayList<>();
        list = root.qianxu(root, list);
        System.out.println(list);
    }

    @Test
    public void qianxu1() {
        // 1, 2, 4, 5, 3, 6
        List<Integer> list = root.qianxu(root);
        System.out.println(list);
    }

    @Test
    public void zhongxu() {
        // 4, 2, 5, 1, 3, 6
        List<Integer> list = new ArrayList<>();
        list = root.zhongxu(root, list);
        System.out.println(list);
    }

    @Test
    public void zhongxu1() {
        // 4, 2, 5, 1, 3, 6
        List<Integer> list = root.zhongxu(root);
        System.out.println(list);
    }

    @Test
    public void houxu() {
        // 4, 5, 2, 6, 3, 1
        List<Integer> list = new ArrayList<>();
        list = root.houxu(root, list);
        System.out.println(list);
    }

    @Test
    public void houxu1() {
        // 4, 5, 2, 6, 3, 1
        List<Integer> list = root.houxu(root);
        System.out.println(list);
    }

    @Test
    public void cengxu() {
        // 1, 2, 3, 4, 5, 6
        List<Integer> list = root.cengxu(root);
        System.out.println(list);
    }
}