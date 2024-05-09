import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dfs(n, m, 0, 1, new ArrayList<>(), new boolean[n + 1]);
    }

    public static void dfs(int n, int m, int depth, int now, List<Integer> list, boolean[] visited) {
        if (depth == m) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = now; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            list.add(i);
            visited[i] = true;
            dfs(n, m, depth + 1, i + 1, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}