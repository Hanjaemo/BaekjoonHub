import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Deque<Character> deque = new LinkedList<>();
    private static final int CIRCLE_BRACKET_VAL = 2;
    private static final int SQUARE_BRACKET_VAL = 3;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int answer = solve(input);
        System.out.println(answer);
    }

    private static int solve(String input) {
        int answer = 0;
        int x = 1;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                deque.push(c);
                x *= CIRCLE_BRACKET_VAL;
            } else if (c == '[') {
                deque.push(c);
                x *= SQUARE_BRACKET_VAL;
            } else {
                if (c == ')') {
                    if (deque.isEmpty() || deque.peek() != '(') {
                        exit();
                    }
                    if (input.charAt(i - 1) == '(') {
                        answer += x;
                    }
                    deque.pop();
                    x /= CIRCLE_BRACKET_VAL;
                }
                if (c == ']') {
                    if (deque.isEmpty() || deque.peek() != '[') {
                        exit();
                    }
                    if (input.charAt(i - 1) == '[') {
                        answer += x;
                    }
                    deque.pop();
                    x /= SQUARE_BRACKET_VAL;
                }
            }
        }

        if (!deque.isEmpty()) {
            exit();
        }
        return answer;
    }

    private static void exit() {
        System.out.println(0);
        System.exit(0);
    }
}