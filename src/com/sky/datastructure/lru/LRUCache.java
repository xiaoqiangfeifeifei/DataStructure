package com.sky.datastructure.lru;

import java.util.HashMap;

/**
 * @ClassName: LRUCache
 * @Author Administrator
 * @Date 2020/4/27
 * @Version 1.0
 */
public class LRUCache {
    private Node head;
    private Node end;
    private int limit;

    private HashMap<String, Node> hashMap;


    public LRUCache(int limit ) {
        this.limit = limit;
        hashMap = new HashMap<>();
    }


    public String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        refreshNode(node);
        return node.value;
    }
    public String get() {
        return end.value;
    }



    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }

            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            node.value = value;
            refreshNode(node);
        }
    }

    public void remove(String key) {
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    private void refreshNode(Node node) {
        if (node == end) {//如果访问的是尾节点，无需移动节点
            return;
        }

        removeNode(node);
        addNode(node);
    }

    private void addNode(Node node) {
        // 添加节点
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }

        //更新尾节点
        end = node;
        //更新头节点
        if (head == null) {
            head = node;
        }
    }


    private String removeNode(Node node) {
        if (node == head) {
            head = head.next;
        } else if (node == end) {
            end = end.pre;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;

        }
        return node.value;
    }




    private class Node {
        private String key;
        private String value;
        private Node next;
        private Node pre;

        public Node(String key ,String value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        lruCache.put("1", "1");
        lruCache.put("2", "2");
        lruCache.put("3", "3");

        lruCache.get("1");
        System.out.println(lruCache.get());

        lruCache.put("4", "4");

        System.out.println(lruCache.get("2"));

    }

}
