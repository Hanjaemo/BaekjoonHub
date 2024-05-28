import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
 * remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
 * check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
 * toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
 * all: S를 {1, 2, ..., 20} 으로 바꾼다.
 * empty: S를 공집합으로 바꾼다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x = 0;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }
            switch (cmd) {
                case "add":
                    add(set, x);
                    break;
                case "remove":
                    remove(set, x);
                    break;
                case "check":
                    bw.write(check(set, x) + "\n");
                    break;
                case "toggle":
                    toggle(set, x);
                    break;
                case "all":
                    all(set);
                    break;
                case "empty":
                    empty(set);
                    break;
            }
        }
        bw.flush();
    }

    public static void add(Set<Integer> set, int x) {
        set.add(x);
    }

    public static void remove(Set<Integer> set, int x) {
        if (!set.contains(x)) {
            return;
        }
        set.remove(x);
    }

    public static int check(Set<Integer> set, int x) {
        if (set.isEmpty()) {
            return 0;
        }
        if (set.contains(x)) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void toggle(Set<Integer> set, int x) {
        if (set.contains(x)) {
            set.remove(x);
        } else {
            set.add(x);
        }
    }

    public static void all(Set<Integer> set) {
        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }
    }

    public static void empty(Set<Integer> set) {
        set.clear();
    }
}