package com.fuyd;

import java.util.Stack;
import java.util.*;

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

    public List<E> qianxu(BinaryTree<E> root, List<E> list) {
        list.add(root.element);
        if (root.left != null) {
            qianxu(root.left, list);
        }
        if (root.right != null) {
            qianxu(root.right, list);
        }
        return list;
    }

    public List<E> qianxu(BinaryTree<E> root) {
        Stack<BinaryTree<E>> stack = new Stack<>();
        stack.push(root);
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

    public List<E> zhongxu(BinaryTree<E> root, List<E> list) {
        if (root.left != null) {
            zhongxu(root.left, list);
        }
        list.add(root.element);
        if (root.right != null) {
            zhongxu(root.right, list);
        }
        return list;
    }

    public List<E> zhongxu(BinaryTree<E> root) {
        Stack<BinaryTree<E>> stack = new Stack<>();
        BinaryTree<E> node = root;
        List<E> list = new ArrayList<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                BinaryTree<E> tmp = stack.pop();
                list.add(tmp.element);
                node = tmp.right;
            }
        }
        return list;
    }

    public List<E> houxu(BinaryTree<E> root, List<E> list) {
        if (root.left != null) {
            houxu(root.left, list);
        }
        if (root.right != null) {
            houxu(root.right, list);
        }
        list.add(root.element);
        return list;
    }

    public List<E> houxu(BinaryTree<E> root) {
        Stack<BinaryTree<E>> stack = new Stack<>();
        Stack<BinaryTree<E>> output = new Stack<>();
        BinaryTree<E> node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                output.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        List<E> list = new ArrayList<>();
        while (output.size() > 0) {
            node = output.pop();
            list.add(node.element);
        }
        return list;
    }

    public List<E> cengxu(BinaryTree<E> root) {
        Queue<BinaryTree<E>> queue = new ArrayDeque<>();
        queue.offer(root);
        List<E> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            BinaryTree<E> node = queue.poll();
            list.add(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return list;
    }
}
