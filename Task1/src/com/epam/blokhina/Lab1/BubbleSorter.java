package com.epam.blokhina.Lab1;

import java.util.Arrays;

/**
 * Created by Yevheniia_Blokhina on 4/20/2015.
 */
public class BubbleSorter {
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

    /**
     * initial sorting
     * @param arr1 to sort
     */
    public static void sort(int[] arr1) {
        int[] arr = arr1.clone();
        long startTime = System.nanoTime();
        for (int barrier = arr.length - 1; barrier >= 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (arr[index] > arr[index + 1]) {
                    int tmp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = tmp;
                }
            }
        }
        long endTime = System.nanoTime() - startTime;
        System.out.println("Time for sort is: " + endTime + "ns");
    }

    /**
     * modified sorting
     *
     * @param arr to sort
     */
    public static int[] bubbleSort(int[] arr) {
        long startTime = System.nanoTime();
        for (int barrier = 0; barrier < arr.length; barrier++) {
            for (int index = barrier + 1; index < arr.length; index++) {
                if (arr[barrier] > arr[index]) {
                    int tmp = arr[index];
                    arr[index] = arr[barrier];
                    arr[barrier] = tmp;
                }
            }
        }
        long endTime = System.nanoTime() - startTime;
        System.out.println("Time for modified sort is: " + endTime + "ns");
        return arr;
    }

    public static void main(String[] args) {
        int[] array = randomNumbersInTheInterval();
        sort(array);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
