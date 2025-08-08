/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int cnt = 0; // 봉우리 수

			// 배열에 지도 담기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 주변 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean isPeak = true; // 봉우리인가..
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							if (arr[i][j] <= arr[nr][nc]) {
								isPeak = false;
							}
						}
					}
					if (isPeak) {
						cnt++;
					}
				}
			}

			System.out.println("#" + test_case + " " + cnt);
		}
	}
}