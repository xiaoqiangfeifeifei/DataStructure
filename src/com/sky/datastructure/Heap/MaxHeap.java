package com.sky.datastructure.Heap;

import com.sky.datastructure.array.Array;

import java.util.Random;

/***
 * @ProjectName DataStructure
 * @Title: MaxHeap
 * @Description:
 * @author Sky
 * @date 2020/2/6 20:54
 * @Version V1.0.0
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<E>(capacity);
    }

    public MaxHeap(E[] arr) {
        data = new Array<E>(arr);
        for (int i = parent(size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public MaxHeap() {
        data = new Array<E>();
    }

    // 返回堆中元素个数
    public int size() {
        return data.getSize();
    }

    // 判断堆是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树中，当前索引表示元素的父元素的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 element doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    // 返回完全二叉树中，当前索引表示元素左孩子的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树中，当前索引表示元素右孩子的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 向完全二叉树中添加元素
    public void add(E e) {
        this.data.addLast(e);
        this.siftUp(size() - 1);
    }

    // 将尾部较大元素上浮，满足最大堆性质
    private void siftUp(int i) {
        while (i > 0 && data.get(i).compareTo(data.get(parent(i))) > 0) {
            data.swap(i, parent(i));
            i = parent(i);
        }
    }

    // 看堆中最大元素
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    // 取出堆中最大元素
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }


    // 将头部较小元素下沉，满足最大堆性质
    private void siftDown(int i) {
        while (leftChild(i) < data.getSize()) {// 左孩子在堆中，才循环
            int j = leftChild(i);
            // 如果右孩子大于左孩子的话，使用右孩子元素
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(i);
            }
            if (data.get(i).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(i, j);
            i = j;
        }
    }

    // 移除堆顶最大元素，进行替换
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap();

        int n = 1000000;
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test completed");
    }

}
