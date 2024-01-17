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
        // 컴퓨터 수 n
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 선 개수 m
        int m = Integer.parseInt(br.readLine());

        // 에지 정보를 저장하는 우선 순위 큐
        Queue<Edge> queue = new PriorityQueue<>();

        // for (m번 반복)
            // 큐에 에지 정보 저장
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
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

        // while (answer 크기 < n-1)
            // 큐에서 꺼낸 에지 now
            // if find(now.a) == find(now.b) : continue
            // union(now.a, now.b)
            // answer에 now.cost 저장
        while (answer.size() < n - 1) {
            Edge now = queue.poll();
            if (find(arr, now.a) == find(arr, now.b)) {
                continue;
            }
            union(arr, now.a, now.b);
            answer.add(now.cost);
        }

        // answer 값들의 총합 출력
        int sum = 0;
        for (Integer integer : answer) {
            sum += integer;
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