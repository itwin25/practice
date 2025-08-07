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

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			boolean isOk = true; // 확인용
			int length = sc.nextInt(); // tc 길이
			String brackets = sc.next(); // tc
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < length; i++) {
				// 여는 괄호면 스택에 넣기
				if (brackets.charAt(i) == '(' || brackets.charAt(i) == '<' || brackets.charAt(i) == '{' || brackets.charAt(i) == '[') {
					stack.push(brackets.charAt(i));
				}
				// 닫는 괄호면..
				else {
					if (stack.isEmpty()) {
						isOk = false;
						break;
					} else {
						if (brackets.charAt(i) == ')') {
							if (stack.pop() != '(') { // 짝이 안 맞으면 break
								isOk = false;
								break;
							}
						} else if (brackets.charAt(i) == '>') {
							if (stack.pop() != '<') {
								isOk = false;
								break;
							}
						} else if (brackets.charAt(i) == '}') {
							if (stack.pop() != '{') {
								isOk = false;
								break;
							}
						} else {
							if (stack.pop() != '[') {
								isOk = false;
								break;
							}
						}
					}
				}

			} // 검사 결과
			if (isOk && stack.isEmpty()) {
				System.out.println("#" + test_case + " " + "1");
			} else {
				System.out.println("#" + test_case + " " + "0");
			}
		}
	}
}