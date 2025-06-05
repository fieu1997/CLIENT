/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ai;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BERU
 */
public class khu2Manager {
    private static final List<khu2> list = new ArrayList<>();

	public static synchronized void add_list(khu2 d) {
		khu2Manager.list.add(d);
	}

	public static synchronized void remove_list(khu2 d) {
		khu2Manager.list.remove(d);
	}

	
}

