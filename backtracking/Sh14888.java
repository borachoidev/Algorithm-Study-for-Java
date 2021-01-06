import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static StringBuffer sb = new StringBuffer();
	public static int[] arr;
	public static int[] cal;
	public static int[] result;
	public static boolean[] check;
	public static int n;
	public static int max = -100000000;
	public static int min = 100000000;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			check = new boolean[n-1];
			
			String[] s = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			
			cal = new int[n-1];
			result = new int[n-1];
			
			s = br.readLine().split(" ");
			int k=0;
			for(int i=0; i<4; i++) {
				int val = Integer.parseInt(s[i]);
				for(int j=0; j<val; j++) {
					cal[k++] = i;
				}
			}
			
			 dfs(0); 
			 System.out.println(max); 
			 System.out.println(min);
			 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void dfs(int depth) {
		
		if(depth == n-1) {
			int res = arr[0];
			for(int i=0; i<n-1; i++) {
				if(result[i] == 0)
					res += arr[i+1];
				else if(result[i] == 1)
					res -= arr[i+1];
				else if(result[i] == 2)
					res *= arr[i+1];
				else
					res /= arr[i+1];
			}
			
			if(res > max)
				max = res;
			if(res < min)
				min = res;
			return;
		}
		
		for(int i=0; i<n-1; i++) {
			if(!check[i]) {
				
				check[i] = true;
				result[depth] = cal[i];
				dfs(depth+1);
				check[i] = false;
			}
		}
		
		return;
	}
	
 
}
