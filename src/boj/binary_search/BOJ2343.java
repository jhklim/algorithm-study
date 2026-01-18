package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        int l = 0;
        int r = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            l = Math.max(l, A[i]);
            r += A[i];
        }

        int ans = 0;
        while(l <= r) {
            int mid = (l+r)/2;
            int sum = 0;
            int cnt = 1;
            for (int i = 0; i < N; i++) {
                if(sum + A[i] > mid) {
                    cnt ++;
                    sum = A[i];
                } else {
                    sum += A[i];
                }
            }

            if(cnt <= M) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
