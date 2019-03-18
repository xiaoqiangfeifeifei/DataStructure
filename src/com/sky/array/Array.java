package com.sky.array;

/***  
 * @ProjectName DataStructure
 * @Title: Array
 * @Description: 自定义数组
 * @author Sky
 * @date 2019/3/2 23:13
 * @Version V1.0.0
 */
public class Array<E> {
    private E[] data;
    private int size;

    // 根据capacity构造数组
    public Array (int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 默认构造函数，默认capacity为16
    public Array () {
        this(16);
    }


    // 返回数组元数个数
    public int getSize() {
        return size;
    }

    // 返回数组容量
    public int getCapacity() {
        return data.length;
    }

    // 判断数组是否为空
    public boolean isEmpty () {
        return data.length == 0;
    }


    // 将元素插入最后位置
    public void addLast(E e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("数组满了，不能再插入");
//        }
//
//        data[size] = e;
//        size++;

        // 直接使用add方法，size此时代表最后的数组元素后的索引值
        add(size, e);
    }


    // 将数组元素添加到第一位
    public void addFirst(E e) {
        add(0, e);
    }

    // 将数组元素插入指定位置
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index非法");
        }

        if (size == data.length) {
            resize(data.length * 2);
        }

        // 索引当前以及索引后的元素的索引都加一，给e腾出位置
        for (int i = size - 1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }


    // 在index位置添加元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index 非法");
        }
        return data[index];
    }


    // 将index位置元素设为e
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index 非法");
        }
        data[index] = e;
    }


    // 查找数组中是否包含e
    public Boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e的索引位置，无此元素返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }


    // 删除索引index位置的元素， 返回被删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index 非法");
        }
        E ret = data[index];

        // 将所有的index之后的元素前移
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;

        // 数组元素小于容量的1/4,缩容。 数组长度不能为零
        if (size < data.length / 4 && data.length /2 != 0) {
            resize(data.length / 2);
        }
        data[index] = null; // 删除后原本位置指向的对象显式声明为null
        return ret;
    }

    // 移除第一位
    public E removeFirst() {
        return remove(0);
    }

    // 移除最后一位
    public E removeLast() {
        return remove(size - 1);
    }


    // 移除指定的元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    // 数组扩容
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i =0 ; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d \n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");

        return res.toString();
    }

}
