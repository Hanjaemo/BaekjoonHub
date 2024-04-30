import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        Solution solution = new Solution();
//        int answer = solution.solve(new int[]{124763021,2147483647,1, 9826478, 73425, 62314, 42867, 39748, 2, 5, 3, 7, 10});
//        System.out.println(answer);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[2];

        int min = Math.abs(arr[0] + arr[n - 1]);
        answer[0] = arr[0];
        answer[1] = arr[n - 1];
        int s = 0;
        int e = n - 1;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer[0] = arr[s];
                answer[1] = arr[e];
            }
            if (sum == 0) {
                break;
            }
            if (sum > 0) {
                e--;
            } else {
                s++;
            }
        }

        for (int a : answer) {
            System.out.print(a + " ");
        }
    }
}