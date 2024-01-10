package dao.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBmanager;

public class noticeDao {
	
	public void noticeInsert(noticeVo vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = " insert into notice (idx, title, content, writer, wdate, viewcount) "
	            + " values (notice_seq.nextval, ?, ?, ?, sysdate, 0)";
	      
	      try {
	         
	         conn = DBmanager.getinstance().getConnection();
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, vo.getTitle());
	         pstmt.setString(2, vo.getContent());
	         pstmt.setString(3, vo.getWriter());
	         
	         pstmt.executeUpdate();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBmanager.getinstance().close(conn, pstmt);
	      }
	     
	}
	
	public List<noticeVo> getNotice() {

	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      String sql = "select * from notice order by idx desc";
	      
	      List<noticeVo> list = new ArrayList<noticeVo>();
	      noticeVo vo = null;
	      
	      try {
	         
	         conn = DBmanager.getinstance().getConnection();
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            vo = new noticeVo();
	            vo.setIdx(rs.getInt("idx"));
	            vo.setTitle(rs.getString("title"));
	            vo.setContent(rs.getString("content"));
	            vo.setWdate(rs.getString("wdate").toString().substring(0,10));
	            vo.setWriter(rs.getString("writer"));
	            vo.setViewcount(rs.getInt("viewcount"));
	            list.add(vo);
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         
	         DBmanager.getinstance().close(conn, pstmt,rs);
	         
	      }
	      return list;
	   }
	
	public int getNoticeCount() {
		
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	      
	      String sql = "select count(*) as total from notice";
	      int total = 0;
	      try {
	         
	         conn = DBmanager.getinstance().getConnection();
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	        	total = rs.getInt("total");
	            return total;
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         
	         DBmanager.getinstance().close(conn, pstmt,rs);
	         
	      }
		return total;
		
	}
	
	public noticeVo getIdxView(int idx) {
		
		setNoticeViewCount(idx);
		
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	      
	      String sql = "select * from notice where idx = ?";
	      
	      noticeVo vo = null;
	      
	      try {
	         
	         conn = DBmanager.getinstance().getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, idx);
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	        	 vo = new noticeVo();
		         vo.setIdx(rs.getInt("idx"));
		         vo.setTitle(rs.getString("title"));
		         vo.setContent(rs.getString("content"));
		         vo.setWdate(rs.getString("wdate").toString().substring(0,10));
		         vo.setWriter(rs.getString("writer"));
		         vo.setViewcount(rs.getInt("viewcount"));
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         
	         DBmanager.getinstance().close(conn, pstmt,rs);
	         
	      }
		return vo;
		
	}
	
	public void getNoticeDeleteIdx(int idx) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		String sql = "delete notice where idx = ?";
		
		try {
			
			conn = DBmanager.getinstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getinstance().close(conn, pstmt);
		}
		
	}
	
	public void setNoticeUpdate(noticeVo vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update notice set title=?, content=?, wdate=sysdate where idx = ?";
		
		try {
			
			conn = DBmanager.getinstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getIdx());
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBmanager.getinstance().close(conn, pstmt);
		}
		
	}
	
	public void setNoticeViewCount(int idx) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update notice set viewcount = viewcount + 1 where idx = ?";
		
		try {
			
			noticeVo vo = new noticeVo();
			
			conn = DBmanager.getinstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBmanager.getinstance().close(conn, pstmt);
		}
		
	}
	
}
