package boj.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);

        int s = 0;
        int e = 0;
        int min = Integer.MAX_VALUE;
        while(s < N && e < N) {
            if(A[e]-A[s] >= M) {
                min = Math.min(A[e]-A[s++], min);
            } else { // A[e]-A[s] < M
                e++;
            }
        }
        System.out.println(min);
    }
}
