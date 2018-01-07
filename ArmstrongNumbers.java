/** An Armstrong number is a number that is the sum of its own
 *  digits each raised to the power of the number of digits
 */

import java.util.Scanner;

public class ArmstrongNumbers {

    public static void main(String[] args) {
        System.out.println(">>");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int len = length(n);
        int result = 0;
        int temp = n;
        while (n != 0)
        {
            result += Math.pow((n % 10), len);
            n /= 10;
        }
        if (result == temp)
            System.out.println("is Armstrong number");
        else
            System.out.println("niet");
    }

    private static int length(int n)
    {
        if (n == 0)
            return (1);
        int len = 0;
        while (n != 0)
        {
            len++;
            n /= 10;
        }
        return (len);
    }
}
