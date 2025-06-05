/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeothapWeek;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BERU
 */
public class LeothapManager {
    private static final List<Leothap> list = new ArrayList<>();

	public static synchronized void add_list(Leothap d) {
		LeothapManager.list.add(d);
	}

	public static synchronized void remove_list(Leothap d) {
		LeothapManager.list.remove(d);
	}

	public static synchronized Leothap get_list(String name) {
		for (Leothap dungeon : LeothapManager.list) {
			if (dungeon.name_party.equals(name)) {
				return dungeon;
			}
		}
		return null;
	}
}

