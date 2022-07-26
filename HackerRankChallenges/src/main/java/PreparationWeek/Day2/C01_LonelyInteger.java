package PreparationWeek.Day2;

/*

    Given an array of integers, where all elements but one occur twice, find the unique element.

    Example -> a = [1, 2, 3, 4, 3, 2, 1]
        The unique element is 4.

    Function Description
        lonelyinteger has the following parameter(s): int a[n]: an array of integers

    Returns
        int: the element that occurs only once

    Input Format
        The first line contains a single integer, n, the number of integers in the array.
        The second line contains n space-separated integers that describe the values in a.

    Constraints
        1 <= n < 100
        It is guaranteed that n is an odd number and that there is one unique element.
        a >= a[i] 100 where 0 <= i < n
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class C01_LonelyInteger {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(0, 0, 1, 2, 1);

        System.out.println(lonelyinteger(values));
    }

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        HashSet<Integer> comparing = new HashSet<Integer>();
        List<Integer> result = new LinkedList<>();

        a.forEach(i -> {
            if(comparing.add(i)){
                result.add(i);
            } else {
                result.remove(i);
            }
        });

        return result.get(0);
    }
}
