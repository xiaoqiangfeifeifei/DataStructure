package com.sky.datastructure.hash;

/**
 *
 * 布隆过滤器实例
 * @ClassName: BLFIlter
 * @Author garylovekira
 * @Date 2021/9/25
 * @Version 1.0
 */
public class BLFilter {
    public static void main(String[] args) {
        int arr[] = new int[1000]; // 32000位（ 一个int4字节 8位）

        int hash = 3000;

        int hashIndex = hash / 32; // 桶位置
        int bitIndex = hash % 32;

        arr[hashIndex] = (arr[hashIndex] | (1 >> bitIndex));
        
    }
}
