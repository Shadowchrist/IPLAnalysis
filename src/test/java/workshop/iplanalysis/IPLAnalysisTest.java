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
		Assert.assertArrayEquals(expected,bestAverages,0.0);
	}
	
	
}
