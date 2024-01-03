import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 노드 개수 n, 에지 개수 m 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<>());
        }

        // for (m번 반복)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            // 입력 받은 에지의 양끝 점을 배열에 인접 리스트로 저장
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int vertex;
        int count = 0;
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                visited[i] = true;
                if (deque.isEmpty()) {
                    for (int j = 0; j < arr.get(i).size(); j++) {
                        Integer adj = arr.get(i).get(j);
                        if (!deque.contains(adj)) {
                            deque.push(adj);
                        }
                    }
                }
                while (!deque.isEmpty()) {
                    vertex = deque.pop();
                    if (!visited[vertex]) {
                        visited[vertex] = true;
                        for (int j = 0; j < arr.get(vertex).size(); j++) {
                            Integer adj = arr.get(vertex).get(j);
                            if (!deque.contains(adj)) {
                                deque.push(adj);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}