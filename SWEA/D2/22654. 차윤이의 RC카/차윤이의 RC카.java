import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N, Q;
	static char[][] map;
	static int sR, sC, eR, eC;
	static List<Character>[] cmd;
	static List<Integer> result;

	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌 (0,1,2,3)
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine()); // 필드의 크기
			map = new char[N][N]; // 필드

			// 필드 정보 입력
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					char tmp = s.charAt(j);
					map[i][j] = tmp;
					// 출발 지점 찾기
					if (tmp == 'X') {
						sR = i;
						sC = j;
					}
					// 도착 지점 찾기
					if (tmp == 'Y') {
						eR = i;
						eC = j;
					}
				}
			}

			// 조종 관련 정보
			Q = Integer.parseInt(br.readLine()); // 조종을 한 횟수
			cmd = new ArrayList[Q]; // 각 커맨드를 저장할 곳
			for (int i = 0; i < Q; i++) {
				cmd[i] = new ArrayList<>();
			}

			// 커맨드 저장
			for (int i = 0; i < Q; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int C = Integer.parseInt(st.nextToken());
				String s = st.nextToken();
				for (int j = 0; j < C; j++) {
					cmd[i].add(s.charAt(j));
				}
			}

			result = new ArrayList<>();

			// 커맨드 따라서 움직이기
			for (List<Character> cmdList : cmd) {
				RcCar(sR, sC, cmdList);
			}

			// 결과 출력
			System.out.print("#" + test_case + " ");
			List<String> strList = new ArrayList<>();
			for (int num : result) {
				strList.add(String.valueOf(num));
			}
			System.out.println(String.join(" ", strList));

		} // tc
	} // main

	static void RcCar(int sR, int sC, List<Character> cmdList) {
		int dir = 0; // 현재 바라보고 있는 곳 (초기 : 상)
		// 초기 위치
		int nr = sR;
		int nc = sC;
		for (int i = 0; i < cmdList.size(); i++) {
			char ch = cmdList.get(i); // 이번에 할 동작
			// 직진
			if (ch == 'A') {
				int tmpR = nr + dr[dir];
				int tmpC = nc + dc[dir];
				// 직진 커맨드인데 나무가 있으면? 직진하지 말고 그냥 가만히 있기
				if (tmpR >= 0 && tmpR < N && tmpC >= 0 && tmpC < N && map[tmpR][tmpC] != 'T') {
					nr += dr[dir];
					nc += dc[dir];
				}
			}
			// 좌회전(델타배열 왼쪽으로 1 이동)
			else if (ch == 'L') {
				dir = (dir - 1 + 4) % 4;
			}
			// 우회전(델타배열 오른쪽으로 1 이동)
			else {
				dir = (dir + 1) % 4;
			}
		}

		// 목표 지점에 도달했나?
		if (nr == eR && nc == eC) {
			result.add(1);
		} else {
			result.add(0);
		}
	}
}