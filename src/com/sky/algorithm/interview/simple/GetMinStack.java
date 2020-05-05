package com.sky.algorithm.interview.simple;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返 回栈中最小元素的操作。
 * 【要求】 1．pop、push、getMin操作的时间复杂度都是O(1)。
 * 2．设计的栈类型可以使用现成的栈结构。
 *
 * @ClassName: GetMinstack
 * @Author Administrator
 * @Date 2020/5/3
 * @Version 1.0
 */
public class GetMinStack {
    public class MyStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public void push(int e) {
            if (minStack.isEmpty()) {
                minStack.push(e);
            } else if (e < getMin()) {//如果压栈的值小于栈最小值，那么压入e
                minStack.push(e);
            } else {//还是压入原最小值
                minStack.push(getMin());
            }

            dataStack.push(e);
        }

        private Integer getMin() {
            if (minStack.isEmpty()) {
                throw new IllegalArgumentException("没有元素了...");
            }
            return minStack.peek();
        }

        public int pop() {
            if (dataStack.isEmpty()) {
                throw new IllegalArgumentException("没有元素了...");
            }

            minStack.pop();
            return dataStack.pop();
        }

    }
}
