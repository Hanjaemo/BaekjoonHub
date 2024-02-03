import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int DIGIT_NUM = 3;

    public static void main(String[] args) throws IOException {
        // 질문 개수 n
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // QnA 정보를 저장할 2차원 배열 qna
        int[][] qna = new int[n][DIGIT_NUM];
        // n번 반복하여 QnA 정보를 입력받아 qna에 저장
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < DIGIT_NUM; j++) {
                qna[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // count = 0
        int result = 0;

        // for (num=111~999)
            // if 0이 포함된 경우 or 서로 다른 수가 아닌 경우 : continue
            // for (i=0~n-1)
                // for (j=0~2)
                    // if QnA 정보와 모두 일치하는 수 : count++
        for (int num = 111; num <= 999; num++) {
            if (containsZero(num) || isNotUnique(num)) {
                continue;
            }
            int sameCount = 0;
            for (int i = 0; i < n; i++) {
                int question = qna[i][0];
                int strikeCount = qna[i][1];
                int ballCount = qna[i][2];
                if (strikeCount == getStrikeCount(question, num) && ballCount == getBallCount(question, num)) {
                    sameCount++;
                }
            }
            if (sameCount == n) {
                result++;
            }
        }

        // count 출력
        System.out.println(result);
    }

    public static boolean containsZero(int num) {
        return String.valueOf(num).contains("0");
    }

    public static boolean isNotUnique(int number) {
        String toString = String.valueOf(number);
        char a = toString.charAt(0);
        char b = toString.charAt(1);
        char c = toString.charAt(2);
        return a == b || b == c || a == c;
    }

    public static int getStrikeCount(int q, int a) {
        int strikeCount = 0;
        String qStr = String.valueOf(q);
        String aStr = String.valueOf(a);
        for (int i = 0; i < DIGIT_NUM; i++) {
            for (int j = 0; j < DIGIT_NUM; j++) {
                if (i == j && qStr.charAt(i) == aStr.charAt(j)) {
                    strikeCount++;
                }
            }
        }

        return strikeCount;
    }

    public static int getBallCount(int q, int a) {
        int ballCount = 0;
        String qStr = String.valueOf(q);
        String aStr = String.valueOf(a);
        for (int i = 0; i < DIGIT_NUM; i++) {
            for (int j = 0; j < DIGIT_NUM; j++) {
                if (i != j && qStr.charAt(i) == aStr.charAt(j)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }
}