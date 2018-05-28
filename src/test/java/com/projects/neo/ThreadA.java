package com.projects.neo;

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
public class ThreadA extends Thread{
    private Object lock;

    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    /**
     * wait 方法
     方法wait()的作用是使当前执行代码的线程进行等待，该方法会将该线程放入“预执行队列”中，并且在 wait() 所在的代码处停止执行，直到接到通知或被中断为止。

     在调用wait()之前，线程必须获得该对象级别锁，这是一个很重要的地方，很多时候我们可能会忘记这一点，即只能在同步方法或同步块中调用wait()方法。

     还需要注意的是wait()是释放锁的，即在执行到wait()方法之后，当前线程会释放锁，当从wait()方法返回前，线程与其他线程竞争重新获得锁。
     */
    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.println("wait begin " + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end  " + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
