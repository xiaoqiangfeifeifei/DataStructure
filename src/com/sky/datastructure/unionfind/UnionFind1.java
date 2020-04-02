package com.sky.datastructure.unionfind;

import java.util.Arrays;

/**
 * @ClassName: UnionFind1
 * @Author Administrator
 * @Date 2020/2/14
 * @Version 1.0
 */
public class UnionFind1 implements UF {
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    // 查找p所属的组
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        System.out.println(Arrays.toString(id));
    }


    public static void main(String[] args) {
        UnionFind1 unionFind1 = new UnionFind1(10);
        unionFind1.unionElements(0,1);

        System.out.println(unionFind1.isConnected(0, 2));
    }
}
