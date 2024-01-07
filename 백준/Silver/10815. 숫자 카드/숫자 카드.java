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

        // 카드 개수 n 입력
        int n = Integer.parseInt(br.readLine());

        // 숫자 카드에 적혀 있는 정수 입력 후 배열 arr 생성
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 확인할 카드 개수 m 입력
        int m = Integer.parseInt(br.readLine());

        // 확인할 카드 입력 후 배열 checkArr 생성
        int[] checkArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        // 가지고 있는 카드 배열 hasCards 생성
        int[] hasCards = new int[m];

        // 이진 탐색
        Arrays.sort(arr);
        for (int i = 0; i < m; i++) {
            int start = 0;
            int end = arr.length - 1;
            int key = checkArr[i];
            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] < key) {
                    start = mid + 1;
                }
                if (arr[mid] > key) {
                    end = mid - 1;
                }
                if (arr[mid] == key) {
                    hasCards[i]++;
                    break;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int hasCard : hasCards) {
            bw.write(hasCard + " ");
        }
        bw.close();
    }
}