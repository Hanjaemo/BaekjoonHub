import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {
        // 전체 사람 수 n
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 촌수 계산 대상 from, to
        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        // 관계 수 m
        int m = Integer.parseInt(br.readLine());

        // m번 반복해 graph에 인접리스트 저장
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // bfs(from, to) 출력
        System.out.println(bfs(from, to));
    }

    public static int bfs(int from, int to) {
        // 큐 자료구조 queue
        Queue<Integer> queue = new LinkedList<>();
        // 방문 기록 배열 visited
        boolean[] visited = new boolean[n + 1];

        // 큐에 from 저장
        queue.add(from);
        // from 방문 처리
        visited[from] = true;

        // 촌수 배열 counts
        int[] counts = new int[n + 1];

        // while (큐에 요소 존재)
            // 큐에서 꺼낸 요소 now
            // if now == to : counts[now] 반환
            // for (now의 인접 요소 탐색)
                // now의 인접 요소 next
                // if next를 방문하지 않은 경우
                    // 큐에 저장하고 방문처리
                    // counts[next] = counts[now] + 1
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == to) {
                return counts[now];
            }
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    counts[next] = counts[now] + 1;
                }
            }

        }

        // from과 to가 연결되어 있지 않으면 -1 반환
        return -1;
    }
}