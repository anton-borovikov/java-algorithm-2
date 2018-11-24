package com.company;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
	    int[] numArray = new int[10];
	    int[] numArraySorted;

	    fillArrayByRandom(numArray);
	    printArray("Original array:", numArray);

	    numArraySorted = Arrays.copyOf(numArray, numArray.length);
        Arrays.sort(numArraySorted);
	    printArray("Array sorted by Arrays.sort:", numArraySorted);

        numArraySorted = Arrays.copyOf(numArray, numArray.length);
        sortDescCustom(numArraySorted);
        printArray("Array DESC sorted by custom *(-1) Arrays.sort:", numArraySorted);

        numArraySorted = Arrays.copyOf(numArray, numArray.length);
        sortBySelection(numArraySorted);
        printArray("Array sorted by Selection:", numArraySorted);

        numArraySorted = Arrays.copyOf(numArray, numArray.length);
        sortByBubble(numArraySorted);
        printArray("Array sorted by Bubble:", numArraySorted);

        numArraySorted = Arrays.copyOf(numArray, numArray.length);
        sortByInsert(numArraySorted);
        printArray("Array sorted by Insert:", numArraySorted);
    }

    private static void sortByInsert(int[] numArraySorted) {
        int temp;
        int j;

        for (int i = 1; i < numArraySorted.length; i++) {
            temp = numArraySorted[i];
            j = i - 1;
            while (j >= 0 && temp < numArraySorted[j]) {
                numArraySorted[j + 1] = numArraySorted[j];
                j--;
            }
            numArraySorted[j + 1] = temp;
        }
    }

    private static void sortByBubble(int[] numArraySorted) {
        int temp;

        for (int i = 1; i < numArraySorted.length; i++) {
            for (int j = 0; j < numArraySorted.length - i; j++) {
                if (numArraySorted[j] > numArraySorted[j + 1]) {
                    temp = numArraySorted[j + 1];
                    numArraySorted[j + 1] = numArraySorted[j];
                    numArraySorted[j] = temp;
                }
            }
        }
    }

    private static void sortBySelection(int[] numArraySorted) {
        int temp;
        int position;

        for (int i = 0; i < numArraySorted.length - 1; i++) {
            temp = numArraySorted[i];
            position = i;
            for (int j = i + 1; j < numArraySorted.length; j++) {
                if (numArraySorted[j] < temp) {
                    temp = numArraySorted[j];
                    position = j;
                }
            }
            if (temp < numArraySorted[i]) {
                numArraySorted[position] = numArraySorted[i];
                numArraySorted[i] = temp;
            }
        }
    }

    private static void sortDescCustom(int[] numArraySorted) {
        for (int i = 0; i < numArraySorted.length; i++) {
            numArraySorted[i] = -numArraySorted[i];
        }
        Arrays.sort(numArraySorted);
        for (int i = 0; i < numArraySorted.length; i++) {
            numArraySorted[i] = -numArraySorted[i];
        }
    }

    private static void printArray(String message, int[] numArray) {
        System.out.print(message + " ");
        for (int i = 0; i < numArray.length; i++) {
            System.out.print(numArray[i] + " ");
        }
        System.out.println();
    }

    private static void fillArrayByRandom(int[] numArray) {
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = ThreadLocalRandom.current().nextInt(0, 9);
        }
    }
}
