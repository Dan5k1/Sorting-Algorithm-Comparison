package SortCompare;

import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) {
		SimpleSorter bs = new SimpleSorter();
		String[] arr = { "a", "b", "c", "d", "e", "f", "g", "h" };
		shuffleArray(arr);
		bs.quickSort(arr, 0, 8);
		for (int i = 0; i < arr.length; i++) {

			System.out.println(arr[i]);
		}
	}


	static void shuffleArray(String[] ar) {
		Random rnd = ThreadLocalRandom.current();
		for (int i = ar.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			String a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}

}
