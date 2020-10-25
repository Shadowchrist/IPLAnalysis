package workshop.iplanalysis;

import static org.junit.Assert.*;

import org.junit.*;

import com.workshop.iplanalysis.GetStats;
import com.workshop.iplanalysis.BatsmanData;
import com.workshop.iplanalysis.BowlerData;

import csvutility.CustomException;

public class IPLAnalysisTest {

	String batsmenList = "C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\workshop.iplanalysis\\src\\main\\resources\\BatsmenDataList.csv";
	String bowlersList = "C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\workshop.iplanalysis\\src\\main\\resources\\BowlersDataList.csv";

	@Test
	public void ReturnNumberOfPlayer() throws CustomException {
		GetStats<BatsmanData> stats1 = new GetStats<BatsmanData>(batsmenList, BatsmanData.class);
		int result1 = stats1.countPlayers();
		assertEquals(100, result1);
		GetStats<BowlerData> stats2 = new GetStats<BowlerData>(bowlersList, BowlerData.class);
		int result2 = stats2.countPlayers();
		assertEquals(99, result2);
	}

	@Test
	public void ReturnBestBattingAverage() throws CustomException {
		GetStats<BatsmanData> batsmen = new GetStats<BatsmanData>(batsmenList, BatsmanData.class);
		double[] bestAverages = batsmen.getBestAverages();
		double[] expected = new double[] { 83.2, 69.2, 56.66, 55.62, 53.9 };
		assertArrayEquals(expected, bestAverages, 0.0);
	}

	@Test
	public void ReturnBestStrikeRates() throws CustomException {
		GetStats<BatsmanData> batsmen = new GetStats<BatsmanData>(batsmenList, BatsmanData.class);
		double[] bestStrikeRates = batsmen.getBestStrikeRates();
		double[] expected = new double[] { 333.33, 204.81, 200, 191.42, 175 };
		assertArrayEquals(expected, bestStrikeRates, 0.0);
	}

	@Test
	public void ReturnMaximumSixesAndFours() throws CustomException {
		GetStats<BatsmanData> batsmen = new GetStats<BatsmanData>(batsmenList, BatsmanData.class);
		String[] maxmSixesAndFours = batsmen.getMaximumSixesAndFours();
		String[] expected = new String[] { "Andre Russell", "Chris Gayle", "Hardik Pandya", "Rishabh Pant",
				"AB de Villiers" };
		assertArrayEquals(expected, maxmSixesAndFours);
	}
	
	@Test
	public void ReturnBestSRsWithMaximumSixesAndFours() throws CustomException {
		GetStats<BatsmanData> batsmen = new GetStats<BatsmanData>(batsmenList, BatsmanData.class);
		String[] bestSRsWithMaxmSixesAndFours = batsmen.getBestStrikeRatesWithMaximumSixesAndFours();
		String[] expected = new String[] { "David Warner ", "KL Rahul", "Quinton de Kock", "Shreyas Iyer",
				"Shikhar Dhawan" };
		assertArrayEquals(expected, bestSRsWithMaxmSixesAndFours);
	}
	
	@Test
	public void ReturnBestAveragesWithGreatSRs() throws CustomException {
		GetStats<BatsmanData> batsmen = new GetStats<BatsmanData>(batsmenList, BatsmanData.class);
		String[] getBestAveragesWithGreatSRs = batsmen.getBestAveragesWithGreatSRs();
		String[] expected = new String[] { "Suresh Raina", "Ambati Rayudu", "Shane Watson", "Hardik Pandya",
				"Rishabh Pant" };
		assertArrayEquals(expected, getBestAveragesWithGreatSRs);
	}
	
	@Test
	public void ReturnMaxmRunsWithBestAverages() throws CustomException {
		GetStats<BatsmanData> batsmen = new GetStats<BatsmanData>(batsmenList, BatsmanData.class);
		String[] getBestAveragesWithGreatSRs = batsmen.getMaxmRunsWithBestAverages();
		String[] expected = new String[] { "Shane Watson", "Suresh Raina", "Ambati Rayudu", "Quinton de Kock",
				"Shikhar Dhawan" };
		assertArrayEquals(expected, getBestAveragesWithGreatSRs);
	}	
}
