package src.plant;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.management.RuntimeErrorException;



public class HerbDAO {
   public HerbDAO() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
   }

  private Herb mapRow(ResultSet rs) throws SQLException {
	  
	  int plantNo = rs.getInt("plantNo");
	  String plantName = rs.getString("plantName");
	  String plantScientific = rs.getString("plantScientific");
	  String plantOrigin = rs.getString("plantOrigin");
	  String plantFamily = rs.getString("plantFamily");
	  boolean plantLuminous = rs.getBoolean("plantLuminous");
	  String plantWatering = rs.getString("plantWatering");
	  int plantPoint = rs.getInt("plantPoint");
     

     return new Herb(plantNo,plantName,plantScientific, plantOrigin,plantFamily,
 			plantLuminous, plantWatering, plantPoint);
  }
  
  
  private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
  
  
  public Herb getByNo(int plantNo) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/team3", "Team3", "team3");
			stmt = conn.prepareStatement("SELECT * FROM Herb WHERE plantNo = ?");
			stmt.setInt(1, plantNo);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return mapRow(rs);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		throw new NotFoundException(plantNo + "번 허브가 존재하지 않음.");
	}
  


  public List<Herb> getAll() throws SQLException {
    List<Herb> list = new ArrayList<Herb>();
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/team3", "Team3", "team3");
          Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM Herb")) {
        while (rs.next()) {
           Herb h = mapRow(rs);
           list.add(h);
        }
     }
      return list;
  }
  
  

}