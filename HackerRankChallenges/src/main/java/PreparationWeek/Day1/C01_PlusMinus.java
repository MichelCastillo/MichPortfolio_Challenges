package PreparationWeek.Day1;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/*
    Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
        Print the decimal value of each fraction on a new line with  places after the decimal.
    Note: This challenge introduces precision problems. The test cases are scaled to six decimal places,
        though answers with absolute error of up to  are acceptable.

    Example -> arr = [1, 1, 0, -1, -1]
        There are n = 5  elements, two positive, two negative and one zero. Their ratios are 2/5 = 0.400000, 2/5 = 0.400000 and 1/5 = 0.200000.
            Results are printed as:
                0.400000
                0.400000
                0.200000

        Function Description
            plusMinus has the following parameter(s):
                int arr[n]: an array of integers

        Print
            Print the ratios of positive, negative and zero values in the array.
            Each value should be printed on a separate line with 6 digits after the decimal. The function should not return a value.

        Input Format
            The first line contains an integer, n, the size of the array.
            The second line contains n space-separated integers that describe arr[n].

        Constraints
            0 < n <= 100
            -100 <= arr[i] <= 100

        Output Format
            Print the following 3 lines, each to 6 decimals:
                proportion of positive values
                proportion of negative values
                proportion of zeros

    */
public class C01_PlusMinus {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 1, 0, -1, -1);
        plusMinus(values);
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int[] integers = new int[3];
        int size = arr.size();

        for (Integer i : arr) {
            if (i < 0){
                integers[0]++;
            } else if (i == 0){
                integers[1]++;
            } else {
                integers[2]++;
            }
        }

        printFormatedValue((double) integers[2] / size);
        printFormatedValue((double) integers[0] / size);
        printFormatedValue((double) integers[1] / size);

    }

    public static void printFormatedValue(Double value){
        DecimalFormat df = new DecimalFormat("0.000000");
        System.out.println(df.format(value));
    }

}
