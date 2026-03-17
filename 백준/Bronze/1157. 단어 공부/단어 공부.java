import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine(); // 단어
        int[] alphabet = new int[26]; // 알파벳 배열

        word = word.toUpperCase(); // 대문자로 변환

        // 알파벳 개수 세기
        for (int i = 0; i < word.length(); i++) {
            alphabet[word.charAt(i) - 'A']++;
        }

        int max = 0; // 최댓값
        char ans = ' '; // 답

        // 빈출 알파벳 찾기
        for (int i = 0; i < 26; i++){
            // 지금 알파벳이 더 많으면
            if (alphabet[i] > max){
                max = alphabet[i];
                ans = (char)(i + 'A');
            } else if (alphabet[i] == max){ // 최대 빈출 알파벳이 또 있으면
                ans = '?';
            }
        }

        System.out.println(ans);
    }
}
