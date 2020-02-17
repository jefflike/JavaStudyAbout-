package com.jeffcode.demo.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    public void stream的简单使用() {
        List<String> strings = Arrays.asList("1", "2", "3");
        strings.stream().filter(num -> num.equals("1")).mapToInt(num -> Integer.max(2, new Integer(num))).forEach(System.out::println);
    }

    @Test
    public void stream创建方式一() {
        Stream<String> stream = Stream.of("jeff", "tom", "frank", "lisa");
        stream.collect(Collectors.toList()).forEach(System.out::println);
        stream.forEach(System.out::println);
    }

    @Test
    public void stream创建方式二() {
        String[] strings = {"jeff", "tom", "frank", "lisa"};
        Stream<String> stream = Stream.of(strings);
        stream.collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void stream创建方式三() {
        List<String> strings = Arrays.asList("jeff", "tom", "frank", "lisa");
        strings.stream().collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void stream创建方式四() {
        String[] strings = {"jeff", "tom", "frank", "lisa"};
        Arrays.stream(strings).collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void IntStream的range方法() {
        // 1-9
        IntStream.range(1,10).forEach(System.out::println);
        System.out.println("-------------");
        // 3-8
        IntStream.rangeClosed(3,8).forEach(System.out::println);
    }

    @Test
    public void IntStream的List求和() {
        int[] list = {44747, 16067, 8204, 1114, 4800};
        int sum = IntStream.of(list).map(integer -> integer * 2).sum();
        System.out.println(sum);
    }

    @Test
    public void Stream的List求和1() {
        List<Integer> integers = Arrays.asList(44747, 16067, 8204, 1114, 4800);
        int sum1 = integers.stream().mapToInt(i -> 2 * i).sum();
        System.out.println(sum1);
    }

    @Test
    public void Stream的List求和2() {
        List<Integer> integers = Arrays.asList(44747, 16067, 8204, 1114, 4800);
        int sum1 = integers.stream().map(i -> 2 * i).reduce(0 , Integer::sum);
        System.out.println(sum1);
    }

    @Test
    public void Stream转Array1() {
        Stream<String> stream = Stream.of("jeff", "tom", "frank", "lisa");
        String[] strings = stream.toArray(String[]::new);
    }

    @Test
    public void Stream转Array2() {
        Stream<String> stream = Stream.of("jeff", "tom", "frank", "lisa");
        String[] strings = stream.toArray(i -> new String[i]);
    }

    @Test
    public void Stream转List() {
        Stream<String> stream = Stream.of("jeff", "tom", "frank", "lisa");
        stream.collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void collect方法的入参说明2() {
        Stream<String> stream = Stream.of("jeff", "tom", "frank", "lisa");
        stream.collect(() -> new LinkedList<>(), (a, b) -> a.add(b), (a, b) -> a.addAll(b) ).forEach(System.out::println);
    }

    // 使用方法引用进行修改
    @Test
    public void collect方法的入参说明3() {
        Stream<String> stream = Stream.of("jeff", "tom", "frank", "lisa");
        stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll).forEach(System.out::println);
    }

    @Test
    public void test() {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        integers.addAll(integers);
        integers.forEach(System.out::println);
    }

    @Test
    public void collect方法的入参说明4() {
        Stream<String> stream = Stream.of("jeff", "tom", "frank", "lisa", "jeff");
        HashSet<String> collect = stream.collect(Collectors.toCollection(HashSet::new));
        collect.forEach(System.out::println);
    }

    @Test
    public void 方法的入参说明() {
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2), Arrays.asList(1, 2, 3, 4), Arrays.asList(1, 2, 7, 8));
        // 多个list打成扁平的一个stream中
        listStream.flatMap(a-> a.stream()).map(i -> i*2).forEach(System.out::println);
    }
}
