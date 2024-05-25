import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Queue<Pair> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.offer(new Pair(i, Integer.parseInt(st.nextToken())));
            }

            int order = 0;
            while (!queue.isEmpty()) {
                Pair peek = queue.peek();
                if (existLargerElement(peek, queue)) {
                    queue.offer(queue.poll());
                } else {
                    Pair polled = queue.poll();
                    order++;
                    if (polled.i == m) {
                        System.out.println(order);
                        break;
                    }
                }
            }
        }
    }

    private static boolean existLargerElement(Pair peek, Queue<Pair> queue) {
        List<Pair> list = queue.stream().collect(Collectors.toList());
        for (int i = 1; i < list.size(); i++) {
            if (peek.n < list.get(i).n) {
                return true;
            }
        }
        return false;
    }
}

class Pair {
    int i, n;

    public Pair(int i, int n) {
        this.i = i;
        this.n = n;
    }
}