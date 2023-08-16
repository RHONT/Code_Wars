package CodeWars;

import java.util.Arrays;

public class KataLekso {


    public static void main(String[] args) {

        System.out.println(nextSmaller2(123456798));


    }

    public static long nextSmaller(long n) {
        int[] inputArray = covertLongToIntArray(n);
        int[] result = calcGenLekso(inputArray);
        if (result[0] == 0) {
            return -1;
        }
        return converIntArrayToLong(result);
    }

    private static int[] calcGenLekso(int[] array) {

        int firstIndex = findFirstIndex(array);
        if (firstIndex != -1) {
            int firstSmall = array[firstIndex];
            int secondIndex = findSecondValueIndex(array, firstSmall);
            swap(array, firstIndex, secondIndex);
            reverse(array, firstIndex);
//            System.out.println(Arrays.toString(array));
            return array;
        }
        return new int[]{0};
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int findSecondValueIndex(int[] array, int firstValue) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] < firstValue) {
                return i;
            }
        }
        return -1;
    }

    private static int findFirstIndex(int[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    private static void reverse(int[] permutation, int index) {
        int shift = index + 1;
        for (int i = 0; i < (permutation.length - shift) / 2; i++) {
            int temp = permutation[shift + i];
            permutation[shift + i] = permutation[permutation.length - i - 1];
            permutation[permutation.length - i - 1] = temp;
        }
    }


    private static int[] covertLongToIntArray(long n) {
        String tempStr = Long.toString(n);
        int[] newGuess = new int[tempStr.length()];
        for (int i = 0; i < tempStr.length(); i++) {
            newGuess[i] = tempStr.charAt(i) - '0';
        }
        return newGuess;
    }

    private static long converIntArrayToLong(int[] array) {
        StringBuilder tempString = new StringBuilder();
        for (var i : array) {
            tempString.append(i);
        }
        return Long.parseLong(String.valueOf(tempString));
    }

    public static long nextSmaller2(long n) {
        char[] carr = String.valueOf(n).toCharArray();
        int len = carr.length, i;
        for (i = len - 1; i > 0; i--) {
            if (carr[i] < carr[i - 1]) break;
        }
        if (i == 0) return -1;
        else {
            int x = carr[i - 1], min = i;
            for (int j = i + 1; j < len; j++) {
                if (carr[j] < x && carr[j] > carr[min]) {
                    min = j;
                }
            }
            char temp = carr[i - 1];
            carr[i - 1] = carr[min];
            carr[min] = temp;
            String[] sarr = String.valueOf(carr).split("");
            Arrays.sort(sarr, i, len, java.util.Collections.reverseOrder());
            long r = Long.valueOf(String.join("", sarr));
            return String.valueOf(r).length() == len ? r : -1;
        }
    }
}
