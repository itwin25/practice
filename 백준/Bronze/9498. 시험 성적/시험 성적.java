import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력으로 시험성적을 받는다
		int score = sc.nextInt();

		// A: 90 ~ 100, B: 80 ~ 89, C: 70 ~ 79, D: 60 ~ 69, F: 나머지
		if (score >= 90 && score <= 100) {
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70) {
			System.out.println("C");
		} else if (score >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}

	}
}