package com.sky.algorithm.interview.simple;

import java.util.Arrays;

/**
 * 旋转正方形矩阵
 * 【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成 顺时针旋转90度的样子。
 * 【要求】 额外空间复杂度为O(1)。
 *
 * @ClassName: RotateMatrix
 * @Author Administrator
 * @Date 2020/5/4
 * @Version 1.0
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        rotate(matrix);

        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
    }

    private static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int bR = matrix.length - 1;
        int bC = matrix[0].length - 1;

        while (tR < bR) {
            rotateEdge(matrix, tR++, tC++, bR--, bC--);
        }
    }

    private static void rotateEdge(int[][] matrix, int tR, int tC, int bR, int bC) {
        int times = bC - tC; //交换元素的个数
        for (int i = 0; i != times; i++) {
            int tmp = matrix[tR][tC + i];//第一行的元素
            matrix[tR][tC + i] = matrix[bR - i][tC];//第一个元素位置指向最后一个位置（第四个）元素
            matrix[bR - i][tC] = matrix[bR][bC - i];//第四个元素位置指向第三个元素
            matrix[bR][bC - i] = matrix[tR + i][bC]; //第三个元素位置指向第二个元素
            matrix[tR + i][bC] = tmp; //第二个位置元素指向tmp
        }

    }

}
