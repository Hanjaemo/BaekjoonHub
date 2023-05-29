import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] command = br.readLine().split("");
            int dequeSize = Integer.parseInt(br.readLine());
            Deque<Integer> deque = setDeque(dequeSize);
            solve(command, deque);
        }
        System.out.println(sb);
    }

    public static Deque<Integer> setDeque(int dequeSize) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < dequeSize; i++) {
            deque.offer(Integer.parseInt(st.nextToken()));
        }
        return deque;
    }

    public static void solve(String[] command, Deque<Integer> deque) {
        boolean isRight = false;
        for (int i = 0; i < command.length; i++) {
            if (command[i].equals("R")) {
                isRight = !isRight;
                continue;
            }

            if (isRight) {
                if (deque.isEmpty()) {
                    sb.append("error\n");
                    return;
                } else {
                    deque.pollLast();
                }
            } else {
                if (deque.isEmpty()) {
                    sb.append("error\n");
                    return;
                } else {
                    deque.pollFirst();
                }
            }
        }
        stringBuild(deque, isRight);
    }

    public static void stringBuild(Deque<Integer> deque, boolean isRight) {
        sb.append("[");
        if (deque.size() > 0) {
            if (isRight) {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append("," + deque.pollLast());
                }
            } else {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append("," + deque.pollFirst());
                }
            }
        }
        sb.append("]\n");
    }
}