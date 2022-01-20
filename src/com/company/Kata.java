package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kata {
    public static int[] sortArray(int[] array) {
        List<Integer> oddNumbers = getOddNumbersSorted(array);
        for (int index = 0; index < array.length; index++) {
            if (array[index] % 2 == 1) {
                array[index] = oddNumbers.get(0);
                oddNumbers.remove(0);
            }
        }
        return array;
    }

    private static List<Integer> getOddNumbersSorted(int[] array) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (int number : array) {
            if (number % 2 == 1) {
                oddNumbers.add(number);
            }
        }
        Collections.sort(oddNumbers);
        return oddNumbers;
    }

    ///////////////////////////////////////BEST OPTIMIZED EXAMPLE////////////////////////////////////////////////
    public static int[] sortArrayOptimized(final int[] array) {

        // Sort the odd numbers only
        final int[] sortedOdd = Arrays.stream(array).filter(e -> e % 2 == 1).sorted().toArray();

        // Then merge them back into original array
        for (int j = 0, s = 0; j < array.length; j++) {
            if (array[j] % 2 == 1) array[j] = sortedOdd[s++];
        }

        return array;
    }
}