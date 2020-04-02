package com.sky.datastructure.queue;

import java.util.Random;

/***
 * @ProjectName DataStructure
 * @Title: Test
 * @Description:
 * @author Sky
 * @date 2019/6/9 11:13
 * @Version V1.0.0
 */
public class Test {
    
    /**
     * @Author Sky
     * @Description 测试入队出队消耗时间， 单位：秒
     * @Date 2019/6/9 
     * @Param [q, opCount]
     * @Version: 1.0.0       
     * @return double
     **/
    private static double  testQueue(Queue q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0 ; i < opCount; i ++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;

        System.out.println("arrayqueue: " + testQueue(new ArrayQueue(), opCount));
        System.out.println("loopqueue: " + testQueue(new LoopQueue(), opCount));
    }
}
