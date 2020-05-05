package com.sky.algorithm.interview.simple;

import java.lang.reflect.Array;

/**
 * 用数组实现栈或队列
 *
 * @ClassName: ArrayStackQueue
 * @Author Administrator
 * @Date 2020/5/3
 * @Version 1.0
 */
public class ArrayStackQueue {

    public class ArrayStack {
        private int[] array;
        private int index;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("初始容量小于0");
            }
            array = new int[initSize];
            index = 0;
        }

        public void push(int e) {
            if (index == array.length) {
                throw new ArrayIndexOutOfBoundsException("栈满了， index已经到array.length了");
            }
            array[index++] = e;//将e加到index位置， index往下走
        }

        public int peek() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("栈空了，已经没有元素可以查看了");
            }
            return array[index - 1];//将index退回到最新元素的位置，返回
        }

        public int pop() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("栈空了，已经没有元素可以查看了");
            }
            return array[--index];//将index退回到最新元素的位置，返回
        }
    }

    public class ArrayQueue {
        private int[] array;
        private int start;//弹出队列元素的指针
        private int end;//添加队列元素的指针
        private int size;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("初始容量小于0");
            }
            array = new int[initSize];
            start = 0;
            end = 0;
            size = 0;
        }

        public void push(int e) {
            if (size == array.length) {
                throw new ArrayIndexOutOfBoundsException("队列满了，无法再往里面加");
            }

            size++;
            array[end] = e;
            end = end == array.length - 1 ? 0 : end + 1;
        }

        public int poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("队列空了，无法弹出元素");
            }

            size--;
            int tmp = start;
            start = start == array.length - 1 ? 0 : start + 1;
            return array[tmp];
        }

        public int peek() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("队列空了，无法弹出元素");
            }

            return array[start];
        }

    }
}
