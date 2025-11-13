import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		boolean[] isPrime = new boolean[1000001];
		Arrays.fill(isPrime, true);

		// 소수인지 확인
		for (int i = 2; i * i <= 1000000; i++) {
			// 아직 지워지지 않은 소수이면
			if (isPrime[i]) {
				for (int j = i * i; j <= 1000000; j += i) {
					if (isPrime[j]) {
						isPrime[j] = false;
					}
				}
			}
		}

		while (num != 0) {

			StringBuilder ans = new StringBuilder();

			ans.append(num).append(" = ");

			for (int i = 3; i <= num / 2; i++) {
				// 작은 소수 하나 뽑기
				if (isPrime[i]) {
					// 만족하는 소수 찾았으면 출력하고 종료
					if (isPrime[num - i]) {
						ans.append(i).append(" + ").append(num - i);
						System.out.println(ans);
						break;
					}
				}
			}

			// 다음 테스트케이스 숫자 받아오기
			num = Integer.parseInt(br.readLine());

		}

	}
}