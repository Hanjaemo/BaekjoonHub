import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] myArr;
    static int[] secret;
    // 만들 수 있는 비밀번호의 종류 수
    static int secretCnt;

    public static void main(String[] args) throws IOException {
        // DNA 문자열 길이 s, 부분문자열 길이 p 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        // DNA 문자열 입력
        String[] dna = br.readLine().split("");

        // 부분문자열에 포함되어야 할 A, C, G, T의 최소 개수 입력 받아 배열 secret 생성
        secret = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            secret[i] = Integer.parseInt(st.nextToken());
        }

        myArr = new int[4];

        for (int i = 0; i < p; i++) {
            add(dna[i]);
        }

        check();

        // 슬라이딩 윈도우 로직
        for (int i = p; i < s; i++) {
            int j = i - p;
            add(dna[i]);
            remove(dna[j]);
            check();
        }

        System.out.println(secretCnt);
    }

    private static void add(String s) {
        switch (s) {
            case "A":
                myArr[0]++;
                break;
            case "C":
                myArr[1]++;
                break;
            case "G":
                myArr[2]++;
                break;
            case "T":
                myArr[3]++;
                break;
        }
    }

    private static void remove(String s) {
        switch (s) {
            case "A":
                myArr[0]--;
                break;
            case "C":
                myArr[1]--;
                break;
            case "G":
                myArr[2]--;
                break;
            case "T":
                myArr[3]--;
                break;
        }
    }

    private static void check() {
        for (int i = 0; i < 4; i++) {
            if (myArr[i] < secret[i]) {
                return;
            }
        }
        secretCnt++;
    }
}