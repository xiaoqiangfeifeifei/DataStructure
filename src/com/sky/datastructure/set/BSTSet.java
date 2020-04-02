package com.sky.datastructure.set;

import com.sky.datastructure.tree.bst.BST;

/***
 * @ProjectName DataStructure
 * @Title: BSTSet
 * @Description:
 * @author Sky
 * @date 2020/2/4 21:30
 * @Version V1.0.0
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
