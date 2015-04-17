package com.epam.blokhina;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Yevheniia_Blokhina on 4/15/2015.
 */
public class Task2 {

    /**
     * @return array of numbers
     */
    public static int[] enterTheNumber() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the numbers via space-->");
        String x = s.nextLine();
        String[] str = x.split(" ");
        int[] array = new int[str.length];
        try {
            for (int i = 0; i < str.length; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
        } catch (NumberFormatException ex) {
            System.out.println("Invalid format");
        }
        return array;
    }


    /**
     * Subtask 1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
     */
    public static void findShortestAndLongestNumber() {
        int[] array = enterTheNumber();
        int l = findLongestNumber(array);
        int s = findShortestNumber(array);
        int lLength = Integer.toString(l).length();
        int sLength = Integer.toString(s).length();
        System.out.println("The longest number: " + l + ", length: " + lLength + ". The shortest: " + s + ", length: " + sLength);
    }

    /**
     * find the shortest number in array
     *
     * @param array where find
     * @return the shortest number
     */
    public static int findShortestNumber(int[] array) {
        int s = array[0];
        int shortest = Integer.toString(s).length();
        int length = 0;
        for (int i = 1; i < array.length; i++) {
            length = Integer.toString(array[i]).length();
            if (length < shortest) {
                s = array[i];
                shortest = length;
            }
        }
        return s;
    }

    /**
     * find the longest number in array
     *
     * @param array where find
     * @return the longest number
     */
    public static int findLongestNumber(int[] array) {
        int l = array[0];
        int longest = Integer.toString(l).length();
        int length = 0;
        for (int i = 1; i < array.length; i++) {
            length = Integer.toString(array[i]).length();
            if (length > longest) {
                l = array[i];
                longest = length;
            }
        }
        return l;
    }

    /**
     * Subtask 2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.
     */
    public static void displayByLength() {
        int[] array = enterTheNumber();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (Integer.toString(array[i]).length() > Integer.toString(array[j]).length()) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Subtask 3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.
     */
    public static void displayNumbersWithLengthAboveAver() {
        int[] array = enterTheNumber();
        int max = Integer.toString(findLongestNumber(array)).length();
        int min = Integer.toString(findShortestNumber(array)).length();
        int mid = (max - min) / 2 + min;
        System.out.println("--Numbers < mid-length: ");
        for (int i = 0; i < array.length; i++) {
            int length = Integer.toString(array[i]).length();
            if (length < mid) {
                System.out.println("Number: " + array[i] + ", length: " + length);
            }
        }
        System.out.println("--Numbers > mid-length: ");
        for (int i = 0; i < array.length; i++) {
            int length = Integer.toString(array[i]).length();
            if (length > mid) {
                System.out.println("Number: " + array[i] + ", length: " + length);
            }
        }
    }
    /**
     *  Subtask 4. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
     */

    /**
     * Subtask 5. Найти количество чисел, содержащих только четные цифры, а среди них количество чисел с равным числом четных и нечетных цифр.
     * @param args
     */


    public static void main(String[] args) {
        //findShortestAndLongestNumber();
        //displayByLength();
        displayNumbersWithLengthAboveAver();
    }
}
