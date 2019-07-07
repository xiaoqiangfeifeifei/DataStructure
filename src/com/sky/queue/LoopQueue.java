package com.sky.queue;

/***  
 * @ProjectName DataStructure
 * @Title: LoopQueue
 * @Description:
 * @author Sky
 * @date 2019/6/8 23:19
 * @Version V1.0.0
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front, tail;
    private int size;


    public LoopQueue(int capacity) {
        // 循环队列情况会预留一个元素空间
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }


    public int getCapacity() {
        // 去除多余的元素空间，得到实际的容量
        return data.length - 1;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        // 下一个尾部元素首部元素重叠，扩容
        if ( (tail + 1) % data.length == front ) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];

        for (int i =0 ; i< size; i++) {
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;// 指向最后的一位元素后的空间
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        // 当size小于总容量四分之之一， 将容量缩小二分之一
        if (size < getCapacity() / 4 && getCapacity()/ 2 != 0 ) {
            resize(getCapacity() /2 );
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }


        return data[front];
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, data.length - 1));
        res.append("front [");
        for(int i = front ; i != tail; i = (i + 1) % data.length){
            res.append(data[i]);

            // 当前元素不为最后一个元素
            if( (i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }
}
