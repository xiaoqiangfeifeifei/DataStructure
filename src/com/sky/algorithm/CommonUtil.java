package com.sky.algorithm;

/**
 * @ClassName: CommonUtil
 * @Author Administrator
 * @Date 2020/3/27
 * @Version 1.0
 */
public class CommonUtil {
    public static int[] swap(int [] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        return arr;
    }

    public static void print(String format, Object... params) {
        System.out.println(String.format(format, params));
    }
}
