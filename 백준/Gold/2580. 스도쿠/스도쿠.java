import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] sudoku;
	static List<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sudoku = new int[9][9];
		list = new ArrayList<>();

		// 스도쿠 판 입력받기
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				sudoku[i][j] = num;
				// 0인 곳 찾아서 기록해두기
				if (num == 0) {
					list.add(new int[] { i, j });
				}
			}
		}

		find(0);

	}

	// 0인 칸들만 확인
	private static void find(int idx) {
		// 다 채웠으면 종료
		if (idx == list.size()) {

			// 출력
			StringBuilder ans = new StringBuilder();

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					ans.append(sudoku[i][j]).append(" ");
				}
				ans.append("\n");
			}

			System.out.println(ans);

			// 종료
			System.exit(0);
		}

		int[] curr = list.get(idx);

		int nr = curr[0];
		int nc = curr[1];

		for (int i = 1; i <= 9; i++) {
			boolean isOk = false; // 가능한 숫자인가?
			if (cross(nr, nc, i) && square(nr, nc, i)) {
				isOk = true;
			}

			// 가능하면 해당 숫자로 채우기
			if (isOk) {
				sudoku[nr][nc] = i;
				find(idx + 1); // 다음 빈칸으로 이동
				sudoku[nr][nc] = 0;
			}

		}
	}

	// 가로세로
	static boolean cross(int r, int c, int num) {
		// 가로 확인
		for (int i = 0; i < 9; i++) {
			if (sudoku[r][i] == num) {
				return false;
			}
		}

		// 세로 확인
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][c] == num) {
				return false;
			}
		}

		return true;
	}

	// 3x3 정사각형
	static boolean square(int r, int c, int num) {

		int st = (r / 3) * 3; // 시작 행
		int sc = (c / 3) * 3; // 시작 열

		// 3x3 범위 안에 동일한 숫자가 있는지 확인
		for (int i = st; i < st + 3; i++) {
			for (int j = sc; j < sc + 3; j++) {
				if (sudoku[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}

}
