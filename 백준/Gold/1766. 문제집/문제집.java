import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 문제 수 n, 정보 수 m
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // for (m번 반복)
            // graph 생성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        // 진입 차수 배열 inDegree 생성
        int[] inDegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                inDegree[graph.get(i).get(j)]++;
            }
        }

        // 우선 순위 큐 생성
        Queue<Integer> queue = new PriorityQueue<>();

        // for (i=1~n)
            // 진입 차수가 0인 노드 큐에 저장
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 정답 리스트 answer
        List<Integer> answer = new ArrayList<>();

        // while (큐에 원소 존재)
            // 큐에서 꺼낸 노드 now
            // answer에 now 추가
            // for (now가 가리키는 노드 탐색)
                // now가 가리키는 노드 next
                // inDegree[next]--
                // 진입 차수가 0이면 큐에 저장
        while (!queue.isEmpty()) {
            int now = queue.poll();
            answer.add(now);
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 정렬 결과 출력
        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }
    }
}