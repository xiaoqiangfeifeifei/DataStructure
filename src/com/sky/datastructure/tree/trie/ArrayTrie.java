package com.sky.datastructure.tree.trie;

/**
 * @ClassName: ArrayTrie
 * @Author garylovekira
 * @Date 2021/10/6
 * @Version 1.0
 */
public class ArrayTrie {
    private static class TrieNode {
        public int path;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            this.path = 0;
            this.end = 0;
            this.nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        public TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            int index = 0;
            TrieNode node = root;
            for (int i = 0; i < chars.length ; i++) {
                char curChar = chars[i];
                index = curChar - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }

        public void delete(String word) {
           if (search(word) != 0) {
               char[] chars = word.toCharArray();
               TrieNode node = root;
               int index = 0;
               for (int i = 0; i < chars.length ; i++) {
                   index = chars[i] - 'a';
                   if (--node.nexts[index].path == 0) {
                       node.nexts[index] = null;
                   }
                   node = node.nexts[index];
               }
               node.end--;
           }
        }


        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            int index = 0;
            TrieNode node = root;
            for (int i = 0; i < chars.length ; i++) {
                char curChar = chars[i];
                index = curChar - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }
}
