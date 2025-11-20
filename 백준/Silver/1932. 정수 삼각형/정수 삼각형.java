import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] tri = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 최대값 찾기
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				// 왼쪽 끝 값이면, 윗 줄의 오른쪽 값 가져오기
				if (j == 0) {
					tri[i][j] = tri[i][j] + tri[i - 1][j];
				}
				// 오른쪽 끝 값이면, 윗 줄의 왼쪽 값 가져오기
				else if (j == i) {
					tri[i][j] = tri[i][j] + tri[i - 1][j - 1];
				}
				// 중앙 값이면, 둘 중에 큰 값 가져오기
				else {
					tri[i][j] = tri[i][j] + Math.max(tri[i - 1][j - 1], tri[i - 1][j]);
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, tri[n - 1][i]);
		}

		System.out.println(ans);

	}
}