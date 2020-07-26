package com.jingchu.method.Intrace;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @description: 函数式接口测试用例
 * @author: JingChu
 * @createtime :2020-07-26 14:31:21
 **/
public class MyTest {
    @FunctionalInterface
    interface GreetingService {
        void sayMessage(String message);
    }

    /**
     * Consumer< T>： 消费性接口 void accept(T t);
     * <p>
     * Supplier< T> ： 供给型接口 T get();
     * <p>
     * Function<T, R>： 函数式接口 R apply(T t);
     * <p>
     * Predicate< T>： 断言型接口 boolean test(T t);
     */

    //Consumer消费行接口测试
    @Test
    public void tset() {
        pay(1000, (m) -> System.out.println("景初购买学习资料花费：" + m + "元"));
    }

    public void pay(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    //Supplier供给型接口测试
    @Test
    public void test1() {
        List<Integer> list = getNumsList(5, () -> (int) (Math.random() * 100));
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    //需求：产生一些整数放入集合内
    public List<Integer> getNumsList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = supplier.get();
            list.add(integer);
        }
        return list;
    }

    //Function 函数行接口：
    @Test
    public void test2() {
        Integer n = strHandler("\t\t   景初努力学习java   ", (str) -> str.trim().length());
        System.out.println(n);
    }

    //需求：处理字符串
    public Integer strHandler(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    //Predicate 断言型接口
    @Test
    public void test3() {
        List<String> list = Arrays.asList("hello", "jingchu", "world", "java", "lambda");
        List<String> res = filterStr(list, (s) -> s.length() > 4);
        for (String str : res) {
            System.out.println(str);
        }
    }

    //需求：将满足条件的字符串放入字符串集合中
    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        List<String> res = new ArrayList<>();
        for (String str : list) {
            if (predicate.test(str)) {
                res.add(str);
            }
        }
        return res;
    }
}
