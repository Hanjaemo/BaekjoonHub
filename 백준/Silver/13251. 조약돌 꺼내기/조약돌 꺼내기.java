import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 색상 종류 개수 m
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        // 배열 arr 생성
        int[] arr = new int[m];
        // 색상별 조약돌 개수를 입력 받아 배열 arr에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 뽑을 조약돌 개수 k
        int k = Integer.parseInt(br.readLine());

        // 조약돌 총 개수(arr의 총합) totalCount
        int totalCount = 0;
        for (int i = 0; i < m; i++) {
            totalCount += arr[i];
        }

        // 결과 result
        double result = 0;

        // for (i=0~m-1)
            // i번째 색상의 조약돌만 뽑을 확률 계산
            // result += 계산한 확률
        for (int i = 0; i < m; i++) {
            double percentage = 1.0;
            for (int j = 0; j < k; j++) {
                percentage *= ((double) (arr[i] - j) / (totalCount - j));
            }
            result += percentage;
        }

        // result 출력
        System.out.println(result);
    }
}