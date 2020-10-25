package com.workshop.iplanalysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;
import csvutility.*;

public class GetStats {

	private List<BatsmanData> batsmenData = new ArrayList<BatsmanData>();
	private List<BowlerData> bowlersData = new ArrayList<BowlerData>();

	public GetStats() throws CustomException
	{
		this.batsmenData=GetPlayerStats("C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\workshop.iplanalysis\\src\\main\\resources\\BatsmenDataList.csv");
		this.bowlersData=GetPlayerStats("C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\workshop.iplanalysis\\src\\main\\resources\\BowlersDataList.csv");
	}
	
	public List<BatsmanData> getBatsmenData() {
		return batsmenData;
	}

	public void setBatsmenData(List<BatsmanData> batsmenData) {
		this.batsmenData = batsmenData;
	}

	public List<BowlerData> getBowlersData() {
		return bowlersData;
	}

	public void setBowlersData(List<BowlerData> bowlersData) {
		this.bowlersData = bowlersData;
	}
	
	@SuppressWarnings("unchecked")
	private <E> List<E> GetPlayerStats(String path) throws CustomException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));
			ICSVBuilder<E> csvBuilder = CSVBuilder.createCSVBuilder();
			if(path.endsWith("BatsmenDataList.csv"))
				return csvBuilder.getCSVList(reader,(Class<E>) BatsmanData.class);
			else if(path.endsWith("BowlersDataList.csv"))
				return csvBuilder.getCSVList(reader,(Class<E>) BowlerData.class);
			else 
				throw new CustomException(CustomException.ExceptionType.INCORRECT_TYPE, "Incorrect File Type!");
		} catch (IOException e) {
			throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND, "File not found!");
		}
	}

	public <E> int countPlayers(List<E> list) {
		return list.size();
	}

	public <E> void displayData(List<E> list) {
		for (E player : list) {
			player.toString();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <E> List<E> sortByCriteria(List<E> list, Comparator comparator, int limit) {
		return (List<E>) list.stream().sorted(comparator).limit(limit).collect(Collectors.toList());
	}

	public <E> String[] convertToPlayerStringArray(List<E> list) {
		String[] reqdPlayers = new String[5];
		int i = 0;
		for (E player : list) {
			if(i==5)
				break;
			reqdPlayers[i] = player.toString();
			i++;
		}
		return reqdPlayers;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <E> String[] getBestAverages() {
		Comparator comparator = Comparator.comparingDouble(BatsmanData::getAverage).reversed();
		String[] bestAverages = new String[5];
		List<BatsmanData> sortedByAverage = (List<BatsmanData>) sortByCriteria(batsmenData, comparator, 5);
		bestAverages = convertToPlayerStringArray((List<E>) sortedByAverage);
		return bestAverages;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <E> String[] getBestStrikeRates() {
		Comparator comparator = Comparator.comparingDouble(BatsmanData::getStrikeRate).reversed();
		String[] bestStrikeRates = new String[5];
		List<BatsmanData> sortedByStrikeRates = (List<BatsmanData>) sortByCriteria(batsmenData, comparator, 5);
		bestStrikeRates = convertToPlayerStringArray((List<E>) sortedByStrikeRates);
		return bestStrikeRates;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <E> String[] getMaximumSixesAndFours() {
		Comparator comparator = Comparator.comparingInt(BatsmanData::getSixes).thenComparingInt(BatsmanData::getFours)
				.reversed();

		List<BatsmanData> sortedBySRsConsideringSixesAndFours = (List<BatsmanData>) sortByCriteria(batsmenData,
				comparator, 5);
		String[] maxmSixesAndFours = new String[5];
		maxmSixesAndFours = convertToPlayerStringArray((List<E>) sortedBySRsConsideringSixesAndFours);
		return maxmSixesAndFours;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <E> String[] getBestStrikeRatesWithMaximumSixesAndFours() {
		Comparator comparator = Comparator.comparing(BatsmanData::getBallsFaced)
				.thenComparingDouble(BatsmanData::getStrikeRate).thenComparingInt(BatsmanData::getSixes)
				.thenComparingInt(BatsmanData::getFours).reversed();

		List<BatsmanData> sortedBySRsConsideringSixesAndFours = (List<BatsmanData>) sortByCriteria(batsmenData,
				comparator, 5);
		String[] bestSRsWithMaxmSixesAndFours = new String[5];
		bestSRsWithMaxmSixesAndFours = convertToPlayerStringArray((List<E>) sortedBySRsConsideringSixesAndFours);
		return bestSRsWithMaxmSixesAndFours;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <E> String[] getBestAveragesWithGreatSRs() {
		Comparator comparator = Comparator.comparing(BatsmanData::getMatches)
				.thenComparingDouble(BatsmanData::getAverage).thenComparingDouble(BatsmanData::getStrikeRate)
				.reversed();

		List<BatsmanData> sortedByAveragesWithGreatSRs = (List<BatsmanData>) sortByCriteria(batsmenData, comparator, 5);
		String[] bestAveragesWithGreatSRs = new String[5];
		bestAveragesWithGreatSRs = convertToPlayerStringArray((List<E>) sortedByAveragesWithGreatSRs);
		return bestAveragesWithGreatSRs;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <E> String[] getMaxmRunsWithBestAverages() {
		Comparator comparator = Comparator.comparing(BatsmanData::getMatches).thenComparingInt(BatsmanData::getRuns)
				.thenComparingDouble(BatsmanData::getAverage).reversed();

		List<BatsmanData> sortedByRunsWithBestAverages = (List<BatsmanData>) sortByCriteria(batsmenData, comparator, 5);
		String[] maxmRunsWithBestAverages = new String[5];
		maxmRunsWithBestAverages = convertToPlayerStringArray((List<E>) sortedByRunsWithBestAverages);
		return maxmRunsWithBestAverages;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <E> String[] getBestBowlingAverages() {
		Comparator comparator = Comparator.comparingDouble(BowlerData::getAverage);
		String[] bestAverages = new String[5];
		List<BowlerData> sortedByAverage = (List<BowlerData>) sortByCriteria(bowlersData, comparator, 5);
		bestAverages = convertToPlayerStringArray((List<E>) sortedByAverage);
		return bestAverages;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <E> String[] getBestBowlingStrikeRates() {
		Comparator comparator = Comparator.comparingDouble(BowlerData::getStrikeRate);
		String[] bestStrikeRates = new String[5];
		List<BowlerData> sortedByStrikeRates = (List<BowlerData>) sortByCriteria(bowlersData, comparator, 5);
		bestStrikeRates = convertToPlayerStringArray((List<E>) sortedByStrikeRates);
		return bestStrikeRates;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <E> String[] getBestBowlingEconomy() {
		Comparator comparator = Comparator.comparingDouble(BowlerData::getEconomy);
		String[] bestStrikeRates = new String[5];
		List<BowlerData> sortedByStrikeRates = (List<BowlerData>) sortByCriteria(bowlersData, comparator, 5);
		bestStrikeRates = convertToPlayerStringArray((List<E>) sortedByStrikeRates);
		return bestStrikeRates;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <E> String[] getBestBowlingStrikeRatesWithWickets() {
		Comparator comparator = Comparator.comparingInt(BowlerData::getFiveWickets).thenComparingInt(BowlerData::getFourWickets).reversed().thenComparingDouble(BowlerData::getStrikeRate);
		String[] bestWicketsAndStrikeRates = new String[5];
		List<BowlerData> sortedByWicketsAndStrikeRates = (List<BowlerData>) sortByCriteria(bowlersData, comparator, 5);
		bestWicketsAndStrikeRates = convertToPlayerStringArray((List<E>) sortedByWicketsAndStrikeRates);
		return bestWicketsAndStrikeRates;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <E> String[] getBestBowlingAveragesAndWickets() {
		Comparator comparator = Comparator.comparingDouble(BowlerData::getAverage).thenComparingDouble(BowlerData::getStrikeRate);
		String[] bestAveragesAndSR = new String[5];
		List<BowlerData> sortedByAverageAndSR = (List<BowlerData>) sortByCriteria(bowlersData, comparator, 5);
		bestAveragesAndSR = convertToPlayerStringArray((List<E>) sortedByAverageAndSR);
		return bestAveragesAndSR;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <E> String[] maxmWicketsWithAverage() {
		Comparator comparator = Comparator.comparingInt(BowlerData::getWickets).reversed().thenComparingDouble(BowlerData::getAverage);
		String[] bestWicketsWithAverages = new String[5];
		List<BowlerData> sortedByAverage = (List<BowlerData>) sortByCriteria(bowlersData, comparator, 5);
		bestWicketsWithAverages = convertToPlayerStringArray((List<E>) sortedByAverage);
		return bestWicketsWithAverages;
	}

	@SuppressWarnings({ "rawtypes" })
	public <E> String[] getBestBattingAndBowlingAverages() {
		String[] bestAverages = new String[5];
		Comparator batsmenCompare = Comparator.comparingDouble(BatsmanData::getAverage).reversed();
		Comparator bowlerCompare = Comparator.comparingDouble(BowlerData::getAverage);
		List<String> battingAverage = sortByCriteria(batsmenData, batsmenCompare, 100).stream().map(BatsmanData::toString).collect(Collectors.toList());
		List<String> bowlingAverage = sortByCriteria(bowlersData, bowlerCompare, 99).stream().map(BowlerData::toString).collect(Collectors.toList());
		List<String> sortedByAverage = battingAverage.stream().filter(bowlingAverage::contains).collect(Collectors.toList()); 
		bestAverages = convertToPlayerStringArray(sortedByAverage);
		return bestAverages;
	}

	@SuppressWarnings("rawtypes")
	public <E> String[] getBestAllRounders() {
		String[] bestAllRounders = new String[5];
		Comparator batsmenCompare = Comparator.comparingInt(BatsmanData::getRuns).reversed();
		Comparator bowlerCompare = Comparator.comparingInt(BowlerData::getWickets).reversed();
		List<String> battingAverage = sortByCriteria(batsmenData, batsmenCompare, 100).stream().map(BatsmanData::toString).collect(Collectors.toList());
		List<String> bowlingAverage = sortByCriteria(bowlersData, bowlerCompare, 99).stream().map(BowlerData::toString).collect(Collectors.toList());
		List<String> sortedByAverage = battingAverage.stream().filter(bowlingAverage::contains).collect(Collectors.toList()); 
		bestAllRounders = convertToPlayerStringArray(sortedByAverage);
		return bestAllRounders;
	}
}
