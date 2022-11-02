// Given an array that consists of elements from range 1 to n. One of the elements is missing from the given list. Find the missing number in the given array.
// example:
// arr=[1,3,5,2,6,4,8,9,10].
// output: the missing number is  7.

// import java.util.*;
// import java.util.Arrays;



class Solution {
    static int MissingNumber(int arr[])
    {
        int n=arr.length;
        int total = 1;
        for (int i = 2; i <= (n + 1); i++) {
            total += i;
            total -= arr[i - 2];
        }
        return total;
    }
    
    public static void main(String[] args)
    {
        int[] arr = { 1,3,5,2,6,4,8,9,10 };
        System.out.println(MissingNumber(arr));
    }
}



