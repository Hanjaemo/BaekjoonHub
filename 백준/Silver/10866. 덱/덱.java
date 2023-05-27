import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static final Deque deque = new LinkedList();
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        command(testCase);
        print();
    }

    public static void command(int testCase) throws IOException {
        for (int i = 0; i < testCase; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(command[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(command[1]));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else{
                        sb.append(deque.pollFirst() + "\n");
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else{
                        sb.append(deque.pollLast() + "\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size() + "\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else{
                        sb.append(deque.peekFirst() + "\n");
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else{
                        sb.append(deque.peekLast() + "\n");
                    }
                    break;
            }
        }
    }

    public static void print() {
        System.out.println(sb);
    }
}