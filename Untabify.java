/** This program updates the file so that all the tabs
 *  are replaced by enough spaces to reach the next tab stop. */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Untabify {

    private static File file;  //stores location information of the file selected

    public static void main(String[] args) {
        /* If the user doesn't choose a file print a message, else update that file. */
        BufferedReader rd = openFile("Enter input file: ");
        if (rd == null)
            System.out.println("You haven't choose a file.");
        else
        {
            String[] lines = readLines(rd);
            for(int i = 0; i < lines.length; i++)
                lines[i] = untabify(lines[i]);
            updateFile(lines);
        }
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
                file = new File(scan.next());
                rd = new BufferedReader(new FileReader(file));
            } catch (IOException ex) {
                System.out.println("Can't open that file");
                System.out.println(">>");
            }
        }
        return (rd);
    }

    /* This method reads all available lines from the specified reader and returns an array containing those
     * lines. This method closes the reader at the end of the file. */
    private static String[] readLines(BufferedReader rd)
    {
        ArrayList<String> lineList = new ArrayList<String>();
        try
        {
            while (true)
            {
                String line = rd.readLine();
                if (line == null)
                    break;
                lineList.add(line);
            }
            rd.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        String[] result = new String[lineList.size()];
        for (int i = 0; i < lineList.size(); i++)
            result[i] = lineList.get(i);
        return (result);
    }

    /* This method considers tab stop set every 8 spaces and replace
     * all the tabs by enough spaces to reach the next tab stop. */
    private static String untabify(String line)
    {
        String	result = "";
        int		count = 0;

        for (int i = 0; i < line.length(); i++)
        {
            if (line.charAt(i) == '\t')
            {
                int	nSpaces = 8 - (count % 8);
                while (nSpaces-- > 0)
                {
                    result += ' ';
                    count++;
                }
            }
            else
            {
                result += line.charAt(i);
                count++;
            }
        }
        return (result);
    }

    /* This method reopens the selected file and writes the new modified text. */
    private static void updateFile(String[] lines)
    {
        try
        {
            PrintWriter wr = new PrintWriter(new FileWriter(file));
            for (int i = 0;  i < lines.length; i++)
                wr.println(lines[i]);
            wr.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
