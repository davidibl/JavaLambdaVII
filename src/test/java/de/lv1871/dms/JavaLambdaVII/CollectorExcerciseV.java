package de.lv1871.dms.JavaLambdaVII;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CollectorExcerciseV {

	/**
	 * Streamtaschenrechner... Berechnet die Formel, ohne Berücksichtigung der
	 * Rechenregeln!
	 */
	@Test
	public void testSth() {
		String formel = "1 +2-5*10+3";
		Double result = null;
		// result = Stream.of(formel.split("")).collect(?);

		assertEquals(new Double(-17), result);
	}
}
