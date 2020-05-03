package com.sky.algorithm.partition;

import com.sky.algorithm.CommonUtil;
import java.util.Arrays;

/**
 * @ClassName: Partition
 * @Author Administrator
 * @Date 2020/5/2
 * @Version 1.0
 */
public class Partition {
    public static void main(String[] args) {
        //        int[] arr = new int[]{2,1,3,8,7,4};
        int arr[] = {3, 8, 2, 4, 5, 1, 9, 6, 5};
        int[] results = partitionDouble(arr, 0, arr.length-1, 5);
        System.out.println(Arrays.toString(results));
    }

    /**
     * 单边分区
     * <p>
     * 给定一个数组arr，和一个数num，请把小于等于num的数放在数 组的左边，大于num的数放在数组的右边。
     *
     * @param arr
     * @param num
     * @return
     */
    private static int[] partitionSingle(int[] arr, int num) {
        int x = -1;//小于等于num的区域
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                //将小于等于num的元素换到x+1位置， x++,扩充边界
                CommonUtil.swap(arr, x + 1, i);
                x++;
            }
        }

        return arr;
    }

    /**
     * 荷兰国旗问题
     *
     * 给定一个数组arr，和一个数num，请把小于num的数放在数组的 左边，等于num的数放在数组的中间，大于num的数放在数组的 右边。
     *
     * @param arr
     * @param L
     * @param R
     * @param num
     * @return
     */
    private static int[] partitionDouble(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        int cur = L;

        while (cur < more) {
            if (arr[cur] < num) {
                CommonUtil.swap(arr, ++less, cur++);//将less后一位（less先移动，所以用++less）与cur交换， cur移动到下一个位置(所以用cur++)
            } else if (arr[cur] > num) {
                CommonUtil.swap(arr, --more, cur);//将more前一位与cur交换， 由于此时more交换过来的元素不确定是否在哪个区间，所以cur不移动， 继续跑while循环
            } else {// arr[cur] = num情况，不需要对more或less进行操作，直接右移cur
                cur++;
            }
        }

        return new int[]{less + 1, more - 1};
    }
}
