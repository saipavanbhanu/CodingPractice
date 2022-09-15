package java8.streams;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SpliteratorDemo {
	public static void main(String[] args) {
		// Create an array list for doubles.
		ArrayList<Integer> al = new ArrayList<>();

		// Add values to the array list.
		al.add(1);
		al.add(2);
		al.add(-3);
		al.add(-4);
		al.add(5);

		// Obtain a Stream to the array list.
		Stream<Integer> str = al.stream();

		// getting Spliterator object on al
		Spliterator<Integer> splitr1 = str.spliterator();

		// estimateSize method
		System.out.println("estimate size : " + splitr1.estimateSize());

		// getExactSizeIfKnown method
		System.out.println("exact size : " + splitr1.getExactSizeIfKnown());

		// hasCharacteristics and characteristics method
		System.out.println(splitr1.hasCharacteristics(splitr1.characteristics()));

		System.out.println("Content of arraylist :");
		// forEachRemaining method
		splitr1.forEachRemaining((n) -> System.out.println(n));

		// Obtaining another Stream to the array list.
		Stream<Integer> str1 = al.stream();
		splitr1 = str1.spliterator();

		// trySplit() method
		Spliterator<Integer> splitr2 = splitr1.trySplit();

		// If splitr1 could be split, use splitr2 first.
		if (splitr2 != null) {
			System.out.println("Output from splitr2: ");
			splitr2.forEachRemaining((n) -> System.out.println(n));
		}

		// Now, use the splitr
		System.out.println("\nOutput from splitr1: ");
		splitr1.forEachRemaining((n) -> System.out.println(n));

		ArrayList<Integer> al1 = new ArrayList<>();

		// Add values to the array list.
		al1.add(1);
		al1.add(2);
		al1.add(-3);
		al1.add(-4);
		al1.add(5);

		// Use tryAdvance() to display(action) contents of arraylist.

		System.out.print("Contents of arraylist:\n");

		// getting Spliterator object on al1
		Spliterator<Integer> splitr = al1.spliterator();

		// Use tryAdvance() to display(action) contents of arraylist.
		// Notice how lambda expression is used to implement accept method
		// of Consumer interface

		while (splitr.tryAdvance((n) -> System.out.println(n)))
			;

		// Use tryAdvance() for getting absolute values(action) of contents of
		// arraylist.

		// Create new list that contains absolute values.
		ArrayList<Integer> al2 = new ArrayList<>();

		splitr = al1.spliterator();

		// Here our action is to get absolute values
		// Notice how lambda expression is used to implement accept method
		// of Consumer interface
		while (splitr.tryAdvance((n) -> al2.add(Math.abs(n))))
			;

		System.out.print("Absolute values of contents of arraylist:\n");

		// getting Spliterator object on al2
		splitr = al2.spliterator();

		while (splitr.tryAdvance((n) -> System.out.println(n)))
			;

	}
}
