package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[M];

        int low = 1;
        int high = 0;

        for (int i = 0; i < M; i++) {
            A[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, A[i]);
        }

        int ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                if(A[i] % mid == 0) {
                    cnt += A[i]/mid;
                } else {
                    cnt += (A[i]/mid) + 1;
                }
            }

            if(cnt <= N) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(ans);

    }
}
