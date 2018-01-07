/** This program reads a file and reports how many lines, words
 *  and characters appears in it. */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WordCount {

    public static void main(String[] args) {
        BufferedReader rd = openFile("Enter input file: ");
        String[] lines = readLines(rd);
        int nLines = 0; // stores the number of line
        int nWords = 0; // stores the number of words
        int nChars = 0; // stores the number of characters
        for (int i = 0; i < lines.length; i++) {
            nLines++;
            nWords += countWordsAndChars(lines[i]);
            nChars += lines[i].length();
        }
        System.out.println("Number of lines = " + nLines);
        System.out.println("Number of words = " + nWords);
        System.out.println("Number of characters = " + nChars);
    }

    /* This method allows the user to select a file by entering its name in response to a prompt.
     * If the file exists, the method returns a BufferedReader , if not the method displays a message
     * indicating that it can't find the specific file and gives the user another chance to enter the file name. */
    private static BufferedReader openFile(String prompt) {
        BufferedReader rd = null;
        System.out.println(prompt + "\n>>");
        Scanner scan = new Scanner(System.in);
        while (rd == null) {
            try {
                String name = scan.next();
                rd = new BufferedReader(new FileReader(name));
            } catch (IOException ex) {
                System.out.println("Can't open that file");
                System.out.println(">>");
            }
        }
        return (rd);
    }

    /* This method reads all available lines from the specified reader and returns an array containing those
     * lines. This method closes the reader at the end of the file. */
    private static String[] readLines(BufferedReader rd) {
        ArrayList<String> lineList = new ArrayList<String>();
        try {
            while (true) {
                String line = rd.readLine();
                if (line == null)
                    break;
                lineList.add(line);
            }
            rd.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String[] result = new String[lineList.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = lineList.get(i);
        return (result);
    }

    /* This method return the numbers of words in a string. A word is considered
     * a sequence of any characters excepts white space. */
    private static int countWordsAndChars(String str) {
        int count = 0;
        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()) {
            tokenizer.nextToken();
            count++;
        }
        return (count);
    }
}