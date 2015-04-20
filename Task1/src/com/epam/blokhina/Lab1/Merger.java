package com.epam.blokhina.Lab1;

import java.util.Arrays;

/**
 * Created by Yevheniia_Blokhina on 4/20/2015.
 */
public class Merger {

    /**
     * modified method
     * @param fst 1st array
     * @param snd 2nd array
     * @return merged array
     */
    public static int[] merge(int[] fst, int[] snd) {
        int[] result = new int[fst.length + snd.length];
        int fstIndex = 0;
        int sndIndex = 0;

        while (fstIndex + sndIndex != result.length) {
            if (fst[fstIndex] < snd[sndIndex]) {
                result[fstIndex + sndIndex] = fst[fstIndex++];
                if (fstIndex == fst.length) {
                    System.arraycopy(snd, sndIndex, result, (fstIndex + sndIndex), (snd.length - sndIndex));
                    break;
                }
            } else {
                result[fstIndex + sndIndex] = snd[sndIndex++];
                if (sndIndex == snd.length) {
                    System.arraycopy(fst, fstIndex, result, (fstIndex + sndIndex), (fst.length - fstIndex));
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = {0, 3, 4, 6, 7};
        int[] b = {1, 2, 5};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        int[] mergedArray = merge(a, b);
        System.out.println("Array after invertion: " + Arrays.toString(mergedArray));
    }
}
