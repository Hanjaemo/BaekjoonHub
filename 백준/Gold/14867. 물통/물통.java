import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int limitA, limitB, goalA, goalB;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limitA = Integer.parseInt(st.nextToken());
        limitB = Integer.parseInt(st.nextToken());
        goalA = Integer.parseInt(st.nextToken());
        goalB = Integer.parseInt(st.nextToken());

        bfs();
    }

    public static void bfs() {
        Queue<Bottle> queue = new LinkedList<>();
        queue.add(new Bottle(0, 0, 0));
        Set<Bottle> visited = new HashSet<>();
        visited.add(new Bottle(0, 0, 0));

        while (!queue.isEmpty()) {
            Bottle now = queue.poll();
            if (now.a == goalA && now.b == goalB) {
                System.out.println(now.d);
                return;
            }

            Bottle fillA = fillA(now.b, now.d);
            if (!visited.contains(fillA)) {
                queue.add(fillA);
                visited.add(fillA);
            }

            Bottle fillB = fillB(now.a, now.d);
            if (!visited.contains(fillB)) {
                queue.add(fillB);
                visited.add(fillB);
            }

            Bottle emptyA = emptyA(now.b, now.d);
            if (!visited.contains(emptyA)) {
                queue.add(emptyA);
                visited.add(emptyA);
            }


            Bottle emptyB = emptyB(now.a, now.d);
            if (!visited.contains(emptyB)) {
                queue.add(emptyB);
                visited.add(emptyB);
            }

            Bottle aToB = moveAtoB(now.a, now.b, now.d);
            if (!visited.contains(aToB)) {
                queue.add(aToB);
                visited.add(aToB);
            }

            Bottle bToA = moveBtoA(now.a, now.b, now.d);
            if (!visited.contains(bToA)) {
                queue.add(bToA);
                visited.add(bToA);
            }
        }

        System.out.println(-1);
    }

    public static Bottle fillA(int b, int d) {
        return new Bottle(limitA, b, d + 1);
    }

    public static Bottle fillB(int a, int d) {
        return new Bottle(a, limitB, d + 1);
    }

    public static Bottle emptyA(int b, int d) {
        return new Bottle(0, b, d + 1);
    }

    public static Bottle emptyB(int a, int d) {
        return new Bottle(a, 0, d + 1);
    }

    public static Bottle moveAtoB(int a, int b, int d) {
        if (a + b > limitB) {
            return new Bottle(a + b - limitB, limitB, d + 1);
        } else {
            return new Bottle(0, b + a, d + 1);
        }
    }

    public static Bottle moveBtoA(int a, int b, int d) {
        if (a + b > limitA) {
            return new Bottle(limitA, b + a - limitA, d + 1);
        } else {
            return new Bottle(a + b, 0, d + 1);
        }
    }
}

class Bottle {
    int a, b, d;

    public Bottle(int a, int b, int d) {
        this.a = a;
        this.b = b;
        this.d = d;
    }

    @Override
    public boolean equals(Object o) {
        Bottle other = (Bottle) o;
        return a == other.a && b == other.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}