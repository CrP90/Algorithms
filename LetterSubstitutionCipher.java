/** This program translates a line of text using a letter-substitution cipher.
 */

import java.util.Scanner;

public class LetterSubstitutionCipher {

    public static void main(String[] args) {
        System.out.println("This program implements a letter-substitution cipher.");
        Scanner scan = new Scanner(System.in);
        System.out.println("Cipher(26 letters key): ");
        String key = scan.next();
        while (!isLegalKey(key)) {
            System.out.println("That key is not legal.");
            System.out.println(">>");
            key = scan.next();
        }
        System.out.println("Text: ");
        String plaintext = scan.next();
        String ciphertext = encrypt(plaintext, key);
        String decryption = decrypt(ciphertext, key);
        System.out.println("Ciphertext: " + ciphertext);
        System.out.println("Decryption: " + decryption);
    }

    //checks to see whether a key is legal
    private static boolean isLegalKey(String key) {
        if (key.length() != 26)
            return false;
        for (int i = 0; i < 26; i++) {
            char ch = key.charAt(i);
            for (int j = i + 1; j < 26; j++) {
                if (ch == key.charAt(j))
                    return false;
            }
        }
        return true;
    }

    //encrypts a string according to the key
    private static String encrypt(String str, String key) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = encryptCharacter(str.charAt(i), key);
            result += ch;
        }
        return result;
    }

    //Encrypts a single character according to the key
    private static char encryptCharacter(char ch, String key) {
        if (Character.isLetter(ch)) {
            ch = key.charAt(Character.toUpperCase(ch) - 'A');
        }
        return ch;
    }

    //Decrypts a string according to the key
    private static String decrypt(String str, String key) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = decryptCharacter(str.charAt(i), key);
            result += ch;
        }
        return result;
    }

    //decrypts a single character according to the key
    private static char decryptCharacter(char ch, String key) {
        int index = key.indexOf(ch);
        if (index != -1) {
            ch = (char) ('a' + index);
        }
        return ch;
    }
}
