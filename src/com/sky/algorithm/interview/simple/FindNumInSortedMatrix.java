package com.sky.algorithm.interview.simple;

/**
 * 在行列都排好序的矩阵中找数
 * 【题目】 给定一个有N*M的整型矩阵matrix和一个整数K，
 * matrix的每一行和每一 列都是排好序的。实现一个函数，判断K 是否在matrix中。
 * 例如： 0 1 2 5 2 3 4 7 4 4 4 8 5 7 7 9 如果K为7，返回true；如果K为6，返 回false。
 * 【要求】 时间复杂度为O(N+M)，额外空间复杂度为O(1)。
 *
 * @ClassName: FindNumInSortedMatrix
 * @Author Administrator
 * @Date 2020/5/4
 * @Version 1.0
 */
public class FindNumInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 6},
                          {2, 5, 7, 9},
                            {4, 6, 8, 10}};
        System.out.println(isContains(matrix, 6));
    }

    private static boolean isContains(int[][] matrix, int num) {
        //从左上角开始查询 O(M+N)
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col > -1) {
            if (matrix[row][col] == num) {
                return true;
            } else if (matrix[row][col] > num) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}
