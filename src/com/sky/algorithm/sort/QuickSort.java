package com.sky.algorithm.sort;


import com.sky.algorithm.CommonUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName: QuickGrant
 * @Author Administrator
 * @Date 2020/4/2
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 1, 4, 2, 3, 5, 6, 7, 13, 12, 14, 11, 15, 16, 17, 19, 18, 10};
        sortClassicOptimized(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    private static void sortByIterate(int[] arr, int startIndex, int endIndex) {
        //用一个集合栈来代替函数的递归栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();
        Map rootParam = new HashMap();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        while (!quickSortStack.isEmpty()) {
            // 栈定元素出栈，得到起止下标
            Map<String, Integer> param = quickSortStack.pop();
            //得到基准元素的位置
            int pivotIndex = partitionDoubleCycle(arr, param.get("startIndex"), param.get("endIndex"));

            // 根据起止元素分成两部分，把每一部分的起止下标入栈
            if (param.get("startIndex") < pivotIndex - 1) {
                Map leftParam = new HashMap();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }

            if (pivotIndex + 1 < param.get("endIndex")) {
                Map rightParam = new HashMap();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    private static void sort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partitionSingleCycle(arr, startIndex, endIndex);

        sort(arr, startIndex, pivotIndex - 1);
        sort(arr, pivotIndex + 1, endIndex);
    }

    // 双边指针循环法
    private static int partitionDoubleCycle(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];

        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        // 将pivot与指针碰撞处元素交换
        int temp = arr[left];
        arr[left] = pivot;
        arr[startIndex] = temp;

        return left;
    }

    // 单边指针法
    private static int partitionSingleCycle(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];

        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] <= pivot) {
                mark++;

                int temp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = temp;
            }
        }

        // 将pivot与指针碰撞处元素交换
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;

        return mark;
    }

    /**
     * 经典快排，单指针分区
     * <p>
     * 实质上是每次排好一个元素
     *
     * @param arr
     * @param L
     * @param R
     */
    private static void sortClassic(int[] arr, int L, int R) {
        if (L < R) {
            int pivotIndex = partitionSingleClassic(arr, R);
            sortClassic(arr, L, pivotIndex - 1);
            sortClassic(arr, pivotIndex + 1, R);
        }
    }

    /**
     * 经典快排单边分区， 实质是将arr[r](最后一个位置元素值)排好序， 将<= arr[r]的元素放在数组左边， >arr[r]放在数组右边
     *
     * @param arr
     * @param r
     * @return
     */
    private static int partitionSingleClassic(int[] arr, int r) {
        int x = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= arr[r]) {
                CommonUtil.swap(arr, ++x, i);
            }
        }

        return x;
    }


    /**
     * 优化版本的经典快排
     * <p>
     * 分区算法采用荷兰国旗问题方案
     */
    private static void sortClassicOptimized(int[] arr, int L, int R) {
        if (L < R) {
            CommonUtil.swap(arr, L, L + (int) (Math.random() * (R - L + 1)));
            int[] sortArea = partitionDoubleClassic(arr, L, R);//sortArea是分区后中间区域的起始下标
            sortClassicOptimized(arr, L, sortArea[0] - 1);
            sortClassicOptimized(arr, sortArea[1] + 1, R);
        }
    }

    /**
     * 荷兰国旗分区, 默认用arr[r]分区
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int[] partitionDoubleClassic(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r + 1;

        int cur = l;
        int value = arr[r];
        while (cur < more) {
            if (arr[cur] < value) {
                CommonUtil.swap(arr, cur++, ++less);
            } else if (arr[cur] > value) {
                CommonUtil.swap(arr, cur, --more);
            } else {
                cur++;
            }
        }

        return new int[]{less + 1, more - 1};
    }


}
