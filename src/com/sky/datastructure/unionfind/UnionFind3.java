package com.sky.datastructure.unionfind;

import java.util.Arrays;

/**
 * @ClassName: UnionFind2
 * @Author Administrator
 * @Date 2020/2/15
 * @Version 1.0
 */
public class UnionFind3 implements UF{

    private int[] parent;

    private int[] sz; //存放着以i根的根节点元素的数目
    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
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

        // pRoot中的节点比qRoot中节点少，将pRoot节点加到qRoot中
        if (sz[pRoot] < sz[qRoot]) {
            parent[p] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[q] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

        
        System.out.println(Arrays.toString(parent));
    }

    public static void main(String[] args) {
        UnionFind1 unionFind1 = new UnionFind1(10);
        unionFind1.unionElements(0,1);

        System.out.println(unionFind1.isConnected(0, 2));
    }
}
