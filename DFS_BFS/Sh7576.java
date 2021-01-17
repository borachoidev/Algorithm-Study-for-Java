import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Location{
	int row, col;
	
	public Location(int row, int col) {
		// TODO Auto-generated constructor stub
		this.row = row;
		this.col = col;
	}
}

public class Main {
	
	public static StringBuffer sb = new StringBuffer();
	
	public static int[][] arr;
	public static int day = 0;
	public static boolean[][] check;
	public static Queue<Location> queue = new LinkedList<Location>();
	public static int n;
	public static int m;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
			arr = new int[m][n];
			check = new boolean[m][n];
			
			for(int i=0; i<m; i++) {
				s = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
					if(Integer.parseInt(s[j]) == 1) {
						queue.add(new Location(i,j));
						check[i][j] = true;
					}
					else if(Integer.parseInt(s[j]) == -1)
						check[i][j] = true;
						
				}
			}
			
			while(!queue.isEmpty()) {
				bfs();
			}
			
			boolean flag = false;
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(check[i][j] == false)
						flag = true;
				}
			}

			if(flag)
				System.out.println(-1);
			else
				System.out.println(day-1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void bfs() {
		day++;
		int[] xArr = {-1,0,1,0};
		int[] yArr = {0,1,0,-1};

		int size = queue.size();
		//System.out.println(size);
		for(int j=0; j<size; j++) {
			
			Location loc = queue.poll();
			int row = loc.row;
			int col = loc.col;
			
			for(int i=0; i<4; i++) {
				int x = row + xArr[i];
				int y = col + yArr[i];
				
				if(checkLocation(x,y)) {
					check[x][y] = true;
					queue.add(new Location(x,y));
					
				}
				
			}
		}
	}
	
	public static boolean checkLocation(int x, int y) {
		if(x < 0 || x >= m || y < 0 || y >= n)
			return false;
		if(check[x][y] == true)
			return false;
		
		return true;
	}
	
}
