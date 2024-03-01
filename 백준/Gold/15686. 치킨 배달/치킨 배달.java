import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[] visitedChickens;
    static List<Pair> chickens = new ArrayList<>();
    static List<Pair> homes = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    homes.add(new Pair(i, j));
                }
                if (map[i][j] == 2) {
                    chickens.add(new Pair(i, j));
                }
            }
        }

        visitedChickens = new boolean[chickens.size()];
        backtracking(0, 0, m);

        System.out.println(answer);
    }

    public static void backtracking(int cnt, int start, int m) {
        if (cnt == m) {
            int total = 0;
            for (int i = 0; i < homes.size(); i++) {
                Pair home = homes.get(i);
                int dist = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if (visitedChickens[j]) {
                        Pair chicken = chickens.get(j);
                        dist = Math.min(dist, Math.abs(home.r - chicken.r) + Math.abs(home.c - chicken.c));
                    }
                }
                total += dist;
            }
            answer = Math.min(answer, total);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if (!visitedChickens[i]) {
                visitedChickens[i] = true;
                backtracking(cnt + 1, i + 1, m);
                visitedChickens[i] = false;
            }
        }
    }
}

class Pair {
    int r, c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}