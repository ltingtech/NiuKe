package test;
import java.util.*;



public class Xiaomi2 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		HashMap<Integer, LinkedList> map = new HashMap<Integer, LinkedList>();
		HashMap<Integer, Integer> nodes = new HashMap<Integer, Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n - 1; i++) {
			int a1 = reader.nextInt();
			int a2 = reader.nextInt();
			set.add(a1);
			nodes.put(a2, 1);
			if (map.containsKey(a1)) {
				map.get(a1).add(a2);
			} else {
				LinkedList<Integer> next = new LinkedList<Integer>();
				next.add(a2);
				map.put(a1, next);
			}
		}
		int root = findroot(nodes, set);
		int h = getDepth(map, root);
		System.out.println(h);
	}

	public static int getDepth(HashMap<Integer, LinkedList> map, int cur) {
		int left = 0, right = 0;
		if (map.get(cur) == null) {
			return 1;
		} else {
			LinkedList<Integer> lk = map.get(cur);
			left = getDepth(map, lk.get(0));
			if (lk.size() > 1)
				right = getDepth(map, lk.get(1));
			return (left > right ? left : right) + 1;
		}

	}
	public static int findroot(HashMap<Integer, Integer> nodes,
			HashSet<Integer> set) {
		for (Integer m : set) {
			if (nodes.get(m) == null) {
				return m;
			}
		}
		return -1;
	}
}