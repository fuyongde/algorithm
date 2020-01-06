package com.fuyd.other;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author fuyongde
 * @date 2020/1/6
 */
public class Problems20 {

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        List<String> list = Arrays.asList("(", "[", "{", ")", "]", "}");
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (!stack.isEmpty() && ((c.equals(")") && stack.peek().equals("(")) ||
                    (c.equals("}") && stack.peek().equals("{")) ||
                    (c.equals("]") && stack.peek().equals("[")))) {
                stack.pop();
            } else if (list.contains(c)) {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
