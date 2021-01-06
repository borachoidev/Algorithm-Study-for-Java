import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[][] arr;
	static int n;
	static int min = 100;
	static boolean[] check;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			check = new boolean[n];
			
			for(int i=0; i<n; i++) {
				String[] s = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			dfs(0, 0);
			
			System.out.println(min);
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dfs(int idx, int depth) {
			
		if(depth == n/2) {
			int result1 = 0;
			int result2 = 0;
			for(int i=0; i<n-1; i++) {
				for(int j=i+1; j<n; j++) {
					if(check[i] && check[j])
						result1 += arr[i][j] + arr[j][i];
					else if(!check[i] && !check[j])
						result2 += arr[i][j] + arr[j][i];
				}
			}
			
			if(Math.abs(result1-result2) < min) {

				min = Math.abs(result1-result2);
				if(min == 0) {
					System.out.println(min);
					System.exit(0);
				}
			}
			
			return;
		}
		
		for(int i=idx; i<n; i++) {
			if(!check[i]) {
				check[i] = true;
				dfs(i+1, depth+1);
				check[i] = false;
			}
		}
		
	}
}
