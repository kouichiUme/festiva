package nagoya.code4.resas.forestry;

import java.util.List;

public class ForestryIncomeForStacked {
	
	private String prefCode;
	
	private String prefName;
	
	private String cityCode;
	
	private String cityName;
	
	private String label;
	
	private List<ForestryIncomeForStackedResultData> years;

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

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<ForestryIncomeForStackedResultData> getYears() {
		return years;
	}

	public void setYears(List<ForestryIncomeForStackedResultData> years) {
		this.years = years;
	}
	
}
