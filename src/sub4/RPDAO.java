package sub4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBmanager;

public class RPDAO {
	
	//좋아요별 랭크 1위 출력
	public RPVO rankLike1() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from( "
				+ " select eldd_foodName, count(eldd_like) as cntL from eldd_food "
				+ " group by eldd_foodName "
				+ " order by cntL desc) "
				+ " where rownum <= 1 ";
		
		RPVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setCntL(rs.getInt("cntL"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return vo;
	}//rankLike()1 end
	
	
	//성별별 랭크 1위(여자편)
	public RPVO rankGender1F() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from (select f.eldd_foodName, count(f.eldd_foodCode) as cntFC "
					+ " from eldd_food f, eldd_member m "
					+ " where f.eldd_id = m.eldd_id and m.eldd_gender = '2' "
					+ " group by f.eldd_foodName "
					+ " order by cnt desc) "
					+ " where rownum <= 1 ";

		RPVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setCntFC(rs.getInt("cntFC"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return vo;
	}//rankGender() end
	
	
	//성별별 랭크 1위(남자편)
	public RPVO rankGender1M() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from (select f.eldd_foodName, count(f.eldd_foodCode) as cntFC "
					+ " from eldd_food f, eldd_member m "
					+ " where f.eldd_id = m.eldd_id and m.eldd_gender = '1' "
					+ " group by f.eldd_foodName "
					+ " order by cnt desc) "
					+ " where rownum <= 1 ";

		RPVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setCntFC(rs.getInt("cntFC"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return vo;
	}//rankGender() end
	
	
	//국가 장르별 랭크 1위
	public RPVO rankCountry1(String country) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int selCoun = 0;
		if(country.equalsIgnoreCase("한식")) {
			selCoun = 1;
		} else if(country.equalsIgnoreCase("중식")) {
			selCoun = 2;
		} else if(country.equalsIgnoreCase("일식")) {
			selCoun = 3;
		} else if(country.equalsIgnoreCase("양식")) {
			selCoun = 4;
		} else if(country.equalsIgnoreCase("아시안")) {
			selCoun = 5;
		} else {
			selCoun = 6;
		}
		
		String sql = " select * from "
						+ " (select eldd_foodName, count(eldd_foodName) as cntEF from eldd_food "
						+ " where eldd_country = '?' "
						+ " group by eldd_foodName "
						+ " order by cntEF desc) "
						+ " where rownum <= 1 ";

		RPVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, selCoun);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setCntEF(rs.getInt("cntEF"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return vo;
	}//rankCountry() end
	
	
	//좋아요별 랭크 출력 5개까지
	public List<RPVO> rankLike() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from( "
				+ " select eldd_foodName, count(eldd_like) as cntL from eldd_food "
				+ " group by eldd_foodName "
				+ " order by cntL desc) "
				+ " where rownum <= 5 ";
		
		RPVO vo = null;
		List<RPVO> list = new ArrayList<RPVO>();
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setCntL(rs.getInt("cntL"));
				list.add(vo);
			}
			
			//확인 출력용
			for(RPVO rv : list) {
				System.out.println(rv.getEldd_foodName()+" : "+rv.getCntL());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return list;
	}//rankLike() end
	
	
	//성별별 랭크 출력 5개까지 (여자편)
	public List<RPVO> rankGenderF() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from (select f.eldd_foodName, count(f.eldd_foodCode) as cntFC "
					+ " from eldd_food f, eldd_member m "
					+ " where f.eldd_id = m.eldd_id and m.eldd_gender = '2' "
					+ " group by f.eldd_foodName "
					+ " order by cnt desc) "
					+ " where rownum <= 5 ";

		RPVO vo = null;
		List<RPVO> list = new ArrayList<RPVO>();
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setCntFC(rs.getInt("cntFC"));
				list.add(vo);
			}
			
			//확인 출력용
			for(RPVO rv : list) {
				System.out.println(rv.getEldd_foodName()+" : "+rv.getCntFC());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return list;
	}//rankGender()F end
	
	
	//성별별 랭크 출력 5개까지 (남자편)
	public List<RPVO> rankGenderM() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from (select f.eldd_foodName, count(f.eldd_foodCode) as cntFC "
					+ " from eldd_food f, eldd_member m "
					+ " where f.eldd_id = m.eldd_id and m.eldd_gender = '1' "
					+ " group by f.eldd_foodName "
					+ " order by cnt desc) "
					+ " where rownum <= 5 ";

		RPVO vo = null;
		List<RPVO> list = new ArrayList<RPVO>();
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setCntFC(rs.getInt("cntFC"));
				list.add(vo);
			}
			
			//확인 출력용
			for(RPVO rv : list) {
				System.out.println(rv.getEldd_foodName()+" : "+rv.getCntFC());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return list;
	}//rankGender()M end
	
	
	//국가 장르별 랭크 출력 5개까지
		public List<RPVO> rankCountry(String country) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int selCoun = 0;
			if(country.equalsIgnoreCase("한식")) {
				selCoun = 1;
			} else if(country.equalsIgnoreCase("중식")) {
				selCoun = 2;
			} else if(country.equalsIgnoreCase("일식")) {
				selCoun = 3;
			} else if(country.equalsIgnoreCase("양식")) {
				selCoun = 4;
			} else if(country.equalsIgnoreCase("아시안")) {
				selCoun = 5;
			} else {
				selCoun = 6;
			}
			
			String sql = " select * from "
							+ " (select eldd_foodName, count(eldd_foodName) as cntEF from eldd_food "
							+ " where eldd_country = '?' "
							+ " group by eldd_foodName "
							+ " order by cntEF desc) "
							+ " where rownum <= 5 ";

			RPVO vo = null;
			List<RPVO> list = new ArrayList<RPVO>();
			
			try {
				
				conn = DBmanager.getIns().getConn();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, selCoun);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					vo = new RPVO();
					vo.setEldd_foodName(rs.getString("eldd_foodName"));
					vo.setCntEF(rs.getInt("cntEF"));
					list.add(vo);
				}
				
				//확인 출력용
				for(RPVO rv : list) {
					System.out.println(rv.getEldd_foodName()+" : "+rv.getCntEF());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBmanager.getIns().close(conn, pstmt, rs);
			}
			return list;
		}//rankCountry() end
	
		
		//랜덤 흩뿌리기 (5개로 한정) 슬라이드 용
		public List<RPVO> randomView() {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = " select eldd_foodName, eldd_foodCode from eldd_food where eldd_foodCode in ( "
						+ " SELECT DISTINCT ROUND(DBMS_RANDOM.VALUE() * 10)+1 "
						+ " FROM dual "
						+ " CONNECT BY LEVEL <= 50 "
						+ " ) and rownum <= 5 ";
			
			List<RPVO> list = new ArrayList<RPVO>();
			RPVO vo = null;
			
			try {
				
				conn = DBmanager.getIns().getConn();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					vo = new RPVO();
					vo.setEldd_foodName(rs.getString("eldd_foodName"));
					list.add(vo);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBmanager.getIns().close(conn, pstmt, rs);
			}
			return list;
		}//randomView() end
}
