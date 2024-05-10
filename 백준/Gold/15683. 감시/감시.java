import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int row, col;
    static int[][] map;
    static List<CCTV> list = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    static int[] dRow1 = {1, 0, -1, 0};
    static int[] dCol1 = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (0 < map[i][j] && map[i][j] < 6) {
                    list.add(new CCTV(map[i][j], i, j));
                }
            }
        }

        // ------ 입력 끝 -------

        install(0);
        System.out.println(answer);
    }

    public static void install(int depth) {
        if (depth == list.size()) {
            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == 0) {
                        count++;
                    }
                }
            }
            answer = Math.min(answer, count);
            return;
        }

        CCTV cctv = list.get(depth);

        switch (cctv.n) {
            case 1:
                left(cctv.r, cctv.c, true, depth + 7);
                install(depth + 1);
                left(cctv.r, cctv.c, false, depth + 7);

                right(cctv.r, cctv.c, true, depth + 7);
                install(depth + 1);
                right(cctv.r, cctv.c, false, depth + 7);

                up(cctv.r, cctv.c, true, depth + 7);
                install(depth + 1);
                up(cctv.r, cctv.c, false, depth + 7);

                down(cctv.r, cctv.c, true, depth + 7);
                install(depth + 1);
                down(cctv.r, cctv.c, false, depth + 7);
                break;
            case 2:
                left(cctv.r, cctv.c, true, depth + 7);
                right(cctv.r, cctv.c, true, depth + 7);
                install(depth + 1);
                left(cctv.r, cctv.c, false, depth + 7);
                right(cctv.r, cctv.c, false, depth + 7);

                up(cctv.r, cctv.c, true, depth + 7);
                down(cctv.r, cctv.c, true, depth + 7);
                install(depth + 1);
                up(cctv.r, cctv.c, false, depth + 7);
                down(cctv.r, cctv.c, false, depth + 7);
                break;
            case 3:
                left(cctv.r, cctv.c, true, depth + 7);
                down(cctv.r, cctv.c, true, depth + 7);
                install(depth + 1);
                left(cctv.r, cctv.c, false, depth + 7);
                down(cctv.r, cctv.c, false, depth + 7);

                left(cctv.r, cctv.c, true, depth + 7);
                up(cctv.r, cctv.c, true, depth + 7);
                install(depth + 1);
                left(cctv.r, cctv.c, false, depth + 7);
                up(cctv.r, cctv.c, false, depth + 7);

                up(cctv.r, cctv.c, true, depth + 7);
                right(cctv.r, cctv.c, true, depth + 7);
                install(depth + 1);
                up(cctv.r, cctv.c, false, depth + 7);
                right(cctv.r, cctv.c, false, depth + 7);

                right(cctv.r, cctv.c, true, depth + 7);
                down(cctv.r, cctv.c, true, depth + 7);
                install(depth + 1);
                right(cctv.r, cctv.c, false, depth + 7);
                down(cctv.r, cctv.c, false, depth + 7);
                break;
            case 4:
                left(cctv.r, cctv.c, true, depth + 7);
                up(cctv.r, cctv.c, true, depth + 7);
                down(cctv.r, cctv.c, true, depth + 7);
                install(depth + 1);
                left(cctv.r, cctv.c, false, depth + 7);
                up(cctv.r, cctv.c, false, depth + 7);
                down(cctv.r, cctv.c, false, depth + 7);

                left(cctv.r, cctv.c, true, depth + 7);
                up(cctv.r, cctv.c, true, depth + 7);
                right(cctv.r, cctv.c, true, depth + 7);
                install(depth + 1);
                left(cctv.r, cctv.c, false, depth + 7);
                up(cctv.r, cctv.c, false, depth + 7);
                right(cctv.r, cctv.c, false, depth + 7);

                up(cctv.r, cctv.c, true, depth + 7);
                right(cctv.r, cctv.c, true, depth + 7);
                down(cctv.r, cctv.c, true, depth + 7);
                install(depth + 1);
                up(cctv.r, cctv.c, false, depth + 7);
                right(cctv.r, cctv.c, false, depth + 7);
                down(cctv.r, cctv.c, false, depth + 7);

                left(cctv.r, cctv.c, true, depth + 7);
                right(cctv.r, cctv.c, true, depth + 7);
                down(cctv.r, cctv.c, true, depth + 7);
                install(depth + 1);
                left(cctv.r, cctv.c, false, depth + 7);
                right(cctv.r, cctv.c, false, depth + 7);
                down(cctv.r, cctv.c, false, depth + 7);
                break;
            case 5:
                left(cctv.r, cctv.c, true, depth + 7);
                right(cctv.r, cctv.c, true, depth + 7);
                up(cctv.r, cctv.c, true, depth + 7);
                down(cctv.r, cctv.c, true, depth + 7);
                install(depth + 1);
                left(cctv.r, cctv.c, false, depth + 7);
                right(cctv.r, cctv.c, false, depth + 7);
                up(cctv.r, cctv.c, false, depth + 7);
                down(cctv.r, cctv.c, false, depth + 7);
                break;
        }
    }

    public static void left(int nr, int nc, boolean set, int setN) {
        for (int c = nc - 1; c >= 0; c--) {
            if (map[nr][c] == 6) {
                break;
            }
            if (set) {
                if (map[nr][c] == 0) {
                    map[nr][c] = setN;
                }
            } else {
                if (map[nr][c] == setN) {
                    map[nr][c] = 0;
                }
            }
        }
    }

    public static void right(int nr, int nc, boolean set, int setN) {
        for (int c = nc + 1; c < col; c++) {
            if (map[nr][c] == 6) {
                break;
            }
            if (set) {
                if (map[nr][c] == 0) {
                    map[nr][c] = setN;
                }
            } else {
                if (map[nr][c] == setN) {
                    map[nr][c] = 0;
                }
            }
        }
    }

    public static void up(int nr, int nc, boolean set, int setN) {
        for (int r = nr - 1; r >= 0; r--) {
            if (map[r][nc] == 6) {
                break;
            }
            if (set) {
                if (map[r][nc] == 0) {
                    map[r][nc] = setN;
                }
            } else {
                if (map[r][nc] == setN) {
                    map[r][nc] = 0;
                }
            }
        }
    }

    public static void down(int nr, int nc, boolean set, int setN) {
        for (int r = nr + 1; r < row; r++) {
            if (map[r][nc] == 6) {
                break;
            }
            if (set) {
                if (map[r][nc] == 0) {
                    map[r][nc] = setN;
                }
            } else {
                if (map[r][nc] == setN) {
                    map[r][nc] = 0;
                }
            }
        }
    }
}

class CCTV {
    int n, r, c;

    public CCTV(int n, int r, int c) {
        this.n = n;
        this.r = r;
        this.c = c;
    }
}