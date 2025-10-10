import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서의 개수
			int idx = Integer.parseInt(st.nextToken()); // 궁금한 문서의 초기 인덱스

			Queue<int[]> printer = new LinkedList<>(); // [초기 인덱스, 중요도]

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken()); // 중요도
				printer.offer(new int[] { i, tmp });
			}

			int cnt = 0;

			while (true) {
				boolean isOk = true;
				int[] curr = printer.poll(); // 맨 앞에 하나 뽑기

				// curr보다 큰 값이 있나?
				for (int[] num : printer) {
					if (num[1] > curr[1]) {
						isOk = false;
						break;
					}
				}

				if (isOk) {
					cnt++; // 하나 프린트

					// 근데 그게 찾고자 하는 문서였다면?
					if (curr[0] == idx) {
						break;
					}

				} else {
					printer.offer(curr);
				}
			}

			System.out.println(cnt);

		}

	}
}
