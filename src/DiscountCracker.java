import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


class DiscountCracker {

	public static void main(String args[]) {
		int t;
		Scanner scan = new Scanner(System.in);
		t = Integer.parseInt(scan.next());
		while((t--) != 0 ) {
			String first = scan.next();
			String next = scan.next();
			int m = Integer.parseInt(scan.next());
			Map<String, Set<String>> map = new HashMap<String, Set<String>>();
			while((m--) !=0 ) {
				String mapping = scan.next();
				String c1 = mapping.split("->")[0];
				String c2 = mapping.split("->")[1];
				Set<String> strs = map.get(c1);
				if(strs == null) {
					strs = new HashSet<String>();
					map.put(c1, strs);
				}
				strs.add(c2);
			}
			
			// Update Map
			for(String key : map.keySet()) {
				for(String key2 : map.keySet()) {
					if(!key.equals(key2)) {
						Set<String> strs = map.get(key2);
						if(strs.contains(key)) {
							strs.addAll(map.get(key));
						}
					}
				}
			}
			
//			for(String key: map.keySet()) {
//				System.out.println(key + map.get(key).toString());
//			}
			
			if(first.length() != next.length())
				System.out.println("NO");
			else {
				int i;
				for(i = 0; i< first.length(); i++ ) {
						String a = (String) first.subSequence(i, i+1);
						String b = (String) next.subSequence(i, i+1);
						if(!a.equals(b) && (map.get(a)==null || !map.get(a).contains(b))) {
							System.out.println("NO");
							break;
						}
				}
				if(i == first.length())
					System.out.println("YES");
			}
		}
	}
	
}
