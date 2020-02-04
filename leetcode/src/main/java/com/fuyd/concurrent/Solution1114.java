package com.fuyd.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author fuyongde
 * @date 2019/12/28 16:14
 */
public class Solution1114 {

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = () -> System.out.println("r1");
        Runnable r2 = () -> System.out.println("r2");
        Runnable r3 = () -> System.out.println("r3");
        Foo foo = new Foo();
        foo.first(r1);
        foo.second(r2);
        foo.third(r3);
    }

    static class Foo {

        Semaphore r2 = new Semaphore(1);
        Semaphore r3 = new Semaphore(1);

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            r2.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            r2.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            r3.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            r3.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
