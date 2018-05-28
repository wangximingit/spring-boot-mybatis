package com.projects.neo;

import java.util.HashMap;

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
 * @date 2018/5/7 13:58
 */
public class ThreadB extends Thread{
    private Object lock;

    public ThreadB(Object lock) {
        super();
        this.lock = lock;
    }

    /**
     *
     * notify 方法
     和wait()方法一样，notify()方法也要在同步块或同步方法中调用，即在调用前，线程也必须获得该对象的对象级别锁。

     该方法是用来通知那些可能等待该对象的对象锁的其他线程，如果有多个线程等待，则由线程规划器随机挑选出其中一个呈 wait 状态的线程，对其发出通知 notify，并使它等待获取该对象的对象锁。

     这里需要注意的是，执行 notify 方法之后，当前线程不会立即释放其拥有的该对象锁，而是执行完之后才会释放该对象锁，被通知的线程也不会立即获得对象锁，而是等待 notify 方法执行完之后，释放了该对象锁，才可以获得该对象锁。

     notifyAll()通知所有等待同一共享资源的全部线程从等待状态退出，进入可运行状态，重新竞争获得对象锁。
     */
    @Override
    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    if (MyList.size() == 5) {
                        lock.notifyAll();
                        System.out.println("已发出通知！");
                    }
                    System.out.println("添加了" + (i + 1) + "个元素!");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
