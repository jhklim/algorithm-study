package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] A = new long[K];

        long low = 1;
        long high = 0;

        for (int i = 0; i < K; i++) {
            A[i] = Long.parseLong(br.readLine());
            high = Math.max(high, A[i]);
        }

        long ans = 0;
        while(low <= high) {
            long cnt = 0;
            long mid = (low + high)/2;
            for (int i = 0; i < K; i++) {
                cnt += A[i]/mid;
            }

            if(cnt >= N) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
