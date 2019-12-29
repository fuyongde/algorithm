package com.fuyd;

/**
 * @author fuyongde
 * @date 2019/12/28 22:12
 */
public class Stack<E> {
    /**
     * 数组
     */
    private E[] items;
    /**
     * 栈中元素的个数
     */
    private int count;
    /**
     * 栈的容量
     */
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.items = (E[]) new Object[capacity];
        this.count = 0;
    }

    /**
     * 入栈
     *
     * @param e 元素
     * @return true | false
     */
    public boolean push(E e) {
        if (count == capacity) {
            // 栈满了
            return false;
        }
        items[count] = e;
        ++count;
        return true;
    }

    /**
     * 出栈
     *
     * @return 元素
     */
    public E pop() {
        if (count == 0) {
            return null;
        }
        E element = items[count - 1];
        --count;
        return element;
    }
}
