package com.sky.algorithm.sort;



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
        sortByIterate(arr, 0, arr.length - 1);
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

        for (int i = startIndex+1; i <= endIndex; i++) {
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

}
