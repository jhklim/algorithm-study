package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[Math.max(N+1, 4)]; // dp[n]: 정수 n을 1,2,3의 합으로 만드는 경우의 수

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i < N+1; i++) {
                    dp[i] = dp[i -1] + dp[i -2] + dp[i -3];
            }
            sb.append(dp[N]).append('\n');
        }
        System.out.println(sb);
    }
}
