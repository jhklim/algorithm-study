package boj.two_pointer;

import java.io.*;

public class BOJ17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String word = br.readLine();
            int len = word.length();
            int result = isPalindrome(0, len-1, word, 0);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int isPalindrome(int s, int e, String word, int check) {
        while(s < e) {
            if(check >= 2) {
                return 2;
            }
            if(word.charAt(s) == word.charAt(e)) {
                s++;
                e--;
            } else {
                return Math.min(isPalindrome(s+1, e, word, check+1), isPalindrome(s, e-1, word, check+1));
            }
        }
        return check;
    }
}
