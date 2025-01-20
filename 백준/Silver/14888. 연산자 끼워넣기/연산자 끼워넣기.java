import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] numbers;
    static int[] ops = new int[4];
    static long max = Integer.MIN_VALUE;
    static long min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] == 0) {
                continue;
            }
            ops[i]--;
            backTracking(i, 1, numbers[0]);
            ops[i]++;
        }

        System.out.println(max);
        System.out.println(min);
    }

    public static void backTracking(int opsIdx, int numbersIdx, long prevValue) {
        long result = calculate(opsIdx, numbersIdx, prevValue);
        if (numbersIdx == numbers.length - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (ops[i] == 0) {
                continue;
            }
            ops[i]--;
            backTracking(i, numbersIdx + 1, result);
            ops[i]++;
        }
    }

    private static long calculate(int opsIdx, int numbersIdx, long prevValue) {
        switch (opsIdx) {
            case 0:
                return prevValue + numbers[numbersIdx];
            case 1:
                return prevValue - numbers[numbersIdx];
            case 2:
                return prevValue * numbers[numbersIdx];
            case 3:
                if (prevValue < 0) {
                    return Math.abs(prevValue) / numbers[numbersIdx] * -1;
                } else {
                    return prevValue / numbers[numbersIdx];
                }
        }
        return 0;
    }
}