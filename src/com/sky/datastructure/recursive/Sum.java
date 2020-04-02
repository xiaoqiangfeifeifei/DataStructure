package com.sky.datastructure.recursive;

/***  
 * @ProjectName DataStructure
 * @Title: Sum
 * @Description:
 * @author Sky
 * @date 2020/1/28 15:03
 * @Version V1.0.0
 */
public class Sum {
    public int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 计算[l, n)的和
    public int sum(int[] arr, int l) {
        // 求解基本问题
        if (l == arr.length) {
            return 0;
        }
        // 将原问题转化为更小的问题
        return arr[l] + sum(arr, l + 1);
    }

}
