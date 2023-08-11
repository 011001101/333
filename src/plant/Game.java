package plant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.mysql.cj.jdbc.SuspendableXAConnection;

import DButil.dbutil;

@WebServlet("/game")
public class Game extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession session = req.getSession();
      String id = (String) session.getAttribute("userId");
      session.setAttribute("inven", item(id));
      System.out.println(id);
      Map<String, List<String>> map = nowplant(id);// 현재 심어진 식물
      session.setAttribute("gamein", map);
      // 이부분은 갱신할 필요는 없음
      Gson gson = new Gson();
      List<byte[]> imglist = item(id); // 이미지 byte 타입으로 가져오기
      List<String> imgEncode = new ArrayList<>();
      Encoder encode = Base64.getEncoder();
      for (int j = 0; j < imglist.size(); j++) {
         String encodeStr = encode.encodeToString(imglist.get(j));
         imgEncode.add(encodeStr);
      } // byte타입을 Base64 String 으로 변환
      String imglistJson = gson.toJson(imgEncode);
      session.setAttribute("imglistJ", imglistJson);
      req.getRequestDispatcher("/game.jsp").forward(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession session = req.getSession();
      String plant = req.getParameter("plant");
      String but = req.getParameter("buttonId");// (식물 심는곳)몇번째 자리인지
      String id = (String) session.getAttribute("userId");
      System.out.println(id);
      if (plant != null && plant.equals("plant")) {
         if (but != null) {
            String plantName = itemplus1(id, but);// 뽑은 식물 이름 가져옴
            int plantNo = shopNo(plantName);// 상점의 뽑은 식물 번호 가져오기
            updateInven(id, plantNo);// 인벤토리에 추가
            setplant(id, but);// 식물 뽑았다고 바꿈
         }
      } else {
         List<Integer> nolist = itemNo(id);
         System.out.println(nolist.toString());
         System.out.println("사용됨");
         String inv = (String) req.getParameter("invencl");// 인벤토리 자리
         int b = Integer.valueOf(inv);
         System.out.println(b);
         if (nolist.size() != 0 && nolist.size() >= b) {
            System.out.println("사용됨2");
            int c = nolist.get(b);
            newplant(id, c, but, ck(getplantgr(c), but)); // 식물 심음
            delectIv(id, c);// 사용한 아이템 삭제
         }
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
         conn = dbutil.getConnection();
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
         dbutil.close(rs);
         dbutil.close(stmt);
         dbutil.close(conn);
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
         conn = dbutil.getConnection();
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
         dbutil.close(stmt);
         dbutil.close(conn);
      }
      return -1;
   }

   public List<byte[]> item(String id) {
      byte[] by = null;
      List<byte[]> img = new ArrayList<>();
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      String sql = "SELECT itemImage FROM inventory AS a INNER JOIN shop AS b ON a.shopNo = b.no WHERE a.userId = ? AND itemGroup LIKE '%씨앗주머니%' AND itemName NOT LIKE '%.%' group by shopNo;";
      try {
         conn = dbutil.getConnection();
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, id);
         rs = stmt.executeQuery();
         while (rs.next()) {
            by = rs.getBytes("itemImage");
            img.add(by);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbutil.close(rs);
         dbutil.close(stmt);
         dbutil.close(conn);
      }
      return img;
   }

   public List<Integer> itemNo(String id) {
      List<Integer> list = new ArrayList<>();
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      String sql = "SELECT b.no FROM inventory as a INNER JOIN shop AS b ON a.shopNo = b.no WHERE a.userId = ? AND itemGroup LIKE '%씨앗주머니%' AND itemName NOT LIKE '%.%' group by shopNo;";
      try {
         conn = dbutil.getConnection();
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, id);
         rs = stmt.executeQuery();
         while (rs.next()) {
            int shopNo = rs.getInt("b.no");
            list.add(shopNo);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbutil.close(rs);
         dbutil.close(stmt);
         dbutil.close(conn);
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
         conn = dbutil.getConnection();
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
         dbutil.close(rs);
         dbutil.close(stmt);
         dbutil.close(conn);
      }
      return list;
   }

   public int setplant(String id, String set) {
      Connection conn = null;
      PreparedStatement stmt = null;
      String sql = "UPDATE playlog SET harvesting = 1 where logId = ? and seat = ?;";
      try {
         conn = dbutil.getConnection();
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, id);
         stmt.setString(2, set);
         return stmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbutil.close(stmt);
         dbutil.close(conn);
      }
      return -1;
   }

   public int updateInven(String id, int set) {
      Connection conn = null;
      PreparedStatement stmt = null;
      String sql = "INSERT INTO inventory (userId, shopNo) VALUES (?, ?);";
      try {
         conn = dbutil.getConnection();
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, id);
         stmt.setInt(2, set);
         return stmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbutil.close(stmt);
         dbutil.close(conn);
      }
      return -1;
   }

   private int ck(List<String> a, String num) {
      String fun = "음지";
      int nut = 0;
      String nt = num.substring(5);
      int nst = Integer.valueOf(nt);
      if (nst < 13) {
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

   public String itemplus1(String id, String set) {
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      String plantName = null;
      String sql = "SELECT plantName FROM playlog as a INNER join plant as b ON a.logNo = b.plantNo where a.logId = ? and a.seat = ? and harvesting = 0;";
      try {
         conn = dbutil.getConnection();
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, id);
         stmt.setString(2, set);
         rs = stmt.executeQuery();
         if (rs.next()) {
            plantName = rs.getString("plantName");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbutil.close(rs);
         dbutil.close(stmt);
         dbutil.close(conn);
      }
      return plantName;
   }

   public int delectIv(String id, int c) {
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      String sql = "DELETE FROM inventory WHERE userId = ? and shopNo = ?;";
      try {
         conn = dbutil.getConnection();
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, id);
         stmt.setInt(2, c);
         return stmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbutil.close(rs);
         dbutil.close(stmt);
         dbutil.close(conn);
      }
      return -1;
   }

   public int shopNo(String plantname) {
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      String sql = "SELECT no FROM shop where itemName = ?;";
      try {
         conn = dbutil.getConnection();
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, plantname + ".");
         rs = stmt.executeQuery();
         if (rs.next()) {
            return rs.getInt("no");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbutil.close(rs);
         dbutil.close(stmt);
         dbutil.close(conn);
      }
      return 0;
   }

   private void test() {
      
   }
}