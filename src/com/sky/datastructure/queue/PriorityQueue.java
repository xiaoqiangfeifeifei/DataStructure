package com.sky.datastructure.queue;

import com.sky.datastructure.Heap.MaxHeap;

/***
 * @ProjectName DataStructure
 * @Title: PriorityQueue
 * @Description:
 * @author Sky
 * @date 2020/2/7 17:09
 * @Version V1.0.0
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
