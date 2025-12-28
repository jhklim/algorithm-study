package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n +1]; // d[i]: i번째 계단까지 얻을 수 있는 최대점수 값
        int[] s = new int[n +1];
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1) {
            System.out.println(s[1]);
            return;
        }

        dp[1] = s[1];
        dp[2] = s[1] + s[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-3] + s[i-1], dp[i-2]) + s[i];
        }
        System.out.println(dp[n]);
    }
}
