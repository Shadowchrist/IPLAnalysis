package com.workshop.iplanalysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;
import csvutility.*;

public class GetStats<E> {

	public List<E> playerData = new ArrayList<E>();

	public GetStats(String path, Class<E> csvClass) throws CustomException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));
			ICSVBuilder<E> csvBuilder = CSVBuilder.createCSVBuilder();
			this.playerData = csvBuilder.getCSVList(reader, csvClass);
		} catch (IOException e) {
			throw new CustomException(CustomException.ExceptionType.FILE_NOT_FOUND, "File not found!");
		}
	}

	public int countPlayers() {
		return playerData.size();
	}

	public void displayData(List<E> list) {
		for (E player : list) {
			player.toString();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<E> sortByCriteria(List<E> list, Comparator comparator) {
		return (List<E>) playerData.stream().sorted(comparator).limit(5).collect(Collectors.toList());
	}

	public String[] convertToBatsmenStringArray(List<E> list) {
		String[] reqdPlayers = new String[5];
		int i = 0;
		for (E player : list) {
			reqdPlayers[i] = player.toString();
			i++;
		}
		return reqdPlayers;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public double[] getBestAverages() {
		Comparator comparator = Comparator.comparingDouble(BatsmanData::getAverage).reversed();
		double[] bestAverages = new double[5];
		List<BatsmanData> sortedByAverage = (List<BatsmanData>) sortByCriteria(playerData, comparator);
		int i = 0;
		for (BatsmanData batsman : sortedByAverage) {
			bestAverages[i] = batsman.getAverage();
			i++;
		}
		return bestAverages;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public double[] getBestStrikeRates() {
		Comparator comparator = Comparator.comparingDouble(BatsmanData::getStrikeRate).reversed();
		double[] bestStrikeRates = new double[5];
		List<BatsmanData> sortedByStrikeRates = (List<BatsmanData>) sortByCriteria(playerData, comparator);
		int i = 0;
		for (BatsmanData batsman : sortedByStrikeRates) {
			bestStrikeRates[i] = batsman.getStrikeRate();
			i++;
		}
		return bestStrikeRates;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String[] getMaximumSixesAndFours() {
		Comparator comparator = Comparator.comparingInt(BatsmanData::getSixes).thenComparingInt(BatsmanData::getFours)
				.reversed();

		List<BatsmanData> sortedBySRsConsideringSixesAndFours = (List<BatsmanData>) sortByCriteria(playerData,
				comparator);
		String[] maxmSixesAndFours = new String[5];
		maxmSixesAndFours = convertToBatsmenStringArray((List<E>) sortedBySRsConsideringSixesAndFours);
		return maxmSixesAndFours;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String[] getBestStrikeRatesWithMaximumSixesAndFours() {
		Comparator comparator = Comparator.comparing(BatsmanData::getBallsFaced)
				.thenComparingDouble(BatsmanData::getStrikeRate).thenComparingInt(BatsmanData::getSixes)
				.thenComparingInt(BatsmanData::getFours).reversed();

		List<BatsmanData> sortedBySRsConsideringSixesAndFours = (List<BatsmanData>) sortByCriteria(playerData,
				comparator);
		String[] bestSRsWithMaxmSixesAndFours = new String[5];
		bestSRsWithMaxmSixesAndFours = convertToBatsmenStringArray((List<E>) sortedBySRsConsideringSixesAndFours);
		return bestSRsWithMaxmSixesAndFours;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String[] getBestAveragesWithGreatSRs() {
		Comparator comparator = Comparator.comparing(BatsmanData::getMatches)
				.thenComparingDouble(BatsmanData::getAverage).thenComparingDouble(BatsmanData::getStrikeRate)
				.reversed();

		List<BatsmanData> sortedByAveragesWithGreatSRs = (List<BatsmanData>) sortByCriteria(playerData, comparator);
		String[] bestAveragesWithGreatSRs = new String[5];
		bestAveragesWithGreatSRs = convertToBatsmenStringArray((List<E>) sortedByAveragesWithGreatSRs);
		return bestAveragesWithGreatSRs;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String[] getMaxmRunsWithBestAverages() {
		Comparator comparator = Comparator.comparing(BatsmanData::getMatches).thenComparingInt(BatsmanData::getRuns)
				.thenComparingDouble(BatsmanData::getAverage).reversed();

		List<BatsmanData> sortedByRunsWithBestAverages = (List<BatsmanData>) sortByCriteria(playerData, comparator);
		String[] maxmRunsWithBestAverages = new String[5];
		maxmRunsWithBestAverages = convertToBatsmenStringArray((List<E>) sortedByRunsWithBestAverages);
		return maxmRunsWithBestAverages;
	}
}
