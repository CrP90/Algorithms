/**
 * A Caesar cipher is cyclic in the sense that any operation take shift
 * a letter beyond Z simply circle back to the beginning and start over again with A.
 *
 */

import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        System.out.println("Enter the number and the text");
        System.out.println(">>");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String message = scan.next();
        if (n < 0) {
            n = 26 - (-n % 26) ;
        }
        System.out.println("Encoded message: " + encodeString(message, n));
    }

    /** This method returns a String formed by shifting every letter
     * in str forward the number of letters indicated by shift, cycling
     * to the beginning of the alphabet if necessary */
    static String encodeString (String str, int shift) {
        String result = "";
        for (int i = 0; i < str.length(); i++){
            if (Character.isUpperCase(str.charAt(i))) {
                char ch = (char)('A' + ((str.charAt(i) - 'A' + shift) % 26));
                result += ch;
            } else if ( Character.isLowerCase(str.charAt(i)) ) {
                char ch = (char)('a' + ((str.charAt(i) - 'a' + shift) % 26));
                result += ch;
            } else result += str.charAt(i);
        }
        return result;
    }
}
