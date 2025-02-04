import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] persons = new Person[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            persons[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Person now = persons[i];
            int k = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                Person other = persons[j];
                if (now.x < other.x && now.y < other.y) {
                    k++;
                }
            }
            sb.append(k + 1).append(" ");
        }

        System.out.println(sb);
    }
}

class Person {
    int x, y;

    public Person(int x, int y) {
        this.x = x;
        this.y = y;
    }
}