package workshop.iplanalysis;

import static org.junit.Assert.*;

import org.junit.*;

import csvutility.CustomException;

public class IPLAnalysisTest {

	String batsmenList="C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\workshop.iplanalysis\\src\\main\\resources\\BatsmenDataList.csv";
	String bowlersList="C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\workshop.iplanalysis\\src\\main\\resources\\BowlersDataList.csv";
	
	
	
	@Test
	public void ReturnNumberOfPlayer() throws CustomException {
		GetStats<IPLBatsmenAnalyzer> stats=new GetStats<IPLBatsmenAnalyzer>(batsmenList,IPLBatsmenAnalyzer.class);
		int result=stats.countPlayers();
		assertEquals(100,result);
	}
	
	@Test
	public void ReturnBestBattingAverage() throws CustomException {
		GetStats<IPLBatsmenAnalyzer> batsmen= new GetStats<IPLBatsmenAnalyzer>(batsmenList,IPLBatsmenAnalyzer.class);
		double[] bestAverages=batsmen.getBestAverages();
		double[] expected=new double[] {83.2,69.2,56.66,55.62,53.9};
		assertArrayEquals(expected,bestAverages,0.0);
	}
	
	@Test
	public void ReturnBestStrikeRates() throws CustomException {
		GetStats<IPLBatsmenAnalyzer> batsmen= new GetStats<IPLBatsmenAnalyzer>(batsmenList,IPLBatsmenAnalyzer.class);
		double[] bestStrikeRates=batsmen.getBestStrikeRates();
		double[] expected=new double[] {333.33,204.81,200,191.42,175};
		assertArrayEquals(expected,bestStrikeRates,0.0);
	}
	
	@Test
	public void ReturnMaximumSixesAndFours() throws CustomException {
		GetStats<IPLBatsmenAnalyzer> batsmen= new GetStats<IPLBatsmenAnalyzer>(batsmenList,IPLBatsmenAnalyzer.class);
		String[] maxmSixesAndFours=batsmen.getMaximumSixesAndFours();
		String[] expected=new String[] {"Andre Russell","Chris Gayle","Hardik Pandya","Rishabh Pant","AB de Villiers"};
		assertArrayEquals(expected,maxmSixesAndFours);
	}
}
