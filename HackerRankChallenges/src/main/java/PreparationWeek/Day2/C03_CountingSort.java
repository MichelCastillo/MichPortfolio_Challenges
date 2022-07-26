package PreparationWeek.Day2;

/*
    Comparison Sorting

    Quicksort usually has a running time of n * log(n), but is there an algorithm that can sort even faster?
    In general, this is not possible. Most sorting algorithms are comparison sorts, i.e. they sort a list just by comparing the elements to one another.
    A comparison sort algorithm cannot beat n * log(n) (worst-case) running time, since n * log(n) represents the minimum number of comparisons needed
        to know where to place each element. For more details, you can see these notes (PDF).

    Alternative Sorting
        Another sorting method, the counting sort, does not require comparison.
        Instead, you create an integer array whose index range covers the entire range of values in your array to sort.
        Each time a value occurs in the original array, you increment the counter at that index.
        At the end, run through your counting array, printing the value of each non-zero valued index that number of times.

    Example -> arr = [1, 1, 3, 2, 1]
        All of the values are in the range [0...3], so create an array of zeros, result [0, 0, 0, 0] -> result = [0, 3, 1, 1]
        The frequency array is [0, 3, 1, 1]. These values can be used to create the sorted array as well: sorted=[1, 1, 1, 2, 3]

    Note
        For this exercise, always return a frequency array with 100 elements. The example above shows only the first 4 elements, the remainder being zeros.

    Challenge
        Given a list of integers, count and return the number of times each value appears as an array of integers.

    Function Description
         countingSort has the following parameter(s):
            arr[n]: an array of integers

    Returns
        int[100]: a frequency array

    Input Format
        The first line contains an integer n, the number of items in arr.
        Each of the next n lines contains an integer arr[i] where a 0<= i < n.

     Constraints
        100 <= n <= pow(10,6)
        0 <= arr[i] < 100

*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C03_CountingSort {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(63, 54, 17, 78, 43, 70, 32, 97, 16, 94,
                                             74, 18, 60, 61, 35, 83, 13, 56, 75, 52,
                                             70, 12, 24, 37, 17, 0, 16, 64, 34, 81, 82,
                                             24, 69, 2, 30, 61, 83, 37, 97, 16, 70, 53,
                                             0, 61, 12, 17, 97, 67, 33, 30, 49, 70, 11,
                                             40, 67, 94, 84, 60, 35, 58, 19, 81, 16, 14,
                                             68, 46, 42, 81, 75, 87, 13, 84, 33, 34, 14,
                                             96, 7, 59, 17, 98, 79, 47, 71, 75, 8, 27, 73,
                                             66, 64, 12, 29, 35, 80, 78, 80, 6, 5, 24, 49, 82);

        System.out.println(countingSort(values));
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int[] result = new int[100];

        for (int i = 0; i < arr.size(); i++) {
            result[arr.get(i)]++;
        }

        return Arrays.stream(result).boxed().collect(Collectors.toList());

    }
}
