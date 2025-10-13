import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// M 이상 N 이하
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		boolean[] isPrime = new boolean[N + 1];

		Arrays.fill(isPrime, true);

		// 에라토스테네스의 체 방식
		// 전부 소수라고 가정
		// N의 제곱근까지의 수들의 배수를 구해서 제거한다
		for (int i = 2; i * i <= N; i++) {
			// 아직 지워지지 않은 소수이면
			if (isPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
					if (isPrime[j]) {
						isPrime[j] = false;
					}
				}
			}
		}

		StringBuilder ans = new StringBuilder();

		// 1은 소수가 아니므로 M이 1일 경우에는 2부터 출력할 수 있도록 한다
		for (int i = Math.max(2, M); i <= N; i++) {
			if (isPrime[i]) {
				ans.append(i).append("\n");
			}
		}

		System.out.println(ans);

	}

}
