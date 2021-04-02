package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreServiceV1 {
	
	Scanner scan;
	List<Integer> scoreList;
	
	public ScoreServiceV1() {
		scan =  new Scanner(System.in);
		scoreList = new ArrayList<Integer>();
		
	}
	
	public void makescore() {
		while(true) {
			System.out.println("=".repeat(50));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("=".repeat(50));
			
			System.out.println();
		}
		
	}

}
