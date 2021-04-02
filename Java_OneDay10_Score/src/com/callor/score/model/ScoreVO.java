package com.callor.score.model;

public class ScoreVO {
	
	protected Integer Kor;
	protected Integer Eng;
	protected Integer Math;
	protected Integer Sien;
	protected Integer Hist;
	
	public Integer getKor() {
		return Kor;
	}
	public void setKor(Integer kor) {
		Kor = kor;
	}
	public Integer getEng() {
		return Eng;
	}
	public void setEng(Integer eng) {
		Eng = eng;
	}
	public Integer getMath() {
		return Math;
	}
	public void setMath(Integer math) {
		Math = math;
	}
	public Integer getSien() {
		return Sien;
	}
	public void setSien(Integer sien) {
		Sien = sien;
	}
	public Integer getHist() {
		return Hist;
	}
	public void setHist(Integer hist) {
		Hist = hist;
	}
	
	
	protected Integer Toral;
	protected Float Avg;
	
	public Integer getTotal() {
		return Toral;
	}
	public void setTotal(Integer toral) {
		Toral = toral;
	}
	public Float getAvg() {
		return Avg;
	}
	public void setAvg(Float avg) {
		Avg = avg;
	}


	protected String Name;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	

}
