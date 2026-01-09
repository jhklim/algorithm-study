package boj.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int temp = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] > arr[j]) {
                    arr[i] = temp;
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        int x = Integer.parseInt(br.readLine());

        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;
        while(end < n) {
            if(sum > x) {
                sum = sum - arr[start];
                start++;
            } else if(sum < x) {
                end++;
                if (end < n) {
                    sum = sum + arr[end];
                }
            } else { // sum == x
                cnt++;
                sum = sum - arr[start];
                start++;
            }
        }
        System.out.println(cnt);
    }
}
