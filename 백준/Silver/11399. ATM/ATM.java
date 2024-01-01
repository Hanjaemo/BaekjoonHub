import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 사람 수 n 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 인출 시간을 입력 받아 배열 생성
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // for (i를 1부터 n까지 반복)
            // for (j를 0부터 i까지 반복)
                // arr[i]를 삽입할 위치 탐색
            // for (k를 삽입할 위치부터 i까지 반복)
                // 각 요소를 오른쪽으로 shift
            // arr[i] 삽입
        for (int i = 1; i < n; i++) {
            int selectIdx = i;
            int selectVal = arr[i];
            for (int j = 0; j < selectIdx; j++) {
                if (arr[selectIdx] >= arr[j]) {
                    continue;
                }
                if (arr[selectIdx] < arr[j]) {
                    selectIdx = j;
                }
            }
            for (int j = i - 1; j >= selectIdx; j--) {
                arr[j + 1] = arr[j];
            }
            arr[selectIdx] = selectVal;
        }

        // 합 배열 생성
        int[] sumArr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i - 1];
        }

        // 합 배열 요소 총합 계산 및 출력
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += sumArr[i];
        }
        System.out.println(result);
    }
}