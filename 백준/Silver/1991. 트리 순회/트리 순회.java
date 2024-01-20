import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new int[2][26];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left == '.') {
                tree[0][node] = -1;
            } else {
                tree[0][node] = left - 'A';
            }
            if (right == '.') {
                tree[1][node] = -1;
            } else {
                tree[1][node] = right - 'A';
            }
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    public static void preOrder(int now) {
        if (now == -1) {
            return;
        }
        System.out.print((char) (now + 'A'));
        preOrder(tree[0][now]);
        preOrder(tree[1][now]);
    }

    public static void inOrder(int now) {
        if (now == -1) {
            return;
        }
        inOrder(tree[0][now]);
        System.out.print((char) (now + 'A'));
        inOrder(tree[1][now]);
    }

    public static void postOrder(int now) {
        if (now == -1) {
            return;
        }
        postOrder(tree[0][now]);
        postOrder(tree[1][now]);
        System.out.print((char) (now + 'A'));
    }
}