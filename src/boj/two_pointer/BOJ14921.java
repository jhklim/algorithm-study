package boj.two_pointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int l = 0;
        int r = N-1;
        int min = Integer.MAX_VALUE;
        while(l < r) {
            int sum = A[l]+A[r];
            if(Math.abs(sum) < Math.abs(min)) {
                min = sum;
            } else if (sum == 0) {
                min = 0;
                break;
            } else if (sum > 0) {
                r--;
            } else {
                l++;
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}
