package plant;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbutil.DBUtil;

@WebServlet("/game")
public class Game extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession session = req.getSession();
       String plant = (String) session.getAttribute("plant");
       String id = (String) session.getAttribute("userid");
       if (plant != null && plant.equals("plant")) {
           String but = (String) req.getParameter("buttonId");
           System.out.println(but);
           setplant(id);
           session.removeAttribute("plant");
       }
      session.setAttribute("inven", item(id));
      System.out.println(id);
      Map<String, List<String>> map = nowplant(id);
      if (map.size() > 0) {
         session.setAttribute("gamein", map);
      }
      req.getRequestDispatcher("/game.jsp").forward(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession session = req.getSession();
      String userid = (String) session.getAttribute("userid");// 유저 아이디
      List<Integer> nolist = itemNo(userid);
      String inv = (String) req.getParameter("invencl");// 인벤토리 자리
      String but = (String) req.getParameter("buttonId");// (식물 심는곳)몇번째 자리인지
      int b = Integer.valueOf(inv);
      if (nolist.size() >= b) {
         int c = nolist.get(b);
         int bu = Integer.valueOf(but);
         newplant(userid, c, but, ck(getplantgr(c), bu));
      }
      resp.sendRedirect("/333/game");
   }

   public Map<String, List<String>> nowplant(String id) {
      LocalDateTime date = LocalDateTime.now();
      Map<String, List<String>> map = new HashMap<>();
      List<String> ok = new ArrayList<>();
      List<String> no = new ArrayList<>();
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      String sql = "select seat, herbtime from playlog where logId = ? and harvesting = 0";

      try {
         conn = DBUtil.getConnection();
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, id);
         rs = stmt.executeQuery();
         while (rs.next()) {
            String seat = rs.getString("seat");
            LocalDateTime time = (LocalDateTime) rs.getObject("herbtime");
            if (date.isAfter(time)) {
               ok.add(seat);
            } else {
               no.add(seat);
            }
         }
         map.put("ok", ok);
         map.put("no", no);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBUtil.close(rs);
         DBUtil.close(stmt);
         DBUtil.close(conn);
      }
      return map;
   }

   public int newplant(String id, int logNo, String seat, int time) {
      LocalDateTime date = LocalDateTime.now();
      LocalDateTime plustime = date.plusSeconds(time);
      Connection conn = null;
      PreparedStatement stmt = null;
      String sql = "INSERT INTO playlog (localdate, logId, logNo, seat, herbtime) VALUES (?, ?, ?, ?, ?);";

      try {
         conn = DBUtil.getConnection();
         stmt = conn.prepareStatement(sql);
         stmt.setObject(1, date);
         stmt.setString(2, id);
         stmt.setInt(3, logNo);
         stmt.setString(4, seat);
         stmt.setObject(5, plustime);
         return stmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBUtil.close(stmt);
         DBUtil.close(conn);
      }
      return -1;
   }

   public List<Blob> item(String id) {
      List<Blob> list = new ArrayList<>();
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      String sql = "SELECT plantImage\r\n" + "FROM inventory AS a\r\n"
            + "INNER JOIN plant AS b ON a.no = b.plantNo\r\n" + "WHERE a.userId = ? AND plantGroup LIKE '%씨앗주머니%';";
      try {
         conn = DBUtil.getConnection();
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, id);
         rs = stmt.executeQuery();
         while (rs.next()) {
            Blob shopNo = rs.getBlob("plantImage");
            list.add(shopNo);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBUtil.close(rs);
         DBUtil.close(stmt);
         DBUtil.close(conn);
      }
      return list;
   }

   public List<Integer> itemNo(String id) {
      List<Integer> list = new ArrayList<>();
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      String sql = "SELECT plantNo FROM inventory as a INNER JOIN plant AS b ON a.no = b.plantNo WHERE a.userId = ? AND plantGroup LIKE '%씨앗주머니%';";
      try {
         conn = DBUtil.getConnection();
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, id);
         rs = stmt.executeQuery();
         while (rs.next()) {
            int shopNo = rs.getInt("plantNo");
            list.add(shopNo);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBUtil.close(rs);
         DBUtil.close(stmt);
         DBUtil.close(conn);
      }
      return list;
   }

   public List<String> getplantgr(int no) {
      List<String> list = new ArrayList<>();
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      String sql = "SELECT plantGroup, plantLuminous FROM plant where plantNo = ?;";
      try {
         conn = DBUtil.getConnection();
         stmt = conn.prepareStatement(sql);
         stmt.setInt(1, no);
         rs = stmt.executeQuery();
         if (rs.next()) {
            String plantGroup = rs.getString("plantGroup");
            String a = plantGroup.substring(5);
            String plantLuminous = rs.getString("plantLuminous");
            list.add(a);
            list.add(plantLuminous);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBUtil.close(rs);
         DBUtil.close(stmt);
         DBUtil.close(conn);
      }
      return list;
   }

   public int setplant(String id) {
      Connection conn = null;
      PreparedStatement stmt = null;
      String sql = "UPDATE `playlog` SET `harvesting` = '1' where logId = ? and seat = 1;";
      try {
         conn = DBUtil.getConnection();
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, id);
         return stmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DBUtil.close(stmt);
         DBUtil.close(conn);
      }
      return -1;
   }

   private int ck(List<String> a, int num) {
      String fun = "음지";
      int nut = 0;
      if (num < 12) {
         fun = "양지";
      }
      switch (a.get(0)) {
      case "A":
         nut = (int) (Math.random() * 11) + 20;
         if (a.get(1).equals(fun)) {
            nut -= nut / 10;
         }
         break;
      case "B":
         nut = (int) (Math.random() * 11) + 30;
         if (a.get(1).equals(fun)) {
            nut -= nut / 10;
         }
         break;
      case "C":
         nut = (int) (Math.random() * 11) + 40;
         if (a.get(1).equals(fun)) {
            nut -= nut / 10;
         }
         break;
      case "D":
         nut = (int) (Math.random() * 11) + 50;
         if (a.get(1).equals(fun)) {
            nut -= nut / 10;
         }
         break;
      case "E":
         nut = (int) (Math.random() * 11) + 60;
         if (a.get(1).equals(fun)) {
            nut -= nut / 10;
         }
         break;
      case "F":
         nut = (int) (Math.random() * 11) + 70;
         if (a.get(1).equals(fun)) {
            nut -= nut / 10;
         }
         break;
      case "G":
         nut = (int) (Math.random() * 11) + 80;
         if (a.get(1).equals(fun)) {
            nut -= nut / 10;
         }
         break;
      case "H":
         nut = (int) (Math.random() * 11) + 90;
         if (a.get(1).equals(fun)) {
            nut -= nut / 10;
         }
         break;
      case "L":
         nut = (int) (Math.random() * 11) + 100;
         if (a.get(1).equals(fun)) {
            nut -= nut / 10;
         }
         break;
      default:
         break;
      }
      return nut;
   }
}