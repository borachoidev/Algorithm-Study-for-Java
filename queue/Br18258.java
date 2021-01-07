package queue;

import java.io.*;
import java.util.*;

public class Br18258 {
    public static LinkedList<Integer> queue = new LinkedList<Integer>();
    public static StringBuilder sb = new StringBuilder();
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop() + "\n");
                    break;
                case "size":
                    sb.append(size() + "\n");
                    break;
                case "empty":
                    sb.append(empty() + "\n");
                    break;
                case "front":
                    sb.append(front() + "\n");
                    break;
                default:
                    sb.append(back() + "\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    public static void push(int data) {
        queue.add(size, data);
        size++;
    }

    static int pop() {
        int res;
        if (empty() == 1) {
            res = -1;
        } else {
            res = queue.remove(0);
            size--;
        }
        return res;
    }

    static int size() {
        return size;
    }

    static int empty() {
        return size() == 0 ? 1 : 0;
    }

    static int front() {
        int res;
        if (empty() == 1) {
            res = -1;
        } else {
            res = queue.getFirst();
        }
        return res;
    }

    static int back() {
        int res;
        if (empty() == 1) {
            res = -1;
        } else {
            res = queue.getLast();
        }
        return res;
    }
}
