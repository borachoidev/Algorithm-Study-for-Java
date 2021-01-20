package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Br1003 {
    static int[] f0;
    static int[] f1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());

            fib(k);
            sb.append(f0[k] + " " + f1[k] + "\n");
        }

        System.out.println(sb);

    }

    static void fib(int n) {

        f0 = new int[n + 1];
        f1 = new int[n + 1];

        f0[0] = 1;
        f1[0] = 0;
        if (n > 0) {
            f0[1] = 0;
            f1[1] = 1;
        }

        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                f0[i] = f0[i - 2] + f0[i - 1];
                f1[i] = f1[i - 2] + f1[i - 1];
            }

        }
    }

}
