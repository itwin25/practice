import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 회의 개수
		int[][] schedule = new int[N][2]; // 회의 정보

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				schedule[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 끝나는 시간 기준으로 정렬
		// 끝나는 시간이 같다면 시작 시간 기준으로 정렬
		Arrays.sort(schedule, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});

		int end = schedule[0][1]; // 가장 빨리 끝나는 회의의 끝나는 시간
		int ans = 1; // 회의 수 카운트

		for (int i = 1; i < N; i++) {
			if (schedule[i][0] >= end) {
				end = schedule[i][1]; // 새롭게 끝나는 시간
				ans++;
			}
		}

		System.out.println(ans);
	}
}