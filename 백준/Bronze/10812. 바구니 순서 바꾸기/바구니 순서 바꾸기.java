import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        ArrayList<Integer> basket = new ArrayList<>(n);
        for (int l = 0; l < n; l++) {
            basket.add(l + 1);
        }

        int i, j, k;
        for (int l = 0; l < m; l++) {
            tokenizer = new StringTokenizer(br.readLine());
            i = Integer.parseInt(tokenizer.nextToken()) - 1;
            j = Integer.parseInt(tokenizer.nextToken()) - 1;
            k = Integer.parseInt(tokenizer.nextToken()) - 1;

            int begin = basket.get(i);
            int end = basket.get(k);

            while (begin != end) {
                basket.remove(i);
                basket.add(j, begin);
                begin = basket.get(i);
            }
        }

        print(basket);
    }

    static void print(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}