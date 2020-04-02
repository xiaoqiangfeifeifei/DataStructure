package com.sky.algorithm.sort;

import java.util.Arrays;

import static com.sky.algorithm.CommonUtil.print;
import static com.sky.algorithm.CommonUtil.swap;

/**
 * @ClassName: SelectSort
 * @Author Administrator
 * @Date 2020/3/27
 * @Version 1.0
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,8,7,4};
        doSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static void doSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                swap(arr, i, minIndex);
            }
        }
    }
}
