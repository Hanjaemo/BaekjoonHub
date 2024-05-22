import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int start = Integer.MAX_VALUE;
        int end = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[l] = h;
            start = Math.min(start, l);
            end = Math.max(end, l);
        }

        Deque<Integer> stack = new ArrayDeque<>();

        int max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < max) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    int popped = stack.pop();
                    arr[popped] = max;
                }
                max = arr[i];
            }
        }
        stack.clear();

        max = arr[end];
        for (int i = end - 1; i >= start; i--) {
            if (arr[i] < max) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    int popped = stack.pop();
                    arr[popped] = max;
                }
                max = arr[i];
            }
        }

        int answer = 0;
        for (int i = start; i <= end; i++) {
            answer += arr[i];
        }

        System.out.println(answer);
    }
}
