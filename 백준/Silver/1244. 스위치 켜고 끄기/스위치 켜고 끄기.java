import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 스위치 개수 switchCount
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchCount = Integer.parseInt(br.readLine());

        // 스위치 배열 arr
        boolean[] arr = new boolean[switchCount + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchCount; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                arr[i] = true;
            }
        }

        // 학생 수 studentCount
        int studentCount = Integer.parseInt(br.readLine());

        // for (studentCount만큼 반복)
            // 성별 gender, 받은 수 num
            // if 남학생인 경우
                // for (arr 탐색)
                    // if 스위치 번호가 받은 수의 배수인 경우 변환
            // if 여학생인 경우
                // for (받은 수 n만큼 반복)
                    // 받은 수와 일치하는 스위치 번호의 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 모두 변환
        for (int student = 0; student < studentCount; student++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                for (int i = 1; i <= switchCount; i++) {
                    if (i % num == 0) {
                        convertSwitch(arr, i);
                    }
                }
            } else {
                convertSwitch(arr, num);
                int start = num - 1;
                int end = num + 1;
                while (start > 0 && end <= switchCount) {
                    if (arr[start] == arr[end]) {
                        convertSwitch(arr, start);
                        convertSwitch(arr, end);
                    } else {
                        break;
                    }
                    start--;
                    end++;
                }
            }
        }

        // 스위치 상태 출력
        for (int i = 1; i <= switchCount; i++) {
            if (arr[i]) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

    public static void convertSwitch(boolean[] arr, int num) {
        arr[num] = !arr[num];
    }
}