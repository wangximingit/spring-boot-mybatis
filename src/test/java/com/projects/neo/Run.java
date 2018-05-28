package com.projects.neo;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * __
 * ,-~¨^  ^¨-,           _,
 * /          / ;^-._...,¨/
 * /          / /         /
 * /          / /         /
 * /          / /         /
 * /,.-:''-,_ / /         /
 * _,.-:--._ ^ ^:-._ __../
 * /^         / /¨:.._¨__.;
 * /          / /      ^  /
 * /          / /         /
 * /          / /         /
 * /_,.--:^-._/ /         /
 * ^            ^¨¨-.___.:^
 *
 * @author WangXiMin
 * @date 2018/5/7 14:09
 */
public class Run {
    /**
     *wait 方法
     方法wait()的作用是使当前执行代码的线程进行等待，该方法会将该线程放入“预执行队列”中，并且在 wait() 所在的代码处停止执行，直到接到通知或被中断为止。

     在调用wait()之前，线程必须获得该对象级别锁，这是一个很重要的地方，很多时候我们可能会忘记这一点，即只能在同步方法或同步块中调用wait()方法。

     还需要注意的是wait()是释放锁的，即在执行到wait()方法之后，当前线程会释放锁，当从wait()方法返回前，线程与其他线程竞争重新获得锁。

     notify 方法
     和wait()方法一样，notify()方法也要在同步块或同步方法中调用，即在调用前，线程也必须获得该对象的对象级别锁。

     该方法是用来通知那些可能等待该对象的对象锁的其他线程，如果有多个线程等待，则由线程规划器随机挑选出其中一个呈 wait 状态的线程，对其发出通知 notify，并使它等待获取该对象的对象锁。

     这里需要注意的是，执行 notify 方法之后，当前线程不会立即释放其拥有的该对象锁，而是执行完之后才会释放该对象锁，被通知的线程也不会立即获得对象锁，而是等待 notify 方法执行完之后，释放了该对象锁，才可以获得该对象锁。

     notifyAll()通知所有等待同一共享资源的全部线程从等待状态退出，进入可运行状态，重新竞争获得对象锁。

     wait()/notify() 方法总结

     wait()/notify() 要集合 Synchronized 关键字一起使用，因为他们都需要首先获取该对象的对象锁；

     wait 方法是释放锁，notify 方法是不释放锁的；

     * @param args
     */
//    public static void main(String[] args) {
//        try {
//            Object lock = new Object();
//            ThreadA a = new ThreadA(lock);
//            a.start();
//            Thread.sleep(50);
//            ThreadA c = new ThreadA(lock);
//            c.start();
//            ThreadB b = new ThreadB(lock);
//            b.start();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//------------------------------------------------------------------------
//    public static void main(String[] args) {
//
//        Lock lock = new ReentrantLock();
//
//        //lambda写法
//        new Thread(() -> runMethod(lock), "thread1").start();
//        new Thread(() -> runMethod(lock), "thread2").start();
//        new Thread(() -> runMethod(lock), "thread3").start();
//        new Thread(() -> runMethod(lock), "thread4").start();
//        //常规写法
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                runMethod(lock);
//            }
//        }, "thread5").start();
//    }
//
//    private static void runMethod(Lock lock) {
//        lock.lock();
//        for (int i = 1; i <= 5; i++) {
//            System.out.println("ThreadName:" + Thread.currentThread().getName() + (" i=" + i));
//        }
//        System.out.println();
//        lock.unlock();
//    }




//------------------------------------------------------------------------
//    public static void main(String[] args) {
//
//        Lock lock = new ReentrantLock();
//
//        new Thread(() -> runMethod(lock, 0), "thread1").start();
//        new Thread(() -> runMethod(lock, 5000), "thread2").start();
//        new Thread(() -> runMethod(lock, 1000), "thread3").start();
//        new Thread(() -> runMethod(lock, 5000), "thread4").start();
//        new Thread(() -> runMethod(lock, 1000), "thread5").start();
//    }
//
//    private static void runMethod(Lock lock, long sleepTime) {
//        lock.lock();
//        try {
//            Thread.sleep(sleepTime);
//            System.out.println("ThreadName:" + Thread.currentThread().getName());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }


    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        //使用同一个LockConditionDemo对象，使得lock、condition一样
        Run demo = new Run();
        new Thread(() -> demo.await(), "thread1").start();
        new Thread(() -> demo.await(), "thread4").start();
        Thread.sleep(3000);
        new Thread(() -> demo.signal(), "thread2").start();
    }

    private void await() {
        try {
            lock.lock();
            System.out.println("开始等待await！ ThreadName：" + Thread.currentThread().getName());
            condition.await();
            System.out.println("等待await结束！ ThreadName：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void signal() {
        lock.lock();
        System.out.println("发送通知signal！ ThreadName：" + Thread.currentThread().getName());
        condition.signalAll();
        lock.unlock();
    }
//    public static void main(String[] args) {
//        int[] arr = {10, 21, 23, 12, 3, 4, 7, 11};
////奇数在前偶数在后
////        for (int i=0;i<arr.length-1;i++) {
////            int index = i;
////            if(arr[index]%2==0){
////                for (int t=i+1;t<arr.length;t++){
////                    if (arr[t]%2!=0){
////                        index = t;
////                        break;
////                    }
////
////                }
////                int temp = arr[index];
////                arr[index] = arr[i];
////                arr[i] = temp;
////            }
////
////        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int t = 0; t < arr.length-1-i; t++) {
//                if (arr[t + 1] > arr[t]) {
//                    int temp = arr[t];
//                    arr[t] = arr[t + 1];
//                    arr[t + 1] = temp;
//                }
//
//            }
//
//        }
//        for (int a : arr) {
//            System.out.println(a);
//        }
//    }
//    private static final int THREAD_COUNT_NUM = 7;
//    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT_NUM);
//
//    public static void main(String[] args) throws InterruptedException {
//
//        for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
//            int index = i;
//            new Thread(() -> {
//                try {
//                    System.out.println("第" + index + "颗龙珠已收集到！");
//                    //模拟收集第i个龙珠,随机模拟不同的寻找时间
//                    Thread.sleep(new Random().nextInt(3000));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                //每收集到一颗龙珠,需要等待的颗数减1
//                countDownLatch.countDown();
//            }).start();
//        }
//        //等待检查，即上述7个线程执行完毕之后，执行await后边的代码
//        countDownLatch.await();
//        System.out.println("集齐七颗龙珠！召唤神龙！");
//    }
//    public static void main(String[] args) {
////        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
////        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
//        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0L,
//                TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<>(100),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy());
////        for (int i = 0; i < 100; i++) {
////            final int index = i;
//
////            executorService.execute(new Runnable() {
////
////                public void run() {
////                    try {
////                        System.out.println(index);
////                        Thread.sleep(2000);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                }
////            });
////        }
//
//
//        for (int i = 0; i < 100; i++) {
//            int index = i;
//            executorService.submit(() -> System.out.println("i:" + index +
//                    " executorService"));
//
//        }
//        executorService.shutdown();
//        new CountDownLatch(2);
//        new CyclicBarrier(1,new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//
//    }
//    public static void main(String[] args) {
////        int[] arr = {10, 21, 23, 12, 3, 4, 7, 11};
////
////        int temp ;
////        for (int i = 0; i < arr.length-1; i++) {
////            for (int j = 0; j < arr.length-1-i; j++) {
////                if(arr[j]<arr[j+1]){
////                    temp = arr[j+1];
////                    arr[j+1]=arr[j];
////                    arr[j] = temp;
////                }
////            }
////
////        }
////        for (int i:arr ) {
////            System.out.println(i);
////        }
//
//        List<Integer> list = new ArrayList();
//        list.add(1);
//        list.add(21);
//        list.add(31);
//        list.add(41);
//        list.add(51);
//        Iterator it = list.iterator();
//        while(it.hasNext()){
//            if(it.next().equals(21)){
//                it.remove();
//            }
//        }
//        for (int ss:list) {
//            System.out.println(ss);
//        }
//    }


}
