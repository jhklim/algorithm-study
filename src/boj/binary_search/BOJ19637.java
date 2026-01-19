package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] titles = new String[N];
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            titles[i] = st.nextToken();
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < M; i++) {
            int low = 0;
            int high = N-1;
            int mid = 0;
            int key = Integer.parseInt(br.readLine());
            int ans = 0;
            while(low <= high) {
                mid = (low+high)/2;
                if(key <= numbers[mid]) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            sb.append(titles[ans]).append('\n');
        }
        System.out.print(sb);
    }
}
