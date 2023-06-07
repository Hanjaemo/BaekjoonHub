import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        
        while (true) {
            String input = br.readLine();

            if (input.equals(".")) {
                break;
            }

            sb.append(solve(input)).append('\n');
        }
        System.out.println(sb);
    }

    private static String solve(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '[') {
                stack.push(input.charAt(i));
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() == '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() == '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            }
        }

        return printYesOrNo(stack);
    }

    private static String printYesOrNo(Stack<Character> stack) {
        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}