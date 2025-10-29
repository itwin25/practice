import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] choice;
	static int team;
	static boolean[] isOk, visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 학생 수
			choice = new int[N + 1]; // 선택된 학생들의 번호

			// 선택된 학생들 번호 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				choice[i] = Integer.parseInt(st.nextToken());
			}

			team = 0; // 팀을 이룬 학생들의 수
			isOk = new boolean[N + 1]; // 팀을 이뤘는지 아닌지
			visited = new boolean[N + 1]; // 이번에 방문했는지 체크

			// 자기 자신을 선택한 경우
			for (int i = 1; i <= N; i++) {
				if (choice[i] == i) {
					isOk[i] = true;
					team++; // 팀 1 증가
					continue;
				}
			}

			for (int i = 1; i <= N; i++) {
				// 팀 구성이 안 된 경우
				if (!isOk[i]) {
					find(i);
				}
			}

			System.out.println(N - team);

		}

	}

	private static void find(int num) {
		visited[num] = true; // 방문 표시

		int next = choice[num]; // 이번 학생이 선택한 학생
		if (!isOk[next]) {
			// 방문한적 있는 학생이면 -> 순환 있음
			if (visited[next]) {
				int cnt = 0; // 팀원 수 저장
				int next2 = next;
				do {
					cnt++; // 팀원 증가
					next2 = choice[next2];
				} while (next2 != next); // next로 돌아올 때까지 반복

				team += cnt; // 팀 변수에 팀원만큼 더하기

				// 이번에 처음 방문하면
			} else {
				find(next); // 다음 선택 학생 방문
			}
		}

		visited[num] = false;
		isOk[num] = true; // 탐색 완료

	}

}
