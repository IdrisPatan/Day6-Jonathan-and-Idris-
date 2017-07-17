package com.allstate.compozed.springplayground.math;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@RestController
final class MathController {

    @RequestMapping(path = "/math/square/{number}")
    Map<String, Integer> square(@PathVariable final int number) {
         Map<String, Integer> map = new HashMap<>();
         map.put("square", number * number);

         // Above line is equivalent to
         // return Collections.singletonMap("square", number * number);

        return map;
    }

    @RequestMapping(path = "/math/factorial/{number}")
    Map<String, Integer> factorial(@PathVariable final int number) {
        return Collections.singletonMap("factorial", IntStream.rangeClosed(2, number).reduce(1, ((a, b) -> a * b)));
    }

    @RequestMapping(path = "/math/fibonacci/{number}")
    Map<String, Integer> fibonacci(@PathVariable final int number) {
        return Collections.singletonMap("fibonacci", fibonacciCalculation(number));
    }

    private static int fibonacciCalculation(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        return fibonacciCalculation(n - 1) + fibonacciCalculation(n - 2);
    }


//    int fibonacciCalc(int n)  {
//        if(n == 0)
//            return 1;
//        else if(n == 1)
//            return 1;
//        else
//            return fibonacciCalc(n - 1) + fibonacciCalc(n - 2);
//    }
}
