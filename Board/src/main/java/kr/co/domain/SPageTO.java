package kr.co.domain;

public class SPageTO<T> extends PageTO<T>{
	private String select;
	private String keyword;
	
	public SPageTO() {
		// TODO Auto-generated constructor stub
	}

	public SPageTO(int curPage, String select, String keyword) {
		super(curPage);
		this.select = select;
		this.keyword = keyword;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}	
}
