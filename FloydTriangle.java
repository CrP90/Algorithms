import java.util.Scanner;

public class FloydTriangle {

    public static void main(String[] args) {
        System.out.println(">>");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 1;
		for (int i = 0; i < n; i++)
		{
			boolean flag = false;
			for (int j = 0; j <= i; j++)
			{
				if (flag)
					System.out.print(" ");
				flag = true;
				System.out.print(count++);
			}
			System.out.print("\n");
		}
    }
}
