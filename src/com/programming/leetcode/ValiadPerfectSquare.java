package com.programming.leetcode;

/*
 * https://leetcode.com/problems/valid-perfect-square/description/
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 */
public class ValiadPerfectSquare {

    public static void main(String[] args) {
        int num = 25;
        
        System.out.println("Is perfect quare = " + isValidPerfectSquare(num));
    }
    
    /*
     * This is a math problem：
     * 1 = 1
     * 4 = 1 + 3
     * 9 = 1 + 3 + 5
     * 16 = 1 + 3 + 5 + 7
     * 25 = 1 + 3 + 5 + 7 + 9
     * 36 = 1 + 3 + 5 + 7 + 9 + 11
     * 
     * 14 = 1 + 3 + 5 + 7
     */
    public static boolean isValidPerfectSquare(int num) {
        
        int temp = 1;
        
        while(temp<=num) {
            num-= temp;
            temp+=2;
        }
        
        return num==0; 
    } 
}
