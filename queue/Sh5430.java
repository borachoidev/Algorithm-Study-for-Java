import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	public static StringBuffer sb = new StringBuffer();
	public static int n;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			n = Integer.parseInt(br.readLine());
			
			for(int i=0; i<n; i++) {
				Deque<Integer> deque = new ArrayDeque<Integer>();
				int f = 0;
				
				String s = br.readLine();
				int m = Integer.parseInt(br.readLine());
				String arr = br.readLine();
				
				arr = arr.substring(1, arr.length()-1);
				if(arr.length()!=0) {
					String[] sarr = arr.split(",");
					for(int j=0; j<m; j++) {
						deque.add(Integer.parseInt(sarr[j]));
					}
				}
				
				boolean flag = false;
				for(char c : s.toCharArray()) {
					//sb.append("c => ").append(c).append("\n");
					switch(c) {
					case 'R':
						if(f==0)
							f = deque.size();
						else
							f = 0;
						break;
				
					case 'D':
						if(deque.size()==0) {
							flag = true;
						}
						else {
							if(f==0)
								deque.pollFirst();
							else 
								deque.pollLast();
						}
						break;
					}
					if(flag)
						break;
				}
				
				if(flag) {
					sb.append("error\n");
				}
				else {
					sb.append("[");
					if(f==0) {
						if(deque.size() != 0) {
							while(deque.size()!=0) {
								sb.append(deque.pollFirst()).append(",");
							}
							sb.delete(sb.length()-1, sb.length());
						}
						
					}
					else {
						if(deque.size() != 0) {
							while(deque.size()!=0) {

								sb.append(deque.pollLast()).append(",");
							}
							sb.delete(sb.length()-1, sb.length());
						}
						
					}
					
					sb.append("]\n");
				}
				
			}
			System.out.println(sb);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
