package com.sky.algorithm.interview.simple;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 如何仅用队列结构实现栈结构？ 如何仅用栈结构实现队列结构？
 *
 * @ClassName: StackQueueConvert
 * @Author Administrator
 * @Date 2020/5/4
 * @Version 1.0
 */
public class StackQueueConvert {

    /**
     * 如何仅用队列结构实现栈结构？
     *
     * 返回时将队列尾部的元素返回，从而达到后进先出
     */
    public class StackWithTwoQueue {

        public Queue<Integer> data;
        public Queue<Integer> help;

        public StackWithTwoQueue() {
            data = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(Integer e) {
            this.data.add(e);
        }

        public Integer pop() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }

            //保留最后一个元素，返回用户
            while (data.size() > 1) {
                help.add(data.poll());
            }

            Integer res = data.poll();
            swap();//help只用于返回元素， 取得最后一个元素返回之前需要将引用替换下
            return res;
        }


        public Integer peek() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }

            //保留最后一个元素，返回用户
            while (data.size() > 1) {
                help.add(data.poll());
            }
            Integer res = data.poll();
            help.add(res);
            swap();//help只用于返回元素， 取得最后一个元素返回之前需要将引用替换下
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = this.data;
            this.data = this.help;
            this.help = tmp;
        }
    }

    public class QueueWithTwoStack {
        public Stack<Integer> pushStack;
        public Stack<Integer> popStack;

        public QueueWithTwoStack() {
            this.pushStack = new Stack<>();
            this.popStack = new Stack<>();
        }

        public void push(Integer e) {
            this.pushStack.push(e);
        }

        public Integer poll() {
            if (pushStack.isEmpty() && popStack.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            } else {
                if (popStack.isEmpty()) {//当pop栈为空时才可以继续传数据，否则会出现新压入的数据跑到栈顶，pop就出错了
                    while (!pushStack.isEmpty()) {//需要一次性传完，不传完会出现pop出中间数据的情况
                        popStack.push(pushStack.pop());
                    }
                }
            }

            return popStack.pop();

        }

        public Integer peek() {
            if (pushStack.isEmpty() && popStack.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            } else {
                if (popStack.isEmpty()) {//当pop栈为空时才可以继续传数据，否则会出现新压入的数据跑到栈顶，pop就出错了
                    while (!pushStack.isEmpty()) {//需要一次性传完，不传完会出现pop出中间数据的情况
                        popStack.push(pushStack.pop());
                    }
                }
            }
            return popStack.peek();
        }

    }
}
