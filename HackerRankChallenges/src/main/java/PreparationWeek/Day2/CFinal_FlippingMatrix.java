package PreparationWeek.Day2;

/*

    Sean invented a game involving a 2n x 2n matrix where each cell of the matrix contains an integer. He can reverse any of its rows or columns any number of times.
    The goal of the game is to maximize the sum of the elements in the  submatrix located in the upper-left quadrant of the matrix.

    Given the initial configurations for q matrices, help Sean reverse the rows and columns of each matrix
    in the best possible way so that the sum of the elements in the matrix's upper-left quadrant is maximal.

    Example
        matrix = [[1, 2], [3, 4]]
        1 2
        3 4

    It is 2x2 and we want to maximize the top left quadrant, a 1x1 matrix. Reverse row 1:
        1 2
        4 3

    And now reverse column 0:
        4 2
        1 3

    The maximal sum is 4.

    Function Description
        flippingMatrix has the following parameters:
            - int matrix[2n][2n]: a 2-dimensional array of integers

    Returns
        - int: the maximum sum possible.

    Input Format
        The first line contains an integer q, the number of queries.
        The next q sets of lines are in the following format:
            The first line of each query contains an integer, n.
            Each of the next 2n lines contains 2n space-separated integers matrix[i][j] in row  of the matrix.

    Constraints
        1 <= q <= 16
        1 <= n <= 128
        0 <= matrix[i][j] <= 4096, where 0 <= i,j < 2n
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CFinal_FlippingMatrix {

    public static void main(String[] args) {

    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        List<Integer> set = new ArrayList<>();
        int lenght = matrix.size() / 2;
        int result = 0;

        matrix.forEach(array -> {
            array.sort(Comparator.naturalOrder());
            for (int i = lenght; i > 0; i--) {
                set.add(array.get(array.size()-i));
            }
        });

        for (int i = lenght; i > 0; i--) {
            result += (set.get(set.size()-i));
        }

        return result;

    }
}
