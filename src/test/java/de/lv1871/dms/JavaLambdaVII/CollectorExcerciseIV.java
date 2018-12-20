package de.lv1871.dms.JavaLambdaVII;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CollectorExcerciseIV {

	private static List<Integer> VALUES_CORRECT = Arrays.asList(1);
	private static List<Integer> VALUES_NOT_CORRECT = Arrays.asList(1, 2);

	// @formatter:off
	/**
	 * Finde einen Integer mit einem Collector. Wird mehr als ein Integer
	 * gefunden, soll eine Exception fliegen!
	 * Das bedeutet das für beide Tests nur insgesamt eine Implementierung existieren darf
	 */
	// @formatter:on
	@Test
	public void testFindOne() {

		List<Integer> result = null;
		// result = VALUES_CORRECT.stream().collect(?);

		assertEquals(1, result.size());
		assertEquals(new Integer(1), result.stream().findAny().get());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFindOneFailesBecauseMultipleEntries() {
		List<Integer> result = null;
		// result = VALUES_NOT_CORRECT.stream().collect(?);
	}

	/**
	 * Erweitert die Lösung dahingehend dass man dem Collector übergeben kann
	 * wieviele Einträge in der Liste enthalten sein dürfen
	 */
	// @formatter:off
	@Test
	public void testFindThingsGivenTimes() {

		List<Integer> result = null;
		// result = VALUES_NOT_CORRECT.stream().collect(?);

		assertEquals(2, result.size());
	}

}
