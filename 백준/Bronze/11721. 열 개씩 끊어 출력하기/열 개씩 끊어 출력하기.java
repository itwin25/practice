import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String[] arr = a.split("");

		for (int i = 0; i < a.length(); i += 10) {
			System.out.println(a.substring(i, Math.min(i + 10, a.length())));
		}

	}
}