package workshop.iplanalysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;
import csvutility.*;

public class GetStats<E> {
	
	public List<E> playerData=new ArrayList<E>();
	
	public GetStats(String path,Class<E> csvClass) throws CustomException
	{
		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));
			ICSVBuilder<E> csvBuilder=CSVBuilder.createCSVBuilder();
			this.playerData=csvBuilder.getCSVList(reader,csvClass);
		  } catch (IOException e) {
			throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND, "File not found!");
		}		
	}

	public int countPlayers()
	{
		return playerData.size();
	}
	
	public void displayData(List<E> list)
	{
		for(E player:list)
		{
			player.toString();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<E> sortByCriteria(List<E> list, Comparator comparator)
	{
		return (List<E>) playerData.stream().sorted(comparator).limit(5).collect(Collectors.toList());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public double[] getBestAverages() {
		Comparator comparator=Comparator.comparingDouble(IPLBatsmenAnalyzer::getAverage).reversed();
		double[] bestAverages=new double[5];
		List<IPLBatsmenAnalyzer> sortedByAverage = (List<IPLBatsmenAnalyzer>) sortByCriteria(playerData,comparator);
		int i=0;
		for(IPLBatsmenAnalyzer batsman: sortedByAverage)
		{
			bestAverages[i]=batsman.getAverage();
			i++;
		}
		return bestAverages;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public double[] getBestStrikeRates() {
		Comparator comparator=Comparator.comparingDouble(IPLBatsmenAnalyzer::getStrikeRate).reversed();
		double[] bestStrikeRates=new double[5];
		List<IPLBatsmenAnalyzer> sortedByStrikeRates = (List<IPLBatsmenAnalyzer>)sortByCriteria(playerData,comparator);
		int i=0;
		for(IPLBatsmenAnalyzer batsman: sortedByStrikeRates)
		{
			bestStrikeRates[i]=batsman.getStrikeRate();
			i++;
		}
		return bestStrikeRates;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String[] getMaximumSixesAndFours() {
		Comparator comparator=Comparator.comparingInt(IPLBatsmenAnalyzer::getSixes).thenComparingInt(IPLBatsmenAnalyzer::getFours).reversed();
		String[] maxmSixesAndFours=new String[5];
		List<IPLBatsmenAnalyzer> sortedBySRsConsideringSixesAndFours = (List<IPLBatsmenAnalyzer>)sortByCriteria(playerData,comparator);
		int i=0;
		for(IPLBatsmenAnalyzer batsman: sortedBySRsConsideringSixesAndFours)
		{
			maxmSixesAndFours[i]=batsman.getName();
			i++;
		}
		return maxmSixesAndFours;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String[] getBestStrikeRatesWithMaximumSixesAndFours() {
		Comparator comparator=Comparator.comparingDouble(IPLBatsmenAnalyzer::getStrikeRate).thenComparingInt(IPLBatsmenAnalyzer::getSixes).thenComparingInt(IPLBatsmenAnalyzer::getFours).reversed();
		String[] bestSRsWithMaxmSixesAndFours=new String[5];
		List<IPLBatsmenAnalyzer> sortedBySRsConsideringSixesAndFours = (List<IPLBatsmenAnalyzer>)sortByCriteria(playerData,comparator);
		int i=0;
		for(IPLBatsmenAnalyzer batsman: sortedBySRsConsideringSixesAndFours)
		{
			bestSRsWithMaxmSixesAndFours[i]=batsman.getName();
			i++;
		}
		return bestSRsWithMaxmSixesAndFours;
	}
}
