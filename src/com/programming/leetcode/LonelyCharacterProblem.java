package com.programming.leetcode;

// TODO
public class LonelyCharacterProblem {
    
    public static void main(String[] args) {
        System.out.println("Lonely Character Problem:");
        
        char[] chars = new char[] {'a', 'b', 'c', 'b', 'a'};
        
        char lonelyChar = findLonelyChar(chars);
        
        System.out.println("Answer : " + lonelyChar);
    }

    private static char findLonelyChar(char[] chars) {
        int lonelyCharCode = (int) chars[0]; // Get ASCII code of char
        System.out.println(lonelyCharCode);
        
        for (int i=1; i<chars.length-1; i++) {
            lonelyCharCode = lonelyCharCode ^ (int) chars[i];
            System.out.println(lonelyCharCode);
        }
        
        return (char) lonelyCharCode;
    }

}
