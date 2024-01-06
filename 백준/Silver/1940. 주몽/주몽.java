import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 재료 개수 n 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 갑옷을 만드는 데 필요한 번호의 합 m 입력
        int m = Integer.parseInt(br.readLine());

        // 크기가 n인 배열 arr 생성
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬
        Arrays.sort(arr);

        // 시작점 s = 0
        // 끝점 e = n-1
        int s = 0;
        int e = n - 1;

        // cnt = 0
        int cnt = 0;
        // while (s <= e)
            // if arr[s] + arr[e] < m : s++
            // if arr[s] + arr[e] > m : e--
            // if arr[s] + arr[e] == m : cnt++, s++, e--
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (sum < m) {
                s++;
            }
            if (sum > m) {
                e--;
            }
            if (sum == m) {
                cnt++;
                s++;
                e--;
            }
        }

        System.out.println(cnt);
    }
}