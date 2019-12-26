package com.fuyd;

import java.util.Objects;

/**
 * @author fuyongde
 * @date 2019/12/26
 */
public class LRULinkedNode<K, V> {

    private int size;
    /**
     * 容量，初始化为5
     **/
    private int capacity = 5;
    /**
     * 链表头
     */
    private LinkedNode<K, V> head;

    public LRULinkedNode(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity 必须大于0");
        }
        this.capacity = capacity;
    }

    public void insert(K key, V value) {
        // 插入元素
        if (Objects.isNull(head)) {
            // 如果链表头部不存在则初始化链表
            initHead(new LinkedNode<>(key, value));
            return;
        }
        LinkedNode<K, V> exist = findByKey(key);
        if (Objects.nonNull(exist)) {
            // 元素存在，则将元素从原来位置删除，并且插入到头部，此时不用考虑 size 的问题
            if (Objects.nonNull(exist.pre)) {
                // 如果没有pre节点，说明当前节点为头部，则不用处理
                exist.pre.deleteNext();
                size--;
                insertAtHead(exist);
            }
        } else {
            // 将元素插入在头部
            if (size + 1 > capacity) {
                // 删除最后一个元素
                deleteTail();
            }
            insertAtHead(new LinkedNode<>(key, value));
        }
    }

    public V getByKey(K key) {
        LinkedNode<K, V> node = findByKey(key);
        if (Objects.isNull(node)) {
            return null;
        }
        // 如果存在对应的 node，则需要将对应的 node 插入到链表的头部
        if (Objects.nonNull(node.pre)) {
            node.pre.next = node.next;
            if (Objects.nonNull(node.next)) {
                node.next.pre = node.pre;
            }
            size--;
            insertAtHead(node);
        }
        return node.value;
    }

    private void deleteTail() {
        LinkedNode<K, V> node = head;
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return;
        }
        while (Objects.nonNull(node.next.next)) {
            node = node.next;
        }
        node.next = null;
        size--;
    }

    private LinkedNode<K, V> findByKey(K key) {
        LinkedNode<K, V> node = head;
        while (Objects.nonNull(node)) {
            if (node.key.equals(key)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private void insertAtHead(LinkedNode<K, V> node) {
        // 在头部插入元素
        head.addPre(node);
        head = node;
        size++;
    }

    private void initHead(LinkedNode<K, V> node) {
        // 初始化链表头部
        this.head = node;
        size++;
    }

    static class LinkedNode<K, V> {
        K key;
        V value;
        LinkedNode<K, V> pre;
        LinkedNode<K, V> next;

        public LinkedNode() {
        }

        public LinkedNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void addPre(LinkedNode<K, V> pre) {
            this.pre = pre;
            pre.next = this;
        }

        public void addNext(LinkedNode<K, V> next) {
            this.next = next;
            next.pre = this;
        }

        public void deleteNext() {
            if (Objects.nonNull(this.pre) && Objects.nonNull(this.next)) {
                this.pre.next = this.next;
                this.next.pre = this.pre;
            } else if (Objects.nonNull(this.pre)) {
                this.pre.next = null;
                this.pre = null;
            }
        }

        public void deletePre() {
            if (Objects.nonNull(this.pre) && Objects.nonNull(this.pre.pre)) {
                this.pre.pre.next = this;
                this.pre = this.pre.pre;
            } else if (Objects.nonNull(this.pre)) {
                this.pre.next = null;
                this.pre = null;
            }
        }
    }
}
