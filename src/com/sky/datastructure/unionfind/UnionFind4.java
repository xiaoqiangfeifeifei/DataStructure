package com.sky.datastructure.unionfind;

/**
 * @ClassName: UnionFind2
 * @Author Administrator
 * @Date 2020/2/15
 * @Version 1.0
 */
public class UnionFind4 implements UF{

    private int[] parent;

    private int[] rank; //存放着以i根的树高度
    public UnionFind4(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
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
            parent[p] = parent[parent[p]];// line compression
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
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }

        
//        System.out.println(Arrays.toString(parent));
    }

    public static void main(String[] args) {
        UnionFind1 unionFind1 = new UnionFind1(10);
        unionFind1.unionElements(0,1);

        System.out.println(unionFind1.isConnected(0, 2));
    }
}
