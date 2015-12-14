package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {

	/*
	 @ensures \result = (\forall Object x1,x2; map.getSet().contains(x1) && map.keySet().contains(x2) && x1 != x2; map.get(x1) != map.get(x2));
	 */
	public static <K, V> boolean isOneOnOne(Map<K, V> map) {
		boolean ans = true;
		for (K key : map.keySet()) {
			for (K key2 : map.keySet()) {
				if (!key.equals(key2)) {
					if (map.get(key).equals(map.get(key2)))
						ans = false;
				}
			}
		}
		return ans;
	}

	/*
	 @ ensures \result == (\forall Object y;
	 range.contains(y);
	 {
	 \exists Object x;
	 map.keySet().contains(x);
	 map.get(x).equals(y)
	 }
	 */
	public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
		boolean ans = true;
		for (K key : map.keySet()) {
			if (!range.contains(map.get(key)) || !isOneOnOne(map))
				ans = false;
		}
		return ans;
	}
	
	/*
	 @ ensures \result == (
	 \forall Object x;
	 map.keySet.contains(x)
	 {
	 	\result.get(map.get(x)).contains(x);
	 }
	 )
	 */
	public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
		HashMap<V, Set<K>> h = new HashMap<V, Set<K>>();
		for (K key : map.keySet()) {
			V v = map.get(key);
			Set <K> s = h.containsKey(map.get(key)) ? h.get(map.get(key)) : new HashSet<K>();
			s.add(key);
			h.put(v, s);
		}
		return h;
	}
	
	/*
	 @ requires MapUtil.isOneOnOne(map);
	 @ ensures \result.keyset.equals(map.values()) && \result.values().equals(map.keySet());
	 @ ensures (\forall Object x; map.values().contains(x); \result.get(map.get(x)).equals(x);
	 	
	 }
	 */
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		Map<V, K> ans = new HashMap<V, K>();
		if(isOneOnOne(map))
			for(K key : map.keySet()){
				ans.put(map.get(key), key);
			}
		return ans;
	}

	/*
	 @ensures \result == (\forall Object x; f.values().contains(x); g.keySet().contains(x));
	 * 
	 */
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
		boolean ans = true;
		for (V v : f.values()) {
			if (!g.containsKey(v)) ans = false;
		}
		return ans;
	}

	/*
	 @ requires compatible(f,g);
	 @ ensures (\forall Object x; f.keySet().contains(x); \result.keySet().contains(x) && \result.get(x).equals(g.get(f.get(x))));
	 */
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		Map<K, W> map = new HashMap<K, W>();
		if (compatible(f, g)) {
			for (K key : f.keySet()) {
				map.put(key, g.get(f.get(key)));
			}
		}
		if (map.size() == 0)
			map = null;
		return map;
	}
}
