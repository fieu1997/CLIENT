package core;

import BossHDL.BossManager;
import ai.LoanDau;
import ai.MobAi;
import ai.NhanBan;
import ai.PlayerPoints;
import ai.khu2;
import ai.khu2Manager;
import java.io.IOException;
import java.util.*;

import event.Event_1;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import client.Clan;
import client.Pet;
import client.Player;
import client.Squire;
import com.sun.management.VMOption;
import static core.GameSrc.Ratio_UpgradeItemStar;
import ev_he.Event_2;
import ev_he.Event_4;
import event_daily.ChiemThanhManager;
import event_daily.ChienTruong;
import event_daily.ChienTruong1;
import event_daily.DailyQuest;
import event_daily.CongNap;
import event_daily.Group_ld;
import event_daily.LoiDai2;
import event_daily.LoiDai;
import event_daily.LoiDaiManager;
import event_daily.MoLy;
import event_daily.NV_TinhTu;
import event_daily.Wedding;
import event_daily.*;
import io.Message;
import io.Session;
import java.io.File;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.lang.model.util.Elements.Origin;
import static junit.runner.Version.id;
import map.Dungeon;
import map.Map;
import map.MapService;
import map.Mob_in_map;
import map.Vgo;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import template.EffTemplate;
import template.Item3;
import template.Item47;
import template.ItemTemplate3;
import template.ItemTemplate4;
import template.ItemTemplate7;
import template.Level;
import template.Medal_Material;
import template.Member_ChienTruong;
import template.Member_ChienTruong1;
import template.Option;
import template.OptionItem;
import template.Option_pet;
import template.Part_fashion;
import template.Pet_di_buon;
import template.Pet_di_buon_manager;
import template.Pet_mi_nuong;
import template.Pet_mi_nuong_manager;
import template.TaiXiuPlayer;
import ai.Fusion;
import ai.Nbtd;
import ev_he.Event_tet;
import ev_he.Event_tet.MobNpc;
import ev_he.Farm;
import ev_he.Farm.MobFarm;
import ev_he.MobCay;
import event.Event_5;

import java.text.NumberFormat;
import map.DungeonManager;
import map.Eff_player_in_map;
import template.Mob_MoTaiNguyen;

import template.box_item_template;

public class MenuController {

    private static int testValue = 0;
    
    public static void request_menu(Session conn, Message m) throws IOException {
        byte idnpc = m.reader().readByte();
        //System.out.println("core.MenuController.request_menu()"+idnpc);
        if (idnpc == -43 || idnpc == -45 || idnpc == -48 || idnpc == -46) {
            Menu_ChangeZone(conn);
            return;
        }
//        cam de tu
//         if (!conn.p.isOwner && !(idnpc == -7 || idnpc == -49 || idnpc == -8|| idnpc == -4 || idnpc == -44|| idnpc == -3|| idnpc ==-42)) {     
//            return;
//        }

     // create menu per id npc
        String[] menu;
        switch (idnpc) {

            case (byte) 300: // 
                if (conn.vip >= 8) {
                    menu = new String[]{"Điểm Danh - Vip", "Hưỡng Dẫn", "Nâng Cấp - Vip", "Shop - Vip", "Tổng Nạp", "Thông Tin - Vip", "Shop NL Thần",};
                } else {
                    menu = new String[]{"Điểm Danh - Vip", "Hưỡng Dẫn", "Nâng Cấp - Vip", "Shop - Vip", "Tổng Nạp", "Thông Tin - Vip"};
                }
                break;
            case (byte) 301: // 128 = (8 + OFFSET) - 120
                menu = new String[]{"Góp Nguyên Liệu", "Hướng Dẫn", "Nhận Bánh", "Đổi bánh giày", "Ghép chữ Happy New Year", "Dâng bánh"};
                break;
            case -92: {
                menu = new String[]{"Cống nạp", "Nhận nhiệm vụ tinh tú", "Hủy nhiệm vụ tinh tú", "Trả nhiệm vụ tinh tú",
                    "Xem nhiệm vụ tinh tú"};
                break;
            }
            case -81: {
                menu = new String[]{"Đăng ký lôi đài", "Vào lôi đài", "Xem lôi đài", "Thông tin", "Xem điểm lôi đài", "Huong dan", "Tháo ngọc khảm", "Luyện đệ tử", "Huỷ đệ tử", "Xem BxH Loạn Đấu", "Nhận Thưởng"};
                break;
            }

            case 127: {
                if(conn.ac_admin != 100){
                    return;
                }
                menu = new String[]{(Manager.isNgocCoin ? "Đóng" : "Mở") + " Đổi Ngọc Ra Coin", (Manager.isShopVang ? "Đóng" : "Mở") + " Shop vàng", (Manager.isLockKC ? "Đóng" : "Mở") + " Vòng Quay Ngọc", (Manager.isLockTaiXiu ? "Đóng" : "Mở") + " Tài Xỉu", (Manager.isPk ? "Đóng" : "Mở") + " Chống Đồ Sát", "Kích Hoạt Tài Khoản", " Nạp Tiền", "Vàng Ngọc", "---------------------------", "Reset Nạp Tuần", "---------------------------", "Reset Account Status 2"};

                break;
            }

            case -12: { // tu tiên
                menu = new String[]{"Tu Tiên", "Đả Thông Kinh Mạch", "Luyện Thể", "Máp Tu Luyện", "Nhiệm Vụ Hằng Ngày"};
                break;
            }
            case -14: { // vua hùng
                menu = new String[]{"Trả Mỵ", "Xem BxH"};
                break;
            }

            case -11: { // tiểu long
                if (conn.ac_admin >= 10) {
                    menu = new String[]{"Đổi Chỉ Số Trang Bị", "Nâng Siêu Thần", "Nâng Mề Đay Siêu Cấp", "Leo Tháp", "Shop Nl Tháp", "Hưỡng Dẫn Đồ Thần", "test1", "test2", "test3", "test4", "test5", "test6"};
                } else {
                    menu = new String[]{"Đổi Chỉ Số Trang Bị", "Nâng Siêu Thần", "Nâng Mề Đay Siêu Cấp", "Leo Tháp", "Shop Nl Tháp", "Hưỡng Dẫn Đồ Thần"};
                }
                break;
            }

            case -31: {
                menu = new String[]{"Đăng ký lôi đài"};
                break;
            }

            case -3: { // Lisa
                menu = new String[]{"Mua bán", "Mở ly", "Thuế", "Nhận quà chiến trường",
                    "Nhận vé tặng ngọc", "Nhận Mốc Nạp"};
                break;
            }
            case -20: { // Lisa
                menu = new String[]{"Mua bán", "Mở ly", "Thuế", "Nhận quà chiến trường",
                    "Đóng"};
                break;
            }

            case -5: { // Hammer
                menu = new String[]{"Chiến Binh", "Sát Thủ", "Pháp Sư", "Xạ Thủ", "Chế tạo trang bị tinh tú", "Nâng cấp trang bị tinh tú", "Tháo Giáp Siêu Nhân ", "Tháo danh hiệu", "Tháo Kim Sắc Lệnh", "Tháo Ngọc Thạch", "Chế Tạo Giáp Siêu Nhân","Nâng cấp Giáp Siêu Nhân","Ghép Sách"};
                break;
            }
            case -77: // Alisama
            case -22: { // Hammer
                menu = new String[]{"Chiến Binh", "Sát Thủ", "Pháp Sư", "Xạ Thủ"};
                break;
            }
            case -4: {// Doubar
                menu = new String[]{"Chiến Binh", "Sát Thủ", "Pháp Sư", "Xạ Thủ", "Thông Tin Boss", "Đăng Ký Tiền Tài", "Vào Úp Tiền Tài", "Shop Vàng", "Shop TB Tinh Tú"};
                break;
            }
            case -33: { // da dich chuyen
                menu = new String[]{"Thành Phố Cảng", "Thành Phố Kho Báu", "Khu Mua Bán", "Sa Mạc", "Vực Lún",
                    "Nghĩa Địa Cát", "Suối Ma", "Hầm Mộ Tầng 1", "Hầm Mộ Tầng 3", "Rừng Cao Nguyên", "Vách Đá Cheo Leo",
                    "Lối Lên Thượng Giới", "Đường Xuống Lòng Đất", "Cổng Vào Hạ Giới", "Khu Vườn"};
                break;
            }
            case -55: { // da dich chuyen
                menu = new String[]{"Thành Phố Cảng", "Khu Mua Bán", "Mê Cung", "Mê Cung Tầng 3", "Thị Trấn Mùa Đông",
                    "Thung lũng băng giá", "Chân núi tuyết", "Đèo băng giá", "Vực thẳm sương mù", "Trạm núi tuyết",
                    "Thành Phố Kho Báu"};
                break;
            }
            case -10: { // da dich chuyen
                menu = new String[]{"Làng Sói Trắng", "Thành Phố Kho Báu", "Khu Mua Bán", "Hang Lửa", "Rừng Ảo Giác",
                    "Thung Lũng Kỳ Bí", "Hồ Kí Ức", "Bờ Biển", "Vực Đá", "Rặng Đá Ngầm", "Đầm Lầy", "Đền Cổ", "Hang Dơi"};
                break;
            }
            case -8: {
                menu = new String[]{"Cửa Hàng Tóc", "Điểm danh hằng ngày", "Đổi coin sang ngọc", "Đổi coin sang vàng", "Đổi Ngọc Ra Coin", "Đăng ký treo chống pk", "Tgian chống pk còn lại", (conn.p.type_exp == 0 ? "Bật" : "Tắt") + " nhận exp", "Đổi Mật Khẩu", "Cộng Tiềm Năng", "Xem Tiềm Năng"};
//                if (conn.p.type_exp == 1) {
//                    menu = new String[]{"Cửa Hàng Tóc", "Điểm danh hằng ngày", "Đổi coin sang ngọc", "Đổi coin sang vàng",
//                        "Đăng ký treo chống pk", "Tgian còn lại", "Tắt nhận exp"};
//                } else {
//                    menu = new String[]{"Cửa Hàng Tóc", "Điểm danh hằng ngày", "Đổi coin sang ngọc", "Đổi coin sang vàng",
//                        "Đăng ký treo chống pk", "Tgian còn lại", "Bật nhận exp"};
//                }
                break;
            }
            case -36: {
                menu = new String[]{"Cường Hóa Trang Bị", "Shop Nguyên Liệu", "Chuyển hóa", "Hợp nguyên liệu mề đay",
                    "Mề đay chiến binh", "Mề đay pháp sư", "Mề đay sát thủ", "Mề đay xạ thủ", "Nâng cấp mề đay",
                    "Đổi dòng sát thương", "Đổi dòng % sát thương", "Hợp ngọc", "Khảm ngọc", "Đục lỗ"};
                break;
            }
            case -44: {
                menu = new String[]{"Nhận Quà  GiftCode", "Tháo cánh", "Tháo cải trang", "Tháo mề đay", "Tháo mặt nạ",
                    "Tháo cánh thời trang", "Tháo áo choàng", "Tháo tóc thời trang", "Tháo vũ khí thời trang",
                    "Tháo tai nghe thời trang", "Nhận đồ đã mua", "Nhận quà top nap + mốc"};
//                menu = new String[]{"Nhận GiftCode", "Tháo cánh", "Tháo cải trang", "Tháo mề đay", "Tháo mặt nạ",
//                    "Tháo cánh thời trang", "Tháo áo choàng", "Tháo tóc thời trang", "Tháo vũ khí thời trang",
//                    "Tháo tai nghe thời trang"};             
                break;
            }
            case -32: {

                menu = new String[]{"Xem BXH Level", "Xem BXH Nạp", "Xem BXH bang", "Xem BXH chuyển sinh", "Xem BXH Tu Tiên", "Ông Thần Đồ Sát ", "Xem BXH Giàu Có", "Xem BxH Leo Tháp", "Xem BxH Thách Đấu"};
                break;
            }
            case -21: { // blackeye
                menu = new String[]{"Chiến Binh", "Sát Thủ", "Pháp Sư", "Xạ Thủ"};
                break;
            }
            case -90: { // keva
                menu = new String[]{"Shop", "Khu Phủ Sương Up", "Map Boss", "Quay Về Làng Phủ Sương", "Về Làng "};
                break;
            }
            case -7: {
                if (conn.user.contains("knightauto_hsr_")) {
                    menu = new String[]{"Rương giữ đồ", "Mở thêm ô hành trang", "Đăng ký tài khoản", "Chuyển Sinh", "Số lần chuyển sinh", "Đổi điểm chuyển sinh", "Fix Âm Exp", "Mởi Giới Hạn chuyển sinh"};
                } else {
                    menu = new String[]{"Rương giữ đồ", "Mở thêm ô hành trang", "Mật khẩu rương", "Chuyển Sinh", "Số lần chuyển sinh", "Đổi điểm chuyển sinh", "Fix Âm Exp", "Mởi Giới Hạn chuyển sinh"};
                }
                break;
            }
            case -34: { // cuop bien
                menu = new String[]{"Vòng xoay Vàng", "Vòng xoay ngọc", "Lịch sử", "Tài Xĩu"};
                break;
            }
            case -2: { // zoro
                if (conn.p.myclan != null) {
                    if (conn.p.myclan.mems.get(0).name.equals(conn.p.name)) {
                        menu = new String[]{"Quản lý bang", "Shop Icon", "Shop Bang"};
                    } else {
                        menu = new String[]{"Kho Bang", "Góp Vàng", "Góp Ngọc", "Chat Bang", "Rời bang"};
                    }
                } else {
                    menu = new String[]{"Đăng ký bang", "Thông tin"};
                }
                break;
            }
            case -19: { // 
                if (conn.p.myclan != null) {
                    if (conn.p.myclan.mems.get(0).name.equals(conn.p.name)) {
                        menu = new String[]{"Quản lý bang", "Shop Icon", "Shop Bang"};
                    } else {
                        menu = new String[]{"Kho Bang", "Góp Vàng", "Góp Ngọc", "Rời bang"};
                    }
                } else {
                    menu = new String[]{"Đăng ký bang", "Thông tin"};
                }
                break;
            }
            case -85: { // mr edgar
                menu = new String[]{"Báo Thù", "Thông tin"};
                break;
            }
            // case 555: { // tu tien
            // menu = new String[]{"Hưỡng dẫn","Tu Tiên","Xem Thông Tin"};
            // break;
            // }

            // case 556: { // kinh mạch
            // menu = new String[]{"Hưỡng dẫn","Đả Thông Kinh Mạch","Xem Thông Tin"};
            // break;
            // }
            // case 557: { // Luyện thể
            // menu = new String[]{"Hưỡng dẫn","Luyện Thể","Xem Thông Tin"};
            // break;
            // }
            case -42: { // pet
                menu = new String[]{"Chuồng thú", "Shop thức ăn", "Shop trứng", "Tháo pet"};
                break;
            }
            case -37: {
                menu = new String[]{"Vào Ngã Tư Tử Thần", "Giới thiệu", "BXH phó bản", "Đăng ký chiếm thành", "Vào chiếm thành",
                    "Xem Điểm Hiện Tại", "Nhận phần thưởng", "Trở thành hiệp sĩ"};
                break;
            }
            case -38:
            case -40: {
//                if (conn.p.dungeon != null && conn.p.dungeon.getWave() == 20) {
//                    menu = new String[]{"Tiếp tục chinh phục", "Bỏ cuộc", "Hướng dẫn"};
//                } else {
                Service.send_notice_box(conn, "Chưa có chức năng :(.");
                return;

            }
            case -41: {
                menu = new String[]{"Tạo cánh", "Nâng cấp cánh", "Kích hoạt cánh", "Tách cánh"};
                break;
            }
            case -49: { //menu_top
                menu = new String[]{"LIKE", "Shop Coin", "Kết Hôn", "Thông Tin Cá Nhân ", "Nhận quà hiếu chiến", "Khu Boss Chuyển Sinh", "Khu Boss "};
                break;
            }
            case -82: {
                if (conn.p.map.ld2 != null) {
                    LoiDaiManager.gI().GetMenuViews(conn, conn.p.map.ld2.idxGroup);
                }
                return;
            }
//            case -81: {
//                menu = new String[]{"Điểm Pk"};
//                break;
//            }
            case -69: {
                if (Manager.gI().event == 1) {
                    menu = new String[]{"Đổi hộp đồ chơi", "Hướng dẫn", "Đăng ký nấu kẹo", "Bỏ nguyên liệu vào nồi kẹo",
                        "Lấy kẹo đã nấu", "Đổi túi kẹo", "Đổi trứng phượng hoàng băng", "Đổi trứng yêu tinh",
                        "Đổi giày băng giá", "Đổi mặt nạ băng giá", "Đổi kẹo gậy", "Đổi gậy tuyết", "Đổi xe trượt tuyết",
                        "Đổi trứng khỉ nâu"};

                } else if (Manager.gI().event == 2) {
                    menu = new String[]{"Mâm trái cây", "Top sự kiện", "Đổi quà may mắn"};
                    send_menu_select(conn, -69, menu, (byte) Manager.gI().event);
                    return;
                    //menu = new String[]{"Coming soon", infoServer.Website};
                } else if (Manager.gI().event == 3) {
                    menu = new String[]{"Đổi bó sen trắng", "Đổi hoa sen hồng", "Đổi bó sen hồng", "Xem top", "Đổi con lân", "Đổi trứng khỉ nâu", "Đổi trứng tiểu yêu", "Đổi cánh thời trang"};
                    send_menu_select(conn, -69, menu, (byte) Manager.gI().event);
                    return;
                    //menu = new String[]{"Coming soon", infoServer.Website};

                } else {
                    Service.send_notice_box(conn, "Chưa có chức năng :(.");
                    return;
                    //menu = new String[]{"Coming soon", infoServer.Website};
                }
                break;
            }
            case -62: {
                if (Manager.gI().event == 1) {
                    menu = new String[]{"Tăng tốc nấu", "Hướng dẫn", "Thông tin", "Top Nguyên Liệu"};
                } else {
                    Service.send_notice_box(conn, "Chưa có chức năng :(.");
                    return;
                    //menu = new String[]{"Coming soon", infoServer.Website};
                }
                break;
            }
            case -66: {
                if (Manager.gI().event == 1) {
                    menu = new String[]{"Hoa tuyết", "Ngôi sao", "Quả châu", "Thiệp", "Top trang trí cây thông"};
                } else {
                    Service.send_notice_box(conn, "Chưa có chức năng :(.");
                    return;
                }
                //menu = new String[]{"Coming soon", infoServer.Website};
                break;
            }
            case -57: {
                menu = new String[]{"Mua bán"};
                break;
            }
            case -54: {
                menu = new String[]{"Đến Thành Phó Kho Báu"};
                break;
            }
            case -58: {
                menu = new String[]{"Mua lạc đà", "Bán đá quý", "Đồ thương nhân"};
                break;
            }
            case -59: {
                menu = new String[]{"Mua lạc đà", "Bán đá quý", "Đồ cướp"};
                break;
            }
            case -53: {
                menu = new String[]{" Đăng Ký Chiến trường", "Hướng dẫn", "Đổi đại bàng", "Vào Chiến Trường"};
                break;
            }

            default: {
                //System.out.println("core.MenuController.request_menu()"+idnpc);
                Service.send_notice_box(conn, "Chưa có chức năng :(.");
                return;
                //menu = new String[]{"Coming soon", infoServer.Website};
                //break;
            }
        }
        //
        send_menu_select(conn, idnpc, menu);
    }

    public static void processmenu(Session conn, Message m) throws IOException, SQLException {
        short idnpc = m.reader().readShort();
        @SuppressWarnings("unused")
        byte idmenu = m.reader().readByte();
        byte index = m.reader().readByte();
//        System.out.println("core.MenuController.processmenu() npc: "+idnpc);
//        System.out.println("core.MenuController.processmenu() id: "+idmenu);
//        System.out.println("core.MenuController.processmenu() idx: "+index);
        if (idnpc == -53) {
            Menu_Mr_Ballard(conn, idnpc, idmenu, index);
            return;
        }
        if (idnpc == -56) {
            send_menu_select(conn, 119, new String[]{"Thông tin", "Bảo hộ", "Hồi máu", "Tăng tốc"});
            return;
        }
        // Phân biệt giữa MobCay và MobMiNuong
        if (idnpc >= 30000 && idnpc <= 34999) {
            if (Event_2.getMob(idnpc) != null) {
                // Xử lý cho MobCay
                Menu_MobEvent(conn, idnpc, idmenu, index);
            } else if (Event_4.getMob(idnpc) != null) {
                // Xử lý cho MobMiNuong
                Menu_MobMiNuong(conn, idnpc, idmenu, index);
            }
            /*else if (Farm.getMob(idnpc, conn.p.index) != null) {
                Menu_Farm(conn, idnpc, idmenu, index);
            }*/

            return;
        }

        if (idnpc >= 2000 && idnpc <= 2500) {
            if (Farm.getMob(idnpc, conn.p.index) != null) {
                Menu_Farm(conn, idnpc, idmenu, index);
            }
            return;
        }
        if (idnpc >= 3000 && idnpc <= 3500) {
            if (Event_tet.getMob(idnpc) != null) {
                Menu_Tet(conn, idnpc, idmenu, index);
            }
            return;
        }

        switch (idnpc) {
            case -92: {
                if (index == 0) { // cong nap
                    if (CongNap.CAT[CongNap.NV_CONG_NAP] == 4 && CongNap.ID[CongNap.NV_CONG_NAP] == -1) {
                        Service.send_box_input_yesno(conn, 107,
                                "Vật phẩm cống nạp hôm nay là 1tr vàng bạn có muốn cống nạp?");
                    } else if (CongNap.CAT[CongNap.NV_CONG_NAP] == 4 && CongNap.ID[CongNap.NV_CONG_NAP] == -2) {
                        Service.send_box_input_yesno(conn, 107, "Vật phẩm cống nạp hôm nay là 5 ngọc bạn có muốn cống nạp?");
                    } else {
                        if (CongNap.CAT[CongNap.NV_CONG_NAP] == 4) {
                            Service.send_box_input_yesno(conn, 107,
                                    "Vật phẩm cống nạp hôm nay là x " + CongNap.NUM[CongNap.NV_CONG_NAP] + " "
                                    + ItemTemplate4.item.get(CongNap.ID[CongNap.NV_CONG_NAP]).getName()
                                    + " bạn có muốn cống nạp?");
                        } else {
                            Service.send_box_input_yesno(conn, 107,
                                    "Vật phẩm cống nạp hôm nay là s " + CongNap.NUM[CongNap.NV_CONG_NAP] + " "
                                    + ItemTemplate7.item.get(CongNap.ID[CongNap.NV_CONG_NAP]).getName()
                                    + " bạn có muốn cống nạp?");
                        }
                    }
                } else if (index == 1) {
                    NV_TinhTu.get_quest(conn.p);
                } else if (index == 2) {
                    NV_TinhTu.remove_quest(conn.p);
                } else if (index == 3) {
                    NV_TinhTu.finish_quest(conn.p);
                } else if (index == 4) {
                    if (conn.p.nv_tinh_tu[0] == -1) {
                        Service.send_notice_box(conn, "Chưa nhận nhiệm vụ");
                    } else {
                        NV_TinhTu.info_quest(conn.p);
                    }
                }
                break;
            }
            case 4: {
                Menu_DoiDongMeDaySTG(conn, index);
                break;
            }
            case 5: {
                Menu_DoiDongMeDaySTPT(conn, index);
                break;
            }

            case 113: {
                Menu_TaiXiu(conn, index);
                break;
            }

            case 114: {
                Menu_Wedding(conn, index);
                break;
            }
            case 115: {
                Menu_Thongtincanhan(conn, index);
                break;
            }

            case 116: {
                conn.p.chon_item3_index = -1; // Đặt giá trị mặc định

                int iditem = -1; // Biến để lưu chỉ số của item được khóa
                int isindex = 0;

                // Duyệt qua các trang bị trong túi
                for (int i = 0; i < conn.p.item.bag3.length; i++) {
                    Item3 it = conn.p.item.bag3[i];
                    if (it != null && it.islock) {
                        // So sánh chỉ số menu hiện tại với chỉ số của trang bị đang xét
                        if (isindex == index) {
                            iditem = i; // Lưu lại chỉ số trang bị được chọn
                            break;
                        }
                        isindex++; // Tăng chỉ số khi xét qua trang bị khóa tiếp theo
                    }
                }

                if (iditem != -1) {
                    // Nếu tìm thấy trang bị khóa, lưu lại chỉ số của nó
                    conn.p.chon_item3_index = iditem;
                    Item3 it = conn.p.item.bag3[iditem];
                    if (it != null) {
                        // Hiển thị thông báo xác nhận mở khóa trang bị
                        Service.send_box_input_yesno(conn, -10, "Mở khóa trang bị \"" + it.name + "\" Với 50k Ngọc ?");
                    }
                } else {
                    // Nếu không tìm thấy trang bị khóa, thông báo cho người chơi
                    Service.send_notice_box(conn, "Không tìm thấy trang bị đã chọn.");
                }
                break;
            }

            case 130: {

                break;
            }

            case 131: {

                break;
            }

            case 133: {

                break;
            }

            case 117: {
                Menu_ThaoKhamNgoc(conn, index);
                break;
            }
            case -54: {
                Menu_Mr_Haku(conn, index);
                break;
            }
            case -81: {
                Menu_Mrs_Oda(conn, index);
                break;
            }

            case -31: {
                Menu_Mrs_Oda(conn, index);
                break;
            }
            case -82: {
                if (conn.p.map.ld2 != null) {
                    Menu_Mrs_Oda_trong_LoiDai(conn, index);
                } else {
                    Menu_MissAnwen(conn, index);
                }
                break;
            }
            case 118: {
                Menu_View_LoiDai(conn, index);
                break;
            }

            case 210: {
                Menu_ThayDongCanh_percent(conn, index);
            }
            case 119: {
                Menu_Pet_di_buon(conn, index);
                break;
            }
            case -57: {
                Menu_Mr_Dylan(conn, index);
                break;
            }
            case -58: {
                Menu_Graham(conn, index);
                break;
            }
            case -59: {
                Menu_Mr_Frank(conn, index);
                break;
            }
            case 121: {
                Menu_TachCanh(conn, index);
                break;
            }
            case -3: { // Lisa
                Menu_Lisa(conn, index);
                break;
            }
            case 888: { // 
                Menu_BXHCLAN(conn, index);
                break;
            }
            case -20: {
                Menu_Emma(conn, index);
            }
            case -90: { // keva
                Menu_keva(conn, index);
                break;
            }
            case 600: {
                Menu_Langphusuongup(conn, index);
                break;
            }
            case 601: {
                Menu_Langphusuongboss(conn, index);
                break;
            }
            case -4: {
                Menu_Doubar(conn, index, idmenu);
                break;
            }
            case 345: {
                Menu_Doiaochoang(conn, index);
                break;
            }
            case 346: {
                Menu_Doiaochoang1(conn, index);
                break;
            }
            case 347: {
                Menu_Doiaochoang2(conn, index);
                break;
            }
            case 348: {
                Menu_Doiaochoang3(conn, index);
                break;
            }
            case 349: {
                Menu_Doiaochoang4(conn, index);
                break;
            }
            case 350: {
                Menu_Doiaochoang5(conn, index);
                break;
            }
            case 351: {
                Menu_Doiaochoang6(conn, index);
                break;
            }
            case 777: {
                Menu_Doiaochoang7(conn, index);
                break;
            }
            case -5: {
                Menu_Hammer(conn, index, idmenu);
                break;
            }
            case -22: {
                Menu_Alisama(conn, index, idmenu);
                break;
            }
            case -33: {
                Menu_DaDichChuyen33(conn, index);
                break;
            }
            case -55: {
                Menu_DaDichChuyen55(conn, index);
                break;
            }
            case -10: {
                Menu_DaDichChuyen10(conn, index);
                break;
            }

            case -128: {
                Menu_Nang_Skill(conn, index);
                break;
            }

            case (byte) 300: {
                Menu_NapVip(conn, index);
                break;
            }
            case (byte) 301: {
                Menu_OngDo(conn, index);
                break;
            }

            case 10: { //dc1
                Menu_dc1(conn, index);
                break;
            }

            case 11: { //dc2
                Menu_dc2(conn, index);
                break;
            }

            case 1000: {
                Menu_GiapSieuNhan(conn, index);
                break;
            }

            case 1001: {
                // Menu_Quest_Daily(conn, index);
                break;
            }
            case -77: {
                Menu_Alisama(conn, index);
                break;
            }
            case -8: {
                Menu_Zulu(conn, index);
                break;
            }
            case 126: {
                Menu_Admin(conn, index);
                break;
            }
            case 127: {
                Menu_lock(conn, index);
                break;
            }

            case 128: {
                Service.send_box_input_text(conn, (37 + index), "TN: " + conn.p.tiemnang + "", new String[]{"Nhập điểm của bạn vào đây....!"});
                break;
            }

            case -12: { // tieu tien nu
                Menu_tieutiennu(conn, index);
                break;
            }
            case -11: { // tieu long
                Menu_tieulong(conn, index, m);
                break;
            }
            case -13: { // mỵ nương
                Menu_minuong(conn, index);
                break;
            }
            case -14: { // Vua hùng
                Menu_vuahung(conn, index);
                break;
            }
            case -36: {
                Menu_PhapSu(conn, index);
                break;
            }
            case -44: {
                Menu_Miss_Anna(conn, index);
                break;
            }
            case -32: {
                SaveData.process();
                Menu_BXH(conn, index);
                break;
            }
            case -21: {
                Menu_Black_Eye(conn, index);
                break;
            }

            case -7: {
                Menu_Aman(conn, index);
                break;
            }
            case -34: {
                Menu_CuopBien(conn, index);
                break;
            }
            case 125: { // vxmm
                Menu_VXMM(conn, index);
                break;
            }
            case 132: { // vxmm
                Menu_VXKC(conn, index);
                break;
            }

            case -2: { // vxmm
                Menu_Zoro(conn, index);
                break;
            }
            case -19: { // vxmm
                Menu_Benjamin(conn, index);
                break;
            }
            case -85: { //
                Menu_Mr_Edgar(conn, index);
                break;
            }
            case 602: { // 
                Menu_op(conn, index);
                break;
            }
            case 555: { // tu tien
                Menu_tutien(conn, index);
                break;
            }

            case 556: { // kinh mạch
                Menu_kinhmach(conn, index);
                break;
            }

            case 557: { // luyện thể
                Menu_luyenthe(conn, index);
                break;
            }
            case 558: {

                Menu_DailyQuest(conn, index);

                break;
            }
            case 559: {

                DailyQuest.get_quest(conn.p, index);
                break;
            }

            case 560: {

                QuaTang.get_qua(conn, index);
                break;
            }

            case 129: {
                Menu_MocNap(conn, index);
                break;
            }

            case 124: {
                Service.revenge(conn, index);
                break;
            }
            case 123: {
                Menu_Dungeon_Mode_Selection(conn, index);
                break;
            }
            case 122: {
                Menu_Clan_Manager(conn, index);
                break;
            }
            case -42: {
                Menu_Pet_Manager(conn, index);
                break;
            }
            case -37: {
                Menu_PhoChiHuy(conn, index);
                break;
            }
            case -38: {
                MENU_Leothap(conn, index);
                break;
            }
            case -40: {
                Menu_LinhCanh(conn, index);
                break;
            }
            case -41: {
                Menu_TienCanh(conn, index);
                break;
            }
            case -49: {
                Menu_top(conn, index);
                break;
            }
//            case -81: {
//                Menu_diempk(conn, index);
//                break;
//            }
            case -69: {
                if (Manager.gI().event == 1) {
                    Menu_Event(conn, index);
                }
                if (Manager.gI().event == 2) {
                    Menu_MissSophia(conn, idnpc, idmenu, index);
                }
                if (Manager.gI().event == 3) {
                    Menu_MissSophia(conn, idnpc, idmenu, index);
                }
                break;
            }
            case -62: {
                if (Manager.gI().event == 1) {
                    Menu_NauKeo(conn, index);
                }
                break;
            }
            case -66: {
                if (Manager.gI().event == 1) {
                    Menu_CayThong(conn, index);
                }

                break;
            }
            case 120: {

                break;
            }

            case 603: {
                conn.p.selectedClanIndex = index;
                send_menu_select(conn, 604, new String[]{"Thông Tin", "Xem Thành Viên"});
                System.out.println("Selected clan index: " + index);

                break;
            }

            case 604: {
                if (conn.p.selectedClanIndex != -1) { // chọn or chưa

                    if (conn.p.selectedClanIndex >= 0 && conn.p.selectedClanIndex < BXH.BXH_clan.size()) {
                        conn.p.selectedClan = BXH.BXH_clan.get(conn.p.selectedClanIndex);

                        if (index == 0) { // Thông Tin
                            conn.p.selectedClan.clan_process(conn, m, 19);
                        } else if (index == 1) { // Xem Thành Viên
                            conn.p.selectedClan.clan_process(conn, m, 13);
                        } else {
                            Service.send_notice_box(conn, "Tùy chọn không hợp lệ!");
                        }

                    }
                } else {
                    Service.send_notice_box(conn, "Bạn chưa chọn bang!");
                }
                break;
            }

            case 605: {

                Menu_showClan(conn, index);

                break;
            }

            case -91: {
                Menu_Khac(conn, idmenu, index);
                break;
            }
            case -101: {
                Menu_Krypton(conn, idmenu, index);
                break;
            }
            case -103: {

                break;
            }

            case 110: {
                if (conn.p.it_change_op != null) {
                    Menu_ChangeOptionItem(conn, index);
                }
                break;
            }
            case 112: {
                conn.p.it_change_op_index = index;
                send_menu_select(conn, 110, new String[]{"Đổi loại sát thương", "Buff thêm điểm"});
                break;
            }
            case 111: {
                Item3 it_change = null;
                for (int i = 0; i < conn.p.item.wear.length; i++) {
                    if (conn.p.item.wear[i] != null) {
                        if (index == 0) {
                            it_change = conn.p.item.wear[i];
                            break;
                        }
                        index--;
                    }
                }
                if (it_change != null) {
                    //
                    Item3 it_new = new Item3();
                    it_new.id = it_change.id;
                    it_new.name = it_change.name;
                    it_new.clazz = it_change.clazz;
                    it_new.type = it_change.type;
                    it_new.level = it_change.level;
                    it_new.icon = it_change.icon;
                    it_new.op = new ArrayList<>();
                    for (int i = 0; i < it_change.op.size(); i++) {
                        it_new.op.add(new Option(it_change.op.get(i).id, it_change.op.get(i).getParam(0)));
                    }
                    it_new.color = it_change.color;
                    it_new.part = it_change.part;
                    it_new.tier = it_change.tier;
                    it_new.islock = it_change.islock;
                    it_new.time_use = it_change.time_use;
                    it_new.expiry_date = it_change.expiry_date;

                    conn.p.it_change_op = it_new;
                    //
                    List<String> list1 = new ArrayList<>();
                    for (int i = 0; i < it_change.op.size(); i++) {
                        OptionItem optionItem = OptionItem.get(it_change.op.get(i).id);
                        list1.add(optionItem.getName() + " "
                                + ((optionItem.getIspercent() == 1) ? (it_change.op.get(i).getParam(it_change.tier) / 100)
                                : it_change.op.get(i).getParam(it_change.tier)));
                    }
                    String[] list = new String[list1.size()];
                    for (int i = 0; i < list1.size(); i++) {
                        list[i] = list1.get(i);
                    }
                    send_menu_select(conn, 112, list);
                }
                break;
            }
            // buff đồ

            case 607: {

                conn.p.chon_option = index; // Lưu chỉ số đã chọn
                Service.send_box_input_text(conn, 45, "Đổi Chỉ Số", new String[]{"Param"});
                break;
            }
            case 608: {

                conn.p.chon_option = index; // Lưu chỉ số đã chọn
                Service.send_box_input_text(conn, 46, "Đổi Loại Chỉ Số", new String[]{"id Option"});
                break;
            }
            case 609: {
                conn.p.chon_option = index; // Lưu chỉ số đã chọn
                deleteOption(conn, conn.p.chon_item3_index, index);
                break;
            }

            case 606: {
                Item3 it_change = null;
                int selectedIndex = -1;
                for (int i = 0; i < conn.p.item.bag3.length; i++) {
                    if (conn.p.item.bag3[i] != null) {
                        if (index == 0) {
                            it_change = conn.p.item.bag3[i];
                            selectedIndex = i; // Lưu chỉ số của mục đã chọn
                            break;
                        }
                        index--;
                    }
                }
                if (it_change != null) {
                    Item3 it_new = new Item3();
                    it_new.id = it_change.id;
                    it_new.name = it_change.name;
                    it_new.clazz = it_change.clazz;
                    it_new.type = it_change.type;
                    it_new.level = it_change.level;
                    it_new.icon = it_change.icon;
                    it_new.op = new ArrayList<>();
                    for (int i = 0; i < it_change.op.size(); i++) {
                        it_new.op.add(new Option(it_change.op.get(i).id, it_change.op.get(i).getParam(0)));
                    }
                    it_new.color = it_change.color;
                    it_new.part = it_change.part;
                    it_new.tier = it_change.tier;
                    it_new.islock = it_change.islock;
                    it_new.time_use = it_change.time_use;
                    conn.p.chon_item3 = it_new;
                    conn.p.chon_item3_index = selectedIndex; // Lưu chỉ số của mục đã chọn

                    List<String> list1 = new ArrayList<>();
                    for (int i = 0; i < it_change.op.size(); i++) {
                        OptionItem optionItem = OptionItem.get(it_change.op.get(i).id);
                        list1.add(optionItem.getName() + " "
                                + ((optionItem.getIspercent() == 1)
                                ? (it_change.op.get(i).getParam(it_change.tier) / 100)
                                : it_change.op.get(i).getParam(it_change.tier)));
                    }
                    String[] list = list1.toArray(new String[list1.size()]);
                    send_menu_select(conn, 607, list);
                }
                break;
            }

            case 610: {
                byte mucCuoc = (byte) (index + 1); // 1: 5000, 2: 15000, 3: 50000
                int soVangCuoc = 0;
                switch (mucCuoc) {
                    case 1:
                        soVangCuoc = 5000;
                        break;
                    case 2:
                        soVangCuoc = 15000;
                        break;
                    case 3:
                        soVangCuoc = 30000;
                        break;
                }

                if (conn.p.vang < soVangCuoc) {
                    Service.send_notice_box(conn, "Bạn không đủ vàng để thách đấu.");
                    break;
                }
                conn.p.vang_td = soVangCuoc;
                // Tìm người chơi mục tiêu từ tên đã lưu
                Player p0 = Map.get_player_by_name(conn.p.name_td);
                p0.vang_td = soVangCuoc;
                // Gửi lời mời thách đấu tới người chơi mục tiêu
                if (p0 != null && p0.conn != null) {
                    m = new Message(68);
                    m.writer().writeByte(0); // Loại yêu cầu: Gửi lời mời
                    m.writer().writeUTF(conn.p.name); // Tên người gửi
                    m.writer().writeShort(soVangCuoc); // Số vàng cược
                    p0.conn.addmsg(m);
                    m.cleanup();
                }
                break;
            }

            case 611: { // Xử lý menu Thu hoạch và Thông tin
                Mob_MoTaiNguyen temp_mob = conn.p.myclan.get_mo_tai_nguyen(conn.p.chon_mob);
                if (temp_mob == null) {
                    Service.send_notice_box(conn, "Không tìm thấy mỏ tài nguyên.");
                    return;
                }

                if (index == 0) { // Thu hoạch
                    int reward = temp_mob.diem_thuong;

                    switch (temp_mob.name_monster) {
                        case "Mỏ Vàng":
                            temp_mob.clan.update_vang(reward); // Cộng vàng vào clan
                            Service.send_notice_nobox_white(conn, "Clan Bạn nhận được " + reward + " vàng");
                            break;
                        case "Mỏ Ngọc":
                            temp_mob.clan.update_ngoc(reward); // Cộng ngọc vào clan
                            Service.send_notice_nobox_white(conn, "Clan Bạn nhận được " + reward + " ngọc");
                            break;
                        case "Mỏ Tri Thức":
                            temp_mob.clan.update_exp(reward); // Cộng exp vào clan
                            Service.send_notice_nobox_white(conn, "Clan Bạn nhận được " + reward + " exp");
                            break;
                    }

                    temp_mob.diem_thuong = 0; // Reset điểm thưởng sau khi thu hoạch
                    //Service.send_box_input_yesno(conn, (byte) 132, "Xác nhận thu hoạch " + reward + " " + temp_mob.name_monster + "?");

                } else if (index == 1) { // Thông tin
                    int currentPoints = temp_mob.diem_thuong;
                    Service.send_notice_box(conn, "Số lượng " + temp_mob.name_monster + " đang tích lũy là: " + currentPoints + " điểm.");
                } else {
                    Service.send_notice_box(conn, "Đã xảy ra lỗi");
                }
                break;
            }

            default: {
                Service.send_notice_box(conn, "Đã xảy ra lỗi");
                break;
            }
        }
    }

    private static void Menu_Mr_Ballard(Session conn, int idNPC, byte idmenu, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }
        switch (idmenu) {
            case 0: {
                switch (index) {
                    case 0: { // dang ky
                        if (ChienTruong.gI().getStatus() == 1) {
                            ChienTruong.gI().register(conn.p);
                        } else {
                            Service.send_notice_box(conn, "Không trong thời gian diễn ra");
                        }
                        break;
                    }
                    case 1: {
                        String s = "Đăng ký tại NPC Mr. Ballard ở map Hang Lửa trước thời gian bắt đầu 45 phút";
                        s += "Phí tham gia 2 ngọc hoặc 500.000 vàng";
                        s += "Người chơi phải từ level 40 trở lên";
                        s += "Cách chơi :";
                        s += " Người chơi được ngẫu nhiên chia đều làm 4 phe, khi gần đến giờ người chơi sẽ được chuyển đến map tập trung .";
                        s += "Đến đúng giờ diễn ra sự kiện , map tập trung sẽ mở cửa để đi sang các map khác.";

                        s += "Mỗi phe sẽ có một map tập trung của phe mình và ít nhất 1 map nhà chính , điều này tùy thuộc vào số người đăng ký . Tối đa 25 map";

                        s += "Ví dụ : tổng số người đăng ký là 40 người - mỗi phe 10 người - thì mỗi phe sẽ sở hữu 1 nhà chính . Nếu tổng số người đăng ký là 80 người - mỗi phe 20 người - thì mỗi phe sẽ sở hữu 2 nhà chính.";

                        s += "\nTại mỗi map nhà chính chỉ có thể cho phép 40 người vào cùng 1 lượt và chia đều 10 người mỗi phe. Nghĩa là tại mỗi map nhà chính bất kỳ chỉ có thể vào được 10 người trong cùng 1 phe.";
                        s += "\nTại mỗi map nhà chính sẽ có 10 lính canh , 10 lính canh này sẽ đánh tất cả những người nào khác phe của nó";
                        s += "\nNhững map nhà chính sẽ được nối với 1 map chung , tại map chung phút thứ 5 và phút thứ 10 sẽ xuất hiện Boss Xà Nữ, nếu Boss thứ nhất ở phút thứ 5 đầu tiên đến phút thứ 10 vẫn chưa bị chết thì vẫn xuất hiện Boss thứ 2. Đánh chết boss Xà Nữ sẽ được điểm chiến trường";

                        s += "\n4. Điều kiện chiến thắng :";
                        s += "Nếu chưa hết 60 phút mà đã có 3 phe sập hết nhà chính, chỉ còn lại 1 phe còn nhà chính thì phe đó là phe thắng cuộc, sự kiện sẽ kết thúc. Phần thưởng sẽ là tổng số ngọc đăng ký của tất cả các phe chia đều cho những người còn sống trong phe thắng cuộc.";
                        s += " Khi hết 60 phút mà chưa có phe nào chiến thắng thì phần thưởng sẽ là ngọc đăng ký chia đều cho tất cả những người còn sống trong đấu trường.";
                        s += "Người chơi nhớ vào NPC Lisa hoặc Emma để nhận quà";

                        s += "Điểm chiến trường";
                        s += " Cách kiếm điểm chiến trường gồm";
                        s += "Tiêu diệt một người chơi khác phe : 1 điểm";
                        s += "Giết quái hoặc một lính canh khác phe : 2 điểm";
                        s += "Tiêu diệt một nhà khác phe bất kì : 20 điểm";
                        s += "Sử dụng item chiến trường : 10 điểm";
                        s += "Đánh chết Boss Xà Nữ : 30 điểm";
                        Service.send_notice_box(conn, s);
                        break;
                    }
                    case 3: {
                        if (ChienTruong.gI().getStatus() == 2) {
                            if (conn.p.time_use_item_arena > System.currentTimeMillis()) {
                                Service.send_notice_box(conn,
                                        "Chờ sau " + (conn.p.time_use_item_arena - System.currentTimeMillis()) / 1000 + " s");
                                return;
                            }
                            Member_ChienTruong info = ChienTruong.gI().get_infor_register(conn.p.name);
                            if (info != null) {
                                conn.p.time_use_item_arena = System.currentTimeMillis() + 250_000;
                                Vgo vgo = new Vgo();
                                switch (info.village) {
                                    case 2: { // lang gio
                                        vgo.id_map_go = 55;
                                        vgo.x_new = 224;
                                        vgo.y_new = 256;
                                        MapService.change_flag(conn.p.map, conn.p, 2);
                                        break;
                                    }
                                    case 3: { // lang lua
                                        vgo.id_map_go = 59;
                                        vgo.x_new = 240;
                                        vgo.y_new = 224;
                                        MapService.change_flag(conn.p.map, conn.p, 1);
                                        break;
                                    }
                                    case 4: { // lang set
                                        vgo.id_map_go = 57;
                                        vgo.x_new = 264;
                                        vgo.y_new = 272;
                                        MapService.change_flag(conn.p.map, conn.p, 4);
                                        break;
                                    }
                                    default: { // 5 lang anh sang
                                        vgo.id_map_go = 53;
                                        vgo.x_new = 276;
                                        vgo.y_new = 246;
                                        MapService.change_flag(conn.p.map, conn.p, 5);
                                        break;
                                    }
                                }
                                conn.p.change_map(conn.p, vgo);
                            } else {
                                Service.send_notice_box(conn, "Chưa đăng ký");
                            }
                            // Vgo vgo = new Vgo();
                            // vgo.id_map_go = 61;
                            // vgo.x_new = 432;
                            // vgo.y_new = 354;
                            // conn.p.change_map(conn.p, vgo);
                        } else {
                            Service.send_notice_box(conn, "Không trong thời gian diễn ra");
                        }
                        break;
                    }
                    case 2: {
                        if (conn.p.pointarena < 5000) {
                            Service.send_notice_box(conn, "Phải cần tối thiểu 5000 điểm tích lũy chiến trường để có thể đổi trứng đại bàng.");
                        } else if (conn.p.item.get_bag_able() < 1) {
                            Service.send_notice_box(conn, "Cần tối thiểu 1 ô trống để có thể đổi.");
                        } else {
                            try (Connection connection = SQL.gI().getConnection(); Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM `history_doi_dai_bang` WHERE `user` = '" + conn.user + "' AND `time` >= DATE_SUB(NOW(), INTERVAL 1 WEEK);")) {
                                if (rs.next()) {
                                    Service.send_notice_box(conn, "Trong vòng 1 tuần 1 tài khoản chỉ có thể đổi 1 lần.");
                                    return;
                                } else {
                                    int last_point = conn.p.pointarena;
                                    short iditem = 3269;
                                    Item3 itbag = new Item3();
                                    itbag.id = iditem;
                                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                                    itbag.op = new ArrayList<>();
                                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                                    itbag.tier = 0;
                                    itbag.islock = false;
                                    itbag.time_use = 0;
                                    conn.p.item.add_item_bag3(itbag);
                                    conn.p.pointarena -= 1200;
                                    conn.p.item.char_inventory(3);
                                    String query
                                            = "INSERT INTO `history_doi_dai_bang` (`user`, `name_player`, `last_point` , `point_arena`) VALUES ('"
                                            + conn.user + "', '" + conn.p.name + "', '" + last_point + "', '" + conn.p.pointarena + "')";
                                    if (st.executeUpdate(query) > 0) {
                                        connection.commit();
                                    }
                                    List<box_item_template> ids = new ArrayList<>();
                                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        }
                        break;

                    }
                    default:
                        Service.send_notice_box(conn, "Chức năng đang được hoàn thiện.");
                        break;
                }
                break;
            }
            case 1: {
                Service.send_notice_box(conn, "Chức năng đang được hoàn thiện.");
                break;
            }
            //  }
        }

    }

    private static void Menu_MissSophia(Session conn, int idNPC, byte idmenu, byte index) throws IOException {
//        System.out.println("core.MenuController.Menu_MissSophia() id: "+idmenu);
//        System.out.println("core.MenuController.Menu_MissSophia() idx: "+index);
//        System.out.println("core.MenuController.Menu_MissSophia() ev: "+Manager.gI().event);
        if (idmenu == 2 && Manager.gI().event == 2) {
            switch (index) {
                case 0: {
                    if (conn.p.level < 40) {
                        Service.send_notice_box(conn, "Level quá thấp.");
                        return;
                    }
                    if (conn.p.item.get_bag_able() < 4) {
                        Service.send_notice_box(conn, "Hành trang đầy");
                        return;
                    }
                    if (conn.p.item.total_item_by_id(4, 141) < 1 && (!Manager.BuffAdminMaterial || conn.ac_admin < 4)) {
                        Service.send_notice_box(conn, "Thiếu " + template.ItemTemplate4.item.get(141).getName());
                        return;
                    }
                    for (int i = 254; i <= 258; i++) {
                        if (conn.p.item.total_item_by_id(4, i) < 1 && (!Manager.BuffAdminMaterial || conn.ac_admin < 4)) {
                            Service.send_notice_box(conn, "Thiếu " + template.ItemTemplate4.item.get(i).getName());
                            return;
                        }
                    }

                    conn.p.item.remove(4, 141, 1);
                    for (int i = 254; i <= 258; i++) {
                        conn.p.item.remove(4, i, 1);
                    }
                    List<box_item_template> ids = new ArrayList<>();

                    List<Integer> it7 = new ArrayList<>(java.util.Arrays.asList(0, 1, 4, 8, 9, 10, 11, 12, 13, 14));
                    List<Integer> it7_vip = new ArrayList<>(java.util.Arrays.asList(33, 346, 347, 349));
                    List<Integer> it4 = new ArrayList<>(java.util.Arrays.asList(2, 5, 61, 67, 269));
                    List<Integer> it4_vip = new ArrayList<>(java.util.Arrays.asList(131, 123, 132, 133, 52, 235, 147));
                    for (int i = 0; i < Util.random(1, 5); i++) {
                        int ran = Util.random(100);
                        if (ran < 0) {
                            short id = Util.random(it7, new ArrayList<>()).shortValue();
                            short quant = (short) Util.random(2, 5);
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        } else if (ran < 2) {
                            short idsach = (short) Util.random(4577, 4585);
                            ids.add(new box_item_template(idsach, (short) 1, (byte) 3));
                            conn.p.item.add_item_bag3_default(idsach, 0, false);
                        } else if (ran < 6) {
                            short idsach = (short) 4762;
                            ids.add(new box_item_template(idsach, (short) 1, (byte) 3));
                            conn.p.item.add_item_bag3_default(idsach, Util.random(10, 20), true);
                        } else if (ran < 14) {
                            short id = (short) Util.random(46, 246);
                            short quant = (short) 1;
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        } else if (ran < 24) {
                            short id = (short) Util.random(417, 464);
                            short quant = (short) Util.random(3);
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        } else if (ran < 41) {
                            short id = Util.random(it7_vip, new ArrayList<>()).shortValue();
                            short quant = (short) Util.random(1, 2);
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        } else if (ran < 57) {
                            short id = Util.random(it4_vip, new ArrayList<>()).shortValue();
                            short quant = (short) Util.random(1, 2);
                            ids.add(new box_item_template(id, quant, (byte) 4));
                            conn.p.item.add_item_bag47(id, quant, (byte) 4);
                        } else if (ran < 77) {
                            short id = Util.random(it4, new ArrayList<>()).shortValue();
                            short quant = (short) Util.random(2, 5);
                            ids.add(new box_item_template(id, quant, (byte) 4));
                            conn.p.item.add_item_bag47(id, quant, (byte) 4);
                        } else {
                            short id = Util.random(it7, new ArrayList<>()).shortValue();
                            short quant = (short) Util.random(2, 5);
                            ids.add(new box_item_template(id, quant, (byte) 7));
                            conn.p.item.add_item_bag47(id, quant, (byte) 7);
                        }
                    }
                    ev_he.Event_2.add_caythong(conn.p.name, 1);
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    break;
                }
                case 1: {
                    send_menu_select(conn, 120, ev_he.Event_2.get_top());
                    break;
                }
                case 2: {
                    if (conn.p.item.get_bag_able() < 1) {
                        Service.send_notice_box(conn, "Hành trang đầy");
                        return;
                    }
                    if (conn.p.item.total_item_by_id(4, 123) < 5) {
                        Service.send_notice_box(conn, "Cần tối thiểu 5 chuông vàng");
                        return;
                    }
                    List<box_item_template> ids = new ArrayList<>();
                    conn.p.item.remove(4, 123, 5);
                    List<Integer> it = new ArrayList<>(java.util.Arrays.asList(4612, 4632, 4633, 4634, 4635));
                    List<Integer> it4 = new ArrayList<>(java.util.Arrays.asList(299, 205, 207));
                    if (Util.random(100) < 60) {
                        short id = Util.random(it4, new ArrayList<>()).shortValue();
                        short quant = (short) Util.random(1, 3);
                        ids.add(new box_item_template(id, quant, (byte) 4));
                        conn.p.item.add_item_box47(id, quant, (byte) 4);
                    } else {
                        short id = Util.random(it, new ArrayList<>()).shortValue();
                        ids.add(new box_item_template(id, (short) 1, (byte) 3));
                        conn.p.item.add_item_bag3_default(id, Util.random(5, 7), true);
                    }

                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    break;
                }
                default:
                    Service.send_notice_box(conn, "Chưa có chức năng ev2!");
                    break;
            }
        } else if (idmenu == 3 && Manager.gI().event == 3) {
            switch (index) {
                case 0: {
                    Service.send_box_input_text(conn, 25, "Đổi bó sen trắng", new String[]{"30 sen trắng + 100k vàng"});
                    break;
                }
                case 1: {
                    Service.send_box_input_text(conn, 26, "Đổi hoa sen hồng", new String[]{"10 sen trắng + 25k vàng"});
                    break;
                }
                case 2: {
                    Service.send_box_input_text(conn, 27, "Đổi bó sen hồng", new String[]{"5 sen hồng + 100 ngọc"});
                    break;
                }
                case 3: {
                    send_menu_select(conn, 120, ev_he.Event_3.get_top());
                    break;
                }
                case 4: {
                    if (conn.p.get_ngoc() < 100 || conn.p.item.total_item_by_id(4, 304) < 10) {
                        Service.send_notice_box(conn, "Cần tối thiểu 100 ngọc và 10 bông sen hồng để đổi!");
                        return;
                    }
                    if (conn.p.item.get_bag_able() < 1) {
                        Service.send_notice_box(conn, "Không đủ ô trống!");
                        return;
                    }
                    conn.p.update_ngoc(-100);
                    conn.p.item.remove(4, 304, 10);
                    Item47 itbag = new Item47();
                    itbag.id = 246;
                    itbag.quantity = (short) 100;
                    itbag.category = 4;
                    conn.p.item.add_item_bag47(4, itbag);
                    conn.p.item.char_inventory(5);

                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", new short[]{246}, new int[]{100}, new short[]{4});
                    break;
                }
                case 5: {
                    if (conn.p.get_ngoc() < 200 || conn.p.item.total_item_by_id(4, 304) < 50) {
                        Service.send_notice_box(conn, "Cần tối thiểu 200 ngọc và 50 bông sen hồng để đổi!");
                        return;
                    }
                    if (conn.p.item.get_bag_able() < 1) {
                        Service.send_notice_box(conn, "Không đủ ô trống!");
                        return;
                    }
                    conn.p.update_ngoc(-200);
                    conn.p.item.remove(4, 304, 50);
                    short iditem = 3616;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = false;
                    itbag.time_use = 0;
                    itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 15;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);

                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    break;
                }
                case 6: {
                    if (conn.p.get_ngoc() < 200 || conn.p.item.total_item_by_id(4, 304) < 50) {
                        Service.send_notice_box(conn, "Cần tối thiểu 200 ngọc và 50 bông sen hồng để đổi!");
                        return;
                    }
                    if (conn.p.item.get_bag_able() < 1) {
                        Service.send_notice_box(conn, "Không đủ ô trống!");
                        return;
                    }
                    conn.p.update_ngoc(-200);
                    conn.p.item.remove(4, 304, 50);
                    short iditem = 4761;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = false;
                    itbag.time_use = 0;
                    itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 15;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);

                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    break;
                }
                case 7: {
                    if (conn.p.get_ngoc() < 500 || conn.p.item.total_item_by_id(4, 304) < 50) {
                        Service.send_notice_box(conn, "Cần tối thiểu 500 ngọc và 50 bông sen hồng để đổi!");
                        return;
                    }
                    if (conn.p.item.get_bag_able() < 1) {
                        Service.send_notice_box(conn, "Không đủ ô trống!");
                        return;
                    }
                    conn.p.update_ngoc(-500);
                    conn.p.item.remove(4, 304, 50);
                    short iditem = 4642;
                    Item3 itbag = new Item3();
                    itbag.id = iditem;
                    itbag.name = ItemTemplate3.item.get(iditem).getName();
                    itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                    itbag.type = ItemTemplate3.item.get(iditem).getType();
                    itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                    itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                    itbag.op = new ArrayList<>();
                    itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                    itbag.color = ItemTemplate3.item.get(iditem).getColor();
                    itbag.part = ItemTemplate3.item.get(iditem).getPart();
                    itbag.tier = 0;
                    itbag.islock = false;
                    itbag.time_use = 0;
                    itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 30;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(5);

                    List<box_item_template> ids = new ArrayList<>();
                    ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                    break;
                }
                default:
                    Service.send_notice_box(conn, "Chưa có chức năng ev3!");
                    break;
            }
        } else {
            Service.send_notice_box(conn, "menu: " + idmenu + "  ev: " + Manager.gI().event);
        }

    }

    private static void Menu_MobEvent(Session conn, int idmob, byte idmenu, byte index) throws IOException {
        if (idmenu == 2) {
            if (index != 0) {
                return;
            }
            if (conn.p.level < 40) {
                Service.send_notice_box(conn, "Cần lên level 40 để có thể chơi sự kiện.");
                return;
            }
            ev_he.MobCay mob = ev_he.Event_2.getMob(idmob);
            if (mob == null || !mob.map.equals(conn.p.map)) {
                Message m2 = new Message(17);
                m2.writer().writeShort(-1);
                m2.writer().writeShort(idmob);
                conn.addmsg(m2);
                m2.cleanup();
                Service.send_notice_box(conn, "Không tìm thấy");
                return;
            }
            if (!(mob.map.equals(conn.p.map) && Math.abs(mob.x - conn.p.x) < 150 && Math.abs(mob.y - conn.p.y) < 150)) {
                Service.send_notice_box(conn, "Khoảng cách quá xa.\nNếu thực sự ở gần hãy thử load lại map.");
                return;
            }
            if (mob.Owner != null) {
                Service.send_notice_box(conn, "Đã có người khác hái quả.");
                return;
            }
            if (conn.p.item.get_bag_able() < 1) {
                Service.send_notice_nobox_white(conn, "Hành trang đầy.");
                return;
            }
            if (conn.p.item.total_item_by_id(4, 252) < 1) {
                Service.send_notice_nobox_white(conn, "Hãy mua giỏ hái quả để chứa.");
                return;
            }
            conn.p.item.remove(4, 252, 1);
            mob.setOwner(conn.p);
            short id = (short) Util.random(254, 259);
            conn.p.item.add_item_bag47(id, (short) 1, (byte) 4);
            conn.p.item.char_inventory(4);
            Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", new short[]{id}, new int[]{1}, new short[]{4});
            //Service.send_notice_box(conn, "Nhận quả: "+mob.nameOwner);
        }
    }

    private static void Menu_Krypton(Session conn, byte idmenu, byte index) throws IOException {
        if (idmenu == 0)//nâng mề dùng đá Krypton
        {
            GameSrc.UpgradeMedal(conn, index);
        } else if (idmenu == 1) {
            GameSrc.UpgradeItemStar(conn, index);
        }
        conn.p.id_Upgrade_Medal_Star = -1;
    }

    private static void Menu_Khac(Session conn, byte idmenu, byte index) throws IOException {
        if (idmenu == 0) {
            switch (index) {
                case 0: {
                    if (conn.p.item.total_item_by_id(4, 52) > 0) {
                        MoLy.show_table_to_choose_item(conn.p);
                    } else {
                        Service.send_notice_box(conn, "Không đủ vé mở trong hành trang");
                    }
                    break;
                }
                case 1: {
                    String[] menu = new String[]{"Vòng xoay Vàng", "Vòng xoay ngọc", "Lịch sử", "Tài Xĩu"};
                    MenuController.send_menu_select(conn, -34, menu);
                    break;
                }
                case 2: {
                    Service.send_notice_box(conn, "Bạn đang có " + conn.p.hieuchien + " Điểm Pk.");
                    break;
                }
                case 3: {
                    if (conn.p.map.ld2 != null) {
                        Menu_Mrs_Oda_trong_LoiDai(conn, (byte) 0);
                    } else {
                        if (Pet_mi_nuong.checkMy(conn)) {
                            return;
                        }
                        if (!conn.p.my_store_name.isEmpty()) {
                            Service.send_notice_box(conn, "Đang Bán Đi đâu em");
                            return;
                        }
                        if (conn.p.item.wear[11] != null && (conn.p.item.wear[11].id == 3599 || conn.p.item.wear[11].id == 3593 || conn.p.item.wear[11].id == 3596)) {
                            Service.send_notice_box(conn, "Bạn không thể về làng nhanh khi đang mặc loại giáp liên quan đến chức năng buôn");
                            return;
                        }
                        Vgo vgo = new Vgo();
                        vgo.id_map_go = 1;
                        vgo.x_new = 432;
                        vgo.y_new = 354;
                        conn.p.change_map(conn.p, vgo);
                    }
                    break;
                }
                case 4: {
                    conn.p.isDropMaterialMedal = !conn.p.isDropMaterialMedal;
                    Service.send_notice_box(conn, "Rơi nguyên liệu mề đay đã " + (conn.p.isDropMaterialMedal ? "bật" : "tắt"));
                    break;
                }
                case 5: {
                    if (conn.p.map.ld2 != null) {
                        LoiDaiManager.gI().GetMenuViews(conn, conn.p.map.ld2.idxGroup);
                    } else {
                        Service.send_notice_box(conn, "Bạn chỉ có thể thao tác khi đang ở trong map lôi đài");
                    }
                    break;
                }
                case 6: {
                    conn.p.isShowMobEvents = !conn.p.isShowMobEvents;
                    Service.send_notice_box(conn, "Đã " + (conn.p.isShowMobEvents ? "bật" : "tắt") + " hiển thị cây sự kiện");
                    break;

                }
                case 7: {
                    conn.p.iseffMedal = !conn.p.iseffMedal;
                    Service.send_notice_box(conn, "Hiệu Ứng mề đay đã " + (conn.p.iseffMedal ? "bật" : "tắt"));
                    break;
                }
            }
        }

    }

    private static void Menu_View_LoiDai(Session conn, byte index) throws IOException {
        Service.send_notice_box(conn, "Chức năng chưa hoàn thiện");
        //LoiDaiManager.gI().JoinMap(conn.p, index);
    }

    private static void Menu_Mrs_Oda_trong_LoiDai(Session conn, byte index) throws IOException {
        if (conn.p.map.ld2 == null) {
            return;
        }
        switch (index) {
            case 0: {
                if (conn.p.map.ld2.pl_1 != null && conn.p.map.ld2.pl_2 != null && (conn.p.map.ld2.pl_1.index == conn.p.index || conn.p.map.ld2.pl_2.index == conn.p.index)) {
                    Service.send_notice_box(conn, "Bạn Không thể Thực hiện hành động này");
                    return;
                }
                Vgo vgo = new Vgo();
                vgo.id_map_go = 1;
                vgo.x_new = 432;
                vgo.y_new = 354;
                conn.p.change_map(conn.p, vgo);

                break;
            }
            case 1: {
                LoiDaiManager.gI().Info(conn);
                break;
            }
            case 2: {
                LoiDaiManager.gI().GetGroup(conn.p.map.ld2.idxGroup).InfoGroup(conn);
                break;
            }
            case 3: {
                LoiDaiManager.gI().GetGroup(conn.p.map.ld2.idxGroup).GetRewarded(conn);
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chức năng chưa hoàn thiện");
//                if(conn.p.map.ld2.pl_1!=null && conn.p.map.ld2.pl_2!=null && (conn.p.map.ld2.pl_1.id == conn.p.id || conn.p.map.ld2.pl_2.id == conn.p.id)){
//                    Service.send_notice_box(conn, "Bạn Không thể Thực hiện hành động này");
//                    return;
//                }
//                LoiDaiManager.gI().JoinMapPVP(conn.p,conn.p.map.ld2.idxGroup, index-1);
                break;
            }
        }
    }

    private static void Menu_Mrs_Oda(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }
        if (conn.p.point_active.length < 3) {
            int a0 = conn.p.point_active[0];
            int a1 = conn.p.point_active[1];
            conn.p.point_active = new int[]{a0, a1, 0};
        }
//        if (index >= 0 && index <= 5) {
//            Service.send_notice_box(conn, "Chưa có chức năng :(");
//            return;
//        }
        switch (index) {
            case 0: {
                LoiDaiManager.gI().JoinGroup(conn.p);
                break;
            }
            case 1: {
                LoiDaiManager.gI().JoinMap(conn.p);
                break;
            }
            case 2: {
                Service.send_notice_box(conn, "Chưa có chức năng.");
//                String[] smenu = new String[LoiDaiManager.Group_entrys.length];
//                int lv = 65;
//                for(int i=0;i<LoiDaiManager.Group_entrys.length;i++){
//                    smenu[i] = "Nhóm "+lv+" - "+(lv+9);
//                    lv+=10;
//                }
//                send_menu_select(conn, 118, smenu);
                break;
            }
            case 3: {
//                String notice = "Hiện tại : \n";
//                switch (LoiDai.state) {
//                    case 0: {
//                        notice += "thời gian đăng ký còn " + (LoiDai.time_state) + "s nữa\n";
//                        notice += "Danh sách đăng ký : \n" + LoiDai.get_list_register();
//                        break;
//                    }
//                    case 1: {
//                        notice += "thời gian diễn ra lôi đài được " + (0 - LoiDai.time_state) + "s";
//                        break;
//                    }
//                    case 2: {
//                        notice += LoiDai.get_notice_break_time();
//                        break;
//                    }
//                }
//                Service.send_notice_box(conn, notice);
                LoiDaiManager.gI().Info(conn);
                break;
            }
            case 4: {
                Service.send_notice_box(conn, "Điểm lôi đài hiện tại: " + LoiDaiManager.gI().GetDiemLD(conn.p.index));
                break;
            }
            case 5: {
                String s = "Lôi đài bắt đầu mở đăng kí vào lúc 18h00, và đóng đăng kí vào lúc 18h28.";
                s += "\n18h30 bắt đầu giao chiến.";
                s += "\nCó 10 vòng đấu, mỗi vòng 3p.";
                s += "\nNghỉ 1p giữa các vòng.";
                s += "\nKết thúc lôi đài người giữ top1 hãy vào lôi đài để nhận quà.";
                s += "\nThời gian nhận quà là từ 20h đến 23h59.";
                s += "\nLưu ý: khi đã có tên trong lôi đài, mà lever nhân vật thay đổi dẫn đến việc không còn nằm trong nhóm đã đăng kí ban đầu thì có thể không nhận được quà và ghép trận";
                Service.send_notice_box(conn, s);
                break;
            }
            case 6: {
                conn.p.list_thao_kham_ngoc.clear();
                for (int i = 0; i < conn.p.item.wear.length; i++) {
                    Item3 it = conn.p.item.wear[i];
                    if (it != null) {
                        short[] b = conn.p.item.check_kham_ngoc(it);
                        boolean check = false;
                        if ((b[0] != -2 && b[0] != -1) || (b[1] != -2 && b[1] != -1) || (b[2] != -2 && b[2] != -1)) {
                            check = true;
                        }
                        if (check) {
                            conn.p.list_thao_kham_ngoc.add(it);
                        }
                    }
                }
                String[] list_show = new String[]{"Trống"};
                if (conn.p.list_thao_kham_ngoc.size() > 0) {
                    list_show = new String[conn.p.list_thao_kham_ngoc.size()];
                    for (int i = 0; i < list_show.length; i++) {
                        list_show[i] = conn.p.list_thao_kham_ngoc.get(i).name;
                    }
                }
                MenuController.send_menu_select(conn, 117, list_show);
                break;
            }
            case 7: {
                // if ((conn.p.squire != null && conn.p.squire.level > conn.p.level)) {
                // Service.send_notice_box(conn, "Sư phụ level yếu hơn đệ thì luyện cái gì ?\n"
                // + "Lv Đệ : " + conn.p.squire.level + "");
                // return;
                // }
                Fusion fusion = new Fusion();
                if (conn.p.squire != null && fusion.isFusion(conn.p) == true) {
                    Service.send_notice_box(conn, "Tách Hợp thể Trước");
                    return;
                }

                if (conn.p.squire != null) {
                    conn.p.squire.switchToSquire(conn.p);
                } else {
                    Service.send_box_input_yesno(conn, -127, "Bạn có muốn nhận đệ tử với giá 10000 ngọc?");
                }
                break;
            }
            case 8: {
                //   Service.send_notice_box(conn," Sắp ra mắt");
                if (conn.p.squire != null) {
                    Service.send_box_input_yesno(conn, -124, "Hủy đệ tử sẽ mất hết trang bị đang mặc, bạn chắc muốn hủy?");
                } else {
                    Service.send_notice_box(conn, "Chưa có đệ tử");
                }
                break;
            }
            case 9: {
                LoanDauRanking(conn);
                break;
            }

            case 10: {
                if (conn.p != null) {
                    PlayerPoints.loadPlayerPointsFromFile(conn.p);
                    LoanDau.NhanQua(conn.p);
                }
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Pet_di_buon(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }
        switch (index) {
            case 0: {
                String notice = null;
                if (conn.p.pet_di_buon != null && conn.p.pet_di_buon.item.size() > 0) {
                    notice = "%s " + ItemTemplate3.item.get(3590).getName() + "\n";
                    notice += "%s " + ItemTemplate3.item.get(3591).getName() + "\n";
                    notice += "%s " + ItemTemplate3.item.get(3592).getName() + "\n";
                    int n1 = 0, n2 = 0, n3 = 0;
                    for (int i = 0; i < conn.p.pet_di_buon.item.size(); i++) {
                        if (conn.p.pet_di_buon.item.get(i) == 3590) {
                            n1++;
                        } else if (conn.p.pet_di_buon.item.get(i) == 3591) {
                            n2++;
                        } else {
                            n3++;
                        }
                    }
                    notice = String.format(notice, n1, n2, n3);
                } else {
                    notice = "Trống";
                }
                Service.send_notice_box(conn, notice);
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                if (conn.p.get_ngoc() > 5) {
                    conn.p.pet_di_buon.update_hp(conn.p, 100);
                } else {
                    Service.send_notice_box(conn, "Không đủ 5 ngọc");
                }
                break;
            }
            case 3: {
                if (conn.p.get_ngoc() > 5) {
                    conn.p.pet_di_buon.update_speed(conn.p);
                } else {
                    Service.send_notice_box(conn, "Không đủ 5 ngọc");
                }
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Mr_Frank(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }
        if (conn.p.map.map_id != 17) {
            Service.send_notice_box(conn, "Nhầm rồi e ơi!");
            return;
        }
        switch (index) {
            case 0: {
                Service.send_box_UI(conn, 39);
                break;
            }
            case 1: {
                if (conn.p.pet_di_buon != null && Math.abs(conn.p.pet_di_buon.x - conn.p.x) < 75
                        && Math.abs(conn.p.pet_di_buon.y - conn.p.y) < 75 && conn.p.item.wear[11] != null
                        && conn.p.item.wear[11].id == 3593) {
                    //
                    int vang_recei = 0;
                    for (int i = 0; i < conn.p.pet_di_buon.item.size(); i++) {
                        if (conn.p.pet_di_buon.item.get(i) == 3590) {
                            vang_recei += 50_000;
                        } else if (conn.p.pet_di_buon.item.get(i) == 3591) {
                            vang_recei += 75_000;
                        } else if (conn.p.pet_di_buon.item.get(i) == 3592) {
                            vang_recei += 100_000;
                        }
                    }
                    if (vang_recei > 0) {
                        conn.p.update_vang(vang_recei);
                        conn.p.item.char_inventory(5);
                        //
                        Message mout = new Message(8);
                        mout.writer().writeShort(conn.p.pet_di_buon.index);
                        for (int i = 0; i < conn.p.map.players.size(); i++) {
                            Player p0 = conn.p.map.players.get(i);
                            if (p0 != null) {
                                p0.conn.addmsg(mout);
                            }
                        }
                        mout.cleanup();
                        //
                        Pet_di_buon_manager.remove(conn.p.pet_di_buon.name);
                        conn.p.pet_di_buon = null;
                        Service.send_notice_box(conn, "Nhận được " + vang_recei + " vàng!");
                        if (conn.p.nv_tinh_tu[0] == 30 && conn.p.nv_tinh_tu[1] < conn.p.nv_tinh_tu[2]) {
                            conn.p.nv_tinh_tu[1]++;
                        }
                    } else {
                        Service.send_notice_box(conn, "Chưa cướp được gì cả, thật kém cỏi!");
                    }
                } else {
                    Service.send_notice_box(conn, "Ta không thấy con vật đi buôn của ngươi");
                }
                break;
            }
            case 2: {
                Item3 itbag = new Item3();
                itbag.id = 3593;
                itbag.clazz = ItemTemplate3.item.get(3593).getClazz();
                itbag.type = ItemTemplate3.item.get(3593).getType();
                itbag.level = ItemTemplate3.item.get(3593).getLevel();
                itbag.icon = ItemTemplate3.item.get(3593).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(3593).getOp());
                itbag.color = 5;
                itbag.part = ItemTemplate3.item.get(3593).getPart();
                itbag.tier = 0;
                itbag.islock = true;
                itbag.time_use = 0;
                // thao do
                if (conn.p.item.wear[11] != null && conn.p.item.wear[11].id != 3593 && conn.p.item.wear[11].id != 3599
                        && conn.p.item.wear[11].id != 3596) {
                    Item3 buffer = conn.p.item.wear[11];
                    conn.p.item.wear[11] = null;
                    conn.p.item.add_item_bag3(buffer);
                }
                itbag.name = ItemTemplate3.item.get(3593).getName() + " [Khóa]";
                itbag.UpdateName();
                conn.p.item.wear[11] = itbag;
                conn.p.item.char_inventory(4);
                conn.p.item.char_inventory(7);
                conn.p.item.char_inventory(3);
                conn.p.fashion = Part_fashion.get_part(conn.p);
                conn.p.change_map_di_buon(conn.p);
                Service.send_notice_box(conn, "Nhận thành công");
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Graham(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }
        if (conn.p.map.map_id != 8 && !(conn.ac_admin >= 10)) {
            return;
        }
        switch (index) {
            case 0: {
                Service.send_box_UI(conn, 32);
                break;
            }
            case 1: {
                if (conn.p.pet_di_buon != null && Math.abs(conn.p.pet_di_buon.x - conn.p.x) < 75
                        && Math.abs(conn.p.pet_di_buon.y - conn.p.y) < 75 && conn.p.item.wear[11] != null
                        && conn.p.item.wear[11].id == 3599) {
                    //
                    int vang_recei = 0;
                    for (int i = 0; i < conn.p.pet_di_buon.item.size(); i++) {
                        if (conn.p.pet_di_buon.item.get(i) == 3590) {
                            vang_recei += 250_000;
                        } else if (conn.p.pet_di_buon.item.get(i) == 3591) {
                            vang_recei += 350_000;
                        } else if (conn.p.pet_di_buon.item.get(i) == 3592) {
                            vang_recei += 450_000;
                        }
                    }
                    if (vang_recei > 0) {
                        conn.p.update_vang(vang_recei);
                        conn.p.item.char_inventory(5);
                        //
                        Message mout = new Message(8);
                        mout.writer().writeShort(conn.p.pet_di_buon.index);
                        for (int i = 0; i < conn.p.map.players.size(); i++) {
                            Player p0 = conn.p.map.players.get(i);
                            if (p0 != null) {
                                p0.conn.addmsg(mout);
                            }
                        }
                        mout.cleanup();
                        //
                        Pet_di_buon_manager.remove(conn.p.pet_di_buon.name);
                        conn.p.pet_di_buon = null;
                        Service.send_notice_box(conn, "Nhận được " + vang_recei + " vàng!");
                        if (conn.p.nv_tinh_tu[0] == 15 && conn.p.nv_tinh_tu[1] < conn.p.nv_tinh_tu[2]) {
                            conn.p.nv_tinh_tu[1]++;
                        }
                    } else {
                        Service.send_notice_box(conn, "Ngươi chưa có gì mà hay bị cướp mất hết hàng rồi!");
                    }
                } else {
                    Service.send_notice_box(conn, "Ta không thấy con vật đi buôn của ngươi");
                }
                break;
            }
            case 2: {
                Item3 itbag = new Item3();
                itbag.id = 3599;
                itbag.clazz = ItemTemplate3.item.get(3599).getClazz();
                itbag.type = ItemTemplate3.item.get(3599).getType();
                itbag.level = ItemTemplate3.item.get(3599).getLevel();
                itbag.icon = ItemTemplate3.item.get(3599).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(3599).getOp());
                itbag.color = 5;
                itbag.part = ItemTemplate3.item.get(3599).getPart();
                itbag.tier = 0;
                itbag.islock = true;
                itbag.time_use = 0;
                // thao do
                if (conn.p.item.wear[11] != null && conn.p.item.wear[11].id != 3593 && conn.p.item.wear[11].id != 3599
                        && conn.p.item.wear[11].id != 3596) {
                    Item3 buffer = conn.p.item.wear[11];
                    conn.p.item.wear[11] = null;
                    conn.p.item.add_item_bag3(buffer);
                }
                itbag.name = ItemTemplate3.item.get(3599).getName() + " [Khóa]";
                itbag.UpdateName();
                conn.p.item.wear[11] = itbag;
                conn.p.item.char_inventory(4);
                conn.p.item.char_inventory(7);
                conn.p.item.char_inventory(3);
                conn.p.fashion = Part_fashion.get_part(conn.p);
                conn.p.change_map_di_buon(conn.p);
                Service.send_notice_box(conn, "Nhận thành công");
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Mr_Dylan(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }
        if (conn.p.map.map_id != 52 && !(conn.ac_admin >= 10)) {
            return;
        }

        if (conn.p.item.wear[11] == null || (conn.p.item.wear[11] != null && conn.p.item.wear[11].id != 3599)) {
            Service.send_notice_box(conn, "Con không phải là thương nhân");
            return;
        }
        if (conn.p.pet_di_buon != null && Math.abs(conn.p.pet_di_buon.x - conn.p.x) < 75
                && Math.abs(conn.p.pet_di_buon.y - conn.p.y) < 75) {
            switch (index) {
                case 0: {
                    Service.send_box_UI(conn, 31);
                    break;
                }
                default: {
                    Service.send_notice_box(conn, "Chưa có chức năng");
                    break;
                }
            }
        } else {
            Service.send_notice_box(conn, "Ta không thấy con vật đi buôn của ngươi");
        }
    }

    private static void Menu_NauKeo(Session conn, byte index) throws IOException {
        if (Manager.gI().event == 1) {
            switch (index) {
                case 0: {
                    // Service.send_box_input_text(conn, 11, "Nhập số lượng", new String[] {"Số lượng :"});
                    if (conn.p.get_ngoc() < 10) {
                        Service.send_notice_box(conn, "Không đủ 10 ngọc");
                        return;
                    }
                    if (Event_1.naukeo.time <= 30) {
                        Service.send_notice_box(conn, "Không thể tăng tốc");
                        return;
                    }
                    conn.p.update_ngoc(-10);
                    conn.p.item.char_inventory(5);
                    Event_1.naukeo.update(1);
                    Service.send_notice_box(conn, "Tăng tốc thành công");
                    break;
                }
                case 1: {
                    Service.send_notice_box(conn, "Nguyên liệu cần để nấu kẹo như sau: Đường, Sữa, Bơ, Vani\r\n"
                            + "- Mỗi ngày server cho nấu kẹo 1 lần vào lúc 17h , thời gian nấu là 2 tiếng.\r\n"
                            + "- Thời gian đăng ký là từ 19h ngày hôm trước đến 16h30 ngày hôm sau. Phí đăng ký là 5 ngọc\r\n"
                            + "- Một lần tăng tốc mất 10 ngọc và sẽ giảm được 2 phút nấu\r\n"
                            + "- Số kẹo tối đa nhận được là 20 kẹo.Tuy nhiên nếu các hiệp sĩ góp càng nhiều thì càng có lợi vì 10 người chơi góp nhiều nguyên liệu nhất sẽ được cộng thêm 20 cái\r\n"
                            + "+ Số kẹo nhận được sẽ tính theo công thức 1 Kẹo = 1 Đường + 1 Sữa + 1 Bơ+ 1 Vani");
                    break;
                }
                case 2: {
                    Service.send_notice_box(conn,
                            "Thông tin:\nĐã góp : " + Event_1.get_keo_now(conn.p.name) + "\nThời gian nấu còn lại : "
                            + ((Event_1.naukeo.time == 0) ? "Không trong thời gian nấu"
                                    : ("Còn lại " + Event_1.naukeo.time + "p")));
                    break;
                }
                case 3: {
                    send_menu_select(conn, 120, Event_1.get_top_naukeo());
                    break;
                }
                default: {
                    Service.send_notice_box(conn, "Chưa có chức năng");
                    break;
                }
            }
        }
    }

    private static void Menu_Event(Session conn, byte index) throws IOException {
        if (Manager.gI().event == 1) {
            switch (index) {
                case 0: {
                    Service.send_box_input_text(conn, 10, "Nhập số lượng", new String[]{"Số lượng :"});
                    break;
                }
                case 1: {
                    Service.send_notice_box(conn,
                            "Để đổi thành Hộp đồ chơi hoàn chỉnh theo công thức: 20.000 vàng + 50 Bức tượng rồng + 50 Kiếm đồ chơi + 50 Đôi giày nhỏ xíu + 50 Trang phục tí hon + 50 Mũ lính chì."
                            + "\nĐể đổi thành Túi kẹo hoàn chỉnh theo công thức: 50.000 vàng + 5 Kẹo.");
                    break;
                }
                case 2: {
                    if (!Event_1.check_time_can_register()) {
                        Service.send_notice_box(conn, "Không trong thời gian đăng ký!");
                        return;
                    }
                    if (conn.p.get_ngoc() < 5) {
                        Service.send_notice_box(conn, "Không đủ 5 ngọc");
                        return;
                    }
                    if (Event_1.check(conn.p.name)) {
                        Service.send_notice_box(conn, "Đã đăng ký rồi, quên à!");
                        return;
                    }
                    conn.p.update_ngoc(-5);
                    conn.p.item.char_inventory(5);
                    Event_1.add_material(conn.p.name, 0);
                    Service.send_notice_box(conn, "Đăng ký thành công, có thể góp nguyên liệu rồi");
                    break;
                }
                case 3: {
                    if (!Event_1.check_time_can_register()) {
                        Service.send_notice_box(conn, "Không trong thời gian đăng ký!");
                        return;
                    }
                    if (Event_1.check(conn.p.name)) {
                        Service.send_box_input_text(conn, 11, "Nhập số lượng", new String[]{"Số lượng :"});
                    } else {
                        Service.send_notice_box(conn, "Chưa đăng ký nấu kẹo, hãy đăng ký!");
                    }
                    break;
                }
                case 4: {
                    int quant = Event_1.get_keo(conn.p.name);
                    if (quant > 0) {
                        quant = (quant > 20) ? 20 : quant;
                        if (Event_1.list_bxh_naukeo_name.contains(conn.p.name)) {
                            quant += 20;
                        }
                        quant *= 3;
                        Item47 it = new Item47();
                        it.category = 4;
                        it.id = 162;
                        it.quantity = (short) quant;
                        conn.p.item.add_item_bag47(4, it);
                        conn.p.item.char_inventory(4);
                        Service.send_notice_box(conn, "Nhận được " + quant + " kẹo");
                    } else {
                        Service.send_notice_box(conn, "Đã nhận rồi hoặc chưa tham gia!");
                    }
                    break;
                }
                case 5: {
                    Service.send_box_input_text(conn, 12, "Nhập số lượng", new String[]{"Số lượng :"});
                    break;
                }
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13: {
                    if (conn.p.item.get_bag_able() < 1) {
                        Service.send_notice_box(conn, "Hành trang không đủ chỗ trống!");
                        return;
                    }
                    short[] id_receiv = new short[]{4626, 4761, 3610, 4636, 4709, 4710, 281, 3616};
                    short[] tuikeo_required = new short[]{120, 120, 60, 60, 30, 30, 15, 60};
                    short[] hopdochoi_required = new short[]{120, 120, 60, 60, 30, 30, 15, 60};
                    int[] ngoc_required = new int[]{360, 330, 60, 60, 60, 60, 15, 300};
                    if (tuikeo_required[index - 6] > conn.p.item.total_item_by_id(4, 157)) {
                        Service.send_notice_box(conn, "Không đủ " + tuikeo_required[index - 6] + " túi kẹo!");
                        return;
                    }
                    if (hopdochoi_required[index - 6] > conn.p.item.total_item_by_id(4, 158)) {
                        Service.send_notice_box(conn, "Không đủ " + hopdochoi_required[index - 6] + " hộp đồ chơi!");
                        return;
                    }
                    if (ngoc_required[index - 6] > conn.p.get_ngoc()) {
                        Service.send_notice_box(conn, "Không đủ " + ngoc_required[index - 6] + " ngọc!");
                        return;
                    }
                    if (index != 12) {
                        Item3 itbag = new Item3();
                        ItemTemplate3 it_temp = ItemTemplate3.item.get(id_receiv[index - 6]);
                        itbag.id = it_temp.getId();
                        itbag.name = it_temp.getName();
                        itbag.clazz = it_temp.getClazz();
                        itbag.type = it_temp.getType();
                        itbag.level = 10;
                        itbag.icon = it_temp.getIcon();
                        itbag.op = new ArrayList<>();
                        itbag.op.addAll(it_temp.getOp());
                        itbag.color = it_temp.getColor();
                        itbag.part = it_temp.getPart();
                        itbag.tier = 0;
                        itbag.islock = false;
                        itbag.time_use = 0;
                        conn.p.item.add_item_bag3(itbag);
                        Service.send_notice_box(conn, "Nhận được " + itbag.name + ".");
                    } else {
                        Item47 itbag = new Item47();
                        itbag.id = id_receiv[index - 6];
                        itbag.quantity = (short) 20;
                        itbag.category = 4;
                        conn.p.item.add_item_bag47(4, itbag);
                        Service.send_notice_box(conn, "Nhận được 20 xe trượt tuyết.");
                    }
                    conn.p.item.remove(4, 157, tuikeo_required[index - 6]);
                    conn.p.item.remove(4, 158, hopdochoi_required[index - 6]);
                    conn.p.update_ngoc(-ngoc_required[index - 6]);
                    conn.p.item.char_inventory(4);
                    conn.p.item.char_inventory(3);
                    break;
                }
                default: {
                    Service.send_notice_box(conn, "Đang được chuẩn bị");
                    break;
                }
            }
        }
    }

//    private static void Menu_diempk(Session conn, byte index) throws IOException {
//        switch (index) {
//            case 0: {
//                Service.send_notice_box(conn, "Bạn đang có " + conn.p.hieuchien + " Điểm Pk.");
//                break;
//            }
//            default: {
//                Service.send_notice_box(conn, "Chưa có chức năng");
//                break;
//            }
//        }
//    }
    private static void Menu_MissAnwen(Session conn, byte index) throws IOException {
        Vgo vgo = null;
        switch (index) {
            case 0: {
                vgo = new Vgo();
                vgo.id_map_go = 1;
                vgo.x_new = 432;
                vgo.y_new = 354;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Thongtincanhan(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                Service.send_notice_box(conn, "Thông tin:\n Hiệp Sĩ NeOn \n Địa Chỉ Ip:" + conn.ip + "\nTài Khoản:" + conn.user + "\nMật Khẩu Là:" + conn.pass + "\n Số Coin Còn Lại \n:" + conn.coin + "\n(Ghi Chú 0 = Đã Kích hoạt, 1 = Chưa Kích hoạt) \n :" + conn.status);
                break;

            }
            case 1: {
                Service.send_notice_box(conn, "Thông Tin: \n" + "\nDame : " + conn.p.body.get_DameBase() + "\nHp :" + conn.p.body.get_HpMax() + "\nMp :" + conn.p.body.get_MpMax() + "\nChí Mạng :" + conn.p.body.get_Crit() + "\nXuyên Giáp :" + conn.p.body.get_Pierce() + "\nPhòng Thủ :" + conn.p.body.get_DefBase() + "\nNé Đòn:" + conn.p.body.get_Miss() + "\nPhản Sát Thương :" + conn.p.body.get_PhanDame());
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_mokhoa(Session conn, byte index) throws IOException {
        if (conn.p.get_ngoc() < 300_000) {
            Service.send_notice_box(conn, "Không đủ 300k ngọc");
            return;
        }
        Item3 it_process = null;
        for (int i = 0; i < conn.p.item.bag3.length; i++) {
            Item3 it = conn.p.item.bag3[i];
            if (conn.p.item.bag3[i] != null && it.islock) {
                if (index == 0) {

                    it_process = it;
                    break;
                }
                index--;
            }
        }

        if (it_process != null) {

            it_process.islock = false;

            it_process.name
                    = ItemTemplate3.item.get(it_process.id).getName() + "";
            it_process.UpdateName();
            conn.p.update_ngoc(-300000);
            conn.p.item.remove(4, 330, 1);
            conn.p.item.char_inventory(4);
            conn.p.item.char_inventory(7);
            conn.p.item.char_inventory(3);
            // conn.p.item.add_item_bag3(it_process);

            Service.send_notice_box(conn, "Thành công nhận được " + it_process.name + "");
            conn.p.item.char_inventory(3);
        }

    }

    private static void Menu_top(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }

        switch (index) {
            case 0: {
                if (conn.p.diem_danh[1] == 0) {
                    conn.p.diem_danh[1] = 1;
                    int ngoc_ = Util.random(1000, 2000);
                    int vang_ = Util.random(10000, 100000);
                    conn.p.update_ngoc(ngoc_);
                    conn.p.update_vang(vang_);
                    conn.p.item.char_inventory(5);
                    Service.send_notice_box(conn,
                            "Cảm ơn bạn đã like cho tôi, để tỏ lòng biết ơn tôi tặng bạn: " + ngoc_ + " ngọc," + vang_ + "Vàng.");
                } else {
                    Service.send_notice_box(conn, "Hôm nay bạn đã like rồi, tôi không có nhiều tiền để phát quà vậy đâu!");
                }
                break;
            }
            case 1: {
                if (conn.p.shopcoin = true) {
                    Service.send_box_UI(conn, 37);
                }
                break;
            }

            case 2: {
                if (conn.p.level < 60) {
                    Service.send_notice_box(conn, "Yêu cầu level trên 60");
                    return;
                }
                send_menu_select(conn, 114, new String[]{"Cầu hôn", "Ly hôn", "Nâng cấp nhẫn", "Hướng dẫn"});
                break;
            }

            case 3: {
                send_menu_select(conn, 115, new String[]{"Chest Thông Tin Tài Khoản", "Thông Tin Bản Thân"});
                break;
            }
            //case 4: {
            //     send_menu_select(conn, 1001,
            //                new String[]{"Hướng dẫn", "Nhận nhiệm vụ", "Hủy nhiệm vụ", "Trả nhiệm vụ", "Kiểm tra"});
            //        break;
            //      }
            case 4: {
                if (conn.p.hieuchien < 1000) {
                    Service.send_notice_box(conn, "Chưa đủ 1000 điểm pk");
                    return;
                }
                conn.p.hieuchien -= 1000;
                int random = Util.random(100);
                if (random < 10) {
                    short id_ = 4718;
                    Item3 itbag = new Item3();
                    itbag.id = id_;
                    itbag.name = ItemTemplate3.item.get(id_).getName();
                    itbag.clazz = ItemTemplate3.item.get(id_).getClazz();
                    itbag.type = ItemTemplate3.item.get(id_).getType();
                    itbag.level = ItemTemplate3.item.get(id_).getLevel();
                    itbag.icon = ItemTemplate3.item.get(id_).getIcon();
                    itbag.op = ItemTemplate3.item.get(id_).getOp();
                    itbag.color = ItemTemplate3.item.get(id_).getColor();
                    itbag.part = ItemTemplate3.item.get(id_).getPart();
                    itbag.tier = 0;
                    itbag.islock = false;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(3);
                    Service.send_notice_box(conn, "Nhận được " + itbag.name);
                    return;
                } else if (random > 10 && random < 20) {
                    short id_ = 4719;
                    Item3 itbag = new Item3();
                    itbag.id = id_;
                    itbag.name = ItemTemplate3.item.get(id_).getName();
                    itbag.clazz = ItemTemplate3.item.get(id_).getClazz();
                    itbag.type = ItemTemplate3.item.get(id_).getType();
                    itbag.level = ItemTemplate3.item.get(id_).getLevel();
                    itbag.icon = ItemTemplate3.item.get(id_).getIcon();
                    itbag.op = ItemTemplate3.item.get(id_).getOp();
                    itbag.color = ItemTemplate3.item.get(id_).getColor();
                    itbag.part = ItemTemplate3.item.get(id_).getPart();
                    itbag.tier = 0;
                    itbag.islock = false;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(3);
                    Service.send_notice_box(conn, "Nhận được " + itbag.name);
                    return;
                } else if (random > 20 && random < 30) {
                    short id_ = 4709;
                    Item3 itbag = new Item3();
                    itbag.id = id_;
                    itbag.name = ItemTemplate3.item.get(id_).getName();
                    itbag.clazz = ItemTemplate3.item.get(id_).getClazz();
                    itbag.type = ItemTemplate3.item.get(id_).getType();
                    itbag.level = ItemTemplate3.item.get(id_).getLevel();
                    itbag.icon = ItemTemplate3.item.get(id_).getIcon();
                    itbag.op = ItemTemplate3.item.get(id_).getOp();
                    itbag.color = ItemTemplate3.item.get(id_).getColor();
                    itbag.part = ItemTemplate3.item.get(id_).getPart();
                    itbag.tier = 0;
                    itbag.islock = false;
                    itbag.time_use = 0;
                    conn.p.item.add_item_bag3(itbag);
                    conn.p.item.char_inventory(3);
                    Service.send_notice_box(conn, "Nhận được " + itbag.name);
                    return;
                } else if (random > 30) {
                    int vang = Util.random(5000, 100000);
                    int ngoc = Util.random(200, 400);
                    conn.p.update_vang(vang);
                    conn.p.update_ngoc(ngoc);
                    conn.p.item.char_inventory(5);
                    Service.send_notice_box(conn, "Nhận được " + vang + "Vàng. " + ngoc + "Ngọc");
                }
                break;
            }
            case 5: {
                int khu = 0;
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài kho?n ch?a ???c kích ho?t,");
                    return;
                }
                if (conn.p.get_ngoc() < 1000) {
                    Service.send_notice_box(conn, "Không ?? 1000 ng?c");
                    return;
                }
                if (conn.p.get_chuyensinh() < 20) {
                    Service.send_notice_box(conn, "Chuy?n Sinh  20 Tr? Lên M?i Có Th? Vào");
                    return;
                }

                conn.p.update_ngoc(-1000);

                if (conn.p.get_chuyensinh() < 50) { // dưới 50
                    khu = 0;
                } else if (conn.p.get_chuyensinh() >= 50 && conn.p.get_chuyensinh() < 150) { // 50 - 150
                    khu = 2;
                } else if (conn.p.get_chuyensinh() >= 150 && conn.p.get_chuyensinh() < 300) { // 150 - 300
                    khu = 3;
                } else if (conn.p.get_chuyensinh() >= 300 && conn.p.get_chuyensinh() < 500) { // 300 - 500
                    khu = 4;
                } else if (conn.p.get_chuyensinh() >= 500 && conn.p.get_chuyensinh() <= 1000) { // 500 - 1000
                    khu = 5;
                }

                Map map = Map.get_map_by_id(119)[khu];
                MapService.leave(conn.p.map, conn.p);
                conn.p.map = map;
                conn.p.x = 516;
                conn.p.y = 504;
                MapService.enter(conn.p.map, conn.p);
                break;

            }
            case 6: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                send_menu_select(conn, 601, new String[]{"Khu Boss Even 0x", "Khu Boss Even 1x", "Khu Boss Even 2x", "Khu Boss Even 7x", "Khu Boss Even 8x", "Khu Boss Even 11x", "Khu Boss Even 13x"});
                break;
            }

            default: {
                Service.send_notice_box(conn, "chức năng đang bảo trì!!");
                break;

            }
        }
    }

    private static void Menu_TachCanh(Session conn, byte index) throws IOException {
        Item3 item = null;
        int count = 0;
        for (int i = 0; i < conn.p.item.bag3.length; i++) {
            Item3 it = conn.p.item.bag3[i];
            if (it != null && it.type == 7 && it.tier > 0) {
                if (count == index) {
                    item = it;
                    break;
                }
                count++;
            }
        }
        if (item != null) {
            conn.p.id_wing_split = index;
            int quant1 = 40;
            int quant2 = 10;
            int quant3 = 50;
            for (int i = 0; i < item.tier; i++) {
                quant1 += GameSrc.wing_upgrade_material_long_khuc_xuong[i];
                quant2 += GameSrc.wing_upgrade_material_kim_loai[i];
                quant3 += GameSrc.wing_upgrade_material_da_cuong_hoa[i];
            }
            if (item.tier > 15) {
                quant1 /= 2;
                quant2 /= 2;
                quant3 /= 2;
            } else {
                quant1 /= 3;
                quant2 /= 3;
                quant3 /= 3;
            }
            Service.send_box_input_yesno(conn, 114, "Bạn có muốn tách cánh này và nhận được: " + quant1
                    + " lông và khúc xương, " + quant2 + " kim loại, " + quant3 + " đá cường hóa?");
        }
    }

    private static void Menu_TienCanh(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                // Service.send_box_UI(conn, index);
                Service.send_msg_data(conn, 23, "create_wings");
                break;
            }
            case 1: {
                Message m2 = new Message(77);
                m2.writer().writeByte(6);
                conn.addmsg(m2);
                m2.cleanup();
                //
                m2 = new Message(77);
                m2.writer().writeByte(1);
                m2.writer().writeUTF("Nâng cấp cánh");
                conn.addmsg(m2);
                m2.cleanup();
                conn.p.is_create_wing = false;
                break;
            }
            //   case 2: {
            //       List<String> list = new ArrayList<>();
            //        for (int i = 0; i < conn.p.item.bag3.length; i++) {
            //            Item3 it = conn.p.item.bag3[i];
            //            if (it != null && it.type == 7) {
            //                list.add(it.name + " +" + it.tier);
            //              }
            //          }
//
            //          String[] list_2 = new String[]{"Trống"};
            //         if (list.size() > 0) {
            //            list_2 = new String[list.size()];
            //             for (int i = 0; i < list_2.length; i++) {
            //                list_2[i] = list.get(i);
            //            }
            //           }
            //           MenuController.send_menu_select(conn, 210, list_2);
//
            //            break;
            //        }
            case 3: {
                conn.p.id_wing_split = -1;
                List<String> list = new ArrayList<>();
                for (int i = 0; i < conn.p.item.bag3.length; i++) {
                    Item3 it = conn.p.item.bag3[i];
                    if (it != null && it.type == 7 && it.tier > 0) {
                        list.add((it.name + " +" + it.tier));
                    }
                }
                if (list.size() > 0) {
                    String[] list_2 = new String[list.size()];
                    for (int i = 0; i < list_2.length; i++) {
                        list_2[i] = list.get(i);
                    }
                    send_menu_select(conn, 121, list_2);
                } else {
                    Service.send_notice_box(conn, "Làm gì có cánh mà đòi tách?");
                }
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_ThayDongCanh_percent(Session conn, byte index) throws IOException {
        if (conn.p.get_ngoc() < 300) {
            Service.send_notice_box(conn, "Không đủ 300 ngọc");
            return;
        }
        conn.p.update_ngoc(-300);
        Log.gI().add_log(conn.p.name, "hết 300 ngọc");
        Item3 it_process = null;
        for (int i = 0; i < conn.p.item.bag3.length; i++) {
            Item3 it = conn.p.item.bag3[i];
            if (it != null && it.type == 7) {
                if (index == 0) {
                    it_process = it;
                    break;
                }
                index--;
            }
        }
        if (it_process != null) {
            Option[] process = new Option[2];
            for (int i = 0; i < it_process.op.size(); i++) {
                if (it_process.op.get(i).id >= 7 && it_process.op.get(i).id <= 11) {
                    if (process[0] == null) {
                        process[0] = it_process.op.get(i);
                    } else if (process[1] == null) {
                        process[1] = it_process.op.get(i);
                    } else {
                        break;
                    }
                }
            }
            if (process[0] != null) {
                process[0].id = (byte) Util.random(7, 12);
                process[0].setParam(Util.random(1500, 2500));
                // process[0].setParam(process[0].getParam(0) + Util.random(50, 100));
            }
            if (process[1] != null) {
                process[1].id = (byte) Util.random(7, 12);
                process[1].setParam(Util.random(1500, 2500));
                //  process[1].setParam(process[1].getParam(0) + Util.random(50, 100));
            }
            Service.send_notice_box(conn, "Thành công");
            conn.p.item.char_inventory(3);
        }
    }

    private static void Menu_Clan_Manager(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }
        if (conn.p.myclan.mems.get(0).name.equals(conn.p.name)) {
            switch (index) {
                case 0: {
                    conn.p.myclan.open_box_clan(conn);
                    break;
                }
                case 1: {
                    if (conn.p.myclan.get_percent_level() >= 100) {
                        Service.send_box_input_yesno(conn, 118,
                                "Bạn có muốn nâng cấp bang lên level " + (conn.p.myclan.level + 1) + " với "
                                + (Clan.vang_upgrade[1] * conn.p.myclan.level) + " vàng và " + (conn.p.myclan.level + 1)
                                + " với " + (Clan.ngoc_upgrade[1] * conn.p.myclan.level) + " ngọc không?");
                    } else {
                        Service.send_notice_box(conn, "Chưa đủ exp để nâng cấp!");
                    }
                    break;
                }
                case 2: {
                    Service.send_box_input_yesno(conn, 116,
                            "Hãy xác nhận việc hủy bang, đừng hối hận khóc lóc xin admin khôi phục lại nhá!");
                    break;
                }
                case 3: {
                    Service.send_box_input_text(conn, 13, "Nhập tên :", new String[]{"Nhập tên :"});
                    break;
                }
                default: {

                    Service.send_notice_box(conn, "Chưa có chức năng");
                    break;
                }
            }
        }
    }

    private static void Menu_Dungeon_Mode_Selection(Session conn, byte index) throws IOException {
//        if (conn.p.dungeon != null && conn.p.dungeon.getWave() == 20) {
//            if (index != 2 && conn.p.party != null && conn.p.party.get_mems().get(0).id != conn.p.id) {
//                Service.send_notice_box(conn, "Chỉ có đội trưởng mới có quyền quyết định!");
//                return;
//            }
//            conn.p.dungeon.setMode(index);
//            if (conn.p.dungeon != null) {
//                conn.p.dungeon.setWave(21);
//                conn.p.dungeon.state = 1;
//            } else {
//                Service.send_notice_box(conn, "Có lỗi xảy ra, hãy thử chọn lại!");
//            }
//        }
    }

    private static void Menu_LinhCanh(Session conn, byte index) throws IOException {
//        if (conn.p.dungeon != null && conn.p.dungeon.getWave() == 20) {
//            if (index != 2 && conn.p.party != null && conn.p.party.get_mems().get(0).id != conn.p.id) {
//                Service.send_notice_box(conn, "Chỉ có đội trưởng mới có quyền quyết định!");
//                return;
//            }
//            switch (index) {
//                case 0: {
//                    send_menu_select(conn, 123, new String[]{"Easy", "Normal", "Hard", "Nightmare", "Hell"});
//                    break;
//                }
//                case 1: {
//                    if (conn.p.dungeon != null) {
//                        conn.p.dungeon.state = 6;
//                    } else {
//                        Service.send_notice_box(conn, "Có lỗi xảy ra, hãy thử chọn lại!");
//                    }
//                    Service.send_notice_box(conn, "gà thật, éo dám đi tiếp à");
//                    break;
//                }
//                case 2: {
//                    Service.send_notice_box(conn,
//                            "Đến được đây quả là có cố gắng, hãy nói chuyện với phó chỉ huy để nhận thưởng hoàn thành phó bản, hoặc chọn tiếp tục chinh phục để có thể nhận được nhiều phần thưởng hơn");
//                    break;
//                }
//                default: {
//                    Service.send_notice_box(conn, "Chưa có chức năng");
//                    break;
//                }
//            }
//        }
    }

    private static void Menu_PhoChiHuy(Session conn, byte index) throws IOException {
        switch (index) {
            // case 0: {
            // if (conn.p.level < 30) {
            // Service.send_notice_box(conn, "Đạt level 30 mới có thể vào phó bản");
            // return;
            // }

            // if (conn.p.isLiveSquire == true) {
            // Service.send_notice_box(conn, "Mang theo đệ không thể vào!");
            // return;
            // }
            // if (conn.p.point_active[0] < 1) {
            // Service.send_notice_box(conn, "Đã hết lượt đi, hãy quay lại vào ngày mai");
            // return;
            // }
            // String notice = "Danh sách người chơi vào phó bản :\n1) " + conn.p.name + " : level " + conn.p.level;
            // /*if (conn.p.party != null) {
            // Service.send_notice_box(conn, "Phó bản hiện tại chỉ hỗ trợ chế độ solo");
            // return;
            // }*/
            // notice += "\nĐộ khó: ??? \nHãy xác nhận." + (conn.p.point_active[0] != 10 ? " phí vào là 30 ngọc." : "");
// //                conn.p.dungeon = null;
            // Service.send_box_input_yesno(conn, 119, notice);
            // break;
            // }
            case 0: {
                if (conn.p.level < 30) {
                    Service.send_notice_box(conn, "Đạt level 30 mới có thể vào phó bản");
                    return;
                }

                // if (conn.p.isLiveSquire) {
                // Service.send_notice_box(conn, "Mang theo đệ không thể vào!");
                // return;
                // }>
                if (conn.p.point_active[0] < 1) {
                    Service.send_notice_box(conn, "Đã hết lượt đi, hãy quay lại vào ngày mai");
                    return;
                }

                Dungeon existingDungeon = DungeonManager.get_list(conn.p.name); // Kiểm tra phó bản hiện tại

                if (existingDungeon == null) {
                    // Nếu chưa có phó bản, chuẩn bị thông báo
                    StringBuilder notice = new StringBuilder("Danh sách người chơi vào phó bản:\n");
                    int difficulty = 1; // Độ khó mặc định là 1

                    if (conn.p.party != null) { // Nếu người chơi thuộc nhóm
                        List<Player> partyMembers = conn.p.party.get_mems(); // Lấy danh sách thành viên nhóm
                        difficulty = partyMembers.size(); // Độ khó bằng số lượng thành viên
                        for (int i = 0; i < partyMembers.size(); i++) {
                            Player member = partyMembers.get(i);
                            notice.append((i + 1)).append(") ").append(member.name)
                                    .append(" : level ").append(member.level).append("\n");
                        }
                    } else {
                        // Nếu chơi một mình
                        notice.append("1) ").append(conn.p.name)
                                .append(" : level ").append(conn.p.level).append("\n");
                    }

                    notice.append("Độ khó: ").append(difficulty)
                            .append("\nHãy xác nhận.")
                            .append(conn.p.point_active[0] != 10 ? " Phí vào là 30 ngọc." : "");
                    Service.send_box_input_yesno(conn, 119, notice.toString());
                } else {
                    // Nếu đã có phó bản, vào ngay
                    MapService.leave(conn.p.map, conn.p);
                    conn.p.map = existingDungeon.template;
                    MapService.enter(existingDungeon.template, conn.p);
                    existingDungeon.send_map_data(conn.p);
                    existingDungeon.send_mob_move_when_exit(conn.p);
                }

                break;
            }

            case 1: {
                Service.send_notice_box(conn,
                        "Ngã tư tử thần nâng cấp:\nSau khi vượt qua 20 ải đầu sẽ nhận phần thưởng hoàn thành phó bản, sau đó hãy nói chuyện với npc trong phó bản để quyết định độ khó, cuối cùng là tiếp tục chinh phục phó bản.\n Càng tích nhiều điểm càng được nhiều phần thưởng nhé, điểm sẽ được tính dựa trên số ải vượt qua và lượng dame gây ra.\nLưu ý mỗi ngày đi tối đa 10 lần.");
                break;
            }
            case 2: {
                synchronized (Dungeon.bxh_time_complete) {
                    String notice;
                    if (Dungeon.bxh_time_complete.size() > 0) {
                        notice = "BXH thời gian hoàn thành:\n";
                        int dem = 1;
                        for (Dungeon.BXH_Dungeon_Finished set : Dungeon.bxh_time_complete) {
                            notice += (dem++) + ". " + set.name + " : " + set.time + "s\n";
                        }
                    } else {
                        notice = "Chưa có thông tin";
                    }
                    Service.send_notice_box(conn, notice);
                }
                break;
            }
            case 3: {
                ChiemThanhManager.ClanRegister(conn.p);
                break;
            }
            case 4: {
                if (!conn.p.isOwner) {
                    return;
                }
                if (ChiemThanhManager.timeAttack < System.currentTimeMillis()) {
                    Service.send_notice_box(conn, "Chiếm thành đã kết thúc.");
                } else if (!ChiemThanhManager.joinMap(conn.p)) {
                    Service.send_notice_box(conn, "Bạn không đủ điều kiện tham gia chiếm thành.");
                }
                break;
            }
            case 5: {
                Service.send_notice_box(conn, "Thông tin:\nSố lần còn lại " + conn.p.point_active[0]
                        + ": lần\nTổng điểm hôm nay : " + conn.p.point_active[1]);
                break;
            }
            case 6: {
                if (conn.p.point_active[1] < 1) {
                    Service.send_notice_box(conn, "Hôm nay chưa làm gì cả, không làm mà đòi có ăn à con??");
                    return;
                }
                if (conn.p.item.get_bag_able() < 3) {
                    Service.send_notice_box(conn, "Hành trang không đủ chỗ!");
                    return;
                }
                while (conn.p.point_active[1] > 0) {
                    conn.p.point_active[1]--;
                    short id_ = Medal_Material.m_blue[Util.random(0, 10)];
                    if (conn.p.item.get_bag_able() <= 0) {
                        Service.send_notice_box(conn, "Hành trang không đủ chỗ!");
                        conn.p.item.char_inventory(7);
                        conn.p.update_vang(Util.random(10, 50));
                        return;
                    }
                    if (25 > Util.random(0, 100) && ((conn.p.item.get_bag_able() > 0))) {
                        Item47 itbag = new Item47();
                        itbag.id = id_;
                        itbag.quantity = (short) Util.random(0, 2);
                        itbag.category = 7;
                        conn.p.item.add_item_bag47(7, itbag);
                    }
                    //
                    conn.p.update_vang(Util.random(10, 50));
                }
                conn.p.item.char_inventory(7);
                Service.send_notice_box(conn, "Nhận thành công");
                break;
            }
            case 7: {
                Item3 itbag = new Item3();
                itbag.id = 3596;
                itbag.clazz = ItemTemplate3.item.get(3596).getClazz();
                itbag.type = ItemTemplate3.item.get(3596).getType();
                itbag.level = ItemTemplate3.item.get(3596).getLevel();
                itbag.icon = ItemTemplate3.item.get(3596).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(3596).getOp());
                itbag.color = 5;
                itbag.part = ItemTemplate3.item.get(3596).getPart();
                itbag.tier = 0;
                itbag.islock = true;
                itbag.time_use = 0;
                // thao do
                if (conn.p.item.wear[11] != null && conn.p.item.wear[11].id != 3593 && conn.p.item.wear[11].id != 3599
                        && conn.p.item.wear[11].id != 3596) {
                    Item3 buffer = conn.p.item.wear[11];
                    conn.p.item.wear[11] = null;
                    conn.p.item.add_item_bag3(buffer);
                }
                itbag.name = ItemTemplate3.item.get(3596).getName() + " [Khóa]";
                itbag.UpdateName();
                conn.p.item.wear[11] = itbag;
                conn.p.item.char_inventory(4);
                conn.p.item.char_inventory(7);
                conn.p.item.char_inventory(3);
                conn.p.fashion = Part_fashion.get_part(conn.p);
                conn.p.change_map_di_buon(conn.p);
                Service.send_notice_box(conn, "Nhận thành công");
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Pet_Manager(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                Service.send_box_UI(conn, 21);
                break;
            }
            case 1: {
                Service.send_box_UI(conn, 22);
                break;
            }
            case 2: {
                Service.send_box_UI(conn, 23);
                break;
            }
            case 3: {
                if (conn.p.pet_follow != -1) {
                    for (Pet temp : conn.p.mypet) {
                        if (temp.is_follow) {
                            temp.is_follow = false;
                            Message m = new Message(44);
                            m.writer().writeByte(28);
                            m.writer().writeByte(1);
                            m.writer().writeByte(9);
                            m.writer().writeByte(9);
                            m.writer().writeUTF(temp.name);
                            m.writer().writeByte(temp.type);
                            m.writer().writeShort(conn.p.mypet.indexOf(temp)); // id
                            m.writer().writeShort(temp.level);
                            m.writer().writeShort(temp.getlevelpercent()); // exp
                            m.writer().writeByte(temp.type);
                            m.writer().writeByte(temp.icon);
                            m.writer().writeByte(temp.nframe);
                            m.writer().writeByte(temp.color);
                            m.writer().writeInt(temp.get_age());
                            m.writer().writeShort(temp.grown);
                            m.writer().writeShort(temp.maxgrown);
                            m.writer().writeShort(temp.point1);
                            m.writer().writeShort(temp.point2);
                            m.writer().writeShort(temp.point3);
                            m.writer().writeShort(temp.point4);
                            m.writer().writeShort(temp.maxpoint);
                            m.writer().writeByte(temp.op.size());
                            for (int i2 = 0; i2 < temp.op.size(); i2++) {
                                Option_pet temp2 = temp.op.get(i2);
                                m.writer().writeByte(temp2.id);
                                m.writer().writeInt(temp2.param);
                                m.writer().writeInt(temp2.maxdam);
                            }
                            conn.p.conn.addmsg(m);
                            m.cleanup();
                            break;
                        }
                    }
                    conn.p.pet_follow = -1;
                    Service.send_wear(conn.p);
                    Service.send_char_main_in4(conn.p);
                } else {
                    Service.send_notice_box(conn, "Đã đeo pet đâu mà đòi tháo??");
                }
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Mr_Edgar(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            Service.send_notice_box(conn, "Em chỉ là đệ thôi! ");
            return;
        }
        switch (index) {
            case 0: {
                if (conn.p.list_enemies.size() > 0) {
                    String[] name = new String[conn.p.list_enemies.size()];
                    for (int i = 0; i < name.length; i++) {
                        name[i] = conn.p.list_enemies.get(name.length - i - 1);
                    }
                    send_menu_select(conn, 124, name);
                } else {
                    Service.send_notice_box(conn, "Danh sách chưa có ai, hãy đi cà khịa để tạo thêm!");
                }
                break;
            }
            case 1: {
                Service.send_notice_box(conn,
                        "Bị người chơi khác pk thì sẽ được lưu vào danh sách, "
                        + "mỗi lần trả thù sẽ được đưa tới nơi kẻ thù đang đứng với chi phí chỉ vỏn vẹn 2 ngọc.\n"
                        + "Sau khi được đưa tới nơi, tên kẻ thù sẽ được loại ra khỏi danh sách");
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Nang_Skill(Session conn, byte index) throws IOException {
        // Đệ tử
        if (!conn.p.isOwner) {
            return;
        }
        if (conn.p.skill_110[conn.p.id_index_temp] >= 10) {
            conn.p.id_index_temp = -1;
            Service.send_notice_box(conn, "Kỹ năng được nâng cấp tối đa");
            return;
        }
        int level = conn.p.skill_110[conn.p.id_index_temp];
        String name_book = "";
        if (conn.p.id_index_temp == 1) {
            name_book = switch (conn.p.clazz) {
                case 0 ->
                    "sách học bão lửa";
                case 1 ->
                    "sách học thần tốc";
                case 2 ->
                    "sách học cơn phẫn nộ";
                case 3 ->
                    "sách học súng điện từ";
                default ->
                    name_book;
            };
        } else if (conn.p.id_index_temp == 0) {
            name_book = switch (conn.p.clazz) {
                case 0 ->
                    "sách học khiên địa chấn";
                case 1 ->
                    "sách học bão độc";
                case 2 ->
                    "sách học băng trận";
                case 3 ->
                    "sách học súng thần công";
                default ->
                    name_book;
            };
        }
        String format = String.format("Để nâng từ cấp %s lên cấp %s bạn cần %s sách %s và %s ngọc."
                + " Bạn có muốn thực hiện", level, level + 1, level + 1, name_book, level * 5 + 10);
        if (index == 0) {
            Service.send_box_input_yesno(conn, -121, format);
        } else if (index == 1) {
            Service.send_box_input_yesno(conn, -120, format);
        }
    }

    private static void Menu_tieutiennu(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            Service.send_notice_box(conn, "Em chỉ là đệ thôi! ");
            return;
        }
        switch (index) {

          case 0: {
                send_menu_select(conn, 555, new String[]{"Hưỡng Dẫn", "Tu Tiên", "Xem Thông Tin"});

                break;
            }

            case 1: {
                send_menu_select(conn, 556, new String[]{"Hưỡng Dẫn", "Đả Thông Kinh Mạch", "Xem Thông Tin"});

                break;
            }

            case 2: {
                send_menu_select(conn, 557, new String[]{"Hưỡng Dẫn", "Luyện Thể", "Xem Thông Tin"});

                break;
            }

            case 3: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 118;
                vgo.x_new = 432;
                vgo.y_new = 354;
                conn.p.change_map(conn.p, vgo);

                break;
            }
            case 4: {
                if (conn.status == 1) {
                    send_menu_select(conn, 558, new String[]{"Nhận Nhiệm Vụ", "Trả Nhiệm Vụ", "Hủy Nhiệm Vụ", "Thông Tin", "Thêm lượt"});
                } else {
                    Service.send_notice_box(conn, "TK chua kich hoat");
                }
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_tieulong(Session conn, byte index, Message m) throws IOException, SQLException {
        // if (!conn.p.isOwner) {
        // Service.send_notice_box(conn, "Em chỉ là đệ thôi! ");
        // return;
        // }
        conn.p.ResetCreateItemStar();
        conn.p.ResetShop();
        switch (index) {

            case 0: {
                if (!Manager.isdoichiso) {
                    Service.send_notice_box(conn, "Chức Năng Đang Tạm Khoá!");
                    return;
                }
                List<String> list1 = new ArrayList<>();
                for (int i = 0; i < conn.p.item.wear.length; i++) {
                    if (conn.p.item.wear[i] != null) {
                        list1.add(conn.p.item.wear[i].name);
                    }
                }
                String[] list = new String[list1.size()];
                for (int i = 0; i < list1.size(); i++) {
                    list[i] = list1.get(i);
                }
                send_menu_select(conn, 111, list);
                break;
            }

            case 1: {
                if (conn.p.isSieuThan = true) {
                    Service.send_box_UI(conn, 33);
                    break;
                }
            }

            case 2: {
                if (conn.p.isSieuCap = true) {
                    Service.send_box_UI(conn, 33);
                    break;
                }
            }

            case 3: {

                if (conn.p.levellt <= 15) {
                    if (conn.p.isLiveSquire == true) {
                        Service.send_notice_box(conn, "Mang theo đệ không thể vào!");
                        return;
                    }
                    if (conn.p.party == null) {
                        if (conn.p.typelt < 1) {
                            send_menu_select(conn, -38, new String[]{"EASY", "MEDIUM", "HARD"});
                        } else {
                            String notice = "BẠN CÓ MUỐN TIẾP TỤC TẦNG " + conn.p.levellt;
                            Service.send_box_input_yesno(conn, -38, notice);

                        }
                    } else {
                        Service.send_notice_box(conn, "Rời Party");
                    }
                } else {
                    Service.send_notice_box(conn, "Bạn đã vượt qua leo tháp tuần này. Chúc mừng bạn");
                }
                break;
            }

            case 6: {

                conn.p.pet_mi_nuong = new Pet_mi_nuong(0, Manager.gI().get_index_mob_new(), conn.p.x, conn.p.y,
                        conn.p.map.map_id, conn.p.name, conn.p);
                Pet_mi_nuong_manager.add(conn.p.name, conn.p.pet_mi_nuong);
                //
                Message m22 = new Message(4);
                m22.writer().writeByte(1);
                m22.writer().writeShort(150);
                m22.writer().writeShort(conn.p.pet_mi_nuong.index);
                m22.writer().writeShort(conn.p.pet_mi_nuong.x);
                m22.writer().writeShort(conn.p.pet_mi_nuong.y);
                m22.writer().writeByte(-1);
                conn.addmsg(m22);
                m22.cleanup();

                break;
            }
            case 7: {
                if (conn.p.pet_mi_nuong != null && Math.abs(conn.p.pet_mi_nuong.x - conn.p.x) < 75
                        && Math.abs(conn.p.pet_mi_nuong.y - conn.p.y) < 75) {

                    m = new Message(8);
                    m.writer().writeShort(conn.p.pet_mi_nuong.index);
                    for (Player p0 : conn.p.map.players) {
                        if (p0 != null) {
                            p0.conn.addmsg(m);
                        }
                    }
                    m.cleanup();

                    // Xóa pet
                    Pet_mi_nuong_manager.remove(conn.p.pet_mi_nuong.name);
                    conn.p.pet_mi_nuong = null;

                    // Khởi tạo danh sách chứa các vật phẩm sẽ nhận được
                    List<Short> itemIDs = new ArrayList<>();
                    List<Integer> quantities = new ArrayList<>();
                    List<Short> categories = new ArrayList<>();

                    // Xác suất 1% để chọn ID 330 cho item4
                    short idItem4 = -1;  // Khởi tạo với giá trị không hợp lệ
                    int randomNumber = Util.random(1, 100);  // Tạo một số ngẫu nhiên từ 1 đến 100
                    if (randomNumber <= 1) {
                        idItem4 = 330;  // 1% cơ hội chọn ID 330
                    }

                    // Nếu item4 được chọn (idItem4 == 330)
                    if (idItem4 == 330) {
                        // Xác định số lượng ngẫu nhiên từ 1 đến 3 cho item4
                        short quantityItem4 = 1;

                        // Thêm item4 vào danh sách nhận được
                        itemIDs.add(idItem4);
                        quantities.add((int) quantityItem4);
                        categories.add((short) 4);

                        // Thêm item4 vào túi đồ
                        conn.p.item.add_item_bag47(idItem4, quantityItem4, (byte) 4);

                        // Hiển thị thông báo cho tất cả người chơi về sự kiện này
                        String message = conn.p.name + " siêu may mắn đã nhận được chìa khoá vạn năng!";
                        Manager.gI().chatKTGprocess(message);
                    }

                    short idItem7 = 0;
                    int ngaunhien = Util.ngaunhien(1, 100);  // Số ngẫu nhiên từ 1 đến 100
                    if (ngaunhien <= 60) {
                        // 80% cơ hội để chọn ID từ 116 đến 125
                        idItem7 = (short) Util.ngaunhien(116, 125);
                    } else if (ngaunhien <= 90) {
                        // 10% cơ hội để chọn ID từ 349 đến 350
                        idItem7 = (short) Util.ngaunhien(13, 14);
                    } else {
                        // 10% cơ hội để chọn ID từ 13 đến 14
                        idItem7 = (short) Util.ngaunhien(349, 350);
                    }
                    short quantityItem7 = (short) Util.ngaunhien(1, 3);

                    // Thêm item7 vào danh sách nhận được
                    itemIDs.add(idItem7);
                    quantities.add((int) quantityItem7);
                    categories.add((short) 7);
                    conn.p.item.add_item_bag47(idItem7, quantityItem7, (byte) 7);

                    int vang = Util.ngaunhien(500_000, 1_000_000);
                    conn.p.update_vang(vang);
                    itemIDs.add((short) -1);
                    quantities.add(vang);
                    categories.add((short) 4);
                    if (ngaunhien <= 60) {
                        int ngoc = Util.ngaunhien(1000, 5000);
                        conn.p.update_ngoc(ngoc);
                        itemIDs.add((short) -2);
                        quantities.add(ngoc);
                        categories.add((short) 4);
                    } else {
                        int coin = Util.ngaunhien(500, 2000);
                        conn.p.update_coin(coin);
                        itemIDs.add((short) -3);
                        quantities.add(coin);
                        categories.add((short) 4);
                    }
                    conn.p.item.char_inventory(4);

                    // Chuyển đổi danh sách sang mảng để hiển thị
                    short[] ar_id = new short[itemIDs.size()];
                    int[] ar_quant = new int[quantities.size()];
                    short[] ar_type = new short[categories.size()];
                    for (int i = 0; i < ar_id.length; i++) {
                        ar_id[i] = itemIDs.get(i);
                        ar_quant[i] = quantities.get(i);
                        ar_type[i] = categories.get(i);
                    }

                    // Hiển thị thông báo nhận được item và vàng
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ar_id, ar_quant, ar_type);
                    Event_4.add_topbxh(conn.p.name, 1);
                } else {
                    Service.send_notice_box(conn, "Không Thấy Mỵ của bạn!");
                }
                break;
            }

            case 8: {
                if (conn.p.hopdo = true) {
                    conn.p.item_replace = -1;
                    conn.p.item_replace2 = -1;
                    Service.send_box_UI(conn, 19);
                    break;
                }
            }
            case 9: {
                if (conn.p.squire != null) {
                    if (conn.p.map.map_id == 46 || conn.p.map.map_id == 48 || conn.p.map.map_id == 124) {
                        Service.send_notice_box(conn, "Không thể sử dụng trong map này!");
                        return;
                    }

                    if (!conn.p.isOwner) {
                        Service.send_notice_box(conn, "Mày chỉ là đệ không thể thao tác");
                        return;
                    }
                    Fusion fusion = new Fusion();

                    if (fusion.isFusion(conn.p) == false) {
                        conn.p.isLiveSquire = false;
                        Squire.squireLeaveMap(conn.p);
                        fusion.saveFusionStatus(conn.p, true, false, false);
                        //fusion.saveFusionStatus(conn.p, false, false, false);
                        conn.p.add_EffDefault(-127, 1000, (1000 * 15));
                        conn.p.fashion = Part_fashion.get_part(conn.p);
                        Service.send_wear(conn.p);
                        Service.send_char_main_in4(conn.p);
                        MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                        Message m2 = new Message(-49);
                        m2.writer().writeByte(2); // loại hiệu ứng 
                        m2.writer().writeShort(0);
                        m2.writer().writeByte(0);
                        m2.writer().writeByte(0);
                        m2.writer().writeByte(44); // Mã 
                        // 
                        m2.writer().writeShort(conn.p.index);
                        m2.writer().writeByte(0);
                        m2.writer().writeByte(0);
                        m2.writer().writeInt(500);

                        MapService.send_msg_player_inside(conn.p.map, conn.p, m2, true);
                        m2.cleanup();

                    } else {
                        // Nếu gọi lần thứ hai thì fusion = 0
                        Squire.callSquire(conn);
                        fusion.saveFusionStatus(conn.p, false, null, false);

                        conn.p.fashion = Part_fashion.get_part(conn.p);
                        Service.send_wear(conn.p);
                        Service.send_char_main_in4(conn.p);
                        MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                        Message m2 = new Message(-49);
                        m2.writer().writeByte(2); // loại hiệu ứng 
                        m2.writer().writeShort(0);
                        m2.writer().writeByte(0);
                        m2.writer().writeByte(0);
                        m2.writer().writeByte(44); // Mã 
                        // 
                        m2.writer().writeShort(conn.p.index);
                        m2.writer().writeByte(0);
                        m2.writer().writeByte(0);
                        m2.writer().writeInt(500);

                        MapService.send_msg_player_inside(conn.p.map, conn.p, m2, true);
                        m2.cleanup();
                    }
                } else {
                    Service.send_notice_box(conn, "chưa có đệ tử");
                }
                break;
            }

            case 10: {
                // if(conn.p.shopitem7 = true){
                // Service.send_box_UI(conn, 37);

                // }
                // Service.send_box_input_text(conn, 50, "Đổi Tên", new String[]{"Nhập Tên Cũ", "Nhập Tên Mới"});
                // BossManager.callBossToMap(1, 0, 218, 690, 426, 1, 500000, 5000, 1, 1, 1000, 0);
                // BossManager.callBossToMap(1, 0, 100, 690, 426, 1, 500000, 5000, 1, 1, 1000, 0);
                Service.send_box_input_text(conn, 52, "Eff", new String[]{""});
                //Farm.spawnEmptyPlots(conn.p);
                break;

            }

            case 11: {
                // Tăng giá trị lên 1
                testValue++;
                //Map.Sen_eff_111(conn.p, (byte) testValue);
                /* Message mw = new Message(13);
                 mw.writer().writeByte(0);
                mw.writer().writeShort(-1);
                mw.writer().writeShort(-1);
                conn.addmsg(mw);
                mw.cleanup();
                 */
                //Map.Sen_eff_111(conn.p, (byte) testValue);
                /*if(conn.p.skill_point[18] != 10){
                    Service.send_notice_box(conn, "Skill 40 chưa đạt level tối đa");   
                    return;
                }
                if(conn.p.myclan.name_clan == null){
                     Service.send_notice_box(conn, "Chưa có Clan");   
                    return;
                }
                conn.p.skill_new[0] = 1;
                Service.send_char_main_in4(conn.p);
                Service.send_notice_box(conn, "Thành Công, Hãy Thoát Game để cập nhật!");
                 */
                // conn.p.item.add_item_bag47_default((short)144, (short)1, (byte)4, 15);
                //conn.p.item.add_item_bag3_default((short)0, 1, true);
                //conn.p.item.get_item47_by_id_date(144, 15);
                //conn.p.item.char_inventory(3);

                //  Service.send_char_main_in4(conn.p);
                //an cai trang
                /*conn.p.an_wear = true; //
                conn.p.fashion = Part_fashion.get_part(conn.p);
                Service.send_wear(conn.p);
                Service.send_char_main_in4(conn.p);
                MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                 */
                // Gi? s? chúng ta mu?n g?i hi?u ?ng eff_111 (ví d?: id = 111) v?i th?i gian kéo dài là 5000 ms.
                //MenuController.sendParticleEffect(conn, (byte)2,true, 1000, -1);
                eff_npc(conn.p, (byte) 61);
                Event_5.naubanh.start();
                Event_5.naubanh.update(120);
                //conn.p.add_EffDefault(-125, 10000, 1000 * 60);

                Service.send_notice_nobox_white(conn, String.valueOf(testValue));
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }
//sendParticleEffect(conn, (byte)3,true, 100, 5000);

    public static void eff_npc(Player p, byte id_eff) throws IOException {

        Message m = new Message(-49);
        byte[] data = Util.loadfile("data/part_char/imgver/x" + p.conn.zoomlv + "/Data/" + (110 + "_" + id_eff));
        m.writer().writeByte(1); // cass trong client, 0 thì 111_ 2 thì 112_
        m.writer().writeShort(data.length);
        m.writer().write(data);
        m.writer().writeByte(0);
        m.writer().writeByte(1);
        m.writer().writeByte(id_eff);// id efff
        m.writer().writeShort(p.index); // id ng??i ch?i ho?c mob
        m.writer().writeByte(0);// 0 là ng??i ch?i, 1 là mob
        m.writer().writeByte(0);
        m.writer().writeShort(5); // th?i gian hi?u ?ng 
        m.writer().writeByte(0);
        MapService.send_msg_player_inside(p.map, p, m, true);
        p.conn.addmsg(m);
        m.cleanup();
    }

    public static void sendParticleEffect(Session conn, byte id, boolean z, int i1, int i2) throws IOException {
        Message m = new Message(76);
        m.writer().writeByte(id); // Loại hiệu ứng (3 cho hoa rơi)
        m.writer().writeBoolean(z);
        m.writer().writeShort(i1); // Số lượng hạt
        m.writer().writeShort(i2); // Thời gian tồn tại (ms)
        conn.addmsg(m);
        m.cleanup();
    }

    private static void Menu_minuong(Session conn, byte index) throws IOException, SQLException {
        switch (index) {
            case 0: {
                if (conn.p.get_ngoc() > 5) {
                    conn.p.pet_mi_nuong.update_speed(conn.p);
                } else {
                    Service.send_notice_box(conn, "Không đủ 5 ngọc");
                }
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_vuahung(Session conn, byte index) throws IOException, SQLException {
        switch (index) {
            case 0: {
                if (conn.p.pet_mi_nuong != null && Math.abs(conn.p.pet_mi_nuong.x - conn.p.x) < 75
                        && Math.abs(conn.p.pet_mi_nuong.y - conn.p.y) < 75) {

                    Message m = new Message(8);
                    m.writer().writeShort(conn.p.pet_mi_nuong.index);
                    for (Player p0 : conn.p.map.players) {
                        if (p0 != null) {
                            p0.conn.addmsg(m);
                        }
                    }
                    m.cleanup();

                    // Xóa pet
                    Pet_mi_nuong_manager.remove(conn.p.pet_mi_nuong.name);
                    conn.p.pet_mi_nuong = null;

                    // Khởi tạo danh sách chứa các vật phẩm sẽ nhận được
                    List<Short> itemIDs = new ArrayList<>();
                    List<Integer> quantities = new ArrayList<>();
                    List<Short> categories = new ArrayList<>();

                    // Xác suất 1% để chọn ID 330 cho item4
                    short idItem4 = -1;  // Khởi tạo với giá trị không hợp lệ
                    int randomNumber = Util.random(1, 100);  // Tạo một số ngẫu nhiên từ 1 đến 100
                    if (randomNumber <= 1) {
                        idItem4 = 330;  // 1% cơ hội chọn ID 330
                    }

                    // Nếu item4 được chọn (idItem4 == 330)
                    if (idItem4 == 330) {
                        // Xác định số lượng ngẫu nhiên từ 1 đến 3 cho item4
                        short quantityItem4 = 1;

                        // Thêm item4 vào danh sách nhận được
                        itemIDs.add(idItem4);
                        quantities.add((int) quantityItem4);
                        categories.add((short) 4);

                        // Thêm item4 vào túi đồ
                        conn.p.item.add_item_bag47(idItem4, quantityItem4, (byte) 4);

                        // Hiển thị thông báo cho tất cả người chơi về sự kiện này
                        String message = conn.p.name + " siêu may mắn đã nhận được chìa khoá vạn năng!";
                        Manager.gI().chatKTGprocess(message);
                    }

                    short idItem7 = 0;
                    int ngaunhien = Util.ngaunhien(1, 100);  // Số ngẫu nhiên từ 1 đến 100
                    if (ngaunhien <= 60) {
                        // 80% cơ hội để chọn ID từ 116 đến 125
                        idItem7 = (short) Util.ngaunhien(116, 125);
                    } else if (ngaunhien <= 90) {
                        // 10% cơ hội để chọn ID từ 349 đến 350
                        idItem7 = (short) Util.ngaunhien(13, 14);
                    } else {
                        // 10% cơ hội để chọn ID từ 13 đến 14
                        idItem7 = (short) Util.ngaunhien(349, 350);
                    }
                    short quantityItem7 = (short) Util.ngaunhien(1, 3);

                    // Thêm item7 vào danh sách nhận được
                    itemIDs.add(idItem7);
                    quantities.add((int) quantityItem7);
                    categories.add((short) 7);
                    conn.p.item.add_item_bag47(idItem7, quantityItem7, (byte) 7);

                    int vang = Util.ngaunhien(500_000, 1_000_000);
                    conn.p.update_vang(vang);
                    itemIDs.add((short) -1);
                    quantities.add(vang);
                    categories.add((short) 4);
                    if (ngaunhien <= 60) {
                        int ngoc = Util.ngaunhien(1000, 5000);
                        conn.p.update_ngoc(ngoc);
                        itemIDs.add((short) -2);
                        quantities.add(ngoc);
                        categories.add((short) 4);
                    } else {
                        int coin = Util.ngaunhien(500, 2000);
                        conn.p.update_coin(coin);
                        itemIDs.add((short) -3);
                        quantities.add(coin);
                        categories.add((short) 4);
                    }
                    conn.p.item.char_inventory(4);

                    // Chuyển đổi danh sách sang mảng để hiển thị
                    short[] ar_id = new short[itemIDs.size()];
                    int[] ar_quant = new int[quantities.size()];
                    short[] ar_type = new short[categories.size()];
                    for (int i = 0; i < ar_id.length; i++) {
                        ar_id[i] = itemIDs.get(i);
                        ar_quant[i] = quantities.get(i);
                        ar_type[i] = categories.get(i);
                    }

                    // Hiển thị thông báo nhận được item và vàng
                    Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ar_id, ar_quant, ar_type);
                    Event_4.add_topbxh(conn.p.name, 1);
                } else {
                    Service.send_notice_box(conn, "Không Thấy Mỵ của bạn!");
                }
                break;
            }
            case 1: {
                send_menu_select(conn, 120, ev_he.Event_4.get_top());
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_MobMiNuong(Session conn, int idmob, byte idmenu, byte index) throws IOException {
        // Kiểm tra nếu idmenu được đặt là 2, có thể là một hành động cụ thể cần thực hiện
        // if (idmenu == 2) {

        if (conn.p.level < 40) {
            Service.send_notice_box(conn, "Cần lên level 40 để có thể giải cứu Mỵ Nương.");
            return;
        }
        if (conn.p.pet_mi_nuong != null) {
            // Nếu có, hiển thị thông báo không thể dịch chuyển
            Service.send_notice_box(conn, "Bạn đã có Mỵ Không Thể dắt thêm");
            return;
        }
        ev_he.MobMiNuong mob = ev_he.Event_4.getMob(idmob);
        if (mob == null || !mob.map.equals(conn.p.map)) {
            Message m2 = new Message(17);
            m2.writer().writeShort(-1);
            m2.writer().writeShort(idmob);
            conn.addmsg(m2);
            m2.cleanup();
            Service.send_notice_box(conn, "Không tìm thấy Mỵ Nương.");
            return;
        }
        if (!(mob.map.equals(conn.p.map) && Math.abs(mob.x - conn.p.x) < 250 && Math.abs(mob.y - conn.p.y) < 250)) {
            Service.send_notice_box(conn, "Khoảng cách quá xa.\nNếu thực sự ở gần hãy thử load lại map.");
            return;
        }
        if (mob.Owner != null) {
            Service.send_notice_box(conn, "Mỵ Nương đã được giải cứu bởi người khác.");
            return;
        }
        if (conn.p.item.get_bag_able() < 1) {
            Service.send_notice_nobox_white(conn, "Hành trang đầy.");
            return;
        }
        // if (conn.p.item.total_item_by_id(4, 252) < 1) {
        // Service.send_notice_nobox_white(conn, "Bạn cần có vật phẩm đặc biệt để giải cứu Mỵ Nương.");
        // return;
        // }

        // Xử lý cho MobMiNuong
        // conn.p.item.remove(4, 252, 1);
        mob.setOwner(conn.p);

        // Tạo Pet_mi_nuong mới và thêm vào hệ thống
        conn.p.pet_mi_nuong = new Pet_mi_nuong(0, Manager.gI().get_index_mob_new(), conn.p.x, conn.p.y,
                conn.p.map.map_id, conn.p.name, conn.p);
        Pet_mi_nuong_manager.add(conn.p.name, conn.p.pet_mi_nuong);

        // Gửi thông báo cho client về Pet mới
        Message m22 = new Message(4);
        m22.writer().writeByte(1);
        m22.writer().writeShort(150);
        m22.writer().writeShort(conn.p.pet_mi_nuong.index);
        m22.writer().writeShort(conn.p.pet_mi_nuong.x);
        m22.writer().writeShort(conn.p.pet_mi_nuong.y);
        m22.writer().writeByte(-1);
        conn.addmsg(m22);
        m22.cleanup();
        //}
    }

    private static void Menu_tutien(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }
        int ad = conn.ac_admin;

        String[] danhSachCanhGioi
                = {"Phàm Nhân",
                    "Luyện Khí",
                    "Trúc Cơ",
                    "Kim Đan",
                    "Nguyên Anh",
                    "Hoá Thần",
                    "Luyện Hư",
                    "Hợp Đạo",
                    "Chân Tiên",
                    "Thiên Tiên",
                    "Kim Tiên",
                    "Tiên Vương",
                    "Tiên Đế",
                    "Phế Vật"};
        String canhgioi = conn.p.tutien >= 0 && conn.p.tutien < danhSachCanhGioi.length ? danhSachCanhGioi[conn.p.tutien] : "Phế Vật";

        switch (index) {
            case 0: {
                Service.send_notice_box(conn, "Tiên Lực chia ra  12 tầng mỗi tầng xung kích đều khó hơn 1 bậc\n"
                        + "Để Độ kiếp Thành Tiên cần có Thông Thiên Đan , 25tr vàng và 10k ngọc xanh!\n"
                        + "Độ kiếp thành công sẽ nhận 2% tiên lực cộng thẳng vào tất cả chỉ số ẩn \n"
                        + "Khi độ kiếp vượt qua các mốc sẽ up ra ngọc xanh!");

                break;
            }
            case 1: {
                if (conn.p.item.total_item_by_id(4, 328) < 100 && ad < 10) {
                    Service.send_notice_box(conn, "Không đủ 100 Thông Thiên Đan");
                    return;
                } else {
                    Service.send_notice_box(conn, "Không đủ 100 Thông Thiên Đan");
                }
                if (conn.p.level < 110 && ad < 10) {

                    Service.send_notice_box(conn, "Cần level 110");
                    return;
                }
                if (conn.p.get_vang() < 25_000_000) {
                    Service.send_notice_box(conn, "Cần 25.000.000 vàng");
                    return;
                }
                if (conn.p.get_ngoc() < 10000 && ad < 10) {
                    Service.send_notice_box(conn, "Cần 10.000 Ngọc");
                    return;
                }

                if (conn.p.get_exptt() < 2000 && ad < 10) {
                    Service.send_notice_box(conn, "Cần tối thiểu 2.000 exp Tu Tiên");
                    return;
                }

                if (conn.p.get_tutien() >= 12) {

                    Service.send_notice_box(conn, "Đã Đạt Cấp Tối Đa");
                    return;
                }

                if (conn.p.get_luyenthe() < 8 && ad < 10) {

                    Service.send_notice_box(conn, "Chưa đủ điều kiện!!");
                    return;
                }

                if (conn.p.get_kinhmach() < 12 && ad < 10) {

                    Service.send_notice_box(conn, "Chưa đủ điều kiện!!");
                    return;
                }
                int tyle = 0;
                if (conn.ac_admin == 100) {
                    tyle = 1;
                } else {
                    tyle = Util.random(100);
                }
                // Tỷ lệ cs theo % 
                if (conn.p.tutien < 1 && tyle > 30
                        || conn.p.tutien > 3 && tyle > 25
                        || conn.p.tutien > 5 && tyle > 20
                        || conn.p.tutien > 7 && tyle > 15
                        || conn.p.tutien > 8 && tyle > 10
                        || conn.p.tutien > 10 && tyle > 5
                        || conn.p.tutien > 12 && tyle > 1) {

                    conn.p.tiemnang += 3;

                    conn.p.item.remove(4, 328, 100);
                    conn.p.update_ngoc(-10000);
                    conn.p.update_exptt(-2000);
                    conn.p.update_vang(-25_000_000);
                    Service.send_char_main_in4(conn.p);
                    conn.p.item.char_inventory(4);
                    Service.send_notice_box(conn, "Độ kiếp thất bại.\n Nhận 3 điểm tiềm năng coi như an ủi!!.");
                    Player p = conn.p;

                    break;
                } else {
                    conn.p.item.remove(4, 328, 100);
                    conn.p.update_ngoc(-10_000);
                    conn.p.update_exptt(-2_000);
                    conn.p.update_vang(-25_000_000L);

                    conn.p.tutien++;

                    conn.p.item.char_inventory(4);
                    Service.send_notice_box(conn, "+ Độ Kiếp Thành Công,  \nCảnh giới hiện tại : " + canhgioi);
                    int temp = conn.p.tutien;

                    Manager.gI().chatKTGprocess("Chúc Mừng " + conn.p.name + " Đã Độ Thành Công " + canhgioi + " Kiếp!");
                    conn.p.update_Exp(1, false);
                    Service.send_char_main_in4(conn.p);

                    break;
                }
            }
            case 2: {
                Service.send_notice_box(conn, "Cảnh giới hiện tại: " + canhgioi + "\nLinh khí hiện tại: " + conn.p.get_exptt() + "");

                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_kinhmach(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }
        int ad = conn.ac_admin;
        switch (index) {
            case 0: {
                Service.send_notice_box(conn, "Kinh mạch chia ra 12 Khiếu mỗi tầng xung kích đều khó hơn 1 bậc\n"
                        + "Để đả thông kinh mạch cần có Hộ Mạch Đan , 20tr vàng và 5k ngọc xanh!\n"
                        + "Xung kích kinh mạch thành công sẽ cộng 2% điểm ẩn vào Hp \n"
                        + "Khi đạt tầng cuối bạn có thể xung kích tếp lên Tu Tiên để trở nên mạnh hơn!");

                break;
            }
            case 1: {
                if (conn.p.item.total_item_by_id(4, 327) < 100 && ad < 10) {
                    Service.send_notice_box(conn, "Không đủ 100 Hộ Mạch Đan");
                    return;
                } else {
                    Service.send_notice_box(conn, "Không đủ 100 Hộ Mạch Đan");
                }
                if (conn.p.level < 60 && ad < 10) {

                    Service.send_notice_box(conn, "Cần level 60");
                    return;
                }
                if (conn.p.get_vang() < 20_000_000 && ad < 10) {
                    Service.send_notice_box(conn, "Cần 20.000.000 vàng");
                    return;
                }
                if (conn.p.get_ngoc() < 5000 && ad < 10) {
                    Service.send_notice_box(conn, "Cần 5.000 Ngọc");
                    return;
                }

                if (conn.p.get_kinhmach() == 12) {

                    Service.send_notice_box(conn, "Đã Đạt Cấp Tối Đa");
                    return;
                }

                if (conn.p.get_luyenthe() < 8 && ad < 10) {

                    Service.send_notice_box(conn, "Chưa đủ điều kiện hãy đi rèn luyện nhục thân!!");
                    return;
                }
                int tyle = 0;
                if (conn.ac_admin == 100) {
                    tyle = 1;
                } else {
                    tyle = Util.random(100);
                }
                // Tỷ lệ cs theo % 
                if (conn.p.kinhmach < 1 && tyle > 25
                        || conn.p.kinhmach > 3 && tyle > 15
                        || conn.p.kinhmach > 5 && tyle > 10
                        || conn.p.kinhmach > 7 && tyle > 5
                        || conn.p.kinhmach > 8 && tyle > 3
                        || conn.p.kinhmach > 10 && tyle > 2
                        || conn.p.kinhmach > 12 && tyle > 1) {

                    conn.p.tiemnang += 3;
                    //conn.p.level = 139;
                    conn.p.item.remove(4, 327, 100);
                    conn.p.update_ngoc(-5000);
                    conn.p.update_vang(-20_000_000);
                    Service.send_char_main_in4(conn.p);
                    conn.p.item.char_inventory(4);
                    Service.send_notice_box(conn, "Đả thông Kinh Mạch thất bại.\n Nhận 3 điểm tiềm năng coi như an ủi!!.");
                    //Manager.gI().chatKTGprocess("Quá đen " + conn.p.name + " Đã Chuyển Sinh thất bại :(.");
                    Player p = conn.p;

                    break;
                } else {
                    //conn.p.level = 1;
                    //conn.p.exp = 0;

                    conn.p.item.remove(4, 327, 100);
                    conn.p.update_ngoc(-5_000);
                    conn.p.update_vang(-20_000_000L);

                    conn.p.kinhmach++;
                    conn.p.item.char_inventory(4);
                    Service.send_notice_box(conn, "+ Đả Thông Kinh Mạch Thành Công, Cấp Độ Kinh Mạch Hiện Tại : " + conn.p.kinhmach);
                    Manager.gI().chatKTGprocess("Chúc Mừng " + conn.p.name + " Đã Đả Thông : " + conn.p.kinhmach + " Kinh Mạch");
                    conn.p.update_Exp(1, false);
                    Service.send_char_main_in4(conn.p);
                    Player p = conn.p;

                    break;
                }
            }
            case 2: {
                Service.send_notice_box(conn, "Kinh Mạch Đã Khai Thông : " + conn.p.get_kinhmach() + "/12");

                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_luyenthe(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }
        int ad = conn.ac_admin;
        switch (index) {
            case 0: {
                Service.send_notice_box(conn, "Cảnh Giới Luyện Thể chia ra 8 tầng mỗi tầng xung kích đều khó hơn 1 bậc\n"
                        + "Để Luyện thể cần có Ngọc thể Đan ,15tr vàng và 5k ngọc xanh!\n"
                        + "Khi Luyện thể thành công sẽ cộng 2% ẩn vào Thể Lực\n"
                        + "Khi đạt tầng cuối bạn có thể xung kích tếp kinh mạch để trở nên mạnh hơn!");

                break;
            }
            case 1: {
                if (conn.p.item.total_item_by_id(4, 326) < 100 && ad < 10) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc Thể Đan");
                    return;
                } else {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc Thể Đan");
                }
                if (conn.p.level < 60 && ad < 10) {

                    Service.send_notice_box(conn, "Cần level 60");
                    return;
                }
                if (conn.p.get_vang() < 15_000_000 && ad < 10) {
                    Service.send_notice_box(conn, "Cần 15.000.000 vàng");
                    return;
                }
                if (conn.p.get_ngoc() < 5000 && ad < 10) {
                    Service.send_notice_box(conn, "Cần 5.000 Ngọc");
                    return;
                }

                if (conn.p.get_luyenthe() == 8) {

                    Service.send_notice_box(conn, "Đã Đạt Cấp Tối Đa");
                    return;
                }
                int tyle = 0;
                if (conn.ac_admin == 100) {
                    tyle = 1;
                } else {
                    tyle = Util.random(100);
                }
                // Tỷ lệ cs theo % 
                if (conn.p.luyenthe < 1 && tyle > 25
                        || conn.p.luyenthe > 3 && tyle > 15
                        || conn.p.luyenthe > 5 && tyle > 10
                        || conn.p.luyenthe > 7 && tyle > 3
                        || conn.p.luyenthe > 8 && tyle > 5) {

                    conn.p.tiemnang += 3;
                    //conn.p.level = 139;
                    conn.p.item.remove(4, 326, 100);
                    conn.p.update_ngoc(-5000);
                    conn.p.update_vang(-15_000_000);
                    Service.send_char_main_in4(conn.p);
                    conn.p.item.char_inventory(4);
                    Service.send_notice_box(conn, "Luyện Thể thất bại.\n Nhận 3 điểm tiềm năng coi như an ủi!!.");
                    //Manager.gI().chatKTGprocess("Quá đen " + conn.p.name + " Đã Chuyển Sinh thất bại :(.");
                    Player p = conn.p;

                    break;
                } else {
                    //conn.p.level = 1;
                    //conn.p.exp = 0;

                    conn.p.item.remove(4, 326, 100);
                    conn.p.update_ngoc(-5_000);
                    conn.p.update_vang(-15_000_000L);

                    conn.p.luyenthe++;
                    conn.p.item.char_inventory(4);
                    Service.send_notice_box(conn, "+ Luyện Thể Thành Công, Cấp Độ Nhục Thân Hiện Tại : " + conn.p.luyenthe);
                    Manager.gI().chatKTGprocess("Chúc Mừng " + conn.p.name + " Đã Tu Luyện Nhục Thân Lên Cấp : " + conn.p.luyenthe + "");
                    conn.p.update_Exp(1, false);
                    Service.send_char_main_in4(conn.p);
                    Player p = conn.p;

                    break;
                }
            }
            case 2: {
                Service.send_notice_box(conn, "Cấp Độ Nhục Thân Hiện Tại : " + conn.p.get_luyenthe() + "/8");

                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_MocNap(Session conn, byte index) throws IOException, SQLException {
        if (!conn.p.isOwner) {
            return;
        }
        switch (index) {
            case 0: {
                send_menu_select(conn, 560, new String[]{"Mốc 50k", "Mốc 100k", "Mốc 200k", "Mốc 500k", "Mốc 1M", "Mốc 1m5", "Mốc 2M", "Mốc 3M", "Mốc 4M", "Mốc 5M"});
                break;
            }
            case 1: {
                Service.send_notice_box(conn,
                        "Khi các bạn tiến hành nạp game thì sẽ được cộng vào tổng nạp, có thể nhận luân hồi"
                        + "\nCó các mốc và quà: 50k 100k, 200k, 500k, 1m, 1m5, 2m, 3m...."
                        + "\n + Khi nạp đủ các bạn sẽ được nhận quà"
                        + "\n + hãy lên web: http://xnxx.com để xem chi tiết quà tặng"
                        + "\n + các mốc cố dòng mề thì hãy nhắn ad để được thêm dòng mề, nhận xong mốc 5tr thì nhắn ad để ad reset mốc nạp cho bạn nhé có thể cộng dồn lên mốc tiếp theo");
                break;
            }

            case 2: {
                String percents = String.format("%,.0f", (((float) conn.p.get_tongnap())));
                Service.send_notice_box(conn, "Bạn đã nạp tổng cộng là : " + percents + " VND!");
            }

        }

    }

    private static void Menu_Zoro(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }
        if (conn.p.myclan != null) {
            if (conn.p.myclan.mems.get(0).name.equals(conn.p.name)) {
                switch (index) {
                    case 0: {
                        send_menu_select(conn, 122,
                                new String[]{"Kho bang", "Nâng cấp bang", "Hủy bang hội", "Chuyển thủ lĩnh"});
                        break;
                    }
                    case 1: { //
                        Service.send_box_UI(conn, 29);
                        break;
                    }
                    case 2: {
                        Service.send_box_UI(conn, 30);
                        break;
                    }
                    default: {
                        Service.send_notice_box(conn, "Chưa có chức năng");
                        break;
                    }
                }
            } else {
                switch (index) {
                    case 0: {
                        conn.p.myclan.open_box_clan(conn);
                        break;
                    }
                    case 1: {
                        Service.send_box_input_text(conn, 8, "Góp vàng", new String[]{"Số lượng :"});
                        break;
                    }
                    case 2: {
                        Service.send_box_input_text(conn, 9, "Góp Ngọc", new String[]{"Số lượng :"});
                        break;
                    }
                    case 3: {
                        Service.send_box_input_text(conn, 43, "Chát Bang", new String[]{""});

                        break;
                    }
                    case 4: {
                        Service.send_box_input_yesno(conn, 117,
                                "Hãy xác nhận việc rời bang, có khi đi rồi quay lại éo đc đâu nhá");
                        break;
                    }
                    default: {
                        Service.send_notice_box(conn, "Chưa có chức năng");
                        break;
                    }
                }
            }
        } else {
            switch (index) {
                case 0: {
                    Service.send_box_input_yesno(conn, 70, "Bạn có muốn đăng ký tạo bang với phí là 20.000 ngọc");
                    break;
                }
                default: {
                    Service.send_notice_box(conn, "Chưa có chức năng");
                    break;
                }
            }
        }
    }

    private static void Menu_Benjamin(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }
        if (conn.p.myclan != null) {
            if (conn.p.myclan.mems.get(0).name.equals(conn.p.name)) {
                switch (index) {
                    case 0: {
                        send_menu_select(conn, 122,
                                new String[]{"Kho bang", "Nâng cấp bang", "Hủy bang hội", "Chuyển thủ lĩnh"});
                        break;
                    }
                    case 1: { //
                        Service.send_box_UI(conn, 29);
                        break;
                    }
                    case 2: {
                        Service.send_box_UI(conn, 30);
                        break;
                    }
                    default: {
                        Service.send_notice_box(conn, "Chưa có chức năng");
                        break;
                    }
                }
            } else {
                switch (index) {
                    case 0: {
                        conn.p.myclan.open_box_clan(conn);
                        break;
                    }
                    case 1: {
                        Service.send_box_input_text(conn, 8, "Góp vàng", new String[]{"Số lượng :"});
                        break;
                    }
                    case 2: {
                        Service.send_box_input_text(conn, 9, "Góp Ngọc", new String[]{"Số lượng :"});
                        break;
                    }
                    case 3: {
                        Service.send_box_input_yesno(conn, 117,
                                "Hãy xác nhận việc rời bang, có khi đi rồi quay lại éo đc đâu nhá");
                        break;
                    }
                    default: {
                        Service.send_notice_box(conn, "Chưa có chức năng");
                        break;
                    }
                }
            }
        } else {
            switch (index) {
                case 0: {
                    Service.send_box_input_yesno(conn, 70, "Bạn có muốn đăng ký tạo bang với phí là 20.000 ngọc");
                    break;
                }
                default: {
                    Service.send_notice_box(conn, "Chưa có chức năng");
                    break;
                }
            }
        }
    }

    private static void Menu_VXMM(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }
        switch (index) {
            case 0: {
                Manager.gI().vxmm.send_in4(conn.p);
                break;
            }
            case 1: {
                Service.send_box_input_text(conn, 3, "Vòng xoay vàng", new String[]{"Tham gia (tối thiểu 10k) :"});
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_VXKC(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }
        switch (index) {
            case 0: {
                Manager.gI().vxkc.send_in4(conn.p);
                break;
            }
            case 1: {
                Service.send_box_input_text(conn, 17, "Vòng xoay ngọc", new String[]{"Tham gia (tối thiểu 500) :"});
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_CuopBien(Session conn, byte index) throws IOException {
        if (!conn.p.isOwner) {
            return;
        }
        switch (index) {
            case 0: {
                send_menu_select(conn, 125, new String[]{"Xem thông tin", "Tham gia"});
                break;
            }
            case 1: {
                if (!Manager.isLockKC) {
                    Service.send_notice_box(conn, "Chức Năng Đang Tạm Khoá!");
                    return;
                }

                send_menu_select(conn, 132, new String[]{"Xem thông tin", "Tham gia"});
                //Service.send_notice_box(conn, "Sắp ra mắt");
                break;
            }
            case 2: {
                Service.send_notice_box(conn, "Sắp ra mắt");
                break;
            }
            case 3: {

                if (!Manager.isLockTaiXiu) {
                    Service.send_notice_box(conn, "Chức Năng Đang Tạm Khoá!");
                    return;
                }
                send_menu_select(conn, 113, new String[]{"Tham gia", "Kết quả", "Lịch Sử"});
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    public static void send_menu_select(Session conn, int idnpc, String[] menu) throws IOException {
        if (!conn.p.isdie) {
            if (menu != null && menu.length > 0) {
                Message m2 = new Message(-30);
                m2.writer().writeShort(idnpc);
                m2.writer().writeByte(0);
                m2.writer().writeByte(menu.length);
                for (int i = 0; i < menu.length; i++) {
                    m2.writer().writeUTF(menu[i]);
                }
                if (conn.ac_admin > 10) {
                    m2.writer().writeUTF("MENU : " + idnpc);
                } else {
                    m2.writer().writeUTF("MENU");
                }
                conn.addmsg(m2);
                m2.cleanup();
            }
        }
    }

    public static void send_menu_select(Session conn, int idnpc, String[] menu, byte idmenu) throws IOException {
        if (!conn.p.isdie) {
            if (menu != null && menu.length > 0) {
                Message m2 = new Message(-30);
                m2.writer().writeShort(idnpc);
                m2.writer().writeByte(idmenu);
                m2.writer().writeByte(menu.length);
                for (int i = 0; i < menu.length; i++) {
                    m2.writer().writeUTF(menu[i]);
                }
                if (conn.ac_admin > 0) {
                    m2.writer().writeUTF("MENU : " + idnpc);
                } else {
                    m2.writer().writeUTF("MENU");
                }
                conn.addmsg(m2);
                m2.cleanup();
            }
        }
    }

    private static void Menu_Aman(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                conn.p.item.char_chest(3);
                conn.p.item.char_chest(4);
                conn.p.item.char_chest(7);
                conn.p.type_process_chest = false;
                Message m = new Message(23);
                m.writer().writeUTF("Rương đồ");
                m.writer().writeByte(3);
                m.writer().writeShort(0);
                conn.addmsg(m);
                m.cleanup();

                //Service.send_box_UI(conn, 48);

                //Service.send_box_UI(conn, 48);
                break;
            }
            case 1: {
                if (conn.p.maxbag >= 126) {
                    Service.send_notice_box(conn, "Đã mở rương rồi!");
                    return;
                }
                try (Connection connection = SQL.gI().getConnection(); Statement statement = connection.createStatement();) {
                    if (statement.executeUpdate("UPDATE `player` SET `maxbag` = 126 WHERE `id` = " + conn.p.index + ";") > 0) {
                        connection.commit();
                    }
                    Service.send_notice_box(conn, "Mở thành công 126 ô, hãy thoát game vào lại để cập nhật!");
                } catch (SQLException e) {
                    e.printStackTrace();
                    //     Service.send_notice_box(conn, "Có lỗi xảy ra, hãy thử lại!");
                }
                break;
            }
            case 2: {

                if (conn.user.contains("knightauto_hsr_")) {
                    if (conn.p.level < 10) {
                        Service.send_notice_box(conn, "Đạt level 10 mới có thể đăng ký tài khoản");
                        return;
                    }
                    Service.send_box_input_text(conn, 6, "Nhập thông tin",
                            new String[]{"Tên đăng nhập mới", "Mật khẩu mới"});
                } else {
                    Service.send_notice_box(conn, "Chức năng đang phát triển...");
                }
                break;
            }
            case 3: { // Chức năng chuyển sinh mới theo yêu cầu
    if (!Manager.ischuyensinh) {
        Service.send_notice_box(conn, "Chức Năng Đang Tạm Khoá!");
        return;
    }
    
    if (!conn.p.isOwner) {
            Service.send_notice_box(conn, "Em chỉ là đệ thôi! ");
            return;
        }

    // Admin không cần kiểm tra vàng ngọc và luôn thành công
    if (conn.ac_admin == 100) {
        conn.p.level = 10;
        conn.p.exp = 0;
        conn.p.mm_cs = 0; // Reset điểm chuyển sinh
        conn.p.update_chuyensinh(1);
        
        // Cập nhật tài nguyên và thông báo
        conn.p.item.remove(7, 494, 5);
        conn.p.update_ngoc(-5000);
        conn.p.update_vang(-10_000_000);
        conn.p.tiemnang = (short) (conn.p.tiemnang / 2);

        Service.send_char_main_in4(conn.p);
        Service.send_notice_box(conn, "+ Chuyển Sinh Thành công! Bạn là admin, chuyển sinh miễn phí.");
        Manager.gI().chatKTGprocess("Chúc Mừng " + conn.p.name + " Đã Chuyển Sinh Thành Công!");

        break;
    }

    // Kiểm tra các yêu cầu cần thiết (vàng, ngọc, level)
    if (conn.p.item.total_item_by_id(7, 494) < 5) {
        Service.send_notice_box(conn, "Không đủ 5 ngọc chuyển sinh");
        return;
    }
    if (conn.p.level < 140) {
        Service.send_notice_box(conn, "Cần level 140");
        return;
    }
    if (conn.p.get_vang() < 10_000_000) {
        Service.send_notice_box(conn, "Cần 10.000.000 vàng");
        return;
    }
    if (conn.p.get_ngoc() < 5000) {
        Service.send_notice_box(conn, "Cần 5.000 Ngọc");
        return;
    }
    
                    if (conn.p.get_chuyensinh() == 50
                        || conn.p.get_chuyensinh() == 100
                        || conn.p.get_chuyensinh() == 150
                        || conn.p.get_chuyensinh() == 300
                        || conn.p.get_chuyensinh() == 500
                        || conn.p.get_chuyensinh() == 1000) {

                    Service.send_notice_box(conn, "Bạn đã quá mạnh hãy Mở giới hạn");
                    return;
                }
                

    // Tính toán tỷ lệ thành công
    int successRate = 0;

    // Cộng thêm 10% nếu là VIP >= 5
    if (conn.vip >= 5) {
        successRate += 10;
    }

    // Xác định tỷ lệ thành công dựa trên số lần chuyển sinh
    if (conn.p.get_chuyensinh() <= 10) {
        successRate += 50;
    } else if (conn.p.get_chuyensinh() <= 20) {
        successRate += 25;
    } else if (conn.p.get_chuyensinh() <= 30) {
        successRate += 15;
    } else if (conn.p.get_chuyensinh() <= 35) {
        successRate += 13;
    } else if (conn.p.get_chuyensinh() <= 40) {
        successRate += 7;
    } else if (conn.p.get_chuyensinh() <= 50) {
        successRate += 5;
    } else if (conn.p.get_chuyensinh() <= 1000) {
        successRate += conn.p.mm_cs / 4; // Dựa vào mm_cs cho CS từ 50 đến 1000
    }

    // Nếu tỷ lệ thành công đủ cao thì chuyển sinh thành công
    if (Util.random(100) < successRate) {
        conn.p.level = 10;
        conn.p.exp = 0;
           if (conn.p.get_chuyensinh() >= 10) {
        conn.p.mm_cs = 1; // Reset lại điểm chuyển sinh
        }
        conn.p.update_chuyensinh(1);
        
        // Cập nhật tài nguyên và thông báo
        conn.p.item.remove(7, 494, 5);
        conn.p.update_ngoc(-5000);
        conn.p.update_vang(-10_000_000);
       // conn.p.tiemnang = (short) (conn.p.tiemnang / 2);

        Service.send_char_main_in4(conn.p);
        Service.send_notice_box(conn, "+ Chuyển Sinh Thành công! Chúc bạn chơi vui vẻ.");
        Manager.gI().chatKTGprocess("Chúc Mừng " + conn.p.name + " Đã Chuyển Sinh Thành Công!");
    } else {
        // Nếu thất bại, tăng điểm chuyển sinh và giảm tài nguyên
        conn.p.mm_cs += 1;
        conn.p.tiemnang += 5;
        conn.p.level = 139;

        conn.p.item.remove(7, 494, 1); // Trừ một ngọc chuyển sinh
        conn.p.update_ngoc(-2500);
        conn.p.update_vang(-5_000_000);

        Service.send_char_main_in4(conn.p);
        Service.send_notice_box(conn, "Chuyển Sinh Thất Bại! Hãy thử lại sau.");
        Manager.gI().chatKTGprocess("Quá đen " + conn.p.name + " Đã Chuyển Sinh thất bại :(.");
    }
    break;
}


            case 4: {
                Service.send_notice_box(conn, "Số Lần Chuyển Sinh: " + conn.p.get_chuyensinh() + "\n Tỉ lệ may mắn: " + conn.p.get_mm_cs() / 2 + "%");

                break;
            }

            case 5: {
                // Service.send_box_input_yesno(conn, 89,
                // "Bạn có muốn đổi 20 điểm cs lấy một món thần ngẫu nhiên?\n Tất Cả chỉ số sẽ mất hết làm lại từ đầu !");
                break;
            }

            case 6: {

                /////
                if (conn.p.get_ngoc() < 5000) {
                    Service.send_notice_box(conn, "Cần 5.000 Ngọc");
                    return;
                }
                if (conn.p.exp >= 0) {
                    Service.send_notice_box(conn, "Mày có bị âm đâu, Muốn bay acc không?");
                    break;

                } else {

                    conn.p.exp = 0;

                    conn.p.update_ngoc(-5_000);

                    Service.send_notice_box(conn, "Xoá exp âm thành công");
                    //Manager.gI().chatKTGprocess("Thằng Đặc Cầu " + conn.p.name + " Đã Fix âm exp thành công");
                    conn.p.update_Exp(1, false);
                    Service.send_char_main_in4(conn.p);
                    Player p = conn.p;

                }
                break;
            }

            case 7: {

                if (!conn.p.isOwner) {
                    Service.send_notice_box(conn, "Mày chỉ là đệ không thể thao tác");
                    return;
                }

                /////
                if (conn.p.get_ngoc() < 150000) {
                    Service.send_notice_box(conn, "Cần 150.000 Ngọc");
                    return;
                }
                
                if (conn.p.get_chuyensinh() >= Manager.gI().chuyen_sinh) {
                Service.send_notice_box(conn, "Đạt Giới Hạn Hiện Tại Của Sever!");
                return;
                  }

                int ve = (3 * (conn.p.get_chuyensinh() + 1)) * 1;

                if (conn.p.item.total_item_by_id(7, 495) < ve && conn.ac_admin < 3) {
                    Service.send_notice_box(conn, "Không đủ " + ve + " vé Mở Giới Hạn");
                    return;
                }

                if (conn.p.chuyensinh != 50
                        && conn.p.chuyensinh != 100
                        && conn.p.chuyensinh != 150
                        && conn.p.chuyensinh != 300
                        && conn.p.chuyensinh != 500
                        && conn.ac_admin < 3) {
                    Service.send_notice_box(conn, "Chưa đủ điều kiện");
                    break;

                } else {

                    if (conn.p.get_chuyensinh() == 50) {
                        conn.p.chuyensinh = 51;

                    } else if (conn.p.chuyensinh == 100) {
                        conn.p.chuyensinh = 101;

                    } else if (conn.p.chuyensinh == 150) {
                        conn.p.chuyensinh = 151;
                    } else if (conn.p.chuyensinh == 300) {
                        conn.p.chuyensinh = 301;
                    } else if (conn.p.chuyensinh == 500) {
                        conn.p.chuyensinh = 501;
                    }

                    conn.p.update_ngoc(-150_000);

                    conn.p.item.remove(7, 495, ve);

                    conn.p.item.char_inventory(7);
                    conn.p.item.char_inventory(5);

                    Service.send_notice_box(conn, "Mở giới hạn thành công");
                    Manager.gI().chatKTGprocess("Thằng Đặc Cầu " + conn.p.name + " Đã Mở giới hạn Chuyển sinh");
                    conn.p.update_Exp(1, false);
                    Service.send_char_main_in4(conn.p);
                    Player p = conn.p;

                }
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Black_Eye(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                Service.send_box_UI(conn, 13);
                break;
            }
            case 1: {
                Service.send_box_UI(conn, 14);
                break;
            }
            case 2: {
                Service.send_box_UI(conn, 15);
                break;
            }
            case 3: {
                Service.send_box_UI(conn, 16);
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_BXH(Session conn, byte index) throws IOException {

        switch (index) {
            case 0: {
                BXH.send(conn, 0);
                break;
            }

            case 1: {
                BXH.send(conn, 1);
                break;
            }

            case 2: {
                // String[] list = new String[Math.min(20, BXH.BXH_clan.size())];
                // for (int i = 0; i < list.length; i++) {
                // list[i] = ("Top " + (i + 1) + " : " + BXH.BXH_clan.get(i).name_clan + "(" + BXH.BXH_clan.get(i).name_clan_shorted + ") " + BXH.BXH_clan.get(i).icon + " Vàng");
                // }
                // if (list.length > 0) {
                // send_menu_select(conn, 603, list);
                // } else {
                // Service.send_notice_box(conn, "Chưa có thong tin");
                // }

                send_menu_select(conn, 605, new String[]{"Bang Hùng Mạnh Nhất", "Bang Giàu Có Nhất", "Bang Nhiều Châu Báu Nhất"});
                break;
            }

            case 3: {
                BXH.send(conn, 2);
                break;
            }

            case 4: {
                BXH.send(conn, 3);
                break;
            }

            case 5: {
                BXH.send(conn, 4);
                break;
            }

            case 6: {
                BXH.send(conn, 5);
                break;
            }

            case 7: {
                BXH.send(conn, 6);
                break;
            }

            case 8: {
                //Service.send_box_input_text(conn, 41, "Nhập Dữ Liệu", new String[]{"Xúc Xắc A", "Xúc Xắc B", "Xúc Xắc C"});
                BXH.send(conn, 7);
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chức Năng Đang Bảo Trì!");
                break;

            }
        }
    }

    private static void Menu_showClan(Session conn, byte index) throws IOException {

        switch (index) {
            case 0: { // level
                String[] list = new String[Math.min(20, BXH.BXH_clan.size())];

                for (int i = 0; i < list.length; i++) {
                    Clan clan = BXH.BXH_clan.get(i);
                    int percentExp = (int) ((clan.exp * 100) / Level.entrys.get(clan.level - 1).exp); // Giả sử Level.entrys.get(clan.level - 1).exp trả về exp cần thiết cho cấp độ tiếp theo
                    list[i] = ("Top " + (i + 1) + " : " + clan.name_clan + "[" + clan.name_clan_shorted + "] - Level: " + clan.level + " - Exp: " + percentExp + "%");
                }
                if (list.length > 0) {
                    send_menu_select(conn, 603, list);
                } else {
                    Service.send_notice_box(conn, "Chưa có thong tin");
                }
                break;
            }

            case 1: { // vàng
                String[] list = new String[Math.min(20, BXH.BXH_clan_vang.size())];
                for (int i = 0; i < list.length; i++) {
                    list[i] = ("Top " + (i + 1) + " : " + BXH.BXH_clan_vang.get(i).name_clan + "[" + BXH.BXH_clan_vang.get(i).name_clan_shorted + "] - " + BXH.BXH_clan_vang.get(i).vang + " Vàng");
                }
                if (list.length > 0) {
                    send_menu_select(conn, 603, list);
                } else {
                    Service.send_notice_box(conn, "Chưa có thong tin");
                }
                break;
            }

            case 2: {// ngọc
                String[] list = new String[Math.min(20, BXH.BXH_clan_ngoc.size())];
                for (int i = 0; i < list.length; i++) {
                    list[i] = ("Top " + (i + 1) + " : " + BXH.BXH_clan_ngoc.get(i).name_clan + "[" + BXH.BXH_clan_ngoc.get(i).name_clan_shorted + "] - " + BXH.BXH_clan_ngoc.get(i).kimcuong + " Ngọc");
                }
                if (list.length > 0) {
                    send_menu_select(conn, 603, list);
                } else {
                    Service.send_notice_box(conn, "Chưa có thong tin");
                }

                break;
            }

            default: {
                Service.send_notice_box(conn, "Chức Năng Đang Bảo Trì!");
                break;

            }
        }
    }

    private static void Menu_ChangeOptionItem(Session conn, byte index) throws IOException {
        if (conn.p.it_change_op != null && conn.p.it_change_op_index != -1) {

            Item3 temp = conn.p.it_change_op;
            if ((temp.id >= 4656 && temp.id <= 4675) || temp.type == 103 || temp.icon == 13165) {
                Service.send_notice_box(conn, "Không thể đổi chỉ số nhẫn cưới và trang bị tinh tú!");
                return;
            }

            Option op = conn.p.it_change_op.op.get(conn.p.it_change_op_index);

            // if (!(op_change.id >= 0 && op_change.id <= 38)) {
            // Service.send_notice_box(conn, "Không Thể đổi dòng này");
            // } else 
            if (index == 0) {
                if (op.id >= 0 && op.id <= 4) {
                    op.id = (byte) Util.ngaunhien(0, 4);
                } else if (op.id >= 5 && op.id <= 6) {
                    op.id = (byte) Util.ngaunhien(5, 6);
                } else if (op.id >= 7 && op.id <= 11) {
                    op.id = (byte) Util.ngaunhien(7, 11);
                } else if (op.id >= 12 && op.id <= 13) {
                    op.id = (byte) Util.ngaunhien(7, 13);
                } else if (op.id >= 14 && op.id <= 22) {
                    op.id = (byte) Util.ngaunhien(14, 22);
                } else if (op.id >= 23 && op.id <= 26) {
                    op.id = (byte) Util.ngaunhien(23, 26);
                } else if (op.id >= 27 && op.id <= 28) {
                    op.id = (byte) Util.ngaunhien(27, 28);
                } else if (op.id >= 29 && op.id <= 32) {
                    op.id = (byte) Util.ngaunhien(29, 32);
                } else if (op.id >= 33 && op.id <= 36) {
                    op.id = (byte) Util.ngaunhien(33, 36);
                } else if (op.id >= 37 && op.id <= 38) {
                    op.id = (byte) Util.ngaunhien(37, 38);
                } else if (op.id >= 58 && op.id <= 60) {
                    Service.send_notice_box(conn, "Không thể đổi dòng này!");
                    return;
                } else {
                    Service.send_notice_box(conn, "Không thể đổi dòng này!");
                    return;
                }
                Service.send_box_input_yesno(conn, 108, "Xác nhận đổi dòng " + conn.p.it_change_op.name + " ?");
            } else {
                if ((temp.id >= 4587 && temp.id <= 4590)) {
                    Service.send_notice_box(conn, "Không thể buff dòng mề đay!");
                    return;
                } else if (op.id >= 58 && op.id <= 60) {
                    Service.send_notice_box(conn, "Không thể buff dòng này!");
                    return;
                } else {
                    int old = op.getParam(0);
                    OptionItem op_temp = OptionItem.get(op.id);
                    op.setParam(old + ((op_temp.getIspercent() == 1) ? Util.random(5, 50) : Util.random(2, 20)));
                    Service.send_box_input_yesno(conn, 109, "Xác nhận buff dòng " + conn.p.it_change_op.name + " ?");
                }
            }
        }
    }

    private static void Menu_BXHCLAN(Session conn, byte index) throws IOException {
        switch (index) {
            case 1: {
                String[] list = new String[Math.min(20, BXH.BXH_clan.size())];
                for (int i = 0; i < list.length; i++) {
                    list[i] = ("Hạng " + (i + 1) + " : "
                            + BXH.BXH_clan.get(i).name_clan
                            + " - " + BXH.BXH_clan.get(i).name_clan_shorted
                            + "\n Vàng : " + BXH.BXH_clan.get(i).vang) + " - ";

                }
                if (list.length > 0) {
                    send_menu_select(conn, 120, list);
                } else {
                    Service.send_notice_box(conn, "Chưa có thong tin");
                }

                break;
            }

            default: {
                Service.send_notice_box(conn, "Chức Năng Đang Được Bảo Trì");
                break;
            }
        }
    }

    private static void Menu_Miss_Anna(Session conn, byte index) throws IOException {
        if ((conn.status != 1 && index == 0)) {
            Service.send_notice_box(conn, "Tài Khoản chưa kích hoạt ");
            return;
        }

        switch (index) {
            case 0: {

                Service.send_box_input_text(conn, 0, "Nhập mã code", new String[]{"Code"});
                break;
            }

            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9: {
                if (conn.p.item.wear[index + 9] == null) {
                    Service.send_notice_box(conn, "Mặc đâu mà tháo");
                } else if (conn.p.item.get_bag_able() > 0) {
                    Item3 buffer = conn.p.item.wear[index + 9];
                    conn.p.item.wear[index + 9] = null;
                    if (buffer.id != 3599 && buffer.id != 3593 && buffer.id != 3596) {
                        conn.p.item.add_item_bag3(buffer);
                    }
                    conn.p.item.char_inventory(3);
                    conn.p.fashion = Part_fashion.get_part(conn.p);
                    Service.send_wear(conn.p);
                    Service.send_char_main_in4(conn.p);
                    MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                    Service.send_notice_box(conn, "Tháo thành công");
                    //
                    if (index == 2 && conn.p.pet_di_buon != null) {
                        Message mout = new Message(8);
                        mout.writer().writeShort(conn.p.pet_di_buon.index);
                        for (int i = 0; i < conn.p.map.players.size(); i++) {
                            Player p0 = conn.p.map.players.get(i);
                            if (p0 != null) {
                                p0.conn.addmsg(mout);
                            }
                        }
                        mout.cleanup();
                        //
                        Pet_di_buon_manager.remove(conn.p.pet_di_buon.name);
                        conn.p.pet_di_buon = null;
                    }
                } else {
                    Service.send_notice_box(conn, "Hành trang đầy!");
                }
                break;
            }
            case 10: {
                // bán đồ cho member
                try (Connection connection = SQL.gI().getConnection(); Statement st = connection.createStatement(); Statement ps = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM `giftcode2` WHERE `name_player` = '" + conn.p.name + "' AND `type_gift` = '2' AND `status` = '0';")) {
                    byte empty_box = (byte) 0;
                    if (!rs.next()) {
                        Service.send_notice_box(conn, "Không tìm thấy đơn hàng, hoặc bạn đã nhận trước đó!");
                        return;
                    }
                    String mess = rs.getString("logger");
                    empty_box = rs.getByte("empty_box");
                    if (conn.p.item.get_bag_able() >= empty_box) {
                        if (ps.executeUpdate("UPDATE `giftcode2` SET `status` = '1' WHERE `id` = '" + rs.getInt("id") + "';") > 0) {
                            connection.commit();
                        }
                        JSONArray jsar = (JSONArray) JSONValue.parse(rs.getString("item3_defauft"));
                        for (int i = 0; i < jsar.size(); i++) {
                            JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                            if (jsar2 == null || jsar2.size() < 1) {
                                continue;
                            }
                            Item3 itbag = new Item3();
                            short it = Short.parseShort(jsar2.get(0).toString());
                            short date = Short.parseShort(jsar2.get(1).toString());
                            itbag.id = it;
                            itbag.name = ItemTemplate3.item.get(it).getName();
                            itbag.clazz = ItemTemplate3.item.get(it).getClazz();
                            itbag.type = ItemTemplate3.item.get(it).getType();
                            itbag.level = ItemTemplate3.item.get(it).getLevel();
                            itbag.icon = ItemTemplate3.item.get(it).getIcon();
                            itbag.op = new ArrayList<>();
                            itbag.op.addAll(ItemTemplate3.item.get(it).getOp());
                            itbag.color = ItemTemplate3.item.get(it).getColor();
                            itbag.part = ItemTemplate3.item.get(it).getPart();
                            itbag.tier = 0;
                            itbag.time_use = 0;
                            itbag.islock = false;
                            if (date > 0) {
                                //     itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * date;
                            }
                            conn.p.item.add_item_bag3(itbag);
                        }
                        jsar.clear();
                        jsar = (JSONArray) JSONValue.parse(rs.getString("item3"));
                        for (int i = 0; i < jsar.size(); i++) {
                            JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                            if (jsar2 == null || jsar2.size() < 1) {
                                continue;
                            }
                            Item3 itbag = new Item3();
                            short it = Short.parseShort(jsar2.get(0).toString());
                            short date = Short.parseShort(jsar2.get(1).toString());
                            itbag.id = it;
                            itbag.name = ItemTemplate3.item.get(it).getName();
                            itbag.clazz = ItemTemplate3.item.get(it).getClazz();
                            itbag.type = ItemTemplate3.item.get(it).getType();
                            itbag.level = ItemTemplate3.item.get(it).getLevel();
                            itbag.icon = ItemTemplate3.item.get(it).getIcon();
                            itbag.op = new ArrayList<>();
                            itbag.op.addAll(ItemTemplate3.item.get(it).getOp());
                            itbag.color = ItemTemplate3.item.get(it).getColor();
                            itbag.part = ItemTemplate3.item.get(it).getPart();
                            itbag.tier = 0;
                            itbag.time_use = 0;
                            itbag.islock = true;
                            if (itbag.islock) {
                                itbag.name += " [Khóa]";
                            }
                            if (date > 0) {
                                //     itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * date;
                            }
                            conn.p.item.add_item_bag3(itbag);
                        }
                        jsar.clear();

                        //
                        jsar = (JSONArray) JSONValue.parse(rs.getString("item4"));
                        for (int i = 0; i < jsar.size(); i++) {
                            JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                            Item47 itbag = new Item47();
                            itbag.id = Short.parseShort(jsar2.get(0).toString());
                            itbag.quantity = Short.parseShort(jsar2.get(1).toString());
                            itbag.category = 4;
                            conn.p.item.add_item_bag47(4, itbag);
                        }
                        jsar.clear();
                        //
                        jsar = (JSONArray) JSONValue.parse(rs.getString("item7"));
                        for (int i = 0; i < jsar.size(); i++) {
                            JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                            Item47 itbag = new Item47();
                            itbag.id = Short.parseShort(jsar2.get(0).toString());
                            itbag.quantity = Short.parseShort(jsar2.get(1).toString());
                            itbag.category = 7;
                            conn.p.item.add_item_bag47(7, itbag);

                        }
                        jsar.clear();
                        conn.p.update_vang(rs.getLong("vang"));
                        conn.p.update_ngoc(rs.getLong("ngoc"));
                        conn.p.update_coin(rs.getInt("coin"));
                        conn.p.update_naptuan(rs.getInt("naptuan"));
                        conn.p.update_tongnap(rs.getInt("tongnap"));
                        Log.gI().add_log(conn.p.name, "Get order :" + rs.getInt("id"));
                        conn.p.item.char_inventory(5);
                        conn.p.item.char_inventory(3);
                        conn.p.item.char_inventory(4);
                        conn.p.item.char_inventory(7);

                        Service.send_notice_box(conn, mess);
                    } else {

                        Service.send_notice_box(conn, "Hành trang phải trống " + empty_box + " ô trở lên!");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 11: {
                // Nhận quà Top 
                try (Connection connection = SQL.gI().getConnection(); Statement st = connection.createStatement(); Statement ps = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM `giftcode2` WHERE `name_player` = '" + conn.p.name + "' AND `type_gift` = '1' AND `status` = '0';")) {
                    byte empty_box = (byte) 0;
                    if (!rs.next()) {
                        Service.send_notice_box(conn, "Không tìm thấy đơn hàng, hoặc bạn đã nhận trước đó!");
                        return;
                    }
                    String mess = rs.getString("logger");
                    empty_box = rs.getByte("empty_box");
                    if (conn.p.item.get_bag_able() >= empty_box) {
                        if (ps.executeUpdate("UPDATE `giftcode2` SET `status` = '1' WHERE `id` = '" + rs.getInt("id") + "';") > 0) {
                            connection.commit();
                        }
                        JSONArray jsar = (JSONArray) JSONValue.parse(rs.getString("item3_defauft"));
                        for (int i = 0; i < jsar.size(); i++) {
                            JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                            if (jsar2 == null || jsar2.size() < 1) {
                                continue;
                            }
                            Item3 itbag = new Item3();
                            short it = Short.parseShort(jsar2.get(0).toString());
                            short date = Short.parseShort(jsar2.get(1).toString());
                            itbag.id = it;
                            itbag.name = ItemTemplate3.item.get(it).getName();
                            itbag.clazz = ItemTemplate3.item.get(it).getClazz();
                            itbag.type = ItemTemplate3.item.get(it).getType();
                            itbag.level = ItemTemplate3.item.get(it).getLevel();
                            itbag.icon = ItemTemplate3.item.get(it).getIcon();
                            itbag.op = new ArrayList<>();
                            itbag.op.addAll(ItemTemplate3.item.get(it).getOp());
                            itbag.color = ItemTemplate3.item.get(it).getColor();
                            itbag.part = ItemTemplate3.item.get(it).getPart();
                            itbag.tier = 0;
                            itbag.time_use = 0;
                            itbag.islock = false;
                            if (date > 0) {
                                //     itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * date;
                            }
                            conn.p.item.add_item_bag3(itbag);
                        }
                        jsar.clear();
                        jsar = (JSONArray) JSONValue.parse(rs.getString("item3"));
                        for (int i = 0; i < jsar.size(); i++) {
                            JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                            if (jsar2 == null || jsar2.size() < 1) {
                                continue;
                            }
                            Item3 itbag = new Item3();
                            short it = Short.parseShort(jsar2.get(0).toString());
                            short date = Short.parseShort(jsar2.get(1).toString());
                            itbag.id = it;
                            itbag.name = ItemTemplate3.item.get(it).getName();
                            itbag.clazz = ItemTemplate3.item.get(it).getClazz();
                            itbag.type = ItemTemplate3.item.get(it).getType();
                            itbag.level = ItemTemplate3.item.get(it).getLevel();
                            itbag.icon = ItemTemplate3.item.get(it).getIcon();
                            itbag.op = new ArrayList<>();
                            itbag.op.addAll(ItemTemplate3.item.get(it).getOp());
                            itbag.color = ItemTemplate3.item.get(it).getColor();
                            itbag.part = ItemTemplate3.item.get(it).getPart();
                            itbag.tier = 0;
                            itbag.time_use = 0;
                            itbag.islock = true;
                            if (itbag.islock) {
                                itbag.name += " [Khóa]";
                            }
                            if (date > 0) {
                                //     itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * date;
                            }
                            conn.p.item.add_item_bag3(itbag);
                        }
                        jsar.clear();

                        //
                        jsar = (JSONArray) JSONValue.parse(rs.getString("item4"));
                        for (int i = 0; i < jsar.size(); i++) {
                            JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                            Item47 itbag = new Item47();
                            itbag.id = Short.parseShort(jsar2.get(0).toString());
                            itbag.quantity = Short.parseShort(jsar2.get(1).toString());
                            itbag.category = 4;
                            conn.p.item.add_item_bag47(4, itbag);
                        }
                        jsar.clear();
                        //
                        jsar = (JSONArray) JSONValue.parse(rs.getString("item7"));
                        for (int i = 0; i < jsar.size(); i++) {
                            JSONArray jsar2 = (JSONArray) JSONValue.parse(jsar.get(i).toString());
                            Item47 itbag = new Item47();
                            itbag.id = Short.parseShort(jsar2.get(0).toString());
                            itbag.quantity = Short.parseShort(jsar2.get(1).toString());
                            itbag.category = 7;
                            conn.p.item.add_item_bag47(7, itbag);

                        }
                        jsar.clear();
                        conn.p.update_vang(rs.getLong("vang"));
                        conn.p.update_ngoc(rs.getLong("ngoc"));
                        conn.p.update_coin(rs.getInt("coin"));
                        conn.p.update_naptuan(rs.getInt("naptuan"));
                        conn.p.update_tongnap(rs.getInt("tongnap"));
                        Log.gI().add_log(conn.p.name, "Get order :" + rs.getInt("id"));
                        conn.p.item.char_inventory(5);
                        conn.p.item.char_inventory(3);
                        conn.p.item.char_inventory(4);
                        conn.p.item.char_inventory(7);

                        Service.send_notice_box(conn, mess);
                    } else {

                        Service.send_notice_box(conn, "Hành trang phải trống " + empty_box + " ô trở lên!");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    private static void Menu_Doiaochoang(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                send_menu_select(conn, 346, new String[]{"Áo Choàng Nam Tước", "Áo Choàng Tử Tước ", "Áo Choàng Bá Tước ", "Áo Choàng Hầu Tước ", "Áo Choàng Công Tước"});
                break;
            }
            case 1: {
                send_menu_select(conn, 347, new String[]{"Áo Choàng Nam Tước", "Áo Choàng Tử Tước ", "Áo Choàng Bá Tước ", "Áo Choàng Hầu Tước ", "Áo Choàng Công Tước"});
                break;
            }
            case 2: {
                send_menu_select(conn, 348, new String[]{"Áo Choàng Nam Tước", "Áo Choàng Tử Tước ", "Áo Choàng Bá Tước ", "Áo Choàng Hầu Tước ", "Áo Choàng Công Tước"});
                break;
            }
            case 3: {
                send_menu_select(conn, 349, new String[]{"Áo Choàng Nam Tước", "Áo Choàng Tử Tước ", "Áo Choàng Bá Tước ", "Áo Choàng Hầu Tước ", "Áo Choàng Công Tước"});
                break;
            }
            case 4: {
                send_menu_select(conn, 350, new String[]{"Áo Choàng Nam Tước", "Áo Choàng Tử Tước ", "Áo Choàng Bá Tước ", "Áo Choàng Hầu Tước ", "Áo Choàng Công Tước"});
                break;
            }
            case 5: {
                send_menu_select(conn, 351, new String[]{"Áo Choàng Nam Tước", "Áo Choàng Tử Tước ", "Áo Choàng Bá Tước ", "Áo Choàng Hầu Tước ", "Áo Choàng Công Tước"});
                break;
            }
            case 6: {
                send_menu_select(conn, 777, new String[]{"Áo Choàng Nam Tước", "Áo Choàng Tử Tước ", "Áo Choàng Bá Tước ", "Áo Choàng Hầu Tước ", "Áo Choàng Công Tước"});
                break;
            }
            case 7: {

                String s = "💖Hướng Dẫn💖";
                s += "\nCó 2 cách săn ngọc rồng";
                s += "\nNgười chơi phải từ level 40 trở lên";
                s += "\nCách chơi :";
                s += "\nNgọc rồng sẽ đc random tại 3 map {Bìa Rừng ,Hang Lửa ,Rừng Ảo Giác} .";
                s += "\nNgoài ra các hiệp sĩ cũng sẽ đuọc săn boss ở map riêng tại npc bxh";
                s += "\nNhặc được ngọc các hiệp sĩ có thể đổi quà tại npc bxh";
                s += "\nKết thúc Even Trân Trọng Cảm Ơn Các Hiệp Sĩ Đã Ủng hộ Sever";
                s += "\nBy HSO!!!";

                break;
            }
            case 8: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 116;
                vgo.x_new = 1020;
                vgo.y_new = 588;
                conn.p.change_map(conn.p, vgo);

                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Doiaochoang7(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 470) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 7 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 470, 1);
                short iditem = 4676;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 1: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 470) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 7 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 470, 1);
                short iditem = 4679;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 2: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 470) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 1 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 470, 1);
                short iditem = 4682;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 3: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 470) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 7 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 470, 1);
                short iditem = 4685;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 4: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 470) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 7 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 470, 1);
                short iditem = 4688;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 7;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Doiaochoang1(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 464) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 1 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 464, 1);
                short iditem = 4676;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 1;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 1: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 464) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 1 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 464, 1);
                short iditem = 4679;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 1;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 2: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 464) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 1 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 464, 1);
                short iditem = 4682;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 1;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 3: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 464) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 1 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 464, 1);
                short iditem = 4685;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 1;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 4: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 464) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 1 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 464, 1);
                short iditem = 4688;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 1;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Doiaochoang2(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 465) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 2 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 465, 1);
                short iditem = 4676;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 2;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 1: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 465) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 2 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 465, 1);
                short iditem = 4679;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 2;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 2: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 465) < 1) {
                    Service.send_notice_box(conn, "thiếu  ngọc 2 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 465, 1);
                short iditem = 4682;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 2;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 3: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 465) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 2 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 465, 1);
                short iditem = 4685;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 2;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 4: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 465) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 2 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 465, 1);
                short iditem = 4688;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 2;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Doiaochoang3(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 466) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 3 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 466, 1);
                short iditem = 4676;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 3;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 1: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 466) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 3 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 466, 1);
                short iditem = 4679;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 3;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 2: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 466) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 3 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 466, 1);
                short iditem = 4682;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 3;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 3: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 466) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 3 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 466, 1);
                short iditem = 4685;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 3;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 4: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 466) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 3 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 466, 1);
                short iditem = 4688;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 3;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Doiaochoang4(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 467) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 4 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 467, 1);
                short iditem = 4676;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 4;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 1: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 467) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 4 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 467, 1);
                short iditem = 4679;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 4;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 2: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 467) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 4 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 467, 1);
                short iditem = 4682;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 4;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 3: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 467) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 4 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 467, 1);
                short iditem = 4685;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 4;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 4: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 467) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 4 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 467, 1);
                short iditem = 4688;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 4;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Doiaochoang5(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 468) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 5 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 468, 1);
                short iditem = 4676;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 5;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 1: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 468) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 5 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 468, 1);
                short iditem = 4679;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 5;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 2: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 468) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 5 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 468, 1);
                short iditem = 4682;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 5;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 3: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 468) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 5 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 468, 1);
                short iditem = 4685;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 5;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 4: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 468) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 5 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 468, 1);
                short iditem = 4688;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 5;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Doiaochoang6(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 469) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 6 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 469, 1);
                short iditem = 4676;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 6;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 1: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 469) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 6 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 469, 1);
                short iditem = 4679;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 6;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 2: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 469) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 6 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 469, 1);
                short iditem = 4682;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 6;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 3: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 469) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 6 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 469, 1);
                short iditem = 4685;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 6;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 4: {
                if (conn.p.get_ngoc() < 0 || conn.p.item.total_item_by_id(7, 465) < 1) {
                    Service.send_notice_box(conn, "thiếu 1 ngọc 6 sao!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-0);
                conn.p.item.remove(7, 469, 1);
                short iditem = 4688;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 6;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_PhapSu(Session conn, byte index) throws IOException {
        conn.p.ResetCreateItemStar();
        conn.p.ResetShop();
        switch (index) {
            case 0: {
                conn.p.id_item_rebuild = -1;
                conn.p.is_use_mayman = false;
                conn.p.id_use_mayman = -1;
                Service.send_box_UI(conn, 18);
                break;
            }
            case 1: {
                Service.send_box_UI(conn, 17);
                break;
            }
            case 2: {
                conn.p.item_replace = -1;
                conn.p.item_replace2 = -1;
                Service.send_box_UI(conn, 19);
                break;
            }
            case 3: {
                Service.send_box_UI(conn, 24);
                break;
            }
            case 4: {
                Service.send_box_UI(conn, 25);
                conn.p.ResetCreateItemStar();
                conn.p.id_medal_is_created = 0;
                break;
            }
            case 5: {
                Service.send_box_UI(conn, 26);
                conn.p.ResetCreateItemStar();
                conn.p.id_medal_is_created = 1;
                break;
            }
            case 6: {
                Service.send_box_UI(conn, 27);
                conn.p.ResetCreateItemStar();
                conn.p.id_medal_is_created = 2;
                break;
            }
            case 7: {
                Service.send_box_UI(conn, 28);
                conn.p.ResetCreateItemStar();
                conn.p.id_medal_is_created = 3;
                break;
            }
            case 8: {
                conn.p.ResetCreateItemStar();
                Service.send_box_UI(conn, 33);
                break;
            }
            case 9:
            case 10: {
                ArrayList<String> myList = new ArrayList<String>();
                //Item3[] item3 = conn.p.item.bag3;
                Item3[] itemw = conn.p.item.wear;

                if (itemw == null || itemw.length < 13) {
                    Service.send_notice_box(conn, "Lỗi hành trang hoặc trang bị!");
                    return;
                }
                if (itemw.length > 12 && itemw[12] != null && Helps.CheckItem.isMeDay(itemw[12].id)) {
                    myList.add(itemw[12].name + " (1000 ngọc)");
                }
                if (myList == null || myList.size() <= 0) {
                    Service.send_notice_box(conn, "Không có vật phẩm phù hợp!");
                    return;
                }

                send_menu_select(conn, index == 9 ? 4 : 5, myList.toArray(new String[0]));

                //Service.send_notice_box(conn, "Chưa có chức năng"); doi dong st
                break;
            }
//            case 10: {
//                Service.send_notice_box(conn, "Chưa có chức năng"); doi pt st
//                break;
//            }
            case 11: {
                Service.send_box_UI(conn, 34);
                break;
            }
            case 12: {
                Service.send_box_UI(conn, 35);
                break;
            }
            case 13: {
                Service.send_box_UI(conn, 36);
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Admin(Session conn, byte index) throws IOException {
         if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn chưa đủ quyền để thực hiện!");
                    return;
                }
        switch (index) {
            case 0: {
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn chưa đủ quyền để thực hiện!");
                    return;
                }
                Service.send_box_input_yesno(conn, 88, "Bạn có chắc chắn muốn bảo trì server?");
                break;
            }
            case 1: {
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                conn.p.update_vang(1_000_000_000);
                //conn.p.item.char_inventory(5);
                Service.send_notice_nobox_white(conn, "+ 1.000.000.000 vàng");
                break;
            }
            case 2: {
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                conn.p.update_ngoc(1_000_000);
                //conn.p.item.char_inventory(5);
                Service.send_notice_nobox_white(conn, "+ 1.000.000 ngọc");
                break;
            }
            case 3: {
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                SaveData.process();
                Service.send_notice_nobox_white(conn, "data đã đc cập nhật");
                break;
            }
            case 4: {
                Service.send_box_input_text(conn, 1, "Get Item",
                        new String[]{"Nhập loại (3,4,7) vật phẩm :", "Nhập id vật phẩm", "Nhập số lượng"});
                break;
            }
            case 5: {
                Service.send_box_input_text(conn, 2, "Plus Level", new String[]{"Nhập level :"});
                break;
            }
            case 6: {
                Service.send_box_input_text(conn, 4, "Set Xp", new String[]{"Nhập mức x :"});
                break;
            }
            case 7: {
                Service.send_box_input_text(conn, 18, "Tên nhân vật", new String[]{"Nhập Tên nhân vật :"});
                break;
            }
            case 8: {
                Service.send_box_input_text(conn, 19, "Tên nhân vật", new String[]{"Nhập Tên nhân vật :"});
                break;
            }
            case 9: {
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                Manager.isLockVX = !Manager.isLockVX;
                Service.send_notice_box(conn, "Vòng xoay vàng ngọc đã " + (Manager.isLockVX ? "khóa" : "mở"));
                //Service.send_box_input_text(conn, 19, "Tên nhân vật", new String[]{"Nhập Tên nhân vật :"});
                break;
            }
            case 10: {
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                Manager.isGiaoDich = !Manager.isGiaoDich;
                Service.send_notice_box(conn, "Giao dịch đã " + (Manager.isGiaoDich ? "mở" : "khóa"));
                break;
            }
            case 11: {
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                Manager.isKmb = !Manager.isKmb;
                Service.send_notice_box(conn, "Kmb đã " + (Manager.isKmb ? "mở" : "khóa"));
                break;
            }
            case 12: {
                if (conn.ac_admin < 4) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                for (Pet pet : conn.p.mypet) {
                    if (pet.time_born > 0) {
                        pet.time_born = 3;
                    }
                }
                Service.send_notice_box(conn, "Đã xong");
                break;
            }
            case 13: {
                if (conn.ac_admin < 4) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                Manager.BuffAdmin = !Manager.BuffAdmin;
                Service.send_notice_box(conn, "Buff Admin đã: " + (Manager.BuffAdmin ? "Bật" : "Tắt"));
                break;
            }
            case 14: {
                if (conn.ac_admin < 4) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                Manager.BuffAdminMaterial = !Manager.BuffAdminMaterial;
                Service.send_notice_box(conn, "Buff nguyên liệu cho Admin Đã: " + (Manager.BuffAdminMaterial ? "Bật" : "Tắt"));
                break;
            }
            case 15: {
                if (conn.ac_admin < 5) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                Manager.gI().chiem_mo.mo_open_atk();
                Manager.gI().chatKTGprocess(" Thời gian chiếm mỏ đã đến!");
                break;
            }
            case 16: {
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                Manager.gI().chiem_mo.mo_close_atk();
                Manager.gI().chatKTGprocess(" Thời gian chiếm mỏ đã đóng!");
                break;
            }
            case 17: {
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                if (!LoiDaiManager.isRegister) {
                    LoiDaiManager.gI().startRegister();
                    Service.send_notice_box(conn, "Đã mở đăng kí ld!");
                } else {
                    LoiDaiManager.timeRegister = System.currentTimeMillis() - 1000;
                    Service.send_notice_box(conn, "Đã đóng đăng kí ld!");
                }
                break;
            }
            case 18: {
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                if (Manager.gI().event == 2) {
                    ev_he.Event_2.ClearMob();
                    ev_he.Event_2.ResetMob();
                    Service.send_notice_box(conn, "Đã thực hiện reset mob events");
                }
                break;
            }
            case 19: {
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                if (ChiemThanhManager.isRegister) {
                    ChiemThanhManager.EndRegister();
                } else {
                    ChiemThanhManager.StartRegister();
                }
                Service.send_notice_box(conn, "Đã thực hiện " + (ChiemThanhManager.isRegister ? "mở" : "đóng") + " đăng kí chiếm thành");
                break;
            }
            case 20: {
                if (conn.ac_admin < 5) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                ChienTruong.gI().open_register();
                //Manager.gI().chatKTGprocess("");
                break;
            }
            case 21: {
                if (conn.ac_admin < 4) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                Service.send_box_input_text(conn, 21, "Dịch chuyển map",
                        new String[]{"Nhập idMap", "Nhập tọa độ x", "Nhập tọa độ y"});
                break;
            }
            case 22: {
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                Manager.gI().load_config();
                break;
            }
            case 23: {
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                Manager.logErrorLogin = !Manager.logErrorLogin;
                Service.send_notice_box(conn, "Bạn đã " + (Manager.logErrorLogin ? "Bật" : "Tắt") + " log error");
                break;
            }
            case 24: {
                Service.send_box_input_text(conn, 24, "Disconnect", new String[]{"Nhập loại :", "Nhập Tên :"});
                break;
            }
            case 25: {
                String ssss = "Start Check \n-----------------------------\n";
                try {
                    Message m = new Message(53);
                    m.writer().writeUTF("check log");
                    m.writer().writeByte(1);
                    int mapnulls = 0;
                    int mapnull = 0;
                    int pnull = 0;
                    ssss += "\nvo ne";
                    for (Map[] map : Map.entrys) {
                        if (map == null) {
                            mapnulls++;
                            continue;
                        }
                        for (Map map0 : map) {
                            if (map0 == null) {
                                mapnull++;
                                continue;
                            }
                            for (int i = 0; i < map0.players.size(); i++) {
                                if (map0.players.get(i) == null || map0.players.get(i).conn == null) {
                                    pnull++;
                                    continue;
                                }
                                map0.players.get(i).conn.addmsg(m);
                            }
                        }
                    }
                    try {
                        for (Group_ld g : LoiDaiManager.gI().Group_entrys) {
                            for (LoiDai2 l : g.ld_entrys) {
                                for (Player p0 : l.map.players) {
                                    if (p0 != null && p0.conn != null && p0.conn.connected) {
                                        p0.conn.addmsg(m);
                                    }
                                }
                            }
                        }
                    } catch (Exception ee) {
                    }
                    ssss += "\n" + mapnulls + " Map[]Null";
                    ssss += "\n" + mapnull + " MapNull";
                    ssss += "\n" + pnull + " PlayerNull";
                    m.cleanup();
                } catch (Exception ex) {
                    Service.send_notice_box(conn, "Lỗi: " + ex.getMessage());
                    ex.printStackTrace();
                    StackTraceElement[] stackTrace = ex.getStackTrace(); // Lấy thông tin ngăn xếp gọi hàm

                    for (StackTraceElement element : stackTrace) {
                        ssss += ("Class: " + element.getClassName());
                        ssss += ("\nMethod: " + element.getMethodName());
                        ssss += ("\nFile: " + element.getFileName());
                        ssss += ("\nLine: " + element.getLineNumber());
                        ssss += ("------------------------\n");
                    }

                }
                Helps.Save_Log.process("checkbug.txt", ssss);
                break;
            }
            case 26: {
                String ssss = "Start Fix \n-----------------------------\n";
                try {
                    Message m = new Message(53);
                    m.writer().writeUTF("check log");
                    m.writer().writeByte(1);
                    int mapnulls = 0;
                    int mapnull = 0;
                    int pnull = 0;
                    ssss += "\nvo ne";
                    for (Map[] map : Map.entrys) {
                        if (map == null) {
                            mapnulls++;
                            continue;
                        }
                        for (Map map0 : map) {
                            if (map0 == null) {
                                mapnull++;
                                continue;
                            }
                            for (int i = map0.players.size() - 1; i >= 0; i--) {
                                if (map0.players.get(i) == null || map0.players.get(i).conn == null) {
                                    map0.players.remove(i);
                                }
                            }
                        }
                    }
                    try {
                        for (Group_ld g : LoiDaiManager.gI().Group_entrys) {
                            for (LoiDai2 l : g.ld_entrys) {
                                for (Player p0 : l.map.players) {
                                    if (p0 != null && p0.conn != null && p0.conn.connected) {
                                        p0.conn.addmsg(m);
                                    }
                                }
                            }
                        }
                    } catch (Exception ee) {
                    }
                    ssss += "\n" + mapnulls + " Map[]Null";
                    ssss += "\n" + mapnull + " MapNull";
                    ssss += "\n" + pnull + " PlayerNull";
                    m.cleanup();
                } catch (Exception ex) {
                    Service.send_notice_box(conn, "Lỗi: " + ex.getMessage());
                    ex.printStackTrace();
                    StackTraceElement[] stackTrace = ex.getStackTrace(); // Lấy thông tin ngăn xếp gọi hàm

                    for (StackTraceElement element : stackTrace) {
                        ssss += ("Class: " + element.getClassName());
                        ssss += ("\nMethod: " + element.getMethodName());
                        ssss += ("\nFile: " + element.getFileName());
                        ssss += ("\nLine: " + element.getLineNumber());
                        ssss += ("------------------------\n");
                    }

                }
                Service.send_notice_box(conn, "xong");
                Helps.Save_Log.process("checkbug.txt", ssss);
                break;
            }
            case 27: {
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Bạn không đủ quyền!");
                    return;
                }
                Service.send_box_input_text(conn, 99, "Nhập thông tin",
                        new String[]{"Tên nhân vật", "Số tiền", "Coin"});

                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_lock(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {  //on off ngọc ra coin
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Không đủ quyền ");
                    return;
                }
                Manager.isNgocCoin = !Manager.isNgocCoin;
                Service.send_notice_box(conn, (Manager.isNgocCoin ? "Đã Mở" : "Đã Đóng") + " Đổi Ngọc Ra Coin");
                break;
            }

            case 1: {  //on off Shop Vàng
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Không đủ quyền ");
                    return;
                }
                Manager.isShopVang = !Manager.isShopVang;
                Service.send_notice_box(conn, (Manager.isShopVang ? "Đã Mở" : "Đã Đóng") + " Shop Vàng");
                break;
            }

            case 2: {  //on off Vòng quay kc
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Không đủ quyền ");
                    return;
                }
                Manager.isLockKC = !Manager.isLockKC;
                Service.send_notice_box(conn, (Manager.isLockKC ? "Đã Mở" : "Đã Đóng") + " Vòng Quay Ngọc");
                break;
            }
            case 3: {  //on off Tài Xỉu
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Không đủ quyền ");
                    return;
                }
                Manager.isLockTaiXiu = !Manager.isLockTaiXiu;
                Service.send_notice_box(conn, (Manager.isLockTaiXiu ? "Đã Mở" : "Đã Đóng") + " Tài Xỉu");
                break;
            }

            case 4: {  //on off Tài Xỉu
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Không đủ quyền ");
                    return;
                }
                Manager.isPk = !Manager.isPk;
                Service.send_notice_box(conn, (Manager.isPk ? "Đã Mở" : "Đã Đóng") + " Chống Đồ Sát");
                break;
            }

            case 5: {  //Kh tk
                if (conn.ac_admin < 10) {
                    Service.send_notice_box(conn, "Không đủ quyền ");
                    return;
                }
                Service.send_box_input_text(conn, 33, "Kích Hoạt Tài Khoản",
                        new String[]{"id"});
                break;
            }

            case 6: {  //Nạp
                if (conn.ac_admin < 100) {
                    Service.send_notice_box(conn, "Không đủ quyền ");
                    return;
                }
                Service.send_box_input_text(conn, 34, "Nạp Tiền",
                        new String[]{"id", "Số Tiền", "Số Coin"});
                break;
            }

            case 7: { // vàng ngọc
                if (conn.ac_admin < 100) {
                    Service.send_notice_box(conn, "Không đủ quyền ");
                    return;
                }
                Service.send_box_input_text(conn, 49, "Cộng Vàng Ngọc",
                        new String[]{"Tên Nhân Vật", "Số Vàng", "Số Ngọc"});
                break;
            }
            case 8, 10: {
                break;
            }
            case 9: {  //reset nap tuân
                if (conn.ac_admin < 100) {
                    Service.send_notice_box(conn, "Không đủ quyền ");
                    return;
                }
                Service.send_box_input_text(conn, 35, "Reset Nạp Tuần",
                        new String[]{"Ghi Số O"});
                break;
            }

            case 11: {  //reset account int2
                if (conn.ac_admin < 100) {
                    Service.send_notice_box(conn, "Không đủ quyền ");
                    return;
                }
                Service.send_box_input_text(conn, 36, "Reset Account int2",
                        new String[]{"Nhập Trường"});
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Zulu(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                switch (conn.p.clazz) {
                    case 0: {
                        Service.send_msg_data(conn, 23, "tocchienbinh");
                        break;
                    }
                    case 1: {
                        Service.send_msg_data(conn, 23, "tocsatthu");
                        break;
                    }
                    case 2:
                    case 3: {
                        Service.send_msg_data(conn, 23, "tocphapsu");
                        break;
                    }
                }
                break;
            }
            case 1: {
                if (conn.p.diem_danh[0] == 0) {
                    conn.p.diem_danh[0] = 1;
                    int ngoc_ = Util.random(100, 1000);
                    conn.p.update_ngoc(ngoc_);
                    conn.p.chuyencan++;
                    Log.gI().add_log(conn.p.name, "Điểm danh ngày được " + Util.number_format(ngoc_) + " ngọc");
                    conn.p.item.char_inventory(5);
                    Service.send_notice_box(conn, "Bạn đã điểm danh thành công, được " + ngoc_ + " ngọc");
                } else {
                    Service.send_notice_box(conn, "Bạn đã điểm danh hôm nay rồi");
                }
                break;
            }
            case 2: {
            if (!Manager.isNgocCoin) {
                    Service.send_notice_box(conn, "Chức Năng Đang Tạm Khoá!");
                    return;
                }
                String tyLe = (conn.vip >= 4) ? "Tỷ lệ Vip 1000 coin = 2000 ngọc" : "Tỷ lệ 1000 coin = 1000 ngọc";
                Service.send_box_input_text(conn, 5, "Đổi coin sang ngọc", new String[]{tyLe});
                break;
            }
            case 3: {
            if (!Manager.isNgocCoin) {
                    Service.send_notice_box(conn, "Chức Năng Đang Tạm Khoá!");
                    return;
                }
                String tyLe = (conn.vip >= 3) ? "Tỷ lệ Vip 1000 coin = 10tr vàng" : "Tỷ lệ 1000 coin = 5tr vàng";
                Service.send_box_input_text(conn, 14, "Đổi coin sang vàng", new String[]{tyLe});
                break;
            }

            case 4: {
                if (!Manager.isNgocCoin) {
                    Service.send_notice_box(conn, "Chức Năng Đang Tạm Khoá!");
                    return;
                }

                if (conn.vip < 2) {
                    Service.send_notice_box(conn, "Dành cho Vip 2 trở lên!");
                    return;
                }

                Service.send_box_input_text(conn, 31, "Đổi Ngọc Sang Coin!", new String[]{"Tỷ lệ 10k ngọc = 1k coin"});
                break;
            }

            case 5: {

                if (!Manager.isPk) {
                    Service.send_notice_box(conn, "Chức Năng Đang Tạm Khoá!");
                    return;
                }

                //Service.send_notice_box(conn, "Chức năng không còn tồn tại.");
                Service.send_box_input_yesno(conn, 121, "1000 ngọc cho 2h, hãy xác nhận");
                break;
            }
            case 6: {
                EffTemplate tempp = conn.p.get_EffDefault(-126);
                if (tempp != null && tempp.time > System.currentTimeMillis()) {
                    Service.send_notice_box(conn,
                            "Thời gian còn lại : " + Util.getTime((int) (tempp.time - System.currentTimeMillis()) / 1000));
                } else {
                    Service.send_notice_box(conn, "Chưa đăng ký kiểm tra cái gì?");
                }
                break;
            }
            case 7: {
                if (conn.p.type_exp == 0) {
                    conn.p.type_exp = 1;
                    Service.send_notice_box(conn, "Đã bật nhận exp");
                } else {
                    conn.p.type_exp = 0;
                    Service.send_notice_box(conn, "Đã tắt nhận exp");
                }
                break;
            }
            case 8: {
                Service.send_box_input_text(conn, 30, "Đổi mật khẩu", new String[]{"nhập mật khẩu cũ",
                    "nhập mật khẩu mới", "nhập lại mật khẩu mới"});
                break;
            }

            case 9: {
                send_menu_select(conn, 128, new String[]{"Sức mạnh", "Khéo léo", "Thể lực", "Tinh thần"});
                break;
            }
            case 10: {
                Service.send_notice_box(conn, "Điểm Tiểm Năng :" + conn.p.tiemnang + "."
                        + "\n Sức Mạnh: " + conn.p.point1
                        + "\n Khéo Léo: " + conn.p.point2
                        + "\n Thể Lực: " + conn.p.point3
                        + "\n Tinh Thần: " + conn.p.point4);
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_ChangeZone(Session conn) throws IOException {
        Map[] map = Map.get_map_by_id(conn.p.map.map_id);

        if (map != null) {
            Message m = new Message(54);
            if (Map.is_map_cant_save_site(conn.p.map.map_id)) {
                m.writer().writeByte(conn.p.map.maxzone);
            } else {
                m.writer().writeByte(conn.p.map.maxzone + 1);
            }
            //
            for (int i = 0; i < conn.p.map.maxzone; i++) {
                if (map[i].players.size() > (map[i].maxplayer - 2)) {
                    m.writer().writeByte(2); // redzone
                } else if (map[i].players.size() >= (map[i].maxplayer / 2)) {
                    m.writer().writeByte(1); // yellow zone
                } else {
                    m.writer().writeByte(0); // green zone
                }
                if (i == 4 && Map.is_map_chiem_mo(conn.p.map, false)) {
                    m.writer().writeByte(4);
                } else if (i == 1 && (!(khu2.isDont_khu2(conn.p.map.map_id)))) {
                    m.writer().writeByte(3); // blue zone
                } else {
                    m.writer().writeByte(0);
                }
            }
            if (!Map.is_map_cant_save_site(conn.p.map.map_id)) {
                m.writer().writeByte(1);
                m.writer().writeByte(5);
            }
            //Map[] map = Map.get_map_by_id(conn.p.map.map_id);

            for (int i = 0; i < conn.p.map.maxzone; i++) {
                if (i == 0 && map[i].players.size() < 50) {

                    int max = map[0].maxplayer;
                    //max = 50;
                    m.writer().writeUTF("Khu " + (map[i].zone_id + 1) + " (" + map[i].players.size() + "/" + max + ")");
                } else {
                    m.writer().writeUTF("Khu " + (map[i].zone_id + 1) + " (" + map[i].players.size() + "/" + map[i].maxplayer + ")");
                }
            }
            if (!Map.is_map_cant_save_site(conn.p.map.map_id)) {
                m.writer().writeUTF("Khu đi buôn");
            }

            //
            conn.addmsg(m);
            m.cleanup();

        }
    }

    private static void Menu_Alisama(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                Service.send_box_UI(conn, 9);
                break;
            }
            case 1: {
                Service.send_box_UI(conn, 10);
                break;
            }
            case 2: {
                Service.send_box_UI(conn, 11);
                break;
            }
            case 3: {
                Service.send_box_UI(conn, 12);
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }
    // menu dc

    private static void Menu_dc1(Session conn, byte index) throws IOException {
        if (conn.p.item.wear[11] != null && (conn.p.item.wear[11].id == 3599 || conn.p.item.wear[11].id == 3593
                || conn.p.item.wear[11].id == 3596)) {
            return;
        }
        if (Pet_mi_nuong.checkMy(conn)) {
            return;
        }
        if (!conn.p.my_store_name.isEmpty()) {
            Service.send_notice_box(conn, "Đang Bán Đi đâu em");
            return;
        }
        Vgo vgo = null;
        switch (index) {
            case 0: {
                vgo = new Vgo();
                vgo.id_map_go = 19;
                vgo.x_new = 1056;
                vgo.y_new = 400;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 1: {
                vgo = new Vgo();
                vgo.id_map_go = 21;
                vgo.x_new = 432;
                vgo.y_new = 480;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 2: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt, hãy kích hoạt");
                    return;
                }
                vgo = new Vgo();
                vgo.id_map_go = 23;
                vgo.x_new = 432;
                vgo.y_new = 354;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 3: {
                vgo = new Vgo();
                vgo.id_map_go = 25;
                vgo.x_new = 888;
                vgo.y_new = 672;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 4: {
                vgo = new Vgo();
                vgo.id_map_go = 27;
                vgo.x_new = 475;
                vgo.y_new = 350;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 5: {
                vgo = new Vgo();
                vgo.id_map_go = 30;
                vgo.x_new = 576;
                vgo.y_new = 222;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 6: {
                vgo = new Vgo();
                vgo.id_map_go = 38;
                vgo.x_new = 450;
                vgo.y_new = 450;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 7: {
                vgo = new Vgo();
                vgo.id_map_go = 40;
                vgo.x_new = 286;
                vgo.y_new = 708;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 8: {
                vgo = new Vgo();
                vgo.id_map_go = 42;
                vgo.x_new = 240;
                vgo.y_new = 732;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 9: {
                vgo = new Vgo();
                vgo.id_map_go = 44;
                vgo.x_new = 450;
                vgo.y_new = 450;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 10: {
                vgo = new Vgo();
                vgo.id_map_go = 47;
                vgo.x_new = 469;
                vgo.y_new = 1099;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 11: {
                vgo = new Vgo();
                vgo.id_map_go = 51;
                vgo.x_new = 673;
                vgo.y_new = 1093;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 12: {
                vgo = new Vgo();
                vgo.id_map_go = 52;
                vgo.x_new = 230;
                vgo.y_new = 350;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 13: {
                vgo = new Vgo();
                vgo.id_map_go = 62;
                vgo.x_new = 660;
                vgo.y_new = 612;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    //menu dc2
    private static void Menu_dc2(Session conn, byte index) throws IOException {
        if (conn.p.item.wear[11] != null && (conn.p.item.wear[11].id == 3599 || conn.p.item.wear[11].id == 3593
                || conn.p.item.wear[11].id == 3596)) {
            return;
        }
        if (Pet_mi_nuong.checkMy(conn)) {
            return;
        }
        if (!conn.p.my_store_name.isEmpty()) {
            Service.send_notice_box(conn, "Đang Bán Đi đâu em");
            return;
        }
        Vgo vgo = null;
        switch (index) {
            case 0: {
                vgo = new Vgo();
                vgo.id_map_go = 63;
                vgo.x_new = 132;
                vgo.y_new = 354;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 1: {
                vgo = new Vgo();
                vgo.id_map_go = 64;
                vgo.x_new = 145;
                vgo.y_new = 480;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 2: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt, hãy kích hoạt");
                    return;
                }
                vgo = new Vgo();
                vgo.id_map_go = 65;
                vgo.x_new = 432;
                vgo.y_new = 354;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 3: {
                vgo = new Vgo();
                vgo.id_map_go = 66;
                vgo.x_new = 459;
                vgo.y_new = 450;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 4: {
                vgo = new Vgo();
                vgo.id_map_go = 71;
                vgo.x_new = 145;
                vgo.y_new = 450;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 5: {
                vgo = new Vgo();
                vgo.id_map_go = 72;
                vgo.x_new = 450;
                vgo.y_new = 459;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 6: {
                vgo = new Vgo();
                vgo.id_map_go = 73;
                vgo.x_new = 145;
                vgo.y_new = 359;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 7: {
                vgo = new Vgo();
                vgo.id_map_go = 75;
                vgo.x_new = 450;
                vgo.y_new = 459;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 8: {
                vgo = new Vgo();
                vgo.id_map_go = 76;
                vgo.x_new = 459;
                vgo.y_new = 462;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 9: {
                vgo = new Vgo();
                vgo.id_map_go = 78;
                vgo.x_new = 459;
                vgo.y_new = 450;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 10: {
                vgo = new Vgo();
                vgo.id_map_go = 79;
                vgo.x_new = 450;
                vgo.y_new = 450;
                conn.p.change_map(conn.p, vgo);
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_DaDichChuyen10(Session conn, byte index) throws IOException {
        if (conn.p.item.wear[11] != null && (conn.p.item.wear[11].id == 3599 || conn.p.item.wear[11].id == 3593
                || conn.p.item.wear[11].id == 3596)) {
            return;
        }
        if (Pet_mi_nuong.checkMy(conn)) {
            return;
        }
        if (!conn.p.my_store_name.isEmpty()) {
            Service.send_notice_box(conn, "Đang Bán Đi đâu em");
            return;
        }
        Vgo vgo = null;
        switch (index) {
            case 0: {
                vgo = new Vgo();
                vgo.id_map_go = 1;
                vgo.x_new = 432;
                vgo.y_new = 354;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 1: {
                vgo = new Vgo();
                vgo.id_map_go = 33;
                vgo.x_new = 432;
                vgo.y_new = 480;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 2: {

                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt, hãy kích hoạt");
                    return;
                }

                if (!Manager.isKmb) {
                    Service.send_notice_box(conn, "Khu mua bán đang tạm khóa!");
                    return;
                }

                if (conn.ac_admin == 15) {
                    Service.send_notice_box(conn, "Không thể vào kmb!");
                    return;
                }
                vgo = new Vgo();
                vgo.id_map_go = 82;
                vgo.x_new = 432;
                vgo.y_new = 354;
                conn.p.change_map(conn.p, vgo);
                break;
            }

            case 3: {
                vgo = new Vgo();
                vgo.id_map_go = 4;
                vgo.x_new = 888;
                vgo.y_new = 672;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 4: {
                vgo = new Vgo();
                vgo.id_map_go = 5;
                vgo.x_new = 1056;
                vgo.y_new = 864;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 5: {
                vgo = new Vgo();
                vgo.id_map_go = 8;
                vgo.x_new = 576;
                vgo.y_new = 222;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 6: {
                vgo = new Vgo();
                vgo.id_map_go = 9;
                vgo.x_new = 1243;
                vgo.y_new = 876;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 7: {
                vgo = new Vgo();
                vgo.id_map_go = 11;
                vgo.x_new = 286;
                vgo.y_new = 708;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 8: {
                vgo = new Vgo();
                vgo.id_map_go = 12;
                vgo.x_new = 240;
                vgo.y_new = 732;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 9: {
                vgo = new Vgo();
                vgo.id_map_go = 13;
                vgo.x_new = 150;
                vgo.y_new = 979;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 10: {
                vgo = new Vgo();
                vgo.id_map_go = 15;
                vgo.x_new = 469;
                vgo.y_new = 1099;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 11: {
                vgo = new Vgo();
                vgo.id_map_go = 16;
                vgo.x_new = 673;
                vgo.y_new = 1093;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 12: {
                vgo = new Vgo();
                vgo.id_map_go = 17;
                vgo.x_new = 660;
                vgo.y_new = 612;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_DaDichChuyen33(Session conn, byte index) throws IOException {
        if (conn.p.item.wear[11] != null && (conn.p.item.wear[11].id == 3599 || conn.p.item.wear[11].id == 3593
                || conn.p.item.wear[11].id == 3596)) {
            return;
        }
        if (Pet_mi_nuong.checkMy(conn)) {
            return;
        }
        if (!conn.p.my_store_name.isEmpty()) {
            Service.send_notice_box(conn, "Đang Bán Đi đâu em");
            return;
        }
        Vgo vgo = null;
        switch (index) {
            case 0: {
                vgo = new Vgo();
                vgo.id_map_go = 67;
                vgo.x_new = 576;
                vgo.y_new = 222;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 1: {
                vgo = new Vgo();
                vgo.id_map_go = 33;
                vgo.x_new = 432;
                vgo.y_new = 480;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 2: {
                // vgo = new Vgo();
                // vgo.idmapgo = 82;
                // vgo.xnew = 432;
                // vgo.ynew = 354;
                // conn.p.changemap(conn.p, vgo);
                Service.send_notice_box(conn, "Đang bảo trì khu vực này");
                break;
            }
            case 3: {
                vgo = new Vgo();
                vgo.id_map_go = 20;
                vgo.x_new = 787;
                vgo.y_new = 966;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 4: {
                vgo = new Vgo();
                vgo.id_map_go = 22;
                vgo.x_new = 120;
                vgo.y_new = 678;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 5: {
                vgo = new Vgo();
                vgo.id_map_go = 24;
                vgo.x_new = 576;
                vgo.y_new = 222;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 6: {
                vgo = new Vgo();
                vgo.id_map_go = 26;
                vgo.x_new = 576;
                vgo.y_new = 222;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 7: {
                vgo = new Vgo();
                vgo.id_map_go = 29;
                vgo.x_new = 576;
                vgo.y_new = 222;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 8: {
                vgo = new Vgo();
                vgo.id_map_go = 31;
                vgo.x_new = 360;
                vgo.y_new = 624;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 9: {
                vgo = new Vgo();
                vgo.id_map_go = 37;
                vgo.x_new = 150;
                vgo.y_new = 674;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 10: {
                vgo = new Vgo();
                vgo.id_map_go = 39;
                vgo.x_new = 199;
                vgo.y_new = 882;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 11: {
                vgo = new Vgo();
                vgo.id_map_go = 41;
                vgo.x_new = 187;
                vgo.y_new = 462;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 12: {
                vgo = new Vgo();
                vgo.id_map_go = 43;
                vgo.x_new = 228;
                vgo.y_new = 43;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 13: {
                vgo = new Vgo();
                vgo.id_map_go = 45;
                vgo.x_new = 576;
                vgo.y_new = 222;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 14: {
                vgo = new Vgo();
                vgo.id_map_go = 50;
                vgo.x_new = 300;
                vgo.y_new = 300;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_DaDichChuyen55(Session conn, byte index) throws IOException {
        if (conn.p.item.wear[11] != null && (conn.p.item.wear[11].id == 3599 || conn.p.item.wear[11].id == 3593
                || conn.p.item.wear[11].id == 3596)) {
            return;
        }
        if (Pet_mi_nuong.checkMy(conn)) {
            return;
        }
        if (!conn.p.my_store_name.isEmpty()) {
            Service.send_notice_box(conn, "Đang Bán Đi đâu em");
            return;
        }

        Vgo vgo = null;
        switch (index) {
            case 0: {
                vgo = new Vgo();
                vgo.id_map_go = 67;
                vgo.x_new = 576;
                vgo.y_new = 222;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 1: {
                // vgo = new Vgo();
                // vgo.idmapgo = 82;
                // vgo.xnew = 432;
                // vgo.ynew = 354;
                // conn.p.changemap(conn.p, vgo);
                Service.send_notice_box(conn, "Đang bảo trì khu vực này");
                break;
            }
            case 2: {
                vgo = new Vgo();
                vgo.id_map_go = 74;
                vgo.x_new = 258;
                vgo.y_new = 354;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 3: {
                vgo = new Vgo();
                vgo.id_map_go = 77;
                vgo.x_new = 576;
                vgo.y_new = 222;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 4: {
                vgo = new Vgo();
                vgo.id_map_go = 93;
                vgo.x_new = 462;
                vgo.y_new = 342;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 5: {
                vgo = new Vgo();
                vgo.id_map_go = 94;
                vgo.x_new = 306;
                vgo.y_new = 240;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 6: {
                vgo = new Vgo();
                vgo.id_map_go = 95;
                vgo.x_new = 390;
                vgo.y_new = 162;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 7: {
                vgo = new Vgo();
                vgo.id_map_go = 96;
                vgo.x_new = 198;
                vgo.y_new = 666;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 8: {
                vgo = new Vgo();
                vgo.id_map_go = 97;
                vgo.x_new = 432;
                vgo.y_new = 168;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 9: {
                vgo = new Vgo();
                vgo.id_map_go = 98;
                vgo.x_new = 270;
                vgo.y_new = 132;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            case 10: {
                vgo = new Vgo();
                vgo.id_map_go = 33;
                vgo.x_new = 432;
                vgo.y_new = 480;
                conn.p.change_map(conn.p, vgo);
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Hammer(Session conn, byte index, byte idmenu) throws IOException {
        conn.p.ResetShop();
        
        if (idmenu == 0) {
            switch (index) {
                case 0: {
                    Service.send_box_UI(conn, 5);
                    break;
                }
                case 1: {
                    Service.send_box_UI(conn, 6);
                    break;
                }
                case 2: {
                    Service.send_box_UI(conn, 7);
                    break;
                }
                case 3: {
                    Service.send_box_UI(conn, 8);
                    break;
                }
                case 4: // chế tạo tinh tú
                {
                    send_menu_select(conn, -5, new String[]{"Chiến binh", "Sát thủ", "Pháp sư", "Xạ thủ"}, (byte) 1);
                    break;
                }
                case 5:// nâng cấp tinh tú
                {
                    conn.p.isCreateItemStar = true;
                    Service.send_box_UI(conn, 33);
                    //send_menu_select(conn,-5100,new String[]{"Chiến binh","Sát thủ","Pháp sư","Xạ thủ"});
                    break;
                }
                case 6: { // giap sieu nhan
                    if (conn.p.item.wear[20] == null) {
                        Service.send_notice_box(conn, "Mặc đéo đâu mà tháo hả thằng lol?");
                    } else {
                        Item3 buffer = conn.p.item.wear[20];
                        conn.p.item.wear[20] = null;
                        conn.p.item.add_item_bag3(buffer);
                        conn.p.item.char_inventory(3);
                        conn.p.fashion = Part_fashion.get_part(conn.p);
                        Service.send_wear(conn.p);
                        Service.send_char_main_in4(conn.p);
                        MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                        Service.send_notice_box(conn, "Tháo thành công");
                    }
                    break;
                }
                case 7: { // thao danh hiẹu
                    if (conn.p.item.wear[19] == null) {
                        Service.send_notice_box(conn, "Mặc đéo đâu mà tháo hả thằng lol?");
                    } else {
                        Item3 buffer = conn.p.item.wear[19];
                        conn.p.item.wear[19] = null;
                        conn.p.item.add_item_bag3(buffer);
                        conn.p.item.char_inventory(3);
                        conn.p.fashion = Part_fashion.get_part(conn.p);
                        Service.send_wear(conn.p);
                        Service.send_char_main_in4(conn.p);
                        MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                        Service.send_notice_box(conn, "Tháo thành công");
                    }
                    break;
                }

                case 8: { // tháo wear 21
                    if (conn.p.item.wear[21] == null) {
                        Service.send_notice_box(conn, "Mặc đéo đâu mà tháo hả thằng lol?");
                    } else {
                        Item3 buffer = conn.p.item.wear[21];
                        conn.p.item.wear[21] = null;
                        conn.p.item.add_item_bag3(buffer);
                        conn.p.item.char_inventory(3);
                        conn.p.fashion = Part_fashion.get_part(conn.p);
                        Service.send_wear(conn.p);
                        Service.send_char_main_in4(conn.p);
                        MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                        Service.send_notice_box(conn, "Tháo thành công");
                    }
                    break;
                }

                case 9: { // thao wear 22
                    if (conn.p.item.wear[22] == null) {
                        Service.send_notice_box(conn, "Mặc đéo đâu mà tháo hả thằng lol?");
                    } else {
                        Item3 buffer = conn.p.item.wear[22];

                        conn.p.item.wear[22] = null;
                        conn.p.item.add_item_bag3(buffer);
                        conn.p.item.char_inventory(3);
                        conn.p.fashion = Part_fashion.get_part(conn.p);

                        Service.send_wear(conn.p);
                        Service.send_char_main_in4(conn.p);
                        MapService.update_in4_2_other_inside(conn.p.map, conn.p);
                        Service.send_notice_box(conn, "Tháo thành công");
                    }
                    break;
                }
                case 10: {
                    String[] nemu = new String[]{"Kháng băng", "Kháng lửa", "Kháng điện", "Kháng độc"};
                    send_menu_select(conn, -5, nemu, (byte) 15);
                    break;
                }
                 case 11:// nâng cấp siêu nhân
                {
                    conn.p.isSieuNhan = true;
                    Service.send_box_UI(conn, 33);
                  
                    break;
                }
                case 12: {
                    String[] nemu = new String[]{"Sách vật lý", "Sách ma pháp"};
                    send_menu_select(conn, -5, nemu, (byte) 14);
                    break;
                }
                default: {
                    Service.send_notice_box(conn, "Chưa có chức năng");
                    break;
                }
            }
        } else if (idmenu == 1) {
            String[] nemu = new String[]{"Nón", "Áo", "Quần", "Giày", "Găng tay", "Nhẫn", "Vũ khí", "Dây chuyền"};
            send_menu_select(conn, -5, nemu, (byte) (10 + index));
        } else if (idmenu >= 10 && idmenu <= 13) {
            conn.p.isCreateItemStar = true;
            conn.p.ClazzItemStar = (byte) (idmenu - 10);
            conn.p.TypeItemStarCreate = index;
            Service.send_box_UI(conn, 40 + index);
        } else if (idmenu == 14) {
            Service.send_box_input_yesno(conn, -123 + index, "Giá ghép sách là 10 ngọc, bạn có muốn tiếp tục không?");
        }   else if (idmenu == 15) { //
            conn.p.type_sieunhan_create = index;
            String[] nemu = new String[]{"Giáp siêu nhân bạc", "Giáp siêu nhân tím", "Giáp siêu nhân xanh", "Giáp siêu nhân vàng"};
            send_menu_select(conn, -5, nemu, (byte) 16);
        } else if (idmenu == 16) {
            conn.p.id_sieunhan_create = index;
            conn.p.isSieuNhan = true;
            Service.send_box_UI(conn, 49);
        }
        
    }

    private static void Menu_Alisama(Session conn, byte index, byte idmenu) throws IOException {
        if (idmenu == 0) {
            switch (index) {
                case 0: {
                    Service.send_box_UI(conn, 9);
                    break;
                }
                case 1: {
                    Service.send_box_UI(conn, 10);
                    break;
                }
                case 2: {
                    Service.send_box_UI(conn, 11);
                    break;
                }
                case 3: {
                    Service.send_box_UI(conn, 12);
                    break;
                }
                default:
                    Service.send_notice_box(conn, "Chưa có chức năng");
                    break;
            }
        }
    }

    private static void Menu_GiapSieuNhan(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                if (conn.p.get_ngoc() < 20000 || conn.p.item.total_item_by_id(4, 319) < 200) {
                    Service.send_notice_box(conn, "Cần tối thiểu 20000 ngọc và 200 hồ quang  bạc để đổi !");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-20000);
                conn.p.item.remove(4, 319, 200);
                short iditem = 4784;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 3;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 1: {
                if (conn.p.get_ngoc() < 20000 || conn.p.item.total_item_by_id(4, 320) < 200) {
                    Service.send_notice_box(conn, "Cần tối thiểu 20000 ngọc và 200 hồ quang  tím để đổi!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-20000);
                conn.p.item.remove(4, 320, 200);
                short iditem = 4785;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 3;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 2: {
                if (conn.p.get_ngoc() < 20000 || conn.p.item.total_item_by_id(4, 321) < 200) {
                    Service.send_notice_box(conn, "Cần tối thiểu 20000 ngọc và 200 hồ quang  xanh để đổi!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-20000);
                conn.p.item.remove(4, 321, 200);
                short iditem = 4786;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 3;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            case 3: {
                if (conn.p.get_ngoc() < 20000 || conn.p.item.total_item_by_id(4, 322) < 200) {
                    Service.send_notice_box(conn, "Cần tối thiểu 20000 ngọc và 200 hồ quang  vàng để đổi!");
                    return;
                }
                if (conn.p.item.get_bag_able() < 1) {
                    Service.send_notice_box(conn, "Không đủ ô trống!");
                    return;
                }
                conn.p.update_ngoc(-20000);
                conn.p.item.remove(4, 322, 200);
                short iditem = 4787;
                Item3 itbag = new Item3();
                itbag.id = iditem;
                itbag.name = ItemTemplate3.item.get(iditem).getName();
                itbag.clazz = ItemTemplate3.item.get(iditem).getClazz();
                itbag.type = ItemTemplate3.item.get(iditem).getType();
                itbag.level = ItemTemplate3.item.get(iditem).getLevel();
                itbag.icon = ItemTemplate3.item.get(iditem).getIcon();
                itbag.op = new ArrayList<>();
                itbag.op.addAll(ItemTemplate3.item.get(iditem).getOp());
                itbag.color = ItemTemplate3.item.get(iditem).getColor();
                itbag.part = ItemTemplate3.item.get(iditem).getPart();
                itbag.op = ItemTemplate3.item.get(iditem).getOp();
                itbag.tier = 0;
                itbag.islock = false;
                itbag.time_use = 0;
                itbag.expiry_date = System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 3;
                conn.p.item.add_item_bag3(itbag);
                conn.p.item.char_inventory(5);

                List<box_item_template> ids = new ArrayList<>();
                ids.add(new box_item_template(iditem, (short) 1, (byte) 3));
                Service.Show_open_box_notice_item(conn.p, "Bạn nhận được", ids);
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;

            }
        }
    }

    private static void Menu_Doubar(Session conn, byte index, byte idmenu) throws IOException {
        conn.p.ResetShop();
        if (idmenu == 1) {
            String s = "Có lỗi xảy ra";
            if (index == 0) {
                s = BossHDL.BossManager.GetInfoBoss(83);
            } else if (index == 1) {
                s = BossHDL.BossManager.GetInfoBoss(84);
            } else if (index == 2) {
                s = BossHDL.BossManager.GetInfoBoss(101);
            } else if (index == 3) {
                s = BossHDL.BossManager.GetInfoBoss(103);
            } else if (index == 4) {
                s = BossHDL.BossManager.GetInfoBoss(104);
            } else if (index == 5) {
                s = BossHDL.BossManager.GetInfoBoss(105);
            } else if (index == 6) {
                s = BossHDL.BossManager.GetInfoBoss(106);
            } else if (index == 7) {
                s = BossHDL.BossManager.GetInfoBoss(149);
            } else if (index == 8) {
                s = BossHDL.BossManager.GetInfoBoss(155);
            } else if (index == 9) {
                s = BossHDL.BossManager.GetInfoBoss(195);
            } else if (index == 10) {
                s = BossHDL.BossManager.GetInfoBoss(173);
            } else if (index == 11) {
                s = BossHDL.BossManager.GetInfoBoss(197);
            } else if (index == 12) {
                s = BossHDL.BossManager.GetInfoBoss(196);
            } else if (index == 13) {
                s = BossHDL.BossManager.GetInfoBoss(186);
            } else if (index == 14) {
                s = BossHDL.BossManager.GetInfoBoss(187);
            } else if (index == 15) {
                s = BossHDL.BossManager.GetInfoBoss(188);
            } else if (index == 16) {
                s = BossHDL.BossManager.GetInfoBoss(174);
            }
            Service.send_notice_box(conn, s);
            return;

        }
        // cua hang item wear
        switch (index) {
            case 0: {
                Service.send_box_UI(conn, 1);
                break;
            }
            case 1: {
                Service.send_box_UI(conn, 2);
                break;
            }
            case 2: {
                Service.send_box_UI(conn, 3);
                break;
            }
            case 3: {
                Service.send_box_UI(conn, 4);
                break;
            }
            case 4: {
                send_menu_select(conn, -4, new String[]{
                    "Dê bạc",
                    "Dê vàng",
                    "Xà nữ",
                    "Bọ cạp chúa",
                    "Quỷ một mắt",
                    "Quỷ đầu bò",
                    "Kỵ sĩ địa ngục",
                    "Nhện chúa",
                    "Giant Skeleton",
                    "Bos Even 7x",
                    "Bos Even 8x",
                    "Bos Even 11x",
                    "Bos Even 13x",
                    "Bos Even 0x",
                    "Bos Even 1x",
                    "Bos Even 2x",
                    "Boss sự kiện"

                }, (byte) 1);
                break;
            }
            case 5: {

                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }

                // dang ky
                if (ChienTruong1.gI().getStatus() == 1) {
                    ChienTruong1.gI().register(conn.p);
                } else {
                    Service.send_notice_box(conn, "Không trong thời gian diễn ra");
                }
                break;
            }

            case 6: {

                Member_ChienTruong1 info = ChienTruong1.gI().get_infor_register(conn.p.name);
                if (info != null) {
                    //conn.p.time_use_item_arena = System.currentTimeMillis() + 10_000;
                    Vgo vgo = new Vgo();
                    switch (info.village) {
                        case 0: { // lang gio
                            vgo.id_map_go = 117;
                            vgo.x_new = 224;
                            vgo.y_new = 256;
                            //MapService.change_flag(conn.p.map, conn.p, 2);
                            break;
                        }

                    }
                    conn.p.change_map(conn.p, vgo);
                } else {
                    Service.send_notice_box(conn, "Chưa đăng ký");
                }
                return;
            }

            case 7: {

                if (!Manager.isShopVang) {
                    Service.send_notice_box(conn, "Chức Năng Đang Tạm Khoá!");
                    return;
                }
                if (conn.p.shopvang = true) {
                    Service.send_box_UI(conn, 37);
                }
                //Service.send_box_UI(conn, 48);
                break;
            }

            case 8: {
                if (conn.p.shoptinhtu = true) {
                    Service.send_box_UI(conn, 37);
                }
                break;

            }
        }
    }

    private static void Menu_keva(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: { // cua hang potion
                Service.send_box_UI(conn, 0);
                break;
            }
            case 1: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                send_menu_select(conn, 600, new String[]{"Khu Làng 10x", "Khu Lảng 11x", "Khu Lảng 12x", "Khu Lảng 13x", "Khu Lảng 14x"});
                break;
            }
            case 2: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                send_menu_select(conn, 601, new String[]{"Khu Boss Even 0x", "Khu Boss Even 1x", "Khu Boss Even 2x", "Khu Boss Even 7x", "Khu Boss Even 8x", "Khu Boss Even 11x", "Khu Boss Even 13x"});
                break;
            }
            case 3: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 103;
                vgo.x_new = 282;
                vgo.y_new = 186;
                conn.p.change_map(conn.p, vgo);

                break;
            }
            case 4: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 1;
                vgo.x_new = 282;
                vgo.y_new = 186;
                conn.p.change_map(conn.p, vgo);

                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Mr_Haku(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_vang() < 500) {
                    Service.send_notice_box(conn, "Không đủ 500 vàng");
                    return;
                }
                conn.p.update_vang(-500);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 67;
                vgo.x_new = 576;
                vgo.y_new = 222;
                conn.p.change_map(conn.p, vgo);

                break;
            }

            default:
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
        }
    }

    private static void Menu_Langphusuongup(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 123;
                vgo.x_new = 282;
                vgo.y_new = 186;
                conn.p.change_map(conn.p, vgo);

                break;
            }
            case 1: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 124;
                vgo.x_new = 282;
                vgo.y_new = 186;
                conn.p.change_map(conn.p, vgo);

                break;
            }
            case 2: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 106;
                vgo.x_new = 282;
                vgo.y_new = 186;
                conn.p.change_map(conn.p, vgo);

                break;
            }
            case 3: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 107;
                vgo.x_new = 282;
                vgo.y_new = 186;
                conn.p.change_map(conn.p, vgo);

                break;
            }
            case 4: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 108;
                vgo.x_new = 282;
                vgo.y_new = 186;
                conn.p.change_map(conn.p, vgo);

                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Langphusuongboss(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 109;
                vgo.x_new = 282;
                vgo.y_new = 186;
                conn.p.change_map(conn.p, vgo);

                break;
            }
            case 1: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 110;
                vgo.x_new = 282;
                vgo.y_new = 186;
                conn.p.change_map(conn.p, vgo);

                break;
            }
            case 2: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 111;
                vgo.x_new = 282;
                vgo.y_new = 186;
                conn.p.change_map(conn.p, vgo);

                break;
            }
            case 3: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 112;
                vgo.x_new = 282;
                vgo.y_new = 186;
                conn.p.change_map(conn.p, vgo);

                break;
            }
            case 4: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 113;
                vgo.x_new = 282;
                vgo.y_new = 186;
                conn.p.change_map(conn.p, vgo);

                break;
            }
            case 5: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 114;
                vgo.x_new = 282;
                vgo.y_new = 186;
                conn.p.change_map(conn.p, vgo);

                break;
            }
            case 6: {
                if (conn.status != 1) {
                    Service.send_notice_box(conn, "Tài khoản chưa được kích hoạt,");
                    return;
                }
                if (conn.p.get_ngoc() < 100) {
                    Service.send_notice_box(conn, "Không đủ 100 ngọc");
                    return;
                }
                conn.p.update_ngoc(-100);

                Vgo vgo = null;
                vgo = new Vgo();
                vgo.id_map_go = 115;
                vgo.x_new = 282;
                vgo.y_new = 186;
                conn.p.change_map(conn.p, vgo);

                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Lisa(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: { // cua hang potion
                Service.send_box_UI(conn, 0);
                break;
            }
            case 1: {
                if (conn.p.item.total_item_by_id(4, 52) > 0) {
                    MoLy.show_table_to_choose_item(conn.p);
                } else {
                    Service.send_notice_box(conn, "Không đủ vé mở trong hành trang");
                }
                break;
            }
            case 2: { // cua hang potion
                Service.send_box_input_text(conn, 22, "% thuế", new String[]{"Nhập % thuế 0 - 5%"});
                break;
            }
            case 3: {
                Member_ChienTruong temp = ChienTruong.gI().get_bxh(conn.p.name);
                if (temp != null) {
                    switch (ChienTruong.gI().get_index_bxh(temp)) {
                        case 0: {
                            short[] id_ = new short[]{3, 2, 53, 54, 18};
                            short[] id2_ = new short[]{5, 5, 1, 1, 10};
                            short[] id3_ = new short[]{7, 7, 4, 4, 4};
                            for (int i = 0; i < id_.length; i++) {
                                Item47 it = new Item47();
                                it.id = id_[i];
                                it.quantity = id2_[i];
                                conn.p.item.add_item_bag47(id3_[i], it);
                            }
                            break;
                        }
                        case 1:
                        case 2: {
                            short[] id_ = new short[]{3, 2, 18};
                            short[] id2_ = new short[]{5, 5, 10};
                            short[] id3_ = new short[]{7, 7, 4};
                            for (int i = 0; i < id_.length; i++) {
                                Item47 it = new Item47();
                                it.id = id_[i];
                                it.quantity = id2_[i];
                                conn.p.item.add_item_bag47(id3_[i], it);
                            }
                            break;
                        }
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9: {
                            short[] id_ = new short[]{3, 18};
                            short[] id2_ = new short[]{5, 10};
                            short[] id3_ = new short[]{7, 4};
                            for (int i = 0; i < id_.length; i++) {
                                Item47 it = new Item47();
                                it.id = id_[i];
                                it.quantity = id2_[i];
                                conn.p.item.add_item_bag47(id3_[i], it);
                            }
                            break;
                        }
                    }
                } else {
                    Service.send_notice_box(conn, "Không có tên trong danh sách");
                }
                break;
            }

            case 4: { // vé ngọc

                Service.send_box_input_text(conn, 51, "1 vé 50k nạp \n Điểm Nạp " + conn.p.get_point_nap() + "", new String[]{"Số Lượng"});

                break;
            }

            case 5: {
                send_menu_select(conn, 129, new String[]{"Nhận Mốc", "Hướng Dẫn", "Tổng Nạp"});
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Emma(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: { // cua hang potion
                Service.send_box_UI(conn, 0);
                break;
            }
            case 1: {
                if (conn.p.item.total_item_by_id(4, 52) > 0) {
                    MoLy.show_table_to_choose_item(conn.p);
                } else {
                    Service.send_notice_box(conn, "Không đủ vé mở trong hành trang");
                }
                break;
            }
            case 2: { // cua hang potion
                Service.send_box_input_text(conn, 22, "% thuế", new String[]{"Nhập % thuế 5 - 20%"});
                break;
            }
            case 3: {
                Member_ChienTruong temp = ChienTruong.gI().get_bxh(conn.p.name);
                if (temp != null) {
                    switch (ChienTruong.gI().get_index_bxh(temp)) {
                        case 0: {
                            short[] id_ = new short[]{3, 2, 53, 54, 18};
                            short[] id2_ = new short[]{5, 5, 1, 1, 10};
                            short[] id3_ = new short[]{7, 7, 4, 4, 4};
                            for (int i = 0; i < id_.length; i++) {
                                Item47 it = new Item47();
                                it.id = id_[i];
                                it.quantity = id2_[i];
                                conn.p.item.add_item_bag47(id3_[i], it);
                            }
                            break;
                        }
                        case 1:
                        case 2: {
                            short[] id_ = new short[]{3, 2, 18};
                            short[] id2_ = new short[]{5, 5, 10};
                            short[] id3_ = new short[]{7, 7, 4};
                            for (int i = 0; i < id_.length; i++) {
                                Item47 it = new Item47();
                                it.id = id_[i];
                                it.quantity = id2_[i];
                                conn.p.item.add_item_bag47(id3_[i], it);
                            }
                            break;
                        }
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9: {
                            short[] id_ = new short[]{3, 18};
                            short[] id2_ = new short[]{5, 10};
                            short[] id3_ = new short[]{7, 4};
                            for (int i = 0; i < id_.length; i++) {
                                Item47 it = new Item47();
                                it.id = id_[i];
                                it.quantity = id2_[i];
                                conn.p.item.add_item_bag47(id3_[i], it);
                            }
                            break;
                        }
                    }
                } else {
                    Service.send_notice_box(conn, "Không có tên trong danh sách");
                }
                break;
            }
            case 5: { // cua hang potion
                ChiemThanhManager.NhanQua(conn.p);
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_CayThong(Session conn, byte index) throws IOException {
        if (Manager.gI().event == 1) {
            switch (index) {
                case 0:
                case 1:
                case 2:
                case 3: {
                    int quant = conn.p.item.total_item_by_id(4, (113 + index));
                    if (quant > 0) {
                        //
                        short[] id_4 = new short[]{2, 5, 52, 142, 225, 271};
                        short[] id_7 = new short[]{0, 4, 23, 34, 39, 352, 357, 362, 367, 372, 377, 382, 387, 392, 397, 402,
                            407, 412,};
                        HashMap<Short, Short> list_4 = new HashMap<>();
                        HashMap<Short, Short> list_7 = new HashMap<>();
                        for (int i = 0; i < quant; i++) {
                            if (conn.p.item.get_bag_able() > 1) {
                                if (80 > Util.random(100)) {
                                    Item47 it = new Item47();
                                    it.category = 4;
                                    it.id = id_4[Util.random(id_4.length)];
                                    it.quantity = (short) Util.random(1, 3);
                                    if (!list_4.containsKey(it.id)) {
                                        list_4.put(it.id, it.quantity);
                                    } else {
                                        short quant_ = it.quantity;
                                        list_4.put(it.id, (short) (list_4.get(it.id) + quant_));
                                    }
                                    conn.p.item.add_item_bag47(4, it);
                                } else {
                                    Item47 it = new Item47();
                                    it.category = 7;
                                    it.id = id_7[Util.random(id_7.length)];
                                    it.quantity = (short) Util.random(1, 2);
                                    if (!list_7.containsKey(it.id)) {
                                        list_7.put(it.id, it.quantity);
                                    } else {
                                        short quant_ = it.quantity;
                                        list_7.put(it.id, (short) (list_7.get(it.id) + quant_));
                                    }
                                    conn.p.item.add_item_bag47(7, it);
                                }
                            }
                        }
                        //
                        Event_1.add_caythong(conn.p.name, quant);
                        conn.p.item.remove(4, (113 + index), quant);
                        conn.p.item.char_inventory(4);
                        conn.p.item.char_inventory(7);
                        String item_receiv = "\n";
                        for (Entry<Short, Short> en : list_4.entrySet()) {
                            item_receiv += ItemTemplate4.item.get(en.getKey()).getName() + " " + en.getValue() + "\n";
                        }
                        for (Entry<Short, Short> en : list_7.entrySet()) {
                            item_receiv += ItemTemplate7.item.get(en.getKey()).getName() + " " + en.getValue() + "\n";
                        }
                        Service.send_notice_box(conn, "Trang trí thành công " + quant + " lần và nhận được:" + item_receiv);
                    } else {
                        Service.send_notice_box(conn, "Không đủ trong hành trang!");
                    }
                    break;
                }
                case 4: {
                    send_menu_select(conn, 120, Event_1.get_top_caythong());
                    break;
                }
                default: {
                    Service.send_notice_box(conn, "Đang bảo trì");
                    break;
                }
            }
        }
    }

    private static void Menu_ThaoKhamNgoc(Session conn, byte index) throws IOException {
        if (conn.p.list_thao_kham_ngoc.size() > 0) {
            if (conn.p.item.get_bag_able() < 3) {
                Service.send_notice_box(conn, "Hành trang không đủ chỗ");
                return;
            }
            Item3 it = conn.p.list_thao_kham_ngoc.get(index);
            if (it != null) {
                for (int i = it.op.size() - 1; i >= 0; i--) {
                    byte id = it.op.get(i).id;
                    if (id == 58 || id == 59 || id == 60) {
                        if (it.op.get(i).getParam(0) != -1) {
                            Item47 it_add = new Item47();
                            it_add.id = (short) (it.op.get(i).getParam(0));
                            it_add.quantity = 1;
                            it_add.category = 7;
                            conn.p.item.add_item_bag47(7, it_add);
                        }
                        it.op.get(i).setParam(-1);
                    } else if (id >= 100 && id <= 107) {
                        it.op.remove(i);
                    } else if (id >= 5 && id <= 6) {
                        it.op.remove(i);
                    }
                }

                conn.p.item.char_inventory(4);
                conn.p.item.char_inventory(7);
                conn.p.item.char_inventory(3);
                Service.send_wear(conn.p);
                Service.send_notice_box(conn, "Tháo thành công");
            }
        }
    }

    private static void Menu_DoiDongMeDaySTG(Session conn, byte index) throws IOException {
        if (conn.p.item.wear != null && conn.p.item.wear.length > 12 && Helps.CheckItem.isMeDay(conn.p.item.wear[12].id)) {
            Service.send_box_input_yesno(conn, 94, "Thực hiện này sẽ tiêu tốn 1000 ngọc, bạn có chắc chắn?");
        } else {
            Service.send_notice_box(conn, "Không có vật phẩm phù hợp!");
        }
    }

    private static void Menu_DoiDongMeDaySTPT(Session conn, byte index) throws IOException {
        if (conn.p.item.wear != null && conn.p.item.wear.length > 12 && Helps.CheckItem.isMeDay(conn.p.item.wear[12].id)) {
            Service.send_box_input_yesno(conn, 98, "Thực hiện này sẽ tiêu tốn 1000 ngọc, bạn có chắc chắn?");
        } else {
            Service.send_notice_box(conn, "Không có vật phẩm phù hợp!");
        }
    }

    private static void Menu_DailyQuest(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                send_menu_select(conn, 559, new String[]{"Dễ", "Bình thường", "Khó", "Rất khó"});
                break;
            }
            case 1: {
                DailyQuest.finish_quest(conn.p);
                break;
            }
            case 2: {
                DailyQuest.remove_quest(conn.p);
                break;
            }
            case 3: {
                Service.send_notice_box(conn, DailyQuest.info_quest(conn.p));
                break;
            }
            case 4: {
                if (conn.p.get_vang() < 1_000_000_000) {
                    Service.send_notice_box(conn, "Không đủ 1tỷ vàng");
                    return;
                }

                if (conn.p.item.total_item_by_id(4, 321) < 1) {
                    Service.send_notice_box(conn, "Không đủ " + ItemTemplate4.item.get(321).getName());
                    return;
                }

                conn.p.update_vang(-1_000_000_000);
                conn.p.item.remove(4, 321, 1);
                conn.p.item.char_inventory(4);
                conn.p.quest_daily[5] += 5;
                Service.send_notice_box(conn, "Số lần nhận nhiệm vụ còn lại " + conn.p.quest_daily[5]);
                break;
            }
        }
    }
    //nvhn
    // private static void Menu_Quest_Daily(Session conn, byte index) throws IOException {
    // switch (index) {
    // case 0: {
    // String notice
    // = "Nhiệm vụ Ngày: đánh quái ngẫu nhiên theo level, tối đa ngày nhận 20 nhiệm vụ, mỗi nhiệm vụ sẽ nhận được phần thưởng kinh nghiệm, ngọc và có cơ hội nhận nguyên liệu mề đay."
    // + "\n Dễ : Vàng Ngọc + Exp" + "\n Bình Thường : Vàng Ngọc, Exp + NL mề Xanh"
    // + "\n Khó :Vàng Ngọc, Exp + NL mề Vàng" + "\n Siêu Khó : Vàng Ngọc, Exp + NL mề Tím";
    // Service.send_notice_box(conn, notice);
    // break;
    // }
    // case 1: {
    // if (conn.p.quest_daily[0] != -1) {
    // Service.send_notice_box(conn, "Đã nhận nhiệm vụ rồi!");
    // } else {
    // if (conn.p.quest_daily[4] > 0) {
    // send_menu_select(conn, 559, new String[]{"Cực Dễ", "Bình thường", "Khó", "Siêu Khó"});
    // } else {
    // Service.send_notice_box(conn, "Hôm nay đã hết lượt, quay lại vào ngày mai");
    // }
    // }
    // break;
    // }
    // case 2: {
    // DailyQuest.remove_quest(conn.p);
    // break;
    // }
    // case 3: {
    // DailyQuest.finish_quest(conn.p);
    // break;
    // }
    // case 4: {
    // Service.send_notice_box(conn, DailyQuest.info_quest(conn.p));
    // break;
    // }
    // }
    // }

    // private static void Menu_Quest(Session conn, byte index) throws IOException {
    // switch (index) {
    //
    // case 0: {
    // send_menu_select(conn, 1000, new String[] {"Hướng dẫn", "Nhận nhiệm vụ", "Hủy nhiệm vụ", "Trả
    // nhiệm vụ", "Kiểm tra"});
    // break;
    // }
    // }
    // }
    private static void Menu_TaiXiu(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                Service.send_box_input_text(conn, 32, "Nhập thông tin",
                        new String[]{"Nhập số coin cược", "Chọn tài (1) hoặc xỉu (2)"});
                break;
            }
            case 1: {
                Manager.gI().tx.send_in4(conn.p);
                break;
            }
            case 2: {
                List<TaiXiuPlayer> temp = Manager.gI().tx.get_tx_history(conn.user);
                if (temp != null) {
                    String notice = "";
                    int dem = 0;
                    for (int i = temp.size() - 1; i >= 0; i--) {
                        if (dem > 20) {
                            break;
                        }
                        dem++;
                        notice += temp.get(i).time + " : ";
                        if (temp.get(i).coin_win > 0) {
                            notice += "thắng " + (temp.get(i).coin_win * 1) + " coin khi chọn "
                                    + ((temp.get(i).type == 1) ? " Tài" : "Xỉu");
                        } else {
                            notice += "thua " + (temp.get(i).coin_win * -1) + " coin khi chọn "
                                    + ((temp.get(i).type == 1) ? " Tài" : "Xỉu");
                        }
                        notice += "\n";
                    }
                    Service.send_notice_box(conn, notice);
                } else {
                    Service.send_notice_box(conn, "Chưa có thông tin");
                }
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void Menu_Wedding(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                if (conn.p.item.wear[23] == null) {
                    Service.send_box_input_text(conn, 66, "Nhập thông tin",
                            new String[]{"Chọn nhẫn (1-4) : ", "Tên đối phương : "});
                } else {
                    Service.send_notice_box(conn, "Nhẫn cưới thì đeo đấy mà đòi cưới thêm ai??");
                }
                break;
            }
            case 1: {
                if (conn.p.item.wear[23] != null) {
                    Wedding temp = Wedding.get_obj(conn.p.name);
                    if (temp != null) {
                        String name_target = "";
                        if (temp.name_1.equals(conn.p.name)) {
                            name_target = temp.name_2;
                        } else {
                            name_target = temp.name_1;
                        }
                        Service.send_box_input_yesno(conn, 111, "Xác định hủy hôn ước với " + name_target);
                    }
                } else {
                    Service.send_notice_box(conn, "Đã cưới ai đâu, ảo tưởng à??");
                }
                break;
            }
            case 2: {
                Item3 it = conn.p.item.wear[23];
                if (it != null) {
                    float perc = (((float) Wedding.get_obj(conn.p.name).exp) / Level.entrys.get(it.tier).exp) * 100f;
                    String notice = "Exp hiện tại : %s, nâng cấp cần %str vàng và %sk ngọc";
                    String a = String.format("%.2f", perc) + "%";
                    Service.send_box_input_yesno(conn, 112,
                            String.format(notice, a, (3 * (it.tier + 1)), (3 * (it.tier + 1))));
                } else {
                    Service.send_notice_box(conn, "Đã cưới ai éo đâu, ảo tưởng à??");
                }
                break;
            }
            case 3: {
                String notice = "Nhẫn cưới\r\n" + "- 3 tỷ vàng \" nhẫn cưới 1\" \r\n" + "- 300k ngọc \" nhẫn cưới 2\"\r\n"
                        + "- 600k ngọc \" nhẫn cưới 3\"\r\n" + "- 900k ngọc \" nhẫn cưới 4\"\r\n" + "Nâng cấp nhẫn:\r\n"
                        + "Khi đã kết hôn vợ và chồng cùng chung 1 nhóm đi up quái hoặc giết boss thì nhẫn cưới sẽ đc + exp\r\n"
                        + "Đến npc Anna để tiến hành nâng cấp nhẫn, mỗi lần nâng cấp tốn 3k ngọc 3tr vàng.\r\n"
                        + "Cấp tối đa của nhẫn là 30. \r\n" + "Lưu ý: Mỗi lần nâng cấp số vàng và ngọc sẽ nhân lên \r\n"
                        + "Ví dụ: Lever 1-2 phí 3k và 3tr lên level 2-3 phí sẽ nhân lên 6k và 6tr vàng";
                Service.send_notice_box(conn, notice);
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void MENU_Leothap(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                String notice = "BẠN CÓ MUỐN TIẾP TỤC CHẾ ĐỘ EASY ";
                Service.send_box_input_yesno(conn, -38, notice);
                conn.p.typelt = 1;
                break;
            }
            case 1: {
                String notice = "BẠN CÓ MUỐN TIẾP TỤC CHẾ ĐỘ MEDIUM";
                Service.send_box_input_yesno(conn, -38, notice);
                conn.p.typelt = 2;
                break;
            }
            case 2: {
                String notice = "BẠN CÓ MUỐN TIẾP TỤC CHẾ ĐỘ HARD";
                Service.send_box_input_yesno(conn, -38, notice);
                conn.p.typelt = 3;
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;

            }
        }
    }

    private static void Menu_op(Session conn, byte index) throws IOException {
        switch (index) {
            case 0: {
                Service.send_box_input_text(conn, 44, "Đổi Chỉ Số", new String[]{"id đầu", "id cuối", "Chỉ Số"});
                break;
            }
            case 1: {
                int selectedIndex = conn.p.chon_item3_index;
                if (selectedIndex != -1 && conn.p.item.bag3[selectedIndex] != null) {
                    Item3 it_change = conn.p.item.bag3[selectedIndex];
                    Item3 it_new = new Item3();
                    it_new.id = it_change.id;
                    it_new.name = it_change.name;
                    it_new.clazz = it_change.clazz;
                    it_new.type = it_change.type;
                    it_new.level = it_change.level;
                    it_new.icon = it_change.icon;
                    it_new.op = new ArrayList<>();
                    for (int i = 0; i < it_change.op.size(); i++) {
                        it_new.op.add(new Option(it_change.op.get(i).id, it_change.op.get(i).getParam(0)));
                    }
                    it_new.color = it_change.color;
                    it_new.part = it_change.part;
                    it_new.tier = it_change.tier;
                    it_new.tierStar = it_change.tierStar;
                    it_new.islock = it_change.islock;
                    it_new.time_use = it_change.time_use;
                    conn.p.chon_item3 = it_new;
                    conn.p.chon_item3_index = selectedIndex;

                    List<String> list1 = new ArrayList<>();
                    for (int i = 0; i < it_change.op.size(); i++) {
                        OptionItem optionItem = OptionItem.get(it_change.op.get(i).id);
                        list1.add(optionItem.getName() + " "
                                + ((optionItem.getIspercent() == 1)
                                ? (it_change.op.get(i).getParam(it_change.tier) / 100)
                                : it_change.op.get(i).getParam(it_change.tier)));
                    }
                    String[] list = list1.toArray(new String[list1.size()]);
                    send_menu_select(conn, 607, list);
                }
                break;
            }
            case 2: {
                int selectedIndex = conn.p.chon_item3_index;
                if (selectedIndex != -1 && conn.p.item.bag3[selectedIndex] != null) {
                    Item3 it_change = conn.p.item.bag3[selectedIndex];
                    Item3 it_new = new Item3();
                    it_new.id = it_change.id;
                    it_new.name = it_change.name;
                    it_new.clazz = it_change.clazz;
                    it_new.type = it_change.type;
                    it_new.level = it_change.level;
                    it_new.icon = it_change.icon;
                    it_new.op = new ArrayList<>();
                    for (int i = 0; i < it_change.op.size(); i++) {
                        it_new.op.add(new Option(it_change.op.get(i).id, it_change.op.get(i).getParam(0)));
                    }
                    it_new.color = it_change.color;
                    it_new.part = it_change.part;
                    it_new.tier = it_change.tier;
                    it_new.tierStar = it_change.tierStar;
                    it_new.islock = it_change.islock;
                    it_new.time_use = it_change.time_use;
                    conn.p.chon_item3 = it_new;
                    conn.p.chon_item3_index = selectedIndex;

                    List<String> list1 = new ArrayList<>();
                    for (int i = 0; i < it_change.op.size(); i++) {
                        OptionItem optionItem = OptionItem.get(it_change.op.get(i).id);
                        list1.add(optionItem.getName() + " "
                                + ((optionItem.getIspercent() == 1)
                                ? (it_change.op.get(i).getParam(it_change.tier) / 100)
                                : it_change.op.get(i).getParam(it_change.tier)));
                    }
                    String[] list = list1.toArray(new String[list1.size()]);
                    send_menu_select(conn, 608, list);
                }
                break;
            }

            case 3: {
                Service.send_box_input_text(conn, 47, "Thêm Chỉ Số", new String[]{"id", "Param"});
                break;
            }

            case 4: {
                int selectedIndex = conn.p.chon_item3_index;
                if (selectedIndex != -1 && conn.p.item.bag3[selectedIndex] != null) {
                    Item3 it_change = conn.p.item.bag3[selectedIndex];
                    Item3 it_new = new Item3();
                    it_new.id = it_change.id;
                    it_new.name = it_change.name;
                    it_new.clazz = it_change.clazz;
                    it_new.type = it_change.type;
                    it_new.level = it_change.level;
                    it_new.icon = it_change.icon;
                    it_new.op = new ArrayList<>();
                    for (int i = 0; i < it_change.op.size(); i++) {
                        it_new.op.add(new Option(it_change.op.get(i).id, it_change.op.get(i).getParam(0)));
                    }
                    it_new.color = it_change.color;
                    it_new.part = it_change.part;
                    it_new.tier = it_change.tier;
                    it_new.tierStar = it_change.tierStar;
                    it_new.islock = it_change.islock;
                    it_new.time_use = it_change.time_use;
                    conn.p.chon_item3 = it_new;
                    conn.p.chon_item3_index = selectedIndex;

                    List<String> list1 = new ArrayList<>();
                    for (int i = 0; i < it_change.op.size(); i++) {
                        OptionItem optionItem = OptionItem.get(it_change.op.get(i).id);
                        list1.add(optionItem.getName() + " "
                                + ((optionItem.getIspercent() == 1)
                                ? (it_change.op.get(i).getParam(it_change.tier) / 100)
                                : it_change.op.get(i).getParam(it_change.tier)));
                    }
                    String[] list = list1.toArray(new String[list1.size()]);
                    send_menu_select(conn, 609, list);
                }
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;
            }
        }
    }

    private static void deleteOption(Session conn, int selectedIndex, int optionIndex) throws IOException {
        if (selectedIndex != -1 && conn.p.item.bag3[selectedIndex] != null) {
            Item3 it_change = conn.p.item.bag3[selectedIndex];

            // Xử lý xóa option ở đây
            if (optionIndex >= 0 && optionIndex < it_change.op.size()) {
                it_change.op.remove(optionIndex);
                conn.p.item.bag3[selectedIndex] = it_change; // Cập nhật lại item trong túi
                conn.p.item.char_inventory(5);
                conn.p.item.char_inventory(3);
                Service.send_notice_box(conn, "Đã xóa Option thành công");

                // Đặt lại thông tin lựa chọn nếu cần thiết
                conn.p.chon_item3 = null;
                conn.p.chon_item3_index = -1;
                conn.p.chon_option = -1;

                // Gửi cập nhật tới client nếu cần thiết
                Service.send_wear(conn.p);
                Service.send_char_main_in4(conn.p);
            } else {
                Service.send_notice_box(conn, "Lỗi: Option không tồn tại");
            }
        }
    }

    private static void Menu_ttclan(Session conn, Message m2, byte index) throws IOException {
        switch (index) {
            case 0: {
                Player p0 = conn.p;
                if (index >= 0 && index < BXH.BXH_clan.size()) {
                    Clan selectedClan = BXH.BXH_clan.get(index);
                    selectedClan.clan_process(conn, m2, 19);
                    //Service.send_notice_box(conn, "Chào mừng bạn đến vớ bang hội " + selectedClan.name_clan);
                }
                break;
            }
            case 1: {

                Player p0 = conn.p;
                if (index >= 0 && index < BXH.BXH_clan.size()) {
                    Clan selectedClan = BXH.BXH_clan.get(index);
                    selectedClan.clan_process(conn, m2, 13);
                    //Service.send_notice_box(conn, "Chào mừng bạn đến vớ bang hội " + selectedClan.name_clan);
                }

                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng");
                break;

            }
        }
    }

    public static void onMenuSelect(Session conn, Message m2, int selectedIndex) throws IOException {
        Player p0 = conn.p;
        if (selectedIndex >= 0 && selectedIndex < BXH.BXH_clan.size()) {
            Clan selectedClan = BXH.BXH_clan.get(selectedIndex);
            selectedClan.clan_process(conn, m2, 19);
            //Service.send_notice_box(conn, "Chào mừng bạn đến vớ bang hội " + selectedClan.name_clan);
        } else {
            Service.send_notice_box(conn, "lỏ");
        }
    }

    public static void LoanDauRanking(Session conn) throws IOException {
        List<Entry<String, Integer>> sortedPlayers = new ArrayList<>();
        File file = new File(PlayerPoints.TEMP_FILE_PATH);

        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] data = line.split(",");
                    if (data.length == 4) { // Đảm bảo định dạng là ID, Tên, Điểm, nhận quà
                        try {
                            int points = Integer.parseInt(data[2]);
                            String playerName = data[1];
                            sortedPlayers.add(new AbstractMap.SimpleEntry<>(playerName, points));
                        } catch (NumberFormatException e) {
                            // Bỏ qua dòng này nếu điểm không phải là số
                            continue;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Service.send_notice_box(conn, "Lỗi khi đọc dữ liệu bảng xếp hạng.");
                return;
            }
        } else {
            Service.send_notice_box(conn, "Không tìm thấy dữ liệu bảng xếp hạng.");
            return;
        }

        sortedPlayers.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        String[] rankingList = new String[Math.min(10, sortedPlayers.size())];
        for (int i = 0; i < rankingList.length; i++) {
            String playerName = sortedPlayers.get(i).getKey();
            int points = sortedPlayers.get(i).getValue();
            rankingList[i] = "Top " + (i + 1) + ": " + playerName + " - " + points + " điểm";
        }

        send_menu_select(conn, 120, rankingList);
    }

    private static void Menu_Farm(Session conn, int idmob, byte idmenu, byte index) throws IOException, SQLException {
        MobFarm mobFarm = Farm.getMob(idmob, conn.p.index);
        if (mobFarm == null) {
            Service.send_notice_box(conn, "Không tìm thấy ô đất.");
            return;
        }

        System.out.println("idmenu: " + idmenu + " - mobFarm.nameOwner: " + mobFarm.nameOwner + " - conn.p.name: " + conn.p.name);

        switch (idmenu) {

            case 1: { // Mua Ô Đất
                // Xác định danh sách ô đất
                List<Farm.MobFarm> playerMobs = Farm.playerMobFarms.get(conn.p.index);
                if (playerMobs == null) {
                    Service.send_notice_box(conn, "Không tìm thấy danh sách ô đất.");
                    return;
                }

                // Tìm ô đất hiện tại dựa trên idmob
                Farm.MobFarm mobToBuy = playerMobs.stream()
                        .filter(mob -> mob.getId() == idmob)
                        .findFirst()
                        .orElse(null);

                if (mobToBuy == null || !"Đất Hoang".equals(mobToBuy.nameOwner)) {
                    Service.send_notice_box(conn, "Ô đất này không khả dụng.");
                    return;
                }

                // Tính giá mở khóa
                int plotIndex = playerMobs.indexOf(mobToBuy);
                long price = 5_000_000; // Giá gốc
                for (int i = 0; i < plotIndex; i++) {
                    price *= 2; // Nhân đôi giá cho mỗi ô đất đã mở khóa
                }
                Locale localeVN = new Locale("vi", "VN");
                NumberFormat vnFormat = NumberFormat.getInstance(localeVN);
                String formattedPrice = vnFormat.format(price);
                Service.send_box_input_yesno(conn, (byte) 128, "Mở Khóa Ô đất với " + formattedPrice + " vàng?");
                break;
            }
            case 2: // Trồng Cây
                if (conn.p.index != mobFarm.Owner.index) {  // Kiểm tra trực tiếp đối tượng Player
                    Service.send_notice_box(conn, "Bạn không sở hữu ô đất này.");
                    return;
                }

                // Hiển thị danh sách cây trồng
                MenuController.send_menu_select(conn, mobFarm.getId(),
                        new String[]{"Lúa Mạch", "Ngô", "Hoa TuLip", "Cà Tím", "Bí Đỏ", "Đào Tiên"}, (byte) 4); // Chọn loại cây
                break;
            case 4: // Trồng Cây
                if (conn.p.index != mobFarm.Owner.index) {  // Kiểm tra trực tiếp đối tượng Player
                    Service.send_notice_box(conn, "Bạn không sở hữu ô đất này.");
                    return;
                }
                String tencay1 = "";
                String loaitiencay = "";
                int price1 = 0;

                // Xác định loại cây dựa vào chỉ số index
                switch (index) {
                    case 0:
                        tencay1 = "Lúa Mạch";
                        price1 = 5000; // Giá
                        loaitiencay = "vàng";
                        break;
                    case 1:
                        tencay1 = "Ngô";
                        price1 = 15000;
                        loaitiencay = "vàng";
                        break;
                    case 2:
                        tencay1 = "Hoa TuLip";
                        price1 = 300;
                        loaitiencay = "ngọc";
                        break;
                    case 3:
                        tencay1 = "Cà Tím";
                        price1 = 5000;
                        loaitiencay = "ngọc";
                        break;
                    case 4:
                        tencay1 = "Bí Đỏ";
                        loaitiencay = "vàng";
                        price1 = 25_000_000;
                        break;
                    case 5:
                        tencay1 = "Đào Tiên";
                        loaitiencay = "ngọc";
                        price1 = 7500;
                        break;
                    default:
                        Service.send_notice_box(conn, "Loại cây không hợp lệ.");
                        return;
                }
                conn.p.chon_odat = idmob;
                conn.p.chon_cay = index;
                conn.p.loaitiencay = loaitiencay; // 
                // Hiển thị hộp thoại xác nhận
                Service.send_box_input_yesno(conn, (byte) 130, "Trồng cây " + tencay1 + " với giá " + price1 + " " + loaitiencay + "?");
                break;

            case 5:
                MenuController.send_menu_select(conn, mobFarm.getId(),
                        new String[]{"Thóc +1Hp", "Cám Gà +2Hp", "Cám Tiên +3Hp", "Tiên Thảo +10Hp"}, (byte) 6);

                break;

            case 6: {// cám gà
                long currentTime = System.currentTimeMillis();
                long remainingTime = 5 * 60 * 1000 - (currentTime - mobFarm.lastFeedTime);
                // Tính thời gian còn lại (ms)

                if (remainingTime > 0 && !(conn.ac_admin >= 10)) {
                    //Service.send_notice_box(conn, "Vui lòng đợi " + remainingTime / 1000 + " giây để cho gà ăn tiếp.");
                    Message m = new Message(-104);
                    m.writer().writeByte(1);
                    m.writer().writeByte(2);
                    m.writer().writeShort((int) remainingTime / 1000);
                    m.writer().writeUTF("Đợi Sau");
                    m.writer().writeShort(0);
                    m.writer().writeUTF("");
                    conn.addmsg(m);
                    m.cleanup();
                    return;
                }

                // Lưu trữ thông tin cần thiết để xử lý trong yes/no box
                conn.p.chon_odat = idmob;
                conn.p.chon_cam = index;

                int vang = 0;
                int ngoc = 0;
                int coin = 0;
                switch (index) {
                    case 0:
                        vang = 5_000_000;
                        Service.send_box_input_yesno(conn, (byte) 201, "Cho gà ăn thóc với giá " + vang + " vàng?");
                        break;
                    case 1:
                        ngoc = 10_000;
                        Service.send_box_input_yesno(conn, (byte) 201, "Cho gà ăn cám gà với giá " + ngoc + " ngọc?");
                        break;
                    case 2:
                        coin = 5_000;
                        Service.send_box_input_yesno(conn, (byte) 201, "Cho gà ăn cám tiên với giá " + coin + " coin?");
                        break;
                    case 3:
                        coin = 50_000;
                        Service.send_box_input_yesno(conn, (byte) 201, "Cho gà ăn tiên thảo với giá " + coin + " coin?");
                        break;
                    default:
                        Service.send_notice_box(conn, "Thức ăn không hợp lệ.");
                        return;
                }
                break;
            }
            case 7: {
                if (conn.p.index != mobFarm.Owner.index) {
                    Service.send_notice_box(conn, "Bạn không sở hữu ô đất này.");
                    return;
                }

                if (mobFarm.level >= 150) {
                    Service.send_notice_box(conn, "Không thể nâng cấp gà.");
                    return;
                }

                long vang = 0;
                int ngoc = 0;
                int chuyencan = 0;

                if (mobFarm.level < 5) {
                    vang = 25_000_000;
                } else if (mobFarm.level >= 5 && mobFarm.level < 15) {
                    vang = 50_000_000;
                } else if (mobFarm.level >= 15 && mobFarm.level < 20) {
                    vang = 50_000_000;
                    ngoc = 50_000;
                    chuyencan = 1;
                } else if (mobFarm.level >= 20 && mobFarm.level < 25) {
                    vang = 100_000_000;
                    ngoc = 100_000;
                    chuyencan = 2;
                } else if (mobFarm.level >= 25 && mobFarm.level < 30) {
                    vang = 150_000_000;
                    ngoc = 150_000;
                    chuyencan = 3;
                } else if (mobFarm.level >= 30 && mobFarm.level < 35) {
                    vang = 200_000_000;
                    ngoc = 200_000;
                    chuyencan = 4;
                } else if (mobFarm.level >= 35 && mobFarm.level < 40) {
                    vang = 250_000_000;
                    ngoc = 250_000;
                    chuyencan = 5;
                } else if (mobFarm.level >= 40 && mobFarm.level < 45) {
                    vang = 300_000_000;
                    ngoc = 300_000;
                    chuyencan = 6;
                } else if (mobFarm.level >= 45 && mobFarm.level < 50) {
                    vang = 350_000_000;
                    ngoc = 350_000;
                    chuyencan = 7;
                } else if (mobFarm.level >= 50 && mobFarm.level < 100) {
                    vang = 500_000_000;
                    ngoc = 500_000;
                    chuyencan = 10;
                } else if (mobFarm.level >= 100 && mobFarm.level < 150) {
                    vang = 1_000_000_000;
                    ngoc = 1_000_000;
                    chuyencan = 15;
                }

                Locale localeVN = new Locale("vi", "VN");
                NumberFormat vnFormat = NumberFormat.getInstance(localeVN);

                String message = "Nâng lên cấp " + (mobFarm.level + 1) + " với ";
                if (vang > 0) {
                    message += vnFormat.format(vang) + " vàng";
                }
                if (ngoc > 0) {
                    message += (vang > 0 ? " và " : "") + vnFormat.format(ngoc) + " ngọc";
                }
                if (chuyencan > 0) {
                    message += (vang > 0 || ngoc > 0 ? " và " : "") + chuyencan + " điểm chuyên cần";
                }
                message += "?";

                Service.send_box_input_yesno(conn, (byte) 200, message);
                conn.p.chon_odat = idmob;
                break;
            }
            case 8: // Nhận thưởng từ số lượng trứng
                if (!"Trứng".equals(mobFarm.chicken)) { // Kiểm tra nếu không phải là ổ trứng
                    Service.send_notice_box(conn, "Đây không phải là ổ trứng.");
                    return;
                }

                if (mobFarm.eggCount <= 0) { // Kiểm tra nếu không có trứng để thu hoạch
                    Service.send_notice_box(conn, "Không có trứng để nhận thưởng.");
                    return;
                }

                // Kiểm tra nếu có Gà lv >= 5
                boolean hasHighLevelChicken = false;
                List<Farm.MobFarm> playerMobs1 = Farm.playerMobFarms.get(conn.p.index);
                if (playerMobs1 != null) {
                    for (Farm.MobFarm mob : playerMobs1) {
                        if ("Gà".equals(mob.chicken) && mob.level >= 5) {
                            hasHighLevelChicken = true;
                            break;
                        }
                    }
                }

                if (hasHighLevelChicken) {
                    // Tính phần thưởng dựa trên cấp độ gà
                    int reward = 0;
                    for (Farm.MobFarm mob : playerMobs1) {
                        if ("Gà".equals(mob.chicken)) {
                            if (mob.level >= 5 && mob.level < 15) {
                                reward += mobFarm.eggCount * 500000; // 1 trứng = 500000 vàng
                            } else if (mob.level >= 15 && mob.level < 20) {
                                reward += mobFarm.eggCount * 1000; // 1 trứng = 1000 ngọc
                            } else if (mob.level >= 20 && mob.level < 25) {
                                reward += mobFarm.eggCount * 2000; // 1 trứng = 2000 ngọc
                            } else if (mob.level >= 25 && mob.level < 30) {
                                reward += mobFarm.eggCount * 4000; // 1 trứng = 4000 ngọc
                            } else if (mob.level >= 30 && mob.level < 35) {
                                reward += mobFarm.eggCount * 6000; // 1 trứng = 6000 ngọc
                            } else if (mob.level >= 35 && mob.level < 40) {
                                reward += mobFarm.eggCount * 8000; // 1 trứng = 8000 ngọc
                            } else if (mob.level >= 40 && mob.level < 45) {
                                reward += mobFarm.eggCount * 10000; // 1 trứng = 10000 ngọc
                            } else if (mob.level >= 45 && mob.level < 50) {
                                reward += mobFarm.eggCount * 12000; // 1 trứng = 12000 ngọc
                            } else if (mob.level >= 50 && mob.level < 100) {
                                reward += mobFarm.eggCount * 15000; // 1 trứng = 15000 ngọc
                            } else if (mob.level >= 100 && mob.level < 149) {
                                reward += mobFarm.eggCount * 25000; // 1 trứng = 25000 ngọc
                            } else if (mob.level >= 149 && mob.level < 150) {
                                reward += mobFarm.eggCount * 50000; // 1 trứng = 50000 ngọc
                            } else if (mob.level >= 150) {
                                reward += mobFarm.eggCount * 100000; // 1 trứng = 100000 ngọc
                            }
                        }
                    }

                    // Hiển thị thông báo thu hoạch
                    if (reward > 0) {
                        if (reward >= 500000 * mobFarm.eggCount) {
                            Service.send_box_input_yesno(conn, (byte) 131, "Thu hoạch " + mobFarm.eggCount + " Trứng, Nhận " + (mobFarm.eggCount * 500000) + " vàng?");
                        } else {
                            Service.send_box_input_yesno(conn, (byte) 131, "Thu hoạch " + mobFarm.eggCount + " Trứng, Nhận " + reward + " ngọc?");
                        }
                    }
                } else {
                    // Nếu không có gà cấp độ >= 5
                    Service.send_notice_box(conn, "Bạn không có gà đủ cấp độ để nhận thưởng.");
                }
                conn.p.chon_odat = idmob;
                break;

            case 3: // Thu Hoạch
                if ("Cây Thối".equals(mobFarm.name)) { // Nếu cây đã thối
                    Service.send_notice_box(conn, "Cây đã hỏng không thu được gì.");
                    mobFarm.name = "Ô Đất"; // Xóa trạng thái cây
                    mobFarm.currentEff = 221;
                    Farm.remob(conn, idmob);
                    return;
                }

                List<String> tencay = Arrays.asList("Cây 1", "Cây 2", "Cây 3", "Cây 4", "Cây 5", "Cây 6");
                if (!tencay.contains(mobFarm.name)) { // Nếu cây chưa chín
                    long thoiGianConLai = mobFarm.time_caychin() - (System.currentTimeMillis() - mobFarm.timeUpdate); // Tính thời gian còn lại
                    long giayConLai = Math.max(thoiGianConLai / 1000, 0); // Chuyển đổi sang giây, đảm bảo không âm

                    // Gửi thông báo cho người chơi
                    Message m = new Message(-104);
                    m.writer().writeByte(1); // Loại thông báo
                    m.writer().writeByte(2); // ID cây
                    m.writer().writeShort((int) giayConLai); // Thời gian còn lại
                    m.writer().writeUTF(mobFarm.name); // Tên cây
                    m.writer().writeShort(0); // Không có phần thưởng
                    m.writer().writeUTF(""); // Không có thông tin thêm
                    conn.addmsg(m);
                    m.cleanup();
                    return;
                }

                int vang = 0;
                int ngoc = 0;
                if ("Cây 1".equals(mobFarm.name)) { // lúa 
                    vang = 25_000;
                    Service.send_notice_box(conn, "Bạn đã thu hoạch thành công.\n Nhận " + vang + " Vàng!");
                } else if ("Cây 2".equals(mobFarm.name)) { // Ngô
                    vang = 75_000;
                    Service.send_notice_box(conn, "Bạn đã thu hoạch thành công.\n Nhận " + vang + " Vàng!");
                } else if ("Cây 3".equals(mobFarm.name)) { // hoa 
                    vang = 500_000;
                    ngoc = 500;
                    Service.send_notice_box(conn, "Bạn đã thu hoạch thành công.\n Nhận " + vang + " Vàng\n " + ngoc + " ngọc ");
                } else if ("Cây 4".equals(mobFarm.name)) { // cà tím
                    // vang = 3500;
                    mobFarm.qitem(conn.p);
                } else if ("Cây 5".equals(mobFarm.name)) { // bí đỏ
                    ngoc = 2500;
                    conn.p.phan_tram_exp(3);
                    Service.send_notice_box(conn, "Bạn đã thu hoạch thành công.\n Nhận " + ngoc + "Ngọc + 3% exp");
                } else if ("Cây 6".equals(mobFarm.name)) { // đào tiên
                    mobFarm.item_key(conn.p);
                    conn.p.phan_tram_exp(5);
                    //Service.send_notice_box(conn, "Bạn đã thu hoạch thành công.\n Nhận " + ngoc + "Ngọc + 5% exp");
                }

                // Cập nhật trạng thái cây sau khi thu hoạch
                mobFarm.name = "Ô Đất";
                conn.p.update_vang(vang);
                conn.p.update_ngoc(ngoc);
                mobFarm.currentEff = 221;
                Farm.remob(conn, idmob);
                Farm.SaveData(conn.p);

                break;

            default:
                Service.send_notice_box(conn, "Hành động không hợp lệ.");
        }
    }

    private static void Menu_NapVip(Session conn, byte index) throws IOException, SQLException {
        if (!conn.p.isOwner) {
            return;
        }
        switch (index) {
            case 0: { // Điểm danh VIP và nhận vàng + ngọc
                if (conn.vip < 1) {
                    Service.send_notice_box(conn, "Dành cho Vip 1 trở lên!");
                    return;
                }
                if (conn.p.diem_danh[2] == 0) {
                    conn.p.diem_danh[2] = 1;

                    int vipMultiplier = (conn.vip >= 5) ? conn.vip : 1; // Nhân nếu VIP >= 5
                    int vang_ = Util.random(100_000, 500_000) * vipMultiplier;
                    int ngoc_ = Util.random(2000, 5000) * vipMultiplier;

                    conn.p.update_vang(vang_);
                    conn.p.update_ngoc(ngoc_); // Đổi thành update_ngoc() để cập nhật ngọc

                    conn.p.item.char_inventory(5);
                    Service.send_notice_box(conn, "Điểm danh VIP thành công, bạn nhận được:\r\n"
                            + vang_ + " Vàng.\r\n"
                            + ngoc_ + " Ngọc.");
                } else {

                    Service.send_notice_box(conn, "Bạn đã điểm danh VIP hôm nay rồi.");
                }
                break;
            }

            case 1: { // Hướng dẫn chi tiết về cách nâng cấp VIP và quyền lợi của VIP
                String message = "Hướng dẫn VIP:\n\n"
                        + "Nâng cấp VIP:\n"
                        + "- Donet vào game để tăng tổng nạp.\n"
                        + "- Khi đạt đến các mốc, bạn sẽ được nâng cấp VIP.\n\n"
                        + "Quyền lợi VIP:\n"
                        + "- VIP 1: Điểm Danh Vip, Mở Khóa Farm \n"
                        + "- VIP 2: Mở Khóa Shop Vip, Mở khóa Đổi ngọc ra coin ở zuzlu \n"
                        + "- VIP 3: Đổi coin sang vàng tỉ lệ x2 \n"
                        + "- VIP 4: Đổi coin sang ngọc tỉ lệ x2 \n"
                        + "- VIP 5: Điểm danh x với Vip >= 5, tăng tỉ lệ Chuyển sinh 10% \n"
                        + "- VIP 6: Tăng Tỉ lệ rơi nguyên liệu, +10% tỉ lệ chế đồ Tinh Tú \n"
                        + "- VIP 7: Tăng lượt đi Phó bản, Nhiệm vụ hằng ngày+ 20 \n"
                        + "- VIP 8: Mở khóa shop nguyên liệu ,Siêu Thần và Siêu cấp \n"
                        + "- VIP 9: Sử dụng vé x4 x2 thời gian, + mỗi ngày nhận 50k tiền nạp, và Coin + 1 Danh hiệu Chiến Thần \n";
                //+ "Hãy nạp tiền để trải nghiệm những đặc quyền tuyệt vời của VIP!";

                Service.send_notice_box(conn, message);
                break;
            }
            case 2: {
                int[] requiredTongnap = {50_000, 150_000, 300_000, 500_000, 750_000, 1_050_000, 1_500_000, 2_100_000, 3_000_000};
                if (conn.vip >= 9) {
                    Service.send_notice_box(conn, "Bạn đã đạt cấp độ VIP tối đa!");
                } else if (conn.vip < requiredTongnap.length) {
                    int requiredExp = requiredTongnap[conn.vip];
                    if (conn.tongnap >= requiredExp) {
                        conn.up_vip(1);
                        Service.send_notice_box(conn, "Nâng VIP thành công! Bạn đã đạt cấp độ VIP " + (conn.vip) + "!");
                    } else {
                        int expNeeded = (int) (requiredExp - conn.tongnap);
                        String formattedExpNeeded = String.format("%,d", expNeeded); // Định dạng với dấu phẩy
                        Service.send_notice_box(conn, "Bạn còn thiếu " + formattedExpNeeded + " VND để nâng lên VIP " + (conn.vip + 1) + "!");
                    }
                }
                break;
            }

            case 3: { //
                if (conn.vip < 2) {
                    Service.send_notice_box(conn, "Dành cho Vip 2 trở lên!");
                    return;
                }
                Service.send_notice_box(conn, "Shop VIP đang được cập nhật."); // Thay bằng code mở shop VIP khi có
                break;
            }
            case 4: { // Tổng nạp (đã có sẵn)
                String percents = String.format("%,.0f", (((float) conn.p.get_tongnap())));
                Service.send_notice_box(conn, "Bạn đã nạp tổng cộng là : " + percents + " VND!");
                break;
            }

            case 5: { // Hiển thị quyền lợi VIP hiện tại
                int currentVip = conn.vip;
                String vipInfo = "Bạn đang ở VIP " + currentVip + ".\n";

                // Danh sách quyền lợi theo cấp độ VIP
                String[] vipBenefits = {
                    "Điểm Danh Vip, Mở Khóa Farm", // VIP 1
                    "Mở Khóa Shop Vip, Mở khóa Đổi ngọc ra coin ở zuzlu", // VIP 2
                    "Đổi coin sang vàng tỉ lệ x2", // VIP 3
                    "Đổi coin sang ngọc tỉ lệ x2", // VIP 4
                    "Điểm danh x với Vip >= 5, tăng tỉ lệ Chuyển sinh 10% ", // VIP 5
                    "Tăng Tỉ lệ rơi nguyên liệu, +10% tỉ lệ chế đồ Tinh Tú", // VIP 6
                    "Tăng lượt đi Phó bản, Nhiệm vụ hằng ngày+ 20", // VIP 7
                    "Mở khóa shop nguyên liệu ,Siêu Thần và Siêu cấp", // VIP 8
                    "Sử dụng vé x4 x2 thời gian, + mỗi ngày nhận 50k tiền nạp, và Coin + 1 Danh hiệu Chiến Thần" // VIP 9
                };

                // Hiển thị quyền lợi hiện tại
                if (currentVip > 0 && currentVip <= vipBenefits.length) {
                    for (int i = 0; i < currentVip; i++) {
                        vipInfo += "- " + vipBenefits[i] + "\n";
                    }
                } else {
                    vipInfo += "Chưa có quyền lợi VIP. Hãy nâng cấp VIP để nhận đặc quyền!";
                }

                // Hiển thị quyền lợi tiếp theo (nếu chưa đạt tối đa)
                if (currentVip < vipBenefits.length) {
                    vipInfo += "\nQuyền lợi khi đạt VIP " + (currentVip + 1) + ":\n";
                    vipInfo += "- " + vipBenefits[currentVip] + "\n";
                } else {
                    vipInfo += "\nBạn đã đạt cấp độ VIP tối đa!";
                }

                // Gửi thông báo
                Service.send_notice_box(conn, vipInfo);
                break;
            }
            case 6: { //
                if (conn.p.shopitem7 = true) {
                    Service.send_box_UI(conn, 37);
                }
                // Service.send_notice_box(conn, "Shop NL VIP đang được cập nhật."); // Thay bằng code mở shop VIP khi có
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng này.");
                break;
            }
        }
    }

    private static void Menu_Tet(Session conn, int idmob, byte idmenu, byte index) throws IOException, SQLException {
        MobNpc mobNpc = Event_tet.getMob(idmob);
        if (mobNpc == null) {
            Service.send_notice_box(conn, "Không tìm thấy Npc.");
            return;
        }
        switch (idmenu) {
            case 0: { //Nồi Bánh
                switch (index) {
                    case 0: {
                        if (conn.p.get_ngoc() < 10) {
                            Service.send_notice_box(conn, "Không đủ 10 ngọc");
                            return;
                        }
                        if (Event_5.naubanh.time <= 30) {
                            Service.send_notice_box(conn, "Không thể tăng tốc");
                            return;
                        }
                        conn.p.update_ngoc(-10);
                        conn.p.item.char_inventory(5);
                        Event_5.naubanh.update(1);
                        Service.send_notice_box(conn, "Tăng tốc thành công");

                        break;
                    }
                    case 1: { // Hướng dẫn
                        Service.send_notice_box(conn, "Nguyên liệu cần để nấu bánh như sau: lá, gạo, đậu xanh, thịt\r\n"
                                + "- Mỗi ngày server cho nấu bánh 1 lần vào lúc 17h , thời gian nấu là 2 tiếng.\r\n"
                                + "- Thời gian đăng ký là từ 19h ngày hôm trước đến 16h30 ngày hôm sau. Phí đăng ký là 5 ngọc\r\n"
                                + "- Một lần tăng tốc mất 10 ngọc và sẽ giảm được 2 phút nấu\r\n"
                                + "- Số bánh tối đa nhận được là 20 bánh.Tuy nhiên nếu các hiệp sĩ góp càng nhiều thì càng có lợi vì 10 người chơi góp nhiều nguyên liệu nhất sẽ được cộng thêm 20 cái\r\n"
                                + "+ Số bánh nhận được sẽ tính theo công thức: 1 Lá + 1 Gạo nếp + 1 Đậu xanh + 1 Thịt heo");
                        break;
                    }
                    case 2: {// thông tin

                        Service.send_notice_box(conn,
                                "Thông tin:\nĐã góp : " + Event_5.get_banh_now(conn.p.name) + "\nThời gian nấu còn lại : "
                                + ((Event_5.naubanh.time == 0) ? "Không trong thời gian nấu"
                                        : ("Còn lại " + Event_5.naubanh.time + "p")));

                        break;
                    }
                    case 3: { // bxh
                        send_menu_select(conn, 120, Event_5.get_top_naubanh());

                        break;
                    }
                }
                break;
            }
            case 1: { //Cây Nêu
                switch (index) {
                    case 0: {
                        send_menu_select(conn, 120, Event_5.get_top_dotphao());

                        break;
                    }
                    case 1: {
                        send_menu_select(conn, 120, Event_5.get_top_moqua());
                        break;
                    }
                }
                break;
            }
            case 2: { //cây Lì xì
                switch (index) {
                    case 0: {
                        Service.send_box_input_text(conn, 57, "Đốt Pháo", new String[]{"Số lượng :"});
                        break;
                    }
                    case 1: {
                        Service.send_notice_box(conn, "Nguyên Liệu cần:\r\n"
                                + "+ 1 Giấy Đỏ + 1 Thuốc Nổ + 5m vàng Và 5k ngọc!\r\n"
                                + "Giấy Và Thuốc Nổ lấy ở Phó bản!"
                        );
                        break;
                    }
                }
                break;
            }
            default: {
                Service.send_notice_box(conn, "Chưa có chức năng này.");
                break;
            }
        }
    }

    //
    private static void Menu_OngDo(Session conn, byte index) throws IOException, SQLException {
        if (!conn.p.isOwner) {
            return;
        }
        switch (index) {

            case 0: { // Góp Nguyên Liệu                                                   
                if (!Event_5.check(conn.p.name)) {
                    Service.send_box_input_yesno(conn, (byte) 202, "Đăng ký Nấu Bánh với 5 ngọc?");
                    return;
                }
                if (Event_5.check(conn.p.name)) {
                    Service.send_box_input_text(conn, 53, "Góp Nguyên Liệu", new String[]{"Số lượng :"});
                }
                break;
            }
            case 1: { // Hướng dẫn 
                Service.send_notice_box(conn, "_Nguyên liệu cần để đổi bánh giày như sau :\r\n"
                        + "5 Lá + 5 Gạo nếp + 5 Đậu xanh + 5 Trứng + 500k vàng.\r\n"
                        + "_Ghép Chữ: Thu Thập Các Ký Tự để ghép Happy New year\r\n"
                        + "Ký Tự có thể thu thập ngẫu nhiên từ việc đốt pháo\r\n"
                        + "_Dâng bánh: 1 Bánh chưng + 1 Bánh dày + 5m vàng\r\n"
                        + "Thưởng Dâng Bánh Ngẫu nhiên nhận...?"
                );

                break;
            }
            case 2: { // Nhận Bánh
                int quant = Event_5.get_banh(conn.p.name);
                if (quant > 0) {
                    quant = (quant > 20) ? 20 : quant;
                    if (Event_5.list_bxh_naubanh_name.contains(conn.p.name)) {
                        quant += 20;
                    }
                    // quant *= 3;
                    Item47 it = new Item47();
                    it.category = 4;
                    it.id = 162;
                    it.quantity = (short) quant;
                    conn.p.item.add_item_bag47(4, it);
                    conn.p.item.char_inventory(4);
                    Service.send_notice_box(conn, "Nhận được " + quant + " bánh");
                } else {
                    Service.send_notice_box(conn, "Đã nhận rồi hoặc chưa tham gia!");
                }
                break;
            }

            case 3: { // Đổi Bánh Dày
                Service.send_box_input_text(conn, 54, "Đổi bánh giày", new String[]{"Số lượng :"});
                break;
            }

            case 4: { // Gép chữ
                Service.send_box_input_text(conn, 55, "Ghép chữ", new String[]{"Số lượng :"});
                break;
            }
            case 5: { // Dâng bánh
                Service.send_box_input_text(conn, 56, "Dâng bánh", new String[]{"Số lượng :"});
                break;
            }

            default: {
                Service.send_notice_box(conn, "Chưa có chức năng này.");
                break;
            }
        }
    }
    //

}
