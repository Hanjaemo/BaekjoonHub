import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String input;
    private static Deque<Character> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input = br.readLine();
        pushFirstChar();
        int answer = solve();
        System.out.println(answer);
    }

    private static void pushFirstChar() {
        if (input.charAt(0) == '(') {
            deque.push(input.charAt(0));
        } else {
            System.exit(0);
        }
    }

    private static int solve() {
        int count = 1;
        boolean isPushed = true;
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                count++;
                deque.push(c);
                isPushed = true;
            } else {
                if (isPushed) {
                    count--;
                    deque.pop();
                    count += deque.size();
                    isPushed = false;
                } else {
                    deque.pop();
                }
            }
        }
        return count;
    }
}