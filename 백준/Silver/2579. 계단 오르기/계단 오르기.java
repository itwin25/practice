import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = Integer.parseInt(br.readLine());
		int[] score = new int[300];

		for (int i = 0; i < cnt; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[300]; // DP 배열

		dp[0] = score[0]; // 첫번째 계단 최대 점수
		dp[1] = score[0] + score[1];
		dp[2] = Math.max(score[0] + score[2], score[1] + score[2]);

		for (int i = 3; i < cnt; i++) {
			dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
		}

		System.out.println(dp[cnt - 1]);
	}
}