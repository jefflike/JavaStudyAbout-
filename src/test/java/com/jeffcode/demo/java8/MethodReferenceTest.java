package com.jeffcode.demo.java8;

import org.junit.Test;

/*
* 方法引用的四种方式
* */
public class MethodReferenceTest {
    @Test
    public void 方法引用方式一() {
        new Thread(MethodReferenceClass::method1).start();

        new Thread(() -> MethodReferenceClass.method1()).start();
    }

    @Test
    public void 方法引用方式二() {

    }

    @Test
    public void 方法引用方式三() {

    }

    @Test
    public void 方法引用方式四() {

    }
}

class MethodReferenceClass {
    public static void method1 () {
        System.out.println("This is method1");
        }
}
