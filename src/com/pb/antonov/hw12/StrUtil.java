package com.pb.antonov.hw12;


import java.util.Collections;

public class StrUtil {
    public static String leftPadding(String input, int lengthOfPadding)
    {
        char ch = ' ';
        String result
                = String
                // First left pad the string
                // with space up to length lengthOfPadding
                .format("%" + lengthOfPadding + "s", input)
                // Then replace all the spaces
                // with the given character ch
                .replace(' ', ch);
        // Return the resultant string
        return result;
    }

    public static String rightPadding(String input, int lengthOfPadding)
    {
        char ch = ' ';
        String result
                = String
                // First right pad the string
                // with space up to length lengthOfPadding
                .format("%" + (-lengthOfPadding) + "s", input)
                // Then replace all the spaces
                // with the given character ch
                .replace(' ', ch);
        // Return the resultant string
        return result;
    }

    public static String delimiterLine(int delimLength){
        return String.join("", Collections.nCopies(delimLength, "-"));
    }
}
