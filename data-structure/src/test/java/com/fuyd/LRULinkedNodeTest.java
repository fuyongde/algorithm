package com.fuyd;

import org.junit.Before;
import org.junit.Test;

/**
 * @author fuyongde
 * @date 2019/12/26
 */
public class LRULinkedNodeTest {

    LRULinkedNode<Integer, Integer> lru = new LRULinkedNode<>(5);

    @Before
    public void before() {
        for (int i = 0; i < 7; i++) {
            lru.insert(i, i);
        }
    }

    @Test
    public void getByKey() {
        System.out.println("1 " + lru.getByKey(1));
        System.out.println("2 " + lru.getByKey(2));
        System.out.println("3 " + lru.getByKey(3));
        System.out.println("4 " + lru.getByKey(4));
        System.out.println("5 " + lru.getByKey(5));
        System.out.println("6 " + lru.getByKey(6));
        System.out.println("7 " + lru.getByKey(7));
    }
}