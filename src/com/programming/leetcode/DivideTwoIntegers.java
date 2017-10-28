package com.programming.leetcode;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * 
 * Reference: https://discuss.leetcode.com/topic/15568/detailed-explained-8ms-c-solution/2
 * 
 * @author Snehil
 *
 */
public class DivideTwoIntegers {

    public static int solve(int dividend, int divisor) {
        
        // Check divide by zero & overflow condition 
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return -1;
        }
                
        int quotient = 0;
        int sign     = (dividend < 0) || (divisor < 0) ? -1 : 1;
        dividend     = Math.abs(dividend);
        divisor      = Math.abs(divisor);
        
        while(dividend >= divisor) {
            int shiftCount = 1;  
            int tempDivisor = divisor;
            
            while(dividend >= (tempDivisor << 1)) {
                tempDivisor    <<= 1;
                shiftCount <<= 1;
            }
            
            dividend -= tempDivisor; 
            quotient += shiftCount; 
        }
        
        return sign * quotient;
    }
    
    public static void main(String[] args) {
        System.out.println("Divide 2 Integers:");
        System.out.println("Result = " + solve(15, -3));
    }
}
