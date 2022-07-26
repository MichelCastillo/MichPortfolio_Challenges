package challenge1;

/*
    Task:
    Given a list of integers, determine whether the sum of its elements is odd or even.

    Give your answer as a string matching "odd" or "even".

    If the input array is empty consider it as: [0] (array with a zero).

    Examples:
    Input: [0]
    Output: "even"

    Input: [0, 1, 4]
    Output: "odd"

    Input: [0, -1, -5]
    Output: "even"
    Have fun!
*/

import java.util.Arrays;
import java.util.function.Predicate;

public class Challenge6 {

    private static final Predicate<Integer> isEven = p -> p % 2 == 0;

    public static String oddOrEven (int[] array) {
        return isEven.test(Arrays.stream(array).sum()) ? "even" : "odd";
    }

}
