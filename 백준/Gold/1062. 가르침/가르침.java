import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static boolean[] visited;
    static List<Set<String>> words = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        for (int i = 0; i < n; i++) {
            words.add(new HashSet<>());
        }

        for (int i = 0; i < n; i++) {
            Set<String> word = words.get(i);
            String[] input = br.readLine().split("");
            for (int j = 4; j < input.length - 4; j++) {
                if (!visited[input[j].charAt(0) - 'a']) {
                    word.add(input[j]);
                }
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int start, int depth) {
        if (depth == k - 5) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (canRead(i)) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean canRead(int i) {
        for (String s : words.get(i)) {
            if (!visited[s.charAt(0) - 'a']) {
                return false;
            }
        }
        return true;
    }
}
