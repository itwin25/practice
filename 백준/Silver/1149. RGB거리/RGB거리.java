import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 집의 개수
		int[][] cost = new int[n][3]; // 비용 배열

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[n][3];

		dp[0][0] = cost[0][0]; // 빨강으로 칠하고 싶을 때 최소비용 계산
		dp[0][1] = cost[0][1]; // 초록으로 칠하고 싶을 때 최소비용 계산
		dp[0][2] = cost[0][2]; // 파랑으로 칠하고 싶을 때 최소비용 계산

		for (int i = 1; i < n; i++) {
			// 1. 이번에 빨강 칠할래
			// -> 초록, 파랑 중에서 낮은 비용 + 현재 빨강 비용
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];

			// 2. 이번에 초록 칠할래
			// -> 빨강, 파랑 중에서 낮은 비용 + 현재 초록 비용
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];

			// 3. 이번에 파랑 칠할래
			// -> 빨강, 초록 중에서 낮은 비용 + 현재 파랑 비용
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
		}

		// 우선 빨강 값 넣어놓기
		int ans = dp[n - 1][0];

		// 초록, 파랑이랑 비교
		for (int i = 1; i < 3; i++) {
			ans = Math.min(ans, dp[n - 1][i]);
		}

		System.out.println(ans);
	}
}