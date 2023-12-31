import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 수의 개수(n) 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 배열 생성 및 정렬
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // for (k를 0부터 n번 반복)
            // while (i < j)
                // if (arr[i] + arr[j] > arr[k]) : j 감소
                // if (arr[i] + arr[j] < arr[k]) : i 증가
                // if (arr[i] + arr[j] == arr[k]) : count 증가, i 증가, j 감소, 종료
        int count = 0;
        for (int k = 0; k < n; k++) {
            int i = 0;
            int j = n - 1;
            while (i < j) {
                 if (arr[i] + arr[j] > arr[k]) {
                     j--;
                     continue;
                 }
                 if (arr[i] + arr[j] < arr[k]) {
                     i++;
                     continue;
                 }
                 if (arr[i] + arr[j] == arr[k]) {
                     if (i != k && j != k) {
                         count++;
                         break;
                     } else if (i == k) {
                         i++;
                     } else {
                         j--;
                     }
                 }
            }
        }

        // count 출력
        System.out.println(count);
    }
}