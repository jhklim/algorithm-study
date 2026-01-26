package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15989 {
    static int maxN = 10000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[maxN+1][4]; // dp[n][k] : n을 만드는 경우 중 마지막에 k를 사용하는 경우의 수
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int i = 4; i < maxN+1; i++) {
            dp[i][1] = dp[i-1][1]; // 1로 끝나는 경우: 이전 경우에 1만 추가
            dp[i][2] = dp[i-2][2] + dp[i-2][1]; // 2로 끝나는 경우: 이전에 1 또는 2로 끝난 경우만 가능
            dp[i][3] = dp[i-3][3] + dp[i-3][2] + dp[i-3][1]; // 3으로 끝나는 경우: 이전에 1,2,3으로 끝난 모든 경우 가능
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][1] + dp[N][2] + dp[N][3]).append('\n');
        }
        System.out.println(sb);
    }
}
