package event_daily;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import ai.LinhCanh;
import client.Player;
import core.Manager;
import core.Service;
import core.Util;
import io.Message;
import map.LeaveItemMap;
import static map.LeaveItemMap.leave_vang;
import map.Map;
import map.MapService;
import map.Mob_in_map;
import map.Vgo;
import template.ItemTemplate3;
import template.MainObject;
import template.Member_ChienTruong1;

public class ChienTruong1 {
	private static ChienTruong1 instance;
	private HashMap<String, Member_ChienTruong1> list;
	private List<Member_ChienTruong1> BXH;
	private int status; // 0 sleep, 1 : register, 2 : start
	private int time;
	public int[] info_house;
	public List<LinhCanh> list_ai;
	public List<Mob_in_map> boss;
         

	public int getStatus() {
		return status;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int i) {
		this.time = i;
	}

	public static ChienTruong1 gI() {
		if (instance == null) {
			instance = new ChienTruong1();
			instance.init();
		}
		return instance;
	}

	private void init() {
		this.list = new HashMap<>();
		this.BXH = new ArrayList<>();
		this.status = 0;
		this.time = 0;
		list_ai = LinhCanh.init();
		this.boss = new ArrayList<>();
		//
	}

	public synchronized void update() {
		try {
			if (this.status == 1) {
				this.time--;
				if (this.time <= 0) {
					this.start();
				}
			} else if (this.status == 2) {
				this.time--;
				// event
				// if (this.time == 60 * 50) {
					// create_boss(10);
				// } else if (this.time == 60 * 40) {
					// create_boss(20);
				// }
				//
				if (this.time <= 0) { // end
					this.finish();
				}
			}
		} catch (IOException e) {
		}
	}

	public synchronized void open_register() throws IOException {
		if (this.status == 0) {
			Manager.gI().chatKTGprocess("Tiền Tài Đã Mở Đăng Ký");
			this.status = 1;
			this.time = 60*59;//time chờ đăng ký
		}
	}
	
	public synchronized void register(Player p) throws IOException {
		if (this.list.containsKey(p.name)) {
			Service.send_notice_box(p.conn, "Đã đăng ký rồi");
		} else {
			Member_ChienTruong1 temp = new Member_ChienTruong1();
			temp.name = p.name;
			temp.point = 0;
			temp.village = 0;
			temp.received = false;
			this.list.put(p.name, temp);
			Service.send_notice_box(p.conn, "Đăng ký thành công");
		}
	}

	private void start() throws IOException {
		if (this.status == 1) { // bắt đầu tính time 
			//Manager.gI().chatKTGprocess("Map Tiền Tài Đã Mở , hãy đến NPC Doubar Báo danh");
			this.BXH.clear();
			this.status = 2;
			this.time = 60 * 1; // time map chạy
			int init_house = this.list.size() / 40;
			init_house = init_house > 0 ? init_house : 1;
			this.info_house = new int[] {init_house, init_house, init_house, init_house
					// Map.get_map_by_id(56)[0].maxzone, Map.get_map_by_id(60)[0].maxzone,
					// Map.get_map_by_id(58)[0].maxzone, Map.get_map_by_id(54)[0].maxzone
			};
			//			
		}
	}


	private void finish() throws IOException {
		if (this.status == 2) {
			Manager.gI().chatKTGprocess("Map Tiền Tài Đã Kết Thúc");
			//
			for (Entry<String, Member_ChienTruong1> en : this.list.entrySet()) {
				// System.out.println(en.getKey() + " " + en.getValue().village);
				Player p0 = Map.get_player_by_name(en.getKey());
				if (p0 != null) {
					Vgo vgo = new Vgo();
					vgo.id_map_go = 1;
					vgo.x_new = 432;
					vgo.y_new = 354;
					p0.change_map(p0, vgo);
					MapService.change_flag(p0.map, p0, -1);
				}
			}
			for (int i = 0; i < boss.size(); i++) {
				boss.get(i).level = 10;
				boss.get(i).hp = 0;
				boss.get(i).is_boss_active = false;
				boss.get(i).isdie = true;
			}
			for (Entry<String, Member_ChienTruong1> en : this.list.entrySet()) {
				this.BXH.add(en.getValue());
			}
			this.BXH.sort(new Comparator<Member_ChienTruong1>() {
				@Override
				public int compare(Member_ChienTruong1 o1, Member_ChienTruong1 o2) {
					return o1.point > o2.point ? -1 : 1;
				}
			});
			//
			this.list.clear();
			this.status = 0;
			this.time = 0;
			this.info_house = null;
		}
	}

	

	

	public void send_info(Player p) throws IOException {
		this.update_time(p);
		for (int i = 2; i < 6; i++) {
			Message m = new Message(-94);
			m.writer().writeByte(i); //
			m.writer().writeByte(this.info_house[i - 2]); // total house
			m.writer().writeShort(total_p_of_house(i)); // total p
			m.writer().writeByte(1);
			p.conn.addmsg(m);
			m.cleanup();
		}
	}

	private int total_p_of_house(int i) {
		int result = 0;
		for (Entry<String, Member_ChienTruong1> en : this.list.entrySet()) {
			if (en.getValue().village == i) {
				Player p0 = Map.get_player_by_name(en.getKey());
				if (p0 != null && Map.is_map_chien_truong1(p0.map.map_id)) {
					result++;
				}
			}
		}
		return result;
	}

	private void update_time(Player p) throws IOException {
		Message m = new Message(-94);
		m.writer().writeByte(-1); //
		m.writer().writeByte(0);
		m.writer().writeShort(0);
		m.writer().writeByte(0);
		m.writer().writeLong(System.currentTimeMillis() - (60 * 60 - this.time) * 1000L);
		p.conn.addmsg(m);
		m.cleanup();
	}

	
	public Member_ChienTruong1 get_infor_register(String name) {
		return this.list.get(name);
	}

	public Member_ChienTruong1 get_bxh(String name) {
		for (int i = 0; i < this.BXH.size(); i++) {
			if (this.BXH.get(i).name.equals(name)) {
				if (i < 10) {
					return this.BXH.get(i);
				}
			}
		}
		return null;
	}

	public int get_index_bxh(Member_ChienTruong1 temp) {
		return this.BXH.indexOf(temp);
	}
}
