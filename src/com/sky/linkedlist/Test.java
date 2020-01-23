package com.sky.linkedlist;

/***  
 * @ProjectName DataStructure
 * @Title: Test
 * @Description:
 * @author Sky
 * @date 2020/1/23 17:28
 * @Version V1.0.0
 */
public class Test {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(1, 2222);
        System.out.println(linkedList);

        linkedList.remove(1);
        System.out.println(linkedList);
    }
}
