package PreparationWeek.Day2;

import java.util.Arrays;
import java.util.List;

/*

    Given a square matrix, calculate the absolute difference between the sums of its diagonals.
    For example, the square matrix arr is shown below:
        1 2 3
        4 5 6
        9 8 9

    The left-to-right diagonal = 1 + 5 + 9 = 15. The right to left diagonal = 3+5+9=17. Their absolute difference is |15-17| = 2.

    Function Description
         diagonalDifference takes the following parameter:
            int arr[n][m]: an array of integers

    Return
        int: the absolute diagonal difference

    Input Format
        The first line contains a single integer, n, the number of rows and columns in the square matrix arr.
        Each of the next n lines describes a[i] row, n, and consists of n space-separated integers arr[i][j].

    Constraints
        -100 <= arr[i][j] <= 100

    Output Format
        Return the absolute difference between the sums of the matrix's two diagonals as a single integer.

    Sample Input
        11 2 4
        4 5 6
        10 8 -12

*/

public class C02_DiagonalDifference {

    public static void main(String[] args) {
        List<List<Integer>> values = Arrays.asList(Arrays.asList(11, 2, 4), Arrays.asList(4, 5, 6), Arrays.asList(10, 8, -12));

        System.out.println(diagonalDifference(values));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int diag1 = 0;
        int diag2 = 0;

        for (int i = 0; i < arr.size(); i++) {
            diag1 += arr.get(i).get(i);
            diag2 += arr.get(i).get(arr.size() - (i+1));
        }

        return Math.abs(diag1 - diag2);
    }
}
