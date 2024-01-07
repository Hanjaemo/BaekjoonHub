import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 t 입력
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            // 수첩 1에 적은 숫자의 개수 n 입력
            int n = Integer.parseInt(br.readLine());

            // 수첩 1에 적은 정수 입력 후 배열 arr 생성
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            // 수첩 2에 적은 숫자의 개수 m 입력
            int m = Integer.parseInt(br.readLine());

            // 수첩 2에 적은 정수 입력 후 배열 checkArr 생성
            int[] checkArr = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                checkArr[j] = Integer.parseInt(st.nextToken());
            }

            // 일치 여부에 따라 1 또는 0을 저장할 배열 counts 생성
            int[] counts = new int[m];

            // 이진 탐색
            Arrays.sort(arr);
            for (int j = 0; j < m; j++) {
                int start = 0;
                int end = arr.length - 1;
                int key = checkArr[j];
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (arr[mid] < key) {
                        start = mid + 1;
                    }
                    if (arr[mid] > key) {
                        end = mid - 1;
                    }
                    if (arr[mid] == key) {
                        counts[j]++;
                        break;
                    }
                }
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int hasCard : counts) {
                bw.write(hasCard + "\n");
            }
            bw.flush();
        }
    }
}