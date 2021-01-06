import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		try {
			
			while(true) {
				
				String s = br.readLine();
				
				if(s.equals("."))
					break;
				
				char[] stack = new char[s.length()];
				int size = 0;
				boolean flag = false;
				
				for(char c : s.toCharArray()) {
					
					if(c == '(') {
						stack[size] = '(';
						size++;
					}
					else if(c == '[') {
						stack[size] = '[';
						size++;
					}
					else if(c == ')') {
						if(size <= 0 || stack[size-1] != '(') {
							sb.append("no").append("\n");
							flag = true;
							break;
						}
						else 
							size--;
							
					}
					else if(c == ']') {
						if(size <= 0 || stack[size-1] != '[') {
							sb.append("no").append("\n");
							flag = true;
							break;
						}
						else 
							size--;
					}
				}
				if(!flag) {
					if(size != 0)
						sb.append("no").append("\n");
					else
						sb.append("yes").append("\n");
				}
			}
			
			
			System.out.println(sb);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
 
}
