package com.jeffcode.demo.Concurrent;

import org.junit.Test;

import java.util.Optional;
import java.util.stream.IntStream;

public class JoinTest {

    // 在未使用join的情况下，这两个线程肯定是交替打印
    @Test
    public void 两个线程打印一串数字() {
        Thread t1 = new Thread(() -> {
            IntStream.range(1, 1000)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        t1.start();

        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1, 1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
    }

    @Test
    public void t1打印完再执行main的操作() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            IntStream.range(1, 1000)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        t1.start();
        //这里就要使用到join
        t1.join();

        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1, 1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
    }

    @Test
    public void t1t2交替打印_打印完再执行main的操作() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            IntStream.range(1, 1000)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });
        Thread t2 = new Thread(() -> {
            IntStream.range(1, 1000)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1, 1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
    }

    // 使用此方法，当前线程一直等自己执行完毕，但是没有执行完，因为他在等自己执行完毕
    @Test
    public void 程序一直不中断的方法() throws InterruptedException {
        Thread.currentThread().join();
    }
    }
