package searchCategoryPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBmanager;
import utility.Criteria;

public class SearchCategoryPageDao {
	
	public List<SearchCategoryPageVo> getCategoryCountry(){
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from eldd_div_country";
		
		List<SearchCategoryPageVo> list = new ArrayList<SearchCategoryPageVo>();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				SearchCategoryPageVo vo = new SearchCategoryPageVo();
				vo.setEldd_country(rs.getString("eldd_country"));
				
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return list;
	}//getCategoryCountry() - 버튼 구현용
	
	public List<SearchCategoryPageVo> getCategoryIngredient(){
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from eldd_div_ingredient";
		
		List<SearchCategoryPageVo> list = new ArrayList<SearchCategoryPageVo>();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				SearchCategoryPageVo vo = new SearchCategoryPageVo();
				vo.setEldd_ingredient(rs.getString("eldd_ingredient"));
				
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return list;
	}//getCategoryIngredient() - 버튼 구현용
	
	public List<SearchCategoryPageVo> getCategorySeason(){
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from eldd_div_season";
		
		List<SearchCategoryPageVo> list = new ArrayList<SearchCategoryPageVo>();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				SearchCategoryPageVo vo = new SearchCategoryPageVo();
				vo.setEldd_season(rs.getString("eldd_season"));
				
				list.add(vo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return list;
	}//getCategorySeason() - 버튼 구현용
	
	public List<SearchCategoryPageVo> selectedCategory(String country, Criteria cri){
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM (SELECT /*+ index_desc(eldd_food food_pk) */ " + 
				"rownum rn, eldd_foodname, eldd_foodcode, eldd_country, eldd_ingredient, " + 
				"eldd_season, eldd_images FROM eldd_food WHERE eldd_country like '%"+ country +"%' and rownum <= ? * ?) WHERE rn > (? - 1) * ?";
		
		List<SearchCategoryPageVo> list = new ArrayList<SearchCategoryPageVo>();

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SearchCategoryPageVo vo = new SearchCategoryPageVo();
				
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
	}//selectedCategory_country
	
	public List<SearchCategoryPageVo> selectedCategoryIngredient(String ingredient, Criteria cri){
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM (SELECT /*+ index_desc(eldd_food food_pk) */ " + 
				"rownum rn, eldd_foodname, eldd_foodcode, eldd_country, eldd_ingredient, " + 
				"eldd_season, eldd_images FROM eldd_food WHERE eldd_ingredient like '%"+ingredient+"%' and rownum <= ? * ?) WHERE rn > (? - 1) * ?";
		
		List<SearchCategoryPageVo> list = new ArrayList<SearchCategoryPageVo>();

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SearchCategoryPageVo vo = new SearchCategoryPageVo();
				
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
	}//selectedCategoryIngredient
	
	public List<SearchCategoryPageVo> selectedCategorySeason(String season, Criteria cri){
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM (SELECT /*+ index_desc(eldd_food food_pk) */ " + 
				"rownum rn, eldd_foodname, eldd_foodcode, eldd_country, eldd_ingredient, " + 
				"eldd_season, eldd_images FROM eldd_food WHERE eldd_season like '%"+season+"%' and rownum <= ? * ?) WHERE rn > (? - 1) * ?";
		
		List<SearchCategoryPageVo> list = new ArrayList<SearchCategoryPageVo>();

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SearchCategoryPageVo vo = new SearchCategoryPageVo();
				
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
	}//selectedCategorySeason
	
	public List<SearchCategoryPageVo> selectedCategory(String country, String ingredient, Criteria cri){
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM (SELECT /*+ index_desc(eldd_food food_pk) */ " + 
				"rownum rn, eldd_foodname, eldd_foodcode, eldd_country, eldd_ingredient, " + 
				"eldd_season, eldd_images FROM eldd_food WHERE eldd_country like '%"+country
				+"%' and eldd_ingredient like '%"+ingredient+"%' and rownum <= ? * ?) WHERE rn > (? - 1) * ?";
		
		List<SearchCategoryPageVo> list = new ArrayList<SearchCategoryPageVo>();

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SearchCategoryPageVo vo = new SearchCategoryPageVo();
				
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
	}//selectedCategory_country,ingredient
	
	public List<SearchCategoryPageVo> selectedCategoryInSe(String ingredient, String season, Criteria cri){
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM (SELECT /*+ index_desc(eldd_food food_pk) */ " + 
				"rownum rn, eldd_foodname, eldd_foodcode, eldd_country, eldd_ingredient, " + 
				"eldd_season, eldd_images FROM eldd_food WHERE eldd_ingredient like '%"+ingredient
				+"%' and eldd_season like '%"+season+"%' and rownum <= ? * ?) WHERE rn > (? - 1) * ?";
		
		List<SearchCategoryPageVo> list = new ArrayList<SearchCategoryPageVo>();

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SearchCategoryPageVo vo = new SearchCategoryPageVo();
				
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
	}//selectedCategory_country,season
	
	public List<SearchCategoryPageVo> selectedCategoryCoSe(String country, String season, Criteria cri){
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM (SELECT /*+ index_desc(eldd_food food_pk) */ " + 
				"rownum rn, eldd_foodname, eldd_foodcode, eldd_country, eldd_ingredient, " + 
				"eldd_season, eldd_images FROM eldd_food WHERE eldd_country like '%"+country
				+"%' and eldd_season like '%"+season+"%' and rownum <= ? * ?) WHERE rn > (? - 1) * ?";
		
		List<SearchCategoryPageVo> list = new ArrayList<SearchCategoryPageVo>();

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SearchCategoryPageVo vo = new SearchCategoryPageVo();
				
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
	}//selectedCategory_country,ingredient
	
	public List<SearchCategoryPageVo> selectedCategory(String country, String ingredient, String season, Criteria cri){
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM (SELECT /*+ index_desc(eldd_food food_pk) */ " + 
				"rownum rn, eldd_foodname, eldd_foodcode, eldd_country, eldd_ingredient, " + 
				"eldd_season, eldd_images FROM eldd_food WHERE eldd_country like '%"+country
				+"%' and eldd_ingredient like '%"+ingredient
				+"%' and eldd_season like '%"+season+"%' and rownum <= ? * ?) WHERE rn > (? - 1) * ?";
		
		List<SearchCategoryPageVo> list = new ArrayList<SearchCategoryPageVo>();

		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SearchCategoryPageVo vo = new SearchCategoryPageVo();
				
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
	}//selectedCategory_All
	
	public List<SearchCategoryPageVo> selectCategoryPage(Criteria cri) {
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<SearchCategoryPageVo> list = new ArrayList<SearchCategoryPageVo>();
		
		String sql = "SELECT * FROM (SELECT /*+ index_desc(eldd_food food_pk) */ " + 
				"rownum rn, eldd_foodname, eldd_foodcode, eldd_country, eldd_ingredient, " + 
				"eldd_season, eldd_images FROM eldd_food WHERE rownum <= ? * ?) WHERE rn > (? - 1) * ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SearchCategoryPageVo vo = new SearchCategoryPageVo();
				
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
	}
	
	public int getFoodCount() {
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
	}//getFoodCount()
	
	public int getFoodCountCountry(String country) {
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) as total from eldd_food where eldd_country=?";
		
		int total=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, country);
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
	}//getFoodCountCountry()
	
	public int getFoodCountIngredient(String ingredient) {
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) as total from eldd_food where eldd_ingredient=?";
		
		int total=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ingredient);
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
	}//getFoodCountIngredient()
	
	public int getFoodCountSeason(String season) {
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) as total from eldd_food where eldd_season=?";
		
		int total=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, season);
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
	}//getFoodCountSeason()
	
	public int getFoodCountCoIn(String country, String ingredient) {
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) as total from eldd_food where eldd_country like '%"+
		country+"%' and eldd_ingredient like '%"+ingredient+"%'";
		
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
	}//getFoodCountCoIn()
	
	public int getFoodCountCoSe(String country, String season) {
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) as total from eldd_food where eldd_country like '%"+country
				+"%' and eldd_season like '%"+season+"%'";
		
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
	}//getFoodCountCoSe()
	
	public int getFoodCountInSe(String ingredient, String season) {
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) as total from eldd_food where eldd_ingredient like '%"+ingredient
				+"%' and eldd_season like '%"+season+"%'";
		
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
	}//getFoodCountInSe()
	
	public int getFoodCountAll(String country, String ingredient, String season) {
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) as total from eldd_food where eldd_country like '%"+country
				+"%' and eldd_ingredient like '%"+ingredient
				+"%' and eldd_season like '%"+season+"%'";
		
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
	}//getFoodCountInSe()
}
