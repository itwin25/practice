import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int min = 999;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 구슬 발사 횟수
			int W = sc.nextInt(); // width
			int H = sc.nextInt(); // height
			int[][] map = new int[H][W]; // 맵

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			min = 999;
			hit(0, N, map, W, H);
			System.out.println("#" + test_case + " " + min);

		} // tc
	} // main

	// 구슬 쏘기
	// cnt: 현재 발사 횟수
	static void hit(int cnt, int N, int[][] map, int W, int H) {
		if (min == 0) {
			return; // 이미 최상의 결과를 찾았으면 끝
		}
		if (cnt == N) { // 모든 발사가 끝났으면 남은 블록 개수 세기
			int blocks = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] > 0) {
						blocks++;
					}
				}
			}
			if (blocks < min) {
				min = blocks;
			}
			return;
		} else { // 발사 횟수가 남았으면 발사
			int[][] new_map = new int[H][W];
			for (int i = 0; i < W; i++) { // 각 열마다 구슬 발사해보기
				// 여러 번의 시도를 위해 map 복사본 만들기
				for (int x = 0; x < H; x++) {
					for (int j = 0; j < W; j++) {
						new_map[x][j] = map[x][j];
					}
				}
				for (int j = 0; j < H; j++) {
					if (new_map[j][i] > 0) {
						List<int[]> explosion = new LinkedList<>(); // 폭발 정보 저장
						explosion.add(new int[] { j, i, new_map[j][i] }); // 첫 위치, 폭발력 정보

						// 폭발 정보 리스트가 비어있을 때 까지 반복
						while (explosion.size() > 0) {
							int[] now = explosion.remove(0); // 맨 앞 요소 꺼내기
							new_map[now[0]][now[1]] = 0; // 폭발 근원지 0
							// 펑~
							for (int d = 1; d <= now[2] - 1; d++) { // 폭발 범위만큼
								for (int k = 0; k < 4; k++) {
									int nr = now[0] + dr[k] * d;
									int nc = now[1] + dc[k] * d;
									if (nr < H && nr >= 0 && nc < W && nc >= 0) {
										if (new_map[nr][nc] == 1) {
											new_map[nr][nc] = 0; // 위력이 1이면 그 자리만 0
										} else if (new_map[nr][nc] > 1) {
											explosion.add(new int[] { nr, nc, new_map[nr][nc] }); // 연쇄 폭발을 위한 정보 담기
										}
									}
								}
							}
						}

						// 중력 적용
						for (int col = 0; col < W; col++) {
							List<Integer> survivors = new ArrayList<>();
							// 1. 남은 벽돌을 위에서부터 순서대로 모은다.
							for (int row = 0; row < H; row++) {
								if (new_map[row][col] > 0) {
									survivors.add(new_map[row][col]);
									new_map[row][col] = 0;
								}
							}

							// 2. 남은 벽돌들을 가장 아래부터 순서대로 다시 쌓는다.
							int rowToFill = H - 1;
							for (int p = survivors.size() - 1; p >= 0; p--) {
								new_map[rowToFill][col] = survivors.get(p);
								rowToFill--;
							}
						}
						break; // 중력 적용까지 끝나면 다음 열로 이동
					}
				}
				hit(cnt + 1, N, new_map, W, H);
			}
		}
	}
}
