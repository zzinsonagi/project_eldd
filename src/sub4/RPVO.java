package sub4;

public class RPVO {
	//eldd_member
	private String eldd_id;
	private String eldd_pw;
	private String eldd_name;
	private char eldd_gender;
	private int eldd_birth;
	
	//eldd_div
	private String eldd_country;
	private String eldd_ingredient;
	private String eldd_season;
	
	//eldd_food
	private String eldd_foodName;
	private int eldd_foodCode;
	private char eldd_wishList;
	private char eldd_like;
	
	//eldd_search
	private String eldd_searchT;
	
	//join - 성별
	private int cntFC;
	
	//join - 국가별
	private int cntEF;
	
	//rank - 좋아요별
	private int cntL;

	public String getEldd_id() {
		return eldd_id;
	}

	public void setEldd_id(String eldd_id) {
		this.eldd_id = eldd_id;
	}

	public String getEldd_pw() {
		return eldd_pw;
	}

	public void setEldd_pw(String eldd_pw) {
		this.eldd_pw = eldd_pw;
	}

	public String getEldd_name() {
		return eldd_name;
	}

	public void setEldd_name(String eldd_name) {
		this.eldd_name = eldd_name;
	}

	public char getEldd_gender() {
		return eldd_gender;
	}

	public void setEldd_gender(char eldd_gender) {
		this.eldd_gender = eldd_gender;
	}

	public int getEldd_birth() {
		return eldd_birth;
	}

	public void setEldd_birth(int eldd_birth) {
		this.eldd_birth = eldd_birth;
	}

	public String getEldd_country() {
		return eldd_country;
	}

	public void setEldd_country(String eldd_country) {
		this.eldd_country = eldd_country;
	}

	public String getEldd_ingredient() {
		return eldd_ingredient;
	}

	public void setEldd_ingredient(String eldd_ingredient) {
		this.eldd_ingredient = eldd_ingredient;
	}

	public String getEldd_season() {
		return eldd_season;
	}

	public void setEldd_season(String eldd_season) {
		this.eldd_season = eldd_season;
	}

	public String getEldd_foodName() {
		return eldd_foodName;
	}

	public void setEldd_foodName(String eldd_foodName) {
		this.eldd_foodName = eldd_foodName;
	}

	public int getEldd_foodCode() {
		return eldd_foodCode;
	}

	public void setEldd_foodCode(int eldd_foodCode) {
		this.eldd_foodCode = eldd_foodCode;
	}

	public char getEldd_wishList() {
		return eldd_wishList;
	}

	public void setEldd_wishList(char eldd_wishList) {
		this.eldd_wishList = eldd_wishList;
	}

	public char getEldd_like() {
		return eldd_like;
	}

	public void setEldd_like(char eldd_like) {
		this.eldd_like = eldd_like;
	}

	public String getEldd_searchT() {
		return eldd_searchT;
	}

	public void setEldd_searchT(String eldd_searchT) {
		this.eldd_searchT = eldd_searchT;
	}

	public int getCntFC() {
		return cntFC;
	}

	public void setCntFC(int cntFC) {
		this.cntFC = cntFC;
	}

	public int getCntEF() {
		return cntEF;
	}

	public void setCntEF(int cntEF) {
		this.cntEF = cntEF;
	}

	public int getCntL() {
		return cntL;
	}

	public void setCntL(int cntL) {
		this.cntL = cntL;
	}
	
	
	
}
