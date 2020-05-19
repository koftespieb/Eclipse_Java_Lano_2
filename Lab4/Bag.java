import java.util.HashMap;

public class Bag<K> {
	private HashMap<K, Integer> map;

	public Bag() {
		map = new HashMap<K, Integer>();

	}

	public void add(K key) {
		if (!map.containsKey(key)) {
			map.put(key, 1);
		} else {
			map.put(key, map.get(key) + 1);
		}
	}

	public void add(K key, int i) {
		if (map.containsKey(key)) {
			i += map.get(key);
		}
		map.put(key, i);
	}

	public int getCount(K key) {
		if (map.containsKey(key)) {
			return map.get(key);
		} else {
			return -1;
		}

	}

	public void remove(K key, int i) throws Exception {
		if (map.containsKey(key)) {
			int count = map.get(key) - i;
			if (count < 0) {
				count = 0;
			}
			map.put(key, count);
		} else {
			throw new Exception("bag does not contain element " + key);
		}
	}
}
