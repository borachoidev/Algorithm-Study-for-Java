import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int dest;
	int weight;
	
	public Node(int dest, int weight) {
		// TODO Auto-generated constructor stub
		this.dest = dest;
		this.weight = weight;
	}
	 @Override
	 public int compareTo(Node o) {
	     return weight - o.weight;
	 }
}

public class Main {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//String[] s = br.readLine().split(" ");
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			List<Node>[] graph = new ArrayList[v];
			boolean[] check = new boolean[v];
			int[] dist = new int[v];
			
			for(int i=0; i<v; i++) {

				graph[i] = new ArrayList<Node>();
				dist[i] = Integer.MAX_VALUE;
			}
			
			int start = Integer.parseInt(br.readLine())-1;
			
			
			for(int i=0; i<e; i++) {
				//s = br.readLine().split(" ");
				st = new StringTokenizer(br.readLine());
				
				graph[Integer.parseInt(st.nextToken())-1].add(new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
			}
			
			PriorityQueue<Node> queue = new PriorityQueue<>();
		    
		    queue.add(new Node(start, 0));
		    dist[start] = 0;

		    while(!queue.isEmpty()){
		    	 Node curNode = queue.poll();
		           int cur = curNode.dest;

		        if(check[cur] == true) continue;
		        check[cur] = true;

		        for(Node node : graph[cur]){
		            if(dist[node.dest] > dist[cur] + node.weight){
		                dist[node.dest] = dist[cur] + node.weight;
		                queue.add(new Node(node.dest, dist[node.dest]));
		            }
		        }
		    }
			
			for(int i=0; i<v; i++) {
				if(dist[i] != Integer.MAX_VALUE)
					sb.append(dist[i]).append("\n");
				else
					sb.append("INF").append("\n");
			}
			System.out.println(sb);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
