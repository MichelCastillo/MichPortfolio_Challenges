package PreparationWeek.Day3;

/*

    Given an array of n distinct integers, transform the array into a zig zag sequence by permuting the array elements.
    A sequence will be called a zig zag sequence if the first k elements in the sequence are in increasing order and the last k elements are in decreasing order,
        where k (n + 1) / 2.
    You need to find the lexicographically smallest zig zag sequence of the given array.

    Example -> a = [2, 3, 5, 1, 4]
        Now if we permute the array as [1, 4, 5, 3, 2], the result is a zig zag sequence.
        Return the appropriate zig zag sequence for the given input array.

    Input Format
        The first line contains t the number of test cases.
        The first line of each test case contains an integer n, denoting the number of array elements.
        The next line of the test case contains n elements of array a.

     Constraints
        1 <= t <= 20
        1 <= n <= 10000 (n is always odd)
        1 <= a(i) <= pow(10, 9)
* */

import java.util.Arrays;
import java.util.List;

public class C01_ZigZagSequence {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        findZigZagSequence(values, k);

    }

    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = (n + 1)/2 - 1;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2;
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
