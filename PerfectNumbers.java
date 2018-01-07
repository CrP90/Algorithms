/** A perfect number is a positive integer that is equal to the sum of its proper positive divisors */

import java.util.Scanner;

public class PerfectNumbers {

    public static void main(String[] args) {
        System.out.println(">>");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 5; i < n; i++) {
            if (isPerfect(i))
                System.out.println(i);
        }
    }

    static boolean isPerfect (int n){
        int divSum = 0;
        for (int i = 1; i <= n/2; i++){
            if (n % i == 0) {
                divSum += i;
            }
        }
        return (divSum == n);
    }
}
