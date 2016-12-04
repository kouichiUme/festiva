package nagoya.code4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.ParseException;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResasHttpAccessTest {

	@Test
	public void testSendString() throws ParseException, IOException {
		
		String result = ResasHttpAccess.sendString("ttes");
	
		ObjectMapper om = new ObjectMapper();
		
		ResasResult resultData= om.readValue(result,ResasResult.class);
		
		System.out.println(resultData);
		
		List<ResasResult> hogeList = new ArrayList<ResasResult>();
		
		hogeList.add(resultData);
		hogeList.add(resultData);
		hogeList.add(resultData);
		
		
		
		
		
	}

}
