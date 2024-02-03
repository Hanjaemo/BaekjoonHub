import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // 9명 난쟁이들의 키를 배열에 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // for (i=0~7)
            // for (j=i+1~8)
                // for (k=0~8)
                    // if arr[k] == arr[i] or arr[j] : continue
                    // sum에 arr[k] 더하기
                    // result 리스트에 arr[k] 추가
                // if sum == 100 : result 리스트 오름차순 정렬 후 출력
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int sum = 0;
                List<Integer> result = new ArrayList<>();
                int exceptA = arr[i];
                int exceptB = arr[j];
                for (int k = 0; k < 9; k++) {
                    if (arr[k] == exceptA || arr[k] == exceptB) {
                        continue;
                    }
                    sum += arr[k];
                    result.add(arr[k]);
                }

                if (sum == 100) {
                    Collections.sort(result);
                    for (Integer integer : result) {
                        System.out.println(integer);
                    }
                    return;
                }
            }
        }
    }
}