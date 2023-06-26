import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int n, k;
    private static final int SIZE = 200000;
    private static int[] arr, dist;
    private static final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        arr = new int[SIZE];
        dist = new int[SIZE];
        System.out.println(bfs());
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    }

    private static int bfs() {
        queue.offer(n);
        dist[n] = 0;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            if (p == k) {
                return dist[p];
            }
            if (p - 1 >= 0 && dist[p - 1] == 0) {
                dist[p - 1] = dist[p] + 1;
                queue.offer(p - 1);
            }
            if (p + 1 < SIZE && dist[p + 1] == 0) {
                dist[p + 1] = dist[p] + 1;
                queue.offer(p + 1);
            }
            if (2 * p < SIZE && dist[2 * p] == 0) {
                dist[2 * p] = dist[p] + 1;
                queue.offer(2 * p);
            }
        }
        return -1;
    }
}