import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dfs(n, m, 0, new StringBuilder());
        bw.flush();
    }

    public static void dfs(int n, int m, int depth, StringBuilder sb) throws IOException {
        if (depth == m) {
            bw.write(sb.toString());
            bw.newLine();
            return;
        }

        for (int i = 1; i <= n; i++) {
            sb.append(i).append(" ");
            dfs(n, m, depth + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}