package nagoya.code4.resas.agriculture;

public enum AgricultureLandAbandonmentMatterEnum {
	DesignatedLocation("1"),
	inDesignedPrefecture("2"),
	JapanAverage("3");
	
	private String  value ;
	
	AgricultureLandAbandonmentMatterEnum(String v){
		this.value = v;
	}
	
	public String getValue(){
		return value;
	}

}
