package com.epam.blokhina.Lab1;

import java.util.Arrays;

/**
 * Created by Yevheniia_Blokhina on 4/20/2015.
 */
public class InsertionSorter {
    final static int SIZE = 11;

    /**
     * @return array of random numbers
     */
    public static int[] randomNumbersInTheInterval() {
        int[] array = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = (int) (Math.random() * (2 * SIZE + 1)) - SIZE;
        }
        return array;
    }

    public static void sort(int[] arr1) {
        int[] arr = arr1.clone();
        long startTime = System.nanoTime();
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int location = k - 1;
            while (location >= 0 && arr[location] > newElement) {
                arr[location + 1] = arr[location];
                location--;
            }
            arr[location + 1] = newElement;

        }
        long endTime = System.nanoTime() - startTime;
        System.out.println("Time for sort is: " + endTime + "ns");

    }

    public static void insertionSort(int[] arr) {
        long startTime = System.nanoTime();

        long endTime = System.nanoTime() - startTime;
        System.out.println("Time for modified sort is: " + endTime + "ns");
    }


    public static void main(String[] args) {
        int[] array = randomNumbersInTheInterval();
        sort(array);
        insertionSort(array);

        System.out.println(Arrays.toString(array));
    }
}
