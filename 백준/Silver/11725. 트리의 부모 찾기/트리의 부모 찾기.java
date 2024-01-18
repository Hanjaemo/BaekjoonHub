import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        visited = new boolean[n + 1];
        answer = new int[n + 1];
        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void dfs(int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (int i = 0; i < tree.get(node).size(); i++) {
            int child = tree.get(node).get(i);
            if (!visited[child]) {
                answer[child] = node;
                dfs(child);
            }
        }
    }
}