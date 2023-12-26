package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBmanager;

public class MainDAO {
	
public MainVO random1() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select eldd_foodName, eldd_foodCode from eldd_food where eldd_foodCode in ( "
					+ " SELECT DISTINCT ROUND(DBMS_RANDOM.VALUE() * 10)+1 "
					+ " FROM dual "
					+ " CONNECT BY LEVEL <= 50 "
					+ " ) and rownum <= 1 ";
		
		MainVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new MainVO();
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return vo;
	}//sub1 end

}
