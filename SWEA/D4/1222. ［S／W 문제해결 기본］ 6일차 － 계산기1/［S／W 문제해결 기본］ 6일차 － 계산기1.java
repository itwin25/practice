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
import java.util.Stack;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int length = sc.nextInt();
			String infix = sc.next();
			Stack<Character> stack = new Stack<>();
			String postfix = "";

			// 후위 표기식으로 변환
			for (int i = 0; i < length; i++) {
				char tmp = infix.charAt(i);
				// 숫자 -> 출력
				if (tmp >= '0' && tmp <= '9') {
					postfix += tmp;
				}
				// + -> 스택에 넣고 하나씩 출력
				else {
					if (stack.isEmpty()) {
						stack.push(tmp);
					} else {
						postfix += stack.pop();
						stack.push(tmp);
					}
				}
			}
			postfix += stack.pop(); // 남은 거 출력

			//////////////////////////////////////////////////////////////////////////////

			Stack<Integer> calculate = new Stack<>();

			// postfix 이용해서 계산
			for (int i = 0; i < length; i++) {
				// 숫자 -> stack에 넣기
				char tmp2 = postfix.charAt(i);
				if (Character.isDigit(tmp2)) {
					calculate.push(Integer.parseInt(tmp2 + ""));
				}
				// + -> stack에서 2개 꺼내서 덧셈 계산하고 다시 넣기
				else {
					int a = calculate.pop();
					int b = calculate.pop();

					calculate.push(a + b);
				}
			}
			////////////////////////////////////////////////////////////////////////////////

			// 결과 출력
			System.out.println("#" + test_case + " " + calculate.pop());
		}
	}
}