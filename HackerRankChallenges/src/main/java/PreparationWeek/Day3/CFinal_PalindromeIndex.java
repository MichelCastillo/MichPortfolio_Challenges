package PreparationWeek.Day3;

import java.util.Arrays;
import java.util.List;

/*
    Given a string of lowercase letters in the range ascii[a-z], determine the index of a character that can be removed to make the string a palindrome.
    There may be more than one solution, but any will do.
    If the word is already a palindrome or there is no solution, return -1.
    Otherwise, return the index of a character to remove.

    Example
        s = "bcbc"
        Either remove 'b' at index 0 or 'c' at index 3.

    Function Description
        palindromeIndex has the following parameter(s):
            string s: a string to analyze

    Returns
        int: the index of the character to remove or -1

    Input Format
        The first line contains an integer q, the number of queries.
        Each of the next q lines contains a query string s.

    Constraints
        1 <= q <= 20
        1 <= length of s <= pow(10, 5) + 5
        All characters are in the range ascii[a-z].
*/

public class CFinal_PalindromeIndex {

    public static void main(String[] args) {

        List<String> cadenas = Arrays.asList("aaab", "baa", "aab", "abba");

        cadenas.forEach(cadena -> {
            System.out.println("Cadena: " + cadena + " - Index: " + palindromeIndex2(cadena));
        });
    }

    public static int palindromeIndex(String s) {
        // Write your code here
        char[] cadena = s.toCharArray();
        int middle = s.length() / 2;

        for (int i = 0; i < middle; i++) {
            if(cadena[i] != cadena[s.length() -  (i + 1)]){

                if(cadena[i] == cadena[s.length() -  (i + 2)]){
                    return s.length() -  (i + 1);
                }
                return i;
            }
        }

        return -1;
    }

    public static int palindromeIndex2(String s) {
        // Write your code here
        int start = 0;
        int end = s.length() - 1;

        while (start < end && s.charAt(start) == s.charAt(end)){
            start++;
            end--;
        }

        if (start >= end) return -1;
        if (isPalindrome(s, ++start, end)) return start;
        if (isPalindrome(s, start, --end)) return end;

        return -1;
    }

    public static boolean isPalindrome(String s, int startIndex, int endIndex) {

        while(startIndex < endIndex && s.charAt(startIndex) == s.charAt(endIndex)){
            startIndex++;
            endIndex--;
        }

        return startIndex >= endIndex;
    }
}
