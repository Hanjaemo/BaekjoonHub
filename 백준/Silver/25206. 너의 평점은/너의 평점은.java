import java.io.*;

public class Main {
    static final int SUBJECT_NUM = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        float sum = 0;
        float totalCredit = 0;

        for (int i = 0; i < SUBJECT_NUM; i++) {
            String str = br.readLine();

            String[] strArr = str.split(" ");

            String name = strArr[0];
            float credit = Float.parseFloat(strArr[1]);
            String score = strArr[2];

            credit = pass(credit, score);
            float value = credit * getScore(score);
            sum += value;
            totalCredit += credit;
        }

        float result = sum / totalCredit;
        System.out.printf("%.6f", result);
    }

    static public float getScore(String score) {
        switch (score) {
            case "A+":
                return 4.5F;
            case "A0":
                return 4.0F;
            case "B+":
                return 3.5F;
            case "B0":
                return 3.0F;
            case "C+":
                return 2.5F;
            case "C0":
                return 2.0F;
            case "D+":
                return 1.5F;
            case "D0":
                return 1.0F;
            case "F":
                return 0.0F;
        }
        return 0;
    }

    static public float pass(float credit, String score) {
        if (score.equals("P")) {
            return 0.0F;
        } else {
            return credit;
        }
    }
}