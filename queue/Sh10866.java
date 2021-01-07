import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static StringBuffer sb = new StringBuffer();
	public static Deque<Integer> deque = new ArrayDeque<Integer>();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				switch(st.nextToken()) {
					case "push_front":
						deque.addFirst(Integer.parseInt(st.nextToken()));
						break;
					
					case "push_back":
						deque.addLast(Integer.parseInt(st.nextToken()));
						break;
						
					case "pop_front":
						if(deque.isEmpty())
							sb.append("-1\n");
						else
							sb.append(deque.pollFirst()).append("\n");
						break;
						
					case "pop_back":
						if(deque.isEmpty())
							sb.append("-1\n");
						else
							sb.append(deque.pollLast()).append("\n");
						break;
						
					case "size":
						sb.append(deque.size()).append("\n");
						break;
						
					case "empty":
						sb.append(deque.isEmpty()==true?"1\n":"0\n");
						break;
					
					case "front":
						if(deque.isEmpty())
							sb.append("-1\n");
						else
							sb.append(deque.getFirst()).append("\n");
						break;
						
					case "back":
						if(deque.isEmpty())
							sb.append("-1\n");
						else
							sb.append(deque.getLast()).append("\n");
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
