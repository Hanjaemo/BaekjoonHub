import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        int numberWords = Integer.parseInt(br.readLine());
        repeat(numberWords);
        System.out.println(count);
    }

    public static void repeat(int numberWords) throws IOException {
        for (int i = 0; i < numberWords; i++) {
            String word = br.readLine();
            solve(word);
        }
    }

    private static void solve(String word) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (deque.isEmpty()) {
                deque.push(c);
            } else {
                if (deque.peek() == word.charAt(i)) {
                    deque.pop();
                } else {
                    deque.push(word.charAt(i));
                }
            }
        }

        if (deque.isEmpty()) {
            count++;
        }
    }


}