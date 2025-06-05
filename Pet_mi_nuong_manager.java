package template;

import java.util.HashMap;
import java.util.Map;

public class Pet_mi_nuong_manager {
	public static final HashMap<String, Pet_mi_nuong> list = new HashMap<>();

	public static synchronized void add(String name, Pet_mi_nuong temp) {
		Pet_mi_nuong_manager.list.put(name, temp);
	}

	public static synchronized void remove(String name) {
		Pet_mi_nuong_manager.list.remove(name);
	}

	public static synchronized Pet_mi_nuong check(int n) {
		for (Map.Entry<String, Pet_mi_nuong> en : Pet_mi_nuong_manager.list.entrySet()) {
			Pet_mi_nuong temp = en.getValue();
			if (temp.index == n) {
				return temp;
			}
		}
		return null;
	}
}
