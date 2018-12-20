package de.lv1871.dms.JavaLambdaVII;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinaryOperator {

	/**
	 * Binary Operator - Was ist das? Wie funktioniert das? Kommentierte Zeile
	 * einkommentieren und implementieren!
	 */
	@Test
	public void combiner_Fibonacci_ForLoop() {

		long startWert_1 = 1;
		long startWert_2 = 1;

		for (int i = 0; i < 20; i++) {
			long sum = 0; // = FIBONACCI.apply(startWert_1, startWert_2);

			// Shift der Startwerte
			startWert_1 = startWert_2;
			startWert_2 = sum;
		}

		assertEquals(17711L, startWert_2);
	}
}
