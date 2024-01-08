import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (priorityQueue.size() > 1) {
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            result += a + b;
            priorityQueue.add(a + b);
        }

        System.out.println(result);
    }
}