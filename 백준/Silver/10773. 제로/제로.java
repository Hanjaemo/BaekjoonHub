import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Stack<Integer> stack = new Stack<>();
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                stack.pop();
            } else {
                stack.push(n);
            } 
        }

        int sum = 0;

        for (Integer integer : stack) {
            sum += integer;
        }

        System.out.println(sum);
    }
}