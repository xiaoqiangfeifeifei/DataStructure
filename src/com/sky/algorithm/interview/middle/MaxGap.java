package com.sky.algorithm.interview.middle;

/**
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比较的排序。
 *
 * @ClassName: MaxGap
 * @Author Administrator
 * @Date 2020/5/3
 * @Version 1.0
 */
public class MaxGap {
    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        //前一个桶的最大值和后一个桶的最小值进行比较
        for (; i <= len; i++) {//从第二个桶开始比较
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        //(num-min)/(max-min)就是占所有的比例
        //返回的结果是第几个桶
        return (int) ((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 7, 9, 10, 12, 20};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(bucket(arr[i], 7, 3, 20));

        }

    }
}
