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
			setPlayerData(csvBuilder.getCSVList(reader,csvClass));
		  } catch (IOException e) {
			throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND, "File not found!");
		}		
	}
	
	public List<E> getPlayerData() {
		return playerData;
	}

	public void setPlayerData(List<E> playerData) {
		this.playerData = playerData.stream().distinct().collect(Collectors.toList());
	}

	public int countPlayers()
	{
		return playerData.size();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public double[] getBestAverages() {
		Comparator comparator=Comparator.comparingDouble(IPLBatsmenAnalyzer::getAverage).reversed();
		double[] bestAverages=new double[5];
		List<IPLBatsmenAnalyzer> sortedByAverage = (List<IPLBatsmenAnalyzer>)playerData.stream().sorted(comparator).limit(5).collect(Collectors.toList());
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
		List<IPLBatsmenAnalyzer> sortedByAverage = (List<IPLBatsmenAnalyzer>)playerData.stream().sorted(comparator).limit(5).collect(Collectors.toList());
		int i=0;
		for(IPLBatsmenAnalyzer batsman: sortedByAverage)
		{
			bestStrikeRates[i]=batsman.getStrikeRate();
			i++;
		}
		return bestStrikeRates;
	}
}
