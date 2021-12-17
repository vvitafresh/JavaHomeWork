package com.pb.antonov.hw11;

public class StrUtil {
    public static String leftPadding(String input, int L)
    {
        char ch = ' ';
        String result
                = String
                // First left pad the string
                // with space up to length L
                .format("%" + L + "s", input)
                // Then replace all the spaces
                // with the given character ch
                .replace(' ', ch);
        // Return the resultant string
        return result;
    }

    public static String rightPadding(String input, int L)
    {
        char ch = ' ';
        String result
                = String
                // First right pad the string
                // with space up to length L
                .format("%" + (-L) + "s", input)
                // Then replace all the spaces
                // with the given character ch
                .replace(' ', ch);
        // Return the resultant string
        return result;
    }
}
