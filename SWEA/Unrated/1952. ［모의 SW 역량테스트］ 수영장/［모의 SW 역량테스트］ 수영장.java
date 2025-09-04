import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int[] fee = new int[4]; // 요금
			int[][] month = new int[13][2]; // 월별 사용일[0], 요금[1]
			int ans = 0;

			// 요금 입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				fee[i] = Integer.parseInt(st.nextToken());
			}

			// 달 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < 13; i++) {
				month[i][0] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i < 13; i++) {
				if (month[i][0] * fee[0] > fee[1]) {
					month[i][1] = fee[1];
				} else {
					month[i][1] = fee[0] * month[i][0];
				}
			}

			int[] dp = new int[13];

			dp[1] = month[1][1];
			dp[2] = dp[1] + month[2][1];

			for (int i = 3; i < 13; i++) {
				dp[i] = Math.min(dp[i - 1] + month[i][1], dp[i - 3] + fee[2]);
			}

			if (dp[12] >= fee[3]) {
				System.out.println("#" + test_case + " " + fee[3]);
			} else {
				System.out.println("#" + test_case + " " + dp[12]);
			}

		} // tc
	} // main
}