package boj.prefix_sum;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sumArr = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            sumArr[i] = arr[i] + sumArr[i-1];
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            bw.write(sumArr[e]-sumArr[s-1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
