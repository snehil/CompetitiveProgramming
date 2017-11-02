package com.programming.leetcode;

public class ReverseVowelsInAString {
    public static void main(String[] args) {
        System.out.println(reverseVowels("LeEtCodE"));
    }
    
    // 2-pointer solution
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        
        int i=0;
        int j=chars.length-1; 
        
        while(i<j)  {
            
            if (!isVowel(chars[i])) {
                i++;
            } else if (!isVowel(chars[j])) {
                j--;
            } else {
                swap(i, j, chars);
                i++;
                j--;
            }
        }
        
        return String.valueOf(chars);
    }
    
    public static char[] swap(int sIdx, int eIdx, char[] c) {
        char temp = c[sIdx];
        c[sIdx] = c[eIdx];
        c[eIdx] = temp;
        
        return c;
    }
    
    public static boolean isVowel(char c) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        
        for (int i=0; i<vowels.length; i++) {
            if (c == vowels[i]) {
                return true;
            }
        }
        
        return false;
    }
}
