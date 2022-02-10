package com.sky.algorithm.skill;

import java.util.Arrays;

/**
 * 差分数组
 *
 * @ClassName: Difference
 * @Author garylovekira
 * @Date 2022/2/8
 * @Version 1.0
 */
public class Difference {

    // 1 4 3 -2 -2
    // 1 5 8 6  4
    private int[] diff;

    public Difference(int[] nums) {
        diff = new int[nums.length];
        this.diff[0] = nums[0];

        for (int i = 1; i < nums.length ; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    // 给[i, j]区间的数字增加num
    public void increment(int i, int j, int num) {
        diff[i] += num;
        if (j + 1 < diff.length) {
            diff[j + 1] -= num;
        }
    }

    public int[] result() {
        int[] nums = new int[diff.length];
        nums[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            nums[i] = diff[i] + nums[i - 1];
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 8, 6, 4};
        Difference difference = new Difference(nums);
        difference.increment(0, 2, 3);
        int[] result = difference.result();
        System.out.println(Arrays.toString(result));

    }
}
