import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 문자열 입력 input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 완성 문자열 result
        StringBuilder result = new StringBuilder();

        // 각 연속된 X의 개수 count = 0
        int count = 0;

        // 문자열을 탐색하며 폴리오미노로 덮기
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.') {
                if (count % 2 != 0) {
                    System.out.println(-1);
                    return;
                }
                poly(result, count);
                result.append(".");
                count = 0;
            } else {
                count++;
            }
        }
        
        // if 입력 받은 문자열에 X만 포함되어 있는 경우
            // if X 개수가 홀수인 경우 : -1 출력 및 종료
            // else : 폴리오미노로 덮기
        if (count > 0) {
            if (count % 2 != 0) {
                System.out.println(-1);
                return;
            } else {
                poly(result, count);
            }
        }

        // result 출력
        System.out.println(result);
    }

    private static void poly(StringBuilder result, int count) {
        int AC = 0;
        int BC = 0;
        while (count > 0) {
            if (count >= 4) {
                AC += count / 4;
                count %= 4;
            } else {
                BC += count / 2;
                count %= 2;
            }
        }
        for (int j = 0; j < AC; j++) {
            result.append("AAAA");
        }
        for (int j = 0; j < BC; j++) {
            result.append("BB");
        }
    }
}