package com.fizzbuzz.backend;

import com.fizzbuzz.backend.api.core.FizzBuzz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test the fizzbuzz result
 */
@RunWith(SpringRunner.class)
public class FizzbuzzTest {

    @Test
    public void whenGetFizzBuzz_thenReturnStream() {
        // given
        Stream<String> result = Stream.of("1", "2", "A", "4", "B", "A", "7", "8", "A", "B", "11", "A", "13", "14", "AB");

        // when
        Stream<String> found = FizzBuzz.getFizzBuzz(3, 5, 15, "A", "B");

        // then
        assertStreamEquals(result, found);
    }

    private static void assertStreamEquals(Stream<?> s1, Stream<?> s2)
    {
        Iterator<?> iter1 = s1.iterator(), iter2 = s2.iterator();
        while(iter1.hasNext() && iter2.hasNext()) {
            assertEquals(iter1.next(), iter2.next());
        }
        assertTrue(!iter1.hasNext() && !iter2.hasNext());
    }
}
