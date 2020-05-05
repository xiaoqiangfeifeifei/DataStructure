package com.sky.algorithm.interview.simple;

/**
 * “之”字形打印矩阵
 * 【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这 个矩阵
 * ，例如： 1 2 3 4 5 6 7 8 9 10 11 12 “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11， 8，12
 * 【要求】 额外空间复杂度为O(1)
 *
 * @ClassName: ZigZagPrintMatrix
 * @Author Administrator
 * @Date 2020/5/4
 * @Version 1.0
 */
public class ZigZagPrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrixZigZag(matrix);

    }

    private static void printMatrixZigZag(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;

        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;

        boolean fromUp = false;
        while (tR != endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp   );
            tR = tC == endC ? tR + 1 : tR;//如果a行的列没有移动到末尾，则a行维持原状，否则向下移动
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;//如果b行的行没有移动到末尾，则b行向下移动， 否则维持原状
            fromUp = !fromUp;
        }

    }

    private static void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }





}
