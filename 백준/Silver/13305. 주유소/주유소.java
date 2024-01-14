import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 도시 개수 n
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 도로 길이 배열 kmArr
        int[] kmArr = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < kmArr.length; i++) {
            kmArr[i] = Integer.parseInt(st.nextToken());
        }

        // 주유소 배열 stations (마지막 입력값은 저장X)
        int[] stations = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < stations.length; i++) {
            stations[i] = Integer.parseInt(st.nextToken());
        }

        // 정답 answer = 0
        int answer = 0;

        // 첫 번째 주유소에서 kmArr[0] 만큼 주유
        answer += stations[0] * kmArr[0];

        // for (i=1~n-1)
            // if i+1 >= n-1
                // answer += stations[i] * kmArr[i]
                // 탈출
            // if stations[i] < stations[i+1]
                // answer += stations[i] * (kmArr[i] + kmArr[i+1])
                // i++
            // else
                // answer += stations[i] * kmArr[i]
        for (int i = 1; i < n - 1; i++) {
            if (i + 1 >= n - 1) {
                answer += stations[i] * kmArr[i];
                break;
            }
            if (stations[i] < stations[i + 1]) {
                answer += stations[i] * (kmArr[i] + kmArr[i + 1]);
                i++;
            } else {
                answer += stations[i] * kmArr[i];
            }
        }

        System.out.println(answer);
    }
}