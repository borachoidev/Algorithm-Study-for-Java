package backtracking;

import java.io.*;

public class Br9663 {
    static int[] board;
    static int n;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 입력개수
        board = new int[n];

        queen(0);
        System.out.println(count);
    }

    static void queen(int level) {
        if (level == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[level] = i;
            if (isPossible(level))
                queen(level + 1);
        }

    }

    static boolean isPossible(int level) {
        for (int i = 0; i < level; i++) {
            if (board[i] == board[level] || Math.abs(level - i) == Math.abs(board[level] - board[i])) {
                return false;
            }
        }

        return true;
    }

}