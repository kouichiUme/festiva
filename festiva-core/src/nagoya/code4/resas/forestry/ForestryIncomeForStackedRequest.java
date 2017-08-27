package nagoya.code4.resas.forestry;

public class ForestryIncomeForStackedRequest {
	
	public static final String url ="/forestry/income/forStacked";

	
	private String cityCode;
	
	private String prefCode;

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getPrefCode() {
		return prefCode;
	}

	public void setPrefCode(String prefCode) {
		this.prefCode = prefCode;
	}
	
}
