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
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for (int T = 0; T < 10; T++) {
			int tc = sc.nextInt();
			int l = 100;
			int nr = l - 1;
			int nc = 0;
			int[][] arr = new int[l][l];
			List<Integer> ladder = new ArrayList<>();

			// 사다리 정보 입력 받기
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < l; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < l; i++) {
				// 당첨인 열 정보 저장
				if (arr[nr][i] == 2) {
					nc = i;
				}

				// 사다리 있는 열 정보 저장
				if (arr[nr][i] == 1 || arr[nr][i] == 2) {
					ladder.add(i);
				}
			}

			// 시작 열 인덱스 정보 저장
			int idx = ladder.indexOf(nc);

			// 사다리 타기
			while (nr > 0) {

				// 좌측 확인
				if (nc - 1 >= 0 && arr[nr][nc - 1] == 1) {
					idx--;
					nc = ladder.get(idx); // 점프
				} else if (nc + 1 < l && arr[nr][nc + 1] == 1) { // 우측 확인
					idx++;
					nc = ladder.get(idx); // 점프
				}

				nr--; // 위로 1칸 이동
			}

			System.out.println("#" + tc + " " + nc);
		}
		sc.close();
	}
}