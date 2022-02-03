package com.sky.datastructure.hash;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集
 *
 * @ClassName: UniqFinSet
 * @Author garylovekira
 * @Date 2021/10/1
 * @Version 1.0
 */
public class UniqFindSet {

    private static  class Node {
        // any
    }

    private HashMap<Node, Node> fatherMap;
    private HashMap<Node, Integer> sizeMap;

    public UniqFindSet(List<Node> list) {
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (Node node: list) {
            fatherMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }


    public boolean isSameSet(Node node1, Node node2) {
        return getParentHead(node1) == getParentHead(node2);
    }

    private Node getParentHead(Node node) {
        Node father = fatherMap.get(node);
        if (node != father) {
            father = getParentHead(father);
        }
        fatherMap.put(node, father);
        return father;
    }

    public void union(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        Node head1 = getParentHead(node1);
        Node head2 = getParentHead(node2);

        if (head1 != head2) {
            int size1 = sizeMap.get(head1);
            int size2 = sizeMap.get(head2);

            if (size1 <= size2) {
                fatherMap.put(head1, head2);
                sizeMap .put(head2, size1 + size2);
            } else  {
                fatherMap.put(head2, head1);
                sizeMap .put(head1, size1 + size2);
            }
        }
    }
}
