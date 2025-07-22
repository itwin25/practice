import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int pay = sc.nextInt();
		int change = 1000 - pay;
		int cnt = 0;

		while (change > 0) {
			if (change >= 500) {
				cnt++;
				change -= 500;
			} else if (change >= 100) {
				cnt++;
				change -= 100;
			} else if (change >= 50) {
				cnt++;
				change -= 50;
			} else if (change >= 10) {
				cnt++;
				change -= 10;
			} else if (change >= 5) {
				cnt++;
				change -= 5;
			} else if (change >= 1) {
				cnt++;
				change -= 1;
			}

		}

		System.out.println(cnt);
	}
}