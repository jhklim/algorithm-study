package boj.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = 1;
        int sum = A[1];
        int cnt = 0;
        while(end <= N) {
            if(sum == M) {
                cnt++;
                sum = sum - A[start];
                start++;
            } else if(sum > M) {
                sum = sum - A[start];
                start++;
            } else { // sum < M
                end++;
                if(end <= N) {
                    sum = sum + A[end];
                } else {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
