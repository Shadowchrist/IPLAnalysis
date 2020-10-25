package workshop.iplanalysis;

import static org.junit.Assert.*;

import org.junit.*;

import com.workshop.iplanalysis.GetStats;
import csvutility.CustomException;

public class IPLAnalysisTest {

	String batsmenList = "C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\workshop.iplanalysis\\src\\main\\resources\\BatsmenDataList.csv";
	String bowlersList = "C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\workshop.iplanalysis\\src\\main\\resources\\BowlersDataList.csv";

	@Test
	public void ReturnNumberOfPlayer() throws CustomException {
		GetStats stats = new GetStats();
		int result1 = stats.countPlayers(stats.getBatsmenData());
		assertEquals(100, result1);
		int result2 = stats.countPlayers(stats.getBowlersData());
		assertEquals(99, result2);
	}

	@Test
	public void ReturnBestBattingAverage() throws CustomException {
		GetStats batsmen = new GetStats();
		String[] bestAverages = batsmen.getBestAverages();
		String[] expected = new String[] { "MS Dhoni", "David Warner ", "Andre Russell", "Jonny Bairstow", "KL Rahul" };
		assertArrayEquals(expected, bestAverages);
	}

	@Test
	public void ReturnBestStrikeRates() throws CustomException {
		GetStats batsmen = new GetStats();
		String[] bestStrikeRates = batsmen.getBestStrikeRates();
		String[] expected = new String[] { "Ishant Sharma", "Andre Russell", "Shardul Thakur","Hardik Pandya", "Stuart Binny" };
		assertArrayEquals(expected, bestStrikeRates);
	}

	@Test
	public void ReturnMaximumSixesAndFours() throws CustomException {
		GetStats batsmen = new GetStats();
		String[] maxmSixesAndFours = batsmen.getMaximumSixesAndFours();
		String[] expected = new String[] { "Andre Russell", "Chris Gayle", "Hardik Pandya", "Rishabh Pant",
				"AB de Villiers" };
		assertArrayEquals(expected, maxmSixesAndFours);
	}
	
	@Test
	public void ReturnBestSRsWithMaximumSixesAndFours() throws CustomException {
		GetStats batsmen = new GetStats();
		String[] bestSRsWithMaxmSixesAndFours = batsmen.getBestStrikeRatesWithMaximumSixesAndFours();
		String[] expected = new String[] { "David Warner ", "KL Rahul", "Quinton de Kock", "Shreyas Iyer",
				"Shikhar Dhawan" };
		assertArrayEquals(expected, bestSRsWithMaxmSixesAndFours);
	}
	
	@Test
	public void ReturnBestAveragesWithGreatSRs() throws CustomException {
		GetStats batsmen = new GetStats();
		String[] getBestAveragesWithGreatSRs = batsmen.getBestAveragesWithGreatSRs();
		String[] expected = new String[] { "Suresh Raina", "Ambati Rayudu", "Shane Watson", "Hardik Pandya",
				"Rishabh Pant" };
		assertArrayEquals(expected, getBestAveragesWithGreatSRs);
	}
	
	@Test
	public void ReturnMaxmRunsWithBestAverages() throws CustomException {
		GetStats batsmen = new GetStats();
		String[] getBestAveragesWithGreatSRs = batsmen.getMaxmRunsWithBestAverages();
		String[] expected = new String[] { "Shane Watson", "Suresh Raina", "Ambati Rayudu", "Quinton de Kock",
				"Shikhar Dhawan" };
		assertArrayEquals(expected, getBestAveragesWithGreatSRs);
	}
	
	@Test
	public void ReturnBestBowlingAverage() throws CustomException {
		GetStats bowlers = new GetStats();
		String[] bestBowlingAverages = bowlers.getBestBowlingAverages();
		String[] expected = new String[] { "Shivam Dube", "Suresh Raina", "Yusuf Pathan", "Hanuma Vihari", "Basil Thampi" };
		assertArrayEquals(expected, bestBowlingAverages);
	}
	
	@Test
	public void ReturnBestBowlingStrikeRates() throws CustomException {
		GetStats bowlers = new GetStats();
		String[] bestStrikeRates = bowlers.getBestBowlingStrikeRates();
		String[] expected = new String[] { "Shivam Dube", "Suresh Raina", "Yusuf Pathan","Hanuma Vihari", "Basil Thampi" };
		assertArrayEquals(expected, bestStrikeRates);
	}
	
	@Test
	public void ReturnBestBowlingEconomy() throws CustomException {
		GetStats bowlers = new GetStats();
		String[] bestEconomy = bowlers.getBestBowlingEconomy();
		String[] expected = new String[] { "Shivam Dube", "Anukul Roy", "Suresh Raina","Stuart Binny", "Ravindra Jadeja" };
		assertArrayEquals(expected, bestEconomy);
	}
	
	@Test
	public void ReturnBestBowlingWicketTakersWithStrikeRates() throws CustomException {
		GetStats bowlers = new GetStats();
		String[] bestBowlers = bowlers.getBestBowlingStrikeRatesWithWickets();
		String[] expected = new String[] { "Alzarri Joseph", "Kagiso Rabada", "Imran Tahir","Lasith Malinga", "Yuzvendra Chahal" };
		assertArrayEquals(expected, bestBowlers);
	}
	
	@Test
	public void ReturnBestBowlingAveragesAndStrikeRates() throws CustomException {
		GetStats bowlers = new GetStats();
		String[] bestBowlers = bowlers.getBestBowlingAveragesAndWickets();
		String[] expected = new String[] { "Shivam Dube", "Suresh Raina", "Yusuf Pathan", "Hanuma Vihari", "Basil Thampi" };
		assertArrayEquals(expected, bestBowlers);
	}
	
	@Test
	public void ReturnMaxmWicketsWithAverage() throws CustomException {
		GetStats bowlers = new GetStats();
		String[] bestBowlingAverages = bowlers.maxmWicketsWithAverage();
		String[] expected = new String[] { "Imran Tahir", "Kagiso Rabada", "Deepak Chahar", "Shreyas Gopal", "Khaleel Ahmed" };
		assertArrayEquals(expected, bestBowlingAverages);
	}
	
	@Test
	public void ReturnBestBattingAndBowlingAverage() throws CustomException {
		GetStats players = new GetStats();
		String[] bestAverages = players.getBestBattingAndBowlingAverages();
		String[] expected = new String[] { "Andre Russell", "Marcus Stoinis", "Hardik Pandya", "Mandeep Singh", "Ravindra Jadeja" };
		assertArrayEquals(expected, bestAverages);
	}
}
