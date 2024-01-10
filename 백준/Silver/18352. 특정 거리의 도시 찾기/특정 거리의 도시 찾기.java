import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 인접 리스트를 담은 배열 arr (크기는 n+1)
    static List<List<Integer>> arr = new ArrayList<>();
    // 방문 기록 배열 visited
    static int[] visited;
    // 큐 자료구조 queue
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // 도시 개수 n, 도로 개수 m, 거리 정보 k, 출발 도시 번호 x 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // arr, visited 초기화
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        visited = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visited[i] = -1;
        }

        // for (i=0~m-1)
            // 에지 입력
            // 각 노드의 인접 리스트 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            arr.get(startNode).add(endNode);
        }

        // bfs(x)
        bfs(x);

        // 최단 거리가 k인 노드를 저장하는 리스트 result
        List<Integer> result = new ArrayList<>();

        // for (visited 탐색)
            // if visited[i] == k
                // result.add(i)
        for (int i = 1; i <= n; i++) {
            if (visited[i] == k) {
                result.add(i);
            }
        }

        // if result가 비어 있는 경우
            // result 오름차순 정렬
            // result 요소들 출력
        // 그렇지 않은 경우
            // -1 출력
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (Integer integer : result) {
                System.out.println(integer);
            }
        }
    }

    private static void bfs(int node) {
        // 시작 노드를 큐에 저장
        queue.add(node);
        
        // node 방문 처리
        visited[node]++;

        // while (큐에 요소 존재)
            // 큐에서 꺼낸 요소 polled
            // for (polled의 인접 리스트 탐색)
                // if visited[i] == -1
                    // visited[i] = visited[polled] + 1
                    // i를 큐에 저장
        while (!queue.isEmpty()) {
            int polled = queue.poll();
            for (Integer i : arr.get(polled)) {
                if (visited[i] == -1) {
                    visited[i] = visited[polled] + 1;
                    queue.add(i);
                }
            }
        }
    }
}