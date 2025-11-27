import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 로프의 수
		int[] rope = new int[N]; // 각 로프의 중량

		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(rope); // 중량순으로 정렬

		int ans = 0;

		for (int i = 0; i < N; i++) {
			int nowWeight = rope[i]; // 현재 로프의 중량
			ans = Math.max(ans, nowWeight * (N - i)); // 현재 로프의 중량을 들 수 있는 로프들 개수 곱하기
		}

		System.out.println(ans);
	}
}