import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
		System.out.println(">>");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
        String result = "";
		for (int i = str.length() - 1; i >= 0; i--)
			result += str.charAt(i);
		System.out.println("Reverse of entered string is: " + result);
		if (result.equals(str))
			System.out.println("String " + str + " is a palindrome");
		else
			System.out.println("String " + str + " is not a palindrome");
    }
}
