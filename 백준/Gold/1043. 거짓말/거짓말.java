import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        // 사람 수 n, 파티 수 m
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // arr 초기화
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        // 진실을 아는 사람 배열 knowPeople
        st = new StringTokenizer(br.readLine());
        int knowPeopleCount = Integer.parseInt(st.nextToken());
        int[] knowPeople = new int[knowPeopleCount];
        for (int i = 0; i < knowPeopleCount; i++) {
            knowPeople[i] = Integer.parseInt(st.nextToken());
        }

        // 진실을 아는 사람끼리 연결
        for (int i = 1; i < knowPeopleCount; i++) {
            union(knowPeople[0], knowPeople[i]);
        }

        // 파티에 오는 사람 배열 participants
        int[] participants = new int[m];
        // for (m번 반복)
            // 파티 정보 입력
            // 각 파티별로 첫 사람과 나머지 사람들 간의 union 연산 수행
            // 각 파티별로 첫 사람을 participants에 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int participantCount = Integer.parseInt(st.nextToken());
            int firstParticipant = Integer.parseInt(st.nextToken());
            if (participantCount > 1) {
                for (int j = 1; j < participantCount; j++) {
                    union(firstParticipant, Integer.parseInt(st.nextToken()));
                }
            }
            participants[i] = firstParticipant;
        }

        // 과장된 이야기 가능한 파티 수 count
        int count = 0;
        // for (m번 반복)
            // knowPeople의 대표 노드에 find(participants[i])가 포함되지 않으면 count 1 증가
        for (int i = 0; i < m; i++) {
            boolean isPossible = true;
            for (int j = 0; j < knowPeopleCount; j++) {
                if (find(participants[i]) == find(knowPeople[j])){
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                count++;
            }
        }

        // count 출력
        System.out.println(count);
    }

    private static int getParent(int node) {
        if (node == arr[node]) {
            return node;
        }
        return arr[node] = getParent(arr[node]);
    }

    private static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }

    private static int find(int node) {
        return getParent(node);
    }
}