package boj.two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (true) {
            if (sum >= S) {
                len = Math.min(len, end-start);
                sum -= A[start++];
            } else if (end == N) {
                break;
            } else {
                sum += A[end++];
            }
        }
        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}
