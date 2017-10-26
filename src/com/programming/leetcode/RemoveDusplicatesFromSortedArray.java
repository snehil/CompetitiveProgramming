package com.programming.leetcode;

/**
 * Remove Duplicates from Sorted Array
 *
 *   Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 *   Do not allocate extra space for another array, you must do this in place with constant memory.
 *   For example, Given input array nums = [1,1,2],
 *   Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * 
 * @author SW029693
 *
 */
public class RemoveDusplicatesFromSortedArray {
    
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,1,1,2,2,3,4,4,4,5};
        
        System.out.println("Length = " + removeDuplicates(arr));
        System.out.println("Array:");
        
        for (int val: arr){
            System.out.println(val);
        }
    }

    private static int removeDuplicates(int[] arr) {
        int count = 0;
        int id    = 0;
        
        for (int i=1; i<arr.length;i++) {
            
            if (arr[i-1] != arr[i]) {
                count++;
                arr[++id] = arr[i];
            }
        }
        
        return count + 1;
        
    }

}
