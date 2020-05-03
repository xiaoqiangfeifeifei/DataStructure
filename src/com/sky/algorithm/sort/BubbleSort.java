package com.sky.algorithm.sort;

import com.sky.algorithm.CommonUtil;
import java.util.Arrays;

import static com.sky.algorithm.CommonUtil.print;
import static com.sky.algorithm.CommonUtil.swap;

/**
 * 冒泡排序
 *
 * @ClassName: BubbleSort
 * @Author Administrator
 * @Date 2020/3/25
 * @Version 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
//        int[] arr = new int[]{2, 1, 3, 4, 5, 6, 7, 8};
//        System.out.println(Arrays.toString(doSort4(arr)));
        verifySort();
    }


    private static int[] doSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int[] beforeArr = Arrays.copyOf(arr, arr.length);
                    swap(arr, j, j + 1);
                    print("第%s轮，%s->%s,  %s-> %s", i + 1, beforeArr[j], beforeArr[j + 1], Arrays.toString(beforeArr), Arrays.toString(arr));
                }
            }
        }
        return arr;
    }

    private static int[] doSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;

            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int[] beforeArr = Arrays.copyOf(arr, arr.length);
                    swap(arr, j, j + 1);
                    isSorted = false;
                    print("第%s轮，%s->%s,  %s-> %s", i + 1, beforeArr[j], beforeArr[j + 1], Arrays.toString(beforeArr), Arrays.toString(arr));
                }
            }

            if (isSorted) {// 当前回合没有进行排序，说明arr已经是有序的，不用继续循环了
                break;
            }
        }
        return arr;
    }


    private static int[] doSort3(int[] arr) {
        //最后一次交换的位置
        int lastChangeIndex = 0;
        // 当前排序边界，在边界后的元素是有序的
        int sortBorder = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;

            for (int j = 0; j < sortBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    int[] beforeArr = Arrays.copyOf(arr, arr.length);
                    swap(arr, j, j + 1);
                    isSorted = false;
                    lastChangeIndex = j;
                    print("第%s轮，%s->%s,  %s-> %s", i + 1, beforeArr[j], beforeArr[j + 1], Arrays.toString(beforeArr), Arrays.toString(arr));
                    print("下一轮的边界为%s", lastChangeIndex);
                }
            }

            sortBorder = lastChangeIndex;
            if (isSorted) {// 当前回合没有进行排序，说明arr已经是有序的，不用继续循环了
                break;
            }
        }
        return arr;
    }


    private static int[] doSort4(int[] arr) {
        if (arr == null) {
            return arr;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i ,i+1);
                }
            }
        }

        return arr;
    }


    private static void verifySort() {
        int times = 500000;
        int maxSize = 10;
        int maxValue = 10;
        int[] arr = CommonUtil.generateRandomArray(maxSize, maxValue);
        int[] arrCopy = CommonUtil.copyArr(arr);


        boolean isSuccess = true;
        for (int i=0; i< times; i++) {
            arr = doSort4(arr);
            arrCopy = CommonUtil.rightDoSort(arrCopy);
            if (!CommonUtil.isEqual(arr, arrCopy)) {
                isSuccess = false;
                CommonUtil.print("method result is %s, right method result is %s", Arrays.toString(arr), Arrays.toString(arrCopy));
                break;
            }
        }

        System.out.println(isSuccess ? "nice": "fuck");

        CommonUtil.print("method result is %s, right method result is %s", Arrays.toString(arr), Arrays.toString(arrCopy));
    }

}

