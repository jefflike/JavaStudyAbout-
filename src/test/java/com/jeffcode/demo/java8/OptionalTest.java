package com.jeffcode.demo.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalTest {

    @Test
    public void Optional基础API操作() {
        Optional<List<String>> strings = Optional.ofNullable(Arrays.asList("1", "2", "3"));
//        strings.ifPresent(list -> list.forEach(System.out::println));
        if (strings.isPresent()) {
            List<String> strings1 = strings.get();
            strings1.forEach(System.out::println);
        }
    }

    @Test
    public void 使用ifPresent方法代替isPresent操作() {
        Optional<List<String>> strings = Optional.ofNullable(Arrays.asList("1", "2", "3"));
        strings.ifPresent(list -> list.forEach(System.out::println));
//        strings.ifPresent(list -> System.out.println(list.stream().map(i -> i + "a").collect(Collectors.toList())));
    }

    @Test
    public void 使用orElse方法() {
        Optional<String> strings = Optional.empty();
        String jeff = strings.orElse("jeff");
        System.out.println(jeff);
    }

    @Test
    public void 使用orElseGet方法() {
        Optional<String> strings = Optional.empty();
        String jeff = strings.orElseGet(() -> "jefflike");
        System.out.println(jeff);
    }

    @Test
    public void 使用orElseGe方法() {
        // map返回的还是一个Optional对象
        Optional<List<String>> strings = Optional.ofNullable(Arrays.asList("1", "2", "3", null));
        String s = strings.map(i -> i + "a").orElse("0a");
        System.out.println(s);
    }
}
