package com.jeffcode.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
        new Thread(() -> {
            System.out.println(111);
        }).start();
    }

    @Test
    public void test2() {
        new Thread(() -> {
            System.out.println(111);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();

        Arrays.asList(threadGroup).forEach(System.out::println);

    }

    @Test
    public void test3() {
//        Optional<String> o = new Optional<>();

        Optional<List<String>> strings = Optional.ofNullable(Arrays.asList("1", "2", "3"));
        strings.ifPresent(list -> list.forEach(System.out::println));
    }
}
