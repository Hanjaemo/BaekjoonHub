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
    static int[] limit;
    static boolean[][] visited;
    static Queue<BottleAB> queue = new LinkedList<>();
    static List<Integer> answer = new ArrayList<>();
    static int[] senders = {0, 0, 1, 1, 2, 2};
    static int[] receivers = {1, 2, 0, 2, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limit = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }
        
        visited = new boolean[201][201];
        
        bfs();
        
        Collections.sort(answer);
        
        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }
    }

    private static void bfs() {
        // 큐에 출발 노드 저장
        queue.add(new BottleAB(0, 0)); // A, B가 0, 0인 상태에서 시작하므로 출발 노드는 (0, 0)
        // 출발 노드 방문 처리
        visited[0][0] = true;
        // 정답 리스트에 시작 시점의 C 용량 저장
        answer.add(limit[2]);

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 노드 가져오기
            BottleAB polled = queue.poll();
            int a = polled.a;
            int b = polled.b;
            int c = limit[2] - a - b; // 전체 물의 양 - a - b
            // 6가지 케이스(A->B, A->C, B->A, B->C, C->A, C->B) 반복하기
            for (int k = 0; k < 6; k++) {
                int[] bottles = {a, b, c}; // 이름 음...
                int from = senders[k]; // 보내는 물통
                int to = receivers[k]; // 받는 물통
                // 받는 물통에 보내는 물통의 값 더하기
                bottles[to] += bottles[from];
                // 보내는 물통의 값 = 0
                bottles[from] = 0;
                // if 받는 물통이 넘치는 경우
                    // 넘치는 만큼 보내는 물통에 다시 넣어주고,
                    // 받는 물통은 해당 물통의 최댓값으로 저장
                if (bottles[to] > limit[to]) {
                    bottles[from] = bottles[to] - limit[to];
                    bottles[to] = limit[to];
                }
                // if 방문하지 않은 노드인 경우
                    // 방문 처리
                    // 큐에 A, B 저장
                    // if A 물통의 값이 0인 경우
                        // 정답 리스트에 C 물통의 값 저장
                if (!visited[bottles[0]][bottles[1]]) {
                    visited[bottles[0]][bottles[1]] = true;
                    queue.add(new BottleAB(bottles[0], bottles[1]));
                    if (bottles[0] == 0) {
                        answer.add(bottles[2]);
                    }
                }
            }
        }
    }
}

// C는 유추 가능
class BottleAB {
    int a;
    int b;

    public BottleAB(int a, int b) {
        this.a = a;
        this.b = b;
    }
}