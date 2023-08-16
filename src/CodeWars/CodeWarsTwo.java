package CodeWars;

import java.util.*;

public class CodeWarsTwo {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 6, 7, 8, 9, 10};
        int[] input2 = {10, 8, 7, 6, 5, 4, 2};

        System.out.println(Arrays.toString(twoSum(input, 13)));
        System.out.println(findMissing(input));


    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] resultTwo = new int[2];
        int tempSum;
        for (int i = 0; i < numbers.length; i++) {

            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    tempSum = numbers[i] + numbers[j];
                    if (tempSum == target) {
                        resultTwo[0] = i;
                        resultTwo[1] = j;
                    }
                }
            }
        }
        return resultTwo;
    }

    public static int findMissing(int[] numbers) {
        int temp_one = numbers[1] - numbers[0];
        int temp_two = numbers[2] - numbers[1];


        if (numbers[0] == numbers[numbers.length - 1]) return numbers[0];
        if (Math.abs(temp_one) < Math.abs(temp_two)) return numbers[1] + temp_one;
        if (Math.abs(temp_one) > Math.abs(temp_two)) return numbers[0] + temp_two;

        if (Math.abs(temp_one) == Math.abs(temp_two)) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] + temp_one != numbers[i + 1]) return numbers[i] + temp_one;
            }
        }
        return 0;
    }
}


