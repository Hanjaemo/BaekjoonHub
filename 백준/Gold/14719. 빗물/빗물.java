import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        // 왼 -> 오
        int base = arr[0];
        for (int i = 1; i < w; i++) {
            if (base >= arr[i]) {
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty()) {
                    int popped = stack.pop();
                    answer += base - popped;
                }
                base = arr[i];
            }
        }

        stack.clear();

        // 오 -> 왼
        base = arr[w - 1];
        for (int i = w-2; i >= 0; i--) {
            if (base > arr[i]) {
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty()) {
                    int popped = stack.pop();
                    answer += base - popped;
                }
                base = arr[i];
            }
        }

        System.out.println(answer);
    }
}