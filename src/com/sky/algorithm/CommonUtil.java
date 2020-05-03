package com.sky.algorithm;

import java.util.Arrays;

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

    public static int[] generateRandomArray(int size, int value) {
        int [] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = (int) ((value + 1) * Math.random() - (value * Math.random()));
        }
        return arr;
    }


    public static int[] copyArr(int[] arr) {
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, newArr.length);
        return newArr;
    }


    public static int[] rightDoSort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }


    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


}
