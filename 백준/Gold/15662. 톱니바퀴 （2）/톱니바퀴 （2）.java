import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Deque<Integer>> gears = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            gears.add(new ArrayDeque<>());
            Deque<Integer> gear = gears.get(i);
            String[] input = br.readLine().split("");
            for (String s : input) {
                gear.addLast(Integer.parseInt(s));
            }
        }

        int rotation = Integer.parseInt(br.readLine());
        for (int r = 0; r < rotation; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[gears.size()];
            rotate(gears, num, dir, visited);
        }

        int answer = 0;
        for (Deque<Integer> gear : gears) {
            if (gear.getFirst() == 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void rotate(List<Deque<Integer>> gears, int num, int dir, boolean[] visited) {
        if (num < 0 || num >= gears.size() || visited[num]) {
            return;
        }

        visited[num] = true;
        Deque<Integer> gear = gears.get(num);

        Integer[] arr = gear.toArray(new Integer[8]);

        if (num - 1 >= 0) {
            Integer[] leftArr = gears.get(num - 1).toArray(new Integer[8]);
            if ((int) arr[6] != leftArr[2]) {
                rotate(gears, num - 1, dir * -1, visited);
            }
        }

        if (num + 1 < gears.size()) {
            Integer[] rightArr = gears.get(num + 1).toArray(new Integer[8]);
            if ((int) arr[2] != rightArr[6]) {
                rotate(gears, num + 1, dir * -1, visited);
            }
        }

        // 회전
        if (dir == -1) {
            gear.addLast(gear.pollFirst());
        } else {
            gear.addFirst(gear.pollLast());
        }
    }
}