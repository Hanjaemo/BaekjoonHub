import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] belt = new int[n];
        for (int i = 0; i < n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int s = 0; s < n; s++) {
            int e = s + k - 1;
            set.clear();

            if (e >= n) {
                for (int i = s; i < n; i++) {
                    set.add(belt[i]);
                }
                for (int i = 0; i <= e - n; i++) {
                    set.add(belt[i]);
                }
            } else {
                for (int i = s; i <= e; i++) {
                    set.add(belt[i]);
                }
            }
            set.add(c);
            max = Math.max(max, set.size());
        }

        System.out.println(max);
    }
}
