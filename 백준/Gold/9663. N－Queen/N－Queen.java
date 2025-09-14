import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static boolean[] col, upwardDiag, downwardDiag;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		col = new boolean[N]; // 퀸이 놓인 열인가?
		upwardDiag = new boolean[2 * N - 1]; // (/) 대각선
		downwardDiag = new boolean[2 * N - 1]; // (\) 대각선

		ans = 0;
		Queen(0); // 시작 행

		System.out.println(ans);

	} // main

	private static void Queen(int row) {
		// 다 놓았으면 가능한 수 1 증가
		if (row == N) {
			ans++;
			return;
		}

		int nr = row;

		for (int i = 0; i < N; i++) {
			boolean isOk = true;
			int nc = i;

			// 1. 세로 (사용된 열인가?)
			if (col[nc] == true) {
				isOk = false;
			}

			// 2. 대각선
			if (upwardDiag[nr + nc] == true || downwardDiag[nr - nc + N - 1] == true) {
				isOk = false;
			}

			if (isOk) {
				// 사용됨
				col[nc] = true;
				upwardDiag[nr + nc] = true;
				downwardDiag[nr - nc + N - 1] = true;

				Queen(nr + 1); // 다음 행으로 이동

				// 다시 돌려놓기
				col[nc] = false;
				upwardDiag[nr + nc] = false;
				downwardDiag[nr - nc + N - 1] = false;
			}
		}
	}
}