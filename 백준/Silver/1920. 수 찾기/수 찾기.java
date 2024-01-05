import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int findNumber = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = arr.length - 1;
            System.out.println(search(start, end, findNumber));
        }
    }

    private static int search(int start, int end, int findNumber) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (findNumber > arr[mid]) {
                start = mid + 1;
            }
            if (findNumber < arr[mid]) {
                end = mid - 1;
            }
            if (findNumber == arr[mid]) {
                return 1;
            }
        }
        return 0;
    }
}