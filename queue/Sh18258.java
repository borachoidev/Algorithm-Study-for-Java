import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static StringBuffer sb = new StringBuffer();
	public static int[] Queue;
	public static int f = 0;
	public static int b = 0;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			Queue = new int[n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				switch(st.nextToken()) {
				case "push":
					push(Integer.parseInt(st.nextToken()));
					break;
					
				case "pop":
					sb.append(pop()).append("\n");
					break;
				
				case "size":
					sb.append(size()).append("\n");
					break;
				
				case "empty":
					sb.append(empty()).append("\n");
					break;
					
				case "front":
					sb.append(front()).append("\n");
					break;
					
				case "back":
					sb.append(back()).append("\n");
					break;
				}
			}
			
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

	
	public static int pop() {
		int result;
		if(f == b)
			result = -1;
		else {	
			result = Queue[f];
			f++;
		}
		return result;
	}
	
	public static int size() {
		return b-f;
	}
	
	public static int empty() {
		return b-f==0?1:0;
	}
	
	public static int front() {
		if(empty() == 1)
			return -1;
		else
			return Queue[f];
	}
	
	public static int back() {
		if(empty() == 1)
			return -1;
		else
			return Queue[b-1];
	}
 
}
