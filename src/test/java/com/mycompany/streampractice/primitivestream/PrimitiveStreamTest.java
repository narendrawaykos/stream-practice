package com.mycompany.streampractice.primitivestream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class PrimitiveStreamTest {

	@Test
	void intStream_rangeTest() {
		// range(inclusive, endExclusive)
		IntStream intStream = IntStream.range(1, 10);
		assertEquals(9, intStream.count());
	}

	@Test
	void intStream_rangeCloseTest() {
		// range(inclusive, endInclusive)
		IntStream intStream = IntStream.rangeClosed(1, 10);
		assertEquals(10, intStream.count());
	}

	@Test
	void intStream_minMaxTest() {
		IntStream intStream = IntStream.of(40, 20, 10, 77, 10, 50, 11, 2, 3, 30);
		assertEquals(2, intStream.min().getAsInt());
		IntStream intStream2 = IntStream.of(40, 20, 10, 77, 10, 50, 11, 2, 3, 30);
		assertEquals(77, intStream2.max().getAsInt());
	}

	@Test
	void intStream_distinct() {
		IntStream intStream = IntStream.of(40, 10, 11, 11, 2, 3, 2, 5);
		assertArrayEquals(IntStream.of(40, 10, 11, 2, 3, 5).toArray(), intStream.distinct().toArray());
	}

}
