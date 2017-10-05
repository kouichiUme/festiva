package nagoya.code4.hojin;

import java.io.IOException;

import org.apache.http.ParseException;
import org.junit.Test;

public class HojinInfoRequestTest {

	@Test
	public void test() throws ParseException, IOException {
		
		
		
		
		String requestparam = "query=PREFIX+hj%3A+%3Chttp%3A%2F%2Fhojin-info.go.jp%2Fns%2Fdomain%2Fbiz%2F1%23%3E%0D%0APREFIX+ic%3A+%3Chttp%3A%2F%2Fimi.go.jp%2Fns%2Fcore%2Frdf%23%3E%0D%0ASELECT+DISTINCT+%3FcID+%28SAMPLE%28%3Fname%29+AS+%3Fname%29+%28SUM%28%3Fvalue%29+AS+%3Fsum%29%0D%0AFROM+%3Chttp%3A%2F%2Fhojin-info.go.jp%2Fgraph%2Fchotatsu%3E%0D%0AWHERE+%7B%0D%0A%3Fs+hj%3A%E6%B3%95%E4%BA%BA%E6%B4%BB%E5%8B%95%E6%83%85%E5%A0%B1+%3Fo+.%0D%0A%3Fo+ic%3AID%2Fic%3A%E8%AD%98%E5%88%A5%E5%80%A4+%3FcID+.%0D%0A%3Fo+ic%3A%E5%90%8D%E7%A7%B0%2Fic%3A%E8%A1%A8%E8%A8%98+%3Fname+.%0D%0A%3Fo+ic%3A%E9%87%91%E9%A1%8D%2Fic%3A%E6%95%B0%E5%80%A4+%3Fvalue+.%0D%0A%7D%0D%0AGROUP+BY+%3FcID%0D%0AORDER+BY+DESC%28%3Fsum%29&format%3Dapplication%2Fsparql-results%2Bjson&timeout=0";
		
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(HojinInfoRequest.url+'?'+requestparam);
		
		
		String text = HojinInfoHttpAccess.sendString("", requestparam);
		
		System.out.println(text);
	}

}
