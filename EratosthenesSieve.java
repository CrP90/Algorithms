/** This program uses the sieve of Eratosthenes to generate a list of prime
 * numbers between 2 and n.
 */

import java.util.Scanner;

public class EratosthenesSieve {

    public static void main(String[] args) {
        System.out.println(">>");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        boolean[] list = eratosthenesSieve(n + 1);
        System.out.print(2 + " ");
        for (int i = 3; i <= n; i += 2)
        {
            if(list[i] == false)
                System.out.print(i + " ");
        }
    }

    private static boolean[] eratosthenesSieve(int n)
    {
        boolean[] list = new boolean[n];
        for (int i = 3; i * i <= n; i += 2)
        {
            if (list[i] == false)
            {
                for (int j = i * i; j <= n; j += 2 * i)
                    list[j] = true;
            }
        }
        return (list);
    }
}
