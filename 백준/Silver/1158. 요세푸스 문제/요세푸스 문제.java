import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static int n, k;
    public static List<Integer> list = new LinkedList<>();
    public static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        input();
        addList(n);
        result = new ArrayList<>(n);


        solve();
        StringBuilder sb = stringBuild();
        System.out.println(sb);
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    }

    public static void addList(int n) {
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
    }

    public static void solve() {
        ListIterator<Integer> it = list.listIterator();
        while (!list.isEmpty()) {
            for (int i = 1; i <= k; i++) {
                if (!it.hasNext()) {
                    it = list.listIterator();
                }
                if (i == k) {
                    result.add(it.next());
                } else {
                    it.next();
                }
            }
            it.remove();
        }
    }

    public static StringBuilder stringBuild() {
        StringBuilder sb = new StringBuilder("<");

        for (int i = 0; i < n; i++) {
            if (i == (n - 1)) {
                sb.append(result.get(i) + ">");
            } else {
                sb.append(result.get(i) + ", ");
            }
        }
        return sb;
    }
}