import java.util.Scanner;

public class FizzBuzz
{
	public static void main(String[] args) {
		System.out.println(">>");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		fizzBuzz(n);
		System.out.println();
		fizzBuzz1(n);
		System.out.println();
		fizzBuzz2(n);
	}

	static void fizzBuzz(int n) {
		StringBuilder result = new StringBuilder(100);
		for (int i = 1; i <= n; i++) {
			int length = result.length();
			if (i % 3 == 0)
				result.append("Fizz");
			if (i % 5 == 0)
				result.append("Buzz");
			if (length == result.length())
				result.append(i);
			result.append(" ");
		}
		System.out.print(result);
	}

	static void fizzBuzz1(int n) {
		for (int i = 1; i <= n; i++) {
			boolean flag = false;
			if (i % 3 == 0) {
				System.out.print("Fizz");
				flag = true;
			}
			if (i % 5 == 0) {
				System.out.print("Buzz");
				flag = true;
			}
			if (flag)
				System.out.print(" ");
			else
				System.out.print(i + " ");
		}
	}

	static void fizzBuzz2(int n) {
		for (int i = 1; i <= n; i++)
		{
			if (i % (3 * 5) == 0)
				System.out.print("FizzBuzz ");
			else if (i % 5 == 0)
				System.out.print("Buzz ");
			else if (i % 3 == 0)
				System.out.print("Fizz ");
			else
				System.out.print(i + " ");
		}
	}
}
