package de.lv1871.dms.JavaLambdaVII;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class CollectorExcerciseIII {

	private static Book[] bookStore = new Book[] { new Book("Book1", 2030), new Book("Book2", 1949),
			new Book("Book3", 815), new Book("Book4", 1499), new Book("Book5", 2499), new Book("Book6", 1225),
			new Book("Book7", 1749), new Book("Book8", 2109), new Book("Book9", 1999), new Book("Book10", 999), };

	// @formatter:off
	/**
	 * Gruppiert die Bücher nach Preiskategorie.. Die Kategorien sollen hierbei jeweils 10 Euro sein.
	 * Kategeorie 1: < 1000 Cent
	 * Kategeorie 2: < 2000 Cent
	 * Kategeorie 3: < 3000 Cent
	 * ....
	 * Verwendet heirfür das Collectors API
	 */
	// @formatter:on
	@Test
	public void testGroupBooksbyPriceCategory() {

		Map<Long, List<Book>> booksByPriceCategory = null;

		assertEquals(2, booksByPriceCategory.get(1000L).size());
		assertEquals(5, booksByPriceCategory.get(2000L).size());
		assertEquals(3, booksByPriceCategory.get(3000L).size());

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
