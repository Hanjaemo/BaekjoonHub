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
        // 학생 수 n, 키를 비교한 횟수 m 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 인접 리스트를 담는 arr
        List<List<Integer>> arr = new ArrayList<>();
        // arr 초기화
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        // 진입 차수 배열 inDegreeArr
        int[] inDegreeArr = new int[n + 1];

        // for (m번 반복)
            // 학생의 번호 a, b 입력
            // arr.get(a).add(b)
            // inDegreeArr[b]++
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            inDegreeArr[b]++;
        }

        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // for (inDegreeArr 탐색)
            // if 값이 0이면 큐에 저장
        for (int i = 1; i <= n; i++) {
            if (inDegreeArr[i] == 0) {
                queue.add(i);
            }
        }

        // while (큐에 요소가 들어 있는 경우)
            // 큐에서 노드를 하나 빼고, 그 노드를 출력
            // 빠진 노드가 가리키는 노드의 진입 차수 1 감소
            // if 진입 차수가 감소한 노드의 진입 차수가 0이면 큐에 저장
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int i = 0; i < arr.get(now).size(); i++) {
                int adj = arr.get(now).get(i);
                inDegreeArr[adj]--;
                if (inDegreeArr[adj] == 0) {
                    queue.add(adj);
                }
            }
        }
    }
}