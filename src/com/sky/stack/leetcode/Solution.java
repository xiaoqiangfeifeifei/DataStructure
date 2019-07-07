
package com.sky.stack.leetcode;

import java.util.Stack;

/***
 * @ProjectName DataStructure
 * @Title: Solution
 * @Description: 扩号匹配
 * @author Sky
 * @date 2019/6/8 0:47
 * @Version V1.0.0
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character character: s.toCharArray()) {
            if (character== '{' || character == '[' || character == '(' ) {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character topChar = stack.pop();
                if (character == '}' && topChar != '{') {
                    return false;
                }
                if (character == ']' && topChar != '[') {
                    return false;
                }
                if (character == ')' && topChar != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    
}
