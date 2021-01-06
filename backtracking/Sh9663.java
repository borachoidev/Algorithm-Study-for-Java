import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int[] arr;
	public static int count=0;
	public static int n;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			
			queen(0);
			
			System.out.println(count);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void queen(int depth) {
		if(depth==n) { // Leaf까지 도달했으므로 정답
			count++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			arr[depth] = i;
			if(possible(depth))
				queen(depth+1);
		}
		
	}
	
	public static boolean possible(int depth) {
		for(int i=0; i<depth; i++) {
			if(arr[depth] == arr[i]) // 같은 열에 위치할 경우
				return false;
			else if(Math.abs(depth-i)==Math.abs(arr[depth]-arr[i])) // 같은 대각선에 위치할 경우
				return false;
		}
		
		return true;
	}
 
}
