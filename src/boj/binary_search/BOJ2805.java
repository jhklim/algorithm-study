package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int s = 0;
        int e = 0;

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            e = Math.max(e, A[i]);
        }

        int ans = 0;
        while(s <= e) {
            int mid = (s+e)/2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if(A[i] > mid) {
                    sum += A[i] - mid;
                }
            }
            if(sum >= M) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
