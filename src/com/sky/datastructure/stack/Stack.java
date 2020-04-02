package com.sky.datastructure.stack;

/**
 * @Author Sky
 * @Description 栈接口
 * @Date 2019/5/26
 * @Param
 * @Version: 1.0.0
 * @return
 **/
public interface Stack<E> {
    void push(E e);
    E pop();
    E peek();
    boolean isEmpty(E e);
    int getSize();
}
