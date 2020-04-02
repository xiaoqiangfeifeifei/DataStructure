package com.sky.algorithm.sort;

import java.util.Arrays;

import static com.sky.algorithm.CommonUtil.print;
import static com.sky.algorithm.CommonUtil.swap;

/**
 * @ClassName: ShellSort
 * @Author Administrator
 * @Date 2020/3/28
 * @Version 1.0
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3, 8, 7, 4, 9};
        doSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static void doSort(int[] arr) {

        //gap: 步长，每次缩小两倍
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i]; //分组后的最后一个位置元素

                int j = i - gap; //分组中前一个元素index，也就是倒数第二个元素index
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j = j - gap;
                }

                arr[j + gap] = temp;
            }
        }
    }

}
