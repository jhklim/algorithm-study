package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        long low = 1;
        long high = 1;

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, A[i]);
        }
        high *= M;

        long ans = 0;
        while(low <= high) {
            long mid = (low+high)/2;
            long cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += mid/A[i];
                if(cnt >= M) break;
            }

            if(cnt >= M) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
