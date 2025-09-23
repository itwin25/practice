import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 점의 개수

		int[][] dots = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				dots[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.sort(dots, (a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			} else {
				return a[1] - b[1];
			}
		});

		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				ans.append(dots[i][j]).append(" ");
			}
			ans.append("\n");
		}

		System.out.println(ans.toString());

	}
}
