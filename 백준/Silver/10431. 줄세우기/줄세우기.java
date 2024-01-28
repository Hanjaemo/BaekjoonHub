import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 테스트케이스 개수 testCase
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        // for (testCase만큼 반복)
            // 크기가 20인 학생들의 키를 저장하는 arr 생성
            // 학생들의 키를 arr에 저장
            // 학생들이 뒤로 물러난 횟수 count
            // for (i=0~19)
                // if i == 0 : continue
                // for (j=i-1~0)
                    // if arr[i] < arr[j]
                        // i번째 요소와 j번째 요소 위치 변경
                        // count++
        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[20];
            int order = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for (int i = 0; i < 20; i++) {
                if (i == 0) {
                    continue;
                }
                int cur = arr[i];
                for (int j = i - 1; j >= 0; j--) {
                    if (cur < arr[j]) {
                        int tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                        count++;
                    }
                }
            }
            System.out.println(t + " " + count);
        }
    }
}