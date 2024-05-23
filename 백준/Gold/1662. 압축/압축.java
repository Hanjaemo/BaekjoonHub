import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 33(562(71(9)))
 * 33(6(562(2(2)2(2))))
 *
 * 33(
 * 1. 문자열 입력 input
 * 2. input 순회
 * if ')' -> peek = '('일 때까지 pop 및 길이 카운트,
 *              if pop = '*' -> (len += pop한 숫자),
 *              len++
 *              '(' pop, 숫자 pop 후 길이에 곱하기, push(곱한 숫자 문자열), push('*')
 * else -> push
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            String now = input[i];
            if (now.equals(")")) {
                int len = 0;
                while (!stack.peek().equals("(")) {
                    String popped = stack.pop();
                    if (popped.equals("*")) {
                        len += Integer.parseInt(stack.pop());
                    } else {
                        len++;
                    }
                }
                stack.pop();
                len *= Integer.parseInt(stack.pop());
                stack.push(String.valueOf(len));
                stack.push("*");
            } else {
                stack.push(now);
            }
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            String popped = stack.pop();
            if (popped.equals("*")) {
                answer += Integer.parseInt(stack.pop());
            } else {
                answer++;
            }
        }
        System.out.println(answer);
    }
}