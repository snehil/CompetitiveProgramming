package com.programming.leetcode;

public class Sqrt {

    public static void main(String[] args) {
//        int num = 2147395599;
        int num=144;
        
//        System.out.println("Square root is: " + sqrtIterative(num));
        System.out.println("Square root is: " + sqrtRecursive(num));
    }
    
    public static int sqrtRecursive(int num) {
        return sqrtRecursiveUtil(0, num/2, num);
    }
    
    public static int sqrtRecursiveUtil(int lo, int hi,int num) {
        
        int mid = (lo + hi)/2;
        
        if (lo == hi) {
            return -1; // NOT FOUND
        } else if (mid*mid==num) {
            return mid;
        } else if (mid*mid > num) {
            return sqrtRecursiveUtil(lo, mid-1, num);
        } else {
            return sqrtRecursiveUtil(mid+1, hi, num);
        }
    }
    
    public static int sqrtIterative(int num) {
        
        int low  = 1; 
        int high = num;
        int mid  = (low+high)/2;
        int ans  = 0;
        
        while(low<=high) {
            // Perform binary search
            
            if (mid*mid == num) {
                return mid; // Solution found!
            } 
            
            if (mid*mid < num) {
                low = mid+1;
            } else {
                high = mid-1;
                ans  = mid;
            }
        }
        
        return ans;
    }
}
