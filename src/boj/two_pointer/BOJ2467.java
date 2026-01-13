package boj.two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int l = 0;
        int r = N-1;
        int min = Integer.MAX_VALUE;
        int ansL = 0;
        int ansR = 0;
        while(l < r) {
            int sum = A[l] + A[r]; 
            if(Math.abs(sum) < Math.abs(min)) {
                min = sum;
                ansL = A[l];
                ansR = A[r];
            } else if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(ansL + " " + ansR);
    }
}
