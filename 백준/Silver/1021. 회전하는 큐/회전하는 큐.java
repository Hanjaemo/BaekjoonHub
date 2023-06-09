import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static final StringBuilder sb = new StringBuilder();
    private static final LinkedList<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        initDeque(n);

        int[] numbers = initNumbers(m);

        int count = 0;
        count = solve(m, numbers, count);
        System.out.println(count);
    }

    private static int solve(int m, int[] numbers, int count) {
        for (int i = 0; i < m; i++) {
            int dequeSize = deque.size();
            int centerIdx = (dequeSize % 2 == 0) ? dequeSize / 2 : dequeSize / 2 + 1;
            int targetIdx = deque.indexOf(numbers[i]) + 1;
            while (numbers[i] != deque.peekFirst()) {
                if (targetIdx <= centerIdx) {
                    moveToLeft();
                } else {
                    moveToRight();
                }
                count++;
            }
            pollFirst();
        }
        return count;
    }

    private static int[] initNumbers(int m) throws IOException {
        int[] numbers = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        return numbers;
    }

    private static void initDeque(int n) {
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }
    }


    private static void pollFirst() {
        deque.pollFirst();
    }

    private static void moveToLeft() {
        deque.offerLast(deque.pollFirst());
    }

    private static void moveToRight() {
        deque.offerFirst((deque.pollLast()));
    }
}