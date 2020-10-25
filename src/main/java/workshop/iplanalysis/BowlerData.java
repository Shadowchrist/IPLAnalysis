package com.workshop.iplanalysis;

import java.io.*;

import com.opencsv.bean.CsvBindByName;

public class BowlerData implements Serializable {
	private static final long serialVersionUID = 1L;

	@CsvBindByName(column = "PLAYER", required = true)
	private String name;

	@CsvBindByName(column = "Mat", required = true)
	private int matches;

	@CsvBindByName(column = "Inns", required = true)
	private int innings;

	@CsvBindByName(column = "Ov", required = true)
	private double overs;

	@CsvBindByName(column = "Runs", required = true)
	private int runs;

	@CsvBindByName(column = "Wkts", required = true)
	private int wickets;

	@CsvBindByName(column = "BBI", required = true)
	private double bbi;

	@CsvBindByName(column = "Avg", required = true)
	private double average;

	@CsvBindByName(column = "SR", required = true)
	private double strikeRate;

	@CsvBindByName(column = "Econ", required = true)
	private double economy;

	@CsvBindByName(column = "4w", required = true)
	private int fourWickets;

	@CsvBindByName(column = "5w", required = true)
	private int fiveWickets;

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

	public double getOvers() {
		return overs;
	}

	public void setOvers(double overs) {
		this.overs = overs;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public double getBbi() {
		return bbi;
	}

	public void setBbi(double bbi) {
		this.bbi = bbi;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}

	public double getEconomy() {
		return economy;
	}

	public void setEconomy(double economy) {
		this.economy = economy;
	}

	public int getFourWickets() {
		return fourWickets;
	}

	public void setFourWickets(int fourWickets) {
		this.fourWickets = fourWickets;
	}

	public int getFiveWickets() {
		return fiveWickets;
	}

	public void setFiveWickets(int fiveWickets) {
		this.fiveWickets = fiveWickets;
	}

	@Override
	public String toString() {
		return name;
	}
}
