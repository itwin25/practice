import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 정수 N

		StringBuilder ans = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			String s = i + "";
			int cnt = 0;

			// 3, 6, 9를 포함하고 있을 경우
			if (s.contains("3") || s.contains("6") || s.contains("9")) {
				for (int j = 0; j < s.length(); j++) {
					char ch = s.charAt(j);

					// 3, 6, 9 개수 세기
					if (ch == '3' || ch == '6' || ch == '9') {
						cnt++;
					}
				}

				// cnt만큼 "-" append
				for (int k = 0; k < cnt; k++) {
					ans.append("-");
				}
				ans.append(" ");

			} else { // 없으면 그냥 append
				ans.append(s).append(" ");
			}
		}

		System.out.println(ans.toString().trim());
	}
}