import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 농장의 크기
			sc.nextLine(); // 남아있는 \n 청소해주기
			int[][] farm = new int[N][N];
			int ans = 0; // 얻을 수 있는 수익

			// 배열에 값 넣기
			for (int i = 0; i < N; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = Character.getNumericValue(s.charAt(j));
				}
			}

			// 마름모 구하기 (맨해튼 거리)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (Math.abs(i - (N / 2)) + Math.abs(j - (N / 2)) <= N / 2) {
						ans += farm[i][j];
					}
				}
			}

			System.out.println("#" + test_case + " " + ans);
		} // tc
	}
}