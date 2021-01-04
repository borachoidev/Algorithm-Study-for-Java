package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Br10828 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> mystack = new LinkedList<Integer>();

        try {
            int n = Integer.parseInt(br.readLine());
            String[] input = new String[n];
            for (int i = 0; i < n; i++) {

                input[i] = br.readLine();

            }
            for (int j = 0; j < n; j++) {
                int res;

                if (input[j].contains("push")) {
                    int data = Integer.parseInt(input[j].substring(5, input[j].length()).trim());
                    mystack.add(0, data);
                } else if (input[j].contains("pop")) {

                    if (mystack.size() == 0) {
                        res = -1;

                    } else {
                        res = mystack.get(0);
                        mystack.removeFirst();
                    }

                    System.out.println(res);

                } else if (input[j].contains("size")) {
                    System.out.println(mystack.size());

                } else if (input[j].contains("empty")) {
                    if (mystack.size() == 0)
                        res = 1;
                    else
                        res = 0;
                    System.out.println(res);
                } else {
                    if (mystack.size() == 0)
                        res = -1;
                    else
                        res = mystack.get(0);
                    System.out.println(res);
                }
            }
        } catch (NumberFormatException |

                IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
