import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[] arr, tmp;

    public static void main(String[] args) throws IOException {
        // 수의 개수 n 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        // 배열 생성
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 임시 배열 선언
        tmp = new int[n];

        // 병합 정렬(1, n)
        mergeSort(0, n - 1);

        // 결괏값 출력
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
    }

    private static void mergeSort(int start, int end) {
        // if end-start < 1 : 종료
        if (end - start < 1) { // 요소가 하나밖에 없을 때 종료
            return;
        }

        // 중간점 mid 초기화
        int mid = (start + end) / 2;

        // 병합 정렬(start, mid)
        mergeSort(start, mid);

        // 병합 정렬(mid+1, end)
        mergeSort(mid + 1, end);

        // for (s~e)
        for (int i = start; i <= end; i++) {
            // tmp 배열에 저장
            tmp[i] = arr[i];
        }

        // 첫 번째 그룹 시작점
        int index1 = start;
        // 두 번째 그룹 시작점
        int index2 = mid + 1;

        // while (index1 <= mid && index2 <= end)
        while (index1 <= mid && index2 <= end) {
            // 두 그룹의 index가 가리키는 값을 비교해 더 작은 값을 배열 arr에 저장
            if (tmp[index1] < tmp[index2]) {
                arr[start] = tmp[index1];
                start++;
                // 선택된 값의 index++
                index1++;
            } else {
                arr[start] = arr[index2];
                start++;
                index2++;
            }
        }

        // 양쪽 그룹에 남아 있는 데이터 정리
        while (index1 <= mid) {
            arr[start] = tmp[index1];
            start++;
            index1++;
        }
        while (index2 <= end) {
            arr[start] = tmp[index2];
            start++;
            index2++;
        }
    }
}