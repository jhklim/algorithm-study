package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        int low = 1;
        int high = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, A[i]);
        }

        int ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if(A[i] >= mid) {
                    cnt += A[i]/mid;
                    if(cnt >= M) break;
                }
            }

            if(cnt >= M) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
