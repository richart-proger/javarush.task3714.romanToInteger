package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        Map<Character, Integer> numbers = new HashMap<>();
        numbers.put('I', 1);
        numbers.put('V', 5);
        numbers.put('X', 10);
        numbers.put('L', 50);
        numbers.put('C', 100);
        numbers.put('D', 500);
        numbers.put('M', 1000);

        char [] romans = s.toCharArray();
        int result = 0;

        for (int i = romans.length-1; i >= 0; i--) {
            if (i >= 1) {
                if (numbers.get(romans[i - 1]) < numbers.get(romans[i])) {
                    result = result + (numbers.get(romans[i]) - numbers.get(romans[i - 1]));
                    i--;
                }
                else {
                    result = result + numbers.get(romans[i]);
                }
            }
            else {
                result = result + numbers.get(romans[i]);
            }
        }
        return result;
    }
}
