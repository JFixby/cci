
package com.jfixby.cci;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class MergeSortTest {

	@Test
	public void testReverse () {

		assertTrue(this.checkSorting(new byte[] {}));
		assertTrue(this.checkSorting(new byte[] {1}));
		assertTrue(this.checkSorting(new byte[] {1, 2}));
		assertTrue(this.checkSorting(new byte[] {2, 1}));
		assertTrue(this.checkSorting(new byte[] {1, 2, 1}));
		assertTrue(this.checkSorting(randomArray(100)));
		for (int k = 0; k < 100; k++) {
			assertTrue(this.checkSorting(randomArray(k)));
		}

	}

	private boolean checkSorting (final byte[] list) {
		System.out.println("checkSorting " + "(" + Arrays.toString(list) + ")");

		final byte[] java_array = this.copy(list);
		final byte[] merge_array = this.copy(list);

		Arrays.sort(java_array);
		MergeSort.mergeSort(merge_array);

		final boolean areEqual = Arrays.equals(java_array, merge_array);
		if (!areEqual) {
			System.out.println("Failed to sort " + "(" + Arrays.toString(list) + ")");
			System.out.println("        result" + "(" + Arrays.toString(merge_array) + ")");
			System.out.println("     should be" + "(" + Arrays.toString(java_array) + ")");
		} else {
			System.out.println("Success to sort " + "(" + Arrays.toString(list) + ")");
			System.out.println("        result" + "(" + Arrays.toString(merge_array) + ")");
			System.out.println("     should be" + "(" + Arrays.toString(java_array) + ")");
			System.out.println();
		}
		return areEqual;
	}

	private byte[] copy (final byte[] src) {
		final byte[] copy = new byte[src.length];
		System.arraycopy(src, 0, copy, 0, src.length);
		return copy;
	}

	public static byte[] randomArray (final int N) {
		final byte[] random = new byte[N]; // create the Array with N slots
		final Random rnd = new Random(4); // create a local variable for Random
		for (int i = 0; i < random.length; i++) // filling with randoms
		{
			random[i] = ((byte)rnd.nextInt());
		}
		return random;
	}

}
