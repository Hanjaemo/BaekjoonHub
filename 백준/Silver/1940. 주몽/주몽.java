import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 재료 개수(n), 갑옷 개수(m) 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 배열 생성 및 정렬
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // while (j < i)
            // if (arr[i] + arr[j] < m) : i++
            // if (arr[i] + arr[j] > m) : j--
            // if (arr[i] + arr[j] == m) : count++, i++, j--
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum < m) {
                i++;
                continue;
            }
            if (sum > m) {
                j--;
                continue;
            }
            count++;
            i++;
            j--;
        }

        // 만들 수 있는 갑옷 개수 출력
        System.out.println(count);
    }
}