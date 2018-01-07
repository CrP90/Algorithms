/** This program reads a line and translates every word in "pasareasca". */

import java.util.Scanner;
import java.util.StringTokenizer;

public class Pasareasca {

    private static final String delimiters = "~!@#$%^&*()-=?,.\"[]>< ";

    public static void main(String[] args) {
        System.out.println(">>");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        System.out.println(translateLine(line));
    }

    static String translateLine(String str) {
        String result = "";
        StringTokenizer tokenizer = new StringTokenizer(str, delimiters, true);
        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (isWord(token)) {
                token = inPasareasca(token);
            }
            result += token;
        }
        return result;
    }

    private static boolean isWord(String s){
        for (int i = 0 ; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static String inPasareasca(String s) {
        String result ="";
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                result += s.charAt(i) + "p" + Character.toLowerCase(s.charAt(i));
            }else result += s.charAt(i);
        }
        if (!isVowel(s.charAt(s.length() - 1))) {
            result += "p";
        }
        return result;
    }

    private static boolean isVowel(char ch) {
        switch(Character.toLowerCase(ch)){
            case 'a': case 'e': case 'i': case 'o': case 'u': return true;
            default: return false;
        }
    }
}
