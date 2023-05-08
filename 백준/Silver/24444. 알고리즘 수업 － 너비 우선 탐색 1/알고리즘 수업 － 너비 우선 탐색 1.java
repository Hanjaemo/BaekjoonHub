import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int vertexCount;
    static int edgeCount;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertexCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        visited = new boolean[vertexCount + 1];
        for (int i = 0; i <= vertexCount; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }

        for (int i = 0; i <= vertexCount; i++) {
            Collections.sort(adjList.get(i));
        }

        bfsList(startVertex);

        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static void bfsList(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        result = new int[vertexCount + 1];

        queue.offer(startVertex);
        visited[startVertex] = true;
        result[startVertex] = ++count;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int i = 0; i < adjList.get(v).size(); i++) {
                int nextV = adjList.get(v).get(i);
                if (!visited[nextV]) {
                    queue.offer(nextV);
                    visited[nextV] = true;
                    result[nextV] = ++count;
                }
            }
        }
    }

}
