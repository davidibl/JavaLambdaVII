package de.lv1871.dms.JavaLambdaVII.gol;

import static de.lv1871.dms.JavaLambdaVII.gol.Field.isAlive;
import static de.lv1871.dms.JavaLambdaVII.gol.Field.isDead;
import static de.lv1871.dms.JavaLambdaVII.gol.Field.mapToSign;
import static de.lv1871.dms.JavaLambdaVII.gol.Field.toAliveField;
import static de.lv1871.dms.JavaLambdaVII.gol.Field.toDeadField;
import static de.lv1871.dms.JavaLambdaVII.gol.Gameboard.initRandomGame;
import static de.lv1871.dms.JavaLambdaVII.gol.Gameboard.livingNeighboursIn;
import static de.lv1871.dms.JavaLambdaVII.gol.LambdaPredicateExtension.and;
import static de.lv1871.dms.JavaLambdaVII.gol.LambdaPredicateExtension.or;
import static de.lv1871.dms.JavaLambdaVII.gol.LambdaPredicateExtension.which;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Aufgabe 1: Ziel dieser Aufgabe ist es die Ausgabe im Log über einen Collector
 * zu realisieren.
 *
 * Hierbei sollte die erneute Transformation in ein Entryset und der zweite call
 * auf .stream entfallen.
 *
 *
 * Aufgabe 2: Der Ausgabealgorythmus soll generisch sein. D.h. Die
 * Transformationsfunktion in ein zeichen sowie die Funktionen zum gruppieren
 * und zusammenziehen sollen von außen hineingereicht werden können so dass
 * zuletzt ein Colector übrigbleibt der entgegennimmt auf welche Weise collected
 * wird.
 *
 *
 * Aufgabe 3: Die While Schleife kann bei dieser Gelegenheit auch gleich noch
 * entfernt werden. Sorgt dafür das keine Schleife mehr notwendig ist. Ein
 * Endless stream kann das auch...
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {

		int xSize = 10;
		int ySize = 5;

		List<Field> gameboard = initRandomGame(xSize, ySize);

		while (true) {

			// @formatter:off

			// Dieser Teil soll refaktorisiert werden!
		    gameboard.stream()
		    	.collect(groupBy(Field::getY, mapToSign()))
				.entrySet()
				.stream()
				.sorted(byYCoord())
				.map(toSingleLine())
				.map(createTextLine())
				.peek(System.out::println)
				.collect(Collectors.toList());

		    gameboard = iterateGameboard(gameboard);

		    // @formatter:on

			System.out.println();
			Thread.sleep(1000);
		}
	}

	private static List<Field> iterateGameboard(List<Field> gameboard) {
		// @formatter:off

		return gameboard
				.stream()
	    		.map(toDeadField(which(isAlive(), and(),
		    			which(hasLessThanTwo(livingNeighboursIn(gameboard)), or(),
		    					hasMoreThanThree(livingNeighboursIn(gameboard))))))
	    		.map(toAliveField(which(isDead(), and(), hasExactThree(livingNeighboursIn(gameboard)))))
	    		.collect(Collectors.toList());

		// @formatter:on
	}

	private static Comparator<Entry<Integer, List<String>>> byYCoord() {
		return (entry1, entry2) -> Integer.compare(entry1.getKey(), entry2.getKey());
	}

	private static Function<Entry<Integer, List<String>>, List<String>> toSingleLine() {
		return (entry) -> entry.getValue();
	}

	private static Collector<Field, ?, Map<Integer, List<String>>> groupBy(Function<Field, Integer> supplier,
			Function<Field, String> mapper) {
		return Collectors.groupingBy(supplier, Collectors.mapping(mapper, Collectors.toList()));
	}

	private static Function<List<String>, String> createTextLine() {
		return (list) -> list.stream().collect(Collectors.joining(""));
	}

	private static Predicate<Field> hasMoreThanThree(Function<Field, List<Field>> neighbours) {
		return (field) -> neighbours.apply(field).size() > 3;
	}

	private static Predicate<Field> hasExactThree(Function<Field, List<Field>> neighbours) {
		return (field) -> neighbours.apply(field).size() == 3;
	}

	private static Predicate<Field> hasLessThanTwo(Function<Field, List<Field>> neighbours) {
		return (field) -> neighbours.apply(field).size() < 2;
	}

}
