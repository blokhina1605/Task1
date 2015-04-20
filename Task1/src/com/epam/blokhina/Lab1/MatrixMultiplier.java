package com.epam.blokhina.Lab1;

import java.util.Arrays;

/**
 * Created by Yevheniia_Blokhina on 4/20/2015.
 */
public class MatrixMultiplier {
    public static int[][] mulMatrix(int[][] A, int[][] B) {
        if(A==null) throw new IllegalArgumentException();
        if(B==null) throw new IllegalArgumentException();
        int[][] C;
        if(A.length == B.length || A.length == B[0].length) {
            C = new int[A.length][B[0].length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B[0].length; j++)
                    for (int k = 0; k < B.length; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
            }
        }
        else throw new IllegalArgumentException();
        return C;
    }



    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        int[][] A = {{2, 2, 1}, {0, 3, 31}, {22, 100, -2}, {22, 100, -2}};
        int[][] B = {{0, 131, -3, 5}, {2, 4, 11, 6}, {0, -9, 213, 1}};
        System.out.println();
        printMatrix((mulMatrix(A, B)));

    }
}
