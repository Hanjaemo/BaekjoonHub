import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 국가 개수 n, 등수를 알고 싶은 국가 번호 k
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 국가를 저장하는 배열 countries
        Country[] countries = new Country[n];
        // for (n번 반복)
            // countries에 메달 개수 정보를 가진 국가 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int countryNumber = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            countries[i] = new Country(countryNumber, gold, silver, bronze);
        }

        Arrays.sort(countries);


        for (int i = 0; i < n; i++) {
            if (countries[i].number == k) {
                Country find = countries[i];
                int count = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (countries[j].compareTo(countries[i]) < 0) {
                        count++;
                    }
                }
                System.out.println(count + 1);
                break;
            }
        }

    }
}

class Country implements Comparable<Country> {
    int number;
    int gold;
    int silver;
    int bronze;

    public Country(int number, int gold, int silver, int bronze) {
        this.number = number;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    @Override
    public int compareTo(Country o) {
        if (this.gold == o.gold) {
            if (this.silver == o.silver) {
                return o.bronze - this.bronze;
            } else {
                return o.silver - this.silver;
            }
        } else {
            return o.gold - this.gold;
        }
    }
}