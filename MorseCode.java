/** This program reads a string from user and translates each letter
 * in the string to its equivalent in Morse code using periods to
 * represent dots and hyphens to represent dashes.
 */

import java.util.Scanner;

public class MorseCode {
    public static void main(String[] args) {
        System.out.println("This program translates a line into Morse code.");
        System.out.println(">>");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        for(int i = 0; i < str.length(); i++)
        {
            if(Character.isLetter(str.charAt(i)))
            {
                System.out.print(toMorse(str.charAt(i)));
                if((i + 1) < str.length() && str.charAt(i + 1) != ' ')
                    System.out.print(" ");
                else
                    System.out.print("\n");
            }
        }
    }

    static String toMorse(char c)
    {
        String[] Morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        return (Morse[toLower(c) - 'a']);
    }

    private static char toLower(char c)
    {
        if(c >= 'A' && c <= 'Z')
            return (char)(c + 'a' - 'A');
        return (c);
    }
}
