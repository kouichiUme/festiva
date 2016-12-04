package nagoya.code4;

public class ResasResult {
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResasGaikokujinResult getResult() {
		return result;
	}

	public void setResult(ResasGaikokujinResult result) {
		this.result = result;
	}

	private String message;
	
	private ResasGaikokujinResult result;
	

}
