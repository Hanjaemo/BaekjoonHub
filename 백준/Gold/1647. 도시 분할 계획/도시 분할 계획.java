import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 집의 개수 n, 길 개수 m
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 에지 정보 저장하는 우선 순위 큐 queue
        Queue<Edge> queue = new PriorityQueue<>();

        // for (m번 반복)
            // 큐에 에지 정보 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            queue.add(new Edge(a, b, c));
        }

        // 유니온 파인드 배열 arr
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        // 정답 리스트 answer
        List<Integer> answer = new ArrayList<>();

        // 연결 에지 개수 connected
        int connected = 0;
        // while (answer 크기 < n-1)
            // 큐에서 꺼낸 에지 now
            // if find(now.a) == find(now.b) : continue
            // union(now.a, now.b)
            // answer에 now.cost 저장
            // connected++
        while (connected < n - 1) {
            Edge now = queue.poll();
            if (find(arr, now.a) == find(arr, now.b)) {
                continue;
            }
            union(arr, now.a, now.b);
            answer.add(now.cost);
            connected++;
        }

        // answer 값들의 총합 출력
            // 이때 마지막 요소는 더하지 않는다. (마을 분리)
        int sum = 0;
        for (int i = 0; i < answer.size() - 1; i++) {
            sum += answer.get(i);
        }
        System.out.println(sum);
    }

    // find 연산
    private static int find(int[] arr, int node) {
        if (arr[node] == node) {
            return node;
        }
        return arr[node] = find(arr, arr[node]);
    }

    // union 연산
    private static void union(int[] arr, int a, int b) {
        a = find(arr, a);
        b = find(arr, b);
        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }
}

class Edge implements Comparable<Edge> {
    int a;
    int b;
    int cost;

    public Edge(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}