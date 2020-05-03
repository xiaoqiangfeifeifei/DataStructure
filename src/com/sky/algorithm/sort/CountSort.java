package com.sky.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @ClassName: CountSort
 * @Author Administrator
 * @Date 2020/5/3
 * @Version 1.0
 */
public class CountSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{2, 1, 3, 2};
        int[] arr = new int[]{1,5,2,8,2,0,4};
        doSort1(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 适用于[0, 200]范围， 负数会发生数组越界， 超过200创建桶数量太多，占内存
     * @param arr
     */
    private static void doSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        int bucketLength = max + 1;
        int[] bucket = new int[bucketLength];

        //将原数组中的元素值映射到桶中的索引位置
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int i = 0;
        for (int j = 0; j < bucket.length ; j++) {
            while (bucket[j]-- > 0 ) {
                arr[i++] = j;
            }
        }

    }


    private static void doSort2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int arrLength = max - min + 1;
        int[] helpArr = new int[arrLength];

        //将原数组中的元素映射到辅助数组中index的位置 (元素value -> helpArr.Index)
        for (int i = 0; i < arr.length; i++) {
            int helpIndex = arr[i] - min;//偏移量为最小值min
            int oldValue = helpArr[helpIndex];
            if (oldValue == 0) {
                helpArr[helpIndex] = 1;
            } else {
                helpArr[helpIndex] = oldValue + 1;
            }
        }

        //将helpIndex中的值依次输入到新的排序数组中
        int[] results = new int[arr.length];
        int cur = 0;
        for (int i = 0; i < helpArr.length; i++) {
            for (int j = 0, helpValue = helpArr[i]; j < helpValue; helpValue--) {
                results[cur++] = i + min;
            }
        }

        System.out.println("结果：" + Arrays.toString(results));
    }
}
