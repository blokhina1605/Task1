package com.epam.blokhina.Lab1;

import java.util.Arrays;

/**
 * Created by Yevheniia_Blokhina on 4/20/2015.
 */
public class ArrayInverter {
    final static int SIZE = 11;

    /**
     *
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
     * invert from 0 to center
     *
     * @param arr1 to invert
     */

    public static void invert(int[] arr1) {
        int[] arr = arr1.clone();
        long startTime = System.nanoTime();
        for (int k = 0; k < arr.length / 2; k++) {
            int tmp = arr[k];
            arr[k] = arr[arr.length - k - 1];
            arr[arr.length - k - 1] = tmp;
        }
        long endTime = System.nanoTime() - startTime;
        System.out.println("Time for invert is: " + endTime + "ns");
    }

    /**
     * invert from center to 0
     *
     * @param arr
     */
    public static void invertFromCenterToZero(int[] arr) {
        long startTime = System.nanoTime();
        for (int k = arr.length / 2; k >= 0 / 2; k--) {
            int tmp = arr[k];
            arr[k] = arr[arr.length - k - 1];
            arr[arr.length - k - 1] = tmp;
        }
        long endTime = System.nanoTime() - startTime;
        System.out.println("Time for modified invert is: " + endTime + "ns");
    }

    public static void main(String[] args) {
        int[] array = randomNumbersInTheInterval();
        invert(array);
        invertFromCenterToZero(array);
        System.out.println(Arrays.toString(array));

    }
}
