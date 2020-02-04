package com.sky.tree.bst;

import java.util.ArrayList;
import java.util.Random;

/***
 * @ProjectName DataStructure
 * @Title: TestBST
 * @Description:
 * @author Sky
 * @date 2020/2/3 22:19
 * @Version V1.0.0
 */
public class TestBST {
//    public static void main(String[] args) {
//        BST<Integer> bst = new BST<>();
//        int arr[] = new int[]{5, 3, 6, 8, 4, 2};
//        ////////////////////
//        //      5         //
//        //    /   \       //
//        //   3     6      //
//        //  / \      \    //
//        // 2   4      8   //
//        ////////////////////
//        for (int i = 0; i < arr.length; i++) {
//            bst.add(arr[i]);
//        }
//
//        bst.preOrder();
//        System.out.println();
//
//        bst.levelOrder();
//
//    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> arrayList = new ArrayList();
        while (!bst.isEmpty()) {
            arrayList.add(bst.removeMin());
        }

        System.out.println(arrayList);

    }
}
