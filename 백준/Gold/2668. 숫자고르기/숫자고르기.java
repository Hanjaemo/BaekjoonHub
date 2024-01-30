import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int to = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int to = Integer.parseInt(br.readLine());
            arr[i] = to;
        }

        visited = new boolean[n + 1];
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            dfs(i);
            if (i == to) {
                result.add(i);
            }
            to = 0;
            visited = new boolean[n + 1];
        }

        System.out.println(result.size());
        Collections.sort(result);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static void dfs(int node) {
        if (visited[node]) {
            to = node;
            return;
        }

        visited[node] = true;
        to = node;
        dfs(arr[node]);
    }
}