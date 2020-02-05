package com.sky.set;

import java.util.TreeSet;

/***
 * @ProjectName DataStructure
 * @Title: Solution
 * @Description:
 * @author Sky
 * @date 2020/2/4 22:29
 * @Version V1.0.0
 */
public class Solution {
    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        TreeSet treeSet = new TreeSet();
        for (String word: words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i< word.length(); i++) {
                sb.append(codes[word.charAt(i) - 'a']);
            }
            treeSet.add(sb.toString());
        }

        return treeSet.size();
    }
}
