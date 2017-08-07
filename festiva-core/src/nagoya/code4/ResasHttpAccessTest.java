package nagoya.code4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.ParseException;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import nagoya.code4.resas.AgricultureDepartmentResult;
import nagoya.code4.resas.AgricultureDepartmentsResult;
import nagoya.code4.resas.CitiesResult;
import nagoya.code4.resas.CityResult;
import nagoya.code4.resas.CustomResult;
import nagoya.code4.resas.CustomsResult;
import nagoya.code4.resas.EmployEducationAcademicToTransitionChange;
import nagoya.code4.resas.EmployEducationLocalAcademicToTransitionData;
import nagoya.code4.resas.EmployEducationLocalAcademicToTransitionResult;
import nagoya.code4.resas.EmployEducationToTransitionResultChanges;
import nagoya.code4.resas.IndustriesBroadResult;
import nagoya.code4.resas.IndustriesMiddleResult;
import nagoya.code4.resas.IndustriesNarrowResult;
import nagoya.code4.resas.IndustryBroadResult;
import nagoya.code4.resas.IndustryMiddleResult;
import nagoya.code4.resas.IndustryNarrowResult;
import nagoya.code4.resas.JobBroadResult;
import nagoya.code4.resas.JobMiddleResult;
import nagoya.code4.resas.JobsBroadResult;
import nagoya.code4.resas.JobsMiddleResult;
import nagoya.code4.resas.PatentBroadResult;
import nagoya.code4.resas.PatentLocationResult;
import nagoya.code4.resas.PatentMiddleResult;
import nagoya.code4.resas.PatentsBroadResult;
import nagoya.code4.resas.PatentsLocationsResult;
import nagoya.code4.resas.PatentsMiddleResult;
import nagoya.code4.resas.PopulationCompositeResultWithBoundaryYear;
import nagoya.code4.resas.PopulationCompositionPerYearResult;
import nagoya.code4.resas.PopulationCompositionPerYearResultData;
import nagoya.code4.resas.PopulationCompositionPerYearResultDataWithLabel;
import nagoya.code4.resas.PopulationCompositionPyramidData;
import nagoya.code4.resas.PopulationCompositionPyramidResult;
import nagoya.code4.resas.PopulationCompositionPyramidSide;
import nagoya.code4.resas.PopulationCompositionPyramidSummary;
import nagoya.code4.resas.PopulationFutureCities;
import nagoya.code4.resas.PopulationFutureCitiesResult;
import nagoya.code4.resas.PopulationFutureCitiesResultCity;
import nagoya.code4.resas.PopulationSumEstimateBoundary;
import nagoya.code4.resas.PopulationSumEstimateLabel;
import nagoya.code4.resas.PopulationSumEstimateResult;
import nagoya.code4.resas.PopulationSumEstimateResultData;
import nagoya.code4.resas.PopulationSumPerYearBar;
import nagoya.code4.resas.PopulationSumPerYearLine;
import nagoya.code4.resas.PopulationSumPerYearList;
import nagoya.code4.resas.PopulationSumPerYearResult;
import nagoya.code4.resas.PopulationSumPerYearResultData;
import nagoya.code4.resas.PopulationSumPerYearResultValue;
import nagoya.code4.resas.PopulationSumValuePerYear;
import nagoya.code4.resas.PrefectureResult;
import nagoya.code4.resas.PrefecturesResult;
import nagoya.code4.resas.RegionBroadResult;
import nagoya.code4.resas.RegionMiddleResult;
import nagoya.code4.resas.RegionsBroadResult;
import nagoya.code4.resas.RegionsMiddleResult;
import nagoya.code4.resas.ResasPrefectureHttpAccess;
import nagoya.code4.resas.ResasUtil;
import nagoya.code4.resas.TradeInfoItemTypeBroadResult;
import nagoya.code4.resas.TradeInfoItemTypeMiddleResult;
import nagoya.code4.resas.TradeInfoItemTypeNarrowResult;
import nagoya.code4.resas.TradeInfoItemTypesBroadResult;
import nagoya.code4.resas.TradeInfoItemTypesMiddleResult;
import nagoya.code4.resas.TradeInfoItemTypesNarrowResult;
import nagoya.code4.resas.industry.IndustryManufactureEstablishResultData;
import nagoya.code4.resas.industry.IndustryManufactureEstablishment;
import nagoya.code4.resas.industry.IndustryManufactureEstablishmentLabel;
import nagoya.code4.resas.industry.IndustryManufactureEstablishmentsRequest;
import nagoya.code4.resas.industry.IndustryManufactureEstablishmentsResult;
import nagoya.code4.resas.industry.IndustryPowerForArea;
import nagoya.code4.resas.industry.IndustryPowerForAreaRequest;
import nagoya.code4.resas.industry.IndustryPowerForAreaResult;
import nagoya.code4.resas.industry.IndustryPowerForAreaResultCityData;
import nagoya.code4.resas.industry.IndustryPowerForAreaResultPrefectureData;
import nagoya.code4.resas.industry.IndustryPowerForIndustry;
import nagoya.code4.resas.industry.IndustryPowerForIndustryRequest;
import nagoya.code4.resas.industry.IndustryPowerForIndustryResult;
import nagoya.code4.resas.industry.IndustryPowerForIndustryResultData;
import nagoya.code4.resas.municipality.MunicipalityAbstractPerYearResult;
import nagoya.code4.resas.municipality.MunicipalityCompanyPerYearRequest;
import nagoya.code4.resas.municipality.MunicipalityCompanyPerYearResult;
import nagoya.code4.resas.municipality.MunicipalityEmployeePerYearRequest;
import nagoya.code4.resas.municipality.MunicipalityEmployeePerYearResult;
import nagoya.code4.resas.municipality.MunicipalityLaborPerYearRequest;
import nagoya.code4.resas.municipality.MunicipalityLaborPerYearResult;
import nagoya.code4.resas.municipality.MunicipalityPerYearResultData;
import nagoya.code4.resas.municipality.MunicipalityPlantYear;
import nagoya.code4.resas.municipality.MunicipalityPlantYearRequest;
import nagoya.code4.resas.municipality.MunicipalityPlantYearResult;
import nagoya.code4.resas.municipality.MunicipalityValuePerYearRequest;
import nagoya.code4.resas.municipality.MunicipalityValuePerYearResult;
import nagoya.code4.resas.population.PopulationFutureMeshChartRequest;
import nagoya.code4.resas.population.PopulationMeshChartRequest;
import nagoya.code4.resas.population.PopulationMeshChartResult;
import nagoya.code4.resas.population.PopulationMeshChartResultData;
import nagoya.code4.resas.population.PopulationMeshCharts;

public class ResasHttpAccessTest {

	// @Test
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

	@Test
	public void testJobsBroad() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("simcCode");
		List<String> paramValues = new ArrayList<String>();

		paramValues.add("02");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/jobs/broad", params.toString());

		JobsBroadResult resultData = om.readValue(result, JobsBroadResult.class);

		for (JobBroadResult job : resultData.getResult()) {
			System.out.println("code" + job.getIscoCode());

			System.out.println("Name" + job.getIscoName());

		}

	}

	@Test
	public void testJobsMiddle() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("iscoCode");
		List<String> paramValues = new ArrayList<String>();

		paramValues.add("B");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/jobs/middle", params.toString());

		JobsMiddleResult resultData = om.readValue(result, JobsMiddleResult.class);

		for (JobMiddleResult job : resultData.getResult()) {
			System.out.println("code" + job.getIscoCode());

			System.out.println("ismcoCode" + job.getIsmcoCode());

			System.out.println("ismcoName" + job.getIsmcoName());

		}

	}

	@Test
	public void testPatentsBroad() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("");
		List<String> paramValues = new ArrayList<String>();

		paramValues.add("B");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/patents/broad", params.toString());

		PatentsBroadResult resultData = om.readValue(result, PatentsBroadResult.class);

		for (PatentBroadResult p : resultData.getResult()) {
			System.out.println("tecCode" + p.getTecCode());

			System.out.println("tecName" + p.getTecName());

		}

	}

	@Test
	public void testPatentsMiddle() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("tecCode");
		List<String> paramValues = new ArrayList<String>();

		paramValues.add("F");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/patents/middle", params.toString());

		PatentsMiddleResult resultData = om.readValue(result, PatentsMiddleResult.class);

		for (PatentMiddleResult p : resultData.getResult()) {
			System.out.println("tecCode" + p.getTecCode());

			System.out.println("tecName" + p.getTecName());

			System.out.println("themeCode" + p.getThemeCode());
			System.out.println("themeName" + p.getThemeName());

		}

	}

	@Test
	public void testCustomsResult() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("prefCode");
		List<String> paramValues = new ArrayList<String>();

		paramValues.add("1");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/customs", params.toString());

		CustomsResult resultData = om.readValue(result, CustomsResult.class);

		for (CustomResult c : resultData.getResult()) {
			System.out.println("Pefcode" + c.getPrefCode());

			System.out.println("getCustomHouseCd" + c.getCustomHouseCode());

			System.out.println("getCustomHouseName" + c.getCustomHouseName());
			System.out.println("getPrefName" + c.getPrefName());

		}

	}

	@Test
	public void testRegionBroadResult() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("");
		List<String> paramValues = new ArrayList<String>();

		paramValues.add("");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/regions/broad", params.toString());

		RegionsBroadResult resultData = om.readValue(result, RegionsBroadResult.class);

		for (RegionBroadResult c : resultData.getResult()) {
			System.out.println("regionCode" + c.getRegionCode());

			System.out.println("regionName" + c.getRegionName());

		}

	}

	@Test
	public void testRegionMiddleResult() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("regionCode");
		List<String> paramValues = new ArrayList<String>();

		paramValues.add("1");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/regions/middle", params.toString());

		RegionsMiddleResult resultData = om.readValue(result, RegionsMiddleResult.class);

		for (RegionMiddleResult c : resultData.getResult()) {
			System.out.println("regionCode" + c.getRegionCode());

			System.out.println("regionName" + c.getRegionName());

			System.out.println("countryCode" + c.getCountryCode());

			System.out.println("countryName" + c.getCountryName());

			System.out.println("regionremarks" + c.getRemarks());

		}

	}

	@Test
	public void testAgricultureDepaartmentsResult() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("regionCode");
		List<String> paramValues = new ArrayList<String>();

		paramValues.add("1");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/regions/agricultureDepartments", params.toString());

		AgricultureDepartmentsResult resultData = om.readValue(result, AgricultureDepartmentsResult.class);

		for (AgricultureDepartmentResult a : resultData.getResult()) {
			System.out.println("sectionCode" + a.getSectionCode());

			System.out.println("sectionName" + a.getSectionName());

		}

	}

	@Test
	public void testPatentsLocationsResult() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("prefCode");
		paramNames.add("cityCode");
		List<String> paramValues = new ArrayList<String>();
		paramValues.add("11");
		paramValues.add("-");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/patents/locations", params.toString());

		PatentsLocationsResult resultData = om.readValue(result, PatentsLocationsResult.class);

		for (PatentLocationResult a : resultData.getResult()) {
			System.out.println("getPrefCode" + a.getPrefCode());

			System.out.println("getPrefName" + a.getPrefName());

			System.out.println("cityCode" + a.getCityCode());

			System.out.println("cityName" + a.getCityName());

			System.out.println("id" + a.getId());

			System.out.println("latitude" + a.getLatitude());

			System.out.println("longitude" + a.getLongitude());

		}

	}

	@Test
	public void testTradeItemTypesResult() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("regionCode");
		List<String> paramValues = new ArrayList<String>();

		paramValues.add("1");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/tradeInfoItemTypes/broad", params.toString());

		TradeInfoItemTypesBroadResult resultData = om.readValue(result, TradeInfoItemTypesBroadResult.class);

		for (TradeInfoItemTypeBroadResult a : resultData.getResult()) {
			System.out.println("itemCode" + a.getItemCode1());

			System.out.println("itemName" + a.getItemName1());

		}

	}

	@Test
	public void testTradeItemTypesMiddleResult() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("itemCode1");
		List<String> paramValues = new ArrayList<String>();

		paramValues.add("1");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/tradeInfoItemTypes/middle", params.toString());

		TradeInfoItemTypesMiddleResult resultData = om.readValue(result, TradeInfoItemTypesMiddleResult.class);

		for (TradeInfoItemTypeMiddleResult a : resultData.getResult()) {
			System.out.println("itemCode1" + a.getItemCode1());

			System.out.println("itemName" + a.getItemName1());

			System.out.println("itemCode2" + a.getItemCode2());

			System.out.println("itemName2" + a.getItemName2());

		}

	}

	@Test
	public void testTradeItemTypesNarrowResult() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("itemCode1");
		paramNames.add("itemCode2");

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("6");
		paramValues.add("33");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/tradeInfoItemTypes/narrow", params.toString());

		TradeInfoItemTypesNarrowResult resultData = om.readValue(result, TradeInfoItemTypesNarrowResult.class);

		for (TradeInfoItemTypeNarrowResult a : resultData.getResult()) {
			System.out.println("itemCode1" + a.getItemCode1());

			System.out.println("itemName" + a.getItemName1());

			System.out.println("itemCode2" + a.getItemCode2());

			System.out.println("itemName2" + a.getItemName2());

			System.out.println("itemCode3" + a.getItemCode3());

			System.out.println("itemName3" + a.getItemName3());

		}

	}

	@Test
	public void testPopulationComposite() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("cityCode");
		paramNames.add("prefCode");

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("11362");
		paramValues.add("11");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/population/composition/perYear", params.toString());

		PopulationCompositionPerYearResult resultData = om.readValue(result, PopulationCompositionPerYearResult.class);

		PopulationCompositeResultWithBoundaryYear a = resultData.getResult();

		System.out.println("boundaryYear" + a.getBoundaryYear());

		for (PopulationCompositionPerYearResultDataWithLabel dl : a.getData()) {

			System.out.println("label : " + dl.getLabel());

			for (PopulationCompositionPerYearResultData data : dl.getData()) {

				System.out.println("year" + data.getYear());

				System.out.println("value" + data.getValue());

			}

		}

	}

	@Test
	public void testPopulationCompositePyramid() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("cityCode");
		paramNames.add("prefCode");
		paramNames.add("yearLeft");
		paramNames.add("yearRight");

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("11362");
		paramValues.add("11");
		paramValues.add("2030");

		paramValues.add("1980");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/population/composition/pyramid", params.toString());

		PopulationCompositionPyramidResult resultData = om.readValue(result, PopulationCompositionPyramidResult.class);

		PopulationCompositionPyramidSide side = resultData.getResult();

		PopulationCompositionPyramidSummary s = side.getYearLeft();

		printSide(s);

		s = side.getYearRight();

		printSide(s);

	}

	private void printSide(PopulationCompositionPyramidSummary s) {
		System.out.println("Year" + s.getYear());
		System.out.println("oldage count" + s.getOldAgeCount());
		System.out.println("oldage parcent" + s.getOldAgePercent());
		System.out.println("mid count" + s.getMiddleAgeCount());
		System.out.println("mid count p" + s.getMiddleAgePercent());
		System.out.println("Year" + s.getYear());
		System.out.println("Year" + s.getYear());

		for (PopulationCompositionPyramidData dl : s.getData()) {

			System.out.println("class : " + dl.getClassname());
			System.out.println("man" + dl.getMan());

			System.out.println("manParcent" + dl.getManPercent());

			System.out.println("woman " + dl.getWoman());

			System.out.println("womanParcent " + dl.getWomanPercent());

		}

	}

	@Test
	public void testPopulationSum() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("cityCode");
		paramNames.add("prefCode");

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("11362");
		paramValues.add("11");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/population/sum/perYear", params.toString());

		PopulationSumPerYearResult resultData = om.readValue(result, PopulationSumPerYearResult.class);

		PopulationSumPerYearResultValue a = resultData.getResult();

		PopulationSumPerYearLine line = a.getLine();

		for (PopulationSumValuePerYear data : line.getData()) {

			System.out.println("year" + data.getYear());

			System.out.println("value" + data.getValue());

		}

		PopulationSumPerYearBar bar = a.getBar();

		for (PopulationSumPerYearList data : bar.getData()) {

			System.out.println("year" + data.getYear());

			System.out.println("sum" + data.getSum());

			for (PopulationSumPerYearResultData d : data.getData()) {

				System.out.println("label : " + d.getLabel());
				System.out.println("value : " + d.getValue());

			}

		}

	}

	@Test
	public void testEducationResult() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("prefecture_cd");
		paramNames.add("displayMethod");
		paramNames.add("matter");
		paramNames.add("classification");
		paramNames.add("displayType");
		paramNames.add("gender");

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("13");
		paramValues.add("0");
		paramValues.add("1");
		paramValues.add("0");
		paramValues.add("00");
		paramValues.add("0");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/employEducation/localjobAcademic/toTransition",
				params.toString());

		EmployEducationLocalAcademicToTransitionResult resultData = om.readValue(result,
				EmployEducationLocalAcademicToTransitionResult.class);

		EmployEducationToTransitionResultChanges a = resultData.getResult();

		for (EmployEducationAcademicToTransitionChange data : a.getData()) {

			System.out.println("label" + data.getLabel());

			System.out.println("preCode" + data.getPrefCode());

			for (EmployEducationLocalAcademicToTransitionData tran : data.getData()) {

				System.out.println("year" + tran.getYear());

				System.out.println("value" + tran.getValue());

			}
		}

	}

	@Test
	public void testPopulationEstimate() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("prefCode");
		paramNames.add("cityCode");

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("11");
		paramValues.add("11362");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/population/sum/estimate", params.toString());

		PopulationSumEstimateResult resultData = om.readValue(result, PopulationSumEstimateResult.class);

		PopulationSumEstimateBoundary a = resultData.getResult();

		for (PopulationSumEstimateLabel data : a.getData()) {

			System.out.println("label" + data.getLabel());

			for (PopulationSumEstimateResultData tran : data.getData()) {

				System.out.println("year" + tran.getYear());

				System.out.println("value" + tran.getValue());

			}
		}

	}

	@Test
	public void testPopulationFutureCities() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("year");
		paramNames.add("prefCode");

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("2040");
		paramValues.add("1");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1/population/future/cities", params.toString());

		PopulationFutureCitiesResult resultData = om.readValue(result, PopulationFutureCitiesResult.class);

		PopulationFutureCities a = resultData.getResult();

		for (PopulationFutureCitiesResultCity data : a.getData()) {

			System.out.println("citycode" + data.getCityCode());

			System.out.println("cityname" + data.getCityName());

			System.out.println("value" + data.getValue());

			System.out.println("RATIO" + data.getRatio());

		}
	}

	@Test
	public void testPopulationMeshChart() throws ParseException, IOException {
		requestPopulationMesh(PopulationMeshChartRequest.url);
	}

	private void requestPopulationMesh(String url) throws IOException, JsonParseException, JsonMappingException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("year");
		paramNames.add("prefecture_cd");
		paramNames.add("city_cd");
		paramNames.add("matter");
		paramNames.add("displayMethod");

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("2010");
		paramValues.add("13");
		paramValues.add("13101");
		paramValues.add("0");
		paramValues.add("0");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1" + url, params.toString());

		PopulationMeshChartResult resultData = om.readValue(result, PopulationMeshChartResult.class);

		PopulationMeshCharts a = resultData.getResult();

		for (PopulationMeshChartResultData data : a.getData()) {

			System.out.println("citycode" + data.getClassification_cd());

			System.out.println("cityname" + data.getClassification_name());

			System.out.println("value1" + data.getValue1());
			System.out.println("value2" + data.getValue2());

			System.out.println("value3" + data.getValue3());

		}
	}

	@Test
	public void testPopulationFutureMeshChart() throws ParseException, IOException {
		requestPopulationMesh(PopulationFutureMeshChartRequest.url);
	}

	@Test
	public void testIndustryPowerForIndustry() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("year");
		paramNames.add("prefCode");
		paramNames.add("cityCode");
		paramNames.add("sicCode");

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("2012");
		paramValues.add("11");
		paramValues.add("11362");
		paramValues.add("-");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1" + IndustryPowerForIndustryRequest.url, params.toString());

		IndustryPowerForIndustryResult resultData = om.readValue(result, IndustryPowerForIndustryResult.class);

		IndustryPowerForIndustry a = resultData.getResult();

		for (IndustryPowerForIndustryResultData data : a.getData()) {

			System.out.println("employee" + data.getEmployee());

			System.out.println("labor" + data.getLabor());

			System.out.println("simCode" + data.getSimcCode());

			System.out.println("simcName" + data.getSimcName());

			System.out.println("value" + data.getValue());

		}
	}

	@Test
	public void testIndustryPowerForArea() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("year");
		paramNames.add("prefCode");
		paramNames.add("areaType");
		paramNames.add("dispType");
		paramNames.add("sicCode");
		paramNames.add("simcCode");

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("2012");
		paramValues.add("11");
		paramValues.add("1");
		paramValues.add("1");
		paramValues.add("E");
		paramValues.add("20");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1" + IndustryPowerForAreaRequest.url, params.toString());

		IndustryPowerForAreaResult resultData = om.readValue(result, IndustryPowerForAreaResult.class);

		IndustryPowerForArea a = resultData.getResult();

		for (IndustryPowerForAreaResultPrefectureData data : a.getPrefectures()) {

			System.out.println("employee" + data.getPrefCode());

			System.out.println("labor" + data.getPrefName());

			System.out.println("simCode" + data.getValue());

		}

		for (IndustryPowerForAreaResultCityData data : a.getCities()) {

			System.out.println("employee" + data.getPrefCode());

			System.out.println("labor" + data.getPrefName());

			System.out.println("simCode" + data.getCityCode());

			System.out.println("simCode" + data.getCityName());

			System.out.println("simCode" + data.getValue());

		}
	}

	@Test
	public void testIndustryPowerForEstablishment() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("prefCode");
		paramNames.add("sicCode");
		paramNames.add("simcCode");
		paramNames.add("addArea");

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("11");
		paramValues.add("E");
		paramValues.add("20");
		paramValues.add("");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1" + IndustryManufactureEstablishmentsRequest.url,
				params.toString());

		IndustryManufactureEstablishmentsResult resultData = om.readValue(result,
				IndustryManufactureEstablishmentsResult.class);

		IndustryManufactureEstablishment a = resultData.getResult();

		for (IndustryManufactureEstablishmentLabel data : a.getEstablishments()) {

			System.out.println("employee" + data.getLabel());

			for (IndustryManufactureEstablishResultData d : data.getData()) {

				System.out.println("employee" + d.getEmployee());

				System.out.println("labor" + d.getLabor());

				System.out.println("value" + d.getValue());

				System.out.println("year" + d.getYear());
			}

		}
	}

	@Test
	public void testMunicipalityCompanyPerYear() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("cityCode");
		paramNames.add("simcCode");
		paramNames.add("prefCode");
		paramNames.add("sicCode");

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("11362");
		paramValues.add("20");
		paramValues.add("11");
		paramValues.add("E");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1" + MunicipalityCompanyPerYearRequest.url, params.toString());

		MunicipalityCompanyPerYearResult resultData = om.readValue(result, MunicipalityCompanyPerYearResult.class);

		MunicipalityAbstractPerYearResult a = resultData.getResult();

		System.out.println("prefCode" + a.getPrefCode());

		System.out.println("prefName" + a.getPrefName());
		System.out.println("cityName" + a.getCityName());
		System.out.println("sicName" + a.getSicName());
		System.out.println("sicCode" + a.getSicCode());
		System.out.println("simcName" + a.getSimcName());
		System.out.println("simcCode" + a.getSimcCode());

		
		
		for (MunicipalityPerYearResultData data : a.getData()) {

			System.out.println("value" + data.getValue());
			
			System.out.println("year : " + data.getYear());



		}
	}
	

	@Test
	public void testMunicipalityPlantPerYear() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("cityCode");
		paramNames.add("simcCode");
		paramNames.add("prefCode");
		paramNames.add("sicCode");

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("11362");
		paramValues.add("20");
		paramValues.add("11");
		paramValues.add("E");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1" + MunicipalityPlantYearRequest.url, params.toString());

		MunicipalityPlantYearResult resultData = om.readValue(result, MunicipalityPlantYearResult.class);

		MunicipalityPlantYear a = resultData.getResult();

		System.out.println("prefCode" + a.getPrefCode());

		System.out.println("prefName" + a.getPrefName());
		System.out.println("cityName" + a.getCityName());
		System.out.println("sicName" + a.getSicName());
		System.out.println("sicCode" + a.getSicCode());
		System.out.println("simcName" + a.getSimcName());
		System.out.println("simcCode" + a.getSimcCode());

		
		
		for (MunicipalityPerYearResultData data : a.getData()) {

			System.out.println("value" + data.getValue());
			
			System.out.println("year : " + data.getYear());

		}
	}
	
	@Test
	public void testMunicipalityEmployeePerYear() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("cityCode");
		paramNames.add("simcCode");
		paramNames.add("prefCode");
		paramNames.add("sicCode");

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("11362");
		paramValues.add("20");
		paramValues.add("11");
		paramValues.add("E");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1" + MunicipalityEmployeePerYearRequest.url, params.toString());

		MunicipalityEmployeePerYearResult resultData = om.readValue(result, MunicipalityEmployeePerYearResult.class);

		MunicipalityPlantYear a = resultData.getResult();

		System.out.println("prefCode" + a.getPrefCode());

		System.out.println("prefName" + a.getPrefName());
		System.out.println("cityName" + a.getCityName());
		System.out.println("sicName" + a.getSicName());
		System.out.println("sicCode" + a.getSicCode());
		System.out.println("simcName" + a.getSimcName());
		System.out.println("simcCode" + a.getSimcCode());

		
		
		for (MunicipalityPerYearResultData data : a.getData()) {

			System.out.println("value" + data.getValue());
			
			System.out.println("year : " + data.getYear());

		}
	}
	

	@Test
	public void testMunicipalityValuePerYear() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("cityCode");
		paramNames.add("simcCode");
		paramNames.add("prefCode");
		paramNames.add("sicCode");
		paramNames.add("year");
		

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("13101");
		paramValues.add("51");
		paramValues.add("13");
		paramValues.add("I");
		paramValues.add("2012");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1" + MunicipalityValuePerYearRequest.url, params.toString());


		System.out.println(result);
		MunicipalityValuePerYearResult resultData = om.readValue(result, MunicipalityValuePerYearResult.class);

		MunicipalityPlantYear a = resultData.getResult();

		System.out.println("prefCode" + a.getPrefCode());

		System.out.println("prefName" + a.getPrefName());
		System.out.println("cityName" + a.getCityName());
		System.out.println("sicName" + a.getSicName());
		System.out.println("sicCode" + a.getSicCode());
		System.out.println("simcName" + a.getSimcName());
		System.out.println("simcCode" + a.getSimcCode());

		
		
		for (MunicipalityPerYearResultData data : a.getData()) {

			System.out.println("value" + data.getValue());
			
			System.out.println("year : " + data.getYear());
			

			System.out.println("concealmentflg : " + data.getConcealmentFlg());

		}
	}
	

	@Test
	public void testMunicipalityLaborPerYear() throws ParseException, IOException {
		ObjectMapper om = new ObjectMapper();

		List<String> paramNames = new ArrayList<String>();
		paramNames.add("cityCode");
		paramNames.add("simcCode");
		paramNames.add("prefCode");
		paramNames.add("sicCode");
		paramNames.add("year");
		

		List<String> paramValues = new ArrayList<String>();

		paramValues.add("13101");
		paramValues.add("51");
		paramValues.add("13");
		paramValues.add("I");
		paramValues.add("2012");

		StringBuffer params = ResasUtil.addParameters(paramNames, paramValues);

		String result = ResasHttpAccess.sendString("api/v1" + MunicipalityLaborPerYearRequest.url, params.toString());


		System.out.println(result);
		MunicipalityLaborPerYearResult resultData = om.readValue(result, MunicipalityLaborPerYearResult.class);

		MunicipalityPlantYear a = resultData.getResult();

		System.out.println("prefCode" + a.getPrefCode());

		System.out.println("prefName" + a.getPrefName());
		System.out.println("cityName" + a.getCityName());
		System.out.println("sicName" + a.getSicName());
		System.out.println("sicCode" + a.getSicCode());
		System.out.println("simcName" + a.getSimcName());
		System.out.println("simcCode" + a.getSimcCode());

		
		
		for (MunicipalityPerYearResultData data : a.getData()) {

			System.out.println("value" + data.getValue());
			
			System.out.println("year : " + data.getYear());
			

			System.out.println("concealmentflg : " + data.getConcealmentFlg());

		}
	}
}
