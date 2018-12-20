package de.lv1871.dms.JavaLambdaVII;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class BiConsumerExcercise {

	// @formatter:off
	/**
	 * BiConsumer - Was ist das? Was macht das?
	 * Kommentiert die Zeile ein und implementiert die Funktion so dass der test grün wird.
	 */
	// @formatter:on
	@Test
	public void accumulator_Fibonacci() {
		ArrayList<Long> list = new ArrayList<>();
		list.add(1L);
		list.add(1L);

		int lastSumDigitCount = 2;

		// Stream.iterate(1, x -> x + 1).limit(20).forEach(x ->
		// FibonacciConsumer.accept(list, lastSumDigitCount));

		assertEquals(17711L, list.get(list.size() - 1).longValue());
		assertListContainsAllFibonacciDigits(list);
	}

	private void assertListContainsAllFibonacciDigits(ArrayList<Long> list) {
		assertEquals(22, list.size());
	}

}
