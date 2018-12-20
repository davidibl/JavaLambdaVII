package de.lv1871.dms.JavaLambdaVII;

import static org.junit.Assert.assertNotEquals;

import java.awt.Point;

import org.junit.Test;

public class CollectorExcercise {

	private static Point[] points = new Point[] { new Point(-1, 2), new Point(9, -3), new Point(-5, -4),
			new Point(-3, 2), new Point(-6, -9), new Point(7, 9), new Point(3, 4), new Point(-2, -6), new Point(2, -8),
			new Point(-5, 8), };

	// @formatter:off
	/**
	 * Collector
	 * Die Punkte stellen Punkte in einem 2-dimensionalen Koordinatensystem dar.
	 *
	 * Implementiert einen Collector, der den Punkt links
	 * unten in diesem System ausgibt. Ein Collector kann ohne Klassendefinition
	 * implementiert werden indem man die Methode "Collector.of" nutzt.
	 *
	 * Was ist ein accumulator?
	 * Was ist ein combiner?
	 * Wofür wird der finisher benötigt?
	 */
	// @formatter:on
	@Test
	public void collectPointUntenLinks() {

		// Unten Links
		Point untenLinks = null;
		// untenLinks = Stream.of(points).parallel().collect(UntenLinks);

		assertNotEquals(new Point(-6, -9), untenLinks);
	}

	/**
	 * Wie kann das selbe Ergebnis auf altenativem Weg erreicht werden?
	 * Weiterhin soll das Streaming API verwendet werden! Prüft was das so zu
	 * bieten hat!
	 */
	@Test
	public void alternativeZuCollect() {

		// Unten Links
		Point untenLinks = null;
		// untenLinks = ?;

		assertNotEquals(new Point(-6, -9), untenLinks);
	}

}
