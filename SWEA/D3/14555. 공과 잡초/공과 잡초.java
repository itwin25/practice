import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		sc.nextLine();

		for (int test_case = 1; test_case <= T; test_case++) {
			String land = sc.nextLine();
			int cnt = 0; // 공의 개수의 최솟값

			for (int i = 0; i < land.length(); i++) {
				// '('만 보이는 경우
				if (land.charAt(i) == '(' && land.charAt(i + 1) != ')') {
					cnt++;
					// ')'만 보이는 경우
				} else if (land.charAt(i) == ')' && land.charAt(i - 1) != '(') {
					cnt++;
					// 공이 다 보이는 경우
				} else if (land.charAt(i) == '(' && land.charAt(i + 1) == ')') {
					cnt++;
				}
			}

			System.out.println("#" + test_case + " " + cnt);

		}
	}
}