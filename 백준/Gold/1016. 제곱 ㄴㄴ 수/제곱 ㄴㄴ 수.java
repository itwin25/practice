import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());

		// max와 min의 차이는 최대 100만입니다.
		// false: 제곱ㄴㄴ수(기본값), true: 제곱수로 나누어 떨어짐(지워짐)
		// 배열 인덱스 0은 min을 의미합니다. (Relative Indexing)
		boolean[] check = new boolean[(int) (max - min + 1)];

		// 2의 제곱수(4)부터 시작해서 max보다 작은 제곱수까지만 반복
		for (long i = 2; i * i <= max; i++) {
			long square = i * i; // 제곱수 (4, 9, 16...)

			// [핵심 로직] Start 지점 구하기
			// min보다 크거나 같은 첫 번째 배수를 찾습니다.
			long start = min / square;
			if (min % square != 0) {
				start++; // 딱 나누어 떨어지지 않으면 몫을 1 증가시켜서 다음 배수로 이동
			}
			start = start * square; // 실제 배수 값(ex: 12)으로 변환

			// [에라토스테네스의 체]
			// start부터 시작해서 square(제곱수)만큼 점프하며 지우기
			for (long j = start; j <= max; j += square) {
				// [핵심] 배열 인덱스는 (현재숫자 - min)으로 접근해야 함
				check[(int) (j - min)] = true;
			}
		}

		// false로 남아있는(지워지지 않은) 개수 세기
		int count = 0;
		for (int i = 0; i < check.length; i++) {
			if (!check[i]) {
				count++;
			}
		}

		System.out.println(count);
	}
}