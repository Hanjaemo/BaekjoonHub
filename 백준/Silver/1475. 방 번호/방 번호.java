import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] numSet = new int[10];

        int[] roomNums = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < roomNums.length; i++) {
            int roomNum = roomNums[i];
            if (roomNum == 6 || roomNum == 9) {
                if (numSet[6] < numSet[9]) {
                    numSet[6]++;
                } else {
                    numSet[9]++;
                }
                continue;
            }
            numSet[roomNum]++;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numSet.length; i++) {
            max = Math.max(max, numSet[i]);
        }
        System.out.println(max);
    }
}