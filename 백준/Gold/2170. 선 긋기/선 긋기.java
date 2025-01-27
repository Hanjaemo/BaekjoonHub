import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Line> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            queue.add(new Line(x, y));
        }

        Line prev = queue.poll();
        int answer = prev.y - prev.x;
        while (!queue.isEmpty()) {
            Line now = queue.poll();
            if (prev.y < now.x) { // 안 겹칠 때
                answer += now.y - now.x;
            } else {
                if (prev.y >= now.y) { // 완전히 포함될 때
                    continue;
                } else  { // 겹칠 때
                    answer += now.y - prev.y;
                }
            }

            prev = now;
        }

        System.out.println(answer);
    }
}

class Line implements Comparable<Line> {
    int x, y;

    public Line(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Line o) {
        if (this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}