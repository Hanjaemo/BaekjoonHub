import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            String[] split = input.split(" ");
            int[] arr = new int[Integer.parseInt(split[0])];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(split[i + 1]);
            }

            dfs(arr, new ArrayList<>(), 0);
            System.out.println();
        }
    }

    public static void dfs(int[] arr, List<Integer> list, int start) {
        if (list.size() == 6) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            list.add(arr[i]);
            dfs(arr, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}