import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] a = new boolean[n]; // 1번 전구 off
        boolean[] b = new boolean[n]; // 1번 전구 on
        boolean[] goal = new boolean[n];

        String[] init = br.readLine().split("");
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(init[i]) == 1) {
                a[i] = true;
                b[i] = true;
            } else {
                a[i] = false;
                b[i] = false;
            }
        }

        b[0] = !b[0];
        b[1] = !b[1];

        String[] goalInput = br.readLine().split("");
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(goalInput[i]) == 1) {
                goal[i] = true;
            } else {
                goal[i] = false;
            }
        }

        int[] cnt = {0, 1};
        for (int i = 1; i < n; i++) {
            if (a[i - 1] != goal[i - 1]) {
                reverse(a, i);
                cnt[0]++;
            }
            if (b[i - 1] != goal[i - 1]) {
                reverse(b, i);
                cnt[1]++;
            }
        }

        if (isSame(a, goal)) {
            System.out.println(cnt[0]);
        } else if (isSame(b, goal)) {
            System.out.println(cnt[1]);
        } else {
            System.out.println(-1);
        }
    }

    public static void reverse(boolean[] arr, int i) {
        if (i < arr.length - 1) {
            arr[i + 1] = !arr[i + 1];
        }
        arr[i - 1] = !arr[i - 1];
        arr[i] = !arr[i];
    }

    public static boolean isSame(boolean[] a, boolean[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}