import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
	
	public static StringBuffer sb = new StringBuffer();
	
	//public static int[][] arr;
	public static ArrayList<ArrayList<Integer>> arr;
	
	public static Queue<Integer> queue = new LinkedList<Integer>();
	public static int v;
	public static int e;
	public static int[] color;
	
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int k = Integer.parseInt(br.readLine());
			
			for(int i=0; i<k; i++) {
				String[] s = br.readLine().split(" ");
				v = Integer.parseInt(s[0]);
				e = Integer.parseInt(s[1]);

				arr = new ArrayList<ArrayList<Integer>>();
				
				for(int j=0; j<v; j++) {
					arr.add(new ArrayList<Integer>());
				}
				
				color = new int[v];
				
				for(int j=0; j<e; j++) {
					s = br.readLine().split(" ");
					int x = Integer.parseInt(s[0])-1;
					int y = Integer.parseInt(s[1])-1;
					
					arr.get(x).add(y);
					arr.get(y).add(x);
					
					//sb.append(x).append(y).append("\n");
						
				}
				
				for (int j = 0; j < v; j++) {
					if (color[j] == 0) {
						color[j] = 1;
						queue.add(j);
						bfs();
					}
				}
				
				boolean check = true;
				for(int j=0; j<v; j++) {
					for(int a=0; a<arr.get(j).size(); a++) {
						if(color[j] == color[arr.get(j).get(a)]) {
							check = false;
						}
							
					}
				}
				
				if(check)
					sb.append("YES\n");
				else
					sb.append("NO\n");
				
			}
			System.out.println(sb);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void bfs() {
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			int colors = color[v];
			
			for(int i=0; i<arr.get(v).size(); i++) {
				
				if(color[arr.get(v).get(i)] == 0) {
					color[arr.get(v).get(i)] = colors * -1;
					queue.add(arr.get(v).get(i));
				}
			}
		}
		
	}
	
	
}
