package nagoya.code4;

import java.util.List;

public class ResasChanges {
	
	private String prefCode;
	
	public String getPrefCode() {
		return prefCode;
	}

	public void setPrefCode(String prefCode) {
		this.prefCode = prefCode;
	}

	public String getPrefName() {
		return prefName;
	}

	public void setPrefName(String prefName) {
		this.prefName = prefName;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public List<ResasData> getData() {
		return data;
	}

	public void setData(List<ResasData> data) {
		this.data = data;
	}

	private String prefName;
	
	private String rank;
	
	private List<ResasData> data; 

}
