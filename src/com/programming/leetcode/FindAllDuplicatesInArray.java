package com.programming.leetcode;

import java.util.*;

/*
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 * 
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 */
public class FindAllDuplicatesInArray {
    
    public static void main(String[] args) {
        System.out.println("Finding Duplicates In Array:");
        
        int[] arr = new int[] {4,3,2,7,8,2,3,1};
        
        List<Integer> dups = findAllDuplicates(arr);
        
        for (Integer dup: dups) {
            System.out.println((int)dup + " Is A Duplicate");
        }
    }
    
    public static List findAllDuplicates(int[] arr) {
        List<Integer> dups = new ArrayList<Integer>();
        
        for (int i=0; i<arr.length; i++) {
            // find the idx to negate
            int     idxToNegate = Math.abs(arr[i]) - 1;
            boolean isNegative  = arr[idxToNegate] < 0;
            
            if (!isNegative) {
                // Negate the idx if not negative
                arr[idxToNegate] = -arr[idxToNegate];                
            } else {
                // The ith value is a duplicate
                dups.add(new Integer(Math.abs(arr[i])));
            }
        }
        
        return dups;
    }
}
