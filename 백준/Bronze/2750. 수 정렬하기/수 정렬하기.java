import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 배열의 크기

        // 배열 생성 및 초기화
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bubbleSort(arr);

        for (int i = 1; i <= n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 1; i <= arr.length; i++) { // 정렬할 루프 범위 설정
            boolean isSwap = false; // 루프 안에서 swap 연산이 수행되었는지 판단하는 변수
            for (int j = 1; j <= arr.length - 1 - i; j++) { // 서로 인접한 두 데이터의 크기를 비교해 swap 연산 수행
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwap = true; // swap 연산이 수행되었음
                }
            }
            if (!isSwap) { // swap 연산이 한 번도 수행되지 않은 경우 정렬 종료
                return;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}