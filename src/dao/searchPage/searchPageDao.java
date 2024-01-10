package dao.searchPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBmanager;
import utility.Criteria;

public class searchPageDao {
	
	// 페이징 + 검색
	public List<searchPageVo> selectSearchPage(String foodname, Criteria cri){
		
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<searchPageVo> list = new ArrayList<searchPageVo>();
		
		String sql = "SELECT * FROM ("
		           + "SELECT /*+ index_desc(eldd_food food_pk) */ "
		           + "rownum rn, eldd_foodname, eldd_foodcode, eldd_country, eldd_ingredient, "
		           + "eldd_season, eldd_images FROM eldd_food WHERE eldd_foodname like '%"+foodname+"%' "
		           + "AND rownum <= ? * ?"
		           + ") WHERE rn > (? - 1) * ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				searchPageVo vo = new searchPageVo();
				vo.setEldd_foodname(rs.getString("eldd_foodname"));
				vo.setEldd_foodcode(rs.getInt("eldd_foodcode"));
				vo.setEldd_country(rs.getString("eldd_country"));
				vo.setEldd_ingredient(rs.getString("eldd_ingredient"));
				vo.setEldd_season(rs.getString("eldd_season"));
				vo.setEldd_images(rs.getString("eldd_images"));
				
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		
		return list;
	}//selectSearchPage()
	
	public int getNoticeCount() {
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) as total from eldd_food";
		
		int total=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				total=rs.getInt("total");
				return total;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		
		return total;
	}//getNoticeCount()
	
	public int getNoticeCountSearched(String foodname) {
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) as total from eldd_food where eldd_foodname like '%"+foodname+"%'";
		
		int total=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				total=rs.getInt("total");
				return total;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		
		return total;
	}//getNoticeCountSearched()
}
