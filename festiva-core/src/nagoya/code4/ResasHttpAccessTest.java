package nagoya.code4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.ParseException;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import nagoya.code4.resas.CitiesResult;
import nagoya.code4.resas.CityResult;
import nagoya.code4.resas.IndustriesBroadResult;
import nagoya.code4.resas.IndustriesMiddleResult;
import nagoya.code4.resas.IndustriesNarrowResult;
import nagoya.code4.resas.IndustryBroadResult;
import nagoya.code4.resas.IndustryMiddleResult;
import nagoya.code4.resas.IndustryNarrowResult;
import nagoya.code4.resas.PrefectureResult;
import nagoya.code4.resas.PrefecturesResult;
import nagoya.code4.resas.ResasPrefectureHttpAccess;
import nagoya.code4.resas.ResasUtil;

public class ResasHttpAccessTest {

	@Test
	public void testSendString() throws ParseException, IOException {

		String result = ResasHttpAccess.sendString("api/v1-rc.1/tourism/foreigners/forTo", "tes");

		ObjectMapper om = new ObjectMapper();

		ResasResult resultData = om.readValue(result, ResasResult.class);

		System.out.println(resultData);

		List<ResasResult> hogeList = new ArrayList<ResasResult>();

		hogeList.add(resultData);
		hogeList.add(resultData);
		hogeList.add(resultData);

		String message = resultData.getMessage();

		System.out.println(resultData.getResult().getPrefCode());

	}

	@Test
	public void testGetPrefectures() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper om = new ObjectMapper();

		String result = ResasPrefectureHttpAccess.sendString("ttes");

		PrefecturesResult resultData = om.readValue(result, PrefecturesResult.class);

		System.out.println(resultData);

		resultData.getMessage();

		List<PrefectureResult> prefs = resultData.getResult();

		for (PrefectureResult p : prefs) {

			System.out.println("name" + p.getPrefName());

			System.out.println("code" + p.getPrefCode());

		}

	}

	@Test
	public void testCities() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("prefCode");
		List<String> paramValues = new ArrayList<String>();

		paramValues.add("23");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);
		String result = ResasHttpAccess.sendString("api/v1/cities", params.toString());

		CitiesResult resultData = om.readValue(result, CitiesResult.class);

		System.out.println(resultData);

		resultData.getMessage();

		List<CityResult> cities = resultData.getResult();

		for (CityResult p : cities) {

			System.out.println("name" + p.getCityName());

			System.out.println("code" + p.getCityCode());

			System.out.println("BigCityFlag" + p.getBigCityFlag());

		}

	}

	@Test
	public void testIndustriesBoard() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		StringBuffer params = new StringBuffer();

		String result = ResasHttpAccess.sendString("api/v1/industries/broad", params.toString());

		IndustriesBroadResult resultData = om.readValue(result, IndustriesBroadResult.class);

		System.out.println(resultData);

		resultData.getMessage();

		List<IndustryBroadResult> industry = resultData.getResult();

		for (IndustryBroadResult p : industry) {

			System.out.println("code" + p.getSicCode());

			System.out.println("Name" + p.getSicName());

		}

	}

	@Test
	public void testIndustriesMiddle() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("sicCode");
		List<String> paramValues = new ArrayList<String>();

		paramValues.add("A");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/industries/middle", params.toString());

		IndustriesMiddleResult resultData = om.readValue(result, IndustriesMiddleResult.class);

		System.out.println(resultData);

		resultData.getMessage();

		List<IndustryMiddleResult> industry = resultData.getResult();

		for (IndustryMiddleResult p : industry) {

			System.out.println("code" + p.getSimcCode());

			System.out.println("Name" + p.getSimcName());

		}
	}


	@Test
	public void testIndustriesNarrow() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("simcCode");
		List<String> paramValues = new ArrayList<String>();

		paramValues.add("02");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/industries/narrow", params.toString());

		IndustriesNarrowResult resultData = om.readValue(result, IndustriesNarrowResult.class);

		System.out.println(resultData);

		resultData.getMessage();

		List<IndustryNarrowResult> industry = resultData.getResult();

		for (IndustryNarrowResult p : industry) {

			System.out.println("code" + p.getSiscCode());

			System.out.println("Name" + p.getSiscName());

		}
	}
}
