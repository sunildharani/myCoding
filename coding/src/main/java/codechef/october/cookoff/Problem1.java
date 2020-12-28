package codechef.october.cookoff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while(n-- > 0) {
			int l = Integer.parseInt(br.readLine());
			String line = br.readLine();
			if(l == 1) {
				System.out.println("NO");
				continue;
			}
			char[] a = line.substring(0,l-1).toCharArray();
			char[] b = line.substring(l-1).toCharArray();
			HashMap<Character,Integer> f1 = new HashMap<Character,Integer> ();
			HashMap<Character,Integer> f2 = new HashMap<Character,Integer> ();
			for(int i =0; i< a.length;i++) {
				if(f1.containsKey(a[i])) {
					f1.put(a[i], f1.get(a[i])+1);
				}else {
					f1.put(a[i], 1);
				}
			}
			f2.put(b[0], 1);
			boolean found = false;
			boolean valid = false;
			while(b.length <= (l+1)/2) {
				for(Map.Entry<Character,Integer> entry : f2.entrySet()) {
					if(f1.containsKey(entry.getKey()) && f1.get(entry.getKey()) >= f2.get(entry.getKey())) {
						valid = true;
					}else {
						break;
					}
				}
				if(valid) {
					found = isSubstring(a,b);
					if(found) {
						break;
					}else {
						char[] c = new char[a.length-1];
						char[] d = new char[b.length+1];
						for(int i = 0 ;i< c.length;i++) {
							c[i] = a[i];
						}
						char w = a[a.length-1];
						f1.put(w, f1.get(w)-1);
						if(f2.containsKey(w)) {
							f2.put(w, f1.get(w)+1);
						}else {
							f2.put(w, 1);
						}
						d[0] = a[a.length-1];
						for(int i = 1 ;i < d.length;i++) {
							d[i] = b[i-1];
						}
						a = c;
						b = d;
					}	
				}else {
					break;
				}
		   }
			if(valid && found) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
		br.close();

	}
	
	private static boolean isSubstring(char[] a , char[] b){
		boolean found = false;
		for(int i = 0; i<= a.length-b.length;i++) {
			    int k = i;
			    found = true;
				for(int j = 0; j< b.length;j++) {
					if(a[k] != b[j]) {
						found = false;
						break;
					}
					k++;
				}
				if(found) {
					return found;
				}
		}
		return found;
	}

}
