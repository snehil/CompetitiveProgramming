package com.programming.leetcode;

/*
 * https://leetcode.com/problems/reverse-integer/description/
 * 
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * click to show spoilers.
 * 
 * Note:
 * The input is assumed to be a 32-bit signed integer. Your function should 
 * return 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        int intToReverse = -12345;
        System.out.println("Reversed Integer = " + reverseInt(intToReverse));
    }
    
    public static int reverseInt(int inputNumber) {
        // Use long datatype to take care of Integer overflow problem
        long reversedInt  = 0;
        long intToReverse = (long) inputNumber; 
        
        if (intToReverse == 0) {
            return 0;
        }
        
        while (intToReverse != 0) {
            
            // Extract last number from int
            int lastNumber = (int) (intToReverse % 10);
            
            // Multiply reversed int by 10
            reversedInt *= 10;
            
            // Add extracted last number to reversed int
            reversedInt += lastNumber;
            
            // Remove last number from intToReverse
            intToReverse /=10;
        }
        
        return (int)reversedInt;
    }
}
