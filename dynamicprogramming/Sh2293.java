import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int maxprofit;
	static int k;   
	static int n;    
	static int total = 0;
	static int[] arr;
	static int[] res;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			k = Integer.parseInt(s[1]);
			
			arr = new int[n + 1];
			res = new int[k + 1];
			res[0] = 1;
			
			for(int i=1; i<=n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				for (int j = arr[i]; j <= k; j++)
	                res[j] += res[j - arr[i]];
			}
			
			//coin(0, 0);
			
			System.out.println(res[k]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
//	public static void coin(int idx, int sum) {
//		
//		if(sum >= k) {
//			if(sum == k)
//				total++;
//			return;
//		}
//		
//		for(int i=idx; i<n; i++) {
//			coin(i, sum + arr[i]);
//		}
//	}
	
	
}
