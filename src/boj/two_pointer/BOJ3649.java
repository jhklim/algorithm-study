package boj.two_pointer;

import java.io.*;
import java.util.Arrays;

public class BOJ3649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String Xval;
        while((Xval = br.readLine()) != null) {
            int Xcm = Integer.parseInt(Xval);
            int x = Xcm * 10000000;

            int n = Integer.parseInt(br.readLine());
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(A);

            int l = 0;
            int r = n-1;
            int ansL = -1;
            int ansR = -1;
            if(n > 1) {
                while(l < r) {
                    if(A[l]+A[r] < x) {
                        l++;
                    } else if (A[l]+A[r] > x) {
                        r--;
                    } else {
                        ansL = A[l];
                        ansR = A[r];
                        break;
                    }
                }
            }
            bw.write(ansL > 0 ? "yes " + ansL + " " + ansR : "danger");
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }
}
