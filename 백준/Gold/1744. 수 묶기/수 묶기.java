import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> positiveQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> negativeQueue = new PriorityQueue<>();
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                zeroCount++;
            }
            if (number > 0) {
                positiveQueue.add(number);
            }
            if (number < 0) {
                negativeQueue.add(number);
            }
        }

        int result = 0;
        while (positiveQueue.size() > 1) {
            int a = positiveQueue.poll();
            int b = positiveQueue.poll();
            if (a * b > a + b) {
                result += a * b;
            } else {
                result += a + b;
            }
        }
        if (!positiveQueue.isEmpty()) {
            result += positiveQueue.poll();
        }

        while (negativeQueue.size() > 1) {
            int a = negativeQueue.poll();
            int b = negativeQueue.poll();
            if (a * b > a + b) {
                result += a * b;
            } else {
                result += a + b;
            }
        }
        if (!negativeQueue.isEmpty()) {
            if (zeroCount > 0) {
                negativeQueue.poll();
                zeroCount--;
            } else {
                result += negativeQueue.poll();
            }
        }

        System.out.println(result);
    }
}