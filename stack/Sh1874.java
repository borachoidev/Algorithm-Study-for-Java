import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int[] arr;
		int[] stack;
		int size = 0;
		int cursor = 0;
		
		try {
			
			int n = Integer.parseInt(br.readLine());
			arr = new int[n];
			stack = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			for(int i=1; i<=n; i++) {
				stack[size] = i;
				size++;
				sb.append("+").append("\n");
				
				if(i==n) {
					break;
				}
				
				while(true) {
					if(size > 0 &&stack[size-1] == arr[cursor]) {
						cursor++;
						size--;
						sb.append("-").append("\n");
					}
					else {
						break;
					}
				}
				
			}
			
			while(size > 0) {
				if(stack[size-1] == arr[cursor]) {
					cursor++;
					size--;
					sb.append("-").append("\n");
				}
				else {
					sb.delete(0, sb.toString().length());
					sb.append("NO");
					break;
				}
			}
			System.out.println(sb);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 
}
