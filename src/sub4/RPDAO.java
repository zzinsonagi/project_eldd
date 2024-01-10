package sub4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBmanager;

public class RPDAO {
	
	//위시리스트 랭크 1위 출력 ♥♥♥♥♥完♥♥♥♥♥
	public RPVO rankWishList1() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select eldd_foodCode, eldd_foodName, eldd_images, top_wishList "
				+ " from ( select a.eldd_foodCode, b.eldd_foodName, b.eldd_images, sum(a.eldd_wishlist) as top_wishList "
				+	 "    from eldd_log a, eldd_food b "
				+	 "    where a.eldd_foodcode = b.eldd_foodcode "
				+    "    group by a.eldd_foodCode, b.eldd_foodName, b.eldd_images "
				+ 	 "    order by top_wishList desc "
				+	 "    ) "
				+ " where rownum = 1 ";
		
		RPVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodCode(rs.getInt("eldd_foodCode"));
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setEldd_images(rs.getString("eldd_images"));
				vo.setTop_wishList(rs.getInt("top_wishList"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return vo;
		
	} //rankWishLis1() end
	
	
	//좋아요별 랭크 1위 출력 ♥♥♥♥♥完♥♥♥♥♥
	public RPVO rankLike1() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select eldd_foodCode, eldd_foodName, eldd_images, top_like "
				+ " from ( select a.eldd_foodCode, b.eldd_foodName, b.eldd_images, sum(a.eldd_wishlist) as top_like "
				+	 "    from eldd_log a, eldd_food b "
				+	 "    where a.eldd_foodcode = b.eldd_foodcode "
				+    "    group by a.eldd_foodCode, b.eldd_foodName, b.eldd_images "
				+ 	 "    order by top_like desc "
				+	 "    ) "
				+ " where rownum = 1 ";
		
		RPVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodCode(rs.getInt("eldd_foodCode"));
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setEldd_images(rs.getString("eldd_images"));
				vo.setTop_like(rs.getInt("top_like"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return vo;
	}//rankLike()1 end
	
	
	//성별별 랭크 1위(여자편) 좋아요 기준 ♥♥♥♥♥完♥♥♥♥♥
	public RPVO rankGender1F() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from ( "
				+ " select a.eldd_foodCode, c.eldd_foodName, c.eldd_images, count(a.eldd_like) "
				+ " from eldd_log a, eldd_member b, eldd_food c "
				+ " where a.eldd_id = b.eldd_id and a.eldd_foodCode = c.eldd_foodCode and b.eldd_gender = 'F' "
				+ " group by a.eldd_foodCode, c.eldd_foodName, c.eldd_images "
				+ " order by count(a.eldd_like) desc "
				+ " ) where rownum = 1 ";

		RPVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setEldd_foodCode(rs.getInt("eldd_foodCode"));
				vo.setEldd_images(rs.getString("eldd_images"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return vo;
	}//rankGender() end
	
	
	//성별별 랭크 1위(남자편) 좋아요 기준 ♥♥♥♥♥完♥♥♥♥♥
	public RPVO rankGender1M() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from ( "
				+ " select a.eldd_foodCode, c.eldd_foodName, c.eldd_images, count(a.eldd_like) "
				+ " from eldd_log a, eldd_member b, eldd_food c "
				+ " where a.eldd_id = b.eldd_id and a.eldd_foodCode = c.eldd_foodCode and b.eldd_gender = 'M' "
				+ " group by a.eldd_foodCode, c.eldd_foodName, c.eldd_images "
				+ " order by count(a.eldd_like) desc "
				+ " ) where rownum = 1 ";

		RPVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setEldd_foodCode(rs.getInt("eldd_foodCode"));
				vo.setEldd_images(rs.getString("eldd_images"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return vo;
	}//rankGender() end
	
	
	//국가별 랭킹 1개씩(맨 위에 출력될 것) 한식
	public RPVO rankCountryHansik() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from ( "
					+ " select a.eldd_foodCode, a.eldd_foodName, a.eldd_images, count(b.eldd_like) "
					+ " from eldd_food a, eldd_log b "
					+ " where a.eldd_foodCode = b.eldd_foodCode and a.eldd_country = '한식' "
					+ " group by a.eldd_foodCode, a.eldd_foodName, a.eldd_images "
					+ " order by count(b.eldd_like) desc "
					+ " ) where rownum = 1 ";
		
		RPVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodCode(rs.getInt("eldd_foodCode"));
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setEldd_images(rs.getString("eldd_images"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return vo;
	}
	
	
	//국가별 랭킹 1개씩(맨 위에 출력될 것)
	public RPVO rankCountryJungsik() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from ( "
					+ " select a.eldd_foodCode, a.eldd_foodName, a.eldd_images, count(b.eldd_like) "
					+ " from eldd_food a, eldd_log b "
					+ " where a.eldd_foodCode = b.eldd_foodCode and a.eldd_country = '중식' "
					+ " group by a.eldd_foodCode, a.eldd_foodName, a.eldd_images "
					+ " order by count(b.eldd_like) desc "
					+ " ) where rownum = 1 ";
		
		RPVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodCode(rs.getInt("eldd_foodCode"));
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setEldd_images(rs.getString("eldd_images"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return vo;
	}
	
	
	//국가별 랭킹 1개씩(맨 위에 출력될 것)
	public RPVO rankCountryIlsik() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from ( "
					+ " select a.eldd_foodCode, a.eldd_foodName, a.eldd_images, count(b.eldd_like) "
					+ " from eldd_food a, eldd_log b "
					+ " where a.eldd_foodCode = b.eldd_foodCode and a.eldd_country = '일식' "
					+ " group by a.eldd_foodCode, a.eldd_foodName, a.eldd_images "
					+ " order by count(b.eldd_like) desc "
					+ " ) where rownum = 1 ";
		
		RPVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodCode(rs.getInt("eldd_foodCode"));
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setEldd_images(rs.getString("eldd_images"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return vo;
	}
	
	
	//국가별 랭킹 1개씩(맨 위에 출력될 것)
	public RPVO rankCountryYangsik() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from ( "
					+ " select a.eldd_foodCode, a.eldd_foodName, a.eldd_images, count(b.eldd_like) "
					+ " from eldd_food a, eldd_log b "
					+ " where a.eldd_foodCode = b.eldd_foodCode and a.eldd_country = '양식' "
					+ " group by a.eldd_foodCode, a.eldd_foodName, a.eldd_images "
					+ " order by count(b.eldd_like) desc "
					+ " ) where rownum = 1 ";
		
		RPVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodCode(rs.getInt("eldd_foodCode"));
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setEldd_images(rs.getString("eldd_images"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return vo;
	}
	
	
	//국가별 랭킹 1개씩(맨 위에 출력될 것)
	public RPVO rankCountryAsiansik() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from ( "
					+ " select a.eldd_foodCode, a.eldd_foodName, a.eldd_images, count(b.eldd_like) "
					+ " from eldd_food a, eldd_log b "
					+ " where a.eldd_foodCode = b.eldd_foodCode and a.eldd_country = '아시안식' "
					+ " group by a.eldd_foodCode, a.eldd_foodName, a.eldd_images "
					+ " order by count(b.eldd_like) desc "
					+ " ) where rownum = 1 ";
		
		RPVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodCode(rs.getInt("eldd_foodCode"));
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setEldd_images(rs.getString("eldd_images"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return vo;
	}
	
	
	//국가별 랭킹 1개씩(맨 위에 출력될 것)
	public RPVO rankCountryGita() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from ( "
					+ " select a.eldd_foodCode, a.eldd_foodName, a.eldd_images, count(b.eldd_like) "
					+ " from eldd_food a, eldd_log b "
					+ " where a.eldd_foodCode = b.eldd_foodCode and a.eldd_country = '기타' "
					+ " group by a.eldd_foodCode, a.eldd_foodName, a.eldd_images "
					+ " order by count(b.eldd_like) desc "
					+ " ) where rownum = 1 ";
		
		RPVO vo = null;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodCode(rs.getInt("eldd_foodCode"));
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setEldd_images(rs.getString("eldd_images"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return vo;
	}
	
	//위시리스트별 랭크 출력 5개까지 ♥♥♥♥♥完♥♥♥♥♥
		public List<RPVO> rankWishList() {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = " select eldd_foodCode, eldd_foodName, eldd_images, top_wishList "
					+ " from ( select a.eldd_foodCode, b.eldd_foodName, b.eldd_images, sum(a.eldd_wishlist) as top_wishList "
					+	 "    from eldd_log a, eldd_food b "
					+	 "    where a.eldd_foodcode = b.eldd_foodcode "
					+    "    group by a.eldd_foodCode, b.eldd_foodName, b.eldd_images "
					+ 	 "    order by top_wishList desc "
					+	 "    ) "
					+ " where rownum <= 5 ";
			
			RPVO vo = null;
			List<RPVO> list = new ArrayList<RPVO>();
			
			try {
				
				conn = DBmanager.getIns().getConn();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					vo = new RPVO();
					vo.setEldd_foodCode(rs.getInt("eldd_foodCode"));
					vo.setEldd_foodName(rs.getString("eldd_foodName"));
					vo.setEldd_images(rs.getString("eldd_images"));
					vo.setTop_wishList(rs.getInt("top_wishList"));
					list.add(vo);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBmanager.getIns().close(conn, pstmt, rs);
			}
			return list;
		}//rankWishList() end
	
		
	//좋아요별 랭크 출력 5개까지 ♥♥♥♥♥完♥♥♥♥♥
	public List<RPVO> rankLike() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select eldd_foodCode, eldd_foodName, eldd_images, top_like "
				+ " from ( select a.eldd_foodCode, b.eldd_foodName, b.eldd_images, sum(a.eldd_wishlist) as top_like "
				+	 "    from eldd_log a, eldd_food b "
				+	 "    where a.eldd_foodcode = b.eldd_foodcode "
				+    "    group by a.eldd_foodCode, b.eldd_foodName, b.eldd_images "
				+ 	 "    order by top_like desc "
				+	 "    ) "
				+ " where rownum <= 5 ";
		
		RPVO vo = null;
		List<RPVO> list = new ArrayList<RPVO>();
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodCode(rs.getInt("eldd_foodCode"));
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setEldd_images(rs.getString("eldd_images"));
				vo.setTop_like(rs.getInt("top_like"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return list;
	}//rankLike() end
	
	
	//성별별 랭크 출력 5개까지 (여자편) ♥♥♥♥♥完♥♥♥♥♥
	public List<RPVO> rankGenderF() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from ( "
				+ " select a.eldd_foodCode, c.eldd_foodName, c.eldd_images, count(a.eldd_like) "
				+ " from eldd_log a, eldd_member b, eldd_food c "
				+ " where a.eldd_id = b.eldd_id and a.eldd_foodCode = c.eldd_foodCode and b.eldd_gender = 'F' "
				+ " group by a.eldd_foodCode, c.eldd_foodName, c.eldd_images "
				+ " order by count(a.eldd_like) desc "
				+ " ) where rownum <= 5 ";

		RPVO vo = null;
		List<RPVO> list = new ArrayList<RPVO>();
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RPVO();
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
	}//rankGender()F end
	
	
	//성별별 랭크 출력 5개까지 (남자편) ♥♥♥♥♥完♥♥♥♥♥
	public List<RPVO> rankGenderM() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from ( "
				+ " select a.eldd_foodCode, c.eldd_foodName, c.eldd_images, count(a.eldd_like) "
				+ " from eldd_log a, eldd_member b, eldd_food c "
				+ " where a.eldd_id = b.eldd_id and a.eldd_foodCode = c.eldd_foodCode and b.eldd_gender = 'M' "
				+ " group by a.eldd_foodCode, c.eldd_foodName, c.eldd_images "
				+ " order by count(a.eldd_like) desc "
				+ " ) where rownum <= 5 ";

		RPVO vo = null;
		List<RPVO> list = new ArrayList<RPVO>();
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RPVO();
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
	}//rankGender()M end
	
	
	//국가별 랭킹 5개씩(페이지 들어가면 있는 것) ♥♥♥♥♥完♥♥♥♥♥
	public List<RPVO> rankCountry(String country) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from ( "
					+ " select a.eldd_foodCode, a.eldd_foodName, a.eldd_images, count(b.eldd_like) "
					+ " from eldd_food a, eldd_log b "
					+ " where a.eldd_foodCode = b.eldd_foodCode and a.eldd_country = '?' "
					+ " group by a.eldd_foodCode, a.eldd_foodName, a.eldd_images "
					+ " order by count(b.eldd_like) desc "
					+ " ) where rownum <= 5 ";
		
		RPVO vo = null;
		List<RPVO> list = new ArrayList<RPVO>();
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, country);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new RPVO();
				vo.setEldd_foodCode(rs.getInt("eldd_foodCode"));
				vo.setEldd_foodName(rs.getString("eldd_foodName"));
				vo.setEldd_images(rs.getString("eldd_images"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return list;
	}
	
	
		//랜덤 흩뿌리기 (5개로 한정) 슬라이드 용 ♥♥♥♥♥完♥♥♥♥♥
		public List<RPVO> randomView() {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = " select eldd_foodName, eldd_foodCode, eldd_images from eldd_food where eldd_foodCode in ( "
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
		}//randomView() end
		
		
		
		
//		//국가 장르별 랭크 1위
//		public RPVO rankCountry1(String country) {
//			
//			Connection conn = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			
//			int selCoun = 0;
//			if(country.equalsIgnoreCase("한식")) {
//				selCoun = 1;
//			} else if(country.equalsIgnoreCase("중식")) {
//				selCoun = 2;
//			} else if(country.equalsIgnoreCase("일식")) {
//				selCoun = 3;
//			} else if(country.equalsIgnoreCase("양식")) {
//				selCoun = 4;
//			} else if(country.equalsIgnoreCase("아시안")) {
//				selCoun = 5;
//			} else {
//				selCoun = 6;
//			}
//			
//			String sql = " select * from "
//							+ " (select eldd_foodName, count(eldd_foodName) as cntEF from eldd_food "
//							+ " where eldd_country = '?' "
//							+ " group by eldd_foodName "
//							+ " order by cntEF desc) "
//							+ " where rownum <= 1 ";
	//
//			RPVO vo = null;
//			
//			try {
//				
//				conn = DBmanager.getIns().getConn();
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setInt(1, selCoun);
//				rs = pstmt.executeQuery();
//				
//				while(rs.next()) {
//					vo = new RPVO();
//					vo.setEldd_foodName(rs.getString("eldd_foodName"));
//					vo.setCntEF(rs.getInt("cntEF"));
//				}
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				DBmanager.getIns().close(conn, pstmt, rs);
//			}
//			return vo;
//		}//rankCountry() end
		
		
//		//국가 장르별 랭크 출력 5개까지
//			public List<RPVO> rankCountry(String country) {
//				
//				Connection conn = null;
//				PreparedStatement pstmt = null;
//				ResultSet rs = null;
//				
//				int selCoun = 0;
//				if(country.equalsIgnoreCase("한식")) {
//					selCoun = 1;
//				} else if(country.equalsIgnoreCase("중식")) {
//					selCoun = 2;
//				} else if(country.equalsIgnoreCase("일식")) {
//					selCoun = 3;
//				} else if(country.equalsIgnoreCase("양식")) {
//					selCoun = 4;
//				} else if(country.equalsIgnoreCase("아시안")) {
//					selCoun = 5;
//				} else {
//					selCoun = 6;
//				}
//				
//				String sql = " select * from "
//								+ " (select eldd_foodName, count(eldd_foodName) as cntEF from eldd_food "
//								+ " where eldd_country = '?' "
//								+ " group by eldd_foodName "
//								+ " order by cntEF desc) "
//								+ " where rownum <= 5 ";
	//
//				RPVO vo = null;
//				List<RPVO> list = new ArrayList<RPVO>();
//				
//				try {
//					
//					conn = DBmanager.getIns().getConn();
//					pstmt = conn.prepareStatement(sql);
//					pstmt.setInt(1, selCoun);
//					rs = pstmt.executeQuery();
//					
//					while(rs.next()) {
//						vo = new RPVO();
//						vo.setEldd_foodName(rs.getString("eldd_foodName"));
//						vo.setCntEF(rs.getInt("cntEF"));
//						list.add(vo);
//					}
//					
//					//확인 출력용
//					for(RPVO rv : list) {
//						System.out.println(rv.getEldd_foodName()+" : "+rv.getCntEF());
//					}
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					DBmanager.getIns().close(conn, pstmt, rs);
//				}
//				return list;
//			}//rankCountry() end
}
