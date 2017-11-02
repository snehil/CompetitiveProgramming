package com.programming.leetcode;

/*
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 */
public class StringPermutations {
    
    public static void main(String[] args) {
        String str = "abcd";
        int counter = 0;
        
        permuteString(str);
    }
    
    public static void permuteString(String str) {
        permuteStringUtil(0, str.length()-1, str);
    }
    
    public static void permuteStringUtil(int start, int end, String str) {
        
        if (start == end) {
            System.out.println(str);
            return;
        }
        
        for(int i=start; i<=end; i++) {
            str = swap(start, i, str);
            permuteStringUtil(start+1, end, str);
            str = swap(start, i, str);
        }
    }
    
    public static String swap(int idxToSwap, int swapWithIdx, String str) {
        char[] chars = str.toCharArray();
        char temp;
        
        temp               = chars[idxToSwap];
        chars[idxToSwap]   = chars[swapWithIdx];
        chars[swapWithIdx] = temp;
        
        return String.valueOf(chars);
    }

}
