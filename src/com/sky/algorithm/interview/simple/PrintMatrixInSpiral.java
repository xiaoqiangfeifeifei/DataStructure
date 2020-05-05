package com.sky.algorithm.interview.simple;

/**
 * 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 *
 * @ClassName: PrintMatrixInSpiral
 * @Author Administrator
 * @Date 2020/5/4
 * @Version 1.0
 */
public class PrintMatrixInSpiral {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                         {4, 5, 6},
                         {7, 8, 9},
                        {10, 11, 12}};

        printMatrix(matrix);
    }

    /**
     * 打印主函数
     *
     * @param matrix
     */
    private static void printMatrix(int[][] matrix) {
        int TR = 0;// TOP Row, 左上角行
        int TC = 0;// TOP Column, 左上角列
        int BR = matrix.length - 1; // 右下角的行
        int BC = matrix[0].length - 1;//右下角的列

        //每经过一个循环， 左上角右下角坐标往内圈移动一个位置
        while (TR <= BR && TC <= BC) {
            printEdge(matrix, TR++, TC++, BR--, BC--);
        }

    }

    private static void printEdge(int[][] matrix, int tr, int tc, int br, int bc) {
        if (tr == br) {//行相等，打印整行
            for (int i = tc; i <= bc; i++) {
                System.out.print(matrix[tr][i] + " ");
            }
        } else if (tc == bc) {//列相等，打印整列
            for (int i = tr; i <= br ; i++) {
                System.out.print(matrix[i][tc] + " ");
            }
        } else {
            int curR = tr;
            int curC = tc;

            while (curC < bc) {//用!=条件也可以
                System.out.print(matrix[tr][curC] + " ");
                curC++;
            }

            while (curR < br) {//用!=条件也可以
                System.out.print(matrix[curR][bc] + " ");
                curR++;
            }

            while (curC > tc) {//用!=条件也可以
                System.out.print(matrix[br][curC] + " ");
                curC--;
            }

            while (curR > tr) {//用!=条件也可以
                System.out.print(matrix[curR][tc] + " ");
                curR--;
            }
        }
    }
}
