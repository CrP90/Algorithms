import java.util.Scanner;

public class PrimeNumbers {

    public static void main(String[] args) {
        System.out.println(">>");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (isPrime(n))
            System.out.println(n + " is a prime number");
        else
            System.out.println(n + " is not a prime number");
        primeFactors(n);
    }
    //this method returns true if n is prime
    static boolean isPrime(int n) {
        if (n < 2)
            return (false);
        if (n == 2)
            return (true);
        if (n % 2 == 0)
            return (false);
        for (int i = 3; i * i <= n; i += 2)
        {
            if (n % i == 0)
                return (false);
        }
        return (true);
    }
    //this method divides n in prime factors
    static void primeFactors(int n) {
        System.out.print(n + " = ");
        int i;
        i = 3;
        if (n == 1)
            System.out.print("1");
        while (n % 2 == 0) {
            System.out.print("2");
            n /= 2;
            if (n >= 2)
                System.out.print("*");
        }
        while (i * i <= n) {
            while (n % i == 0)
            {
                System.out.print(i);
                n /= i;
                if (n >= i)
                    System.out.print("*");
            }
            i += 2;
        }
        if (n > 2)
            System.out.print(n);
    }
}
