import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Stack<Integer> stack = new Stack<>();
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            command();
        }


    }

    public static void command() throws IOException {
        String[] input = br.readLine().split(" ");

        switch (input[0]) {
            case "push":
                stack.push(Integer.parseInt(input[1]));
                break;
            case "pop":
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
                break;
            case "size":
                System.out.println(stack.size());
                break;
            case "empty":
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                break;
            case "top":
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
                break;
        }
    }
}