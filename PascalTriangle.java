import java.util.*;

public class PascalTriangle {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Height: ");
		int n = in.nextInt();
		pascalTriangle(n);
		System.out.println();
		pascalTriangle1(n);
		System.out.println();
		pascalTriangle2(n);
	}
	
	static int sum(byte[] A){
		int sum = 0;
		for (byte b : A)
			sum += b;
		return (sum);
	}
	
	static void pascalTriangle(int n){
		int[] prev = {1};
		int[] current;
		for (int line = 0; line < n; line++){
			for (int i = n; (i - 1) > line; i--){
				System.out.print(" ");
			}
			current = new int[line + 1];
			for (int j = 0; j <= line; j++){
				if (j == 0 || j == line){
					System.out.print("1   ");
					current[j] = 1;
				}
				else{
					int temp = prev[j - 1] + prev[j];
					if(temp >= 100)
						System.out.print(temp + " ");
					else if(temp >= 10)
						System.out.print(temp + "  ");
					else
						System.out.print(temp + "   ");
					current[j] = temp;
				}
			}
			prev = current;
			System.out.println();
		}
	}
	
	static void pascalTriangle1(int n){
		int result;
		for (int line = 1; line <= n; line++){
			result = 1;
			for (int i = 1; i <= line; i++){
				System.out.print(result + " ");
				result = result * (line - i) / i;
			}
			System.out.println();
		}
	}

	static void pascalTriangle2(int n){
		for (int line = 0; line < n; line++){
			for (int j = 0; j <= line; j++){
				System.out.print(Comb(line, j) + "   ");
			}
			System.out.println();
		}
	}
	
	static long Comb(int n, int k){
		return (Factorial(n) / (Factorial(k) * Factorial(n - k)));
	}
	
	static long Factorial(int n){
		if (n == 0 || n == 1)
			return (1);
		return (n * Factorial(n - 1));
	}
}
