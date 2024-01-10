package sub1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBmanager;

public class ARPDAO {
	
	public List<ARPVO> ARPselectPrint() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select eldd_foodName, eldd_foodCode, eldd_images from eldd_food where eldd_foodCode in ( "
					+ " SELECT DISTINCT ROUND(DBMS_RANDOM.VALUE() * 10)+1 "
					+ " FROM dual "
					+ " CONNECT BY LEVEL <= 50 "
					+ " ) and rownum <= 10 ";
		
		List<ARPVO> list = new ArrayList<ARPVO>();
		ARPVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new ARPVO();
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setEldd_foodCode(rs.getInt("eldd_foodCode"));
				vo.setEldd_images(rs.getString("eldd_images"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return list;
	}//sub1 end
	
	
}
