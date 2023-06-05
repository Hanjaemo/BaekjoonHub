import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Deque<Integer> stack = new ArrayDeque<>();
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int start = 0;

        while (n-- > 0) {
            int value = Integer.parseInt(br.readLine());
            if (start < value) {
                pushStartToValue(start, value);
                start = value;
            } else if (stack.peek() != value) {
                System.out.println("NO");
                return;
            }
            pop();
        }

        System.out.println(sb);
    }

    private static void pop() {
        stack.pop();
        sb.append("- \n");
    }

    private static void pushStartToValue(int start, int value) {
        for (int i = start + 1; i <= value; i++) {
            stack.push(i);
            sb.append("+ \n");
        }
    }
}