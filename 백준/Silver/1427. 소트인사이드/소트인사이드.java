import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 정렬할 수 n 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        // for (i를 0부터 n까지 반복)
            // for (j를 i부터 n까지 반복)
                // 남은 정렬 부분에서 최댓값 선택
            // 가장 앞에 있는 값과 최댓값을 비교해 조건을 만족하면 swap
        for (int i = 0; i < arr.length; i++) {
            int maxIdx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (arr[i] < arr[maxIdx]) {
                int tmp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = tmp;
            }
        }

        // 결과 출력
        for (int i : arr) {
            System.out.print(i);
        }
    }
}