package com.epam.blokhina;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Yevheniia_Blokhina on 4/16/2015.
 */
public class Sorts {
    public static final int SIZE = 100000;

    public static void main(String[] args) {
        Random rd = new Random();
        long start, timeSpent;
        int[] array = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = rd.nextInt(50000);
        }

        start = System.currentTimeMillis();

        //System.out.println(Arrays.toString(array));
        int[] mergeArray = mergeSort(array);
        timeSpent = System.currentTimeMillis() - start;
        System.out.println("Merge sort takes: " + timeSpent + " ms");
        // System.out.println(Arrays.toString(mergeArray));

        start = System.currentTimeMillis();
        int[] insertSortArray = array.clone();
        //System.out.println(Arrays.toString(array));
        insertSort(insertSortArray);
        timeSpent = System.currentTimeMillis() - start;
        System.out.println("Inserting sort takes: " + timeSpent + " ms");
        // System.out.println(Arrays.toString(insertSortArray));

        start = System.currentTimeMillis();
        int[] shellSortArray = array.clone();
        // System.out.println(Arrays.toString(array));
        shellSort(shellSortArray);
        timeSpent = System.currentTimeMillis() - start;
        System.out.println("Shell sort takes: " + timeSpent + " ms");
        // System.out.println(Arrays.toString(shellSortArray));

        start = System.currentTimeMillis();
        int[] bubbleSortArray = array.clone();
        // System.out.println(Arrays.toString(array));
        bubbleSort(bubbleSortArray);
        timeSpent = System.currentTimeMillis() - start;
        System.out.println("Bubble sort tales: " + timeSpent + " ms");
        //  System.out.println(Arrays.toString(bubbleSortArray));

        start = System.currentTimeMillis();
        int[] selectSortArray = array.clone();
        // System.out.println(Arrays.toString(array));
        selectionSort(selectSortArray);
        timeSpent = System.currentTimeMillis() - start;
        System.out.println("Selecting sort takes: " + timeSpent + " ms");
        // System.out.println(Arrays.toString(selectSortArray));

        start = System.currentTimeMillis();
        int[] qSortArray = array.clone();
        System.out.println(Arrays.toString(array));
        qSort(qSortArray);
        timeSpent = System.currentTimeMillis() - start;
        System.out.println("Quick sort takes: " + timeSpent + " ms");
        System.out.println(Arrays.toString(qSortArray));


    }

    /**
     * BubbleSort
     *
     * @param arr
     */
    static int[] bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    /**
     * Selection Sort
     *
     * @param arr
     */
    static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * Merge Sort
     *
     * @param arr
     * @return sorted array
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[mid + arr.length % 2];

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length / 2) {
                left[i] = arr[i];
            } else {
                right[j++] = arr[i];
            }
        }
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * @param left  path of array
     * @param right path of array
     * @return merged array
     */
    public static int[] merge(int[] left, int[] right) {
        int a = 0, b = 0;
        int[] merged = new int[left.length + right.length];
        for (int i = 0; i < left.length + right.length; i++) {
            if (b < right.length && a < left.length)
                if (left[a] > right[b] && b < right.length)
                    merged[i] = right[b++];
                else
                    merged[i] = left[a++];
            else if (b < right.length)
                merged[i] = right[b++];
            else
                merged[i] = left[a++];
        }
        return merged;
    }


    /**
     * Insert sort
     *
     * @param arr array to sort
     * @return sorted array
     */
    public static int[] insertSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];// запомним i-ый элемент
            int j = i - 1;//будем идти начиная с i-1 элемента
            while (j >= 0 && arr[j] > temp)
            // пока не достигли начала массива
            // или не нашли элемент больше i-1-го
            // который храниться в переменной temp
            {
                arr[j + 1] = arr[j];
                //проталкиваем элемент вверх
                j--;
            }
            arr[j + 1] = temp;
            // возвращаем i-1 элемент
        }
        return arr;
    }


    /**
     * Shell sort
     *
     * @param arr to sort
     * @return sorted array
     */
    public static int[] shellSort(int[] arr) {
        int step = arr.length / 2;//инициализируем шаг.
        while (step > 0)//пока шаг не 0
        {
            for (int i = 0; i < (arr.length - step); i++) {
                int j = i;
                //будем идти начиная с i-го элемента
                while (j >= 0 && arr[j] > arr[j + step])
                //пока не пришли к началу массива
                //и пока рассматриваемый элемент больше
                //чем элемент находящийся на расстоянии шага
                {
                    //меняем их местами
                    int temp = arr[j];
                    arr[j] = arr[j + step];
                    arr[j + step] = temp;
                    j--;
                }
            }
            step = step / 2; //уменьшаем шаг
        }
        return arr;
    }


    /**
     * QuickSort
     *
     * @param arr
     * @return
     */
    public static int[] qSort(int[] arr) {
        return qSort(arr, 0, arr.length - 1);
    }

    /**
     * QuickSort
     *
     * @param qSortArr
     * @param begin
     * @param end
     * @return
     */
    public static int[] qSort(int[] qSortArr, int begin, int end) {
        int i = begin;
        int j = end;
        int x = qSortArr[(begin + end) / 2];
        do {
            while (qSortArr[i] < x) ++i;
            while (qSortArr[j] > x) --j;
            if (i <= j) {
                int temp = qSortArr[i];
                qSortArr[i] = qSortArr[j];
                qSortArr[j] = temp;

                i++;
                j--;
            }
        } while (i <= j);

        if (begin < j) qSort(qSortArr, begin, j);
        if (i < end) qSort(qSortArr, i, end);
        return qSortArr;
    }
}
