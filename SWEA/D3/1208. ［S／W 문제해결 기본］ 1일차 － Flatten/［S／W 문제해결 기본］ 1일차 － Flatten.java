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

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int dump = sc.nextInt(); // 최대 덤프 횟수
			int[] arr = new int[100]; // 상자 갯수 담을 곳
			int min = 100, minIdx = 0;
			int max = 0, maxIdx = 0;
			int ans = 0;
			int cnt = 0;

			// 배열 생성
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}

			// Flatten
			while (cnt < dump) {
				// max, min 초기화
				max = 0;
				min = 100;

				// 최대, 최소 값과 인덱스 찾기
				for (int i = 0; i < 100; i++) {
					if (arr[i] > max) {
						max = arr[i];
						maxIdx = i;
					}
					if (arr[i] < min) {
						min = arr[i];
						minIdx = i;
					}
				}

				// 평탄화가 됐는지 확인
				if (max - min > 1) {
					arr[maxIdx]--;
					arr[minIdx]++;

				} else {
					break;
				}
				cnt++; // 현재 덤프 횟수

			}
            max = 0;
			min = 100;
            
			// 덤프가 끝난 후 최종 배열의 최대, 최소 찾기
			for (int i = 0; i < 100; i++) {
				if (arr[i] > max) {
					max = arr[i];
				}
				if (arr[i] < min) {
					min = arr[i];
				}

			}
			System.out.println("#" + test_case + " " + (max - min));
		}
	}
}