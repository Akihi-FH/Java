package org.fh.writtenexam;

import java.util.concurrent.Semaphore;

public class NThreadPrint {
    private final static int THREAD_COUNT = 3;
    static int result = 0;
    static int maxNum = 10;

    public static void main(String[] args) throws InterruptedException {
        Semaphore[] semaphores = new Semaphore[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            // 每个信号量初始计数都为1
            semaphores[i] = new Semaphore(1);
            if (i != 0) {
                System.out.println(i + "===" + semaphores[i].getQueueLength());
                //for 循环之后只有 syncObjects[0] 没有获取信号量
                semaphores[i].acquire();
            }
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            // 初次执行，当前信号量是 syncObjects[0]
            Semaphore currentSemphore = semaphores[i];
            Semaphore nextSemphore = i == THREAD_COUNT - 1 ? semaphores[0] : semaphores[i + 1];
            new Thread(() -> {
                try {
                    while (true) {
                        // 初次执行，让syncObjects[0] 获得信号量
                        currentSemphore.acquire();
                        if (result>maxNum){
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + ": " + result++);
                        // 释放下一个信号量，syncObjects[1] ，下次 for 循环的当前信号量即为syncObjects[1]
                        nextSemphore.release();
                    }
                    nextSemphore.release();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "thread" + i).start();
        }
    }
}
