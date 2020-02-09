package com.jeffcode.demo.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* 方法引用的四种方式
* */
public class MethodReferenceTest {

    // 类名::静态方法
    @Test
    public void 方法引用方式一() {
        new Thread(MethodReferenceClass::method1).start();

        new Thread(() -> MethodReferenceClass.method1()).start();
    }

    // 对象::方法
    @Test
    public void 方法引用方式二() {
        new Thread(() -> System.out.println("")).start();

        new Thread(System.out::println).start();
    }

    @Test
    public void 方法引用方式三() {
        List<String> strings = Arrays.asList("jeff", "tom", "frank", "Lisa");
        Collections.sort(strings, (name1, name2) -> name1.compareToIgnoreCase(name2));
        strings.forEach(System.out::println);

        Collections.sort(strings, String::compareToIgnoreCase);
        strings.forEach(System.out::println);
    }

    // 类名::new
    @Test
    public void 方法引用方式四() {
    }
}

class MethodReferenceClass {
    public static void method1 () {
        System.out.println("This is method1");
        }

    public void method2 () {
        this.method1();
    }
}
