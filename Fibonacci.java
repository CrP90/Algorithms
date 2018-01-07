import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println(">>");
		int n = scan.nextInt();
		if (n < 0) {
			System.out.println("Only positive");
			return;
		}
		if (n < 2)
		{
			System.out.println("F(" + n + ") = " +n);
			return ;
		}
		long[]A = new long[n + 1];
		A[0] = 0;
		A[1] = 1;
		for (int i = 2; i < A.length; i++)
			A[i] = -1;
		System.out.println("F(" + n + ") = " + Fibonacci(n, A));
		System.out.println("F(" + n + ") = " + Fibonacci1(n));
		System.out.println("F(" + n + ") = " + Fibonacci2(n));
	}


	//memoization
	static long Fibonacci(int n, long[] A)
	{
		if (A[n] == -1)
			A[n] = Fibonacci((n - 1), A) + Fibonacci((n - 2), A);
		return A[n];
	}

	//bottom-up
	static long Fibonacci1(int n){
		long[] fib = new long[2];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++){
			fib[1] = fib[0] + fib[1];
			fib[0] = fib[1] - fib[0];
		}
		return (fib[1]);
	}

	//classic
	static long Fibonacci2(int n) {
		long a = 0;
		long b = 1;
		int count = 2;
		while (count <= n) {
			b = a + b;
			a = b - a;
			count++;
		}
		return (b);
	}
}
