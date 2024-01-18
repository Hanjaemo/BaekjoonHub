import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
                continue;
            }
            tree.get(parent).add(i);
        }

        int delete = Integer.parseInt(br.readLine());

        if (delete == root) {
            System.out.println(0);
        } else {
            visited = new boolean[n];
            dfs(root, delete);
            System.out.println(result);
        }
    }

    private static void dfs(int node, int delete) {
        visited[node] = true;
        int count = 0;

        for (int i = 0; i < tree.get(node).size(); i++) {
            int child = tree.get(node).get(i);
            if (!visited[child] && child != delete) {
                count++;
                dfs(child, delete);
            }
        }
        if (count == 0) {
            result++;
        }
    }
}