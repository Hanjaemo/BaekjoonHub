import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            if (i == dfs(arr, new boolean[n + 1], i)) {
                set.add(i);
            }
        }

        List<Integer> toList = new ArrayList<>(set);
        Collections.sort(toList);
        System.out.println(toList.size());
        for (Integer integer : toList) {
            System.out.println(integer);
        }
    }

    public static int dfs(int[] arr, boolean[] visited, int idx) {
        if (visited[idx]) {
            return idx;
        }
        visited[idx] = true;
        return dfs(arr, visited, arr[idx]);
    }
}