package com.fuyd;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的遍历
 *
 * @author fuyongde
 * @date 2019/12/27 23:05
 */
public class BinaryTree<E> {
    E element;
    BinaryTree<E> left;
    BinaryTree<E> right;

    public BinaryTree(E element) {
        this.element = element;
    }

    public void setLeft(E left) {
        this.left = new BinaryTree<>(left);
    }

    public void setRight(E right) {
        this.right = new BinaryTree<>(right);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.setLeft(2);
        tree.setRight(3);
        tree.left.setLeft(4);
        tree.left.setRight(5);
        tree.right.setRight(6);

        List<Integer> list = new ArrayList<>();
        list = tree.qianxu(tree);
        System.out.println(list);
    }

    public List<E> qianxu(BinaryTree<E> tree, List<E> list) {
        list.add(tree.element);
        if (tree.left != null) {
            qianxu(tree.left, list);
        }
        if (tree.right != null) {
            qianxu(tree.right, list);
        }
        return list;
    }

    public List<E> qianxu(BinaryTree<E> tree) {
        Stack<BinaryTree<E>> stack = new Stack<>();
        stack.push(tree);
        List<E> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            BinaryTree<E> binaryTree = stack.pop();
            list.add(binaryTree.element);
            if (binaryTree.right != null) {
                stack.push(binaryTree.right);
            }
            if (binaryTree.left != null) {
                stack.push(binaryTree.left);
            }
        }
        return list;
    }

    public List<E> zhongxu(BinaryTree<E> tree, List<E> list) {
        if (tree.left != null) {
            zhongxu(tree.left, list);
        }
        list.add(tree.element);
        if (tree.right != null) {
            zhongxu(tree.right, list);
        }
        return list;
    }

    public List<E> houxu(BinaryTree<E> tree, List<E> list) {
        if (tree.left != null) {
            houxu(tree.left, list);
        }
        if (tree.right != null) {
            houxu(tree.right, list);
        }
        list.add(tree.element);
        return list;
    }
}
