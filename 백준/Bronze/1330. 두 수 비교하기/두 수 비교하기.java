import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);

		// 정수 A, B
		int A = sc.nextInt(), B = sc.nextInt();

		String output;
		// 로직
		// 정수 A, B에 대한 대소 비교
		if (A > B) {
			output = ">";
		}

		else if (A < B) {
			output = "<";
		}

		else {
			output = "==";
		}
		
		// 삼항연산자.. 지양
//		output = (A > B) ? ">" : ((A < B) ? "<" : "==");

		// 출력 output 문자열: "<", ">", "=="
		System.out.println(output);
	}
}
