package com.epam.blokhina;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Yevheniia_Blokhina on 4/15/2015.
 */
public class Task2 {

    /**
     * @return array of numbers
     */
    public static int[] enterTheNumbers() {
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
    public static void findShortestAndLongestNumber(int[] array) {
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
    public static void displayByLength(int[] array) {
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
    public static void displayNumbersWithLengthAboveAver(int[] array) {
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
     * Subtask 4. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
     */
    public static void findNumberWithMinDifferentSymbols(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (countDifferentSymbolsInNumber(result) > countDifferentSymbolsInNumber(array[i])) {
                result = array[i];
            }
        }
        System.out.println(result);
    }

    /**
     * @param number where count different symbols
     * @return quantity of different symbols in  number
     */
    public static int countDifferentSymbolsInNumber(int number) {
        int length = Integer.toString(number).length();
        char[] array = getChars(number);
        int result = 1;
        for (int i = 0; i < length - 1; i++) {
            if (array[i] != array[i + 1]) {
                result++;
            }
        }
        return result;
    }

    /**
     * @param number to do array
     * @return array of chars
     */
    private static char[] getChars(int number) {
        int length = Integer.toString(number).length();
        char[] array = new char[length];
        for (int i = 0; i < length; i++) {
            array[i] = Integer.toString(number).charAt(i);
        }
        return array;
    }

    /**
     * Subtask 5. Найти количество чисел, содержащих только четные цифры, а среди них количество чисел с равным числом четных и нечетных цифр.
     */
    public static void getQuantityOfEvenNumbers(int[] array) {
        int result = 0;
        int numbersWithOddAndEven = 0;
        for (int i = 0; i < array.length; i++) {
            int oddQuant = 0;
            int evenQuant = 0;
            if (array[i] % 2 == 0) {
                result++;
                char[] arrayOfChars = getChars(array[i]);
                for (int j = 0; j < arrayOfChars.length; j++) {
                    if (arrayOfChars[j] % 2 == 0) oddQuant++;
                    else if (arrayOfChars[j] % 2 != 0) evenQuant++;
                }
                if (oddQuant == evenQuant) numbersWithOddAndEven++;
            }
        }
        System.out.println("Quantity of even numbers: " + result + ". Quantity of numbers with equal numbers of odd and even numbers: " + numbersWithOddAndEven);

    }

    /**
     * Subtask 6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
     */
    public static void findNumberWithDigitsInAsc(int[] array) {
        for (int number : array) {
            if (isDigitsInAsc(number)) {
                System.out.println(number);
                break;
            }
        }
    }

    /**
     * @param number to verify for ascending
     * @return is in Asc or not
     */
    public static boolean isDigitsInAsc(int number) {
        char[] array = getChars(number);
        if (array.length < 2) {
            return false;
        }
        boolean result = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }


    /**
     * Subtask 7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
     */
    public static void findNumberWithOnlyDifferentDigits(int[] array) {
        for (int number : array) {
            if (hasUniqueDigits(number)) {
                System.out.println("The number " + number + " has only unique digits.");
                break;
            }
        }
    }

    /**
     * @param number to verify for uniqueness
     * @return is unique or not
     */
    public static boolean hasUniqueDigits(int number) {
        char[] array = getChars(number);
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) return false;
            }
        }
        return true;
    }

    /**
     * print matrix
     *
     * @param matrix to print
     */
    public static void printQuadMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Subtask 8. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз.
     */
    public static void printNumbersAsAMatrix() {
        System.out.print("Enter size of matrix -->");
        int size = enterTheNumberForMatrix();
        int[] array = enterTheNumbers();
        System.out.println("----from left to right----");
        printQuadMatrix(fillTheMatrixLeftToRight(size, array));
        System.out.println("----from top to down----");
        printQuadMatrix(fillTheMatrixTopToDown(size, array));
    }

    /**
     * @param size  of matrix
     * @param array which convert to matrix
     * @return matrix filled from left to right
     */
    private static int[][] fillTheMatrixLeftToRight(int size, int[] array) {
        int[][] matrix = new int[size][size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (array.length > k) {
                    matrix[i][j] = array[k];
                    k++;

                } else {
                    matrix[i][j] = 0;
                }

            }
        }
        return matrix;
    }

    /**
     * @param size  of matrix
     * @param array which convert to matrix
     * @return matrix filled from top to down
     */
    private static int[][] fillTheMatrixTopToDown(int size, int[] array) {
        int[][] matrix = new int[size][size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (array.length > k) {
                    matrix[j][i] = array[k];
                    k++;

                } else {
                    matrix[j][i] = 0;

                }
            }
        }
        return matrix;
    }

    /**
     * @return first entered number
     */
    public static int enterTheNumberForMatrix() {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        return x;
    }

    /**
     * get matrix of random numbers in the range from -n to n
     *
     * @return matrix of random numbers
     */
    public static int[][] randomNumbersInTheInterval() {
        System.out.print("Enter size of matrix -->");
        int size = enterTheNumberForMatrix();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) (Math.random() * (2 * size + 1)) - size;
            }
        }
        return matrix;
    }

    /**
     * Subtask 9.1. Упорядочить строки (столбцы) матрицы в порядке возрастания значений.
     */
    public static void arrangeMatrixInAsc(int[][] matrix) {
        System.out.println("-----original matrix----- ");
        printQuadMatrix(matrix);
        System.out.println("-----with arranged rows in Asc-----");
        printQuadMatrix(arrangeRowsOfMatrixInAsc(matrix));
        System.out.println("-----with arranged cols in Asc-----");
        printQuadMatrix(arrangeColsOfMatrixInAsc(matrix));
    }

    /**
     * sorting cols in matrix in Asc
     *
     * @param matrix to sort
     * @return sorted matrix
     */
    private static int[][] arrangeColsOfMatrixInAsc(int[][] matrix) {
        int[][] sortedMatrix = matrix.clone();
        System.out.println(Arrays.deepToString(sortedMatrix));
        for (int i = 0; i < sortedMatrix.length - 1; i++) {
            for (int j = i + 1; j < sortedMatrix.length; j++) {
                for (int k = 0; k < sortedMatrix.length; k++) {
                    if (sortedMatrix[i][k] > sortedMatrix[j][k]) {
                        int tmp = sortedMatrix[j][k];
                        sortedMatrix[j][k] = sortedMatrix[i][k];
                        sortedMatrix[i][k] = tmp;
                    }
                }
            }
        }
        return sortedMatrix;
    }

    /**
     * Sorting rows in matrix in Asc
     *
     * @param matrix which sort
     * @return sorted matrix
     */
    private static int[][] arrangeRowsOfMatrixInAsc(int[][] matrix) {
        int[][] sortedMatrix = matrix.clone();
        for (int i = 0; i < sortedMatrix.length; i++) {
            for (int j = 0; j < sortedMatrix.length - 1; j++) {
                for (int k = j; k < sortedMatrix.length; k++) {
                    if (sortedMatrix[i][j] > sortedMatrix[i][k]) {
                        int tmp = sortedMatrix[i][j];
                        sortedMatrix[i][j] = sortedMatrix[i][k];
                        sortedMatrix[i][k] = tmp;
                    }
                }
            }
        }
        return sortedMatrix;
    }

    /**
     * Subtask 9.2 Выполнить циклический сдвиг заданной матрицы на k позиций вправо (влево, вверх, вниз).
     */
    public static void shiftOfMatrix(int[][] matrix) {
        System.out.println("-----original matrix----- ");
        printQuadMatrix(matrix);
        System.out.println("Enter position to shift");
        int k = enterTheNumberForMatrix();
        System.out.println("-----Shift to the down-----");
        printQuadMatrix(shiftToTheDown(matrix, k));
        System.out.println("-----Shift to the top-----");
        printQuadMatrix(shiftToTheTop(matrix, k));
        System.out.println("-----Shift to the right-----");
        printQuadMatrix(shiftToTheRight(matrix, k));
        System.out.println("-----Shift to the left-----");
        printQuadMatrix(shiftToTheLeft(matrix, k));
    }

    /**
     * cyclic shift to the top
     *
     * @param matrix to shift
     * @param k      shift position
     * @return shifted matrix
     */
    private static int[][] shiftToTheTop(int[][] matrix, int k) {
        int[][] shiftedMatrix = new int[matrix.length][matrix.length];
        for (int i = matrix.length; i > 0; i--) {
            int[] line = matrix[i - 1];
            shiftedMatrix[(i - k - 1 + matrix.length) % matrix.length] = line;
        }
        return shiftedMatrix;
    }

    /**
     * cyclic shift to the down
     *
     * @param matrix to shift
     * @param k      shift position
     * @return shifted matrix
     */
    private static int[][] shiftToTheDown(int[][] matrix, int k) {
        int[][] shiftedMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int[] line = matrix[i];
            shiftedMatrix[(i + k) % matrix.length] = line;
        }
        return shiftedMatrix;

    }

    /**
     * cyclic shift to the right
     *
     * @param matrix to shift
     * @param k      shift position
     * @return shifted matrix
     */
    private static int[][] shiftToTheRight(int[][] matrix, int k) {
        int[][] shiftedMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int elem = matrix[i][j];
                shiftedMatrix[i][(j + k) % matrix.length] = elem;
            }
        }
        return shiftedMatrix;
    }

    /**
     * cyclic shift to the left
     *
     * @param matrix to shift
     * @param k      shift position
     * @return shifted matrix
     */
    private static int[][] shiftToTheLeft(int[][] matrix, int k) {
        int[][] shiftedMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length; j > 0; j--) {
                int elem = matrix[i][j - 1];
                shiftedMatrix[i][(j - k - 1 + matrix.length) % matrix.length] = elem;
            }
        }
        return shiftedMatrix;
    }

    /**
     * Subtask 9.3. Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
     */
    public static void findQuantityOf(int[][] matrix) {
        System.out.println("-----Matrix-----");
        printQuadMatrix(matrix);
        System.out.println("-----Matrix with elements in ascending. * - element is not in sequence");
        findQuantityOfAsc(matrix);
        System.out.println("-----Matrix with elements in descending. * - element is not in sequence");
        findQuantityOfDesc(matrix);
    }

    /**
     * find quantity of elements which are in descending
     *
     * @param matrix where find
     */
    private static void findQuantityOfDesc(int[][] matrix) {
        int less = Integer.MAX_VALUE;
        int result = 0;
        int preResult = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (less > matrix[i][j]) {
                    preResult++;
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.print("* ");
                    if (preResult > result) {
                        result = preResult;
                    }
                    preResult = 0;
                }
                less = matrix[i][j];
            }
            System.out.println();
        }
        if (preResult > result) {
            result = preResult;

        }
        System.out.println();
        System.out.println(result);
    }

    /**
     * find quantity of elements which are in ascending
     *
     * @param matrix where find
     */
    private static void findQuantityOfAsc(int[][] matrix) {
        int less = Integer.MIN_VALUE;
        int result = 0;
        int preResult = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (less < matrix[i][j]) {
                    preResult++;
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.print("* ");
                    if (preResult > result) {
                        result = preResult;
                    }
                    preResult = 0;
                }
                less = matrix[i][j];
            }
        }
        if (preResult > result) {
            result = preResult;
        }
        System.out.println();
        System.out.println(result);
    }

    /**
     * Subtask 9.4. Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки.
     */
    public static void findSumBetweenTwoPositiveNumbers(int[][] matrix) {
        printQuadMatrix(matrix);
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (flag && matrix[i][j] < 0) {
                    sum += matrix[i][j];
                }
                if (matrix[i][j] > 0) {
                    flag = !flag;
                    if (!flag) {
                        break;
                    }
                }
            }
            if (flag) {
                sum = 0;
            }
            System.out.println(sum);
            sum = 0;
            flag = false;
        }
    }

    /**
     * Subtask 9.5. Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.
     */
    public static void rotateMatrix(int[][] matrix) {

        printQuadMatrix(matrix);
        System.out.println("----90 rotate degrees----");
        printQuadMatrix(rotateMatrix90(matrix));
        System.out.println("----180 rotate degrees----");
        printQuadMatrix(rotateMatrix180(matrix));
        System.out.println("----270 rotate degrees----");
        printQuadMatrix(rotateMatrix270(matrix));
    }

    /**
     * rotate matrix 90 degrees
     *
     * @param matrix to rotate
     * @return rotated matrix
     */
    private static int[][] rotateMatrix90(int[][] matrix) {
        int[][] rotatedMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                rotatedMatrix[i][j] = matrix[matrix.length - j - 1][matrix.length - i - 1];
            }
        }
        return rotatedMatrix;
    }

    /**
     * rotate matrix 180 degrees
     *
     * @param matrix to rotate
     * @return rotated matrix
     */
    private static int[][] rotateMatrix180(int[][] matrix) {
        int[][] rotatedMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            rotatedMatrix[i] = matrix[matrix.length - i - 1];
        }
        return rotatedMatrix;
    }

    /**
     * rotate matrix 270 degrees
     *
     * @param matrix to rotate
     * @return rotated matrix
     */
    private static int[][] rotateMatrix270(int[][] matrix) {
        int[][] rotatedMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                rotatedMatrix[i][j] = matrix[j][i];
            }
        }
        return rotatedMatrix;
    }

    /**
     * Subtask 9.6 Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.
     */
    public static void printMatrixWithDiffAver(int[][] matrix) {
        System.out.println("-----Matrix-----");
        printQuadMatrix(matrix);
        substrTheAverValueFromElemOfRows(matrix);
        System.out.println("-----Modified matrix-----");
        printQuadMatrix(matrix);
    }

    /**
     * Subtract from the elements of each row of its average value.
     *
     * @param matrix where substr
     */
    private static void substrTheAverValueFromElemOfRows(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sum += matrix[i][j];
            }
            int aver = sum / matrix.length;
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] -= aver;
            }
            sum = 0;
        }
    }

    /**
     * Subtask 9.8. Преобразовать строки матрицы таким образом, чтобы элементы, равные нулю, располагались после всех остальных
     */
    public static void moveZeroToRight(int[][] matrix) {
        System.out.println("-----Matrix-----");
        printQuadMatrix(matrix);
        int[][] resultMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, k = 0; j < matrix.length; j++) {

                if (matrix[i][j] != 0) {
                    resultMatrix[i][k++] = matrix[i][j];
                }
            }
        }
        System.out.println("-----Modified matrix-----");
        printQuadMatrix(resultMatrix);
    }

    /**
     * Subtask 9.7. Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями..
     */
    public static void compress(int[][] matrix) {

        System.out.println("-----Matrix-----");
        printQuadMatrix(matrix);
        boolean[] horizontalZeros = new boolean[matrix.length];
        boolean[] verticalZeros = new boolean[matrix.length];
        int horizontalLength = matrix.length;
        int verticalLength = matrix.length;
        boolean flag = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 0) {
                    flag = false;
                }
            }
            if (flag) {
                horizontalLength--;
            }
            verticalZeros[i] = !flag;
            flag = true;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] != 0) {
                    flag = false;
                }
            }
            if (flag) {
                verticalLength--;
            }
            horizontalZeros[i] = !flag;
            flag = true;
        }
        int[][] result = new int[horizontalLength][verticalLength];
        for (int i = 0, i1 = 0; i < matrix.length; i++) {
            if (verticalZeros[i]) {
                for (int j = 0, j1 = 0; j < matrix.length; j++) {
                    if (horizontalZeros[j]) {
                        result[i1][j1++] = matrix[i][j];
                    }
                }
                i1++;
            }
        }
        System.out.println("-----Modified matrix-----");
        System.out.println(Arrays.deepToString(result));
    }

    public static void main(String[] args) {

        System.out.println("-----Subtask 1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.");
        findShortestAndLongestNumber(enterTheNumbers());
        System.out.println("-----Subtask 2. Упорядочить и вывести числа в порядке возрастания значений их длины.");
        displayByLength(enterTheNumbers());
        System.out.println("-----Subtask 3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.");
        displayNumbersWithLengthAboveAver(enterTheNumbers());
        System.out.println("-----Subtask 4. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.");
        findNumberWithMinDifferentSymbols(enterTheNumbers());
        System.out.println("-----Subtask 5. Найти количество чисел, содержащих только четные цифры, а среди них количество чисел с равным числом четных и нечетных цифр.");
        getQuantityOfEvenNumbers(enterTheNumbers());
        System.out.println("-----Subtask 6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.");
        findNumberWithDigitsInAsc(enterTheNumbers());
        System.out.println("-----Subtask 7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.");
        findNumberWithOnlyDifferentDigits(enterTheNumbers());
        System.out.println("-----Subtask 8. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз.");
        printNumbersAsAMatrix();
        System.out.println("-----Subtask 9. Ввести с консоли n-размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.");
        int[][] matrix = randomNumbersInTheInterval();
        System.out.println("-----Subtask 9.1. Упорядочить строки (столбцы) матрицы в порядке возрастания значений.");
        arrangeMatrixInAsc(matrix);
        System.out.println("-----Subtask 9.2. Выполнить циклический сдвиг заданной матрицы на k позиций вправо (влево, вверх, вниз).");
        shiftOfMatrix(matrix);
        System.out.println("-----Subtask 9.3. Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.");
        findQuantityOf(matrix);
        System.out.println("-----Subtask 9.4. Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки.");
        findSumBetweenTwoPositiveNumbers(matrix);
        System.out.println("-----Subtask 9.5. Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.");
        rotateMatrix(matrix);
        System.out.println("-----Subtask 9.6. Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.");
        printMatrixWithDiffAver(matrix);
        System.out.println("-----Subtask 9.7. Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.");
        moveZeroToRight(matrix);
        System.out.println("-----Subtask 9.8. Преобразовать строки матрицы таким образом, чтобы элементы, равные нулю, располагались после всех остальных.");
        compress(matrix);

    }
}
