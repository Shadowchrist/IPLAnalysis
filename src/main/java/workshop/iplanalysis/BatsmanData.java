package com.workshop.iplanalysis;

import java.io.*;

import com.opencsv.bean.CsvBindByName;

public class BatsmanData implements Serializable {

	private static final long serialVersionUID = 1L;

	@CsvBindByName(column = "PLAYER", required = true)
	private String name;

	@CsvBindByName(column = "Mat", required = true)
	private int matches;

	@CsvBindByName(column = "Inns", required = true)
	private int innings;

	@CsvBindByName(column = "NO", required = true)
	private int notOuts;

	@CsvBindByName(column = "Runs", required = true)
	private int runs;

	@CsvBindByName(column = "HS", required = true)
	private String highScore;

	@CsvBindByName(column = "Avg", required = true)
	private double average;

	@CsvBindByName(column = "BF", required = true)
	private int ballsFaced;

	@CsvBindByName(column = "SR", required = true)
	private double strikeRate;

	@CsvBindByName(column = "100", required = true)
	private int hundreds;

	@CsvBindByName(column = "50", required = true)
	private int fifties;

	@CsvBindByName(column = "4s", required = true)
	private int fours;

	@CsvBindByName(column = "6s", required = true)
	private int sixes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public int getInnings() {
		return innings;
	}

	public void setInnings(int innings) {
		this.innings = innings;
	}

	public int getNotOuts() {
		return notOuts;
	}

	public void setNotOuts(int notOuts) {
		this.notOuts = notOuts;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public String getHighScore() {
		return highScore;
	}

	public void setHighScore(String highScore) {
		this.highScore = highScore;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public int getBallsFaced() {
		return ballsFaced;
	}

	public void setBallsFaced(int ballsFaced) {
		this.ballsFaced = ballsFaced;
	}

	public double getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}

	public int getHundreds() {
		return hundreds;
	}

	public void setHundreds(int hundreds) {
		this.hundreds = hundreds;
	}

	public int getFifties() {
		return fifties;
	}

	public void setFifties(int fifties) {
		this.fifties = fifties;
	}

	public int getFours() {
		return fours;
	}

	public void setFours(int fours) {
		this.fours = fours;
	}

	public int getSixes() {
		return sixes;
	}

	public void setSixes(int sixes) {
		this.sixes = sixes;
	}

	@Override
	public String toString() {
		return name;
	}
}
