import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] building = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            building[i] = Integer.parseInt(st.nextToken());
        }

        int maxCount = 0;

        // i번째 빌딩을 기준으로 확인
        for(int i = 0; i < n; i++) {
            int count = 0;

            // 1. 왼쪽 탐색 (i-1 부터 0까지 역순으로)
            double minSlope = 10000000000.0; // 아주 큰 값으로 초기화

            for(int j = i - 1; j >= 0; j--) {
                // 기울기 계산: (높이차) / (거리차)
                double slope = (double)(building[i] - building[j]) / (i - j);

                if(slope < minSlope) { // 기울기가 더 작아지면 보임
                    count++;
                    minSlope = slope; // 최소 기울기 갱신
                }
            }

            // 2. 오른쪽 탐색 (i+1 부터 n-1까지)
            double maxSlope = -10000000000.0; // 아주 작은 값으로 초기화

            for(int j = i + 1; j < n; j++) {
                double slope = (double)(building[i] - building[j]) / (i - j);

                if(slope > maxSlope) { // 기울기가 더 커지면 보임
                    count++;
                    maxSlope = slope; // 최대 기울기 갱신
                }
            }

            // 정답 갱신
            if(count > maxCount) {
                maxCount = count;
            }
        }

        System.out.println(maxCount);
    }
}