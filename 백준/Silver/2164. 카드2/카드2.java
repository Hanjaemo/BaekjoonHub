import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        offerQueue(n);
        solve();
        System.out.println(queue.peek());
    }

    public static void offerQueue(int n) {
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
    }

    public static boolean checkSize() {
        return !(queue.size() == 1);
    }

    public static void solve() {
        while (checkSize()) {
            queue.poll();
            Integer x = queue.poll();
            queue.offer(x);
        }
    }
}