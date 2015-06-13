import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


class Count {

	public static <T> Set<List<Long>> powerSet(List<Long> originalSet) {
        Set<List<Long>> sets = new HashSet<List<Long>>();
        if (originalSet.isEmpty()) {
            sets.add(new ArrayList<Long>());
            return sets;
        }
        List<Long> list = new ArrayList<Long>(originalSet);
        Long head = list.get(0);
        List<Long> rest = new ArrayList<Long>(list.subList(1, list.size()));
        for (List<Long> set : powerSet(rest)) {
        	List<Long> newSet = new ArrayList<Long>();
            newSet.add((Long) head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		List<Long> primes = new ArrayList<Long>();
		int k = scan.nextInt();
		int t = scan.nextInt();
		
		for(int i=0;i<k;i++) {
			Long no = scan.nextLong();
			primes.add(no);
		}
		
		
		Set<List<Long>> powerSet = powerSet(primes);
		
		while((t--)!=0) {
		Long a = scan.nextLong();
		Long b = scan.nextLong();
		
		Long result = 0L;
		a=a-1;
		for(Long prime : primes) {
			result += (b/prime - a/prime);
		}
		
		for(List<Long> set : powerSet) {
			if(set.size()>1) {
				Long mul = 1L;
				for(Long number : set) {
					mul*= number;
					if(mul>b) 
						break;
				}
				if(mul>b) 
					continue;
				if(set.size()%2==0)
					result = (Long) (result - (b/mul - a/mul));
				else
					result = (Long) (result + (b/mul - a/mul));
			}
		}
		
		System.out.println(result);
		
		}
	}
}
