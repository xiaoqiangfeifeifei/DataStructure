package com.sky.datastructure.unionfind;

import java.util.Arrays;

/**
 * @ClassName: UnionFind2
 * @Author Administrator
 * @Date 2020/2/15
 * @Version 1.0
 */
public class UnionFind2 implements UF{

    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //查找元素p的根节点元素，父元素
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound");
        }

        while (parent[p] != p) {
            p = parent[p];
        }

        return p;
    }
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // 此时q的parent就是q自己，
        parent[q] = pRoot;
        
        System.out.println(Arrays.toString(parent));
    }

    public static void main(String[] args) {
        UnionFind1 unionFind1 = new UnionFind1(10);
        unionFind1.unionElements(0,1);

        System.out.println(unionFind1.isConnected(0, 2));
    }
}
