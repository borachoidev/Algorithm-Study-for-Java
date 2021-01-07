import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static StringBuffer sb = new StringBuffer();
	public static int[] Queue;
	public static int f = 0;
	public static int b = 0;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			Queue = new int[n];
			
			for(int i=0; i<n; i++) {
				push(i+1);
			}
			
			int idx = 0;
			sb.append("<");
			for(int i=0; i<n; i++) {
				int count=1;
				
				while(count < m) {
					if(Queue[idx % n] != 0) {
						count++;
					}
					idx++;
				}
				
				while(Queue[idx % n] == 0) {
					idx++;
				}
				
				sb.append(Queue[idx % n]);
				
				if(i != n-1)
					sb.append(", ");
				
				Queue[idx % n] = 0;
			}
			sb.append(">").append("\n");
			System.out.println(sb);
		
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void push(int n) {
		Queue[b] = n;
		b++;
	}

 
}
