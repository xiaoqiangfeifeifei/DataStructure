package com.sky.algorithm.sort;

import sun.awt.AWTAccessor;

import java.util.Arrays;

/**
 * @ClassName: QuickGrant
 * @Author Administrator
 * @Date 2020/4/2
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 1, 4, 2, 3, 5, 6, 7, 13, 12, 14, 11, 15, 16, 17, 19, 18, 10};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partitionSingleCycle(arr, startIndex, endIndex);

        sort(arr, startIndex, pivotIndex - 1);
        sort(arr, pivotIndex + 1, endIndex);
    }

    private static int partitionDoubleCycle(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];

        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        // 将pivot与指针碰撞处元素交换
        int temp = arr[left];
        arr[left] = pivot;
        arr[startIndex] = temp;

        return left;
    }

    private static int partitionSingleCycle(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];

        int mark = startIndex;

        for (int i = startIndex+1; i <= endIndex; i++) {
            if (arr[i] <= pivot) {
                mark++;

                int temp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = temp;
            }
        }

        // 将pivot与指针碰撞处元素交换
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;

        return mark;
    }

}
