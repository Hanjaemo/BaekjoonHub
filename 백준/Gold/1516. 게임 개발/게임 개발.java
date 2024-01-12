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
        // 건물 수 n 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 건물 번호와 각 번호의 인접 리스트 저장 리스트 arr
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        // 진입차수 배열 inDegree
        int[] inDegree = new int[n + 1];
        // 각 건물 생산 시간 배열 times
        int[] times = new int[n + 1];
        // 각 건물 최대 생산 시간 배열 maxTimes
        int[] maxTimes = new int[n + 1];

        // for (i=1~n)
            // i의 생산 시간, 먼저 지어져야 하는 건물, -1 입력
            // times에 생산 시간 저장
            // while (st에 남아 있는 경우)
                // if -1이면 탈출
                // arr.get(입력 받은 건물).add(i)
                // 입력 받은 건물의 진입 차수 1 증가
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            maxTimes[i] = times[i];
            while (st.hasMoreTokens()) {
                int nextToken = Integer.parseInt(st.nextToken());
                if (nextToken == -1) {
                    break;
                }
                arr.get(nextToken).add(i);
                inDegree[i]++;
            }
        }

        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        // for (i=1~n)
            // if i의 진입 차수가 0 : 큐에 i 저장
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // while (큐에 요소 존재)
            // 큐에서 뽑은 요소 now
            // now의 다음 건물들의 진입 차수 1 감소
            // now의 최대 생산 시간 업데이트 : max(i의 최대 생산 시간, i의 최대 생산 시간 + 다음 건물의 생산 시간)
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < arr.get(now).size(); i++) {
                int next = arr.get(now).get(i);
                inDegree[next]--;
                maxTimes[next] = Math.max(maxTimes[next], maxTimes[now] + times[next]);
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // times 출력
        for (int i = 1; i <= n; i++) {
            System.out.println(maxTimes[i]);
        }
    }
}