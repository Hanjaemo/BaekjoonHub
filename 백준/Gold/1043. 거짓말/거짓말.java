import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 대표 노드 저장 배열 arr
    static int[] arr;
    // 진실 아는 사람 배열 knowPeople
    static int[] knowPeople;
    // 파티 참가자 배열 participants
    static List<List<Integer>> participants = new ArrayList<>();
    // 참가 가능한 파티 수 count = 0
    static int count = 0;

    public static void main(String[] args) throws IOException {
        // 사람 수 n, 파티 수 m 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // arr 초기화
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        // 진실을 아는 사람들의 번호를 입력 받아, knowPeople 배열에 저장
        String[] inputKnowInfo = br.readLine().split(" ");
        int knowPeopleCount = Integer.parseInt(inputKnowInfo[0]);
        knowPeople = new int[knowPeopleCount];
        for (int i = 0; i < knowPeopleCount; i++) {
            knowPeople[i] = Integer.parseInt(inputKnowInfo[i + 1]);
        }

        // participants 초기화
        for (int i = 0; i < m; i++) {
            participants.add(new ArrayList<>());
        }
        
        // for (m번 반복)
            // i번째 파티에 참가하는 사람들의 번호를 participants에 인접 리스트로 저장
        for (int i = 0; i < m; i++) {
            String[] inputPartyInfo = br.readLine().split(" ");
            int participantCount = Integer.parseInt(inputPartyInfo[0]);
            for (int j = 1; j <= participantCount; j++) {
                participants.get(i).add(Integer.parseInt(inputPartyInfo[j]));
            }
        }

        // for (m번 반복)
            // 각 파티의 첫 번째 참가자 firstParticipant
            // 첫 번째 참가자와 i번째 파티 참가자들에 대한 union 연산
        for (int i = 0; i < m; i++) {
            int firstParticipant = participants.get(i).get(0);
            for (int j = 1; j < participants.get(i).size(); j++) {
                union(firstParticipant, participants.get(i).get(j));
            }
        }
        
        // for (m번 반복)
            // i번째 파티의 첫 번째 참가자가 진실을 아는 사람이라면 건너뛰고, 아니라면 count++
        for (int i = 0; i < m; i++) {
            boolean isPossible = true;
            for (int j = 0; j < knowPeopleCount; j++) {
                int firstParticipants = participants.get(i).get(0);
                if (find(firstParticipants) == find(knowPeople[j])) {
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
        if (arr[node] == node) {
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