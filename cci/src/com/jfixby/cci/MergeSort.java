
package com.jfixby.cci;

public class MergeSort {

	public static void mergeSort (final byte[] list) {
		final byte[] tmp = new byte[list.length];
		mergeSort(0, list.length, list, tmp);
	}

	private static void mergeSort (final long begin, final long end, final byte[] list, final byte[] tmp) {
		if (end - begin < 2) {
			return;
		}
		final long mid = mid(begin, end);
		mergeSort(begin, mid, list, tmp);
		mergeSort(mid, end, list, tmp);
		merge(begin, mid, end, list, tmp);
	}

	private static void merge (final long begin, final long mid, final long end, final byte[] list, final byte[] tmp) {
		final int index0 = (int)begin;
		int indexA = (int)begin;
		final int maxA = (int)mid;
		int indexB = (int)mid;
		final int maxB = (int)end;
		final int tmpSize = (int)(end - begin);

		int tmpI = 0;
		while (indexA < maxA && indexB < maxB) {
			final byte valueA = list[indexA];
			final byte valueB = list[indexB];
			if (valueA <= valueB) {
				tmp[tmpI] = valueA;
				indexA++;
			} else {
				tmp[tmpI] = valueB;
				indexB++;
			}
			tmpI++;
		}
		while (indexA < maxA) {
			final byte valueA = list[indexA];
			tmp[tmpI] = valueA;
			indexA++;
			tmpI++;
		}
		while (indexB < maxB) {
			final byte valueB = list[indexB];
			tmp[tmpI] = valueB;
			indexB++;
			tmpI++;
		}
		for (int i = 0; i < tmpSize; i++) {
			final int index = index0 + i;
			list[index] = tmp[i];
		}

	}

	private static long mid (final long begin, final long end) {
		return (end + begin) / 2;
	}

}
