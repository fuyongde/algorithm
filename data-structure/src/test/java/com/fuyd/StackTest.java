package com.fuyd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author fuyongde
 * @date 2019/12/29 11:29
 */
public class StackTest {

    private Stack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<>(3);
    }

    @Test
    public void push() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    @Test
    public void pop() {
    }
}