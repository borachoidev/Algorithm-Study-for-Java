import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int[] Queue;
	public static int f = 0;
	public static int b = 0;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			Queue = new int[2*n-1];
			
			for(int i=0; i<n; i++) {
				push(i+1);
			}
			
			while(b-f != 1) {
				if(f % 2 == 0) {
					f++;
					
				}
				else {
					Queue[b] = Queue[f];
					f++;
					b++;
				}
			}
			
			System.out.println(Queue[f]);
			
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
