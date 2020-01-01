package com.fuyd.stack;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：使用一个辅助栈，辅助栈存储最小的元素
 * @author fuyongde
 * @date 2020/1/1 13:17
 */
public class Problems155 {

    class MinStack {

        Stack a, b;

        public MinStack() {
            a = new Stack();
            b = new Stack();
        }

        public void push(int x) {
            a.push(x);
            if (b.isEmpty() || x <= (int) b.peek()) {
                b.push(x);
            }
        }

        public void pop() {
            int x = (int) a.pop();
            if (!b.isEmpty() && x != (int) b.peek()) {

            } else {
                b.pop();
            }
        }

        public int top() {
            int x = (int) a.peek();
            return x;
        }

        public int getMin() {
            int y = (int) b.peek();
            return y;
        }
    }
}
