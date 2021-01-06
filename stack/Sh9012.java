import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static String[] stack;
	public static String[] tmpStack;
	public static StringBuffer sb = new StringBuffer();
	public static int size;
	public static int tsize;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			
			for(int i=0; i<n; i++) {
				String[] sarr = br.readLine().split("");
				
				stack = new String[50];
				tmpStack = new String[25];
				size = 0;
				tsize = 0;
				boolean flag = false;
				
				for(int j=0; j<sarr.length; j++) {
					String s = sarr[j];
					
					if(j==0 && s.equals(")")) {
						flag = true;
						sb.append("NO").append("\n");
						break;
					}
						
					if(j==sarr.length-1 && s.equals("(")) {
						flag = true;
						sb.append("NO").append("\n");
						break;
					}
					stack[size] = s;
					size++;
				}
				
				if(!flag) {
					for(int j=0; j<sarr.length; j++) {
						if(stack[size-1].equals(")")) {
							size--;
							tmpStack[tsize] = ")";
							tsize++;
						}
						else if(stack[size-1].equals("(")) {
							if(tsize <= 0) {
								tsize = 100;
								break;
							}
							else {
								tsize--;
								size--;
							}
							
						}
					}
					String result;
					if(size==0 && tsize==0)
						result = "YES";
					else
						result = "NO";
					sb.append(result).append("\n");
				}
				
			}
			System.out.println(sb);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 
}
