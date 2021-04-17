package com.sky.algorithm.sort;

import com.sky.algorithm.CommonUtil;

import javax.swing.*;
import java.util.Arrays;

/**
 * @ClassName: 归并排序
 * @Author Administrator
 * @Date 2020/3/29
 * @Version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int nums[] = {3, 8, 2, 4, 1, 9, 6, 5};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    private static void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);

    }

    /**
     * 将数组分成两半， 分别递归排序， 最终把得到的结果合并
     * @param nums
     * @param low
     * @param high
     * @param temp
     */
    private static void mergeSort(int[] nums, int low, int high, int[] temp) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(nums, low, mid, temp);
        mergeSort(nums, mid + 1, high, temp);

        merge(nums, low, mid, high, temp);
    }

    private static void merge(int[] nums, int low, int mid, int high, int[] temp) {

        int i = low; // 第一个合并数组开始位置
        int j = mid + 1; //第二个数组开始位置

        int t = 0;

        while (i <= mid && j <= high) {
            if (nums[i] >= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }

        while (i <= mid) {// 比较完发现第一个数组还有剩余的元素， 放到temp中
            CommonUtil.print("原始temp = %s, ");
            temp[t++] = nums[i++];
        }
        while (j <= high) {// 比较完发现第二个数组还有剩余的元素， 放到temp中
            temp[t++] = nums[j++];
        }

        t = 0;
        while (low <= high) {//将temp中排序好的元素拷贝到nums
            nums[low++] = temp[t++];
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;

        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
    }
}
