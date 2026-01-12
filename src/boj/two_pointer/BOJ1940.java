package boj.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int s = 0;
        int e = N-1;
        int cnt = 0;
        while(s < e) {
            if(A[s] + A[e] > M) {
                e--;
            } else if(A[s] + A[e] < M) {
                s++;
            } else { // sum == M
                cnt++;
                s++;
                e--;
            }
        }
        System.out.println(cnt);
    }
}
