package com.programming.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return 2.
 * 
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class IntersectionOfTwoArrays {
    
    public static void main(String[] args) {
        
        int[] arr1 = new int[]{1,2,2,1};
        int[] arr2 = new int[]{5,3,3,2,2};
        
        System.out.println("Intersection is at: " + findIntersection(arr1, arr2));
    }
    
    // O(nlogn) Time, O(1) space
    public static int findIntersection(int[] arr1, int[] arr2) {
        
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
            return -1;
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        int i = 0;
        int j = 0;
        
        while(i<arr1.length || j<arr2.length) {
            
            if (arr1[i] == arr2[j]) {
                return arr1[i];
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        return -1;
    } 
    
}
