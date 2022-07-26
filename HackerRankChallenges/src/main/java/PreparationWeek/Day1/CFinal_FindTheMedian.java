package PreparationWeek.Day1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*

    The median of a list of numbers is essentially its middle element after sorting.
    The same number of elements occur after it as before. Given a list of numbers with an odd number of elements, find the median?

    Example -> arr = [5, 3, 1, 2, 4]
        The sorted array arr' = [1, 2, 3, 4, 5]. The middle element and the median is 3.

    Function Description
        findMedian has the following parameter(s):
            int arr[n]: an unsorted array of integers

    Returns
        int: the median of the array

    Input Format
        The first line contains the integer n, the size of arr.
        The second line contains n space-separated integers arr[i]

    Constraints
        1 <= n <= 1000001
        n is odd

    Sample Input
        0 1 2 4 6 5 3

    Sample Output
        3
*/

public class CFinal_FindTheMedian {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(0, 1, 2, 4, 6, 5, 3);

        System.out.println(findMedian(values));
    }

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        arr.sort(Comparator.naturalOrder());
        return arr.get(arr.size() / 2);
    }

}
