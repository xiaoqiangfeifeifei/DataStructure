package com.sky.algorithm.sort;

import com.sky.algorithm.CommonUtil;

import java.util.Arrays;

/**
 * @ClassName: HeapSort
 * @Author Administrator
 * @Date 2020/5/3
 * @Version 1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        //        int[] arr = new int[]{2,1,3,8,7,4};
        int[] arr = new int[]{9, 8, 1, 4, 2, 3, 5, 6, 7, 13, 12, 14, 11, 15, 16, 17, 19, 18, 10};
        doSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void doSort(int[] arr) {
        if (arr == null) {
            return;
        }

        //1. 将数组调整为最大堆形式
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);//时间复杂度 log0 + log1 + log2 +... + log^N-1 = O(N)
        }
        //2.将最大堆顶元素放到数组尾部
        int heapSize = arr.length;
        CommonUtil.swap(arr, 0, --heapSize);

        //3. 重新建立最大堆，再重复将堆顶元素放到队列尾部
        while (heapSize > 0) {// 时间复杂度 O(N*log^N)
            heapify(arr, 0, heapSize);
            CommonUtil.swap(arr, 0, --heapSize);
        }
    }

    /**
     * 调整最大堆
     *
     * @param arr
     * @param index
     * @param heapSizeIndex
     */
    private static void heapify(int[] arr, int index, int heapSizeIndex) {
        int left = index * 2 + 1;
        while (left < heapSizeIndex) {
            // 当右孩子没有越界， 并且比当前元素大的时候， 取右孩子index为largest，否则取左孩子index
            int largest = left + 1 < heapSizeIndex && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            CommonUtil.swap(arr, index, largest);
            index = largest;//将index变为孩子节点中最大值， 也就是index位置下沉
            left = index * 2 + 1;// 重新计算下沉后的left
        }
    }

    /**
     * 构建最大堆
     * @param arr
     * @param index
     */
    private static void heapInsert(int[] arr, int index) {
        // 如果当前元素大于父元素
        while (arr[index] > arr[(index-1)/2]) {
            CommonUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


}
