package boj.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] A = new char[51][51];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = line.charAt(j);
            }
        }
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                answer = Math.min(answer, chessboard(A, i, j));
            }
        }

        System.out.println(answer);
    }

    private static int chessboard(char[][] A, int x, int y) {
        int cnt = 0;
        char startColor = A[x][y];

        for (int i = x; i < 8+x; i++) {
            for (int j = y; j < 8+y; j++) {
                if((i+j) % 2 == 0) {
                    if(A[i][j] != startColor) {
                        cnt++;
                    }
                } else {
                    if(A[i][j] == startColor) {
                        cnt++;
                    }
                }
            }
        }
        return Math.min(cnt, 64-cnt);
    }
}
