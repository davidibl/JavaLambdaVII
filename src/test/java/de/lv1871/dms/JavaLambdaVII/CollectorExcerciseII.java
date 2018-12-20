package de.lv1871.dms.JavaLambdaVII;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CollectorExcerciseII {

	private static Book[] bookStore = new Book[] { new Book("Book1", 2030), new Book("Book2", 1949),
			new Book("Book3", 815), new Book("Book4", 1499), new Book("Book5", 2499), new Book("Book6", 1225),
			new Book("Book7", 1749), new Book("Book8", 2109), new Book("Book9", 1999), new Book("Book10", 999), };

	/**
	 * Ermittelt den Gesamtpreis aller Bücher mit Hilfe des Streaming APIs
	 */
	@Test
	public void collectGesamtpreis() {

		long gesamtPreis = 0L;
		// gesamtPreis = of(bookStore).collect(?);

		assertEquals(16873L, gesamtPreis);
	}

	/**
	 * Ermittelt den Durchschnittspreis
	 */
	@Test
	public void collectDurchschnittspreis() {

		Double durchschnittspreis = 0.0;
		// durchschnittspreis = Stream.of(bookStore).collect(?);

		assertEquals(new Double(1687.3), durchschnittspreis);
	}

	/**
	 * Ermittelt den Gesamtpreis aller Bücher mit Hilfe des Streaming APIs.
	 * Verwendet hierfür eine Alternative zur ersten Implementierung!
	 */
	@Test
	public void collectGesamtpreisAlternative() {

		long gesamtPreis = 0L;
		// gesamtPreis = of(bookStore).collect(?);

		assertEquals(16873L, gesamtPreis);
	}

	/**
	 * Ermittelt den Durchschnittspreis
	 */
	@Test
	public void collectDurchschnittspreisAlternative() {

		Double durchschnittspreis = 0.0;
		// durchschnittspreis = Stream.of(bookStore).collect(?);

		assertEquals(new Double(1687.3), durchschnittspreis);
	}

	private static class Book {
		private String name;
		private Price price = new Price();

		public String getName() {
			return name;
		}

		public long getPriceInCent() {
			return price.getCentValue();
		}

		private Book(String name, long priceInCent) {
			this.name = name;
			this.price = new Price(priceInCent);
		}
	}

	private static class Price {
		private long centValue;

		private Price() {
			setCentValue(0L);
		}

		private Price(long valueInCent) {
			setCentValue(valueInCent);
		}

		private void setCentValue(long centValue) {
			this.centValue = centValue;
		}

		private long getCentValue() {
			return centValue;
		}
	}

}
