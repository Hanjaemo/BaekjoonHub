import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 정점 개수 v, 에지 개수 e
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 에지 정보를 저장하는 우선순위 큐 
        Queue<Edge> edges = new PriorityQueue<>();
        
        // 큐에 에지 정보 저장
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        // 유니온 파인드 배열 초기화
        int[] arr = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            arr[i] = i;
        }

        // 정답 리스트 answer
        List<Integer> answer = new ArrayList<>();

        // i = 0
        int i = 0;
        // while (answer 크기 < v-1)
            // 큐에서 꺼낸 에지 now
            // if find(now.a) == find(now.b) : continue
            // union(now.a, now.b)
            // answer에 now.cost 저장
            // i++
        while (answer.size() < v - 1) {
            Edge now = edges.poll();
            if (find(arr, now.a) == find(arr, now.b)) {
                continue;
            }
            union(arr, now.a, now.b);
            answer.add(now.cost);
            i++;
        }

        // answer의 원소 총합 출력
        int sum = 0;
        for (Integer integer : answer) {
            sum += integer;
        }
        System.out.println(sum);
    }

    // find 메서드
    private static int find(int[] arr, int node) {
        if (arr[node] == node) {
            return node;
        }
        return arr[node] = find(arr, arr[node]);
    }

    // union 메서드
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