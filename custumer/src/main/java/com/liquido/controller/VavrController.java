package com.liquido.controller;


import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Function3;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Option;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/vavr")
public class VavrController {


    @GetMapping("test")
    public void queryRefund(){
        //tuple
        final Tuple2<String, Integer> tuple = Tuple.of("刘凌峰", 23);
        final String name = tuple._1;
        final Integer age = tuple._2;
        //map
        final Tuple2<String, Integer> map = tuple.map(s -> s.substring(2) + "vavr", i -> i);
        final String key = map._1;
        log.info(key);

        Tuple2<String, Integer> that = tuple.map(
                (s, i) -> Tuple.of(s.substring(2) + "vr", i / 8)
        );
        log.info(that._1);
        log.info("that._2:{}",that._2);

        final String apply = tuple.apply((s, i) -> s + i);
       log.info("apply:{}",apply);

        // sum.apply(1, 2) = 3
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        final Integer apply1 = sum.apply(1).apply(2);
        log.info(apply1.toString());

        Function3<String, String, String, String> function3 =
                Function3.of(this::methodWhichAccepts3Parameters);
        final String apply2 = function3.apply("peng").apply("yang").apply("liang");

        log.info("apply2:{}",apply2);

        Function1<Integer, Integer> plusOne = a -> a + 1;
        Function1<Integer, Integer> multiplyByTwo = a -> a * 2;

        //andThen
        Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.andThen(multiplyByTwo);

        if (add1AndMultiplyBy2.apply(2)==6) {
            log.info("add1AndMultiplyBy2  6");
        }
        //compose
        final Function1<Integer, Integer> compose = multiplyByTwo.compose(plusOne);
        if (compose.apply(2)==6) {
            log.info("compose  6");
        }

        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;
        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);

        Option<Integer> i1 = safeDivide.apply(1, 0);
        Option<Integer> i2 = safeDivide.apply(4, 2);
        log.info("i1:{}",i1.toString());
        final Integer integer = i2.get();
        log.info("i2:{}",integer);


        Function2<Integer, Integer, Option<Integer>> sumary = Function2.lift(this::sum);
        // = None
        Option<Integer> optionalResult = sumary.apply(-1, 2);
        log.info("optionalResult:{}",optionalResult);
    }

    private String methodWhichAccepts3Parameters(String t1, String t2, String t3) {
        return t1+t2+t3;
    }


    private int sum(int first, int second) {
        if (first < 0 || second < 0) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
        return first + second;
    }
}


