package com.sky.algorithm.sort;

import java.util.Arrays;

import static com.sky.algorithm.CommonUtil.swap;

/**
 * @ClassName: InsertSort
 * @Author Administrator
 * @Date 2020/3/27
 * @Version 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{2,1,3,8,7,4};
        int[] arr = new int[]{9, 8, 1, 4, 2, 3, 5, 6, 7, 13, 12, 14, 11, 15, 16, 17, 19, 18, 10};
        doSort1(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static void doSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];

            // 当前被比较元素的前一个位置
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                // 将前一个元素移动到后一个元素位置
                arr[j + 1] = arr[j];
                j--;
            }

            // 在j+1位置插入temp（此时temp在[0,i]区间内已经排好序）
            if (j != i - 1) {
                arr[j + 1] = temp;
            }
        }
    }

    private static void doSort2(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            // 利用二分法，定位需要插入的位置

            int index = binarySearchIndex(arr, i - 1, arr[i]);

            if (index != i) {
                int temp = arr[i];
                int j;
                for (j = i - 1; j >= index && j >= 0; j--) {
                    arr[j + 1] = arr[j];
                }

                arr[j + 1] = temp;
            }

        }
    }

    private static int binarySearchIndex(int[] arr, int i, int data) {
        int left = 0;
        int right = i;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (data >= arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }


    /**
     * 插入扑克牌
     * @param arr
     * @return
     */
    private static int[] doSort1(int[] arr) {
        if (arr == null) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {// 从第二位开始， 依次往后
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {// j起始是被比较数的前一位， 然后与被比较数比较
                swap(arr, j, j + 1);
            }
        }

        return arr;
    }
}
