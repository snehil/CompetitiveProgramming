package com.programming.leetcode;

/*
 * https://leetcode.com/problems/majority-element/description/
 * References (Majority Vote Algorithm - O(n) time):
 *  1. https://www.cs.utexas.edu/~moore/best-ideas/mjrty/
 *  2. https://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html
 *  
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets
 */
public class MajorityElement {
    
    /**
     * Gets the majority element from the provided array of ints
     * Time Complexity  = O(n)
     * Space Complexity = O(1)
     *  
     * @param num List of integers
     * @return majority element
     */
    public static int getMajorityElement(int[] num) {
        int major = num[0];
        int count = 1;
        
        for (int i=1; i < num.length; i++) {
            
            if (count == 0){
                count++;
                major=num[i];
            } else if (major == num[i]) {
                count++;
            } else {
                count--;
            }
        }
        
        return major;   
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {8,1,8,3,8,5};
        
        System.out.println("Majority Element: " + getMajorityElement(arr));
    }

}
