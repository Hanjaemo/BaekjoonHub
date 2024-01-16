import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 테스트 케이스 t
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // for (t번 반복)
        for (int testCase = 0; testCase < t; testCase++) {
            // 건물 개수 n, 규칙 개수 m
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 각 건물의 시간 배열 times 생성
            int[] times = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            // 각 건물이 연결된 그래프 graph
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            // for (m번 반복)
                // graph.get(a).add(b)
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
            }

            // 승리하기 위해 건설할 건물 번호
            int endNode = Integer.parseInt(br.readLine());

            // 각 노드 별 최종 시간 배열 result
            int[] result = new int[n + 1];

            // 진입 차수 배열 inDegree 생성
            int[] inDegree = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < graph.get(i).size(); j++) {
                    inDegree[graph.get(i).get(j)]++;
                }
            }

            // 큐 queue
            Queue<Integer> queue = new LinkedList<>();

            // for (i=1~n)
                // 진입 차수 0인 노드 큐, result에 저장
            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                    result[i] = times[i];
                }
            }
            // while (큐에 원소 존재)
                // 큐에서 꺼낸 노드 now
                // for (now가 가리키는 노드 탐색)
                    // now가 가리키는 건물 next
                    // next의 진입 차수 1 감소
                    // result[next] = max(result[next], result[now] + times[next])
                    // next의 진입 차수가 0인 경우 큐에 저장
            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (int i = 0; i < graph.get(now).size(); i++) {
                    int next = graph.get(now).get(i);
                    inDegree[next]--;
                    result[next] = Math.max(result[next], result[now] + times[next]);
                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            
            // result[마지막 건물 번호] 출력
            System.out.println(result[endNode]);
        }
    }
}