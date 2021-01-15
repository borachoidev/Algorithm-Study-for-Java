import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static StringBuffer sb = new StringBuffer();
	
	public static int[][] arr;
	public static int n;
	public static boolean[] check;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			int v = Integer.parseInt(s[2]);
			
			arr = new int[n+1][n+1];
			check = new boolean[n+1];
			
			for(int i=0; i<m; i++) {
				s = br.readLine().split(" ");
				arr[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
				arr[Integer.parseInt(s[1])][Integer.parseInt(s[0])] = 1;
			}
			
			dfs(v);
			
			sb.append("\n");
			check = new boolean[n+1];
			bfs(v);
			
			System.out.println(sb);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		check[start] = true;
		sb.append(start).append(" ");
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			for(int i=1; i<=n; i++) {
				if(arr[a][i]==1 && check[i]==false) {
					check[i]=true;
					queue.add(i);
					sb.append(i).append(" ");
				}
			}
		}
	}
	
	public static void dfs(int start) {
		check[start] = true;
		sb.append(start).append(" ");
		
		for(int i=1; i<=n; i++) {
			if(arr[start][i]==1 && check[i]==false) {
				dfs(i);
			}
		}
	}
	
}
