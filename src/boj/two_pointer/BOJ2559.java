package boj.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < K; i++) {
            max += A[i];
        }

        int sum = max;
        for (int i = K; i < N; i++) {
            sum = sum + A[i] - A[i-K];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
