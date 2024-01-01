import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 데이터 개수 n, 찾을 숫자의 위치 k 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 배열 생성
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 퀵정렬
        quickSort(arr, 0, arr.length - 1);
        
        // 결괏값 출력
        System.out.println(arr[k - 1]);
    }

    private static void quickSort(int[] arr, int start, int end) {
        // 2개의 집합을 나눌 기준점 구하기
        int part = partition(arr, start, end);
        
        // 기준점의 전과 후로 집합을 나누어 정렬
        if (start < part - 1) {
            quickSort(arr, start, part - 1);
        }
        if (part < end) {
            quickSort(arr, part, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        // 기준점 pivot 설정 (시작점과 끝점의 중간점)
        int pivot = arr[(start + end) / 2];
        
        // while (start 포인트와 end 포인트가 어긋날 때까지 반복)
        while (start <= end) {
            // while (start 위치의 요소가 pivot보다 클 때까지 반복)
            while (arr[start] < pivot) {
                // start 증가
                start++;
            }
            // while (end 위치의 요소가 pivot보다 작을 때까지 반복)
            while (arr[end] > pivot) {
                // end 감소
                end--;
            }
            
            // if start <= end : swap(arr, start, end) start++, end-- 
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        // start 반환
        return start;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}