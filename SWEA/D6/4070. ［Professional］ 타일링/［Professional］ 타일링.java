import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 타일의 크기

			BigInteger[] dp = new BigInteger[N + 1];
			for (int i = 0; i < N + 1; i++) {
				dp[i] = BigInteger.ZERO;
			}

			dp[1] = BigInteger.ONE;

			if (N < 2) {
				System.out.println("#" + test_case + " " + dp[N]);
			} else {
				dp[2] = BigInteger.valueOf(3);
				for (int i = 3; i <= N; i++) {
					// 1. 마지막에 세로 타일을 하나 놓은 경우
					dp[i] = dp[i].add(dp[i - 1]);

					// 2. 마지막에 2*2 타일을 하나 놓은 경우 (2가지 종류 존재)
					dp[i] = dp[i].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
				}
				System.out.println("#" + test_case + " " + dp[N]);
			}

		} // tc
	} // main
}
