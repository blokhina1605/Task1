package com.epam.blokhina;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Yevheniia_Blokhina on 4/15/2015.
 */
public class Task1 {

    /**
     * Subtask 1
     */
    public static void helloName(String name) {
        System.out.println("Hello, " + name);
    }

    /**
     * Subtask 2
     */
    public static void invertArray(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Subtask 3
     */
    public static void printNumbersInLines(int quantity) {
        Random rnd = new Random();
        int[] array = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            array[i] = rnd.nextInt();
            System.out.println(array[i]);
        }
        for (int i = 0; i < quantity; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Subtask 4
     */
    public static void verifyThePassword(String password) {
        System.out.println(password.equals("mypass"));
    }

    /**
     * Subtask 5
     */

    public static void sumAndMul(String[] array) {
        int[] arrayOfInts = new int[array.length];
        int mul = 0, sum = 0;
        try {
            for (int i = 0; i < array.length; i++) {
                arrayOfInts[i] = Integer.parseInt(array[i]);
                mul *= arrayOfInts[i];
                sum += arrayOfInts[i];
            }
        } catch (NumberFormatException ex) {
            ex.getMessage();
        }
    }

    /**
     * @return array of numbers
     */
    public static int[] enterTheNumber() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the numbers via space:");
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
     * Subtask 6.1
     */
    public static void getOddAndEvenNumbers() {
        int[] array = enterTheNumber();
        System.out.println("Odd numbers:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0)
                System.out.print(array[i]);
        }
        System.out.println("Even numbers:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                System.out.print(array[i]);
        }
    }

    /**
     * Subtask 6.2
     */

    public static void getMaxAndMin() {
        int[] array = enterTheNumber();
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Min=" + min + ", max=" + max);
    }

    /**
     * Subtask 6.3
     */
    public static void verifyDivisionBySevenAndFive() {
        int[] array = enterTheNumber();
        System.out.println("numbers that divide by 3 and 5");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 7 == 0 && array[i] % 5 == 0)
                System.out.println(array[i]);
        }

    }

    /**
     * Subtask 6.4
     */
    public static void verifyDivisionByThreeOrNine() {
        int[] array = enterTheNumber();
        System.out.println("numbers that divide by 3 and 9");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0 || array[i] % 9 == 0)
                System.out.println(array[i]);
        }
    }


    /**
     * Subtask 6.5
     */
    public static void displayThreeDigitsNumbersWithDifDigits() {
        int[] array = enterTheNumber();
        for (int i = 0; i < array.length; i++){
            if (isNumberIsThreeAndHasntSameDigits(array[i])) {
                System.out.println(array[i]);
            }
        }
    }

    /**
     *
     * @param number number to verify
     * @return
     */
    public static boolean isNumberIsThreeAndHasntSameDigits(int number) {
        int length = 3;
        if (Integer.toString(number).length() != length) return false;
        int[] array = getInts(number, length);
        if (array[0] == array[1] || array[0] == array[2] || array[1] == array[2]) return false;
        return true;
    }

    /**
     *
     * @param number number to parse
     * @param length count of digits
     * @return array of digits
     */
    private static int[] getInts(int number, int length) {
        int[] array = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            array[i] = number % 10;
            number /= 10;
        }
        return array;
    }

    /**
     * Subtask 6.6
     */
    public static void displayHappyNumber() {
        int[] array = enterTheNumber();
        for (int i = 0; i < array.length; i++) {
            if(isHappyNumber(array[i])) {
                System.out.println(array[i]);
            }
        }
    }

    /**
     *
     * @param number to verify on 'happiness'
     * @return
     */
    private static boolean isHappyNumber(int number) {
        int sumOfFirstHalf = 0;
        int sumOfSecondHalf = 0;
        int length = Integer.toString(number).length();
        if (length % 2 != 0) return false;
        int[] array = getInts(number, length);
        for (int i = 0; i < array.length / 2; i++) {
            sumOfFirstHalf += array[i];
            sumOfSecondHalf += array[array.length - 1 - i];
        }
        if (sumOfFirstHalf == sumOfSecondHalf) return true;
        return false;
    }

    /**
     * Subtask 6.6
     */
    public static void displayElements() {
        int[] array = enterTheNumber();
        int exp = 0;
        for (int i = 1; i < array.length - 1; i++){
            exp = (array[i-1] + array[i+1]) / 2;
            if (array[i] == exp) {
                System.out.print(array[i] + " ");
            }
        }

    }

    public static void main(String[] args) {
        getOddAndEvenNumbers();
        getMaxAndMin();
        verifyDivisionBySevenAndFive();
        verifyDivisionByThreeOrNine();
        displayThreeDigitsNumbersWithDifDigits();
        displayHappyNumber();
    }

}

