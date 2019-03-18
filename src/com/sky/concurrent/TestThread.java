package com.sky.concurrent;

/***  
 * @ProjectName DataStructure
 * @Title: TestThread
 * @Description:
 * @author Sky
 * @date 2019/3/17 21:49
 * @Version V1.0.0
 */
public class TestThread {
    private long count = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(clac());
    }

    private void add10k() {
        int idx = 0;
        while (idx++ < 100000) {
            count+=1;
        }
    }

    public static long clac() throws InterruptedException {
        final TestThread test = new TestThread();
        Thread th1 = new Thread(() -> {
           test.add10k();
        });
        Thread th2 = new Thread(() -> {
            test.add10k();
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();
        return test.count;
    }

}
