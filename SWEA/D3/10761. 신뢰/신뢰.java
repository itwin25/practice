import java.io.FileInputStream;
import java.util.Scanner;
 
class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            String[][] button = new String[N][2]; // 눌러야하는 버튼 정보
            int min = 0; // 최소 시간
            int ob = 0; // 오렌지가 버튼 누른 횟수
            int bb = 0; // 블루가 버튼 누른 횟수
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 2; j++) {
                    button[i][j] = sc.next();
                }
            }
 
            // 각 로봇들의 초기 위치
            int orange = 1;
            int blue = 1;
            int i = 0;
            while (!button[N - 1][0].equals("X")) {
                // 오렌지~
                if (button[i][0].equals("O")) {
                    if (Integer.parseInt(button[i][1]) > orange) {
                        orange++;
                    } else if (Integer.parseInt(button[i][1]) < orange) {
                        orange--;
                    } else { // 같으면
                        if (i - 1 < 0 || button[i - 1][0].equals("X")) {
                            ob++; // 버튼 누름
                            button[i][0] = "X"; // 순서가 지나갔다는 표시
                        }
                    }
 
                    // 오렌지 차례지만 블루도 뭔가 해야지
                    for (int j = i + 1; j < N; j++) {
                        if (button[j][0].equals("B")) {
                            if (Integer.parseInt(button[j][1]) > blue) {
                                blue++;
                            } else if (Integer.parseInt(button[j][1]) < blue) {
                                blue--;
                            }
                            break;
                        }
                    }
                }
 
                // 블루~
                if (button[i][0].equals("B")) {
                    if (Integer.parseInt(button[i][1]) > blue) {
                        blue++;
                    } else if (Integer.parseInt(button[i][1]) < blue) {
                        blue--;
                    } else { // 같으면
                        if (i - 1 < 0 || button[i - 1][0].equals("X")) {
                            bb++; // 버튼 누름
                            button[i][0] = "X"; // 순서가 지나갔다는 표시
                        }
                    }
 
                    // 블루 차례지만 오렌지도 뭔가 해야지
                    for (int j = i + 1; j < N; j++) {
                        if (button[j][0].equals("O")) {
                            if (Integer.parseInt(button[j][1]) > orange) {
                                orange++;
                            } else if (Integer.parseInt(button[j][1]) < orange) {
                                orange--;
                            }
                            break;
                        }
                    }
                }
                if (button[i][0].equals("X")) {
                    i++;
                }
                min++; // + 1초
            }
 
            System.out.println("#" + test_case + " " + min);
        }
 
    }
}