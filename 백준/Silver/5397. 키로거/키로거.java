import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Character> list;

    public static void main(String[] args) throws IOException {

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            list = new LinkedList<>();
            ListIterator<Character> it = list.listIterator();
            keyLogger(input(), it);
            StringBuilder sb = stringBuild();
            output(sb);
        }
    }

    public static String input() throws IOException {
        return br.readLine();
    }

    public static void keyLogger(String str, ListIterator<Character> it) {

        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '<') {
                if (it.hasPrevious()) {
                    it.previous();
                }
            } else if (str.charAt(j) == '>') {
                if (it.hasNext()) {
                    it.next();
                }
            } else if (str.charAt(j) == '-') {
                if (it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
            } else {
                it.add(str.charAt(j));
            }
        }
    }

    public static StringBuilder stringBuild() {
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        return sb;
    }

    public static void output(StringBuilder sb) {
        System.out.println(sb.toString());
    }

}