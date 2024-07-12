import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Time> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Time(s, e));
        }

        Queue<Integer> lasts = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            Time now = pq.poll();
            if (!lasts.isEmpty() && lasts.peek() <= now.s) {
                lasts.poll();
            }
            lasts.add(now.e);
        }

        System.out.println(lasts.size());
    }
}

class Time implements Comparable<Time> {

    int s, e;

    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        if (this.s == o.s) {
            return this.e - o.e;
        }
        return this.s - o.s;
    }
}
