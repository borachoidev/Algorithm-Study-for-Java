import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static StringBuffer sb = new StringBuffer();
	public static int t;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			t = Integer.parseInt(br.readLine());
			
			for(int i=0; i<t; i++) {
				int n = Integer.parseInt(br.readLine());
				
				if(n==0)
					sb.append(1).append(" ").append(0).append("\n");
				else if(n==1)
					sb.append(0).append(" ").append(1).append("\n");
				else {
					int[][] fib = new int[n+1][2];
					fib[0][0] = 1;
					fib[0][1] = 0;
					fib[1][0] = 0;
					fib[1][1] = 1;
					for(int j=2; j<=n; j++) {
						fib[j][0] = fib[j-1][0] + fib[j-2][0];
						fib[j][1] = fib[j-1][1] + fib[j-2][1];
					}
					sb.append(fib[n][0]).append(" ").append(fib[n][1]).append("\n");
				}
			}
			
			System.out.println(sb);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
