import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	
	public static StringBuffer sb = new StringBuffer();
	public static LinkedList<Integer> deque = new LinkedList<Integer>();
	public static int n;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			
			for(int i=1; i<=n; i++) {
				deque.addLast(i);
			}
			
			s = br.readLine().split(" ");
			
			
			int count = 0;
			for(int i=0; i<m; i++) {
				
				while(true) {	
					int idx = 0;
					for (int j = 0; j < deque.size(); j++) {
						if (deque.get(j) == Integer.parseInt(s[i])) {
							idx = j;
							break;
						}
					}				
					
					if(idx == 0) {
						deque.poll();
						break;
					}		
					else if(idx-0 < deque.size()-idx) {
						for(int j=0; j <idx-0; j++) {
							int val = deque.pollFirst();
							deque.addLast(val);
							count++;
						}
					}
					else {
						int val = deque.pollLast();
						deque.addFirst(val);
						count++;
					}
					//System.out.println("i = " + Integer.parseInt(s[i]) + " " + count + " " + idx);
						
				}
				
			}
			
			System.out.println(count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
 
}
