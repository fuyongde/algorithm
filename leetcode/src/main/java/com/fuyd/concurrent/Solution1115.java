package com.fuyd.concurrent;

/**
 * 我们提供一个类：
 * <p>
 * class FooBar {
 * public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 * }
 * <p>
 * public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 * }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 * <p>
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。ÒÒÒ
 *
 * @author fuyongde
 * @date 2020/1/17 10:08
 */
public class Solution1115 {

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = () -> System.out.print("foo");
        Runnable r2 = () -> System.out.println("bar");
        Solution1115.FooBar fooBar = new Solution1115.FooBar(6);
        FooThread fooThread = new FooThread(r1, fooBar);
        BarThread barThread = new BarThread(r2, fooBar);
        fooThread.start();
        barThread.start();
    }

    static class FooThread extends Thread {
        FooBar fooBar;
        Runnable runnable;

        public FooThread(Runnable runnable, FooBar fooBar) {
            this.fooBar = fooBar;
            this.runnable = runnable;
        }

        @Override
        public void run() {
            try {
                fooBar.foo(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class BarThread extends Thread {
        FooBar fooBar;
        Runnable runnable;

        public BarThread(Runnable runnable, FooBar fooBar) {
            this.fooBar = fooBar;
            this.runnable = runnable;
        }

        @Override
        public void run() {
            try {
                fooBar.bar(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class FooBar {
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        private volatile boolean finish = false;

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                while (finish) {
                    Thread.yield();
                }
                printFoo.run();
                finish = true;
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                while (!finish) {
                    Thread.yield();
                }
                printBar.run();
                finish = false;
            }
        }
    }
}
