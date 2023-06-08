import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Top {
    private int num;
    private int height;

    public Top(int num, int height) {
        this.num = num;
        this.height = height;
    }

    public int getNum() {
        return num;
    }

    public int getHeight() {
        return height;
    }
}

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Deque<Top> deque = new ArrayDeque<>();
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (deque.isEmpty()) {
                printZero(i, height);
            } else {
                repeat(i, height);
            }
        }
        System.out.println(sb);
    }

    private static void repeat(int i, int height) {
        while (true) {
            if (deque.isEmpty()) {
                printZero(i, height);
                break;
            }
            Top peekTop = deque.peek();
            if (peekTop.getHeight() > height) {
                sb.append(peekTop.getNum() + " ");
                deque.push(new Top(i, height));
                break;
            } else {
                deque.pop();
            }
        }
    }

    private static void printZero(int i, int height) {
        sb.append("0 ");
        deque.push(new Top(i, height));
    }
}