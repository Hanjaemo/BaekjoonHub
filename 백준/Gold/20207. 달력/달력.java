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
        Queue<Schedule> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue.add(new Schedule(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        boolean[][] calender = new boolean[1001][366];
        // 달력 채우기
        while (!queue.isEmpty()) {
            Schedule now = queue.poll();
            int s = now.start;
            int e = now.end;
            int depth = 1;

            // depth 증가
            for (int i = s; i <= e; i++) {
                if (calender[depth][i]) {
                    depth++;
                    i = s - 1;
                }
            }

            // 일정 기록
            for (int i = s; i <= e; i++) {
                calender[depth][i] = true;
            }
        }

        // 높이 구하기
        int[] heights = new int[366];
        for (int i = 1; i <= 365; i++) {
            int h = 0;
            for (int j = 1; j <= 1000; j++) {
                if (calender[j][i]) {
                    h = j;
                }
            }
            heights[i] = h;
        }

        // 코팅지 면적 구하기
        int w = 0;
        int h = 0;
        int answer = 0;
        for (int i = 1; i <= 365; i++) {
            if (heights[i] > 0) {
                w++;
                h = Math.max(heights[i], h);
            } else {
                answer += w * h;
                w = 0;
                h = 0;
            }
        }

        if (heights[365] != 0) {
            answer += w * h;
        }

        System.out.println(answer);
    }
}

class Schedule implements Comparable<Schedule> {
    int start;
    int end;

    public Schedule(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Schedule o) {
        if (this.start == o.start) {
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}