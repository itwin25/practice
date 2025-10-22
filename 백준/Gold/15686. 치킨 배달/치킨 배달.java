import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static int[][] city;
	static List<int[]> store, house;
	static List<Integer> curr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 변수 초기화
		N = Integer.parseInt(st.nextToken()); // 도시의 가로 세로 길이
		M = Integer.parseInt(st.nextToken()); // 최대 치킨집의 개수
		city = new int[N][N]; // 도시 정보
		store = new ArrayList<>(); // 치킨집 위치 정보
		house = new ArrayList<>(); // 집 위치 정보

		// 도시 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				city[i][j] = tmp;

				if (tmp == 1) {
					house.add(new int[] { i, j });
				} else if (tmp == 2) {
					store.add(new int[] { i, j });
				}
			}
		}

		ans = 987654321; // 도시의 최소 치킨 거리 초기화

		curr = new ArrayList<>();

		// 치킨집 조합 찾기
		for (int i = 1; i <= M; i++) {
			dfs(0, 0, i);
		}

		System.out.println(ans);

	}

	// depth : 자릿수, start : 시작 숫자, size : 뽑으려는 개수
	private static void dfs(int depth, int start, int size) {
		if (depth == size) {
			int sum = 0; // curr 조합에서의 최소거리 저장용
			for (int i = 0; i < house.size(); i++) {
				int tmp = 987654321; // 가게-집 최소거리 계산용
				for (int j = 0; j < size; j++) {
					tmp = Math.min(tmp, dist(store.get(curr.get(j)), house.get(i)));
				}
				sum += tmp;
			}
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = start; i < store.size(); i++) {
			curr.add(i);
			dfs(depth + 1, i + 1, size);
			curr.remove(curr.size() - 1);
		}
	}

	// 거리 계산
	// sp: 치킨집 좌표, hp: 집 좌표
	static int dist(int[] sp, int[] hp) {
		return Math.abs(sp[0] - hp[0]) + Math.abs(sp[1] - hp[1]);
	}

}
