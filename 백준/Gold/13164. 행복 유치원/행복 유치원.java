import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        List<Integer> diffs = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            diffs.add(arr[i] - arr[i - 1]);
        }

        Collections.sort(diffs);

        int answer = 0;
        for (int i = 0; i < n - k; i++) {
            answer += diffs.get(i);
        }

        System.out.println(answer);
    }
}