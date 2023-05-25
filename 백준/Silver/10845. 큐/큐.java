import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static final Queue<Integer> queue = new LinkedList<>();
    private static Integer backNum;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push":
                    queue.offer(Integer.parseInt(command[1]));
                    backNum = Integer.parseInt(command[1]);
                    break;
                case "pop":
                    if (queue.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(queue.poll() + "\n");
                    break;
                case "size":
                    sb.append(queue.size() + "\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(queue.peek() + "\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(backNum + "\n");
                    }
                    break;
            }
        }

        System.out.println(sb);

    }
}