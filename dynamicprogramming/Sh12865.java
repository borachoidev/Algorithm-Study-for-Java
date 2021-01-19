import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int k;   
	static int n;    
	static int[] w;   
	static int[] p;  
	static int[][] arr;
	
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			k = Integer.parseInt(s[1]);
			
			arr = new int[n+1][k+1];
			for(int i=1; i<=n; i++) {
				for(int j=0; j<k+1; j++) {
					arr[i][j] = -1;
				}
			}
			
			w = new int[n+1]; 
			p = new int[n+1];
			
			for(int i=1; i<=n; i++) {  
				s = br.readLine().split(" ");
				w[i] = Integer.parseInt(s[0]);
				p[i] = Integer.parseInt(s[1]);
			}
			
			System.out.println(knapsack(n, k));; 
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	public static int knapsack(int i, int k) {
		if (i == 0)
			return 0;
		
		if (arr[i][k] == -1) {
			
			if(w[i] > k) {
				arr[i][k] = knapsack(i - 1, k);
			}
			else { 
				arr[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - w[i]) + p[i]);
			}
		}
		return arr[i][k];
	}
	
	
}
