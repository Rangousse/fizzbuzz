package com.fizzbuzz.backend.api.core;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Computes fizzbuzz with given data
 */
public class FizzBuzz {
    public static Stream<String> getFizzBuzz(int int1,
                                    int int2,
                                    int limit,
                                    String str1,
                                    String str2) {
        int int1and2 = int1 * int2;
        String str1and2 = str1.concat(str2);
        Stream<String> stream = IntStream.rangeClosed(1, limit)
                .mapToObj(i ->
                        isDivisible(i, int1and2) ? str1and2 :
                                (isDivisible(i, int1) ? str1 :
                                        (isDivisible(i, int2) ? str2 :
                                                String.valueOf(i))));
        return stream;
    }

    private static boolean isDivisible ( int source, int target){
        return source % target == 0;
    }
}
